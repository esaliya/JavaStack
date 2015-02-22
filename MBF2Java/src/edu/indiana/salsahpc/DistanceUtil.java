package edu.indiana.salsahpc;

public class DistanceUtil {
    public static double computePercentIdentityDistance(AlignedData ad) {
        Sequence alignedSeqA = ad.getFirstAlignedSequence();
        Sequence alignedSeqB = ad.getSecondAlignedSequence();
        double identity = 0.0;
        for (int i = 0; i < alignedSeqA.getCount(); i++) {

            char ca = Character.toUpperCase((char) alignedSeqA.get(i));
            char cb = Character.toUpperCase((char) alignedSeqB.get(i));
            if (ca == cb) {
                identity++;
            }

        }
        return (1.0 - (identity / alignedSeqA.getCount()));
    }
    
    public static double computeMinMaxNormScoreDistance(AlignedData ad, SimilarityMatrix matrix, int gapOpen, int gapExt ){
        int firstSelfAlignedScore = ad.getFirstOriginalSequence().getSelfAlignedScore(matrix);
        int secondSelfAlignedScore = ad.getSecondOriginalSequence().getSelfAlignedScore(matrix);
        int maxS = Math.max(firstSelfAlignedScore,  secondSelfAlignedScore);
        // For SWG minimum score is zero
        int minS = 0;
        return (ad.getScore() - minS) * 1.0 / (maxS - minS);
    }
    
    public static double computeJukesCantorDistance(AlignedData ad) {
        double length = 0;
        double gapCount = 0;
        double differenceCount = 0;

        Sequence alignedSeqA = ad.getFirstAlignedSequence();
        Sequence alignedSeqB = ad.getSecondAlignedSequence();

        char gap = '-'; // upper case for this is the same
        char itemA;
        char itemB;


        for (int i = 0; i < alignedSeqA.getCount(); i++)
        {
            ++length;
            itemA = Character.toUpperCase((char)alignedSeqA.get(i)); //nucleotide 1
            itemB = Character.toUpperCase((char)alignedSeqB.get(i)); //nucleotide 2

            if (itemA != itemB)
            {
                // Don't consider gaps at all in this computation;
                if (itemA == gap || itemB == gap)
                {
                    gapCount++;
                }
                else
                {
                    differenceCount++;
                }
            }
        }

        double d = 1.0 - ((4.0 / 3.0) * (differenceCount / (length - gapCount)));

        double artificialDistance = Double.MAX_VALUE;
        if (d <= 0.0)
        {
            return artificialDistance;
        }

        return (-0.75 * Math.log(d));
    }
    
    public static double computeKimura2Distance(AlignedData ad) {
        double length = 0;
        double gapCount = 0;
        double transitionCount = 0;    // P = A -> G | G -> A | C -> T | T -> C
        double transversionCount = 0;  // Q = A -> C | A -> T | C -> A | C -> G | T -> A  | T -> G | G -> T | G -> C

        Sequence alignedSeqA = ad.getFirstAlignedSequence();
        Sequence alignedSeqB = ad.getSecondAlignedSequence();

        char gap = '-';
        char itemA;
        char itemB;
        char A = 'A';
        char T = 'T';
        char G = 'G';
        char C = 'C';
        char a = 'a';
        char t = 't';
        char g = 'g';
        char c = 'c';


        for (int i = 0; i < alignedSeqA.getCount(); i++)
        {
            ++length;
            itemA = Character.toUpperCase((char)alignedSeqA.get(i)); //nucleotide 1
            itemB = Character.toUpperCase((char)alignedSeqB.get(i)); //nucleotide 2

            if (itemA != itemB)
            {
                // Don't consider gaps at all in this computation;
                if (itemA == gap || itemB == gap)
                {
                    gapCount++;
                }
                else if (((itemA == A || itemA == a) && (itemB == G || itemB == g)) ||
                        ((itemA == G || itemA == g) && (itemB == A || itemB == a)) ||
                        ((itemA == C || itemA == c) && (itemB == T || itemB == t)) ||
                        ((itemA == T || itemA == t) && (itemB == C || itemB == c)))
                {
                    transitionCount++;
                }
                else
                {
                    transversionCount++;
                }
            }
        }

        double P = transitionCount / (length - gapCount);
        double Q = transversionCount / (length - gapCount);

        double artificialDistance = Double.MAX_VALUE;
        if (1.0 - (2.0 * P + Q) <= 0.0 || 1.0 - (2.0 * Q) <= 0.0)
        {
            return artificialDistance;
        }

        double d = (-0.5 * Math.log(1.0 - 2.0 * P - Q) - 0.25 * Math.log(1.0 - 2.0 * Q));
        if (d > artificialDistance)
        {
            return artificialDistance;
        }
        return d;
    }
    

    public static short computePercentIdentityDistanceAsShort(AlignedData ad) {
        return (short) (Short.MAX_VALUE * computePercentIdentityDistance(ad));
    }
}
