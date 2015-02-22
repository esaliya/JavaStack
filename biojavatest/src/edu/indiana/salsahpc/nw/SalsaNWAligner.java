package edu.indiana.salsahpc.nw;

import java.util.ArrayList;
import java.util.List;

public class SalsaNWAligner extends edu.indiana.salsahpc.nw.SalsaDPPairwiseAligner {
    /// <summary>
    /// Tracks optimal score for alignment.
    /// </summary>
    private int optScore = Integer.MIN_VALUE;
    protected void ResetSpecificAlgorithmMemberVariables()
    {
        // Not strictly necessary since this will be set in the FillCell methods,
        // but it is good practice to initialize correctly.
        this.optScore = Integer.MIN_VALUE;
    }

    @Override
    public String getName() {
        return "Needleman-Wunsch";
    }

    @Override
    public String getDescription() {
        return "Pairwise global alignment";
    }

    @Override
     protected void SetRowBoundaryConditionAffine()
    {
        // Column 0
        ixGapScore[0] = Integer.MIN_VALUE / 2;
        maxScore[0] = 0;
        fSource[0] = SourceDirection.Left;

        for (int col = 1; col < numberOfCols; col++)
        {
            ixGapScore[col] = Integer.MIN_VALUE / 2;
            maxScore[col] = internalGapOpenCost + ((col - 1) * internalGapExtensionCost);
            fSource[col] = SourceDirection.Left;
        }
    }

    /// <summary>
    /// Sets matrix boundary conditions for zeroth column in NeedlemanWunsch global alignment.
    /// Uses affine gap penalty.
    /// </summary>
    /// <param name="row">Row number of cell.</param>
    /// <param name="cell">Cell number.</param>
    @Override
    protected void SetColumnBoundaryConditionAffine(short row, int cell)
    {
        iyGapScore = Integer.MIN_VALUE / 2; // Iy set to -infinity
        maxScoreDiagonal = maxScore[0]; // stored 0th cell of previous row.

        // sets (row, 0) for _MaxScore
        maxScore[0] = internalGapOpenCost + (row - 1) * internalGapExtensionCost;
        fSource[cell] = SourceDirection.Up;
    }

    /// <summary>
    /// Fills matrix cell specifically for NeedlemanWunsch - Uses affine gap penalty.
    /// Required because method is abstract in DynamicProgrammingPairwise
    /// To be removed once changes are made in SW, Pairwise algorithms.
    /// </summary>
    /// <param name="row">Row of cell.</param>
    /// <param name="col">Col of cell.</param>
    /// <param name="cell">Cell number.</param>
    @Override
    protected void FillCellAffine(short row, short col, int cell)
    {
        maxScore[col] = SetCellValuesAffine(row, col, cell);
    }

    /// <summary>
    /// Sets the score in last cell of _MaxScore to be the optimal score.
    /// </summary>
    @Override
    protected void SetOptimalScoreAffine()
    {
        // Trace back starts at lower right corner.
        // Save the score from this point.
        optScore = maxScore[numberOfCols - 1];
    }

