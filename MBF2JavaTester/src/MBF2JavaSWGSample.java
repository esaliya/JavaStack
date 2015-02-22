import edu.indiana.salsahpc.*;

import java.io.IOException;
import java.util.List;

public class MBF2JavaSWGSample {
    public static void main(String[] args) {
        String fasta = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\100k_sample_fasta_clusters_21+5_100.txt";

        try {
            // Parse FASTA file
            List<Sequence> sequences = SequenceParser.parse(fasta, Alphabet.DNA);

            // Load EDNAFULL similarity matrix
            SimilarityMatrix ednafull = SimilarityMatrix.getEDNAFULL();

            // Set gap open penalty.
            // Note negative value indicates penalty should be deducted from score when aligning
            int go = -16;

            // Set gap extension penalty.
            // Note negative value indicates penalty should be deducted from score when aligning
            int ge = -4;

            // Create SmithWaterman aligner
            SmithWatermanAligner aligner = new SmithWatermanAligner();

            // Short distance for each alignment pair
            short distance;

            // Double distance 
            double d;
            
            for (int i = 0; i < sequences.size(); i++) {
                for (int j = 0; j < sequences.size(); j++) {

                    
                    /* Print sequence and reverse complemented sequence*/
                    /*
                    System.out.println(sequences.get(i));
                    System.out.println(sequences.get(i).getReverseComplementedSequence());
                    System.out.println();
                    */

                    // Call align() method for each sequence pair
                    // Note. it returns a list of alignments though most of the time it's just one
                    List<AlignedData> ads = aligner.align(ednafull, go, ge, sequences.get(i), sequences.get(j));

                    // We will just take the first alignment
                    AlignedData ad = ads.get(0);

                    // Compute percent identity distance as short value
                    distance = DistanceUtil.computePercentIdentityDistanceAsShort(ad);
                    
                    /* Alignment score */
                    System.out.println("Alignment Score: " + ad.getScore());
                    
                    /* Different distances double values */
                    System.out.println();
                    System.out.println("Percent Identity: " + DistanceUtil.computePercentIdentityDistance(ad));
                    System.out.println("Jukes Cantor: " + DistanceUtil.computeJukesCantorDistance(ad));
                    System.out.println("Kimura2: " + DistanceUtil.computeKimura2Distance(ad));
                    System.out.println();

                    /*if (ad.getFirstAlignedSequenceInsertionCount() > 5 || ad.getSecondAlignedSeqeunceInsertionCount() > 5) {
                        System.out.println(sequences.get(i));
                        System.out.println();
                        System.out.println(sequences.get(j));
                        System.out.println();
                        System.out.println(ad);

                        System.out.println("FAS length: " + ad.getFirstAlignedSequence().getCount());
                        System.out.println("FAS soff: " + ad.getFirstAlignedSequenceStartOffset());
                        System.out.println("FAS eoff: " + ad.getFirstAlignedSequenceEndOffset());
                        System.out.println("FAS gaps: " + ad.getFirstAlignedSequenceInsertionCount());

                        short alignmentLength = (short)((ad.getFirstAlignedSequenceEndOffset() - ad.getFirstAlignedSequenceStartOffset()) + 1 + ad.getFirstAlignedSequenceInsertionCount());

                        System.out.println("SAS length: " + ad.getSecondAlignedSequence().getCount());
                        System.out.println("SAS soff: " + ad.getSecondAlignedSeqeunceStartOffset());
                        System.out.println("SAS eoff: " + ad.getSecondAlignedSeqeunceEndOffset());
                        System.out.println("SAS gaps: " + ad.getSecondAlignedSeqeunceInsertionCount());


                        return;
                    }*/
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
