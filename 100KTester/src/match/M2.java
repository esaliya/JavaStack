package match;

import java.io.*;

public class M2 {
    public static void main(String[] args) throws IOException {
        String hc100k = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\100K_human_chimp.txt";
        String top50k = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\top50k.txt";
        String tail50k = "C:\\Users\\sekanaya\\Desktop\\100k\\data\\tail50k.txt";

        String str;
        BufferedReader reader = new BufferedReader(new FileReader(hc100k));
        PrintWriter topWriter = new PrintWriter(top50k);
        PrintWriter tailWriter = new PrintWriter(tail50k);
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            topWriter.println(reader.readLine());
        }
        topWriter.close();
        for (int i = 0; i < 100000; i++) {
            tailWriter.println(reader.readLine());
        }
        tailWriter.close();
        reader.close();
        System.out.println("Done");


    }
}