    /// <summary>
    /// Performs traceback for global alignment.
    /// </summary>
    /// <param name="alignedSequences">List of aligned sequences (output).</param>
    /// <param name="offsets">Offset is the starting position of alignment
    /// of sequence1 with respect to sequence2.</param>
    /// <param name="startOffsets">Start indices of aligned sequences with respect to input sequences.</param>
    /// <param name="endOffsets">End indices of aligned sequences with respect to input sequences.</param>
    /// <param name="insertions">Insertions made to the aligned sequences.</param>
    /// <returns>Optimum score.</returns>
    @Override
    protected AlignedData Traceback() {
        List<byte[]> alignedSequences  = new ArrayList<byte[]>(2);
        List<Integer>offsets = new ArrayList<Integer>(2);
        List<Integer>startOffsets= new ArrayList<Integer>(2);
        List<Integer>endOffsets= new ArrayList<Integer>(2);
        List<Integer>insertions= new ArrayList<Integer>(2);

        // For NW, aligned sequence will be at least as long as longest input sequence.
        // May be longer if there are gaps in both aligned sequences.
        int guessLen = Math.max(firstInputSequence.length, secondInputSequence.length);

        endOffsets.add(firstInputSequence.length - 1);
        endOffsets.add(secondInputSequence.length - 1);

        List<Byte> alignedListA = new ArrayList<Byte>(guessLen);
        List<Byte> alignedListB = new ArrayList<Byte>(guessLen);

        // Start at the bottom left element of F and work backwards until we get to upper left
        short col, row;
        col = (short) (numberOfCols - 1);
        row = (short) (numberOfRows - 1);

        int colGaps = 0;
        int rowGaps = 0;

        // Since, numberOfCols * numberOfRows < Integer.MAX_VALUE
        int cell = ((int)numberOfCols * (int)numberOfRows) - 1;
        // stop when col and row are both zero
        while (cell > 0) {
            switch (fSource[cell]) {
                case SourceDirection.Diagonal:
                    // diagonal, no gap, use both sequence residues
                    alignedListA.add(firstInputSequence[col - 1]);
                    alignedListB.add(secondInputSequence[row - 1]);

                    col = (short) (col - 1);
                    row = (short) (row - 1);
                    // Todo: check with C# value
                    cell = cell - numberOfCols - 1;
                    break;

                case SourceDirection.Up:
                    // up, gap in a
                    alignedListA.add(gapCode);
                    alignedListB.add(secondInputSequence[row - 1]);

                    row = (short) (row - 1);
                    cell = cell - numberOfCols;
                    colGaps++;
                    break;

                case SourceDirection.Left:
                    // left, gap in b
                    alignedListA.add(firstInputSequence[col - 1]);
                    alignedListB.add(gapCode);

                    col = (short) (col - 1);
                    cell = cell - 1;
                    rowGaps++;
                    break;

                default:
                    System.out.println("Error in trace back");
            }
        }

        // Prepare solution, copy diagnostic data, turn aligned sequences around, etc
        // Be nice, turn aligned solutions around so that they match the input sequences
        int i, j; // utility indices used to reverse aligned sequences
        int len = alignedListA.size();
        byte[] alignedA = new byte[len];
        byte[] alignedB = new byte[len];
        for (i = 0, j = len - 1; i < len; i++, j--) {
            alignedA[i] = alignedListA.get(j);
            alignedB[i] = alignedListB.get(j);
        }

        alignedSequences.add(alignedA);
        alignedSequences.add(alignedB);

        insertions.add(colGaps);
        insertions.add(rowGaps);

        offsets.add(GetOffset(alignedA) - GetOffset(firstInputSequence));
        offsets.add(GetOffset(alignedB) - GetOffset(secondInputSequence));

        startOffsets.add(0);
        startOffsets.add(0);

        AlignedData ad = new AlignedData();
        ad.setAlignedSequences(alignedSequences);
        ad.setOffsets(offsets);
        ad.setStartOffsets(startOffsets);
        ad.setEndOffsets(endOffsets);
        ad.setInsertions(insertions);
        ad.setOptScore(optScore);
        return ad;
    }


    public short calculatePercentIdentityDistance(AlignedData ad) {
        byte[] s1 = ad.getAlignedSequences().get(0);
        byte[] s2 = ad.getAlignedSequences().get(1);

        // Modifying percent identity calculation only for the aligned portion.
        int firstNonGapIdx = Math.max(getNonGapIdx(s1, false), getNonGapIdx(s2, false));
        int lastNonGapIdx = Math.max(getNonGapIdx(s1, true), getNonGapIdx(s2, true));;

        float identity = 0.0f;
        //for (int i = 0; i < alignedSeqA.Count; i++)
        for (int i = firstNonGapIdx; i <= lastNonGapIdx; i++)
        {
            if (s1[i] == s2[i])
            {
                identity++;
            }
        }
        return (short) ((1 - (identity / ((lastNonGapIdx - firstNonGapIdx) + 1))) * Short.MAX_VALUE);
    }

    private int getNonGapIdx(byte[] s, boolean fromEnd) {
        int start, end,step;
        if (fromEnd) {
            start = s.length-1;
            step = -1;
        } else {
            start = 0;
            step = 1;
        }

        for (byte value : s) {
            if (s[start] != gapCode) {
                return start;
            }
            start += step;
        }
        return -1;
    }
}
