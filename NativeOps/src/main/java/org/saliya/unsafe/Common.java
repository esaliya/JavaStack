package org.saliya.unsafe;

import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Common {
    /**
     * *** Access the Unsafe class *****
     */
    @NotNull
    @SuppressWarnings("ALL")
    public static final Unsafe UNSAFE;

    static {
        try {
            @SuppressWarnings("ALL") Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
