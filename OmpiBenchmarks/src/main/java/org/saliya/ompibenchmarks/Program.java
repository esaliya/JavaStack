package org.saliya.ompibenchmarks;
import com.google.common.base.Stopwatch;
import mpi.Intracomm;
import mpi.MPI;
import mpi.MPIException;
import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Program {
    static int procRank;
    static int procCount;
    static Intracomm procComm;
    static int pointCount;

    public static void main(String[] args) throws MPIException {
        pointCount = Integer.parseInt(args[0]);
        int dimension = Integer.parseInt(args[1]);
        int iter = Integer.parseInt(args[2]);
        MPI.Init(args);
        procComm = MPI.COMM_WORLD;
        procRank = procComm.getRank();
        procCount = procComm.getSize();
        int q = pointCount / procCount;
        int r = pointCount % procCount;
        int myPointCount = r > 0 && procRank < r ? q+1 : q;
        long time = 0;
        Stopwatch timer = Stopwatch.createUnstarted();
        DoubleBuffer partialBuffer = MPI.newDoubleBuffer(myPointCount*dimension);
        DoubleBuffer fullBuffer = MPI.newDoubleBuffer(pointCount*dimension);
        for (int i = 0; i < iter; ++i) {
            generateRandomPoints(myPointCount, dimension, partialBuffer);
            time += allGather(partialBuffer, fullBuffer, dimension, timer);
        }
        printMessage("Allgatherv time: " + time  + " ms");
        MPI.Finalize();
    }

    public static void printMessage(String msg) {
        if (procRank != 0) return;
        System.out.println(msg);
    }

    public static long allGather(
        DoubleBuffer partialPointBuffer, DoubleBuffer fullBuffer, int dimension, Stopwatch timer) throws MPIException {
        int [] lengths = getLengthsArray(procCount, dimension);
        int [] displas = new int[procCount];
        displas[0] = 0;
        System.arraycopy(lengths, 0, displas, 1, procCount - 1);
        Arrays.parallelPrefix(displas, (m, n) -> m + n);

        fullBuffer.position(displas[procRank]);
        partialPointBuffer.position(0);
        fullBuffer.put(partialPointBuffer);

        timer.start();
        // with separate send and recv buffers
//        procComm.allGatherv(partialPointBuffer, lengths[procRank], MPI.DOUBLE, fullBuffer, lengths, displas, MPI.DOUBLE);

        // with inplace
        procComm.allGatherv(fullBuffer, lengths, displas, MPI.DOUBLE);
        timer.stop();
        long elapsedMills = timer.elapsed(TimeUnit.MILLISECONDS);
        timer.reset();
        return  elapsedMills;
    }

    private static int[] getLengthsArray(int procCount, int dimension) {
        int q = pointCount/procCount;
        int r = pointCount%procCount;
        int [] lengths = new int[procCount];
        IntStream.range(0,procCount).forEach(i->lengths[i] = dimension *(i < r ? q+1 : q));
        return lengths;
    }

    private static void generateRandomPoints(
        int myPointCount, int dimension, DoubleBuffer partialBuffer) {
        partialBuffer.position(0);
        IntStream.range(0,myPointCount).forEach(i -> IntStream.range(0,dimension).forEach(j-> partialBuffer.put(
            Math.random())));
    }
}