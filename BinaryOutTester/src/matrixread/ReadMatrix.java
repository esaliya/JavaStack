package matrixread;

import edu.indiana.salsahpc.BioJavaWrapper;
import edu.indiana.salsahpc.MatrixUtil;
import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.compound.NucleotideCompound;
import org.biojava3.core.sequence.io.FastaReader;
import org.biojava3.core.sequence.io.FastaReaderHelper;
import org.biojava3.core.sequence.template.Sequence;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReadMatrix {
    public static void main(String[] args) throws Exception {
        // Comparing Distance for Ryan for his HMDS
        String path = "C:\\Users\\sekanaya\\Downloads\\distance_1000x1000.bin";
        int x = 1000;
        short d;
//        DataInputStream dis = new DataInputStream(new FileInputStream(path));
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < x; j++) {
//                d = dis.readShort();
//                System.out.println(d);
//            }
//        }
//        dis.close();

        path ="C:\\Users\\sekanaya\\Downloads\\test.1000.ref.fasta";
        LinkedHashMap<String, DNASequence> map = FastaReaderHelper.readFastaDNASequence(new File(path));
        List<Sequence<NucleotideCompound>> seqs = new ArrayList<Sequence<NucleotideCompound>>(map.values());


        short gapOpen = 16;
        short gapExt = 4;
        for (int i = 0; i < seqs.size(); i++) {
            Sequence<NucleotideCompound> seqi =  seqs.get(i);
            for (int j = 0; j < seqs.size(); j++) {
                Sequence<NucleotideCompound> seqj = seqs.get(j);
                x = BioJavaWrapper.calculateDistance(seqi.toString(), seqj.toString(), gapOpen,  gapExt, MatrixUtil.getEDNAFULL());
                System.out.println(x);
            }

        }
    }
}
