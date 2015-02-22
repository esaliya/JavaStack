import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceQuery {
//    public static void main(String[] args) {
//        if (args.length < 2) return;
//        String distanceFile = args[0];
//        int size = Integer.parseInt(args[1]);
//
//        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
//
//        Pattern pairRegex = Pattern.compile("^(\\d+)(,|\\s+)((\\d+))$");
//        Pattern quitRegex = Pattern.compile("^(q|quit|Quit|QUIT|exit|Exit|EXIT)$");
//        boolean quit = false;
//
//        DataInputStream dis = new DataInputStream(new FileInputStream(distanceFile));
//        do{
//            System.out.print(">");
//            try {
//                String s = inputReader.readLine();
//                if (s != null && !s.equals("")) {
//                    Matcher m = pairRegex.matcher(s);
//                    if (m.find()){
//                        int r = Integer.parseInt(m.group(1));
//                        int c = Integer.parseInt(m.group(3));
//
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } while(!quit);

//        try {
//            DataInputStream dis = new DataInputStream(new FileInputStream(distanceFile));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}

/*
Regex pairRegex = new Regex(@"^(\d+)(,|\s+)(\d+)$");
Regex quitRegex = new Regex(@"^(q|quit|Quit|QUIT|exit|Exit|EXIT)$");
bool quit = false;
do
        {
        Console.Write("> ");
string s = Console.ReadLine();
if (!string.IsNullOrEmpty(s))
        {
        Match m = pairRegex.Match(s);
if (m.Success)
        {
        int r = int.Parse(m.Groups[1].Value);
int c = int.Parse(m.Groups[3].Value);
double dist = ((double) BitConverter.ToInt16(reader.Read(r, c), 0))/Int16.MaxValue;
Console.WriteLine("  Distance: " + dist);
}
        else if (quitRegex.IsMatch(s))
        {
        quit = true;
}
        else
        {
        Console.WriteLine("  Unidentified input");
}
        }
        } while (!quit);
*/