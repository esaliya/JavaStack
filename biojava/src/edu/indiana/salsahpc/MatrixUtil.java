package edu.indiana.salsahpc;

import org.biojava3.alignment.PositionSpecificSubstitutionMatrix;
import org.biojava3.alignment.SimpleSubstitutionMatrix;
import org.biojava3.alignment.SubstitutionMatrixHelper;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava3.core.sequence.compound.AminoAcidCompound;
import org.biojava3.core.sequence.compound.AminoAcidCompoundSet;
import org.biojava3.core.sequence.compound.NucleotideCompound;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MatrixUtil {

    // Wrapper functions for existing matrices in BioJava //

    /**
     * Returns Blosum 100 matrix by Henikoff & Henikoff
     * @return Blosum 100 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum100() {
        return SubstitutionMatrixHelper.getBlosum100();
    }

    /**
     * Returns Blosum 30 matrix by Henikoff & Henikoff
     * @return Blosum 30 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum30() {
        return  SubstitutionMatrixHelper.getBlosum30();
    }

    /**
     * Returns Blosum 35 matrix by Henikoff & Henikoff
     * @return Blosum 35 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum35() {
        return  SubstitutionMatrixHelper.getBlosum35();
    }

    /**
     * Returns Blosum 40 matrix by Henikoff & Henikoff
     * @return Blosum 40 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum40() {
        return  SubstitutionMatrixHelper.getBlosum40();
    }

    /**
     * Returns Blosum 45 matrix by Henikoff & Henikoff
     * @return Blosum 45 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum45() {
        return SubstitutionMatrixHelper.getBlosum45();
    }

    /**
     * Returns Blosum 50 matrix by Henikoff & Henikoff
     * @return Blosum 50 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum50() {
        return SubstitutionMatrixHelper.getBlosum50();
    }

    /**
     * Returns Blosum 55 matrix by Henikoff & Henikoff
     * @return Blosum 55 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum55() {
        return SubstitutionMatrixHelper.getBlosum55();
    }

    /**
     * Returns Blosum 60 matrix by Henikoff & Henikoff
     * @return Blosum 60 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum60() {
        return SubstitutionMatrixHelper.getBlosum60();
    }

    /**
     * Returns Blosum 62 matrix by Henikoff & Henikoff
     * @return Blosum 62 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum62() {
        return SubstitutionMatrixHelper.getBlosum62();
    }

    /**
     * Returns Blosum 65 matrix by Henikoff & Henikoff
     * @return Blosum 65 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum65() {
        return SubstitutionMatrixHelper.getBlosum65();
    }

    /**
     * Returns Blosum 70 matrix by Henikoff & Henikoff
     * @return Blosum 70 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum70() {
        return SubstitutionMatrixHelper.getBlosum70();
    }

    /**
     * Returns Blosum 75 matrix by Henikoff & Henikoff
     * @return Blosum 75 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum75() {
        return SubstitutionMatrixHelper.getBlosum75();
    }

    /**
     * Returns Blosum 80 matrix by Henikoff & Henikoff
     * @return Blosum 80 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum80() {
        return SubstitutionMatrixHelper.getBlosum80();
    }

    /**
     * Returns Blosum 85 matrix by Henikoff & Henikoff
     * @return Blosum 85 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum85() {
        return SubstitutionMatrixHelper.getBlosum85();
    }

    /**
     * Returns Blosum 90 matrix by Henikoff & Henikoff
     * @return Blosum 90 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getBlosum90() {
        return SubstitutionMatrixHelper.getBlosum90();
    }

    /**
     * Returns PAM 250 matrix by Gonnet, Cohen & Benner
     * @return Gonnet 250 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getGonnet250() {
        return SubstitutionMatrixHelper.getGonnet250();
    }

    /**
     * Returns Nuc 4.2 matrix by Lowe
     * @return Nuc 4.2 matrix
     */
    public static SubstitutionMatrix<NucleotideCompound> getNuc4_2() {
        return SubstitutionMatrixHelper.getNuc4_2();
    }

    /**
     * Returns Nuc 4.4 matrix by Lowe
     * @return Nuc 4.4 matrix
     */
    public static SubstitutionMatrix<NucleotideCompound> getNuc4_4() {
        return SubstitutionMatrixHelper.getNuc4_4();
    }

    /**
     * Returns PAM 250 matrix by Dayhoff
     * @return PAM 250 matrix
     */
    public static SubstitutionMatrix<AminoAcidCompound> getPAM250() {
        return SubstitutionMatrixHelper.getPAM250();
    }


    private static Map<String, SubstitutionMatrix<AminoAcidCompound>> aminoAcidMatrices =
            new HashMap<String, SubstitutionMatrix<AminoAcidCompound>>();
    private static Map<String, SubstitutionMatrix<NucleotideCompound>> nucleotideMatrices =
            new HashMap<String, SubstitutionMatrix<NucleotideCompound>>();

    // No instants
    private MatrixUtil() { }

    // Load other matrices //

    public static SubstitutionMatrix<AminoAcidCompound> getBlosumN(){
        return getAminoAcidCompoundSubstitutionMatrix("BLOSUMN");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getDAYHOFF(){
        return getAminoAcidCompoundSubstitutionMatrix("DAYHOFF");
    }

    public static SubstitutionMatrix<NucleotideCompound> getEDNAFULL() {
        return getNucleotideCompoundSubstitutionMatrix("EDNAFULL");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getIdentity(){
        return getAminoAcidCompoundSubstitutionMatrix("IDENTITY");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getMatch(){
        return getAminoAcidCompoundSubstitutionMatrix("MATCH");
    }

    public static SubstitutionMatrix<NucleotideCompound> getNuc44(){
        return getNucleotideCompoundSubstitutionMatrix("NUC44");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM10() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM10");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM100() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM100");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM110() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM110");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM120() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM120");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM130() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM130");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM140() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM140");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM150() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM150");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM160() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM160");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM170() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM170");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM180() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM180");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM190() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM190");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM20() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM20");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM200() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM200");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM210() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM210");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM220() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM220");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM230() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM230");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM240() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM240");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM260() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM260");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM270() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM280");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM280() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM280");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM290() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM290");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM30() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM30");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM300() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM300");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM310() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM310");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM320() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM320");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM330() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM330");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM340() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM340");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM350() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM350");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM360() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM360");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM370() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM370");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM380() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM380");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM390() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM390");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM40() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM40");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM400() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM400");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM410() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM410");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM420() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM420");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM430() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM430");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM440() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM440");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM450() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM450");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM460() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM460");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM470() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM470");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM480() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM480");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM490() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM490");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM50() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM50");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM500() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM500");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM60() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM60");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM70() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM70");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM80() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM80");
    }

    public static SubstitutionMatrix<AminoAcidCompound> getPAM90() {
        return getAminoAcidCompoundSubstitutionMatrix("PAM90");
    }

    // reads in a position specific scoring matrix from blastpgp
    public static SubstitutionMatrix<AminoAcidCompound> getAminoAcidCompoundPositionSpecificSubstitutionMatrix(String sequenceName, String suffix)
            throws MatrixNotFoundException{
        String fname = sequenceName+suffix;
        if (aminoAcidMatrices.containsKey(fname)) {
            return aminoAcidMatrices.get(fname);
        }

        PositionSpecificSubstitutionMatrix<AminoAcidCompound> matrix =
                new PositionSpecificSubstitutionMatrix<AminoAcidCompound>(
                        AminoAcidCompoundSet.getAminoAcidCompoundSet(), getReader(fname), fname);
        aminoAcidMatrices.put(fname, matrix);
        return matrix;

    }



    // reads in an amino acid substitution matrix, if necessary
    private static SubstitutionMatrix<AminoAcidCompound> getAminoAcidCompoundSubstitutionMatrix(String fname) {
        if (aminoAcidMatrices.containsKey(fname)) {
            return aminoAcidMatrices.get(fname);
        }

        SubstitutionMatrix<AminoAcidCompound> matrix = new SimpleSubstitutionMatrix<AminoAcidCompound>(
                    AminoAcidCompoundSet.getAminoAcidCompoundSet(), getReader(fname), fname);
        aminoAcidMatrices.put(fname, matrix);
        return matrix;

    }

    // reads in a nucleotide substitution matrix, if necessary
    private static SubstitutionMatrix<NucleotideCompound> getNucleotideCompoundSubstitutionMatrix(String fname) {
        if (nucleotideMatrices.containsKey(fname)) {
            return nucleotideMatrices.get(fname);
        }
        SubstitutionMatrix<NucleotideCompound> matrix = new SimpleSubstitutionMatrix<NucleotideCompound>(
                AmbiguityDNACompoundSet.getDNACompoundSet(), getReader(fname), fname);
        nucleotideMatrices.put(fname, matrix);
        return matrix;
    }

    // reads in a substitution matrix from a resource file
    private static InputStreamReader getReader(String fname) {
        return new InputStreamReader(MatrixUtil.class.getResourceAsStream(String.format("/%s",
                fname)));
    }
}