package edu.indiana.salsahpc;

import jaligner.Sequence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SequenceParser {
    /**
     * Parse a simple FASTA file with sequence name followed by multi-line sequence characters
     *
     * @param file Path to FASTA file
     * @param type <code>Sequence.NUCLEIC</code> or <code>Sequence.PROTEIN</code>
     * @return a <code>List&lt;Sequence&gt;</code>
     * @throws IOException If an IO error happens
     */
    public static List<Sequence> parse(String file, int type) throws IOException {
        String desc = "";
        ArrayList<Sequence> seqs = new ArrayList<Sequence>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String name;
        String seqstr = "";
        Sequence seq;
        name = reader.readLine();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(">")) {
                seq = new Sequence(seqstr, name, desc, type);
                seqs.add(seq);
                name = line;
                seqstr = "";
                continue;
            }
            seqstr += line;
        }
        seq = new Sequence(seqstr, name, desc, type);
        seqs.add(seq);
        reader.close();
        return seqs;
    }
}
