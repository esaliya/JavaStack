package org.saliya.memorymapped.ipc;

import mpi.Intracomm;
import mpi.MPI;
import net.openhft.lang.io.ByteBufferBytes;
import net.openhft.lang.io.Bytes;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class InterProcComm {
    static Bytes readBytes;
    static ByteBuffer readByteBuffer;
    static Bytes writeBytes;
    static ByteBuffer writeByteBuffer;
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        Intracomm comm = MPI.COMM_WORLD;
        int rank = comm.getRank();
        int size = comm.getSize();

        String mmapScratchDir = "/dev/shm/sekanaya";
        String collWriteFileName = MPI.getProcessorName() + ".test." + 0 + ".collwrite.bin";
        String collReadFileName = MPI.getProcessorName() + ".test." + 0 + ".collread.bin";
        try (FileChannel collWriteFc = FileChannel
                .open(Paths.get(mmapScratchDir, collWriteFileName),
                        StandardOpenOption.CREATE, StandardOpenOption.READ,
                        StandardOpenOption.WRITE);
             FileChannel collReadFc = FileChannel
                     .open(Paths.get(mmapScratchDir, collReadFileName),
                             StandardOpenOption.CREATE, StandardOpenOption.READ,
                             StandardOpenOption.WRITE)) {

            int collWriteByteExtent = 2*Integer.BYTES;
            int collReadByteExtent = 2*size*Integer.BYTES;


            readBytes = ByteBufferBytes.wrap(collReadFc.map(
                    FileChannel.MapMode.READ_WRITE, 0L,
                    collReadByteExtent));
            readByteBuffer = readBytes.sliceAsByteBuffer(readByteBuffer);

            writeBytes = ByteBufferBytes.wrap(collWriteFc.map(
                    FileChannel.MapMode.READ_WRITE, 0L,
                    collReadByteExtent));
            writeByteBuffer = writeBytes.sliceAsByteBuffer(writeByteBuffer);
        }



        /* reading through Bytes work, but using readByteBuffer.get methods
        *  won't show that consistency */
        /*readBytes.writeInt(2*rank*Integer.BYTES, rank);
        readBytes.writeInt((2*rank+1)*Integer.BYTES, 53);

        comm.barrier();
        if (rank == 3) {
            for (int i = 0; i < size; ++i) {
                System.out.println(
                        "++ r " + readBytes.readInt(2 * i * Integer.BYTES) +
                                " v " +
                                readBytes.readInt((2 * i + 1) * Integer.BYTES));

            }
        }*/

        writeBytes.writeInt(0, rank);
        writeBytes.writeInt(Integer.BYTES, 53);

        comm.allGather(writeByteBuffer, 2*Integer.BYTES, MPI.BYTE, readByteBuffer, 2*Integer.BYTES, MPI.BYTE);
        if (rank == 13){
            for (int i = 0; i < size; ++i){
                System.out.println("-- " + readBytes.readInt(2*i*Integer.BYTES) + " " + readBytes.readInt((2*i+1)*Integer.BYTES));
            }
        }
        comm.barrier();

        MPI.Finalize();
    }
}
