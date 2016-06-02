package org.saliya.unsafe;

import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTester {

    public static void main(String[] args) {
        long SUPER_SIZE = (long)Integer.MAX_VALUE * 2;
        SuperArray array = new SuperArray(SUPER_SIZE);
        System.out.println("Array size:" + array.size()); // 4294967294
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            array.set((long)Integer.MAX_VALUE + i, (byte)3);
            sum += array.get((long)Integer.MAX_VALUE + i);
        }
        System.out.println("Sum of 100 elements:" + sum);  // 300
    }
}
