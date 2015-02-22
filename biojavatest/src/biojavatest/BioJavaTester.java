package biojavatest;

import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.SimpleSubstitutionMatrix;
import org.biojava3.alignment.SubstitutionMatrixHelper;
import org.biojava3.alignment.template.AlignedSequence;
import org.biojava3.alignment.template.GapPenalty;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.compound.DNACompoundSet;
import org.biojava3.core.sequence.compound.NucleotideCompound;
import org.biojava3.core.sequence.io.FastaReaderHelper;
import org.biojava3.core.sequence.io.FastaSequenceParser;
import org.biojava3.core.sequence.io.FastaWriterHelper;
import org.biojava3.core.sequence.template.CompoundSet;
import org.biojava3.core.sequence.template.Sequence;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class BioJavaTester {
    public static void main(String[] args) throws FileNotFoundException {
//        String basePath = "C:\\sali\\pti\\data\\mina-Nov11-2010";
        String basePath = "/home/saliya/Desktop";
        String fname = "TEST_20seq_FS312_trimmed3.fa";
////
        try {
            LinkedHashMap<String, DNASequence> map = FastaReaderHelper.readFastaDNASequence(
                    new File(basePath + File.separator + fname));

            System.out.println(map.keySet().size());

            String[] sequenceNames = new String[map.keySet().size()];
            map.keySet().toArray(sequenceNames);
            System.out.println(sequenceNames[0]);
//
//            List<Sequence<NucleotideCompound>> seqs = new ArrayList<Sequence<NucleotideCompound>>(map.values());
//            System.out.println(seqs.size());
//
////            SubstitutionMatrix<NucleotideCompound> matrix = new
////                SimpleSubstitutionMatrix<NucleotideCompound>(new DNACompoundSet(), new File("src\\matrices\\EDNAFULL"));
//
//            SubstitutionMatrix<NucleotideCompound> matrix = SubstitutionMatrixHelper.getNuc4_2();
//
//
//            GapPenalty penalty = new SimpleGapPenalty((short)20, (short)8);
//            long t0 = System.currentTimeMillis();
//            List<SequencePair<Sequence<NucleotideCompound>, NucleotideCompound>> pairs = Alignments.
//                    getAllPairsAlignments(seqs, Alignments.PairwiseSequenceAlignerType.GLOBAL, penalty, matrix);
//            long time = System.currentTimeMillis() - t0;
//            System.out.println("Time (ms): " + time);
//
//            System.out.println(pairs.size());
//
//            PrintWriter writer = new PrintWriter("src/out.txt");
//            for (SequencePair<Sequence<NucleotideCompound>, NucleotideCompound> pair : pairs) {
//                writer.println(pair.getAlignedSequence(1).toString());
//                writer.println(pair.getAlignedSequence(2).toString());
//
//                writer.println();
//            }
//            writer.close();
//            System.exit(0);


            System.out.println("DONE.");

//
//
//            for(Map.Entry<String, DNASequence> entry : map.entrySet()) {
//                System.out.println(entry.getValue());
//            }
//            System.out.println("Number of sequences: " + map.values().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        doSimple();

    }

    public static void doSimple() throws FileNotFoundException {
        DNASequence s1 = new DNASequence("AGATGCATTATGTGCGAATCGCCCCCCCCC");
        DNASequence s2 = new DNASequence("TGCGAACTTAGGGAAAAA");

//        SubstitutionMatrix<NucleotideCompound> matrix = new
//                SimpleSubstitutionMatrix<NucleotideCompound>(new DNACompoundSet(), new File("src\\matrices\\EDNAFULL"));
        SubstitutionMatrix<NucleotideCompound> matrix = SubstitutionMatrixHelper.getNuc4_4();

        GapPenalty penalty = new SimpleGapPenalty((short)16, (short)4);
        SequencePair<DNASequence, NucleotideCompound> pair = Alignments.getPairwiseAlignment(
                s1, s2, Alignments.PairwiseSequenceAlignerType.GLOBAL, penalty, matrix);

        AlignedSequence<DNASequence, NucleotideCompound> as1 = pair.getAlignedSequence(s1);
        AlignedSequence<DNASequence, NucleotideCompound> as2 = pair.getAlignedSequence(s2);
        System.out.println(as1);
        System.out.println(as2);

        System.out.println(as1.getStart().getPosition());
        System.out.println(as2.getStart().getPosition());

        System.out.println(as1.getEnd().getPosition() - 1);
        System.out.println(as2.getEnd().getPosition() - 1);

        System.out.println(as2.getLength());

                NucleotideCompound A,C,T,G,gap;
        DNACompoundSet dnaCS = DNACompoundSet.getDNACompoundSet();

        A = dnaCS.getCompoundForString("A");
        C = dnaCS.getCompoundForString("C");
        T = dnaCS.getCompoundForString("T");
        G = dnaCS.getCompoundForString("G");
        gap = dnaCS.getCompoundForString("-");

        System.out.println(A);
        System.out.println(C);
        System.out.println(T);
        System.out.println(G);
        System.out.println(gap);



//         // Modifying percent identity calculation only for the aligned portion.
//        int firstNonGapIdx = Math.max(as1.getStart().getPosition(), as2.getStart().getPosition());
//        int lastNonGapIdx = Math.min(as1.getEnd().getPosition(), as2.getEnd().getPosition());
//
//        float identity = 0.0f;
//        for (int i = firstNonGapIdx; i <= lastNonGapIdx; i++)
//        {
//            if (as1.getCompoundAt(i).equals(as2.getCompoundAt(i)))
//            {
//                identity++;
//            }
//
//        }
//
//        System.out.println(identity);
//        System.out.println((short) ((1 - (identity / ((lastNonGapIdx - firstNonGapIdx) + 1))) * Short.MAX_VALUE));

        

    }
}
