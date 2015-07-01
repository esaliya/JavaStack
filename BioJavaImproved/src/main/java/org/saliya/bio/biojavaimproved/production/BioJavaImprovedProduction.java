package org.saliya.bio.biojavaimproved.production;

import com.google.common.base.Stopwatch;
import edu.indiana.salsahpc.Alphabet;
import edu.indiana.salsahpc.Sequence;
import edu.indiana.salsahpc.SequenceParser;
import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.SimpleSubstitutionMatrix;
import org.biojava3.alignment.SubstitutionMatrixHelper;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava3.core.sequence.compound.NucleotideCompound;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BioJavaImprovedProduction {
    public static void main(String[] args) throws IOException {
        int n = 10;
        String file = "data/200_fasta.txt";

        SubstitutionMatrix<NucleotideCompound> matrix = getNucleotideMatrix("EDNAFULL");

        SimpleGapPenalty gapP = new SimpleGapPenalty();
        gapP.setOpenPenalty((short)16);
        gapP.setExtensionPenalty((short)4);

        List<Sequence> mbfseqs = SequenceParser.parse(file, Alphabet.DNA);
        List<DNASequence> seqs = new ArrayList<>(mbfseqs.size());
        for (int i = 0; i < mbfseqs.size(); i++) {
            Sequence sequence = mbfseqs.get(i);
            seqs.add(new DNASequence(sequence.toString(), AmbiguityDNACompoundSet.getDNACompoundSet()));
        }

        int [][] identicalsArray = new int[n][n];
        Stopwatch timer = Stopwatch.createStarted();
        for (int i = 0; i < n; ++i){
            DNASequence si = seqs.get(i);
            for (int j = 0; j < n; ++j){
                DNASequence sj = seqs.get(j);
                SequencePair<DNASequence, NucleotideCompound> psa =
                        Alignments
                                .getPairwiseAlignment(si, sj, Alignments.PairwiseSequenceAlignerType.LOCAL, gapP,
                                                      matrix);
                identicalsArray[i][j] = psa.getNumIdenticals();
            }
        }
        timer.stop();
        System.out.println("Aligned " + n  + "sequences in " + timer.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }

    private static SubstitutionMatrix<NucleotideCompound> getNucleotideMatrix(String file) {
        return new SimpleSubstitutionMatrix(AmbiguityDNACompoundSet.getDNACompoundSet(), getReader(file), file);
    }

    private static InputStreamReader getReader(String file) {
        return new InputStreamReader(SubstitutionMatrixHelper.class.getResourceAsStream(String.format("/%s", new Object[]{file})));
    }
}
