package org.saliya.ompi.kmeans;

import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ProgramTest {
    public static void main(String[] args) {
        DoubleBuffer buffer = DoubleBuffer.allocate(12);
        double [][] array = new double [4][3];
        for (int i = 0; i < array.length; i++) {
            double[] doubles = array[i];
            for (int j = 0; j < doubles.length; j++) {
                doubles[j] = i*doubles.length + j;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        copyToBuffer(array, buffer);
        buffer.position(0);
        for (int i = 0; i < 12; ++i){
            buffer.put(i, buffer.get(i)+1);
        }
        copyFromBuffer(buffer, array);

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }

    private static void copyFromBuffer(DoubleBuffer buffer, double[][] centerSums) {
        buffer.position(0);
        for (double [] centerSum : centerSums){
            buffer.get(centerSum);
        }
    }

    private static void copyToBuffer(double[][] centerSums, DoubleBuffer buffer) {
        buffer.position(0);
        for (double [] centerSum : centerSums){
            buffer.put(centerSum);
        }
    }
}
