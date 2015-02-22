import edu.indiana.salsahpc.SimilarityMatrix;

import java.io.IOException;

public class MatrixLoadTester {
    public static void main(String[] args) {
        try {
            SimilarityMatrix matrix = SimilarityMatrix.getEDNAFULL();
            char[] syms = matrix.getSymbols();
            for (int i = 0; i < syms.length; i++) {
                char sym = syms[i];
                System.out.print(sym + "\t");
            }
            System.out.println();
            for (int i = 0; i < syms.length; i++) {
                for (int j = 0; j < syms.length; j++) {
                    System.out.print(matrix.getValueAt(syms[i], syms[j]) + "\t");
                }
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
