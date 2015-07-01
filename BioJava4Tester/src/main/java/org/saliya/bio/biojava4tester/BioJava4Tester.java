package org.saliya.bio.biojava4tester;

import org.biojava.nbio.alignment.Alignments;
import org.biojava.nbio.alignment.SimpleGapPenalty;
import org.biojava.nbio.alignment.SimpleSubstitutionMatrix;
import org.biojava.nbio.alignment.SubstitutionMatrixHelper;
import org.biojava.nbio.alignment.template.SequencePair;
import org.biojava.nbio.alignment.template.SubstitutionMatrix;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;

import java.io.InputStreamReader;

public class BioJava4Tester {
    public static void main(String[] args) throws CompoundNotFoundException {
        simpleTwoSequenceTest();
    }
    public static void simpleTwoSequenceTest() throws CompoundNotFoundException {
        String targetSeq = "CACGTTTCTTGTGGCAGCTTAAGTTTGAATGTCATTTCTTCAATGGGACGGA"+
                "GCGGGTGCGGTTGCTGGAAAGATGCATCTATAACCAAGAGGAGTCCGTGCGCTTCGACAGC"+
                "GACGTGGGGGAGTACCGGGCGGTGACGGAGCTGGGGCGGCCTGATGCCGAGTACTGGAACA"+
                "GCCAGAAGGACCTCCTGGAGCAGAGGCGGGCCGCGGTGGACACCTACTGCAGACACAACTA"+
                "CGGGGTTGGTGAGAGCTTCACAGTGCAGCGGCGAG";
        DNASequence target = new DNASequence(targetSeq,
                                             AmbiguityDNACompoundSet.getDNACompoundSet());

        String querySeq = "ACGAGTGCGTGTTTTCCCGCCTGGTCCCCAGGCCCCCTTTCCGTCCTCAGGAA"+
                "GACAGAGGAGGAGCCCCTCGGGCTGCAGGTGGTGGGCGTTGCGGCGGCGGCCGGTTAAGGT"+
                "TCCCAGTGCCCGCACCCGGCCCACGGGAGCCCCGGACTGGCGGCGTCACTGTCAGTGTCTT"+
                "CTCAGGAGGCCGCCTGTGTGACTGGATCGTTCGTGTCCCCACAGCACGTTTCTTGGAGTAC"+
                "TCTACGTCTGAGTGTCATTTCTTCAATGGGACGGAGCGGGTGCGGTTCCTGGACAGATACT"+
                "TCCATAACCAGGAGGAGAACGTGCGCTTCGACAGCGACGTGGGGGAGTTCCGGGCGGTGAC"+
                "GGAGCTGGGGCGGCCTGATGCCGAGTACTGGAACAGCCAGAAGGACATCCTGGAAGACGAG"+
                "CGGGCCGCGGTGGACACCTACTGCAGACACAACTACGGGGTTGTGAGAGCTTCACCGTGCA"+
                "GCGGCGAGACGCACTCGT";
        DNASequence query = new DNASequence(querySeq,
                                            AmbiguityDNACompoundSet.getDNACompoundSet());

        SubstitutionMatrix<NucleotideCompound> matrix = getNucleotideMatrix("EDNAFULL");

        SimpleGapPenalty gapP = new SimpleGapPenalty();
        gapP.setOpenPenalty((short)16);
        gapP.setExtensionPenalty((short)4);

        SequencePair<DNASequence, NucleotideCompound> psa =
                Alignments.getPairwiseAlignment(query, target, Alignments.PairwiseSequenceAlignerType.LOCAL, gapP, matrix);

        System.out.println(psa);
    }

    private static SubstitutionMatrix<NucleotideCompound> getNucleotideMatrix(String file) {
        return new SimpleSubstitutionMatrix(AmbiguityDNACompoundSet.getDNACompoundSet(), getReader(file), file);
    }

    private static InputStreamReader getReader(String file) {
        return new InputStreamReader(SubstitutionMatrixHelper.class.getResourceAsStream(String.format("/%s.txt", new Object[]{file})));
    }
}
