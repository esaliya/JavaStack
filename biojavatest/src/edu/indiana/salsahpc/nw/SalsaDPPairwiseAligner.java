package edu.indiana.salsahpc.nw;

import java.util.List;

public abstract class SalsaDPPairwiseAligner {
    protected  byte gapCode = 45;

    /// <summary> Similarity matrix for use in alignment algorithms. </summary>
    protected SimilarityMatrix internalSimilarityMatrix;

    /// <summary>
    /// Gap open penalty for use in alignment algorithms.
    /// For alignments using a linear gap penalty, this is the gap penalty.
    /// For alignments using an affine gap, this is the penalty to open a new gap.
    /// This is a negative number, for example _gapOpenCost = -8, not +8.
    /// </summary>
    protected int internalGapOpenCost;

    /// <summary>
    /// Gap extension penalty for use in alignment algorithms.
    /// Not used for alignments using a linear gap penalty.
    /// For alignments using an affine gap, this is the penalty to extend an existing gap.
    /// This is a negative number, for example _gapExtensionCost = -2, not +2.
    /// </summary>
    protected int internalGapExtensionCost;

    /// <summary>
    /// FScoreDiagonal is used to store diagonal value from previous row.
    /// Used for Gotoh optimization of linear gap penalty.
    /// </summary>
    protected int fScoreDiagonal;

    // Note that the dynamic programming matrix is coded as separate arrays.  Structs allocate space on 4 byte
    // boundaries, leading to some memory inefficiency.

    /// <summary>
    /// FSource stores the source for the each cell in the F matrix.
    /// Source is coded as 0 diagonal, 1 up, 2 left, see enum SourceDirection below.
    /// </summary>
    protected byte[] fSource; // source for cell

    /// <summary>
    /// MaxScore stores the maximum value for the affine gap penalty implementation.
    /// </summary>
    protected int[] maxScore; // best score of alignment x1...xi to y1...yi

    /// <summary>
    /// MaxScoreDiagonal is used to store maximum value from previous row.
    /// Used for Gotoh optimization of affine gap penalty.
    /// </summary>
    protected int maxScoreDiagonal;

    /// <summary>
    /// Stores alignment score for putting gap in 'x' sequence for affine gap penalty implementation.
    /// Alignment score if xi aligns to a gap after yi.
    /// </summary>
    protected int[] ixGapScore;

    /// <summary>
    /// Stores alignment score for putting gap in 'y' sequence for affine gap penalty implementation.
    /// Alignment score if yi aligns to a gap after xi.
    /// </summary>
    protected int iyGapScore;

    /// <summary>
    /// Number of rows in the dynamic programming matrix.
    /// </summary>
    protected short numberOfRows;

    /// <summary>
    /// Number of columns in the dynamic programming matrix.
    /// </summary>
    protected short numberOfCols;

    /// <summary>
    /// First input sequence.
    /// </summary>
    protected byte[] firstInputSequence;

    /// <summary>
    /// Second input sequence.
    /// </summary>
    protected byte[] secondInputSequence;

    protected SalsaDPPairwiseAligner()
    { }

    public SimilarityMatrix getInternalSimilarityMatrix() {
        return internalSimilarityMatrix;
    }

    public void setInternalSimilarityMatrix(SimilarityMatrix internalSimilarityMatrix) {
        this.internalSimilarityMatrix = internalSimilarityMatrix;
    }

    public int getInternalGapOpenCost() {
        return internalGapOpenCost;
    }

    public void setInternalGapOpenCost(int internalGapOpenCost) {
        this.internalGapOpenCost = internalGapOpenCost;
    }

    public int getInternalGapExtensionCost() {
        return internalGapExtensionCost;
    }

    public void setInternalGapExtensionCost(int internalGapExtensionCost) {
        this.internalGapExtensionCost = internalGapExtensionCost;
    }



    public AlignedData Align(
            SimilarityMatrix localSimilarityMatrix,
            int gapOpenPenalty,
            int gapExtensionPenalty,
            String inputA,
            String inputB) {

        // Initialize and perform validations for alignment
        // In addition, initialize gap extension penalty.
        SimpleAlignPrimer(localSimilarityMatrix, gapOpenPenalty, inputA, inputB);
        internalGapExtensionCost = gapExtensionPenalty;

        FillMatrixAffine();

        AlignedData ad = Traceback();
        return ad;
//        return CollateResults(inputA, inputB, tbd);
//        return null;
    }

      protected void FillMatrixAffine()
      {
          // Assumed: input length + 1 < Short.MAX_VALUE
          numberOfCols = (short)(firstInputSequence.length + 1);
          numberOfRows = (short)(secondInputSequence.length + 1);
          ixGapScore = new int[numberOfCols];
          maxScore = new int[numberOfCols];
          int size = (int)numberOfRows * numberOfCols;
          fSource = new byte[size];
          // Set matrix boundary condition along top row and left column.

          SetRowBoundaryConditionAffine();
          short row, col;
          int cell;
          for (row = 1, cell = numberOfCols; row < numberOfRows; row++)
          {
              SetColumnBoundaryConditionAffine(row, cell);
              cell++;
              for (col = 1; col < numberOfCols; col++, cell++)
              {
                  FillCellAffine(row, col, cell);
              }
          }
          SetOptimalScoreAffine();
      }

