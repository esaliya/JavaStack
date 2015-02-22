package biojavawrappertest;

import edu.indiana.salsahpc.AlignmentData;
import edu.indiana.salsahpc.BioJavaWrapper;
import edu.indiana.salsahpc.DistanceType;
import edu.indiana.salsahpc.MatrixUtil;
import org.biojava3.alignment.template.AlignedSequence;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.compound.AminoAcidCompound;
import org.biojava3.core.sequence.compound.NucleotideCompound;

public class WrapperTester {
    public static void main(String[] args) {
//        String s1 = "AGATGCATTATGTGCGAATCGCCCCCCCCC";
//        String s2 = "TGCGAACTTAGGGAAAAA";

        // Sequences that give different alignments w.r.t. this (old) MBF and BioJava update
        String s1 = "CTGGCACGGAGTTAGCCGGTGCTATTACTCTGGTACCGTCATCTGCCCTAAGGCTCTTTCGTCCCAGATTCAGAGGTTTACGATCCGAAACCTTCATCCCTCACGCGGCGTCGCTCCATCAGGCTTGCGCCCATTGTGGAAGATTCCTAACTGCTGCCTCCCGTAGGAGTGGGACCCGTGTCTCAGTGCCCCTGTGGCCGGCCACCCTCTCAGGCCGGCTATCCGTCGTCGCCTTGGTAGGCCTTTACCCCACCAACCAGCTGATGGAACGCAACCCCATCCAGAAGCGATAAATCTTTAGTGATGCACCACGGTGCATCACCACATCACGTATTAGCGGACCTTTCGGCCAGTTATTCGTGACTTCTGGGTAGGTCAGTTACGTGTTACTCACCCGTGCGCCACTCGGTCCGAAGACCGCGTTCGGCTTGCATGTCTTAAGCACGCCGCCAGCGTTCACCCTGAGCCAGGATCAAACTCTCTGAGACTTCCAAGGCACACAGGGGA";
        String s2 = "CTTCACCCCAATCATCCATCCCACCTTAGGCGGCTGGCCCCTAAAAGGTTACCTCACCGACTTCGGGTGTTACAAACTCTCGTGGTGTGACGGGCGGTGTGTACAAGGCCCGGGAACGTATTCACCGCGGCGTGCTGATCCGCGATTACTAGCGATTCCGACTTCATGGAGGCGAGTTGCAGCCTCCAATCCGAACTGAGATCGGCTTTCAGAGATTAGCTTGCCGTCACCGGCTCGCAACTCGTTGTACCGACCATTGTAGCACGTGTGTAGCCCAGGTCATAAGGGGCATGATGATTTGACGTCATCCCCACCTTCCTCCGGTTTATTACCCGGCAGTCTCGCTAGAGTGCCCAACTTAATGATGGCAACTAACAATAAGGGTTGCGCTCGTTGCGGGACTTAACCCAACATCTCACGACACGAGCTGACGACAACCATGCACCACCTGTCTCCGATGTACCGAAGTAACTTCCTATCTCTAAGAATAGCATCGGGATGTCAAGACCT";

        SubstitutionMatrix<NucleotideCompound> matrix = MatrixUtil.getEDNAFULL();

        // Default distance is percent identity over the aligned region
//        System.out.println(BioJavaWrapper.calculateDistance(s1, s2, (short)16, (short)4, matrix));

        // Explicitly specify distance type
//        System.out.println(BioJavaWrapper.calculateDistance(s1, s2, (short)8, (short)2, matrix, DistanceType.Kimura2));


        /* Code for Protein alignment */
//        String str1 = "MKKISLTTMILLALVLGMIIGVVLNNTASPETAKLYAQEISIFTTIFLRLIKMIIAPLVVSTLVVGIAKMGDAKALGRIFSKTLFLFICASLLSIALGLITVNFFMPGTGINFVAHGAETTGVVAAEPFTLKVFISHAFPTSIVDAMAHNEILQIVVFSIFLGCSLTAIGEKGSAIVHALDSLAHAMLKLTGYVMLFAPLTVFAAISALIAERGLAVMVSAGIFMGEFYFTMLLLWVLLIGLAIVYVGPCIRRLTRALSEPALLAFTTSSSEAAFPGTLEKLEQFGVSPKIASFVLPIGYSFNLVGSMAYCSFATVFIAQACNIHLSIGEQITMLLILMLTSKGMAGVPRASMVVIAATLNQFNIPEAGLILLMGVDPFLDMGRSATNVMSNAMGAAMVSRWEGEHFGEGCRGKALKPNESNVALP";
        String str1 = "MKKISLTTMILLA";
//        String str2 = "MASEEKIYDVIIIGAGPAGMTAALYTSRADLDTLMIERGVPGGQMVNTAEVENYPGFDSILGPDLSDKMLSGAKQFGAEYAYGDIKEVIDGKEFKTVTAGSKTYKARAIIIATGAEHRKLGAAGEEELSGRGVSYCAVCDGAFFKNRELVVVGGGDSAVEEGTYLTRYADKVTIVHRRDKLRAQQILQDRAFKDEKVDFIWNNTVEEIIGDGKKVTSVKLVSTVDGSESIMPVDGVFIYVGLVPLTKAFLSLGITDEEGYIVTDEEMRTNLPGIFAAGDVRAKSLRQIVTATGDGGLAGQNAQKYVEELKEALEAEAAK";
        String str2 = "MASETTEKI";

        ProteinSequence seq1 = new ProteinSequence(str1);
        ProteinSequence seq2 = new ProteinSequence(str2);
        
        

        SubstitutionMatrix<AminoAcidCompound> m = MatrixUtil.getBlosum62();
        AlignmentData ad = BioJavaWrapper.calculateAlignment(seq1, seq2, (short) 9, (short) 1, m, DistanceType.PercentIdentity);
        System.out.println(ad.getDistance());
        System.out.println(ad.getScore());
        System.out.println(ad.getFirstSelfAlignedScore(m));
        System.out.println(ad.getFirstAlignedSequenceStartOffset());
        System.out.println(ad.getFirstAlignedSequenceEndOffset());
        System.out.println(ad.getSecondAlignedSequenceStartOffset());
        System.out.println(ad.getSecondAlignedSequenceEndOffset());

        SequencePair pair = ad.getPair();
        AlignedSequence aseq1 = pair.getAlignedSequence(seq1);
        AlignedSequence aseq2 = pair.getAlignedSequence(seq2);


        System.out.println("**A*********************************************************************");
        System.out.println(seq2.getLength());
        int startInAlignment = aseq2.getStart().getPosition();
        System.out.println(startInAlignment);
        System.out.println(aseq2.getSequenceIndexAt(startInAlignment));
        int endInAlignment = aseq2.getEnd().getPosition();
        System.out.println(endInAlignment);
        System.out.println(aseq2.getSequenceIndexAt(endInAlignment));
        System.out.println("***********************************************************************");
        
        
        System.out.println();
        System.out.println("**B*********************************************************************");
        System.out.println(seq1.getCompoundAt(1));
        System.out.println(seq1.getCompoundAt(2));
        System.out.println("***********************************************************************");


        System.out.println();
        System.out.println("**C*********************************************************************");
        System.out.println(pair.getNumIdenticals());
        int start = Math.max(aseq1.getStart().getPosition(), aseq2.getStart().getPosition());
        int end = Math.min(aseq1.getEnd().getPosition(), aseq2.getEnd().getPosition());
        System.out.println((end-start)+1);
        System.out.println("***********************************************************************");


        System.out.println(ad.getPair().getAlignedSequence(seq1));
        System.out.println(ad.getPair().getAlignedSequence(seq2));



    }
}
