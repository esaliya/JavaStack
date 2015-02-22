package edu.indiana.salsahpc.nw;

import java.util.List;

public class AlignedData {
    List<byte[]> alignedSequences;
    List<Integer> offsets;
    List<Integer> startOffsets;
    List<Integer> endOffsets;
    List<Integer> insertions;
    int optScore;

    String firstAlignedSequence, secondAlignedSequence;

    public List<byte[]> getAlignedSequences() {
        return alignedSequences;
    }

    public void setAlignedSequences(List<byte[]> alignedSequences) {
        this.alignedSequences = alignedSequences;
    }

    public List<Integer> getOffsets() {
        return offsets;
    }

    public void setOffsets(List<Integer> offsets) {
        this.offsets = offsets;
    }

    public List<Integer> getStartOffsets() {
        return startOffsets;
    }

    public void setStartOffsets(List<Integer> startOffsets) {
        this.startOffsets = startOffsets;
    }

    public List<Integer> getEndOffsets() {
        return endOffsets;
    }

    public void setEndOffsets(List<Integer> endOffsets) {
        this.endOffsets = endOffsets;
    }

    public List<Integer> getInsertions() {
        return insertions;
    }

    public void setInsertions(List<Integer> insertions) {
        this.insertions = insertions;
    }

    public int getOptScore() {
        return optScore;
    }

    public void setOptScore(int optScore) {
        this.optScore = optScore;
    }

    public String getFirstAlignedSequence() {
        if (firstAlignedSequence == null) {
            firstAlignedSequence = new String(alignedSequences.get(0));
        }
        return firstAlignedSequence;
    }

    public String getSecondAlignedSequence() {
        if (secondAlignedSequence == null) {
            secondAlignedSequence = new String(alignedSequences.get(1));
        }
        return secondAlignedSequence;
    }

}