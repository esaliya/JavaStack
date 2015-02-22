package edu.indiana.cs.b534;
		
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapred.lib.NLineInputFormat;

import edu.indiana.extreme.DistributedRayTracer;
import edu.indiana.extreme.SceneVectorGraphics;
//import edu.indiana.cs.b534.Point3D;
//import org.apache.log4j.spi.LoggingEvent;
import threeD.raytracer.graphics.RGB;
import threeD.raytracer.graphics.GraphicsConverter;
import threeD.raytracer.util.Vector;
import threeD.io.FileEncoder;
import java.text.DecimalFormat;
		
public class HadoopRayTracer {
		
	public static RGB[][] String2RGB(String value) {
		String[] bounds = value.split("=");
		String[] split1 = bounds[2].split("-");
		RGB[][] ret = new RGB[Integer.parseInt(bounds[0])][Integer.parseInt(bounds[1])];
		for (int i = 0; i < split1.length; i++) {
			String row = split1[i].trim();
			if (!"".equals(row)) {
				String[] rgbs = row.split(",");
				for (int j = 0; j < rgbs.length; j++) {
					String rgb = rgbs[j];
					String[] vals = rgb.split("#");
					ret[i][j] = new RGB(Double.parseDouble(vals[0].trim()),
							Double.parseDouble(vals[1].trim()), Double
									.parseDouble(vals[2].trim()));
				}
			}
		}
		return ret;
	}	
		
	public static String RGB2String(RGB[][] rgb) {
		StringBuffer ret = new StringBuffer();
		DecimalFormat myFormatter = new DecimalFormat("0.0000000000");
		ret.append(rgb.length+"="+rgb[0].length+"=");
		for (int i = 0; i < rgb.length; i++) {
			RGB[] rgbs = rgb[i];
			for (int j = 0; j < rgbs.length; j++) {
				RGB rgb2 = rgbs[j];
				ret.append(myFormatter.format(rgb2.getRed()) + "#" + myFormatter.format(rgb2.getGreen()) + "#"
						+ myFormatter.format(rgb2.getBlue()));
				ret.append(",");
			}
			ret.append("-");
		}
		return ret.toString();
	}

	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

		String outputFileDir;// = "D:\\DeveloperSoftware\\apache-tomcat-6.0.24\\webapps\\pictures\\";
		edu.indiana.extreme.CameraSetup cameraSetup;
		java.awt.Rectangle rectSetup;
		String url = "http://pagodatree.cs.indiana.edu:9999/temp/RenderDemo.xml";
		SceneVectorGraphics sceneHolder;// = new SceneVectorGraphics(new URL(url));
		String jobLocalDir;
		int imageWidth, imageHeight;
		
		@Override
		public void configure(JobConf conf){
			jobLocalDir = conf.getJobLocalDir();
			System.out.println("[map task debug msg] configure jobLocalDir:"+jobLocalDir);
		}
		
		private int parseParameter(String inputLine, String parameter){
			int index;
			index = inputLine.indexOf(parameter);
			index += parameter.length()+1;
 			inputLine = inputLine.substring(index);
 			inputLine = inputLine.substring(0,inputLine.indexOf(";"));
			return Integer.parseInt(inputLine);
		}

