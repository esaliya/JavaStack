package edu.indiana.cs.b534.client;

import edu.indiana.cs.b534.stub.RayTracerCallbackHandler;
import edu.indiana.cs.b534.stub.RayTracerStub;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import org.apache.axis2.description.Parameter;
import threeD.io.FileEncoder;
import threeD.raytracer.graphics.RGB;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class RayTraceClient {

	public void rayTrace(){
		try{
          RayTracerStub stub = new RayTracerStub("http://129.79.49.91:8080/axis2/services/RayTracer?wsdl");
          RayTracerStub.RayTrace rt = new RayTracerStub.RayTrace();
          RayTracerStub.CameraSetup camSetup = new RayTracerStub.CameraSetup();
          RayTracerStub.Point3D location = new RayTracerStub.Point3D();
          location.setX(0.0);
          location.setY(-1.0);
          location.setZ(10.0);
          camSetup.setLocation(location);

          RayTracerStub.Point3D direction = new RayTracerStub.Point3D();
          direction.setX(0.0);
          direction.setY(0.0);
          direction.setZ(-1.0);
          camSetup.setDirection(direction);

          rt.setCamera(camSetup);
          rt.setImageHeight(100);
          rt.setImageWidth(100);
          rt.setSceneURL("http://pagodatree.cs.indiana.edu:9999/temp/RenderDemo.xml");
          
          stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(2*60*1000);
          RayTracerStub.RayTraceResponse resp = stub.rayTrace(rt);
          RayTracerStub.ArrayOfRGBColor [] matrix = resp.get_return();
          RayTracerStub.RGBColor row[];
          RayTracerStub.RGBColor color;
          RGB [][] bytes = new RGB[matrix.length][];
          for (int i = 0; i < matrix.length; i++) {
              row = matrix[i].getArray();
              bytes[i] = new RGB[row.length];
              for (int j = 0; j < row.length; j++) {
                  color = row[j];
                  bytes[i][j] = new RGB(color.getRed(), color.getGreen(), color.getBlue());
              }
          }//end for i
          FileEncoder.encodeImageFile(bytes, new File(".\\RayTraceClient\\rendered\\rayTrace.jpg"), 6);
          System.out.println("rayTrace() return");
      } catch (AxisFault axisFault) {
          axisFault.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (RemoteException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (IOException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
	}
	public void rayTraceULR(){
		try {
	          RayTracerStub stub = new RayTracerStub("http://129.79.49.91:8080/axis2/services/RayTracer?wsdl");
	          RayTracerStub.RayTraceURL rtUrl = new RayTracerStub.RayTraceURL();

	            RayTracerStub.CameraSetup camSetup = new RayTracerStub.CameraSetup();
	            RayTracerStub.Point3D location = new RayTracerStub.Point3D();
	            location.setX(0.0);
	            location.setY(-1.0);
	            location.setZ(10.0);
	            camSetup.setLocation(location);

	            RayTracerStub.Point3D direction = new RayTracerStub.Point3D();
	            direction.setX(0.0);
	            direction.setY(0.0);
	            direction.setZ(-1.0);
	            camSetup.setDirection(direction);

	            rtUrl.setCamera(camSetup);
	            rtUrl.setImageHeight(100);
	            rtUrl.setImageWidth(100);
	            rtUrl.setSceneURL("http://pagodatree.cs.indiana.edu:9999/temp/RenderDemo.xml");

	            stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(2*60*1000);
	            RayTracerStub.RayTraceURLResponse resp = stub.rayTraceURL(rtUrl);
	            System.out.println(resp.getImageURL());
		        System.out.println("rayTraceULR() return");

		        //System.in.read();
	        } catch (AxisFault axisFault) {
	            axisFault.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        } catch (RemoteException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        } catch (IOException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }
	}

	public void rayTraceSubView(){
		//TODO
	}

	private String getTextVal(Element ele, String tagName){
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl!=null && nl.getLength()>0){
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}
	
	public void rayTraceMovie(){
		
		
		try{
		RayTracerStub stub = new RayTracerStub("http://129.79.49.91:8080/axis2/services/RayTracer?wsdl");
        RayTracerStub.RayTraceMovie rtm = new RayTracerStub.RayTraceMovie();
    
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse("input.xml");
		Element docEle = dom.getDocumentElement();

		NodeList nl = docEle.getElementsByTagName("scene");
		String scene = nl.item(0).getFirstChild().getNodeValue();
        rtm.setSceneURL(scene);
		
		nl = docEle.getElementsByTagName("image");
		int imageWidth = Integer.parseInt(getTextVal((Element)nl.item(0),"width"));
		int imageHeight = Integer.parseInt(getTextVal((Element)nl.item(0),"height"));
		rtm.setImageHeight(imageHeight);
        rtm.setImageWidth(imageWidth);

		nl = docEle.getElementsByTagName("camera");
		for(int i=0;i<nl.getLength();i++){
		System.out.println("parsing input.xml");
		Element ele = (Element)nl.item(i);
			
        RayTracerStub.CameraSetup camSetup = new RayTracerStub.CameraSetup();
        RayTracerStub.Point3D location = new RayTracerStub.Point3D();  
      	NodeList n2 = ele.getElementsByTagName("location");
      	location.setX(Integer.parseInt(getTextVal((Element)n2.item(0),"x")));
      	location.setY(Integer.parseInt(getTextVal((Element)n2.item(0),"y")));
      	location.setZ(Integer.parseInt(getTextVal((Element)n2.item(0),"z")));
      	camSetup.setLocation(location);

        RayTracerStub.Point3D direction = new RayTracerStub.Point3D();
        n2 = ele.getElementsByTagName("direction");
        direction.setX(Integer.parseInt(getTextVal((Element)n2.item(0),"x")));
        direction.setY(Integer.parseInt(getTextVal((Element)n2.item(0),"y")));
        direction.setZ(Integer.parseInt(getTextVal((Element)n2.item(0),"z")));
        camSetup.setDirection(direction);
        rtm.addCamera(camSetup);
        
        /*  TODO setup rectangle?
		n2 = ele.getElementsByTagName("rectangle");
		System.out.println("minx:"+ getTextVal((Element)n2.item(0),"minx"));
		System.out.println("miny:"+ getTextVal((Element)n2.item(0),"miny"));
		System.out.println("maxx:"+ getTextVal((Element)n2.item(0),"maxx"));
		System.out.println("maxy:"+ getTextVal((Element)n2.item(0),"maxy"));
		*/
        
		}//end for nl.getLength
		System.out.println("rayTraceULR() invoked");
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(2*60*1000);
        RayTracerStub.RayTraceMovieResponse resp = stub.rayTraceMovie(rtm);
        String[] result = resp.getImageURL();
        for (int i=0;i<result.length;i++){
        System.out.println(result[i]);
        }
	    System.out.println("rayTraceULR() return");
	        //System.in.read();
      } catch (AxisFault axisFault) {
          axisFault.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (RemoteException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (IOException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (Exception e){
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }   
	
	
	}
	
    public static void main(String[] args) {
    	RayTraceClient rtc = new RayTraceClient();
    	//rtc.rayTraceULR();
    	//rtc.rayTrace();
    	//rtc.rayTraceSubView();
    	rtc.rayTraceMovie();
    	//rtc.rayTrace();
    }
    
   }
