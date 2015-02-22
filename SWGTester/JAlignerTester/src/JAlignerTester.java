import edu.indiana.salsahpc.MatrixUtil;
import edu.indiana.salsahpc.SequenceParser;
import jaligner.Alignment;
import jaligner.Sequence;
import jaligner.SmithWatermanGotoh;
import jaligner.formats.FASTA;
import jaligner.matrix.MatrixLoaderException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JAlignerTester {
    public static void main(String[] args) throws IOException, MatrixLoaderException {
        test();
//        String file = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\100k_sample_fasta_clusters_21+5_100.txt";
//        String outfile = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\100k_sample_fasta_clusters_21+5_100_JAlignerParserOut.txt";
//        FASTA fasta = new FASTA();
//        List<Sequence> seqs = SequenceParser.parse(file, Sequence.NUCLEIC);
//        System.out.println(seqs.size());
//
//        PrintWriter writer = new PrintWriter(outfile);
//        for (int i = 0; i < seqs.size(); i++) {
//            Sequence sequence = seqs.get(i);
//            writer.println(fasta.format(sequence).replace(">>", ">"))  ;
//        }
//        writer.flush();
//        writer.close();
    }

    public static void test() throws IOException, MatrixLoaderException {
        List<String> loggers = LogManager.getLoggingMXBean().getLoggerNames();
        for (int i = 0; i < loggers.size(); i++) {
            LogManager.getLoggingMXBean().setLoggerLevel(loggers.get(i), Level.OFF.toString());
        }

        String file = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\100k_sample_fasta_clusters_21+5_100.txt";
        String outfile = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\JAligner_alignment.txt";
//        String outfile = "C:\\Users\\sekanaya\\Desktop\\swgtester2\\JAligner_alignment_reversed.txt";
        List<Sequence> seqs = SequenceParser.parse(file, Sequence.NUCLEIC);
        System.out.println(seqs.size());

        PrintWriter writer = new PrintWriter(outfile);
        for (int i = 0; i < seqs.size(); i++) {
            for (int j = 0; j < seqs.size(); j++) {
                Sequence si = seqs.get(i);
                Sequence sj = seqs.get(j);
                Alignment alignment = SmithWatermanGotoh.align(si, sj, MatrixUtil.getEDNAFULL(), 16f, 4f);
//                Alignment alignment = SmithWatermanGotoh.align(sj, si, MatrixUtil.getEDNAFULL(), 16f, 4f);
                writer.println(new String(alignment.getSequence1()));
                writer.println(new String(alignment.getSequence2()));
                writer.println();
            }
            System.out.println("Row " + i + " done.");
        }
        writer.flush();
        writer.close();
    }
}
