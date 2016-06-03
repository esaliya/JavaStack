/**
 * Copyright 2016 Milinda Pathirage
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnsafeTest {

  private Unsafe unsafe;

  @Before
  public void prepareUnsafe() throws Exception {
    unsafe = makeInstance();
  }

  private Unsafe makeInstance() throws Exception{
    Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
    unsafeConstructor.setAccessible(true);
    unsafe = unsafeConstructor.newInstance();
    return unsafe;
  }

  private Unsafe fetchInstance() throws Exception{
    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
    theUnsafe.setAccessible(true);
    unsafe = (Unsafe) theUnsafe.get(null);
    return unsafe;
  }

  @Test
  public void testRetrieval() throws Exception {
    fetchInstance();
  }

  @Test(expected = SecurityException.class)
  public void testSingletonGetter() throws Exception {
    Unsafe.getUnsafe();
  }

  private static class ClassWithExpensiveConstructor {

    private final int value;

    private ClassWithExpensiveConstructor() {
      value = doExpensiveLookup();
    }

    private int doExpensiveLookup() {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return 1;
    }

    public int getValue() {
      return value;
    }
  }

  @Test
  public void testObjectCreation() throws Exception {
    ClassWithExpensiveConstructor instance = (ClassWithExpensiveConstructor) unsafe.allocateInstance(ClassWithExpensiveConstructor.class);
    assertEquals(0, instance.getValue());
  }

  @Test
  public void testReflectionFactory() throws Exception {
    @SuppressWarnings("unchecked")
    Constructor silentConstructor = ReflectionFactory.getReflectionFactory()
        .newConstructorForSerialization(ClassWithExpensiveConstructor.class, Object.class.getConstructor());
    silentConstructor.setAccessible(true);
    assertEquals(0, ((ClassWithExpensiveConstructor)silentConstructor.newInstance()).getValue());
  }

  private static class OtherClass {

    private final int value;
    private final int unknownValue;

    private OtherClass() {
      System.out.println("test");
      this.value = 10;
      this.unknownValue = 20;
    }
  }

  @Test
  public void testStrangeReflectionFactory() throws Exception {
    @SuppressWarnings("unchecked")
    Constructor silentConstructor = ReflectionFactory.getReflectionFactory()
        .newConstructorForSerialization(ClassWithExpensiveConstructor.class, OtherClass.class.getDeclaredConstructor());
    silentConstructor.setAccessible(true);
    ClassWithExpensiveConstructor instance = (ClassWithExpensiveConstructor) silentConstructor.newInstance();
    assertEquals(10, instance.getValue());
    assertEquals(ClassWithExpensiveConstructor.class, instance.getClass());
    assertEquals(Object.class, instance.getClass().getSuperclass());
  }

  private class DirectIntArray {

    private final static long INT_SIZE_IN_BYTES = 4;

    private final long startIndex;

    public DirectIntArray(long size) {
      startIndex = unsafe.allocateMemory(size * INT_SIZE_IN_BYTES);
      unsafe.setMemory(startIndex, size * INT_SIZE_IN_BYTES, (byte) 0);
    }

    public void setValue(long index, int value) {
      unsafe.putInt(index(index), value);
    }

    public int getValue(long index) {
      return unsafe.getInt(index(index));
    }

    private long index(long offset) {
      return startIndex + offset * INT_SIZE_IN_BYTES;
    }

    public void destroy() {
      unsafe.freeMemory(startIndex);
    }
  }

  @Test
  public void testDirectIntArray() throws Exception {
    long maximum = Integer.MAX_VALUE + 1L;
    DirectIntArray directIntArray = new DirectIntArray(maximum);
    directIntArray.setValue(0L, 2);
    directIntArray.setValue(maximum -1, 1);
    assertEquals(2, directIntArray.getValue(0L));
    assertEquals(0, directIntArray.getValue(1L));
    assertEquals(1, directIntArray.getValue(maximum -1));
    directIntArray.destroy();
  }

  @Test
  public void testMallaciousAllocation() throws Exception {
    long address = unsafe.allocateMemory(2L * 4);
    unsafe.setMemory(address, 8L, (byte) 0);
    assertEquals(0, unsafe.getInt(address));
    assertEquals(0, unsafe.getInt(address + 4));
    unsafe.putInt(address + 1, 0xffffffff);
    assertEquals(0xffffff00, unsafe.getInt(address));
    assertEquals(0x000000ff, unsafe.getInt(address + 4));
  }


  private static class SuperContainer {

    protected int i;

    private SuperContainer(int i) {
      this.i = i;
    }

    public int getI() {
      return i;
    }
  }

  private static class Container extends SuperContainer {

    private long l;

    private Container(int i, long l) {
      super(i);
      this.l = l;
    }

    public long getL() {
      return l;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Container container = (Container) o;
      return l == container.l && i == container.i;
    }
  }

  @Test
  public void testObjectAllocation() throws Exception {
    long containerSize = sizeOf(Container.class);
    long address = unsafe.allocateMemory(containerSize);
    Container c1 = new Container(10, 1000L);
    Container c2 = new Container(5, -10L);
    place(c1, address);
    place(c2, address + containerSize);
    Container newC1 = (Container) read(Container.class, address);
    Container newC2 = (Container) read(Container.class, address + containerSize);
    assertEquals(c1, newC1);
    assertEquals(c2, newC2);
  }

  public void place(Object o, long address) throws Exception {
    Class<?> clazz = o.getClass();
    do {
      for (Field f : clazz.getDeclaredFields()) {
        if (!Modifier.isStatic(f.getModifiers())) {
          long offset = unsafe.objectFieldOffset(f);
          if (f.getType() == long.class) {
            unsafe.putLong(address + offset, unsafe.getLong(o, offset));
          } else if (f.getType() == int.class) {
            unsafe.putInt(address + offset, unsafe.getInt(o, offset));
          } else {
            throw new UnsupportedOperationException();
          }
        }
      }
    } while ((clazz = clazz.getSuperclass()) != null);
  }

  public Object read(Class<?> clazz, long address) throws Exception {
    Object instance = unsafe.allocateInstance(clazz);
    do {
      for (Field f : clazz.getDeclaredFields()) {
        if (!Modifier.isStatic(f.getModifiers())) {
          long offset = unsafe.objectFieldOffset(f);
          if (f.getType() == long.class) {
            unsafe.putLong(instance, offset, unsafe.getLong(address + offset));
          } else if (f.getType() == int.class) {
            unsafe.putInt(instance, offset, unsafe.getInt(address + offset));
          } else {
            throw new UnsupportedOperationException();
          }
        }
      }
    } while ((clazz = clazz.getSuperclass()) != null);
    return instance;
  }

  public long sizeOf(Class<?> clazz) {
    long maximumOffset = 0;
    do {
      for (Field f : clazz.getDeclaredFields()) {
        if (!Modifier.isStatic(f.getModifiers())) {
          maximumOffset = Math.max(maximumOffset, unsafe.objectFieldOffset(f));
        }
      }
    } while ((clazz = clazz.getSuperclass()) != null);
    return maximumOffset == 0 ? maximumOffset : maximumOffset + 8;
  }

  @Test(expected = Exception.class)
  public void testThrowChecked() throws Exception {
    throwChecked();
  }

  public void throwChecked() {
    unsafe.throwException(new Exception());
  }

  @Test
  public void testPark() throws Exception {
    final boolean[] run = new boolean[1];
    Thread thread = new Thread() {
      @Override
      public void run() {
        unsafe.park(true, 100000L);
        run[0] = true;
      }
    };
    thread.start();
    unsafe.unpark(thread);
    thread.join(100L);
    assertTrue(run[0]);
  }

  @Test
  public void testCopy() throws Exception {
    long address = unsafe.allocateMemory(4L);
    unsafe.putInt(address, 100);
    long otherAddress = unsafe.allocateMemory(4L);
    unsafe.copyMemory(address, otherAddress, 4L);
    assertEquals(100, unsafe.getInt(otherAddress));
  }

  public long getDirectByteBufferAddressViaField(ByteBuffer buffer) throws NoSuchFieldException {
    long addressOffset = unsafe.objectFieldOffset(Buffer.class.getDeclaredField("address"));
    return unsafe.getLong(buffer, addressOffset);
  }

  public long getDirectByteBufferAddressViaMethod(ByteBuffer buffer) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method address = DirectBuffer.class.getDeclaredMethod("address");
    return (Long)address.invoke(buffer);
  }

  @Test
  public void directByteBuffer() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    int size = 2<<20;
    ByteBuffer buffer = ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
    buffer.position(0);
    for (int i = 0; i < size; ++i) {
      buffer.put((byte)'a');
    }

    System.out.println("Byte buffer address(F): " + getDirectByteBufferAddressViaField(buffer));
    System.out.println("Byte buffer address(M): " + getDirectByteBufferAddressViaMethod(buffer));
    System.out.println("Byte buffer capacity: " + buffer.capacity());
    System.out.println("First Byte: " + unsafe.getByte(getDirectByteBufferAddressViaField(buffer)));
    long otherAddress = unsafe.allocateMemory(size);
    unsafe.copyMemory(getDirectByteBufferAddressViaField(buffer), otherAddress, size);
    assertEquals((byte)'a',unsafe.getByte(otherAddress));
  }

}