		@Override
		public void map(LongWritable key, Text value,OutputCollector<Text, Text> output, Reporter reporter)
				throws IOException {
			
			String inputLine = value.toString();
			//input = "minX=0;maxX=50;minY=0;maxY=50;locationX=0;locationY=-1;locationZ=10;directionX=0;directionY=0;directionZ=-1;imageWidth=100;imageHeight=100;"
			//construct the cameraSetup
			int locationX = parseParameter(inputLine,"locationX");
			int locationY = parseParameter(inputLine,"locationY");
			int locationZ = parseParameter(inputLine,"locationZ");
			int directionX = parseParameter(inputLine,"directionX");
			int directionY = parseParameter(inputLine,"directionY");
			int directionZ = parseParameter(inputLine,"directionZ");
			cameraSetup = new edu.indiana.extreme.CameraSetup(
					new Vector(locationX, locationY, locationZ),
                    new Vector(directionX, directionY, directionZ));
			System.out.println("location:<"+locationX+","+locationY+","+locationZ+",>");
			System.out.println("location:<"+directionX+","+directionY+","+directionZ+",>");
			
			//construct the rectSetup
	        int minX = parseParameter(inputLine,"minX");
	        int maxX = parseParameter(inputLine,"maxX");
	        int minY = parseParameter(inputLine,"minY");
	        int maxY = parseParameter(inputLine,"maxY");
	        System.out.println("x1,y1:<"+minX+","+minY+",>");
	        System.out.println("x2,y2:<"+maxX+","+maxY+",>");
	    	rectSetup = new java.awt.Rectangle();
	        rectSetup.setLocation(minX, maxY);// left upper point of rectangle
	        rectSetup.setSize(maxX-minX, maxY-minY);
	
	        //construct the sceneHolder
	        sceneHolder = new SceneVectorGraphics(new URL(url));
	        imageWidth = parseParameter(inputLine,"imageWidth");
	        imageHeight = parseParameter(inputLine,"imageHeight");
	        System.out.println("imageWidth:"+imageWidth+" imageHeight:"+imageHeight);
	        
	        DistributedRayTracer tracer = new DistributedRayTracer();
	        RGB[][] rgbArray = tracer.rayTrace(cameraSetup, sceneHolder, imageWidth, imageHeight, rectSetup);
	        
	        Image image = GraphicsConverter.convertToAWTImage(rgbArray);
	        //String imageFileName = "./subView_"+key.toString()+".jpg"; 
	        //System.out.println("[map task debug msg] subview file name:"+imageFileName);

	        /*networkFilePathName += key.toString()+"subView.jpg";
	        try{
	        FileEncoder.encodeImageFile(rgbArray,new File(imageFileName),6);
	        }catch(Exception e){
	        	//String fileName = "./subView_"+key.toString()+".jpg";
	        	System.out.println("[map task handle error. recode image file] :"+imageFileName);
	        	System.out.println(e.toString());
	        }*/
	        
	        output.collect(new Text("reduce-key"), new Text("head"+RGB2String(rgbArray)));
		}		
	}//Map
	 	
	public static class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>{
		/*
		int imageWidth;
		int imageHeight;
		int numMapTasks;
		int numPartitions;
		
		@Override
		public void configure(JobConf conf){
			numMapTasks = conf.getNumMapTasks();
			imageWidth = Integer.parseInt(conf.get("imageHeight"));
			imageHeight = Integer.parseInt(conf.get("imageWidth"));
			numPartitions = Integer.parseInt(conf.get("numPartitions"));
		}*/
		
		@Override
		public void reduce(Text key, Iterator<Text> values,OutputCollector<Text, Text> output, Reporter arg3)
				throws IOException {
		String collect = "";
		while (values.hasNext()){
			Text text = (Text)values.next();
			collect += text.toString() + ":";
		}
		output.collect(new Text("subview_file"), new Text (collect));
		}//reduce
	}//Reduce
	
	/**
	 * @param args
	 * @throws URISyntaxException 
	 */
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("		[HadoopRayTracer]");
		System.out.println("class location:"+HadoopRayTracer.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		
		JobConf conf = new JobConf(HadoopRayTracer.class);
		conf.setJobName("rayTrace");
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		conf.setMapperClass(Map.class);
		conf.setReducerClass(Reduce.class);
		//conf.setJarByClass(HadoopRayTracer.class);
		conf.setInputFormat(NLineInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		System.out.println("args length:"+args.length);
		if (null == args || args.length != 2){
			System.out.println("HadoopRayTracer Usage:"+
					"java edu.indiana.cs.b534.HadoopRayTracer [s3n input dir] [s3n output dir] ");
			System.exit(1);
		}
		
		FileInputFormat.setInputPaths(conf, new Path(args[0]));//s3n://b534.hui/rayTracer/input/
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));//s3n://b534.hui/rayTracer/output/
		//conf.set("imageHeight", args[2]);
		//conf.set("imageWidth", args[3]);
		//conf.set("numPartitions", args[4]);
		System.out.println("job start...");
		conf.setNumReduceTasks(1);
		JobClient.runJob(conf);		
		//System.out.println("job finished.");
	}//main
}