package edu.indiana.salsahpc;

import java.util.ArrayList;
import java.util.List;

public class SmithWatermanAligner extends DynamicProgrammingPairwiseAligner {
    // SW begins traceback at cell with optimum score.  Use these variables
    // to track this in FillCell overrides.

    /// <summary>
    /// Stores details of all cells with best score.
    /// </summary>
    private List<OptScoreCell> optScoreCells = new ArrayList<OptScoreCell>();

    /// <summary>
    /// Tracks optimal score for alignment.
    /// </summary>
    private int optScore = Integer.MIN_VALUE;


    public String getName() {
        return "Smith-Waterman";
    }

    public String getDescription() {
        return "Pairwise local alignment";
    }

    /// <summary>
    /// Resets the members used to track optimum score and cell.
    /// </summary>
    protected void resetSpecificAlgorithmMemberVariables() {
        optScoreCells.clear();
        optScore = Integer.MIN_VALUE;
    }

    /// <summary>
    /// Sets matrix boundary conditions for zeroth row in SmithWaterman alignment.
    /// Uses affine gap penalty.
    /// </summary>
    protected void setRowBoundaryConditionAffine() {
        for (short col = 0; col < numberOfCols; col++) {
            ixGapScore[col] = Integer.MIN_VALUE / 2;
            maxScore[col] = 0;
            fSource[col] = SourceDirection.Stop; // no source for cells with 0
        }

        // Optimum score can be anywhere in the matrix.
        // These all have the same score, 0.
        // Track only cells with positive scores.
        optScore = 1;
        optScoreCells.clear();
    }

    /// <summary>
    /// Sets matrix boundary conditions for zeroth column in SmithWaterman alignment.
    /// Uses affine gap penalty.
    /// </summary>
    /// <param name="row">Row number of cell.</param>
    /// <param name="cell">Cell number.</param>
    protected void setColumnBoundaryConditionAffine(short row, int cell) {
        iyGapScore = Integer.MIN_VALUE / 2;
        maxScoreDiagonal = maxScore[0];
        fSource[cell] = SourceDirection.Stop; // no source for cells with 0
    }

    /// <summary>
    /// Fills matrix cell specifically for SmithWaterman - Uses affine gap penalty.
    /// </summary>
    /// <param name="row">Row of cell.</param>
    /// <param name="col">Col of cell.</param>
    /// <param name="cell">Cell number.</param>
    protected void fillCellAffine(short row, short col, int cell) {
        int score = setCellValuesAffine(row, col, cell);

        // SmithWaterman does not use negative scores, instead, if score is < 0
        // set score to 0 and stop the alignment at that point.
        if (score < 0) {
            score = 0;
            fSource[cell] = SourceDirection.Stop;
        }

        maxScore[col] = score;

        // SmithWaterman traceback begins at cell with optimum score, save it here.
        if (score > optScore) {
            // New high score found. Clear old cell lists.
            // Update score and add this cell info
            optScoreCells.clear();
            optScore = score;
            optScoreCells.add(new OptScoreCell(row, col, cell));
        } else if (score == optScore) {
            // One more high scoring cell found.
            // Add cell info to opt score cell list
            optScoreCells.add(new OptScoreCell(row, col, cell));
        }
    }

    /// <summary>
    /// Optimal score updated in fillCellAffine.
    /// So nothing to be done here.
    /// </summary>
    @Override
    protected void setOptimalScoreAffine() {
    }

    @Override
    protected List<AlignedData> traceback() throws Exception {
        List<byte[]> alignedSequences = new ArrayList<byte[]>(optScoreCells.size() * 2);
        List<Integer>offsets = new ArrayList<Integer>(optScoreCells.size() * 2);
        List<Short>startOffsets = new ArrayList<Short>(optScoreCells.size() * 2);
        List<Short>endOffsets = new ArrayList<Short>(optScoreCells.size() * 2);
        List<Integer>insertions = new ArrayList<Integer>(optScoreCells.size() * 2);

        short col, row;
        for(OptScoreCell optCell : optScoreCells)
        {
            // need an array we can extend if necessary
            // aligned array will be backwards, may be longer than original sequence due to gaps
            int guessLen = Math.max(firstInputSequence.getCount(), secondInputSequence.getCount());

            // TODO: Remove below cast
            List<Byte> alignedListA = new ArrayList<Byte>(guessLen);
            List<Byte> alignedListB = new ArrayList<Byte>(guessLen);

            // Start at the optimum element of F and work backwards
            col = optCell.Column;
            row = optCell.Row;
            endOffsets.add((short)(col - 1));
            endOffsets.add((short)(row - 1));

            int colGaps = 0;
            int rowGaps = 0;

            boolean done = false;

            int cell = optCell.Cell;
            while (!done) {
                // if next cell has score 0, we're done
                switch (fSource[cell]) {
                    case SourceDirection.Stop:
                        done = true;
                        break;

                    case SourceDirection.Diagonal:
                        // Diagonal, Aligned
                        alignedListA.add(firstInputSequence.get(col - 1));
                        alignedListB.add(secondInputSequence.get(row - 1));

                        col = (short) (col - 1);
                        row = (short) (row - 1);
                        cell = cell - numberOfCols - 1;
                        break;

                    case SourceDirection.Up:
                        // up, gap in A
                        alignedListA.add(gapCode);
                        alignedListB.add(secondInputSequence.get(row - 1));

                        row = (short) (row - 1);
                        cell = cell - numberOfCols;
                        colGaps++;
                        break;

                    case SourceDirection.Left:
                        // left, gap in B
                        alignedListA.add(firstInputSequence.get(col - 1));
                        alignedListB.add(gapCode);

                        col = (short) (col - 1);
                        cell = cell - 1;
                        rowGaps++;
                        break;

                    default:
                        // error condition, should never see this
                        String message = "SmithWatermanAligner : Bad source in traceback.";
                        throw new Exception(message);
                }
            }

            // Offset is start of alignment in input sequence with respect to other sequence.
            if (col - row >= 0) {
                offsets.add(0);
                offsets.add(col - row);
            } else {
                offsets.add(-(col - row));
                offsets.add(0);
            }

            startOffsets.add(col);
            startOffsets.add(row);

            insertions.add(colGaps);
            insertions.add(rowGaps);

            // prepare solution, copy diagnostic data, turn aligned sequences around, etc
            // Be nice, turn aligned solutions around so that they match the input sequences
            int i, j; // utility indices used to invert aligned sequences
            int len = alignedListA.size();
            byte[] alignedA = new byte[len];
            byte[] alignedB = new byte[len];
            for (i = 0, j = len - 1; i < len; i++, j--) {
                alignedA[i] = alignedListA.get(j);
                alignedB[i] = alignedListB.get(j);
            }

            alignedSequences.add(alignedA);
            alignedSequences.add(alignedB);
        }

        return collateResults(firstInputSequence, secondInputSequence,
                optScoreCells.size(), optScore, alignedSequences,
                offsets, startOffsets, endOffsets, insertions);
    }


}
