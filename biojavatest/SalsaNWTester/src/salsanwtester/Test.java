package salsanwtester;

//import edu.indiana.salsahpc.nw.AlignedData;
//import edu.indiana.salsahpc.nw.SalsaNWAligner;
//import edu.indiana.salsahpc.nw.SimilarityMatrix;

import edu.indiana.salsahpc.nw.AlignedData;
import edu.indiana.salsahpc.nw.SalsaNWAligner;
import edu.indiana.salsahpc.nw.SimilarityMatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        String x = "1,2  4,3";
        String[] split = x.split("(,|( )+)");
        System.out.println(split);
        System.out.println((byte)"A".charAt(0));

        SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
//        String[] syms = matrix.getSymbols();
//        for (String r: syms){
//            for (String c: syms) {
//
//                int val = matrix.getValueAt(r.getBytes()[0], c.charAt(0));
//                if (val < 0) {
//                    System.out.print(val + " ");
//                } else {
//                    System.out.print(" " + val + " ");
//                }
//            }
//            System.out.println();
//        }

//        String s = "abcdef";
//        byte[] bytes = s.getBytes();
//        System.out.println(bytes.length);
//        System.out.println("***");
//
//        for (int i = 0; i < bytes.length; i++) {
//            byte aByte = bytes[i];
//            System.out.println(aByte);
//        }
//        System.out.println("***");
//
//        for (int i = 0; i < 127; i++) {
//            System.out.println((char)i + " " + i);
//        }

//        String s1 ="CATCCAA";
//        String s2 = "AGAGATGGTTTT";

        // Sequences that give different alignments w.r.t. old MBF and BioJava update
        // String s1 = "CTGGCACGGAGTTAGCCGGTGCTATTACTCTGGTACCGTCATCTGCCCTAAGGCTCTTTCGTCCCAGATTCAGAGGTTTACGATCCGAAACCTTCATCCCTCACGCGGCGTCGCTCCATCAGGCTTGCGCCCATTGTGGAAGATTCCTAACTGCTGCCTCCCGTAGGAGTGGGACCCGTGTCTCAGTGCCCCTGTGGCCGGCCACCCTCTCAGGCCGGCTATCCGTCGTCGCCTTGGTAGGCCTTTACCCCACCAACCAGCTGATGGAACGCAACCCCATCCAGAAGCGATAAATCTTTAGTGATGCACCACGGTGCATCACCACATCACGTATTAGCGGACCTTTCGGCCAGTTATTCGTGACTTCTGGGTAGGTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCAAGGCACACAGGGGA";
        // String s2 = "CTTCACCCCAATCATCCATCCCACCTTAGGCGGCTGGCCCCTAAAAGGTTACCTCACCGACTTCGGGTGTTACAAACTCTCGTGGTGTGACGGGCGGTGTGTACAAGGCCCGGGAACGTATTCACCGCGGCGTGCTGATCCGCGATTACTAGCGATTCCGACTTCATGGAGGCGAGTTGCAGCCTCCAATCCGAACTGAGATCGGCTTTCAGAGATTAGCTTGCCGTCACCGGCTCGCAACTCGTTGTACCGACCATTGTAGCACGTGTGTAGCCCAGGTCATAAGGGGCATGATGATTTGACGTCATCCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCGGGACTTAACCCAACATCTCACGACACGAGCTGACGACAACCATGCACCACCTGTCTCCGATGTACCGAAGTAACTTCCTATCTCTAAGAATAGCATCGGGATGTCAAGACCT";

        // Another two sequences that screw  up old MBF and BioJava
        String s1 = "TAGTGATGCACCACGGTGCATCACCACATCACGTATTAGCGGACCTTTCGGCCAGTTATTCGTGACTTCTGGGTAGGTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCAAGGCACA";
        String s2 = "CATCCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCGGGACTTAACCCAACATCTCACGACACGAGCTGACGACAACCATGCACCACCTGTCTCCGATGTACCGAAGTAACTTCCTATCTCTAAGAATAGCATCGGGATGTCA";

        System.out.println("S1: " + s1);
        System.out.println("S2: " + s2);
        System.out.println();

        int go = -16;
        int ge = -4;

        SalsaNWAligner aligner = new SalsaNWAligner();
        AlignedData ad = aligner.Align(matrix, go, ge, s1, s2);

        List<byte[]> alignedSequences = ad.getAlignedSequences();
        System.out.println("aS1: " + new String(alignedSequences.get(0)));
        System.out.println("aS2: " + new String(alignedSequences.get(1)));
        System.out.println();
        System.out.println("\n\nDistance S1 against S2");
        System.out.println(aligner.calculatePercentIdentityDistance(ad));

        ad = aligner.Align(matrix, go, ge, s2, s1);
        alignedSequences = ad.getAlignedSequences();
        System.out.println("aS2: " + new String(alignedSequences.get(0)));
        System.out.println("aS1: " + new String(alignedSequences.get(1)));
        System.out.println();
        System.out.println("\n\nDistance S2 against S1");
        System.out.println(aligner.calculatePercentIdentityDistance(ad));

        /*
         * Starting the pairwise alignment of 200 sequences
         */

        System.out.println("Starting the pairwise alignment of 200 sequences");
        String[] seqs = new String[200];
        BufferedReader reader = new BufferedReader(new FileReader("200_fasta.txt"));
        String seq;
        int count = 0;
        while ((seq = reader.readLine())!= null) {
            if (!seq.startsWith(">")) {
                seqs[count++] = seq;
            }
        }

        String[] alignedSeqs = new String[39800];
        double preciseTime = 0.0;
        double start, end;
        PrintWriter writer = new PrintWriter("SalsaNW_alignments.txt");
        count = 0;
        for (int i = 0; i < seqs.length; i++)
        {
            for (int j = i + 1; j < seqs.length; j++)
            {
                start = System.currentTimeMillis();
                ad = aligner.Align(matrix, go, ge, seqs[i], seqs[j]);
                end = System.currentTimeMillis();
                preciseTime += (end - start);
                alignedSeqs[count++] = ad.getFirstAlignedSequence();
                alignedSeqs[count++] = ad.getSecondAlignedSequence();
            }
        }
        writer.println("Time to align 200 * (200 -1) / 2 sequences: " + ((preciseTime/1000)/60) + "min");
        System.out.println("Time to align 200 * (200 -1) / 2 sequences: " + ((preciseTime / 1000) / 60) + "min");

        for (int i = 0; i < alignedSeqs.length; i++)
        {
            writer.println(alignedSeqs[i]);
        }
        writer.flush();
        writer.close();
        System.out.println("Done");
        //Time to align 200 * (200 -1) / 2 sequences: 0.87485min


    }
}
