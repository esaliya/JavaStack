package org.saliya.unsafe;

public class SuperArray {

    private final static int BYTE = 1;

    private long size;
    private long address;

    public SuperArray(long size) {
        this.size = size;
        address = Common.UNSAFE.allocateMemory(size * BYTE);
    }

    public void set(long i, byte value) {
        Common.UNSAFE.putByte(address + i * BYTE, value);
    }

    public int get(long idx) {
        return Common.UNSAFE.getByte(address + idx * BYTE);
    }

    public long size() {
        return size;
    }
}
