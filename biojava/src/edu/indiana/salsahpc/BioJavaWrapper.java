package edu.indiana.salsahpc;

import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.template.*;
import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.compound.AminoAcidCompoundSet;
import org.biojava3.core.sequence.compound.DNACompoundSet;
import org.biojava3.core.sequence.compound.NucleotideCompound;
import org.biojava3.core.sequence.template.AbstractCompoundSet;
import org.biojava3.core.sequence.template.AbstractSequence;
import org.biojava3.core.sequence.template.Compound;

import java.util.List;

public class BioJavaWrapper {

    /**
     * Calculates the percent identity distance between sequences <code>querySequence</code> and
     * <code>targetSequence</code> after aligning them globally using Needleman-Wunsch algorithm.
     * The sequences are treated as DNA sequences implicitly.
     *
     * @param querySequence  first DNA sequence as a string
     * @param targetSequence second DNA sequence
     * @param gapOpen        gap open penalty
     * @param gapExt         gap extension penalty
     * @param subMatrix      scoring matrix used to perform substitutions. Use <code>MatrixUtil</code> to get predefined
     *                       matrices.
     * @return the percent identity distance between aligned sequences.
     */
    public static short calculateDistance(
            String querySequence, String targetSequence, short gapOpen, short gapExt,
            SubstitutionMatrix<NucleotideCompound> subMatrix) {
        return calculateDistance(querySequence, targetSequence, gapOpen, gapExt, subMatrix, DistanceType.PercentIdentity);
    }

    /**
     * Calculates the distance between sequences <code>querySequence</code> and <code>targetSequence</code> after aligning them globally using
     * Needleman-Wunsch algorithm. The sequences are treated as DNA sequences implicitly.
     * The particular type of distance is specified through the <code>dist</code> parameter.
     *
     * @param querySequence  first DNA sequence as a string
     * @param targetSequence second DNA sequence
     * @param gapOpen        gap open penalty
     * @param gapExt         gap extension penalty
     * @param subMatrix      scoring matrix used to perform substitutions. Use <code>MatrixUtil</code> to get predefined
     *                       matrices.
     * @param dist           distance type. Use <code>DistanceType</code> enumerator to specify the particular type.
     * @return the calculated distance of the particular <code>DistanceType</code> between aligned sequences.
     */
    public static short calculateDistance(
            String querySequence, String targetSequence, short gapOpen, short gapExt,
            SubstitutionMatrix<NucleotideCompound> subMatrix, DistanceType dist) {
        DNASequence s1 = new DNASequence(querySequence);
        DNASequence s2 = new DNASequence(targetSequence);

        GapPenalty penalty = new SimpleGapPenalty(gapOpen, gapExt);

        SequencePair<DNASequence, NucleotideCompound> pair = Alignments.getPairwiseAlignment(
                s1, s2, Alignments.PairwiseSequenceAlignerType.GLOBAL, penalty, subMatrix);

        switch (dist) {
            /* Todo. These work only with DNASequences */
            /*case Kimura2:
                return calculateKimura2Distance(pair.getAlignedSequence(s1), pair.getAlignedSequence(s2));
            case JukesCantor:
                return calculateJukesCantorDistance(pair.getAlignedSequence(s1), pair.getAlignedSequence(s2));*/
            case PercentIdentity:
                return calculatePercentIdentityDistance(pair.getAlignedSequence(s1), pair.getAlignedSequence(s2));
            default:
                return calculatePercentIdentityDistance(pair.getAlignedSequence(s1), pair.getAlignedSequence(s2));
        }
    }

    public static <C extends Compound, S extends AbstractSequence<C>> AlignmentData calculateAlignment(
            S querySequence, S targetSequence, short gapOpen, short gapExt, SubstitutionMatrix<C> subMatrix, DistanceType dist) {
        return calculateAlignment(querySequence,  targetSequence,  gapOpen,  gapExt,  subMatrix,  subMatrix,  dist);
    }
    public static <C extends Compound, S extends AbstractSequence<C>> AlignmentData calculateAlignment(
            S querySequence, S targetSequence, short gapOpen, short gapExt, SubstitutionMatrix<C> subMatrix, SubstitutionMatrix<C> targetSubMatrix, DistanceType dist) {

        GapPenalty penalty = new SimpleGapPenalty(gapOpen, gapExt);
        PairwiseSequenceAligner<S,C> aligner = Alignments.getPairwiseAligner(
                querySequence, targetSequence, Alignments.PairwiseSequenceAlignerType.GLOBAL, penalty, subMatrix, targetSubMatrix);
        SequencePair<S, C> pair = aligner.getPair();

        short d;
        switch (dist) {
           /* Todo. These work only with DNASequences */
           /* case Kimura2:
                d= calculateKimura2Distance(pair.getAlignedSequence(querySequence), pair.getAlignedSequence(targetSequence));
                break;
            case JukesCantor:
                d= calculateJukesCantorDistance(pair.getAlignedSequence(querySequence), pair.getAlignedSequence(targetSequence));
                break;*/
            case PercentIdentity:
                d= calculatePercentIdentityDistance(pair.getAlignedSequence(querySequence), pair.getAlignedSequence(targetSequence));
                break;
            default:
                d= calculatePercentIdentityDistance(pair.getAlignedSequence(querySequence), pair.getAlignedSequence(targetSequence));
                break;
        }
        
        return new AlignmentData<C,S>(d,aligner.getScore(), aligner.getMinScore(), aligner.getMaxScore(), aligner.getPair(), querySequence, targetSequence);
    }

