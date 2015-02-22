import edu.indiana.salsahpc.*;

import java.io.IOException;
import java.util.List;

public class TwoSeqSWGTester {
    public static void main(String[] args) throws Exception {
        Sequence s1 = new Sequence("MKKILTTTTTGGCCCMILLTLF",
//        Sequence s1 = new Sequence("PEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPEPE",
                Alphabet.Protein);

//        Sequence s1 = new Sequence("TAGTGATGCACCACGGTGCATCACCACATCACGTATTAGCGGACCTTTCGGCCAGTTATTCGTGACTTCTGGGTAGGTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCAAGGCACA", Alphabet.DNA);
        Sequence s2 = new Sequence("MEAAARRGGRISGGCCTERH",
//        Sequence s2 = new Sequence("MGFYSGYSGGYSGGGYGSSFVLIVVLFILLIIVGATFLY",
                Alphabet.Protein);
//        Sequence s2 = new Sequence("CATCCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCGGGACTTAACCCAACATCTCACGACACGAGCTGACGACAACCATGCACCACCTGTCTCCGATGTACCGAAGTAACTTCCTATCTCTAAGAATAGCATCGGGATGTCA", Alphabet.DNA);

        int go = -9;
        int ge = -1;

//        SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
        SimilarityMatrix matrix = SimilarityMatrix.getBLOSUM62();
        SmithWatermanAligner aligner = new SmithWatermanAligner();

        List<AlignedData> alignments = aligner.align(matrix, go, ge, s1, s2);
        
        if (alignments.size() == 0) {
            AlignedData ad = new AlignedData(s1, s2);
            ad.setScore(0);
            ad.setFirstAlignedSequence(null);
            ad.setSecondAlignedSequence(null);
            ad.setFirstAlignedSequenceStartOffset(-1);
            ad.setFirstAlignedSequenceEndOffset(-1);
            ad.setSecondAlignedSeqeunceStartOffset(-1);
            ad.setSecondAlignedSeqeunceEndOffset(-1);
            ad.setFirstAlignedSequenceInsertionCount(-1);
            ad.setSecondAlignedSeqeunceInsertionCount(-1);
            ad.setFirstOffset(-1);
            ad.setSecondOffset(-1);
        }

        System.out.println("Total alignments: " + alignments.size());
        if (alignments.size()>0) {
            AlignedData ad = alignments.get(0);
            System.out.println(s1);
            System.out.println(s2);
            System.out.println();
            System.out.println(ad);
//        System.out.println(ad.getScore());
            Sequence as1 = ad.getFirstAlignedSequence();
            Sequence as2 = ad.getSecondAlignedSequence();
//        System.out.println(s1);
            System.out.print(ad.getFirstAlignedSequenceStartOffset() + "\t");
            System.out.println(ad.getFirstAlignedSequenceEndOffset());
            System.out.print(ad.getSecondAlignedSeqeunceStartOffset() + "\t");
            System.out.println(ad.getSecondAlignedSeqeunceEndOffset());
            System.out.println(ad.getScore());

            /*System.out.println("new features");
                System.out.println(ad.getAlignmentLength());
                System.out.println(ad.getAlignmentLengthExcludingEndGaps());
                System.out.println(ad.getNumberOfIdenticalBasePairs(true));
                System.out.println(ad.getNumberOfIdenticalBasePairs(false));
                System.out.println(ad.getScore());

                System.out.println("Self Alignment");
                List<AlignedData> ads = aligner.align(matrix,go,ge,s1,s1);
                ad = ads.get(0);
                System.out.println(ad.getScore());
                System.out.println(s1.getSelfAlignedScore(matrix));

                ads = aligner.align(matrix, go, ge, s2,s2);
                ad = ads.get(0);
                System.out.println(ad.getScore());
                System.out.println(s2.getSelfAlignedScore(matrix));*/
        }


    }

}
