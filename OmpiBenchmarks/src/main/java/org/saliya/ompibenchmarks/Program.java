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
    static int worldProcRank;
    static int worldProcsCount;
    static Intracomm worldProcsComm;
    static int pointCount;
    
    static int[] lengths;
    static int[] displas;

    public static void main(String[] args) throws MPIException {
        pointCount = Integer.parseInt(args[0]);
        int dimension = Integer.parseInt(args[1]);
        int iter = Integer.parseInt(args[2]);
        MPI.Init(args);
        worldProcsComm = MPI.COMM_WORLD;
        worldProcRank = worldProcsComm.getRank();
        worldProcsCount = worldProcsComm.getSize();
        int q = pointCount / worldProcsCount;
        int r = pointCount % worldProcsCount;
        int myPointCount = r > 0 && worldProcRank < r ? q + 1 : q;
        long time = 0;
        Stopwatch timer = Stopwatch.createUnstarted();
        DoubleBuffer partialBuffer = MPI.newDoubleBuffer(myPointCount*dimension);
        DoubleBuffer fullBuffer = MPI.newDoubleBuffer(pointCount*dimension);
        DoubleBuffer timeBuffer = MPI.newDoubleBuffer(1);
        
        /* Compute lengths and displacements */
        lengths = getLengthsArray(worldProcsCount, dimension);
        displas = new int[worldProcsCount];
        displas[0] = 0;
        System.arraycopy(lengths, 0, displas, 1, worldProcsCount - 1);
        Arrays.parallelPrefix(displas, (m, n) -> m + n);
        
        /* Generate points - these are not random numbers */
        generatePoints(myPointCount, dimension, partialBuffer);

        for (int i = 0; i < iter; ++i) {
            time += allGather(partialBuffer, fullBuffer, dimension, timer);
        }

        timeBuffer.put(0, time);
        worldProcsComm.reduce(timeBuffer,1,MPI.DOUBLE,MPI.MIN,0);
        double minTime = timeBuffer.get(0);
        timeBuffer.put(0, time);
        worldProcsComm.reduce(timeBuffer,1,MPI.DOUBLE,MPI.MAX,0);
        double maxTime = timeBuffer.get(0);
        timeBuffer.put(0, time);
        worldProcsComm.reduce(timeBuffer,1,MPI.DOUBLE,MPI.SUM,0);
        double avgTime = timeBuffer.get(0) / worldProcsCount;
        printMessage("Allgatherv time in R0 and min max avg in ms: " + time + "\t" + minTime + "\t" + maxTime + "\t" + avgTime);
        MPI.Finalize();
    }

    public static void printMessage(String msg) {
        if (worldProcRank != 0) return;
        System.out.println(msg);
    }

    public static long allGather(
        DoubleBuffer partialPointBuffer, DoubleBuffer fullBuffer, int dimension, Stopwatch timer) throws MPIException {

        worldProcsComm.barrier();
        timer.start();
        worldProcsComm.allGatherv(partialPointBuffer, lengths[worldProcRank], MPI.DOUBLE, fullBuffer, lengths, displas, MPI.DOUBLE);
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

    private static void generatePoints(
        int myPointCount, int dimension, DoubleBuffer partialBuffer) {
        partialBuffer.position(0);
        IntStream.range(0,myPointCount).forEach(i -> IntStream.range(0,dimension).forEach(j-> partialBuffer.put(
                (((i + j) & 1) == 0 ?
                        (0.9999995 / 1.0000023) :
                        (1.0000023 / 0.9999995)))));
    }
}