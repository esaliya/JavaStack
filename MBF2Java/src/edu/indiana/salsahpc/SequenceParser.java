package edu.indiana.salsahpc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SequenceParser {
    /**
     * Parse a simple FASTA file with sequence name followed by multi-line sequence characters
     *
     * @param file Path to FASTA file
     * @return a <code>List&lt;Sequence&gt;</code>
     * @throws java.io.IOException If an IO error happens
     */
    public static List<Sequence> parse(String file, Alphabet alphabet) throws IOException {
        ArrayList<Sequence> seqs = new ArrayList<Sequence>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String name;
        String seqstr = "";
        Sequence seq;
        name = reader.readLine();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(">")) {
                seq = new Sequence(seqstr, name, alphabet);
                seqs.add(seq);
                name = line;
                seqstr = "";
                continue;
            }
            seqstr += line;
        }
        seq = new Sequence(seqstr, name, alphabet);
        seqs.add(seq);
        reader.close();
        return seqs;
    }
}

