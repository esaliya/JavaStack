package org.saliya.memorymapped.ipc;

import net.openhft.lang.io.ByteBufferBytes;
import net.openhft.lang.io.Bytes;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InterProcCommSerial {
    static Bytes readBytes;
    static ByteBuffer readByteBuffer;
    public static void main(String[] args) throws Exception {

        String mmapScratchDir = ".";
        String ZmmapCollectiveFileName = "localhost" + ".test." + 0 + ".mmapipc.bin";
        try (FileChannel ZmmapCollectiveFc = FileChannel
                .open(Paths.get(mmapScratchDir, ZmmapCollectiveFileName),
                        StandardOpenOption.CREATE, StandardOpenOption.READ,
                        StandardOpenOption.WRITE)) {

            int ZmmapCollectiveReadByteExtent = 2*Integer.BYTES;

            long mmapCollectiveReadByteOffset = 0L;

            readBytes = ByteBufferBytes.wrap(ZmmapCollectiveFc.map(
                    FileChannel.MapMode.READ_WRITE, mmapCollectiveReadByteOffset,
                    ZmmapCollectiveReadByteExtent));
            readBytes.position(0);
            readByteBuffer = readBytes.sliceAsByteBuffer(readByteBuffer);
        }

        readBytes.writeInt(0, 3);
        readBytes.writeInt(Integer.BYTES, 53);

        System.out.println(" r " + readBytes.readInt(0)  + " v " + readBytes.readInt(Integer.BYTES));
        System.out.println(" r " + readByteBuffer.getInt(0)  + " v " + readByteBuffer.getInt(Integer.BYTES));


    }
}
