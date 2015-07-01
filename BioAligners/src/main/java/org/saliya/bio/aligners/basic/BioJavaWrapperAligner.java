package org.saliya.bio.aligners.basic;

import edu.indiana.salsahpc.AlignmentData;
import edu.indiana.salsahpc.BioJavaWrapper;
import edu.indiana.salsahpc.DistanceType;
import edu.indiana.salsahpc.MatrixUtil;
import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.template.GapPenalty;
import org.biojava3.alignment.template.PairwiseSequenceAligner;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.compound.AminoAcidCompound;
import org.biojava3.core.sequence.compound.NucleotideCompound;

public class BioJavaWrapperAligner {

    // Don't understand what's wrong with the BioJava library we've been using !
/*
    public static void main(String[] args) {
        simpleTwoSequenceTest();
    }

    public static void simpleTwoSequenceTest(){
        */
/*DNASequence s1 = new DNASequence("GTAGTCATATGCTTGTCTCAAAGATTAAGCCATGCATGTCTAGTATAATCGTTATACAGGTGAAACTGCGAATGGCTCAT");
        DNASequence s2 = new DNASequence("CGTCCCTGCCCTTTGTACACACCGCCCGTCGCTACTACCGATTGAATGGCTTAGTGAGGCCTTCGGATTGAGGTTTGGAG");*//*


        ProteinSequence s1 = new ProteinSequence("MKKISLTTMILLA");
        ProteinSequence s2 = new ProteinSequence("MASETTEKI");

//        SubstitutionMatrix<NucleotideCompound> matrix = MatrixUtil.getEDNAFULL();
        SubstitutionMatrix<AminoAcidCompound> matrix = MatrixUtil.getBlosum62();

        short gapOpen = 16;
        short gapExt = 4;

        GapPenalty penalty = new SimpleGapPenalty(gapOpen, gapExt);
        SequencePair<ProteinSequence,AminoAcidCompound> pair =
                Alignments.getPairwiseAlignment(s1, s2, Alignments.PairwiseSequenceAlignerType.LOCAL, penalty, matrix);
        System.out.println(pair.getAlignedSequence(s1));
        System.out.println();
        System.out.println(pair.getAlignedSequence(s2));
        System.out.println();

        */
/*AlignmentData ad = BioJavaWrapper.calculateAlignment(s1, s2, gapOpen, gapExt, matrix, DistanceType.PercentIdentity);
        System.out.println("Alignment;");
        System.out.println("  " + ad.getPair().getQuery());
        System.out.println("  " + ad.getPair().getTarget());
        System.out.println("Score: " + ad.getScore());
        System.out.println("PID Distance: " + ad.getDistance()*1.0/Short.MAX_VALUE);*//*


    }
*/
}
