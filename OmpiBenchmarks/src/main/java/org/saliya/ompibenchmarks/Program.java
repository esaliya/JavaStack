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

    public static void main(String[] args) throws MPIException {
        int pointCount = Integer.parseInt(args[0]);
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
        DoubleBuffer partialBuffer = MPI.newDoubleBuffer(myPointCount);
        DoubleBuffer fullBuffer = MPI.newDoubleBuffer(pointCount);
        for (int i = 0; i < iter; ++i) {
            generateRandomPoints(myPointCount, dimension, partialBuffer);
            timer.start();
            fullBuffer = allGather(partialBuffer, fullBuffer, dimension, myPointCount);
            timer.stop();
            time += timer.elapsed(TimeUnit.MILLISECONDS);
            timer.reset();
        }

        printMessage("Allgatherv time: " + time  + " ms");
        MPI.Finalize();
    }

    public static void printMessage(String msg) {
        if (procRank != 0) {
            return;
        }
        System.out.println(msg);
    }

    public static DoubleBuffer allGather(
        DoubleBuffer partialPointBuffer, DoubleBuffer fullBuffer, int dimension, int procRowCount) throws MPIException {

        int [] lengths = new int[procCount];
        int length = procRowCount * dimension;
        lengths[procRank] = length;
        procComm.allGather(lengths, 1, MPI.INT);
        int [] displas = new int[procCount];
        displas[0] = 0;
        System.arraycopy(lengths, 0, displas, 1, procCount - 1);
        Arrays.parallelPrefix(displas, (m, n) -> m + n);
        int count = IntStream.of(lengths).sum(); // performs very similar to usual for loop, so no harm done
        procComm.allGatherv(partialPointBuffer, length, MPI.DOUBLE, fullBuffer, lengths, displas, MPI.DOUBLE);
        return  fullBuffer;
    }

    private static void generateRandomPoints(
        int myPointCount, int dimension, DoubleBuffer partialBuffer) {
        partialBuffer.position(0);
        IntStream.range(0,myPointCount).forEach(i -> IntStream.range(0,dimension).forEach(j-> partialBuffer.put(
            Math.random())));
    }
}
