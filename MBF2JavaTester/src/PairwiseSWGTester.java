import edu.indiana.salsahpc.*;

import java.io.*;
import java.util.List;

/*import static edu.rice.hj.HJ.finalizeHabanero;
import static edu.rice.hj.HJ.forall;
import static edu.rice.hj.HJ.initializeHabanero;*/

public class PairwiseSWGTester {
    /*public static void main(String[] args) throws Exception {
        *//*String file = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\100k_sample_fasta_clusters_21+5_100.txt";
        String alignFile = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\MBF2JavaSWG_alignment.txt";
        String distFile = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\MBF2JavaSWG_dist.txt";
        String lenFile = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\MBF2JavaSWG_len.txt";*//*

        String file = "G:\\My Box Files\\SalsaBio\\millions\\phy\\lsu_w+k\\sequences\\AMF_Phylo_for_clustering_revised_599nts_set_unique_seqs.fasta";
        String distFile = "G:\\My Box Files\\SalsaBio\\millions\\phy\\lsu_w+k\\distpairwise\\swgpid\\AMF_Phylo_for_clustering_revised_599nts_set_unique_seqs_swgms_pid_831_myjava.bin";

        List<Sequence> seqs = SequenceParser.parse(file,Alphabet.DNA);
        int count = seqs.size();

        SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
        int go = -16;
        int ge = -4;

        SmithWatermanAligner aligner = new SmithWatermanAligner();

        System.out.println("Working ...");
//        PrintWriter writer = new PrintWriter(alignFile);
//        PrintWriter distWriter = new PrintWriter(distFile);
//        PrintWriter lenWriter = new PrintWriter(lenFile);
        initializeHabanero();
        long time = System.currentTimeMillis();
        short [] dists = new short[count * count];
        for (int i = 0; i < count; i++) {
            final int iLoop = i;
            forall(0,count-1,(j) ->  {
                try{
                List<AlignedData> ads = new SmithWatermanAligner().align(matrix, go, ge, seqs.get(iLoop), seqs.get(j));
                    AlignedData ad = ads.get(0);
                    dists[iLoop*count+j] = DistanceUtil.computePercentIdentityDistanceAsShort(ad);
                } catch (Exception e){
                    System.out.println(e);
                }

//                lenWriter.println(ad.getFirstAlignedSequence().getCount());
//                distWriter.println((int)computePercentIdentityDistance(ad));
//                writer.println(ad.toString().replace("\n", "\r\n"));
//                writer.println();
            });
            System.out.println("Row " + i + " done.");
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);
        finalizeHabanero();

        DataOutputStream daos = new DataOutputStream(new FileOutputStream(distFile));
        for(short d: dists){
            daos.writeShort(d);
        }
        daos.flush();
        daos.close();
//        lenWriter.flush();
//        lenWriter.close();
//        distWriter.flush();
//        distWriter.close();
//        writer.flush();
//        writer.close();
        System.out.println("Done.");
    }*/

    public static float computePercentIdentityDistance(AlignedData ad) {
        Sequence alignedSeqA = ad.getFirstAlignedSequence();
        Sequence alignedSeqB = ad.getSecondAlignedSequence();
        float identity = 0.0f;
        for (int i = 0; i < alignedSeqA.getCount(); i++) {
            if (alignedSeqA.get(i) == alignedSeqB.get(i)) {
                identity++;
            }

        }
        return identity;
    }
}
