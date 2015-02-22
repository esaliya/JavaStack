package cgl.imr.samples.interpolation.bio.mimds;


import cgl.imr.base.*;
import cgl.imr.base.impl.JobConf;
import cgl.imr.base.impl.MapperConf;
import cgl.imr.samples.interpolation.type.Point;
import cgl.imr.samples.interpolation.type.SequencePoint;
import cgl.imr.samples.interpolation.util.Constants;
import cgl.imr.samples.interpolation.util.FileOperation;
import edu.indiana.salsahpc.Alphabet;
import edu.indiana.salsahpc.Sequence;
import edu.indiana.salsahpc.SequenceParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InterpolationMapper  {
	String sampleCoordinates;
	String sampleFasta;
	int kValue;
	int mapTaskNo;
	String type;
	String inputPrefix;
	String inputFolder;
	String idxFile;
	String outputPrefix;

	public void close() throws TwisterException {
		// TODO Auto-generated method stub
	}

	public void configure(JobConf jobConf, int mapTaskNo)
			throws TwisterException {
		//System.out.println("Starting configuration!");
		sampleCoordinates = jobConf.getProperty(Constants.SAMPLE_COORDINATES);
		sampleFasta = jobConf.getProperty(Constants.SAMPLE_FASTA);
		kValue = Integer.parseInt(jobConf.getProperty(Constants.KVALUE));
		type = jobConf.getProperty(Constants.TYPE);
		this.mapTaskNo = mapTaskNo;
		inputPrefix = jobConf.getProperty(Constants.OUTSAMPLE_PREFIX);
		inputFolder = jobConf.getProperty(Constants.OUTSAMPLE_FOLDER);
		idxFile = jobConf.getProperty(Constants.IDX_FILE);
		outputPrefix = jobConf.getProperty(Constants.OUTPUT_PREFIX);
		
		//System.out.println("Finish configuraton!");
	}

	public void map()
			throws TwisterException {
		String inputFile = (inputFolder + "/" + inputPrefix).replaceAll("//", "/") + mapTaskNo;
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(idxFile));
			String line;
			String[] tokens;
			int offset = -1;
			while((line = br.readLine())!=null){
				tokens = line.split("\t");
				if(Integer.parseInt(tokens[0]) == mapTaskNo){
					offset = Integer.parseInt(tokens[4]);
					break;
				}
			}
			br.close();
			
			List<Sequence> sampleSequences = SequenceParser.parse(sampleFasta, Alphabet.Protein);
			List<Point> samplePoints = FileOperation.readPoints(sampleCoordinates, "\t");
			List<SequencePoint> sampleSet = new ArrayList<SequencePoint>();
			for(int i = 0; i < sampleSequences.size(); ++i)
				sampleSet.add(new SequencePoint(sampleSequences.get(i), samplePoints.get(i)));
			
			List<Sequence> outSampleSequences = SequenceParser.parse(inputFile, Alphabet.Protein);
			List<SequencePoint> outSampleSet = new ArrayList<SequencePoint>();
			for(int i = 0; i < outSampleSequences.size(); ++i)
				outSampleSet.add(new SequencePoint(outSampleSequences.get(i), null));
			
			List<Point> points = Interpolation.MIMDS(sampleSet, outSampleSet, kValue, type, offset);

			System.out.println("Key: " + mapTaskNo + "\tValue: " + points.size());
			String outputFile = (inputFolder + "/" + outputPrefix + mapTaskNo).replaceAll("//", "/");
			FileOperation.writeToFile(outputFile, points);
			System.out.println(mapTaskNo + "finished");
		} catch (Exception e) {
			throw new TwisterException(e);
		}
	}
}
