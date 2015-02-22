package match;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Matcher {
    public static void main(String[] args) throws IOException {
        String hc100k = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\100K_human_chimp.txt";
        String human = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\human.txt";
        String chimp = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\chimp.txt";

        String tail50k = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\tail50k.txt";
        String top50k = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\top50k.txt";

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        BufferedReader reader = new BufferedReader(new FileReader(human));
        String str;
        int count = 0;
        int i = 1;
        System.out.println("----------------------------------------");
        long t0 = System.currentTimeMillis();
        while ((str = reader.readLine())!= null) {
            str = reader.readLine();
//            System.out.println(i++);
            map.put(str, ++count);
        }
        long t1 = System.currentTimeMillis();
        reader.close();
        System.out.println("----------------------------------------");
        System.out.println("Put " + count + "lines to hashmap");
        System.out.println("Time to put: " + (t1 - t0) + "ms");
        System.out.println("----------------------------------------");


        count = 0;
        i = 1;
        reader = new BufferedReader(new FileReader(tail50k));
        t0 = System.currentTimeMillis();
        while ((str = reader.readLine()) != null) {
            str = reader.readLine();
//            System.out.println(i++);
            if (map.containsKey(str))
            {
                count++;
            }
        }
        t1 = System.currentTimeMillis();
        System.out.println("----------------------------------------");
        System.out.println("Time for 50k comparisons: " + (t1 - t0) + "ms");
        System.out.println("Found: " + count);
        System.out.println("----------------------------------------");


      

    }
}
