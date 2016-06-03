package org.saliya.unsafe;

import com.google.common.base.Stopwatch;
import net.openhft.lang.io.ByteBufferBytes;
import net.openhft.lang.io.Bytes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

public class MappedBytes {
    static Bytes mmapCollectiveBytes;
    static ByteBuffer mmapCollectiveByteBuffer;
    public static void main(String[] args) {
        int minMsgSize = 2<<20;
        int maxMsgSize = 2<<20;

        String mmapCollectiveFileName = "mmapId.mmapCollective.bin";
        try (FileChannel mmapCollectiveFc = FileChannel
                .open(Paths.get(".", mmapCollectiveFileName),
                        StandardOpenOption.CREATE, StandardOpenOption.READ,
                        StandardOpenOption.WRITE)) {

            mmapCollectiveBytes = ByteBufferBytes.wrap(mmapCollectiveFc.map(
                    FileChannel.MapMode.READ_WRITE, 0L, maxMsgSize));
            mmapCollectiveByteBuffer = mmapCollectiveBytes.sliceAsByteBuffer(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < maxMsgSize; ++i) {
            mmapCollectiveBytes.writeByte(i, (byte)'a');
        }
        ByteBuffer buffer = ByteBuffer.allocateDirect(minMsgSize);
        buffer.position(0);
        mmapCollectiveBytes.position(0);
        Stopwatch timer = Stopwatch.createStarted();
        mmapCollectiveBytes.read(buffer, minMsgSize);

        timer.stop();
        System.out.println(timer.elapsed(TimeUnit.NANOSECONDS));
        /*for (int i = 0; i < minMsgSize; ++i){
            System.out.println((char)buffer.get(i));
        }*/

    }
}
