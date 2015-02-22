package edu.indiana.salsahpc;

public class OptScoreCell {
    /// <summary>
    /// Column number of cell with optimal score.
    /// </summary>
    public short Column;

    /// <summary>
    /// Row number of cell with optimal score.
    /// </summary>
    public short Row;

    /// <summary>
    /// Cell number of cell with optimal score.
    /// </summary>
    public int Cell;

    /// <summary>
    /// Initializes a new instance of the OptScoreCell struct.
    /// Creates best score cell with the input position values.
    /// </summary>
    /// <param name="row">Row Number.</param>
    /// <param name="column">Column Number.</param>
    public OptScoreCell(short row, short column) {
        Row = row;
        Column = column;
        Cell = 0;
    }

    /// <summary>
    /// Initializes a new instance of the OptScoreCell struct.
    /// Creates best score cell with the input position values.
    /// </summary>
    /// <param name="row">Row Number.</param>
    /// <param name="column">Column Number.</param>
    /// <param name="cell">Cell Number.</param>
    public OptScoreCell(short row, short column, int cell) {
        this(row, column);
        Cell = cell;
    }

    /// <summary>
    /// Overrides == Operator.
    /// </summary>
    /// <param name="cell1">First cell.</param>
    /// <param name="cell2">Second cell.</param>
    /// <returns>Result of comparison.</returns>
    public boolean valEq(OptScoreCell cell) {
        return
                this.Row == cell.Row &&
                        this.Column == cell.Column &&
                        this.Cell == cell.Cell;
    }

    /// <summary>
    /// Overrides != Operator.
    /// </summary>
    /// <param name="cell1">First cell.</param>
    /// <param name="cell2">Second cell.</param>
    /// <returns>Result of comparison.</returns>
    public boolean valNotEq(OptScoreCell cell) {
        return !(this.valEq(cell));
    }

    /// <summary>
    /// Override Equals method.
    /// </summary>
    /// <param name="obj">Object for comparison.</param>
    /// <returns>Result of comparison.</returns>
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OptScoreCell)) {
            return false;
        }

        OptScoreCell other = (OptScoreCell) obj;
        return this.valEq(other);
    }
}

