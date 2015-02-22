package edu.indiana.cs.b534;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import threeD.io.FileEncoder;
import threeD.raytracer.graphics.RGB;

import com.amazonaws.elasticmapreduce.*;
import com.amazonaws.elasticmapreduce.model.*;
import com.amazonaws.elasticmapreduce.mock.AmazonElasticMapReduceMock;

public class HadoopRayTracerClient {
	//partition the view picture by lines. example: 
	/* 	aaaaaaaaaaaa
   	aaaaaaaaaaaa
   	bbbbbbbbbbbb
   	bbbbbbbbbbbb*/ 	
	//input file format. example:	
	//minX=0;maxX=99;minY=0;maxY=24;locationX=0;locationY=-1;locationZ=10;directionX=0;directionY=0;directionZ=-1;imageWidth=100;imageHeight=100;
	public static void createInputFile(int numPartition, int imageHeight, int imageWidth, int lx,int ly,int lz,int dx,int dy, int dz){
		String inputFile = "input.txt";
		String strLine;
		int minX = 0;
		int maxX = imageWidth-1;
		int maxY,minY;

		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
			int step = imageHeight/numPartition;
			assert ((imageHeight%numPartition)==0);
			for (int i=0;i<numPartition;i++){
				minY = i*step;
				maxY = minY + step - 1;
				strLine = "id="+i+";minX=0;maxX=99;minY="+minY+";maxY="+maxY+";locationX="+lx+";locationY="+ly+";locationZ="+lz;
				strLine += ";directionX="+dx+";directionY="+dy+";directionZ="+dz+";imageWidth="+imageWidth+";imageHeight="+imageHeight+";";
				writer.write(strLine+"\n");
			}
			writer.flush();
			writer.close();
		}catch (IOException e){
			System.out.println(e.toString());
		}
	}

	//TODO
	public static void upLoadInputFile(String localFilePath, String s3nInputDir){

	}

	//TODO
	// return the abstract path of output file
	public static String downloadOutputFile(String s3nOutputDir, String localOutDir){
		return "";
	}

	//TODO
	// transfer the hadoop output result into RGB, and encoded as picture
	// return the path of picture.

	public static String getSubBlock(String strLine, int index){

		int i1, i2;
		while ( (i1=strLine.indexOf("<id>"))>=0 ){
			strLine = strLine.substring(i1+4);
			i2 = strLine.indexOf("</id>");
			i1 = Integer.parseInt(strLine.substring(0, i2));
			if (i1 == index){
				strLine = strLine.substring(i2+5,strLine.indexOf("</block>"));
				return strLine;
			}
		}
		return null;
	}

	public static String String2Image(String inputFile, int numPartition, int imageHeight, int imageWidth){
		inputFile = "./part-000001";
		String outputFile = "./outputImage.jpg";

		try{
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String strLine = reader.readLine();
			String strTmp = "";
			for (int i = 0; i<numPartition; i++){
				strTmp = getSubBlock(strLine,i); 

			}

			//public static RGB[][] String2RGB(String value) {
			String[] bounds = strLine.split("=");
			String[] split1 = bounds[2].split("-");
			RGB[][] rgbMatrix = new RGB[Integer.parseInt(bounds[1])][Integer.parseInt(bounds[1])];
			for (int i = 0; i < split1.length; i++) {
				String row = split1[i].trim();
				if (!"".equals(row)) {
					String[] rgbs = row.split(",");
					for (int j = 0; j < rgbs.length; j++) {
						String rgb = rgbs[j];
						String[] vals = rgb.split("#");
						rgbMatrix[i][j] = new RGB(Double.parseDouble(vals[0].trim()),
								Double.parseDouble(vals[1].trim()), Double
								.parseDouble(vals[2].trim()));
					}
				}
			}
			FileEncoder.encodeImageFile(rgbMatrix,new File(outputFile),6);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return outputFile;
	}
    static String accessKeyId,secretAccessKey,s3nJarPath,s3nInputPath,s3nOutputPath,s3nLogPath;
    static String jobFlowName;
    
	public static void main(String... args) {
		System.out.println(" ----------------------");
		
		/************************************************************************
			accessKeyId,secretAccessKey,s3nJarPath,s3nInputPath,s3nOutputPath,s3nLogPath are static parameters that store in configure file
			imageHeight,imageWidth, location, direction, num of partitions, are dynamic parameters that pass through args[] of main and part 5.
		 ************************************************************************/
		if (args.length != 10){
			System.out.println("usage: jar HadoopRayTracerClient [configure file path][num of partition]" +
			"[imageHeight] [imageWidth] [lx] [ly] [lz] [dx] [dy] [dz]");
			System.exit(-1);
		}
		int numPartitions = Integer.parseInt(args[1]);
		int imageHeight = Integer.parseInt(args[2]);
		int imageWidth = Integer.parseInt(args[3]);
		int lx = Integer.parseInt(args[4]);
		int ly = Integer.parseInt(args[5]);
		int lz = Integer.parseInt(args[6]);
		int dx = Integer.parseInt(args[7]);
		int dy = Integer.parseInt(args[8]);
		int dz = Integer.parseInt(args[9]);

		createInputFile(numPartitions,imageHeight,imageWidth,lx,ly,lz,dx,dy,dz);

		String configureFile = args[0];
		File file = new File(configureFile);
		
		accessKeyId = secretAccessKey = s3nJarPath = s3nInputPath = s3nOutputPath = s3nLogPath = "";

		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			accessKeyId = reader.readLine();
			secretAccessKey = reader.readLine();
			s3nJarPath = reader.readLine();
			s3nInputPath = reader.readLine();
			s3nOutputPath = reader.readLine();
			s3nLogPath = reader.readLine();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		String curDir = System.getProperty("user.dir");
		upLoadInputFile(curDir+"/input.txt",s3nInputPath);

		System.out.println("	[debug] instances:"+numPartitions);
		System.out.println("	[debug] s3nLogPath:"+s3nLogPath);
		System.out.println("	[debug] s3nOutputPath:"+s3nOutputPath);
		System.out.println("	[debug] s3nInputPath:"+s3nInputPath);
		System.out.println("	[debug] s3nJarPath:"+s3nJarPath);
		System.out.println("	[debug] secretAccessKey:"+secretAccessKey);
		/************************************************************************
		 * Instantiate Http Client Implementation of Amazon Elastic Map Reduce
		 ***********************************************************************/
		AmazonElasticMapReduceConfig config = new AmazonElasticMapReduceConfig();
		config.setSignatureVersion("0");
		// config.set
		
		AmazonElasticMapReduce service = new AmazonElasticMapReduceClient(
				accessKeyId, secretAccessKey, config);
		
		
		RunJobFlowRequest request = new RunJobFlowRequest();

		// @TODO: set request parameters here
		int numInstances = numPartitions; //number of map tasks. 

		JobFlowInstancesConfig conf = new JobFlowInstancesConfig();
		conf.setEc2KeyName("raytracer");
		conf.setInstanceCount(numInstances);
		conf.setKeepJobFlowAliveWhenNoSteps(true);
		conf.setMasterInstanceType("m1.small");
		conf.setPlacement(new PlacementType("us-east-1a"));
		conf.setSlaveInstanceType("m1.small");

		request.setInstances(conf);
		request.setLogUri(s3nLogPath);//"s3n://b534.hui/raytracer/log");
		jobFlowName = "rayTracer-job-flow-" + new Date().toString();
		jobFlowName = formatString(jobFlowName);
		System.err.println("jobFlowName:"+jobFlowName);
		request.setName(jobFlowName);
		String stepname = "Step" + System.currentTimeMillis();
		List<StepConfig> steps = new LinkedList<StepConfig>();
		StepConfig stepConfig = new StepConfig();
		stepConfig.setActionOnFailure("CANCEL_AND_WAIT");
		HadoopJarStepConfig jarsetup = new HadoopJarStepConfig();
		List<String> arguments = new LinkedList<String>();
		arguments.add(s3nInputPath);//"s3n://b534.hui/raytracer/input/");
		arguments.add(s3nOutputPath+jobFlowName+"/"+stepname+"/");
		System.out.println("	outputPath: "+s3nOutputPath+jobFlowName+"/"+stepname+"/");
		jarsetup.setArgs(arguments);
		jarsetup.setJar(s3nJarPath);//"s3n://b534.hui/raytracer/HadoopRayTracer.jar");
		//jarsetup.setMainClass("edu.indiana.cs.b534.HadoopRayTracer");
		stepConfig.setHadoopJarStep(jarsetup);
		stepConfig.setName(stepname);
		steps.add(stepConfig);
		request.setSteps(steps);

		double beginTime = System.currentTimeMillis();
		//String jobFlowId = "j-3GPW9ZAHGI0P6";
		String jobFlowId = invokeRunJobFlow(service, request);

		DescribeJobFlowsRequest getJobFlowStatusrequest = new DescribeJobFlowsRequest();
        
        List<String> jobFlowIds = new LinkedList<String>();
        //jobFlowIds.add("j-145HTJL98ON1");
        try{
        Thread.sleep(1000);
        }catch(Exception e){
        	System.out.println("Thread sleep 1 second.");
        }
        jobFlowIds.add(jobFlowId);
        getJobFlowStatusrequest.setJobFlowIds(jobFlowIds );
        String jobFlowStatus = getStatus(service, getJobFlowStatusrequest,"jobFlowStatus");
        double endTime = System.currentTimeMillis();
        
		System.out.println("invokeRunJobFlow take:"+(endTime-beginTime)/1000 + "sec");
		String stepStatus = getStatus(service, getJobFlowStatusrequest,"stepStatus");
		
		//Terminate Job Flows  !
		
		if (jobFlowStatus.equals("WAITING")&&stepStatus.equals("COMPLETED")){
		System.out.println("setp complete terminate JobFlows!");
		try{
		TerminateJobFlowsRequest terminateJobFlowrequest = new TerminateJobFlowsRequest();
		terminateJobFlowrequest.setJobFlowIds(jobFlowIds);
		service.terminateJobFlows(terminateJobFlowrequest);
		}catch(Exception e){
			System.out.println("terminateJobFlows error");
		}
		}
		System.out.println("jobFlowStatus:"+jobFlowStatus+" stepStatus:"+stepStatus);
	}

	public static String formatString(String val){
		String ret = val.replace("-", "_");
		ret = ret.replace(" ", "_");
		return ret.replace(":", "_");
	}
	
	public static String addJobStep(AmazonElasticMapReduce service){
		AddJobFlowStepsRequest request = new AddJobFlowStepsRequest();
		String stepName = "Step" + System.currentTimeMillis();
		System.err.println(stepName);
		//request.setJobFlowId("j-1BS71HJL020AR");
		
		List<StepConfig> steps = new LinkedList<StepConfig>();
		StepConfig stepConfig = new StepConfig();
		stepConfig.setActionOnFailure("CANCEL_AND_WAIT");
		HadoopJarStepConfig jarsetup = new HadoopJarStepConfig();
		List<String> arguments = new LinkedList<String>();
		//,,,s3nLogPath;
		arguments.add(s3nInputPath);
		arguments.add(s3nOutputPath+jobFlowName +"/"+stepName+"/");
		jarsetup.setArgs(arguments);
		jarsetup.setJar(s3nJarPath);
		jarsetup.setMainClass("edu.indiana.extreme.HadoopRayTracer");
		stepConfig.setHadoopJarStep(jarsetup);
		stepConfig.setName(stepName);
		steps.add(stepConfig);
		request.setSteps(steps);
		try{
		service.addJobFlowSteps(request);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return null;
	}
	/**
	 * Run Job Flow request sample
	 * 
	 * @param service
	 *            instance of AmazonElasticMapReduce service
	 * @param request
	 *            Action to invoke
	 */
	// statusType   jobFlowStatus	stepStatus
	public static String getStatus(AmazonElasticMapReduce service, DescribeJobFlowsRequest request, String statusType){
		String returnStatus = null;
		
		try {
			DescribeJobFlowsResponse response = service.describeJobFlows(request);
			if (response.isSetDescribeJobFlowsResult()) {
				DescribeJobFlowsResult  describeJobFlowsResult = response.getDescribeJobFlowsResult();
				java.util.List<JobFlowDetail> jobFlowsList = describeJobFlowsResult.getJobFlows();
				for (JobFlowDetail jobFlows : jobFlowsList) {
					if (jobFlows.isSetJobFlowId()) {
						System.out.println("                JobFlowId");
						System.out.println("                    " + jobFlows.getJobFlowId());
					}
					if (jobFlows.isSetName()) {
						System.out.println("                Name");
						System.out.println("                    " + jobFlows.getName());
					}
					if (jobFlows.isSetExecutionStatusDetail()) {
						System.out.println("                ExecutionStatusDetail");
						JobFlowExecutionStatusDetail  executionStatusDetail = jobFlows.getExecutionStatusDetail();
						if (executionStatusDetail.isSetState()) {
							System.out.println("                    State");
							System.out.println("                        " + executionStatusDetail.getState());
							if (statusType.equals("jobFlowStatus"))
								returnStatus = executionStatusDetail.getState();
						}
						if (executionStatusDetail.isSetCreationDateTime()) {
							System.out.println("                    CreationDateTime");
							System.out.println("                        " + executionStatusDetail.getCreationDateTime());
						}
						if (executionStatusDetail.isSetStartDateTime()) {
							System.out.println("                    StartDateTime");
							System.out.println("                        " + executionStatusDetail.getStartDateTime());
						}
						if (executionStatusDetail.isSetEndDateTime()) {
							System.out.println("                    EndDateTime");
							System.out.println("                        " + executionStatusDetail.getEndDateTime());
						}
						if (executionStatusDetail.isSetLastStateChangeReason()) {
							System.out.println("                    LastStateChangeReason");
							System.out.println("                        " + executionStatusDetail.getLastStateChangeReason());
						}
					} 
					if (jobFlows.isSetInstances()) {
						System.out.println("                Instances");
						JobFlowInstancesDetail  instances = jobFlows.getInstances();
						if (instances.isSetInstanceCount()) {
							System.out.println("                    InstanceCount");
							System.out.println("                        " + instances.getInstanceCount());
						}
					} 
					java.util.List<StepDetail> stepsList = jobFlows.getSteps();
					for (StepDetail steps : stepsList) {
						if (steps.isSetExecutionStatusDetail()) {
							System.out.println("                    ExecutionStatusDetail");
							StepExecutionStatusDetail  executionStatusDetail1 = steps.getExecutionStatusDetail();
							if (executionStatusDetail1.isSetState()) {
								System.out.println("                        State");
								System.out.println("                            " + executionStatusDetail1.getState());
								if (statusType.equals("stepStatus"))
									returnStatus = executionStatusDetail1.getState();
							}
							if (executionStatusDetail1.isSetCreationDateTime()) {
								System.out.println("                        CreationDateTime");
								System.out.println("                            " + executionStatusDetail1.getCreationDateTime());
							}
							if (executionStatusDetail1.isSetStartDateTime()) {
								System.out.println("                        StartDateTime");
								System.out.println("                            " + executionStatusDetail1.getStartDateTime());
							}
							if (executionStatusDetail1.isSetEndDateTime()) {
								System.out.println("                        EndDateTime");
								System.out.println("                            " + executionStatusDetail1.getEndDateTime());
							}
							if (executionStatusDetail1.isSetLastStateChangeReason()) {
								System.out.println("                        LastStateChangeReason");
								System.out.println("                            " + executionStatusDetail1.getLastStateChangeReason());
							}
						} 
					}
				}
			} 
			System.out.println();
		} catch (AmazonElasticMapReduceException ex) {
			System.out.println("Caught Exception: " + ex.getMessage());
			System.out.println("Response Status Code: " + ex.getStatusCode());
			System.out.println("Error Code: " + ex.getErrorCode());
			System.out.println("Error Type: " + ex.getErrorType());
			System.out.println("Request ID: " + ex.getRequestId());
			System.out.print("XML: " + ex.getXML());
		}
		return returnStatus;
	}

	public static String invokeRunJobFlow(AmazonElasticMapReduce service,
			RunJobFlowRequest request) {
		String jobFlowId = null;
		try {
			RunJobFlowResponse response = service.runJobFlow(request);
			System.out.println("RunJobFlow Action Response");
			System.out.println("=============================================================================");
			System.out.println("    RunJobFlowResponse");
			if (response.isSetRunJobFlowResult()) {
				System.out.println("        RunJobFlowResult");
				RunJobFlowResult runJobFlowResult = response
				.getRunJobFlowResult();
				if (runJobFlowResult.isSetJobFlowId()) {
					System.out.println("            JobFlowId");
					System.out.println("                " + runJobFlowResult.getJobFlowId());
					jobFlowId = runJobFlowResult.getJobFlowId();
				}
			}
			if (response.isSetResponseMetadata()) {
				System.out.println("        ResponseMetadata");
				ResponseMetadata responseMetadata = response.getResponseMetadata();
				if (responseMetadata.isSetRequestId()) {
					System.out.println("            RequestId");
					System.out.println("                "
							+ responseMetadata.getRequestId());
				}
			}
			System.out.println("RunJobFlow finished.");
			System.out.println("=============================================================================");
		} catch (AmazonElasticMapReduceException ex) {
			System.out.println("Caught Exception: " + ex.getMessage());
			System.out.println("Response Status Code: " + ex.getStatusCode());
			System.out.println("Error Code: " + ex.getErrorCode());
			System.out.println("Error Type: " + ex.getErrorType());
			System.out.println("Request ID: " + ex.getRequestId());
			System.out.print("XML: " + ex.getXML());
		}
		return jobFlowId;
	}
}