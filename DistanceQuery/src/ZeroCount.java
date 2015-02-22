import java.io.*;

public class ZeroCount {
    public static void main(String[] args) throws IOException {
        String distFile = args[0];
        int size = Integer.parseInt(args[1]);
        String outFile = args[2];
        
        DataInputStream dis = new DataInputStream(new FileInputStream(distFile));
        PrintWriter writer = new PrintWriter(outFile);
        int maxCount = 0;
        int maxCountRow = 0;
        long totalCount = 0;
        for (int i =0; i < size; ++i ){
            int count = 0;
            for (int j =0; j < size; ++j){
                if (dis.readShort() == Short.MAX_VALUE)  {
                    count++;
                    totalCount++;
                }
            }
            writer.println("Row\t" + i + "\t1 count:\t" + count);
            if (maxCount < count)
            {
                maxCount = count;
                maxCountRow = i;
            }
        }
        writer.println("Max Count:\t" + maxCount);
        writer.WriteLine("Max Count Row:\t" + maxCountRow);
//                    writer.WriteLine("Total Zero Count:\t" + totalCount);
        writer.WriteLine("Total 1 Count:\t" + totalCount);
        Console.WriteLine("Done.");
    }
}

    /*
string distFile = args[0];
int size = int.Parse(args[1]);
string outFile = Path.Combine(Path.GetDirectoryName(distFile),
//                                          Path.GetFileNameWithoutExtension(distFile) + "_zercount.txt");
        Path.GetFileNameWithoutExtension(distFile) + "_1count.txt");
    using (BinaryReader reader = new BinaryReader(File.OpenRead(distFile)))
        {
        using (StreamWriter writer = new StreamWriter(outFile))
        {
        int maxCount = 0;
int maxCountRow = 0;
long totalCount = 0;
for (int i = 0; i < size; i++)
        {
        int count = 0;
for (int j = 0; j < size; j++)
        {
//                            if (reader.ReadInt16() == 0)
        if (reader.ReadInt16() == Int16.MaxValue)
        {
        count++;
totalCount++;
}
        }
//                        writer.WriteLine("Row\t" + i + "\tzero count:\t" + count);
        writer.WriteLine("Row\t" + i + "\t1 count:\t" + count);
if (maxCount < count)
        {
        maxCount = count;
maxCountRow = i;
}
        }
        writer.WriteLine("Max Count:\t" + maxCount);
writer.WriteLine("Max Count Row:\t" + maxCountRow);
//                    writer.WriteLine("Total Zero Count:\t" + totalCount);
writer.WriteLine("Total 1 Count:\t" + totalCount);
Console.WriteLine("Done.");
Console.Read();
}
        }          */
