package org.saliya.unsafe;

import net.openhft.lang.io.ByteBufferBytes;
import net.openhft.lang.io.Bytes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedBytes {
    static Bytes mmapCollectiveBytes;
    static ByteBuffer mmapCollectiveByteBuffer;
    public static void main(String[] args) {
        int minMsgSize = 2*Integer.BYTES;
        int maxMsgSize = 4*Integer.BYTES;

        String mmapCollectiveFileName = "mmapId.mmapCollective.bin";
        try (FileChannel mmapCollectiveFc = FileChannel
                .open(Paths.get("/dev/shm/sekanaya", mmapCollectiveFileName),
                        StandardOpenOption.CREATE, StandardOpenOption.READ,
                        StandardOpenOption.WRITE)) {

            mmapCollectiveBytes = ByteBufferBytes.wrap(mmapCollectiveFc.map(
                    FileChannel.MapMode.READ_WRITE, 0L, maxMsgSize));
            mmapCollectiveByteBuffer = mmapCollectiveBytes.sliceAsByteBuffer(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mmapCollectiveBytes.writeInt(0, 4);
        mmapCollectiveBytes.writeInt(Integer.BYTES, 5);
        mmapCollectiveBytes.writeInt(2*Integer.BYTES, 6);
        mmapCollectiveBytes.writeInt(3*Integer.BYTES, 7);
        System.out.println(mmapCollectiveBytes.readInt(0));
        System.out.println(mmapCollectiveBytes.readInt(Integer.BYTES));
        System.out.println(mmapCollectiveBytes.readInt(2*Integer.BYTES));
        System.out.println(mmapCollectiveBytes.readInt(3*Integer.BYTES));

        ByteBuffer buffer = ByteBuffer.allocateDirect(maxMsgSize);
        buffer.position(0);
        mmapCollectiveBytes.position(0);
        mmapCollectiveBytes.read(buffer, minMsgSize);

        System.out.println(buffer.getInt(0) +  " "  + buffer.getInt(Integer.BYTES));

    }
}
