import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import threeD.io.FileEncoder;
import threeD.raytracer.graphics.GraphicsConverter;
import threeD.raytracer.graphics.RGB;
import threeD.raytracer.util.Vector;
import edu.indiana.extreme.CameraSetup;
import edu.indiana.extreme.DistributedRayTracer;
import edu.indiana.extreme.SceneVectorGraphics;

public class Test {
//    public static void main(String[] args) throws IOException {
//        long start = System.currentTimeMillis();
//        DistributedRayTracer tracer = new DistributedRayTracer();
//        CameraSetup cameraInformation = new CameraSetup(
//                new Vector(0.0, -1.0, 10.0), new Vector(0.0, 0.0, -1.0));
//        SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL("http://pagodatree.cs.indiana.edu:9999/temp/RenderDemo.xml"));
////        RGB[][] rgb = tracer.rayTrace(cameraInformation, sceneHolder,300, 300);
//        RGB[][][] parts = new RGB[4][][];
//        parts[0] = tracer.rayTrace(cameraInformation , sceneHolder , 100, 100, new Rectangle(0, 0, 100, 25));
//        parts[1] = tracer.rayTrace(cameraInformation , sceneHolder , 100, 100, new Rectangle(0, 25, 100, 25));
//        parts[2] = tracer.rayTrace(cameraInformation , sceneHolder , 100, 100, new Rectangle(0, 50, 100, 25));
//        parts[3] = tracer.rayTrace(cameraInformation , sceneHolder , 100, 100, new Rectangle(0, 75, 100, 25));
//
//        RGB[][] out = new RGB[100][100];
//        for (int i = 0; i < out.length; i++) {
//            for (int j = 0; j < out[i].length; j++) {
//                if (j < 25 && i < 100) {
//                    out[i][j] = parts[0][i][j];
//                } else if (j < 50 && i < 100) {
//                    out[i][j] = parts[1][i][j];
//                } else if (j < 75 && i < 100) {
//                    out[i][j] = parts[2][i][j];
//                } else if (j < 100 && i < 100) {
//                    out[i][j] = parts[3][i][j];
//                }
//            }
//        }
////        Image image = GraphicsConverter.convertToAWTImage(out);
////        RGB[][] temp = tracer.rayTrace(cameraInformation , sceneHolder , 100, 100, new Rectangle(100, 20, 200, 50));
////        RGB[][] temp = tracer.rayTrace(cameraInformation , sceneHolder , 100, 100);
////        for (RGB[] aTemp : temp) {
////            for (RGB c : aTemp) {
////                System.out.print(c.getRed());
////                System.out.print("\t");
////                System.out.print(c.getGreen());
////                System.out.print("\t");
////                System.out.println(c.getBlue());
////            }
////
////        }
////        Image image = GraphicsConverter.convertToAWTImage(temp);
//
//        FileEncoder.encodeImageFile(out, new File("out.jpg"), 6);
////        FileEncoder.encodeImageFile(temp, new File("out.jpg"), 6);
////        System.out.println((System.currentTimeMillis() - start) / 1000+ "Secs");
////        int x = 10;
////        System.out.println(-x);
//    }

    public static void main(String[] args) {
        char c = '-';
        System.out.print(c);
        System.out.println(Character.toUpperCase(c));
        System.out.println(c == Character.toUpperCase(c));
        System.out.println("-".toUpperCase());
    }
}