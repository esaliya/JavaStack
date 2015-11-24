package org.saliya.ompibenchmarks;
import com.google.common.base.Stopwatch;
import mpi.Intracomm;
import mpi.MPI;
import mpi.MPIException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
        String fname = args[3];
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
        final String msg = "R\t" + procRank + "\t TotalTime(ms)\t" + time
                           + "\tItr\t" + iter + "\tMyPoints\t" + myPointCount
                           + "\tMyBytes\t" + (myPointCount * dimension
                                              * Double.BYTES);
        printMessage(msg, procComm, procRank, procCount, fname);
        MPI.Finalize();
    }

    public static void printMessage(String msg, Intracomm procComm, int procRank, int procCount, String fname)

        throws MPIException {
        ByteBuffer flag = MPI.newByteBuffer(1);
        flag.put((byte)1);
        if (procRank != 0){
            procComm.recv(flag, 1, MPI.BYTE, procRank-1, 99);
        }
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fname),
            StandardOpenOption.APPEND, StandardOpenOption.CREATE)){
            PrintWriter printWriter = new PrintWriter(bw, true);
            printWriter.append(msg).append("\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (procRank != procCount -1)
        {
            procComm.send(flag, 1, MPI.BYTE, procRank+1, 99);
        }
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

        /* Let's add a barrier for cleaner timing */
        procComm.barrier();
        timer.start();
        // with separate send and recv buffers
        procComm.allGatherv(partialPointBuffer, lengths[procRank], MPI.DOUBLE, fullBuffer, lengths, displas, MPI.DOUBLE);

        // with inplace
//        procComm.allGatherv(fullBuffer, lengths, displas, MPI.DOUBLE);
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