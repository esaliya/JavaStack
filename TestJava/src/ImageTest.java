import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.*;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        File file = new File("src/result.jpg");
        FileInputStream fis = new FileInputStream(file);

        BufferedImage img = ImageIO.read(fis);

        int size = 4;
        int temp = (int) Math.sqrt(size);


        int w = img.getWidth() / temp;
        int num = 0;
        BufferedImage imgs[] = new BufferedImage[size];
        for (int x = 0; x < temp; x++) {
            for (int y = 0; y < temp; y++) {
                imgs[num] = new BufferedImage(w, w, img.getType());
                // Tell the graphics to draw only one block of the image
                Graphics2D g = imgs[num].createGraphics();
                g.drawImage(img, 0, 0, w, w, w * x, w * y, w * x + w, w * y + w, null);
                g.dispose();
                num++;
            }
        }
        BufferedImage image;
        for (int i = 0; i < imgs.length; i++) {
            image = imgs[i];
            ImageIO.write(image, "jpg", new File("img" + i + ".jpg"));
        }
        System.out.println("Image splited");


        File[] imgFiles = new File[size];
        for (int i = 0; i < size; i++) {
            imgFiles[i] = new File("img" + i + ".jpg");
        }

        /* concatenating..............................*/

        //read splitted image files
        BufferedImage[] buffImages = new BufferedImage[size];
        for (int i = 0; i < size; i++) {
            buffImages[i] = ImageIO.read(imgFiles[i]);
        }


        int finalWidth = buffImages[0].getWidth() * temp;

        BufferedImage finalImg = new BufferedImage(
                finalWidth,   // Final image will have width and height as
                finalWidth,  // addition of widths and heights of the images we already have
                img.getType());

        num = 0;
        for (int i = 0; i < temp; i++) {
            for (int j = 0; j < temp; j++) {
                finalImg.createGraphics().drawImage(buffImages[num], w * i, w * j, null);
                num++;
            }
        }

        ImageIO.write(finalImg, "jpeg", new File("finalImg.jpg"));
        System.out.println("Image concatenated.....");


    }
}