package org.saliya.bio.aligners.basic;

import edu.indiana.salsahpc.*;

import java.io.IOException;
import java.util.List;

public class MBF2JavaAligner {
    public static void main(String[] args) throws Exception {
        simpleTwoSequenceTest();
    }

    public static void simpleTwoSequenceTest() throws Exception {
        /*Sequence s1 = new Sequence("GTAGTCATATGCTTGTCTCAAAGATTAAGCCATGCATGTCTAGTATAATCGTTATACAGGTGAAACTGCGAATGGCTCAT",
                                   Alphabet.DNA);

        Sequence s2 = new Sequence("CGTCCCTGCCCTTTGTACACACCGCCCGTCGCTACTACCGATTGAATGGCTTAGTGAGGCCTTCGGATTGAGGTTTGGAG",
                                   Alphabet.DNA);*/

        Sequence s1 = new Sequence("CACGTTTCTTGTGGCAGCTTAAGTTTGAATGTCATTTCTTCAATGGGACGGA"+
                                           "GCGGGTGCGGTTGCTGGAAAGATGCATCTATAACCAAGAGGAGTCCGTGCGCTTCGACAGC"+
                                           "GACGTGGGGGAGTACCGGGCGGTGACGGAGCTGGGGCGGCCTGATGCCGAGTACTGGAACA"+
                                           "GCCAGAAGGACCTCCTGGAGCAGAGGCGGGCCGCGGTGGACACCTACTGCAGACACAACTA"+
                                           "CGGGGTTGGTGAGAGCTTCACAGTGCAGCGGCGAG",
                                   Alphabet.DNA);

        Sequence s2 = new Sequence("ACGAGTGCGTGTTTTCCCGCCTGGTCCCCAGGCCCCCTTTCCGTCCTCAGGAA"+
                                           "GACAGAGGAGGAGCCCCTCGGGCTGCAGGTGGTGGGCGTTGCGGCGGCGGCCGGTTAAGGT"+
                                           "TCCCAGTGCCCGCACCCGGCCCACGGGAGCCCCGGACTGGCGGCGTCACTGTCAGTGTCTT"+
                                           "CTCAGGAGGCCGCCTGTGTGACTGGATCGTTCGTGTCCCCACAGCACGTTTCTTGGAGTAC"+
                                           "TCTACGTCTGAGTGTCATTTCTTCAATGGGACGGAGCGGGTGCGGTTCCTGGACAGATACT"+
                                           "TCCATAACCAGGAGGAGAACGTGCGCTTCGACAGCGACGTGGGGGAGTTCCGGGCGGTGAC"+
                                           "GGAGCTGGGGCGGCCTGATGCCGAGTACTGGAACAGCCAGAAGGACATCCTGGAAGACGAG"+
                                           "CGGGCCGCGGTGGACACCTACTGCAGACACAACTACGGGGTTGTGAGAGCTTCACCGTGCA"+
                                           "GCGGCGAGACGCACTCGT",
                                   Alphabet.DNA);

        int go = -16;
        int ge = -4;

        SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
        SmithWatermanAligner aligner = new SmithWatermanAligner();
        List<AlignedData> alignments = aligner.align(matrix,  go, ge, s1, s2);
        AlignedData ad = alignments.get(0);
        System.out.println("Alignment;");
        System.out.println("  " + ad.getFirstAlignedSequence());
        System.out.println("  " + ad.getSecondAlignedSequence());
        System.out.println("Score: " + ad.getScore());
        System.out.println("PID Distance: " + DistanceUtil.computePercentIdentityDistance(ad));
    }
}
