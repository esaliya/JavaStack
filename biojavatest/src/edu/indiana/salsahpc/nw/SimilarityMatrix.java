package edu.indiana.salsahpc.nw;

import java.io.*;

public class SimilarityMatrix {
    private String name;
    private String[] symbols;
    private int[][] values;

    public int getValueAt(int row, int col){
        return values[row][col];
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SimilarityMatrix getEDNAFULL() throws IOException {
        return loadMatrix(getReader("EDNAFULL"));
    }

    public static SimilarityMatrix loadMatrixFromFile(String path) throws IOException {
        FileInputStream fins = new FileInputStream(path);
        return loadMatrix(fins);
    }

    private static SimilarityMatrix loadMatrix(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        SimilarityMatrix mat = new SimilarityMatrix();
        mat.setName(reader.readLine().trim());
        String splitRegex = "(,|( )+)"; // comma or one or more spaces
        String [] syms = reader.readLine().split(splitRegex);
        mat.setSymbols(syms);
        int [][] values = new int[Byte.MAX_VALUE][];
        for(int i = 0; i < Byte.MAX_VALUE; i++) {
            values[i] = new int[Byte.MAX_VALUE];
        }

        String [] rowSplits;
        int [] rowValues;
        int count;
        for(String r : syms) {
            count = 0;
            rowSplits = reader.readLine().split(splitRegex);
            rowValues = values[r.charAt(0)];
            for (String c:syms) {
                rowValues[c.charAt(0)] =  Integer.parseInt(rowSplits[count++]);
            }
        }

        mat.setValues(values);
        return mat;
    }

     private static InputStream getReader(String fname) {
        return SimilarityMatrix.class.getResourceAsStream(String.format("/%s",
                fname));
    }

    public String[] getSymbols() {
        return symbols;
    }

    public void setSymbols(String[] symbols) {
        this.symbols = symbols;
    }
}
