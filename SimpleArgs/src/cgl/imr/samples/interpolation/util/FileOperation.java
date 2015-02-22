package cgl.imr.samples.interpolation.util;

import cgl.imr.samples.interpolation.type.CrandallData;
import cgl.imr.samples.interpolation.type.Point;
import cgl.imr.samples.interpolation.type.Vec3D;
import edu.indiana.salsahpc.Sequence;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileOperation {
	
	
	public static List<Point> readPoints(String filePath,
			String separator) throws IOException{
		List<Point> points = new ArrayList<Point>();
		BufferedReader br = new BufferedReader(
				new FileReader(filePath));
		String line;
		String[] tokens;
		
		//int id = 0;
		//br.readLine();
		while((line = br.readLine())!= null){
			tokens = line.split(separator);
			if(tokens.length >= 5){
				Point point = new Point();
				Vec3D position = new Vec3D(Double.parseDouble(tokens[1]),
						Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
				//if(tokens[0].charAt(0) == 65279)
				//	tokens[0] = tokens[0].substring(1);
				//System.out.println("len: " + tokens[0].length());
				//System.out.println(tokens[0].charAt(0));
				//System.out.println("ASCII: " + (int)tokens[0].charAt(0));
				//System.out.println("ASCII: " + (int)tokens[0].charAt(1));
				point.setId(Integer.parseInt(tokens[0]));
				point.setPosition(position);
				point.setGroup(Integer.parseInt(tokens[4]));
				if(tokens.length > 5)
					point.setLabel(tokens[5]);
				points.add(point);
			}
		}
		br.close();
		//writeToFile(filePath, points);
		return points;
	}
	
	public static List<CrandallData> readCrandallData(String filePath) throws IOException{
		BufferedReader br = new BufferedReader(
				new FileReader(filePath));
		String line;
		String[] tokens;
		String[] dataTokens;
		short[] data;
		//int id = 0;
		List<CrandallData> cds = new ArrayList<CrandallData>();
		while((line = br.readLine())!= null){
			tokens = line.split("\t");
			String id = tokens[0];
			dataTokens = tokens[1].split(" ");
			data = new short[dataTokens.length];
			for(int i = 0; i < dataTokens.length; i++){
				data[i] = Short.parseShort(dataTokens[i]);
			}
			CrandallData cd = new CrandallData(id, data.length, data);
			cds.add(cd);
		}
		br.close();
		return cds;
	}
	
	public static HashSet<String> getStringSet(String fileName) throws Exception{
		HashSet<String> names = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		while((line = br.readLine())!= null){
			if(line.length() > 0)
				names.add(line);
		}
		br.close();
		return names;
	}
	
	public static String[] getLines(String fileName, int dataSize) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		String[] lines = new String[dataSize];
		int count = 0;
		while((line = br.readLine()) != null){
			lines[count] = line;
			count++;
		}
		br.close();
		
		return lines;
	}
	
	public static void writeToFile(String filePath, List<Point> points) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for(Point point: points){
			bw.write(point.getId() + "\t"
					+ point.getPosition().getX() + "\t"
					+ point.getPosition().getY() + "\t"
					+ point.getPosition().getZ() + "\t"
					+ point.getGroup() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void writeSequenceToFile(List<Sequence> sequences, String filePath) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for(Sequence s: sequences){
			bw.write(s.getId() + "\n");
			bw.write(s.toString() + "\n");
		}
		bw.flush();
		bw.close();}
}
