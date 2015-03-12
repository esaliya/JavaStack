package org.saliya.ompi.kmeans;

import com.google.common.base.Optional;
import com.google.common.base.Stopwatch;
import com.google.common.primitives.Doubles;
import mpi.MPI;
import mpi.MPIException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Program {
    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private static Options programOptions = new Options();

    static {
        programOptions.addOption("n", true, "Number of points");
        programOptions.addOption("d", true, "Dimensionality");
        programOptions.addOption("k", true, "Number of centers");
        programOptions.addOption("t", true, "Error threshold");
        programOptions.addOption("c", true, "Initial center file");
        programOptions.addOption("p", true, "Points file");
        programOptions.addOption("o", true, "Cluster assignment output file");
    }

    public static void main(String[] args) {
        Optional<CommandLine> parserResult = Utils.parseCommandLineArguments(args, programOptions);
        if (!parserResult.isPresent()) {
            System.out.println(Utils.ERR_PROGRAM_ARGUMENTS_PARSING_FAILED);
            new HelpFormatter().printHelp(Utils.PROGRAM_NAME, programOptions);
            return;
        }

        CommandLine cmd = parserResult.get();
        if (!(cmd.hasOption("n") && cmd.hasOption("d") && cmd.hasOption("k") && cmd.hasOption("t") &&
                cmd.hasOption("o") && cmd.hasOption("c") && cmd.hasOption("p"))) {
            System.out.println(Utils.ERR_INVALID_PROGRAM_ARGUMENTS);
            new HelpFormatter().printHelp(Utils.PROGRAM_NAME, programOptions);
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
            Stopwatch mainTimer = Stopwatch.createStarted();
            print("=== Program Started on " + dateFormat.format(new Date()) + " ===");
            print("  Reading points ... ");
            Stopwatch timer = Stopwatch.createStarted();
            double[][] points = readPoints(pointsFile, d, ParallelOptions.globalVecStartIdx, ParallelOptions.myNumVec);
            timer.stop();
            print("    Done in " + timer.elapsed(TimeUnit.MILLISECONDS) + " ms");
            timer.reset();
            print("  Reading centers ...");
            timer.start();
            double[][] centers = readCenters(centersFile, k, d);
            timer.stop();
            print("    Done in " + timer.elapsed(TimeUnit.MILLISECONDS) + " ms");
            timer.reset();

            DoubleBuffer doubleBuffer = MPI.newDoubleBuffer(k * d);
            IntBuffer intBuffer = MPI.newIntBuffer(k);
            IntBuffer intBuffer2 = MPI.newIntBuffer(n);

            double[][] centerSums = new double[k][d];
            int[] pointsPerCenter = new int[k];
            resetPointsPerCenter(pointsPerCenter);
            int[] clusterAssignments = new int[ParallelOptions.myNumVec];

            int itrCount = 0;
            boolean converged = false;
            print("  Computing K-Means .. ");
            Stopwatch loopTimer = Stopwatch.createStarted();
            Stopwatch commTimerWithCopy = Stopwatch.createUnstarted();
            Stopwatch commTimer = Stopwatch.createUnstarted();
            long [] times = new long[]{0,0,0};
            while (!converged) {
                ++itrCount;
                resetCenterSums(centerSums, d);
                resetPointsPerCenter(pointsPerCenter);
                for (int i = 0; i < ParallelOptions.myNumVec; ++i) {
                    double[] point = points[i];
                    int dMinIdx = findCenterWithMinDistance(point, centers);
                    ++pointsPerCenter[dMinIdx];
                    accumulate(point, centerSums, dMinIdx);
                    clusterAssignments[i] = dMinIdx;
                }
                commTimerWithCopy.start();
                copyToBuffer(centerSums, doubleBuffer);
                copyToBuffer(pointsPerCenter, intBuffer);
                commTimer.start();
                ParallelOptions.comm.allReduce(doubleBuffer, d * k, MPI.DOUBLE, MPI.SUM);
                commTimer.stop();
                copyFromBuffer(doubleBuffer, centerSums);
                commTimer.start();
                ParallelOptions.comm.allReduce(intBuffer, k, MPI.INT, MPI.SUM);
                commTimer.stop();
                copyFromBuffer(intBuffer, pointsPerCenter);
                commTimerWithCopy.stop();
                times[0] += commTimerWithCopy.elapsed(TimeUnit.MILLISECONDS);
                times[1] += commTimer.elapsed(TimeUnit.MILLISECONDS);
                commTimerWithCopy.reset();
                commTimer.reset();

                converged = true;
                for (int i = 0; i < k; ++i) {
                    double[] centerSum = centerSums[i];
                    int tmpI = i;
                    IntStream.range(0, d).forEach(j -> centerSum[j] /= pointsPerCenter[tmpI]);
                    double dist = getEuclideanDistance(centerSum, centers[i]);
                    if (dist > t) converged = false;
                }
                // Swap centerSums, which now contains the updated centers with original centers
                double[][] tmp = centers;
                centers = centerSums;
                centerSums = tmp;
            }
            loopTimer.stop();
            times[2] = loopTimer.elapsed(TimeUnit.MILLISECONDS);
            loopTimer.reset();

            ParallelOptions.comm.reduce(times, 3, MPI.LONG, MPI.SUM, 0);
            print("    Done in " + times[2] * 1.0 / ParallelOptions.size + " ms on average");
            print("    Avg. comm time " + times[1] * 1.0 / ParallelOptions.size + " ms");
            print("    Avg. comm time w/ copy" + times[0] * 1.0 / ParallelOptions.size + " ms");


            // Gather cluster assignments
            print("  Gathering cluster assignments ...");
            timer.start();
            int[] lengths = ParallelOptions.getLengthsArray(n);
            int[] displas = new int[n];
            displas[0] = 0;
            System.arraycopy(lengths, 0, displas, 1, n - 1);
            Arrays.parallelPrefix(displas, (p, q) -> p + q);
            intBuffer2.position(ParallelOptions.globalVecStartIdx);
            intBuffer2.put(clusterAssignments);
            ParallelOptions.comm.allGatherv(intBuffer2, lengths, displas, MPI.INT);
            timer.stop();
            long [] time = new long[]{timer.elapsed(TimeUnit.MILLISECONDS)};
            timer.reset();
            ParallelOptions.comm.reduce(time, 1, MPI.LONG, MPI.SUM, 0);
            print("    Done in " + time[0]*1.0/ParallelOptions.size + " ms on average");

            if (ParallelOptions.rank == 0) {
                print("  Writing output file ...");
                timer.start();
                try (PrintWriter writer = new PrintWriter(
                        Files.newBufferedWriter(Paths.get(outputFile), Charset.defaultCharset(),
                                                StandardOpenOption.CREATE, StandardOpenOption.WRITE), true)){
                    PointReader reader = PointReader.readRowRange(pointsFile, 0, n, d);
                    double [] point = new double[d];
                    for (int i = 0; i < n; ++i){
                        reader.getPoint(i, point);
                        writer.println(i + "\t" + Doubles.join("\t", point) + "\t" + intBuffer2.get(i));
                    }
                }
                timer.stop();
                print("    Done in " + timer.elapsed(TimeUnit.MILLISECONDS) + "ms");
                timer.reset();
            }
            mainTimer.stop();
            print("=== Program terminated successfully on " + dateFormat.format(new Date())  +" took " + (mainTimer.elapsed(TimeUnit.MILLISECONDS))  + " ms ===");

            ParallelOptions.endParallelism();
        } catch (MPIException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void resetPointsPerCenter(int[] pointsPerCenter) {
        int k = pointsPerCenter.length;
        IntStream.range(0, k).forEach(i -> pointsPerCenter[i] = 0);
    }


    private static void copyFromBuffer(IntBuffer buffer, int[] pointsPerCenter) {
        buffer.position(0);
        buffer.get(pointsPerCenter);
    }

    private static void copyFromBuffer(DoubleBuffer buffer, double[][] centerSums) {
        buffer.position(0);
        for (double[] centerSum : centerSums) {
            buffer.get(centerSum);
        }
    }

    private static void copyToBuffer(int[] pointsPerCenter, IntBuffer buffer) {
        buffer.position(0);
        buffer.put(pointsPerCenter);
    }

    private static void copyToBuffer(double[][] centerSums, DoubleBuffer buffer) {
        buffer.position(0);
        for (double[] centerSum : centerSums) {
            buffer.put(centerSum);
        }
    }

    private static void print(String msg) {
        if (ParallelOptions.rank == 0) {
            System.out.println(msg);
        }
    }

    private static int findCenterWithMinDistance(double[] point, double[][] centers) {
        int k = centers.length;
        double dMin = Double.MAX_VALUE;
        int dMinIdx = -1;
        for (int j = 0; j < k; ++j) {
            double dist = getEuclideanDistance(point, centers[j]);
            if (dist < dMin) {
                dMin = dist;
                dMinIdx = j;
            }
        }
        return dMinIdx;
    }

    private static void accumulate(double[] point, double[][] centerSums, int idx) {
        double[] center = centerSums[idx];
        for (int i = 0; i < center.length; ++i) {
            center[i] += point[i];
        }
    }

    private static double getEuclideanDistance(double[] point1, double[] point2) {
        int length = point1.length;
        double d = 0.0;
        for (int i = 0; i < length; ++i) {
            d += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(d);
    }

    private static void resetCenterSums(double[][] centerSums, int d) {
        Arrays.stream(centerSums).forEach(centerSum -> IntStream.range(0, d).forEach(i -> centerSum[i] = 0.0));
    }

    private static double[][] readPoints(String pointsFile, int d, int globalVecStartIdx, int myNumVec)
            throws IOException {
        double[][] points = new double[myNumVec][d];
        PointReader reader = PointReader.readRowRange(pointsFile, globalVecStartIdx, myNumVec, d);
        for (int i = 0; i < myNumVec; i++) {
            reader.getPoint(i + globalVecStartIdx, points[i]);
        }
        return points;
    }

    private static double[][] readCenters(String centersFile, int k, int d) throws IOException {
        double[][] centers = new double[k][d];
        PointReader reader = PointReader.readRowRange(centersFile, 0, k, d);
        for (int i = 0; i < k; i++) {
            reader.getPoint(i, centers[i]);
        }
        return centers;
    }


}
