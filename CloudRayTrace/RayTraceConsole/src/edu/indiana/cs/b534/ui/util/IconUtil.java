package edu.indiana.cs.b534.ui.util;

import threeD.raytracer.graphics.GraphicsConverter;
import threeD.raytracer.graphics.RGB;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class IconUtil {
    public static ImageIcon createFromFile(String path) throws IOException {
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
        return new ImageIcon(GraphicsConverter.convertToAWTImage(img));
    }
}
