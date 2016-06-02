package org.saliya.unsafe;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.IntBuffer;
import java.util.HashSet;

public class ShallowCopy {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(2);
        buffer.put(0,1);
        buffer.put(1,4);
        System.out.println(buffer.get(0) + " " + buffer.get(1));
        long size = sizeOf(buffer);
        System.out.println(size);

        Object[] array = new Object[] {buffer};
        long baseOffset = Common.UNSAFE.arrayBaseOffset(Object[].class);
        System.out.println(baseOffset);
        long start = normalize(Common.UNSAFE.getInt(array, baseOffset));
        System.out.println(start);
        long address = Common.UNSAFE.allocateMemory(size);

        Common.UNSAFE.copyMemory(start, address, size);
    }

    static long toAddress(Object obj) {
        Object[] array = new Object[] {obj};
        long baseOffset = Common.UNSAFE.arrayBaseOffset(Object[].class);
        return normalize(Common.UNSAFE.getInt(array, baseOffset));
    }

    static Object fromAddress(long address) {
        Object[] array = new Object[] {null};
        long baseOffset = Common.UNSAFE.arrayBaseOffset(Object[].class);
        Common.UNSAFE.putLong(array, baseOffset, address);
        return array[0];
    }

    static Object shallowCopy(Object obj) {
        long size = sizeOf(obj);
        long start = toAddress(obj);
        long address = Common.UNSAFE.allocateMemory(size);
        Common.UNSAFE.copyMemory(start, address, size);
        return fromAddress(address);
    }

    private static long normalize(int value) {
        if(value >= 0) return value;
        return (~0L >>> 32) & value;
    }

    public static long sizeOf(Object o) {
        Unsafe u = Common.UNSAFE;
        HashSet<Field> fields = new HashSet<Field>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = u.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }

        return ((maxSize/8) + 1) * 8;   // padding
    }

}
