package org.saliya.memorymapped.ipc;

import mpi.Intracomm;
import mpi.MPI;
import net.openhft.lang.io.ByteBufferBytes;
import net.openhft.lang.io.Bytes;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InterProcComm {
    static Bytes readBytes;
    static ByteBuffer readByteBuffer;
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        Intracomm comm = MPI.COMM_WORLD;
        int rank = comm.getRank();
        int size = comm.getSize();

        String mmapScratchDir = "/scratch/sekanaya";
        String ZmmapCollectiveFileName = MPI.getProcessorName() + ".mmapId." + 0 + ".ZmmapCollective.bin";
        try (FileChannel ZmmapCollectiveFc = FileChannel
                .open(Paths.get(mmapScratchDir, ZmmapCollectiveFileName),
                        StandardOpenOption.CREATE, StandardOpenOption.READ,
                        StandardOpenOption.WRITE)) {

            int ZmmapCollectiveReadByteExtent = 2*size*Integer.BYTES;

            long mmapCollectiveReadByteOffset = 0L;

            readBytes = ByteBufferBytes.wrap(ZmmapCollectiveFc.map(
                    FileChannel.MapMode.READ_WRITE, mmapCollectiveReadByteOffset,
                    ZmmapCollectiveReadByteExtent));
            readBytes.position(0);
            readByteBuffer = readBytes.sliceAsByteBuffer(readByteBuffer);

            /*if (isMmapLead){
                for (int i = 0; i < ZmmapCollectiveReadByteExtent; ++i)
                    readBytes.writeByte(i,0);
            }*/
        }



        if (rank == 3) {
            readByteBuffer.putInt(Integer.BYTES, rank);
            Thread.sleep(1000);
            System.out.println(readByteBuffer.getInt(Integer.BYTES));
            System.out.println(readBytes.readInt(Integer.BYTES));

            /*readBytes.writeInt(2 * rank * Integer.BYTES, rank);
            readBytes.writeInt((2 * rank + 1) * Integer.BYTES, 53);

            System.out.println("@@ Rank " + rank + " r fromBytes " +
                    readBytes.readInt(2 * rank * Integer.BYTES) +
                    " r fromBuffer " +
                    readByteBuffer.getInt(2 * rank * Integer.BYTES));*/

        }
        comm.barrier();
        /*if (rank == 3) {
            for (int i = 0; i < size; ++i) {
                System.out.println(
                        "++ r " + readBytes.readInt(2 * i * Integer.BYTES) +
                                " v " +
                                readBytes.readInt((2 * i + 1) * Integer.BYTES) +

                                "** r " + readByteBuffer.getInt(2 * i * Integer.BYTES) +
                                " v " + readByteBuffer.getInt(
                                (2 * i + 1) * Integer.BYTES));

            }
        }*/

        MPI.Finalize();
    }
}
