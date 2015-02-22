package test;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapred.lib.NLineInputFormat;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class BytesMR {
    public static class Map extends MapReduceBase
            implements Mapper<LongWritable, Text, Text, BytesWritable> {
        String url = "http://pagodatree.cs.indiana.edu:9999/temp/RenderDemo.xml";

        public void map(LongWritable key, Text value,
                        OutputCollector<Text, BytesWritable> output,
                        Reporter reporter) throws IOException {
            // The format of the input value string
            // minX;maxX;minY;maxY;locX;locY;locZ;directX;directY;directZ;width;height
            String[] args = value.toString().split(";");

            // Location vector
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(Integer.parseInt(args[0]));
            dos.writeInt(Integer.parseInt(args[2]));
            output.collect(new Text("map-key"), new BytesWritable(baos.toByteArray()));
        }
    }

    public static class Reduce extends MapReduceBase
            implements Reducer<Text, BytesWritable, Text, BytesWritable> {
        public void reduce(Text text, Iterator<BytesWritable> itr, OutputCollector<Text, BytesWritable> output,
                           Reporter reporter) throws IOException {
//            ArrayList<Byte> list = new ArrayList<Byte>();
//            byte[] arr;
//            while (itr.hasNext()) {
//                arr = itr.next().get();
//                for (byte b : arr) {
//                    list.add(b);
//                }
//            }
//            arr = new byte[list.size()];
//            for (int i = 0; i < list.size(); i++) {
//                Byte aByte = list.get(i);
//                arr[i] = aByte;
//            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(43);
            dos.writeInt(27);

            output.collect(new Text("reduce-key"), new BytesWritable(baos.toByteArray()));
        }
    }

    public static void main(String[] args) throws IOException {
        JobConf conf = new JobConf(BytesMR.class);
        conf.setJobName("BytesMR-Test");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(BytesWritable.class);
        conf.setMapperClass(Map.class);
        conf.setReducerClass(Reduce.class);
        conf.setInputFormat(NLineInputFormat.class);
        conf.setOutputFormat(ByteOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        System.out.println("job start...");
        conf.setNumReduceTasks(1);
        JobClient.runJob(conf);
    }
}
