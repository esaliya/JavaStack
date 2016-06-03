package org.saliya.unsafe;

import com.google.common.base.Stopwatch;
import net.openhft.lang.io.ByteBufferBytes;
import net.openhft.lang.io.Bytes;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

public class MappedBytes {
    static Bytes mmapCollectiveBytes;
    static ByteBuffer mmapCollectiveByteBuffer;
    public static void main(String[] args) throws NoSuchFieldException {
        int extent = 2<<20;

        String mmapCollectiveFileName = "mmapId.mmapCollective.bin";
        try (FileChannel mmapCollectiveFc = FileChannel
                .open(Paths.get(".", mmapCollectiveFileName),
                        StandardOpenOption.CREATE, StandardOpenOption.READ,
                        StandardOpenOption.WRITE)) {

            MappedByteBuffer mapedBytes = mmapCollectiveFc.map(FileChannel.MapMode.READ_WRITE, 0L, extent);
            mapedBytes.order(ByteOrder.LITTLE_ENDIAN);
            mmapCollectiveBytes = ByteBufferBytes.wrap(mapedBytes);

            mmapCollectiveByteBuffer = mmapCollectiveBytes.sliceAsByteBuffer(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < extent; ++i) {
            mmapCollectiveBytes.writeByte(i, (byte)'a');
        }
        ByteBuffer rbuffViaRead = ByteBuffer.allocateDirect(extent).order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer rbuffViaCopy = ByteBuffer.allocateDirect(extent).order(ByteOrder.LITTLE_ENDIAN);

        copyViaRead(extent, rbuffViaRead);
        copyViaMemCopy(extent, rbuffViaCopy);

        /*for (int i = 0; i < minMsgSize; ++i){
            System.out.println((char)rbuff.get(i));
        }*/

    }

    private static void copyViaMemCopy(int extent, ByteBuffer rbuff) throws NoSuchFieldException {
        long fromAddress = getDirectByteBufferAddressViaField(mmapCollectiveByteBuffer);
        long toAddress = getDirectByteBufferAddressViaField(rbuff);
        Stopwatch timer = Stopwatch.createStarted();
        Common.UNSAFE.copyMemory(fromAddress, toAddress, extent);
        timer.stop();
        System.out.println((char)rbuff.get(0) + " " + (char)rbuff.get(1));
        System.out.println(timer.elapsed(TimeUnit.NANOSECONDS));
    }

    public static long getDirectByteBufferAddressViaField(ByteBuffer buffer) throws NoSuchFieldException {
        long addressOffset = Common.UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        return Common.UNSAFE.getLong(buffer, addressOffset);
    }

    private static void copyViaRead(int extent, ByteBuffer rbuff) {
        rbuff.position(0);
        mmapCollectiveBytes.position(0);
        Stopwatch timer = Stopwatch.createStarted();
        mmapCollectiveBytes.read(rbuff, extent);
        timer.stop();
        System.out.println((char)rbuff.get(0) + " " + (char)rbuff.get(1));
        System.out.println(timer.elapsed(TimeUnit.NANOSECONDS));
    }
}
