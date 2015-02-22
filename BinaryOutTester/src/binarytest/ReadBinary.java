package binarytest;

import java.io.*;

public class ReadBinary {
    public static void main(String[] args) {
        try {
//            FileInputStream in = new FileInputStream("C:\\users\\sekanaya\\desktop\\bytes.bin");
            FileInputStream in = new FileInputStream("C:\\users\\sekanaya\\desktop\\javabytes.bin");
            byte [] bytes = new byte[2];
            if (in.read(bytes) != 2) {
                System.out.println("This is bad, there should be two bytes in the file");
            }

            byte b0 = bytes[0];
            byte b1 = bytes[1];
            System.out.println("Manual Reading");
            System.out.println("b0: " + b0);
            System.out.println("b1: " + b1);
//            short x = (short) (b0 & 0xff);
//            System.out.println(x);
//
//            x = (short) (b1 << 8);
//            System.out.println(x);
//
//            x = (short)(b1 << 8 | b0);
//            System.out.println(x);


            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
//            DataInputStream dis = new DataInputStream(new FileInputStream("C:\\users\\sekanaya\\desktop\\bytes.bin"));
            DataInputStream dis = new DataInputStream(new FileInputStream("C:\\users\\sekanaya\\desktop\\javabytes.bin"));

            short x = dis.readShort();
            System.out.println("Reading by DataInputStream");
            System.out.println(x);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public short readCSharpShort(InputStream is) throws IOException {
        byte [] bytes = new byte[2];
        if (is.read(bytes) == 2) {
            return (short) ((bytes[1] << 8) | (bytes[0] & 0xff));
        }
        throw new IOException("Couldn't read two bytes to create a short value");
    }


}
