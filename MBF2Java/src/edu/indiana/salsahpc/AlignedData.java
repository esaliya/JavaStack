package edu.indiana.salsahpc;

import java.util.List;

public class AlignedData {
    Sequence firstOriginalSequence;
    Sequence secondOriginalSequence;
    Sequence firstAlignedSequence;
    Sequence secondAlignedSequence;

    int firstAlignedSequenceStartOffset;
    int secondAlignedSeqeunceStartOffset;
    int firstAlignedSequenceEndOffset;
    int secondAlignedSeqeunceEndOffset;

    int firstOffset, secondOffset;

    int firstAlignedSequenceInsertionCount;
    int secondAlignedSeqeunceInsertionCount;
    private short score;
    private short alignmentLength = -1;
    private short alignmentLengthExcludingEndGaps = -1;

    public AlignedData(Sequence firstOriginalSequence, Sequence secondOriginalSequence) {
        this.firstOriginalSequence = firstOriginalSequence;
        this.secondOriginalSequence = secondOriginalSequence;
    }

    public Sequence getFirstOriginalSequence() {
        return firstOriginalSequence;
    }

    public void setFirstOriginalSequence(Sequence firstOriginalSequence) {
        this.firstOriginalSequence = firstOriginalSequence;
    }

    public Sequence getSecondOriginalSequence() {
        return secondOriginalSequence;
    }

    public void setSecondOriginalSequence(Sequence secondOriginalSequence) {
        this.secondOriginalSequence = secondOriginalSequence;
    }

    public Sequence getFirstAlignedSequence() {
        return firstAlignedSequence;
    }

    public void setFirstAlignedSequence(Sequence firstAlignedSequence) {
        this.firstAlignedSequence = firstAlignedSequence;
    }

    public Sequence getSecondAlignedSequence() {
        return secondAlignedSequence;
    }

    public void setSecondAlignedSequence(Sequence secondAlignedSequence) {
        this.secondAlignedSequence = secondAlignedSequence;
    }

    public int getFirstAlignedSequenceStartOffset() {
        return firstAlignedSequenceStartOffset;
    }

    public void setFirstAlignedSequenceStartOffset(int firstAlignedSequenceStartOffset) {
        this.firstAlignedSequenceStartOffset = firstAlignedSequenceStartOffset;
    }

    public int getSecondAlignedSeqeunceStartOffset() {
        return secondAlignedSeqeunceStartOffset;
    }

    public void setSecondAlignedSeqeunceStartOffset(int secondAlignedSeqeunceStartOffset) {
        this.secondAlignedSeqeunceStartOffset = secondAlignedSeqeunceStartOffset;
    }

    public int getFirstAlignedSequenceEndOffset() {
        return firstAlignedSequenceEndOffset;
    }

    public void setFirstAlignedSequenceEndOffset(int firstAlignedSequenceEndOffset) {
        this.firstAlignedSequenceEndOffset = firstAlignedSequenceEndOffset;
    }

    public int getSecondAlignedSeqeunceEndOffset() {
        return secondAlignedSeqeunceEndOffset;
    }

    public void setSecondAlignedSeqeunceEndOffset(int secondAlignedSeqeunceEndOffset) {
        this.secondAlignedSeqeunceEndOffset = secondAlignedSeqeunceEndOffset;
    }

    public int getFirstAlignedSequenceInsertionCount() {
        return firstAlignedSequenceInsertionCount;
    }

    public void setFirstAlignedSequenceInsertionCount(int firstAlignedSequenceInsertionCount) {
        this.firstAlignedSequenceInsertionCount = firstAlignedSequenceInsertionCount;
    }

    public int getSecondAlignedSeqeunceInsertionCount() {
        return secondAlignedSeqeunceInsertionCount;
    }

    public void setSecondAlignedSeqeunceInsertionCount(int secondAlignedSeqeunceInsertionCount) {
        this.secondAlignedSeqeunceInsertionCount = secondAlignedSeqeunceInsertionCount;
    }

    public void setScore(int optScore) {
        score = (short)optScore;
    }

    public short getScore() {
        return score;
    }

    public int getFirstOffset() {
        return firstOffset;
    }

    public void setFirstOffset(int firstOffset) {
        this.firstOffset = firstOffset;
    }

    public int getSecondOffset() {
        return secondOffset;
    }

    public void setSecondOffset(int secondOffset) {
        this.secondOffset = secondOffset;
    }

    public String toString() {
        return firstAlignedSequence.toString() + "\n" + secondAlignedSequence.toString();
    }

    public short getAlignmentLengthExcludingEndGaps(){
        if (alignmentLengthExcludingEndGaps == -1){
            short startIndex =(short) Math.max(firstAlignedSequence.getFirstNonGapIndex(), secondAlignedSequence.getFirstNonGapIndex());
            short endIndex = (short)Math.min(firstAlignedSequence.getLastNonGapIndex(), secondAlignedSequence.getLastNonGapIndex());
            alignmentLengthExcludingEndGaps = (short)((endIndex - startIndex) + 1);
        }
        return alignmentLengthExcludingEndGaps;
    }

    public short getAlignmentLength(){
        if (alignmentLength == -1){
            // the two aligned sequences should have the same length
            alignmentLength = firstAlignedSequence.getCount();
        }
        return alignmentLength;
    }

    public short getNumberOfIdenticalBasePairs(boolean excludeGaps){
        byte gap = (byte)'-';
        short identity = 0;
        byte firstByte, secondByte;
        for (int i = 0; i < firstAlignedSequence.getCount(); i++) {
            firstByte = firstAlignedSequence.get(i);
            secondByte = secondAlignedSequence.get(i);
            if ( excludeGaps && (firstByte==gap || secondByte == gap)) continue;
            if (firstByte == secondByte) {
                identity++;
            }
        }
        return identity;
    }
}