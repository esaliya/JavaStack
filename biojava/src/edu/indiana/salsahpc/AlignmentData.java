package edu.indiana.salsahpc;

import org.biojava3.alignment.template.AlignedSequence;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.template.AbstractSequence;
import org.biojava3.core.sequence.template.Compound;

public class AlignmentData<C extends Compound, S extends AbstractSequence<C>> {
    private short distance;
    private int score;
    private int minScore;
    private int maxScore;
    private double normalizedScore;
    private SequencePair<S, C> pair;
    private S s1;
    private S s2;

    public AlignmentData(short distance, int score, int minScore, int maxScore, SequencePair<S, C> pair, S s1, S s2) {
        this.distance = distance;
        this.score = score;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.normalizedScore = (double)(score - minScore) / (double)(maxScore - minScore);
        this.pair = pair;
        this.s1 = s1;
        this.s2 = s2;
    }

    public short getDistance() {
        return this.distance;
    }

    public int getScore() {
        return this.score;
    }

    public SequencePair<S, C> getPair() {
        return this.pair;
    }

    public int getFirstAlignedSequenceStartOffset() {
        AlignedSequence as = this.pair.getAlignedSequence(this.s1);
        return as.getSequenceIndexAt(as.getStart().getPosition().intValue()) - 1;
    }

    public int getFirstAlignedSequenceEndOffset() {
        AlignedSequence as = this.pair.getAlignedSequence(this.s1);
        return as.getSequenceIndexAt(as.getEnd().getPosition().intValue()) - 1;
    }

    public int getSecondAlignedSequenceStartOffset() {
        AlignedSequence as = this.pair.getAlignedSequence(this.s2);
        return as.getSequenceIndexAt(as.getStart().getPosition().intValue()) - 1;
    }

    public int getSecondAlignedSequenceEndOffset() {
        AlignedSequence as = this.pair.getAlignedSequence(this.s2);
        return as.getSequenceIndexAt(as.getEnd().getPosition().intValue()) - 1;
    }

    public int getFirstSelfAlignedScore(SubstitutionMatrix<C> matrix) {
        return getSelfAlignedScore(this.s1, matrix);
    }

    public int getSecondSelfAlignedScore(SubstitutionMatrix<C> matrix) {
        return getSelfAlignedScore(this.s2, matrix);
    }

    public static <C extends Compound, S extends AbstractSequence<C>> int getSelfAlignedScore(S s, SubstitutionMatrix<C> matrix) {
        int selfAlignedScore = 0;

        for(int i = 1; i <= s.getLength(); ++i) {
            C c = s.getCompoundAt(i);
            selfAlignedScore += matrix.getValue(c, c);
        }

        return selfAlignedScore;
    }

    public int getNumIdenticals() {
        return this.pair.getNumIdenticals();
    }

    public int getAlignmentLengthExcludingEndGaps() {
        AlignedSequence as1 = this.pair.getAlignedSequence(this.s1);
        AlignedSequence as2 = this.pair.getAlignedSequence(this.s2);
        int start = Math.max(as1.getStart().getPosition().intValue(), as2.getStart().getPosition().intValue());
        int end = Math.min(as1.getEnd().getPosition().intValue(), as2.getEnd().getPosition().intValue());
        return end - start + 1;
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    public int getMinScore() {
        return this.minScore;
    }

    public double getNormalizedScore() {
        return this.normalizedScore;
    }
}
