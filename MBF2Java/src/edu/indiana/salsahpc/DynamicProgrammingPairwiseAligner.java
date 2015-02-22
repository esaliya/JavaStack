package edu.indiana.salsahpc;

import java.util.ArrayList;
import java.util.List;

public abstract class DynamicProgrammingPairwiseAligner {
    protected byte gapCode = 45;
    protected int internalGapOpenCost;
    protected SimilarityMatrix internalSimilarityMatrix;
    protected Sequence secondInputSequence;
    protected Sequence firstInputSequence;
    protected int internalGapExtensionCost;
    protected short numberOfCols;
    protected short numberOfRows;
    protected int[] ixGapScore;
    protected int[] maxScore;
    protected byte[] fSource;
    protected int iyGapScore;
    protected int maxScoreDiagonal;

    /// <summary>
    /// Gets the name of the Aligner. Intended to be filled in
    /// by classes deriving from DynamicProgrammingPairwiseAligner class
    /// with the exact name of the Alignment algorithm.
    /// </summary>
    public abstract String getName();

    /// <summary>
    /// Gets the description of the Aligner. Intended to be filled in
    /// by classes deriving from DynamicProgrammingPairwiseAligner class
    /// with the exact details of the Alignment algorithm.
    /// </summary>
    public abstract String getDescription();

    /// <summary>
    /// Pairwise alignment of two sequences using an affine gap penalty.  The various algorithms in derived classes (NeedlemanWunsch,
    /// SmithWaterman, and PairwiseOverlap) all use this general engine for alignment with an affine gap penalty.
    /// </summary>
    /// <param name="localSimilarityMatrix">Scoring matrix.</param>
    /// <param name="gapOpenPenalty">Gap open penalty (by convention, use a negative number for this.).</param>
    /// <param name="gapExtensionPenalty">Gap extension penalty (by convention, use a negative number for this.).</param>
    /// <param name="inputA">First input sequence.</param>
    /// <param name="inputB">Second input sequence.</param>
    /// <returns>A list of sequence alignments.</returns>
    public List<AlignedData> align(
            SimilarityMatrix localSimilarityMatrix,
            int gapOpenPenalty,
            int gapExtensionPenalty,
            Sequence inputA,
            Sequence inputB) throws Exception {


        // Initialize and perform validations for alignment
        // In addition, initialize gap extension penalty.
        simpleAlignPrimer(localSimilarityMatrix, gapOpenPenalty, inputA, inputB);
        internalGapExtensionCost = gapExtensionPenalty;

        fillMatrixAffine();

        return traceback();
    }

    private void simpleAlignPrimer(SimilarityMatrix similarityMatrix, int gapPenalty, Sequence inputA, Sequence inputB) {
        resetSpecificAlgorithmMemberVariables();

        // Set Gap Penalty and Similarity Matrix
        internalGapOpenCost = gapPenalty;

        // note that _gapExtensionCost is not used for linear gap penalty
        this.internalSimilarityMatrix = similarityMatrix;

        firstInputSequence = inputA;
        secondInputSequence = inputB;
    }

    /// <summary>
    /// Resets member variables that are unique to a specific algorithm.
    /// These must be reset for each alignment, initialization in the constructor
    /// only works for the first call to AlignSimple.  This routine is called at the beginning
    /// of each AlignSimple method.
    /// </summary>
    protected abstract void resetSpecificAlgorithmMemberVariables();

    /// <summary>
    /// Fills matrix data for affine gap penalty implementation.
    /// </summary>
    protected void fillMatrixAffine() {
        numberOfCols = (short) (firstInputSequence.getCount() + 1);
        numberOfRows = (short) (secondInputSequence.getCount() + 1);
        ixGapScore = new int[numberOfCols];
        maxScore = new int[numberOfCols];
        int size = (int) numberOfRows * numberOfCols;
        fSource = new byte[size];

        // Fill by rows
        short row, col;
        int cell;
        // Set matrix bc along top row and left column.
        setRowBoundaryConditionAffine();

        for (row = 1, cell = numberOfCols; row < numberOfRows; row++) {
            setColumnBoundaryConditionAffine(row, cell);
            cell++;
            for (col = 1; col < numberOfCols; col++, cell++) {
                fillCellAffine(row, col, cell);
            }
        }

        setOptimalScoreAffine();
    }

