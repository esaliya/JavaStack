package edu.indiana.salsahpc;

import java.io.*;

public class SimilarityMatrix {
    private int[][] values;
    // symbols length is 127 for ASCII range excluding DEL character
    private char[] symbols;
    private String name;

    // Row number is same as byte value corresponding
    // to sequence symbol on the row.
    // Column number is same as byte value corresponding
    // to sequence symbol on the column.
    public int getValueAt(int row, int col){
        return values[row][col];
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public char[] getSymbols() {
        return symbols;
    }

    public void setSymbols(char[] symbols) {
        this.symbols = symbols;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SimilarityMatrix getEDNAFULL() throws IOException {
        return loadMatrix(getReader("EDNAFULL_newformat"));
    }
    
    public static SimilarityMatrix getBLOSUM62() throws IOException{
        return loadMatrix(getReader("BLOSUM62_newformat"));
    }

    public static SimilarityMatrix loadMatrixFromFile(String path) throws IOException {
        FileInputStream fins = new FileInputStream(path);
        return loadMatrix(fins);
    }

    private static SimilarityMatrix loadMatrix(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        SimilarityMatrix mat = new SimilarityMatrix();
        mat.setName(reader.readLine().trim());

        String splitRegex = "(,|( )+)";     // comma or one or more spaces

        char[] syms = new char[Byte.MAX_VALUE];
        String [] splits = reader.readLine().split(splitRegex);
        String split;
        char u,l;
        for (int i = 0; i < splits.length; i++) {
            split = splits[i];
            u = split.toUpperCase().charAt(0);
            l = split.toLowerCase().charAt(0);
            // Store split in both lower case and upper case positions in syms
            // char to byte compression is OK as long as u,l are within ASCII range excluding DEL symbol, i.e.[0-126]
            syms[((byte)u)] = u;
            syms[((byte)l)] = l;
        }
        mat.setSymbols(syms);

        int [][] values = new int[Byte.MAX_VALUE][];
        for(int i = 0; i < Byte.MAX_VALUE; i++) {
            values[i] = new int[Byte.MAX_VALUE];
        }

        String [] rowSplits;
        int [] rowValuesU;
        int [] rowValuesL;
        int count;
        for(String r : splits) {
            count = 0;
            rowSplits = reader.readLine().split(splitRegex);
            rowValuesU = values[r.toUpperCase().charAt(0)];
            rowValuesL = values[r.toLowerCase().charAt(0)];
            for (String c: splits) {
                rowValuesU[c.toUpperCase().charAt(0)] =  Integer.parseInt(rowSplits[count]);
                rowValuesL[c.toLowerCase().charAt(0)] =  Integer.parseInt(rowSplits[count++]);
            }
        }

        mat.setValues(values);
        return mat;
    }

     private static InputStream getReader(String fname) {
        return SimilarityMatrix.class.getResourceAsStream(String.format("/%s",
                fname));
    }
}
