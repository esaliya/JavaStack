package edu.indiana.cs.b534.client.thread;

import edu.indiana.cs.b534.client.bean.ImageInfo;
import edu.indiana.cs.b534.client.callback.SubViewRequestCallback;
import edu.indiana.cs.b534.client.stub.RayTracerStub;
import edu.indiana.cs.b534.client.ui.ResponseUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Class <code>SubViewRequestManage</code> handles the
 * requester threads. 
 */
public class SubViewRequestManager extends Thread{
    private CountDownLatch startSignal, doneSignal;
    private RayTracerStub stub;
    private RayTracerStub.CameraSetup cameraSetup;
    private int width;
    private int height;
    private String sceneUrl;
    private int blocks;
    private SubViewRequestCallback [] cbs;
    private AtomicInteger ai;

    public SubViewRequestManager(RayTracerStub stub, RayTracerStub.CameraSetup cameraSetup,
                           int width, int height, String sceneUrl, int blocks, AtomicInteger ai) {
        this.stub = stub;
        this.cameraSetup = cameraSetup;
        this.width = width;
        this.height = height;
        this.sceneUrl = sceneUrl;
        this.blocks = blocks;
        startSignal = new CountDownLatch(1);
        doneSignal = new CountDownLatch(blocks);
        cbs = new SubViewRequestCallback[blocks];
        this.ai = ai;
    }

    @Override
    public void run() {
        int jump = width / (int) Math.sqrt(blocks);
        RayTracerStub.Rectangle rectangle;
        Thread t;
        int count = 0;
        for (int i = 0; i < width;) {
            for (int j = 0; j < height;) {
                rectangle = new RayTracerStub.Rectangle();
                rectangle.setMinX(i);
                rectangle.setMinY(j);
                rectangle.setMaxX(i + jump -1);
                rectangle.setMaxY(j + jump -1);
                cbs[count] = new SubViewRequestCallback(doneSignal, new ImageInfo(count, i, j, (i+jump-1), (j+jump-1)));
                t = new SubViewRequester(stub, cbs[count], cameraSetup, width, height, sceneUrl, rectangle,
                        startSignal);
                t.start();
                count++;
                j += jump;
            }
            i += jump;
        }
        // give all the requester threads the green light at once
        startSignal.countDown();
        try {
            ai.addAndGet(blocks);
            // now wait till their callbacks are done with receiving results
            doneSignal.await();
            new ResponseUI("Parallel Response", generateInfo(), generateFullImage());
            ai.addAndGet(- blocks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace(); 
        } 

    }

    private ImageIcon generateFullImage() throws IOException {
        SubViewRequestCallback cb;
        ImageInfo imageInfo;
        int w = (int)(width / Math.sqrt(blocks));
        BufferedImage partialImage;
        BufferedImage blockImage;
        BufferedImage fullImage = null;
        Graphics2D g;
        for (int i = 0; i < cbs.length; i++) {
            cb = cbs[i];
            imageInfo = cb.getImageInfo();
            partialImage = ImageIO.read(new URL(imageInfo.getImageUrl()));
            if (i == 0) {  // do this once just to initialize fullImage
                fullImage = new BufferedImage(width, height, partialImage.getType());
            }
            blockImage = new BufferedImage(w, w, partialImage.getType());
            g = blockImage.createGraphics();
            
            g.drawImage(partialImage, 0, 0, w, w, imageInfo.getTlx(), imageInfo.getTly(),
                    imageInfo.getBrx(), imageInfo.getBry(), null);
            g.dispose();
            // creates full image
            g = fullImage.createGraphics();
            g.drawImage(blockImage, imageInfo.getTlx(), imageInfo.getTly(), null);
            g.dispose();
        }
        return new ImageIcon(fullImage);
    }

    //make this generate beautiful info
    private String generateInfo() {
        long minRequestTime = cbs[0].getStartTime();
        long maxResponseTime = cbs[0].getEndTime();
        double averageTime=0;
        double duration;
        StringBuffer sb = new StringBuffer();
        int count = 0;
        int id;
        // relying on the verifier to give perfect squres for blocks
        int length = (int) Math.sqrt(blocks);
        for (SubViewRequestCallback cb : cbs) {
            if (cbs[count].getStartTime() < minRequestTime) {
                minRequestTime = cbs[count].getStartTime();
            }
            if (cbs[count].getEndTime() > maxResponseTime) {
                maxResponseTime = cbs[count].getEndTime();
            }
            duration = (cb.getEndTime() - cb.getStartTime())/1000;
            averageTime += duration;
            sb.append("\n_____________________________________");
            sb.append("\n  Partial File: (");
            id =cb.getImageInfo().getId();
            sb.append(id % length);
            sb.append(",");
            sb.append((int)Math.floor(id / length));
            sb.append(")");
            sb.append("\n"); 
            sb.append("    URL: ");
            sb.append(cb.getImageInfo().getImageUrl());
            sb.append("\n    Time: ");
            sb.append(duration);
            sb.append("s");
            count++;
        }
        StringBuffer top = new StringBuffer();
        top.append("Image Info:");
        top.append("\n_____________________________________");
        top.append("\n  Blocks: ");
        top.append(blocks);
        top.append("\n  Total Time: ");
        top.append((double) (maxResponseTime - minRequestTime) / 1000);
        top.append("s");
        top.append("\n  Avg. Time: ");
        top.append(averageTime / blocks);
        top.append("s");
        top.append(sb.toString());
        return top.toString();
    }
}
