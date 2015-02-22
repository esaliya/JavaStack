package edu.indiana.salsahpc;

import jaligner.matrix.Matrix;
import jaligner.matrix.MatrixLoader;
import jaligner.matrix.MatrixLoaderException;
import jaligner.ui.filechooser.NamedInputStream;
import java.util.HashMap;
import java.util.Map;

public class MatrixUtil {

    // Wrapper functions for existing matrices in BioJava //

    /**
     * Returns Blosum 100 matrix by Henikoff & Henikoff
     * @return Blosum 100 matrix
     */
    public static Matrix getBlosum100() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum100");
    }

    /**
     * Returns Blosum 30 matrix by Henikoff & Henikoff
     * @return Blosum 30 matrix
     */
    public static Matrix getBlosum30() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum30");
    }

    /**
     * Returns Blosum 35 matrix by Henikoff & Henikoff
     * @return Blosum 35 matrix
     */
    public static Matrix getBlosum35() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum35");
    }

    /**
     * Returns Blosum 40 matrix by Henikoff & Henikoff
     * @return Blosum 40 matrix
     */
    public static Matrix getBlosum40() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum40");
    }

    /**
     * Returns Blosum 45 matrix by Henikoff & Henikoff
     * @return Blosum 45 matrix
     */
    public static Matrix getBlosum45() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum45");
    }

    /**
     * Returns Blosum 50 matrix by Henikoff & Henikoff
     * @return Blosum 50 matrix
     */
    public static Matrix getBlosum50() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum50");
    }

    /**
     * Returns Blosum 55 matrix by Henikoff & Henikoff
     * @return Blosum 55 matrix
     */
    public static Matrix getBlosum55() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum55");
    }

    /**
     * Returns Blosum 60 matrix by Henikoff & Henikoff
     * @return Blosum 60 matrix
     */
    public static Matrix getBlosum60() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum60");
    }

    /**
     * Returns Blosum 62 matrix by Henikoff & Henikoff
     * @return Blosum 62 matrix
     */
    public static Matrix getBlosum62() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum62");
    }

    /**
     * Returns Blosum 65 matrix by Henikoff & Henikoff
     * @return Blosum 65 matrix
     */
    public static Matrix getBlosum65() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum65");
    }

    /**
     * Returns Blosum 70 matrix by Henikoff & Henikoff
     * @return Blosum 70 matrix
     */
    public static Matrix getBlosum70() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum70");
    }

    /**
     * Returns Blosum 75 matrix by Henikoff & Henikoff
     * @return Blosum 75 matrix
     */
    public static Matrix getBlosum75() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum75");
    }

    /**
     * Returns Blosum 80 matrix by Henikoff & Henikoff
     * @return Blosum 80 matrix
     */
    public static Matrix getBlosum80() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum80");
    }

    /**
     * Returns Blosum 85 matrix by Henikoff & Henikoff
     * @return Blosum 85 matrix
     */
    public static Matrix getBlosum85() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum85");
    }

    /**
     * Returns Blosum 90 matrix by Henikoff & Henikoff
     * @return Blosum 90 matrix
     */
    public static Matrix getBlosum90() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("blosum90");
    }

    /**
     * Returns PAM 250 matrix by Gonnet, Cohen & Benner
     * @return Gonnet 250 matrix
     */
    public static Matrix getGonnet250() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("gonnet250");
    }

    /**
     * Returns Nuc 4.2 matrix by Lowe
     * @return Nuc 4.2 matrix
     */
    public static Matrix getNuc4_2() throws MatrixLoaderException {
        return getNucleotideCompoundSubstitutionMatrix("nuc-4_2");
    }

    /**
     * Returns Nuc 4.4 matrix by Lowe
     * @return Nuc 4.4 matrix
     */
    public static Matrix getNuc4_4() throws MatrixLoaderException {
        return getNucleotideCompoundSubstitutionMatrix("nuc-4_4");
    }

    /**
     * Returns PAM 250 matrix by Dayhoff
     * @return PAM 250 matrix
     */
    public static Matrix getPAM250() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("pam250");
    }


    private static Map<String, Matrix> aminoAcidMatrices =
            new HashMap<String, Matrix>();
    private static Map<String, Matrix> nucleotideMatrices =
            new HashMap<String, Matrix>();

    // No instants
    private MatrixUtil() { }

    // Load other matrices //

    public static Matrix getBlosumN() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("BLOSUMN");
    }

    public static Matrix getDAYHOFF() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("DAYHOFF");
    }

    public static Matrix getEDNAFULL() throws MatrixLoaderException {
        return getNucleotideCompoundSubstitutionMatrix("EDNAFULL");
    }

    public static Matrix getIdentity() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("IDENTITY");
    }

    public static Matrix getMatch() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("MATCH");
    }

    public static Matrix getNuc44() throws MatrixLoaderException {
        return getNucleotideCompoundSubstitutionMatrix("NUC44");
    }

    public static Matrix getPAM10() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM10");
    }

    public static Matrix getPAM100() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM100");
    }

    public static Matrix getPAM110() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM110");
    }

    public static Matrix getPAM120() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM120");
    }

    public static Matrix getPAM130() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM130");
    }

    public static Matrix getPAM140() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM140");
    }

    public static Matrix getPAM150() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM150");
    }

    public static Matrix getPAM160() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM160");
    }

    public static Matrix getPAM170() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM170");
    }

    public static Matrix getPAM180() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM180");
    }

    public static Matrix getPAM190() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM190");
    }

    public static Matrix getPAM20() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM20");
    }

    public static Matrix getPAM200() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM200");
    }

    public static Matrix getPAM210() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM210");
    }

    public static Matrix getPAM220() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM220");
    }

    public static Matrix getPAM230() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM230");
    }

    public static Matrix getPAM240() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM240");
    }

    public static Matrix getPAM260() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM260");
    }

    public static Matrix getPAM270() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM280");
    }

    public static Matrix getPAM280() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM280");
    }

    public static Matrix getPAM290() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM290");
    }

    public static Matrix getPAM30() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM30");
    }

    public static Matrix getPAM300() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM300");
    }

    public static Matrix getPAM310() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM310");
    }

    public static Matrix getPAM320() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM320");
    }

    public static Matrix getPAM330() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM330");
    }

    public static Matrix getPAM340() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM340");
    }

    public static Matrix getPAM350() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM350");
    }

    public static Matrix getPAM360() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM360");
    }

    public static Matrix getPAM370() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM370");
    }

    public static Matrix getPAM380() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM380");
    }

    public static Matrix getPAM390() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM390");
    }

    public static Matrix getPAM40() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM40");
    }

    public static Matrix getPAM400() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM400");
    }

    public static Matrix getPAM410() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM410");
    }

    public static Matrix getPAM420() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM420");
    }

    public static Matrix getPAM430() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM430");
    }

    public static Matrix getPAM440() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM440");
    }

    public static Matrix getPAM450() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM450");
    }

    public static Matrix getPAM460() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM460");
    }

    public static Matrix getPAM470() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM470");
    }

    public static Matrix getPAM480() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM480");
    }

    public static Matrix getPAM490() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM490");
    }

    public static Matrix getPAM50() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM50");
    }

    public static Matrix getPAM500() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM500");
    }

    public static Matrix getPAM60() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM60");
    }

    public static Matrix getPAM70() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM70");
    }

    public static Matrix getPAM80() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM80");
    }

    public static Matrix getPAM90() throws MatrixLoaderException {
        return getAminoAcidCompoundSubstitutionMatrix("PAM90");
    }


    // reads in an amino acid substitution matrix, if necessary
    private static Matrix getAminoAcidCompoundSubstitutionMatrix(String fname) throws MatrixLoaderException {
        if (aminoAcidMatrices.containsKey(fname)) {
            return aminoAcidMatrices.get(fname);
        }

        Matrix matrix = MatrixLoader.load(getReader(fname));
        aminoAcidMatrices.put(fname, matrix);
        return matrix;

    }

    // reads in a nucleotide substitution matrix, if necessary
    private static Matrix getNucleotideCompoundSubstitutionMatrix(String fname) throws MatrixLoaderException {
        if (nucleotideMatrices.containsKey(fname)) {
            return nucleotideMatrices.get(fname);
        }
        Matrix matrix = MatrixLoader.load(getReader(fname));
        nucleotideMatrices.put(fname, matrix);
        return matrix;
    }

    // reads in a substitution matrix from a resource file
    private static NamedInputStream getReader(String fname) {
        return new NamedInputStream(fname, MatrixUtil.class.getResourceAsStream(String.format("/%s",fname)));
    }
}