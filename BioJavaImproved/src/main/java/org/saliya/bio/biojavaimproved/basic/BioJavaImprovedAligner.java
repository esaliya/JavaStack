package org.saliya.bio.biojavaimproved.basic;

import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.SimpleSubstitutionMatrix;
import org.biojava3.alignment.SubstitutionMatrixHelper;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava3.core.sequence.compound.AminoAcidCompound;
import org.biojava3.core.sequence.compound.NucleotideCompound;

import java.io.InputStreamReader;

public class BioJavaImprovedAligner {
    public static void main(String[] args) {
        simpleTwoSequenceTest2();
    }

    public static void simpleTwoSequenceTest2() {
        String str1 = "MKKISLTTMILLALVLGMIIGVVLNNTASPETAKLYAQEISIFTTIFLRLIKMIIAPLVVSTLVVGIAKMGDAKALGRIFSKTLFLFICASLLSIALGLITVNFFMPGTGINFVAHGAETTGVVAAEPFTLKVFISHAFPTSIVDAMAHNEILQIVVFSIFLGCSLTAIGEKGSAIVHALDSLAHAMLKLTGYVMLFAPLTVFAAISALIAERGLAVMVSAGIFMGEFYFTMLLLWVLLIGLAIVYVGPCIRRLTRALSEPALLAFTTSSSEAAFPGTLEKLEQFGVSPKIASFVLPIGYSFNLVGSMAYCSFATVFIAQACNIHLSIGEQITMLLILMLTSKGMAGVPRASMVVIAATLNQFNIPEAGLILLMGVDPFLDMGRSATNVMSNAMGAAMVSRWEGEHFGEGCRGKALKPNESNVALP";
        String str2 = "MASEEKIYDVIIIGAGPAGMTAALYTSRADLDTLMIERGVPGGQMVNTAEVENYPGFDSILGPDLSDKMLSGAKQFGAEYAYGDIKEVIDGKEFKTVTAGSKTYKARAIIIATGAEHRKLGAAGEEELSGRGVSYCAVCDGAFFKNRELVVVGGGDSAVEEGTYLTRYADKVTIVHRRDKLRAQQILQDRAFKDEKVDFIWNNTVEEIIGDGKKVTSVKLVSTVDGSESIMPVDGVFIYVGLVPLTKAFLSLGITDEEGYIVTDEEMRTNLPGIFAAGDVRAKSLRQIVTATGDGGLAGQNAQKYVEELKEALEAEAAK";

        ProteinSequence seq1 = new ProteinSequence(str1);
        ProteinSequence seq2 = new ProteinSequence(str2);

        SubstitutionMatrix<AminoAcidCompound> matrix = SubstitutionMatrixHelper.getBlosum62();
        SimpleGapPenalty gapP = new SimpleGapPenalty();
        gapP.setOpenPenalty((short) 9);
        gapP.setExtensionPenalty((short) 1);

        SequencePair<ProteinSequence, AminoAcidCompound> psa =
                Alignments.getPairwiseAlignment(seq1, seq2, Alignments.PairwiseSequenceAlignerType.LOCAL, gapP, matrix);

        System.out.println(psa);
    }

    private static SubstitutionMatrix<NucleotideCompound> getNucleotideMatrix(String file) {
        return new SimpleSubstitutionMatrix(AmbiguityDNACompoundSet.getDNACompoundSet(), getReader(file), file);
    }

    private static InputStreamReader getReader(String file) {
        return new InputStreamReader(SubstitutionMatrixHelper.class.getResourceAsStream(String.format("/%s", new Object[]{file})));
    }
}
