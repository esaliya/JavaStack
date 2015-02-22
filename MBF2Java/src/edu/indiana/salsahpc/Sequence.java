package edu.indiana.salsahpc;

import java.util.Arrays;
import java.util.HashMap;

public class Sequence {
    private String id = "";
    private byte[] sequenceData = null;
    // Shrinking MBF long to Java short since Java arrays anyway have max size of Int.MAX_VALUE
    // See "int size = (int) numberOfRows * numberOfCols; in fillMatrixAffine of DynamicProgrammingPairwiseAligner"
    private short count = 0;
    
    private Alphabet alphabet;

    public Sequence(String sequence, Alphabet alphabet) {
        this(sequence, "", alphabet);
    }

    public Sequence(byte[] sequenceData, Alphabet alphabet) {
        this(sequenceData, "", alphabet);
    }
    public Sequence(byte [] sequenceData, String id, Alphabet alphabet) {
        this.sequenceData = sequenceData;
        this.alphabet = alphabet;
        this.count = (short)sequenceData.length;
        this.id = id;
    }
    public Sequence(String sequence, String id, Alphabet alphabet) {
        this.id = id;
        //Note. Assumes sequence is an ASCII which will get encoded one byte per one character
        sequenceData = sequence.getBytes();
        this.alphabet = alphabet;
        count = (short) sequence.length();
    }

    public String getId() {
        return id;
    }

    public byte get(int i) {
        return sequenceData[i];
    }

    public short getCount() {
        return count;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public String toString() {
        return new String(sequenceData);
    }

    public Sequence getReverseComplementedSequence() throws UnsupportedOperationException{
        if (alphabet == Alphabet.DNA) {
            byte[] reverseComplement = new byte[sequenceData.length];
            HashMap<Byte, Byte> complementSymbolMap = new HashMap<Byte, Byte>(8);
            complementSymbolMap.put((byte)'A', (byte)'T');
            complementSymbolMap.put((byte)'T', (byte)'A');
            complementSymbolMap.put((byte)'U', (byte)'A');
            complementSymbolMap.put((byte)'G', (byte)'C');
            complementSymbolMap.put((byte)'C', (byte)'G');

            complementSymbolMap.put((byte)'M', (byte)'K');
            complementSymbolMap.put((byte)'K', (byte)'M');
            complementSymbolMap.put((byte)'Y', (byte)'R');
            complementSymbolMap.put((byte)'R', (byte)'Y');
            complementSymbolMap.put((byte)'N', (byte)'N');
            complementSymbolMap.put((byte)'S', (byte)'S');

            complementSymbolMap.put((byte)'B', (byte)'V');
            complementSymbolMap.put((byte)'V', (byte)'B');
            complementSymbolMap.put((byte)'D', (byte)'H');
            complementSymbolMap.put((byte)'H', (byte)'D');
            complementSymbolMap.put((byte)'W', (byte)'W');
            complementSymbolMap.put((byte)'X', (byte)'X');

            complementSymbolMap.put((byte)'a', (byte)'t');
            complementSymbolMap.put((byte)'t', (byte)'a');
            complementSymbolMap.put((byte)'u', (byte)'a');
            complementSymbolMap.put((byte)'g', (byte)'c');
            complementSymbolMap.put((byte)'c', (byte)'g');

            complementSymbolMap.put((byte)'m', (byte)'k');
            complementSymbolMap.put((byte)'k', (byte)'m');
            complementSymbolMap.put((byte)'y', (byte)'r');
            complementSymbolMap.put((byte)'r', (byte)'y');
            complementSymbolMap.put((byte)'n', (byte)'n');
            complementSymbolMap.put((byte)'s', (byte)'s');

            complementSymbolMap.put((byte)'b', (byte)'v');
            complementSymbolMap.put((byte)'v', (byte)'b');
            complementSymbolMap.put((byte)'d', (byte)'h');
            complementSymbolMap.put((byte)'h', (byte)'d');
            complementSymbolMap.put((byte)'w', (byte)'w');
            complementSymbolMap.put((byte)'x', (byte)'x');

            int idx = sequenceData.length - 1;
            for(byte b : sequenceData){
                reverseComplement[idx] = complementSymbolMap.get(b);
                --idx;
            }
            Sequence reverseSequence = new Sequence(reverseComplement, id + "_reversecomplement", alphabet);
            return reverseSequence;
        }
        else{
            throw new UnsupportedOperationException("No reverse complement for sequences other than DNA");
        }
    }
    
    public int getSelfAlignedScore(SimilarityMatrix matrix){
        int selfAlignedScore = 0;
        for(byte c : sequenceData){
            selfAlignedScore += matrix.getValueAt(c,c);
        }
        return selfAlignedScore;
    }

    public int getFirstNonGapIndex(){
        byte gap = (byte)'-';
        for (int i =0; i <count; ++i){
            if (sequenceData[i] != gap){
                return i;
            }
        }
        return -1;
    }

    public int getLastNonGapIndex(){
        byte gap = (byte)'-';
        for (int i=count-1; i >=0; --i){
            if (sequenceData[i] != gap){
                return i;
            }
        }
        return -1;
    }
}
