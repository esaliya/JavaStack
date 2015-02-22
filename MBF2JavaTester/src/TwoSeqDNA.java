import edu.indiana.salsahpc.*;

import java.io.IOException;
import java.util.List;

public class TwoSeqDNA {
    public static void main(String[] args) throws Exception {
        Sequence s1 = new Sequence("GTAGTCATATGCTTGTCTCAAAGATTAAGCCATGCATGTCTAGTATAATCGTTATACAGGTGAAACTGCGAATGGCTCAT",
                Alphabet.DNA);

        Sequence s2 = new Sequence("CGTCCCTGCCCTTTGTACACACCGCCCGTCGCTACTACCGATTGAATGGCTTAGTGAGGCCTTCGGATTGAGGTTTGGAG",
                Alphabet.DNA);

        int go = -16;
        int ge = -4;

//        SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
        SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
        SmithWatermanAligner aligner = new SmithWatermanAligner();
        List<AlignedData> alignments = aligner.align(matrix,  go, ge, s1, s2);
        AlignedData ad = alignments.get(0);
        System.out.println(ad.getScore());
        System.out.println(DistanceUtil.computeMinMaxNormScoreDistance(ad, matrix, go, ge));
    }
}
