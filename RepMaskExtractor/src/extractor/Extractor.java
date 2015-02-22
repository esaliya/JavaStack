package extractor;

import java.io.*;

public class Extractor {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Need alu file and gene file");
            return;
        }
        String thinFile = "files" + File.separator + "thin.txt";
        try {
            String str;
            String [] splits;
            int count = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            PrintWriter printWriter = new PrintWriter(new File (thinFile));

            while ((str = bufferedReader.readLine()) != null) {
                splits = str.split("\\s+");
                printWriter.println(splits[6] + "\t" + splits[7]+ "\t" + splits[9]+ "\t" + splits[10]);
            }
            bufferedReader.close();
            printWriter.close();

//            System.out.println("# of lines: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("Bad thing happens: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Bad thing happens: " + e.getMessage());
        }
    }
}
