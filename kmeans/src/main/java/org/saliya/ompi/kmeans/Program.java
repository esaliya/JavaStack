package org.saliya.ompi.kmeans;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import mpi.MPI;
import mpi.MPIException;
import org.apache.commons.cli.*;

import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Program {
    private static Options programOptions = new Options();
    static {
        programOptions.addOption("n",true,"Number of points");
        programOptions.addOption("d",true,"Dimensionality");
        programOptions.addOption("k",true,"Number of centers");
        programOptions.addOption("t",true,"Error threshold");
        programOptions.addOption("c",false,"Initial center file");
        programOptions.addOption("p",false,"Points file");
        programOptions.addOption("o",true,"Cluster assignment output file");
    }

    public static void main(String[] args) {
        Optional<CommandLine> parserResult = parseCommandLineArguments(args, programOptions);
        if (!parserResult.isPresent()){
            System.out.println(Constants.ERR_PROGRAM_ARGUMENTS_PARSING_FAILED);
            new HelpFormatter().printHelp(Constants.PROGRAM_NAME, programOptions);
            return;
        }

        CommandLine cmd = parserResult.get();
        if (!(cmd.hasOption("n") && cmd.hasOption("d") && cmd.hasOption("k") && cmd.hasOption("o") && cmd.hasOption("t"))) {
            System.out.println(Constants.ERR_INVALID_PROGRAM_ARGUMENTS);
            new HelpFormatter().printHelp(Constants.PROGRAM_NAME, programOptions);
            return;
        }

        int n = Integer.parseInt(cmd.getOptionValue("n"));
        int d = Integer.parseInt(cmd.getOptionValue("d"));
        int k = Integer.parseInt(cmd.getOptionValue("k"));
        double t = Double.parseDouble(cmd.getOptionValue("t"));
        String outputFile = cmd.getOptionValue("o");
        String centersFile = cmd.hasOption("c") ? cmd.getOptionValue("c") : "";
        String pointsFile = cmd.hasOption("p") ? cmd.getOptionValue("p") : "";



        try {
            ParallelOptions.setupParallelism(args, n);
            double [][] points = Strings.isNullOrEmpty(pointsFile) ? generatePoints(d, ParallelOptions.myNumVec) : readPoints(pointsFile, ParallelOptions.globalVecStartIdx, ParallelOptions.myNumVec);
            double [][] centers = Strings.isNullOrEmpty(centersFile) ? generateCenters(k, d) : readCenters(centersFile);
            DoubleBuffer doubleBuffer = MPI.newDoubleBuffer(k*d);
            IntBuffer intBuffer = MPI.newIntBuffer(k);
            IntBuffer intBuffer2 = MPI.newIntBuffer(n);

            double [][] centerSums = new double[k][d];
            int [] pointsPerCenter = new int[k];
            IntStream.range(0, k).forEach(i -> pointsPerCenter[i] = 0);
            int [] clusterAssignments = new int[ParallelOptions.myNumVec];

            boolean converged = false;
            while (!converged){
                resetCenterSums(centerSums, d);
                for (int i = 0; i < ParallelOptions.myNumVec; ++i){
                    double [] point = points[i];
                    int dMinIdx = findCenterWithMinDistance(point, centers);
                    ++pointsPerCenter[dMinIdx];
                    accumulate(point, centerSums, dMinIdx);
                    clusterAssignments[i] = dMinIdx;
                }
                copyToBuffer(centerSums, doubleBuffer);
                copyToBuffer(pointsPerCenter, intBuffer);
                ParallelOptions.comm.allReduce(doubleBuffer, d*k, MPI.DOUBLE, MPI.SUM);
                copyFromBuffer(doubleBuffer, centerSums);
                ParallelOptions.comm.allReduce(intBuffer, k, MPI.INT, MPI.SUM);
                copyFromBuffer(intBuffer, pointsPerCenter);

                converged = true;
                for (int i = 0; i < k; ++i){
                    double [] centerSum = centerSums[i];
                    IntStream.range(0, d).forEach(j -> centerSum[j] /= pointsPerCenter[j]);
                    double dist = getEuclideanDistance(centerSum, centers[i]);
                    if (dist > t) converged = false;
                }
                // Swap centerSums, which now contains the updated centers with original centers
                double [][] tmp = centers;
                centers = centerSums;
                centerSums = tmp;
            }

            // Gather cluster assignments
            int [] lengths = ParallelOptions.getLengthsArray(n);
            int [] displas = new int[n];
            displas[0] = 0;
            System.arraycopy(lengths, 0, displas, 1, n - 1);
            Arrays.parallelPrefix(displas, (p, q) -> p + q);
            intBuffer2.position(ParallelOptions.globalVecStartIdx);
            intBuffer2.put(clusterAssignments);
            ParallelOptions.comm.allGatherv(intBuffer2, lengths, displas, MPI.INT);
            ParallelOptions.endParallelism();
        } catch (MPIException e) {
            e.printStackTrace();
        }
    }

    private static void copyFromBuffer(IntBuffer buffer, int [] pointsPerCenter){
        buffer.position(0);
        buffer.get(pointsPerCenter);
    }

    private static void copyFromBuffer(DoubleBuffer buffer, double[][] centerSums) {
        buffer.position(0);
        for (double [] centerSum : centerSums){
            buffer.get(centerSum);
        }
    }

    private static void copyToBuffer(int[] pointsPerCenter, IntBuffer buffer) {
        buffer.position(0);
        buffer.put(pointsPerCenter);
    }

    private static void copyToBuffer(double[][] centerSums, DoubleBuffer buffer) {
        buffer.position(0);
        for (double [] centerSum : centerSums){
            buffer.put(centerSum);
        }
    }

    private static int findCenterWithMinDistance(double [] point, double [][] centers){
        int k = centers.length;
        double dMin = Double.MAX_VALUE;
        int dMinIdx = -1;
        for (int j = 0; j < k; ++j) {
            double dist = getEuclideanDistance(point, centers[k]);
            if (dist < dMin){
                dMin = dist;
                dMinIdx = j;
            }
        }
        return dMinIdx;
    }

    private static void accumulate(double[] point, double[][] centerSums, int idx) {
        double [] center = centerSums[idx];
        for (int i = 0; i < center.length; ++i){
            center[i] += point[i];
        }
    }

    private static double getEuclideanDistance(double[] point1, double[] point2) {
        int length = point1.length;
        double d = 0.0;
        for (int i = 0; i < length; ++i){
            d += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(d);
    }

    private static void resetCenterSums(double[][] centerSums, int d) {
        Arrays.stream(centerSums).forEach(centerSum -> IntStream.range(0,d).forEach(i -> centerSum[i] = 0.0));
    }


    private static double[][] generateCenters(int k, int d) {
        final double [][] centers = new double[k][d];
        IntStream.range(0, k).parallel().forEach(
                i -> IntStream.range(0, d+1).parallel().forEach(j -> centers[i][j] = Math.random()));
        return centers;
    }

    private static double[][] generatePoints(int d, int myNumVec) {
        double [][] points = new double[myNumVec][d];
        IntStream.range(0, myNumVec).parallel().forEach(i -> IntStream.range(0, d).parallel().forEach(j -> points[i][j] = Math.random())); // -1 for assigned center
        return points;
    }

    private static double[][] readPoints(String pointsFile, int globalVecStartIdx, int myNumVec) {
        return new double[0][];
    }

    private static double[][] readCenters(String centersFile) {
        return new double[0][];
    }

    /**
     * Parse command line arguments
     * @param args Command line arguments
     * @param opts Command line options
     * @return An <code>Optional&lt;CommandLine&gt;</code> object
     */
    private static Optional<CommandLine> parseCommandLineArguments(String [] args, Options opts){

        CommandLineParser optParser = new GnuParser();

        try {
            return Optional.fromNullable(optParser.parse(opts, args));
        } catch (ParseException e) {
            System.out.println(e);
        }
        return Optional.fromNullable(null);
    }
}