    public static SequencePair<DNASequence, NucleotideCompound> getPairSWG(
            String querySequence, String targetSequence, short gapOpen, short gapExt,
            SubstitutionMatrix<NucleotideCompound> subMatrix) {
        DNASequence s1 = new DNASequence(querySequence);
        DNASequence s2 = new DNASequence(targetSequence);

        GapPenalty penalty = new SimpleGapPenalty(gapOpen, gapExt);

        SequencePair<DNASequence, NucleotideCompound> pair = Alignments.getPairwiseAlignment(
                s1, s2, Alignments.PairwiseSequenceAlignerType.LOCAL, penalty, subMatrix);
        return pair;
    }

    public static SequencePair<DNASequence, NucleotideCompound> getPairNW(
            DNASequence s1, DNASequence s2, short gapOpen, short gapExt,
            SubstitutionMatrix<NucleotideCompound> matrix) {
        return Alignments.getPairwiseAlignment(
                s1, s2, Alignments.PairwiseSequenceAlignerType.GLOBAL, new SimpleGapPenalty(gapOpen, gapExt), matrix);
    }

    /**
     * Calculates Kimura2 distance for DNA sequence alignments.
     * @param s1 aligned DNA sequence
     * @param s2 aligned DNA sequence
     * @return Kimura2 distance
     */
    private static short calculateKimura2Distance(AlignedSequence<DNASequence, NucleotideCompound> s1,
                                                  AlignedSequence<DNASequence, NucleotideCompound> s2) {

        double length = 0;
        double gapCount = 0;
        double transitionCount = 0;    // P = A -> G | G -> A | C -> T | T -> C
        double transversionCount = 0;  // Q = A -> C | A -> T | C -> A | C -> G | T -> A  | T -> G | G -> T | G -> C

        NucleotideCompound A, C, T, G, gap;
        DNACompoundSet dnaCS = DNACompoundSet.getDNACompoundSet();

        A = dnaCS.getCompoundForString("A");
        C = dnaCS.getCompoundForString("C");
        T = dnaCS.getCompoundForString("T");
        G = dnaCS.getCompoundForString("G");
        gap = dnaCS.getCompoundForString("-");

        NucleotideCompound s1C, s2C;

        for (int i = 1; i <= s1.getLength(); i++) {
            length++;

            s1C = s1.getCompoundAt(i);
            s2C = s2.getCompoundAt(i);

            if (!s1C.equals(s2C)) {
                // Don't consider gaps at all in this computation;
                if (s1C.equals(gap) || s2C.equals(gap)) {
                    gapCount++;
                } else if ((s1C.equals(A) && s1C.equals(G)) ||
                        (s1C.equals(G) && s1C.equals(A)) ||
                        (s1C.equals(C) && s1C.equals(T)) ||
                        (s1C.equals(T) && s1C.equals(C))) {
                    transitionCount++;
                } else {
                    transversionCount++;
                }
            }
        }

        double P = transitionCount / (length - gapCount);
        double Q = transversionCount / (length - gapCount);

        double artificialDistance = 10;
        if (1.0 - (2.0 * P + Q) <= Double.MIN_VALUE || 1.0 - (2.0 * Q) <= Double.MIN_VALUE) {
            return (short) (artificialDistance * Short.MAX_VALUE);
        }

        double d = (-0.5 * Math.log(1.0 - 2.0 * P - Q) - 0.25 * Math.log(1.0 - 2.0 * Q));
        if (d > artificialDistance) {
            return (short) (artificialDistance * Short.MAX_VALUE);
        }
        return (short) (d * Short.MAX_VALUE);
    }

    /**
     * Calculates JukesCantor distance for DNA sequence alignments. This could be made to calculate for protein
     * sequences as well, but not implemented like that yet.
     * @param s1 aligned DNA sequence
     * @param s2 aligned DNA sequence
     * @return JukesCantor distance
     */
    private static short calculateJukesCantorDistance(AlignedSequence<DNASequence, NucleotideCompound> s1,
                                                      AlignedSequence<DNASequence, NucleotideCompound> s2) {

        double length = 0;
        double gapCount = 0;
        double differenceCount = 0;

        List<NucleotideCompound> list1 = s1.getAsList();
        List<NucleotideCompound> list2 = s2.getAsList();

        NucleotideCompound c1, c2, gap;

        gap = DNACompoundSet.getDNACompoundSet().getCompoundForString("-");
        for (int i = 0; i < list1.size(); i++) {
            length++;
            c1 = list1.get(i);
            c2 = list2.get(i);

            if (!c1.equalsIgnoreCase(c2)) {
                // Don't consider gaps at all in this computation;
                if (c1.equals(gap) || c2.equals(gap)) {
                    gapCount++;
                } else {
                    differenceCount++;
                }
            }
        }

        double d = 1.0 - ((4.0 / 3.0) * (differenceCount / (length - gapCount)));

        double artificialDistance = 10;
        if (d <= Double.MIN_VALUE) {
            return (short) (artificialDistance * Short.MAX_VALUE);
        }

        return (short) ((-0.75 * Math.log(d)) * Short.MAX_VALUE);

    }

    private static <C extends Compound, S extends AbstractSequence<C>> short calculatePercentIdentityDistance(
            AlignedSequence<S, C> s1, AlignedSequence<S, C> s2) {

        // Modifying percent identity calculation only for the aligned portion.
        int firstNonGapIdx = Math.max(s1.getStart().getPosition(), s2.getStart().getPosition());
        int lastNonGapIdx = Math.min(s1.getEnd().getPosition(), s2.getEnd().getPosition());

        float identity = 0.0f;
        for (int i = firstNonGapIdx; i <= lastNonGapIdx; i++) {
            if (s1.getCompoundAt(i).equalsIgnoreCase(s2.getCompoundAt(i))) {
                identity++;
            }

        }
        return (short) ((1 - (identity / ((lastNonGapIdx - firstNonGapIdx) + 1))) * Short.MAX_VALUE);
    }
}
