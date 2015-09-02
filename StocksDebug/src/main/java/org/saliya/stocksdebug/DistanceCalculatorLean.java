package org.saliya.stocksdebug;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.DoubleBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class DistanceCalculatorLean {
    public static void main(String[] args) {

        String file = "E:\\Sali\\git\\github\\esaliya\\JavaStack\\StocksDebug"
                      + "\\src\\main\\resources\\vectors\\2004_1_2005_1.csv";
        int size = 6435;
        int distanceType = 0;
        double cut = 0.1;

        String outDir = "E:\\Sali\\git\\github\\esaliya\\JavaStack\\StocksDebug"
                        + "\\src\\main\\resources\\distances";

        String fname = Files.getNameWithoutExtension(file);
        generateDistances(file, fname, size, distanceType, cut, outDir);
        readDistances(outDir, fname, size, cut);
    }

    private static void readDistances(
        String outDir, String fname, int size, double cut) {
        short cutAsShort = (short) (cut * Short.MAX_VALUE);
        System.out.println("Cut as short = " + cutAsShort);
        System.out.println("Cut as double = " + cut);
        try (FileChannel fc = FileChannel.open(Paths.get(outDir, fname + ".bin"),
                                               StandardOpenOption.READ)){
            long extent = ((long)size) * size * Double.BYTES;
            MappedByteBuffer
                mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, extent);
            DoubleBuffer buffer = mbb.asDoubleBuffer();
            long countLessThanCut = 0;
            long countLessThanShortCut =0;
            long countLessThanDoubleCut =0;

            for (int i = 0; i < size; ++i){
                for (int j = 0; j < size; ++j){
                    int pos = i*size + j;
                    double doubleCor = buffer.get(pos);
                    if (doubleCor < cut) {
                        ++countLessThanCut;
                    }

                    if (Double.isNaN(doubleCor)){
                        System.out.println("Error! Double value at (" + i + "," + j + ") is not a number (NaN)");
                        return;
                    }
                    assert doubleCor >= 0.0 && doubleCor <= 1.0;
                    short shortCor = (short) (doubleCor * Short.MAX_VALUE);
                    assert shortCor >= 0;
                    if (doubleCor < cut) {
                        countLessThanDoubleCut++;
                    }
                    if (shortCor < cutAsShort) {
                        countLessThanShortCut++;
                        if (!(doubleCor < cut)){
                            System.out.println("Bizzare i=" + i + " j=" + j +  " doubleCor=" + doubleCor + " shortCor=" + shortCor + " doubleCut=" + cut + " shortCut=" + cutAsShort);
                        }
                    }

                }
            }
            System.out.println("Count less than " + cut + " = " + countLessThanCut);
            System.out.println("countLessThanShortCut  " + countLessThanShortCut);
            System.out.println("countLessThanDoubleCut " + countLessThanDoubleCut);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateDistances(
        String file, String fname, int size, int distanceType, double cut, String outDir) {

        List<VectorPoint> vectors = Utils.readVectors(new File(file), 0, size);
        try(FileChannel fc = FileChannel.open(Paths.get(outDir, fname + ".bin"),
                                              StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            long extent = ((long)size) * size * Double.BYTES;
            MappedByteBuffer
                mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, extent);
            DoubleBuffer buffer = mbb.asDoubleBuffer();

            long countLessThanCut = 0;
            double dmax = Double.MIN_VALUE;
            double dmin = Double.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                VectorPoint sv = vectors.get(i);
                for (int j = 0; j < size; j++) {
                    VectorPoint fv = vectors.get(j);
                    double cor = sv.correlation(fv, distanceType);
                    if (Double.isNaN(cor)){
                        System.out.println("Error! Double value at (" + i + "," + j + ") is not a number (NaN)");
                        System.out.println(Arrays.toString(fv.getNumbers()));
                        System.out.println(Arrays.toString(sv.getNumbers()));
                        return;
                    }
                    if (cor < cut) {
                        ++countLessThanCut;
                    }
                    if (cor > dmax) {
                        dmax = cor;
                    }

                    if (cor < dmin) {
                        dmin = cor;
                    }
                    buffer.put(cor);
                }
            }
            mbb.force();
            System.out.println("Count less than " + cut + " = " + countLessThanCut);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
