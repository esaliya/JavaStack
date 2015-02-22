/**
 * RayTracerSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package edu.indiana.cs.b534;

import edu.indiana.extreme.DistributedRayTracer;
import edu.indiana.extreme.SceneVectorGraphics;

//import edu.indiana.extreme.CameraSetup;
import threeD.raytracer.graphics.RGB;
import threeD.raytracer.graphics.GraphicsConverter;
import threeD.raytracer.util.Vector;
import threeD.io.FileEncoder;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.awt.Image;

/**
 * RayTracerSkeleton java skeleton for the axisService
 */
public class RayTracerSkeleton {

    public RayTraceResponse rayTrace(RayTrace rayTrace) {
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
            //tracer.rayTrace(cameraInformation, sceneHolder, imageWidth, imageHeight)
            RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder,rayTrace.getImageWidth(), rayTrace.getImageHeight());
            
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
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return response;
    }

    public RayTraceMovieResponse rayTraceMovie(RayTraceMovie rayTraceMovie) {
    	
    	try{
    	RayTraceMovieResponse response = new RayTraceMovieResponse();
    	edu.indiana.cs.b534.CameraSetup[] cameraInfo = rayTraceMovie.getCamera();
    	
    	String url = rayTraceMovie.getSceneURL();
        SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL(url));
        
        for (int i = 0; i < cameraInfo.length; i++) {
        	Point3D direction = cameraInfo[i].getDirection();
            Point3D location = cameraInfo[i].getLocation();
            edu.indiana.extreme.CameraSetup cameraSetup = new edu.indiana.extreme.CameraSetup(
                    new Vector(location.getX(), location.getY(), location.getZ()),
                    new Vector(direction.getX(), direction.getY(), direction.getZ())
            );
            
            int imageHeight = rayTraceMovie.getImageHeight();
            int imageWidth = rayTraceMovie.getImageWidth();
                       
            DistributedRayTracer tracer = new DistributedRayTracer();
            RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder, imageWidth, imageHeight);
            Image image = GraphicsConverter.convertToAWTImage(rgbArray);
            String fileName = "movie_"+i+".jpg";
            String localFileFullPathName = "D:\\DeveloperSoftware\\apache-tomcat-6.0.24\\webapps\\pictures\\"+fileName;
            String networkFilePathName = "http://129.79.49.91:8080/pictures/"+fileName;
            FileEncoder.encodeImageFile(rgbArray,new File(localFileFullPathName),6);
            response.addImageURL(networkFilePathName);     
    	}//end for
    	
    	return response;
    	} catch (IOException e){
    		e.printStackTrace();
    	return null;
    	}//try   	
    }

    public RayTraceSubViewResponse rayTraceSubView(RayTraceSubView rayTraceSubView) {
    	
    	try{
    		RayTraceSubViewResponse response = new RayTraceSubViewResponse();
    		edu.indiana.cs.b534.CameraSetup cameraInfo = rayTraceSubView.getCamera();
        	        	
        	String url = rayTraceSubView.getSceneURL();
            SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL(url));
            String localFileFullPathName = "D:\\DeveloperSoftware\\apache-tomcat-6.0.24\\webapps\\pictures\\";
            String networkFilePathName = "http://129.79.49.91:8080/pictures/";
        	
        	Point3D direction = cameraInfo.getDirection();
            Point3D location = cameraInfo.getLocation();
            
            edu.indiana.extreme.CameraSetup cameraSetup = new edu.indiana.extreme.CameraSetup(
                        new Vector(location.getX(), location.getY(), location.getZ()),
                        new Vector(direction.getX(), direction.getY(), direction.getZ())
            );
            
            edu.indiana.cs.b534.Rectangle rectInfo = rayTraceSubView.getSubView();
            //Rectangle rectSetup = new Rectangle();
            java.awt.Rectangle rectSetup = new java.awt.Rectangle();
            rectSetup.setLocation((int)rectInfo.getMinX(), (int)rectInfo.getMaxY());// left upper point of rectangle
            rectSetup.setSize((int)(rectInfo.getMaxX()-rectInfo.getMinX()), (int)(rectInfo.getMaxY()-rectInfo.getMinY()));
            		
            int imageHeight = rayTraceSubView.getImageHeight();
            int imageWidth = rayTraceSubView.getImageWidth();
                        
            DistributedRayTracer tracer = new DistributedRayTracer();
            
            RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder, imageWidth, imageHeight, rectSetup);
            Image image = GraphicsConverter.convertToAWTImage(rgbArray);
            localFileFullPathName += "subView.jpg";
            networkFilePathName += "subView.jpg";
            FileEncoder.encodeImageFile(rgbArray,new File(localFileFullPathName),6);
        	
            response.setImageURL(networkFilePathName);    
        	return response;
        	} catch (IOException e){
        		e.printStackTrace();
        	return null;
        	}//try
    }

    public RayTraceURLResponse rayTraceURL(RayTraceURL rayTraceURL) {
    	try{
    		RayTraceURLResponse response = new RayTraceURLResponse();
    		edu.indiana.cs.b534.CameraSetup cameraInfo = rayTraceURL.getCamera();
        	        	
        	String url = rayTraceURL.getSceneURL();
            SceneVectorGraphics sceneHolder = new SceneVectorGraphics(new URL(url));
            String localFileFullPathName = "D:\\DeveloperSoftware\\apache-tomcat-6.0.24\\webapps\\pictures\\";
            String networkFilePathName = "http://129.79.49.91:8080/pictures/";
        	
        	Point3D direction = cameraInfo.getDirection();
            Point3D location = cameraInfo.getLocation();
            
            edu.indiana.extreme.CameraSetup cameraSetup = new edu.indiana.extreme.CameraSetup(
                        new Vector(location.getX(), location.getY(), location.getZ()),
                        new Vector(direction.getX(), direction.getY(), direction.getZ())
            );
            
            int imageHeight = rayTraceURL.getImageHeight();
            int imageWidth = rayTraceURL.getImageWidth();
            
            DistributedRayTracer tracer = new DistributedRayTracer();
            RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder, imageWidth, imageHeight);
            Image image = GraphicsConverter.convertToAWTImage(rgbArray);
            localFileFullPathName += "rayTraceURL.jpg";
            networkFilePathName += "rayTraceURL.jpg";
            FileEncoder.encodeImageFile(rgbArray,new File(localFileFullPathName),6);
        	
            response.setImageURL(networkFilePathName);    
        	return response;
        	} catch (IOException e){
        		e.printStackTrace();
        	return null;
        	}//try
    }

}
