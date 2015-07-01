package org.saliya.bio.aligners.performance;

import com.google.common.base.Stopwatch;
import edu.indiana.salsahpc.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MBF2JavaProduction {
    public static void main(String[] args) throws Exception {
        int n = 20;
        String file = "data/200_fasta.txt";
        int go = -16;
        int ge = -4;

        List<Sequence> seqs = SequenceParser.parse(file, Alphabet.DNA);
        SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
        SmithWatermanAligner aligner = new SmithWatermanAligner();
        short [][] scoreArray = new short[n][n];
        Stopwatch timer = Stopwatch.createStarted();
        for (int i = 0; i < n; ++i){
            Sequence si = seqs.get(i);
            for (int j = 0; j < n; ++j){
                Sequence sj = seqs.get(j);
                List<AlignedData> alignments = aligner.align(matrix,  go, ge, si, sj);
                AlignedData ad = alignments.get(0);
                scoreArray[i][j] = ad.getScore();
            }
        }
        timer.stop();
        System.out.println("Aligned " + n  + "sequences in " + timer.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}
