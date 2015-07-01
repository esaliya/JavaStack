package org.saliya.ompi.kmeans.old;

import mpi.Intracomm;
import mpi.MPI;
import mpi.MPIException;

import java.util.stream.IntStream;

public class ParallelOptions
{

    public static int rank = 0;
    public static int size = 1;
    public static Intracomm comm;

    public static int myNumVec;
    public static int globalVecStartIdx;


    public static void setupParallelism(String[] args, int numVec)
        throws MPIException
    {
//        MPI.Init(args);
//        comm = MPI.COMM_WORLD;
//        rank = comm.getRank();
//        size = comm.getSize();
        decomposeDomain(numVec);
    }


    public static void endParallelism() throws MPIException
    {
//        MPI.Finalize();
    }

    private static void decomposeDomain(int numVec)
    {
        int div = numVec / size;
        int rem = numVec % size;
        myNumVec = rank < rem ? div + 1 : div;
        globalVecStartIdx = rank * div + (rank < rem ? rank : rem);
    }

    public static int[] getLengthsArray(int numVec)
    {
        int div = numVec / size;
        int rem = numVec % size;
        int[] lengths = new int[numVec];
        IntStream.range(0, numVec)
                 .forEach(i -> lengths[i] = i > rem ? div : div + 1);
        return lengths;
    }
}