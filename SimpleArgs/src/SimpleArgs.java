import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SimpleArgs {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(args.length);
        for(String s:args){
            System.out.println(s);
        }

        System.out.println(System.getProperty("user.name"));
        String idxFile = args[0];
        BufferedReader br = new BufferedReader(new FileReader(idxFile.replaceAll("//","/")));
        System.out.println("good");
    }
}
