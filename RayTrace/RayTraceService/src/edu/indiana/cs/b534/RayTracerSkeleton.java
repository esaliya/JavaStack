/**
 * RayTracerSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package edu.indiana.cs.b534;

import edu.indiana.extreme.DistributedRayTracer;
import edu.indiana.extreme.SceneVectorGraphics;
import org.apache.axis2.AxisFault;
import threeD.io.FileEncoder;
import threeD.raytracer.graphics.RGB;
import threeD.raytracer.util.Vector;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.UUID;
/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 * @author Li, Hui
 */

/**
 * Class <code>RayTracerSkeleton</code> contains the business logic
 * for of <code>RayTracer</code> service.
 */
public class RayTracerSkeleton {

    public RayTraceResponse rayTrace(RayTrace rayTrace) throws AxisFault {
        RayTraceResponse response = new RayTraceResponse();
        try {
            edu.indiana.cs.b534.CameraSetup cameraInfo = rayTrace.getCamera();
            Point3D direction = cameraInfo.getDirection();
            Point3D location = cameraInfo.getLocation();
            edu.indiana.extreme.CameraSetup cameraSetup = new edu.indiana.extreme.CameraSetup(
                    new Vector(location.getX(), location.getY(), location.getZ()),
                    new Vector(direction.getX(), direction.getY(), direction.getZ())
            );
            String url = rayTrace.getSceneURL();
            SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL(url));

            DistributedRayTracer tracer = new DistributedRayTracer();
            RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder, rayTrace.getImageWidth(),
                    rayTrace.getImageHeight());

            ArrayOfRGBColor[] array = new ArrayOfRGBColor[rgbArray.length];
            RGBColor rgbColorArray[];
            RGBColor rgbColor;
            RGB rgb;
            for (int i = 0; i < rgbArray.length; i++) {
                array[i] = new ArrayOfRGBColor();
                rgbColorArray = new RGBColor[rgbArray[i].length];
                for (int j = 0; j < rgbArray[i].length; j++) {
                    rgb = rgbArray[i][j];

                    rgbColor = new RGBColor();
                    rgbColor.setRed(rgb.getRed());
                    rgbColor.setGreen(rgb.getGreen());
                    rgbColor.setBlue(rgb.getBlue());

                    rgbColorArray[j] = rgbColor;
                }
                array[i].setArray(rgbColorArray);
            }

            response.set_return(array);
        } catch (IOException e) {
            throw new AxisFault("IO Exception in RayTrace", e);
        }
        return response;
    }

    public RayTraceMovieResponse rayTraceMovie(RayTraceMovie rayTraceMovie) throws AxisFault {
        RayTraceMovieResponse resp = new RayTraceMovieResponse();
        try {
            String url = rayTraceMovie.getSceneURL();
            SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL(url));
            int width = rayTraceMovie.getImageWidth();
            int height = rayTraceMovie.getImageHeight();

            CameraSetup[] cameraArray = rayTraceMovie.getCamera();
            DistributedRayTracer tracer = new DistributedRayTracer();
            RGB[][] rgbArray;
            String imageURL [] = new String [cameraArray.length];
            CameraSetup camera;
            Point3D direction;
            Point3D location;
            UUID uuid;
            File file;
            for (int i=0; i<cameraArray.length; i++) {
                camera = cameraArray[i];
                direction = camera.getDirection();
                location = camera.getLocation();
                edu.indiana.extreme.CameraSetup cameraSetup = new edu.indiana.extreme.CameraSetup(
                        new Vector(location.getX(), location.getY(), location.getZ()),
                        new Vector(direction.getX(), direction.getY(), direction.getZ())
                );
                rgbArray = tracer.rayTrace(cameraSetup, sceneHolder, width, height);
                uuid = UUID.randomUUID();
                file = new File(uuid.toString() + ".jpg");
                FileEncoder.encodeImageFile(rgbArray, file, 6);
                imageURL[i] = file.toURI().toURL().toString();
            }
            resp.setImageURL(imageURL);
        } catch (IOException e) {
            throw new AxisFault("IO Exception in RayTraceMovie", e);
        }
        return resp;
    }

    public RayTraceSubViewResponse rayTraceSubView(RayTraceSubView rayTraceSubView) throws AxisFault {
        RayTraceSubViewResponse resp = new RayTraceSubViewResponse();
        try {
            CameraSetup cameraInfo = rayTraceSubView.getCamera();
            Point3D direction = cameraInfo.getDirection();
            Point3D location = cameraInfo.getLocation();
            edu.indiana.extreme.CameraSetup cameraSetup = new edu.indiana.extreme.CameraSetup(
                    new Vector(location.getX(), location.getY(), location.getZ()),
                    new Vector(direction.getX(), direction.getY(), direction.getZ())
            );
            String url = rayTraceSubView.getSceneURL();
            SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL(url));

            Rectangle rectangle = rayTraceSubView.getSubView();
            int width = (int) (rectangle.getMaxX() - rectangle.getMinX() + 1);
            int height = (int) (rectangle.getMaxY() - rectangle.getMinY() + 1);
            java.awt.Rectangle block = new java.awt.Rectangle(
                    (int) rectangle.getMinX(), (int) rectangle.getMinY(), width, height);

            DistributedRayTracer tracer = new DistributedRayTracer();
            RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder, rayTraceSubView.getImageWidth(),
                    rayTraceSubView.getImageHeight(), block);

            UUID uuid = UUID.randomUUID();
            File file = new File(uuid.toString() + ".jpg");
            FileEncoder.encodeImageFile(rgbArray, file, 6);
            resp.setImageURL(file.toURI().toURL().toString());
        } catch (IOException e) {
            throw new AxisFault("IO Exception in RayTraceURL", e);
        }
        return resp;
    }

    public RayTraceURLResponse rayTraceURL(RayTraceURL rayTraceURL) throws AxisFault {
        RayTraceURLResponse resp = new RayTraceURLResponse();
        try {
            CameraSetup cameraInfo = rayTraceURL.getCamera();
            Point3D direction = cameraInfo.getDirection();
            Point3D location = cameraInfo.getLocation();
            edu.indiana.extreme.CameraSetup cameraSetup = new edu.indiana.extreme.CameraSetup(
                    new Vector(location.getX(), location.getY(), location.getZ()),
                    new Vector(direction.getX(), direction.getY(), direction.getZ())
            );
            String url = rayTraceURL.getSceneURL();
            SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL(url));

            DistributedRayTracer tracer = new DistributedRayTracer();
            RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder,
                    rayTraceURL.getImageWidth(), rayTraceURL.getImageHeight());

            UUID uuid = UUID.randomUUID();
            File file = new File(uuid.toString() + ".jpg");
            FileEncoder.encodeImageFile(rgbArray, file, 6);
            resp.setImageURL(file.toURI().toURL().toString());
        } catch (IOException e) {
            throw new AxisFault("IO Exception in RayTraceURL", e);
        }
        return resp;
    }

}