    /// <summary>
    /// Sets general case cell score and matrix elements for general affine gap case.
    /// </summary>
    /// <param name="row">Row of cell.</param>
    /// <param name="col">Col of cell.</param>
    /// <param name="cell">Cell number.</param>
    /// <returns>Score for cell.</returns>
    protected int SetCellValuesAffine(short row, short col, int cell)
    {
        int score;
        int extnScore, openScore;

        // _MaxScoreDiagonal is max(M[row-1,col-1], Iy[row-1,col-1], Iy[row-1,col-1])
        int diagScore = maxScoreDiagonal + internalSimilarityMatrix.getValueAt(
                secondInputSequence[row - 1],firstInputSequence[col - 1]);

        // ~ Ix = _M[row - 1, col] + _gapOpenCost, _Ix[row - 1, col] + _gapExtensionCost);
        extnScore = ixGapScore[col] + internalGapExtensionCost;
        openScore = maxScore[col] + internalGapOpenCost;
        int scoreX = (extnScore >= openScore) ? extnScore : openScore;
        ixGapScore[col] = scoreX;

        // ~ Iy = Max(_M[row, col - 1] + _gapOpenCost, _Iy[row, col - 1] + _gapExtensionCost);
        extnScore = iyGapScore + internalGapExtensionCost;
        openScore = maxScore[col - 1] + internalGapOpenCost;
        iyGapScore = (extnScore >= openScore) ? extnScore : openScore;

        maxScoreDiagonal = maxScore[col];

        if (diagScore >= scoreX)
        {
            if (diagScore >= iyGapScore)
            {
                score = diagScore;
                fSource[cell] = SourceDirection.Diagonal;
            }
            else
            {
                score = iyGapScore;
                fSource[cell] = SourceDirection.Left;
            }
        }
        else
        {
            if (iyGapScore >= scoreX)
            {
                score = iyGapScore;
                fSource[cell] = SourceDirection.Left;
            }
            else
            {
                score = scoreX;
                fSource[cell] = SourceDirection.Up;
            }
        }
        return score;
    }

    private void SimpleAlignPrimer(SimilarityMatrix similarityMatrix, int gapPenalty, String inputA, String inputB)
    {
        ResetSpecificAlgorithmMemberVariables();

        // Set Gap Penalty and Similarity Matrix
        internalGapOpenCost = gapPenalty;

        // note that _gapExtensionCost is not used for linear gap penalty
        this.internalSimilarityMatrix = similarityMatrix;

//        ValidateAlignInput(inputA, inputB);  // throws exception if input not valid

        // Convert input strings to 0-based int arrays using similarity matrix mapping
        firstInputSequence = inputA.getBytes();
        secondInputSequence = inputB.getBytes();
    }

    /// <summary>
    /// Return the starting position of alignment of sequence1 with respect to sequence2.
    /// </summary>
    /// <param name="aligned">Aligned sequence.</param>
    /// <returns>The number of initial gap characters.</returns>
    protected int GetOffset(byte[] aligned)
    {
        int ret = 0;
        for (byte item : aligned)
        {
            if (item != gapCode)
            {
                return ret;
            }
            ++ret;
        }
        return ret;
    }

    public abstract String getName();

    public abstract String getDescription();

    /// <summary>
    /// Sets cell (row,col) of the matrix for affine gap implementation.  Different algorithms will use different scoring
    /// and traceback methods and therefore will override this method.
    /// Uses affine gap penalty.
    /// </summary>
    /// <param name="row">Row of cell to fill.</param>
    /// <param name="col">Col of cell to fill.</param>
    /// <param name="cell">Cell number.</param>
    protected abstract void FillCellAffine(short row, short col, int cell);

    /// <summary>
    /// Sets boundary conditions for the zeroth column in dynamic programming
    /// matrix for affine gap penalty case.
    /// As in the FillCell methods, different algorithms will use different
    /// boundary conditions and will override this method.
    /// </summary>
    /// <param name="row">Row number of cell.</param>
    /// <param name="cell">Cell number.</param>
    protected abstract void SetColumnBoundaryConditionAffine(short row, int cell);

    /// <summary>
    /// Sets boundary conditions for first row in dynamic programming matrix for affine gap penalty case.
    /// As in the FillCell methods, different algorithms will use different
    /// boundary conditions and will override this method.
    /// </summary>
    protected abstract void SetRowBoundaryConditionAffine();

    protected abstract void ResetSpecificAlgorithmMemberVariables();

    protected abstract void SetOptimalScoreAffine();

    /// <summary> Direction to source of cell value, used during traceback. </summary>
    protected static class SourceDirection
    {
        // This is coded as a set of consts rather than using an enum.  Enums are ints and
        // referring to these in the code requires casts to and from (sbyte), which makes
        // the code more difficult to read.

        /// <summary> Source was up and left from current cell. </summary>
        public static final byte Diagonal = 0;

        /// <summary> Source was up from current cell. </summary>
        public static final byte Up = 1;

        /// <summary> Source was left of current cell. </summary>
        public static final byte Left = 2;

        /// <summary> During traceback, stop at this cell (used by SmithWaterman). </summary>
        public static final byte Stop = -1;

        /// <summary> Error code, if cell has code Invalid error has occurred. </summary>
        public static final byte Invalid = -2;
    }

    protected abstract AlignedData Traceback();


}


