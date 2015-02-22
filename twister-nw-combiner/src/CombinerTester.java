import javax.swing.plaf.metal.MetalIconFactory;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class CombinerTester {
    public static void main(String[] args) throws IOException {
//        String path = "/home/saliya/sali/pti/sub/salsa/saliya/java/twister-nw/out/production/twister-nw";
//        File f = new File(path);
//        File[] outs = f.listFiles(new FilenameFilter() {
//            public boolean accept(File dir, String name) {
//                return name.startsWith("out_prefix_");
//            }
//        });
//
//        int seqs = 20;
//        int parts = 3;
//        int seqsPerPart = seqs/parts;
//        int remainder = seqs % parts;
//        int suffix;
//        int rowSize;
//
//        DataInputStream dis;
//        PrintWriter writer = new PrintWriter(path + File.separator + "matrix.txt");
//        for (File out : outs) {
//            suffix = Integer.parseInt(out.getName().substring(out.getName().lastIndexOf("_") + 1));
//            rowSize = suffix < remainder ? seqsPerPart +1 : seqsPerPart;
//            dis = new DataInputStream(new FileInputStream(out));
//
//            for (int i = 0; i < rowSize; i++){
//                for (int j = 0; j < seqs; j++) {
//                    writer.write(String.valueOf(dis.readShort()) + "\t");
//                }
//                writer.write("\n");
//            }
//            dis.close();
//        }
//        writer.flush();
//        writer.close();

        int[] arr = {8,5,9,10,6,7};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
    }
}
