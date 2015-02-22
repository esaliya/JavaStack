package edu.indiana.salsahpc;

public class SourceDirection {
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
