package org.saliya.unsafe;


import com.google.common.base.Stopwatch;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class ShallowCopy {
    public static void main(String[] args) throws NoSuchFieldException {
        int extent = 2;
        ByteBuffer sbuff = ByteBuffer.allocateDirect(extent);
        sbuff.position(0);
        for (int i = 0; i < extent; ++i) {
            sbuff.put((byte)'a');
        }
        System.out.println((char)sbuff.get(0) + " " + (char)sbuff.get(1));

        ByteBuffer rbuff = ByteBuffer.allocateDirect(extent);

        long fromAddress = getDirectByteBufferAddressViaField(sbuff);
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

}
