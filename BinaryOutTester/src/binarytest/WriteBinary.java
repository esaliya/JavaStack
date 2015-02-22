package binarytest;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary {
    public static void main(String[] args) {
        try {
            DataOutputStream dos =
                    new DataOutputStream(new FileOutputStream("C:\\users\\sekanaya\\desktop\\javabytes.bin"));

            dos.writeShort(260);
            dos.flush();
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
