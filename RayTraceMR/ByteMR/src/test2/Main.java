package test2;

import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import threeD.io.FileEncoder;
import threeD.raytracer.graphics.RGB;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "c:\\users\\sekanaya\\desktop\\part-00000";
        DataInputStream dis = new DataInputStream(new FileInputStream(path));

        int imgW = dis.readInt();
        int imgH = dis.readInt();
        RGB[][] img = new RGB[imgH][imgW];
        double r, g, b;
        for (int i = 0; i < imgW; i++) {
            for (int j = 0; j < imgH; j++) {
                r = dis.readDouble();
                g = dis.readDouble();
                b = dis.readDouble();
                img[i][j] = new RGB(r, g, b);
            }
        }
        dis.close();
        FileEncoder.encodeImageFile(img, new File("c:\\users\\sekanaya\\desktop\\img.jpg"), 6);
//        String headString = "reduce-key\t";
//        byte [] headBytes = headString.getBytes();
//        dis.skipBytes(headBytes.length);
//
//        byte[] tailBytes = new byte[dis.available()];
//        dis.readFully(tailBytes);
//        dis.close();
//
//        String tailString = new String(tailBytes);
//        System.out.println(tailString.getBytes().length);
//        System.out.println(headString.getBytes().length);
//        dis = new DataInputStream(new ByteArrayInputStream(tailBytes));
//        System.out.println(dis.readInt());
//
//        System.out.println("*****************");
//        String [] arr = tailString.trim().split(" ");
//        System.out.println(tailString);
//        System.out.println(arr.length);
//        byte[] bytes = new byte[8];
//        for (int i = 0; i < arr.length; i++) {
//            byte b = Byte.decode("0x" + arr[i]);
//            bytes[i] = b;
//        }
//        dis = new DataInputStream(new ByteArrayInputStream(bytes));
//        System.out.println(dis.readInt());
//        System.out.println(dis.readInt());
//        dis.close();
        

        

//        double d = 0.2345678433;
//        long l =Double.doubleToLongBits(d);
        

//        String headString = new String(tailBytes);
//        System.out.println(headString);
//        String [] headBytes = headString.split("\t");
//        tailBytes = headBytes[1].getBytes();
//        dis = new DataInputStream(new ByteArrayInputStream(tailBytes));
//        int x;
//        System.out.println(headBytes[1]);
//        System.out.println(dis.readInt());


//        }
//        byte tailBytes = -128;
//        RGB rgb = new RGB();
//        rgb.setRed(255);
//        rgb.setGreen(120);
//        rgb.setBlue(230);
//        double d = rgb.getRed();
//        System.out.println(d);
//        System.out.println(rgb.getBlue());
//        System.out.println(((Double)rgb.getBlue()).toString());
//        RGB rgb = new RGB(0.5, 0.4, 0.3);
//        byte tailBytes = ((Double)rgb.getRed()).byteValue();
//        System.out.println(tailBytes);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        DataOutputStream dos = new DataOutputStream(baos);
//        dos.writeInt(153);
//        dos.writeInt(244);
//        byte[] bytes = baos.toByteArray();
//        String headString = new String(bytes);
//        String tailString = "key\t" + headString;
//        System.out.println(tailString);
//        bytes = tailString.getBytes();
//        for (byte aByte : bytes) {
//            System.out.println(aByte);
//        }

    }
}
