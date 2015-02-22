import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Searcher {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src/search.txt"));
//        String str;
//        int i, count =0, addition = 179700; // (addition from 0-599) I found that only one rank is missing
//        while ((str = reader.readLine()) != null) {
//            i = str.indexOf('F');
//            if (i != -1)  {
//                count++;
//                addition -= Integer.parseInt(str.substring(5, i - 1));
//            }
//        }
//        reader.close();
//        System.out.println("Total Finished: " + count);
//        System.out.println("Missing Rank: " + addition);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/search.txt"));
        String str;
        int count = 0;
        while ((str = reader.readLine()) != null) {
            if (str.contains("Beginning File IO")) {
                System.out.println(str.substring(5, str.indexOf('B') - 1));
                count++;
            }
        }
        System.out.println("Total IO started ranks " + count);
        reader.close();
    }
}
