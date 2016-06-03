package org.saliya.unsafe;

import com.google.common.base.Stopwatch;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class BufferCopy {
    public static void main(String[] args) {
        int size = 2<<20;
        int sizeInLongs = size/Long.BYTES;

        ByteBuffer sbuff = ByteBuffer.allocateDirect(size);
        for (int i = 0; i < sizeInLongs; ++i){
            sbuff.putInt(i*Integer.BYTES, i);
        }

        ByteBuffer rbuff = ByteBuffer.allocateDirect(size);

        Stopwatch timer = Stopwatch.createStarted();
        for (int i = 0; i < sizeInLongs; ++i){
            rbuff.putInt(i*Integer.BYTES, sbuff.getInt(i*Integer.BYTES));
        }
        timer.stop();
        System.out.println(timer.elapsed(TimeUnit.NANOSECONDS));
    }
}