    /// <summary>
    /// Sets boundary conditions for first row in dynamic programming matrix for affine gap penalty case.
    /// As in the FillCell methods, different algorithms will use different
    /// boundary conditions and will override this method.
    /// </summary>
    protected abstract void setRowBoundaryConditionAffine();

    /// <summary>
    /// Sets boundary conditions for the zeroth column in dynamic programming
    /// matrix for affine gap penalty case.
    /// As in the FillCell methods, different algorithms will use different
    /// boundary conditions and will override this method.
    /// </summary>
    /// <param name="row">Row number of cell.</param>
    /// <param name="cell">Cell number.</param>
    protected abstract void setColumnBoundaryConditionAffine(short row, int cell);

    /// <summary>
    /// Sets cell (row,col) of the matrix for affine gap implementation.  Different algorithms will use different scoring
    /// and traceback methods and therefore will override this method.
    /// Uses affine gap penalty.
    /// </summary>
    /// <param name="row">Row of cell to fill.</param>
    /// <param name="col">Col of cell to fill.</param>
    /// <param name="cell">Cell number.</param>
    protected abstract void fillCellAffine(short row, short col, int cell);

    /// <summary>
    /// Sets general case cell score and matrix elements for general affine gap case.
    /// </summary>
    /// <param name="row">Row of cell.</param>
    /// <param name="col">Col of cell.</param>
    /// <param name="cell">Cell number.</param>
    /// <returns>Score for cell.</returns>
    protected int setCellValuesAffine(short row, short col, int cell) {
        int score;
        int extnScore, openScore;

        // _MaxScoreDiagonal is max(M[row-1,col-1], Iy[row-1,col-1], Iy[row-1,col-1])
        int diagScore = maxScoreDiagonal + internalSimilarityMatrix.getValueAt(
                secondInputSequence.get(row - 1), firstInputSequence.get(col - 1));

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

        if (diagScore >= scoreX) {
            if (diagScore >= iyGapScore) {
                score = diagScore;
                fSource[cell] = SourceDirection.Diagonal;
            } else {
                score = iyGapScore;
                fSource[cell] = SourceDirection.Left;
            }
        } else {
            if (iyGapScore >= scoreX) {
                score = iyGapScore;
                fSource[cell] = SourceDirection.Left;
            } else {
                score = scoreX;
                fSource[cell] = SourceDirection.Up;
            }
        }

        return score;
    }

    /// <summary>
    /// Allows each algorithm to set optimal score at end of matrix construction
    /// Used for affine gap penalty.
    /// </summary>
    protected abstract void setOptimalScoreAffine();

    protected abstract List<AlignedData> traceback() throws Exception;

    protected List<AlignedData> collateResults(Sequence inputA,
                                               Sequence inputB,
                                               int alignmentCount,
                                               int optScore,
                                               List<byte[]> alignedSequences,
                                               List<Integer> offsets,
                                               List<Short> startOffsets,
                                               List<Short> endOffsets,
                                               List<Integer> insertions) {
        if (alignmentCount > 0)
        {
            List<AlignedData> alignments = new ArrayList<AlignedData>(alignmentCount);
            Sequence seq;
            AlignedData ad;
            byte[] alignedA, alignedB;

            for (int i = 0; i < alignedSequences.size(); i += 2)
            {
                ad  = new AlignedData(inputA, inputB);
                alignedA = alignedSequences.get(i);
                alignedB = alignedSequences.get(i + 1);
                ad.setScore(optScore);

                seq = new Sequence(alignedA, inputA.getId(), inputA.getAlphabet());
                ad.setFirstAlignedSequence(seq);

                seq = new Sequence(alignedB, inputB.getId(), inputB.getAlphabet());
                ad.setSecondAlignedSequence(seq);

                ad.setFirstOffset(offsets.get(i));
                ad.setSecondOffset(offsets.get(i + 1));

                ad.setFirstAlignedSequenceStartOffset(startOffsets.get(i));
                ad.setSecondAlignedSeqeunceStartOffset(startOffsets.get(i + 1));

                ad.setFirstAlignedSequenceEndOffset(endOffsets.get(i));
                ad.setSecondAlignedSeqeunceEndOffset(endOffsets.get(i + 1));

                ad.setFirstAlignedSequenceInsertionCount(insertions.get(i));
                ad.setSecondAlignedSeqeunceInsertionCount(insertions.get(i + 1));

                alignments.add(ad);
            }

            return alignments;
        }
        else
        {
            return new ArrayList<AlignedData>();
        }
    }
}
