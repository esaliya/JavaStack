package mypack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        // Trying to test if I can load resources in a different jar than the one
        // containing my mypack.ClassLoaderTest class.

        InputStreamReader reader = new InputStreamReader(ClassLoaderTest.class.getResourceAsStream(String.format("/%s", "test.txt")));
        if (reader != null){
            System.out.println("good");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s;
            while ((s = bufferedReader.readLine()) != null){
                System.out.println(s);
            }
        } else {
            System.out.println("bad");
        }
    }
}
