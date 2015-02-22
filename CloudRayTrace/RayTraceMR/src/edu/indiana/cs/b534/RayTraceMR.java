package edu.indiana.cs.b534;

import edu.indiana.extreme.CameraSetup;
import edu.indiana.extreme.DistributedRayTracer;
import edu.indiana.extreme.SceneVectorGraphics;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapred.lib.*;
import threeD.raytracer.graphics.RGB;
import threeD.raytracer.util.Vector;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Iterator;

public class RayTraceMR {
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
            Vector loc =  new Vector(
                            Double.parseDouble(args[4]),
                            Double.parseDouble(args[5]),
                            Double.parseDouble(args[6]));
            // Direction vector
            Vector direct = new Vector(
                            Double.parseDouble(args[7]),
                            Double.parseDouble(args[8]),
                            Double.parseDouble(args[9]));

            // CameraSetup based on location and direction vectors
            CameraSetup camSetup = new CameraSetup(loc, direct);

            // Scene configuration
            SceneVectorGraphics scene = new SceneVectorGraphics(new URL(url));

            // Dimensions and coordinates of the sub view
            int x = Integer.parseInt(args[0]);
            int w = Integer.parseInt(args[1]) - x + 1;
            int y = Integer.parseInt(args[2]);
            int h = Integer.parseInt(args[3]) - y + 1;

            // Image width and height
            int imgW = Integer.parseInt(args[10]);
            int imgH = Integer.parseInt(args[11]);

            DistributedRayTracer rayTracer = new DistributedRayTracer();
            RGB[][] subView = rayTracer.rayTrace(camSetup, scene, imgW, imgH, new Rectangle(x, y, w, h));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            // Write total image width and height at the beginning
            dos.writeInt(imgW);
            dos.writeInt(imgH);
            dos.writeInt(x);
            dos.writeInt(y);
            dos.writeInt(w);
            dos.writeInt(h);
            // Filter out the portion, which has useful data
            for (int i = 0; i < imgW; i++) {
                for (int j = 0; j < imgH; j++) {
                    if (i >= x && i < w + x && j >= y && j < h + y) {
                        dos.writeDouble(subView[i][j].getRed());
                        dos.writeDouble(subView[i][j].getGreen());
                        dos.writeDouble(subView[i][j].getBlue());
                    }
                }
            }
            dos.flush();
            BytesWritable bytes = new BytesWritable(baos.toByteArray());
            dos.close();
            baos.close();
            output.collect(new Text("map-key"), bytes);
        }
    }

    public static class Reduce extends MapReduceBase
            implements Reducer<Text, BytesWritable, Text, BytesWritable> {
        public void reduce(Text text, Iterator<BytesWritable> itr, OutputCollector<Text, BytesWritable> output,
                           Reporter reporter) throws IOException {
            byte [] finalBytes = null;
            int imgW, imgH;
            int x, y, w, h;
            DataInputStream dis;
            while (itr.hasNext()) {
                dis = new DataInputStream(new ByteArrayInputStream(itr.next().get()));
                if (finalBytes == null) {
                    imgW = dis.readInt();
                    imgH = dis.readInt();
                    // 24 = 3(doubles) x 8
                    // 8 = 2(int) x 4
                    finalBytes = new byte[imgH * imgW * 24 + 8];
                    // write imgW and imgH in the beginning
                    writeInt(finalBytes, 0, imgW);
                    writeInt(finalBytes, 4, imgH);
                } else {
                    // Skip imgW and imgH integers since we have taken them once
                    dis.skipBytes(8);
                }
                x = dis.readInt();
                y = dis.readInt();
                w = dis.readInt();
                h = dis.readInt();

                int t = w * 24;
                int k, idx;
                // Write everything into a 1-D byte array by column-major
                for (int i = 0; i < w; i++) {
                    // A little optimization as this value doesn't change inside the inner loop
                    k = t * (i + x);
                    for (int j = 0; j < h; j++) {
                        idx = k + ((j + y) * 24) + 8; // the last 8 to offset 8 bytes for imgW and imgH
                        writeDouble(finalBytes, idx, dis.readDouble());
                        writeDouble(finalBytes, idx + 8, dis.readDouble());
                        writeDouble(finalBytes, idx + 16, dis.readDouble());
                    }
                }
                dis.close();
            }
            output.collect(new Text("reduce-key"), new BytesWritable(finalBytes));
        }

        /**
         * Writes a double value as a sequence of 8 bytes
         * @param arr the array to which the double value should be written
         * @param idx the starting index for the byte sequence in arr
         * @param d the double value
         */
        private void writeDouble(byte[] arr, int idx, double d) {
            long v = Double.doubleToLongBits(d);
            arr[idx] = (byte) (0xff & (v >> 56));
            arr[idx + 1] = (byte) (0xff & (v >> 48));
            arr[idx + 2] = (byte) (0xff & (v >> 40));
            arr[idx + 3] = (byte) (0xff & (v >> 32));
            arr[idx + 4] = (byte) (0xff & (v >> 24));
            arr[idx + 5] = (byte) (0xff & (v >> 16));
            arr[idx + 6] = (byte) (0xff & (v >> 8));
            arr[idx + 7] = (byte) (0xff & v);
        }

        /**
         * Writes an int value as a sequence of 4 bytes
         * @param arr the array to which the int value should be written
         * @param idx the starting index for the byte sequence in arr
         * @param v the int value
         */
        private void writeInt(byte[] arr, int idx, int v) {
            arr[idx] = (byte) (0xff & (v >> 24));
            arr[idx + 1] = (byte) (0xff & (v >> 16));
            arr[idx + 2] = (byte) (0xff & (v >> 8));
            arr[idx + 3] = (byte) (0xff & v);
        }
    }

    public static void main(String[] args) throws IOException {
        JobConf conf = new JobConf(RayTraceMR.class);
        conf.setJobName("RayTraceMR");
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
