package edu.indiana.cs.b534.client.callback;

import edu.indiana.cs.b534.client.stub.RayTracerCallbackHandler;
import edu.indiana.cs.b534.client.stub.RayTracerStub;
import edu.indiana.cs.b534.client.ui.ResponseUI;
import threeD.raytracer.graphics.GraphicsConverter;
import threeD.raytracer.graphics.RGB;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Class <code>SimpleRequestCallback</code> extends the
 * <code>RayTracerCallbackHandler</code> to give custom
 * call back facility for simple requests. Once a response
 * is received it will call off an instance of <code>ResponseUI</code>
 * with correct information.
 */
public class SimpleRequestCallback extends RayTracerCallbackHandler {
    private ImageIcon icon;

    private long startTime;
    private long endTime;
    private AtomicInteger ai;

    public SimpleRequestCallback(AtomicInteger ai) {
        this.ai = ai;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    private String generateSimpleInfo(String url) {
        StringBuffer sb = new StringBuffer();
        sb.append("Image Info:");
        sb.append("\n_____________________________________");
        sb.append("\n  Total Time: ");
        sb.append((double) (endTime - startTime) / 1000);
        sb.append("s");
        sb.append("\n  Dimensions: ");
        sb.append(icon.getIconWidth());
        sb.append(" X ");
        sb.append(icon.getIconHeight());
        if (url != null && !"".equals(url)) {
            sb.append("\n  URL: ");
            sb.append(url);
        }
        return sb.toString();
    }

    // todo: complete this if you have time
    private String generateErrorInfo(Exception e) {
        return "" + e.getMessage();
    }

    @Override
    public void receiveResultrayTrace(RayTracerStub.RayTraceResponse result) {
        endTime = System.currentTimeMillis();
        RayTracerStub.ArrayOfRGBColor[] matrix = result.get_return();
        RayTracerStub.RGBColor row[];
        RayTracerStub.RGBColor color;
        RGB[][] bytes = new RGB[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            row = matrix[i].getArray();
            bytes[i] = new RGB[row.length];
            for (int j = 0; j < row.length; j++) {
                color = row[j];
                bytes[i][j] = new RGB(color.getRed(), color.getGreen(), color.getBlue());
            }
        }
        icon = new ImageIcon(GraphicsConverter.convertToAWTImage(bytes));
        new ResponseUI("Image Received from RayTrace", generateSimpleInfo(null), icon);
        ai.decrementAndGet();
    }

    @Override
    public void receiveErrorrayTrace(Exception e) {
        new ResponseUI("Error occurred", generateErrorInfo(e), new ImageIcon());
        ai.decrementAndGet();
    }

    @Override
    public void receiveResultrayTraceMovie(RayTracerStub.RayTraceMovieResponse result) {
        endTime = System.currentTimeMillis();
        String [] urls = result.getImageURL();
        ImageIcon [] icons = new ImageIcon[urls.length];
        try {
            for (int i = 0; i < urls.length; i++) {
                icons[i] = new ImageIcon(new URL(urls[i]));
            }
            icon = icons[0]; // assignment just for generating info
            new ResponseUI("Images Received from RayTraceMovie" ,generateSimpleInfo(null), icons);
        } catch (MalformedURLException e) {
            new ResponseUI("Error occurred", generateErrorInfo(e), new ImageIcon());
        } finally {
            ai.decrementAndGet();
        }
    }

    @Override
    public void receiveErrorrayTraceMovie(Exception e) {
        new ResponseUI("Error occurred", generateErrorInfo(e), new ImageIcon());
        ai.decrementAndGet();
    }

    @Override
    public void receiveResultrayTraceURL(RayTracerStub.RayTraceURLResponse result) {
        endTime = System.currentTimeMillis();
        try {
            icon = new ImageIcon(new URL(result.getImageURL()));
            new ResponseUI("Image Received from RayTraceURL",
                    generateSimpleInfo(result.getImageURL()), icon);
        } catch (MalformedURLException e) {
            new ResponseUI("Error occurred", generateErrorInfo(e), new ImageIcon());
        } catch (IOException e) {
            new ResponseUI("Error occurred", generateErrorInfo(e), new ImageIcon());
        } finally {
            ai.decrementAndGet();
        }
    }

    @Override
    public void receiveErrorrayTraceURL(Exception e) {
        new ResponseUI("Error occurred", generateErrorInfo(e), new ImageIcon());
        ai.decrementAndGet();
    }
}
