package edu.indiana.cs.b534.clients;

import com.amazonaws.elasticmapreduce.AmazonElasticMapReduce;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceConfig;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceException;
import com.amazonaws.elasticmapreduce.model.*;
import edu.indiana.cs.b534.bean.StepInfo;
import edu.indiana.cs.b534.thread.MonitorThread;
import edu.indiana.cs.b534.ui.ResponseUI;
import org.jets3t.service.S3ServiceException;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class EMClient {
    private String accessKey;
    private String secretKey;
    private String keyPair;
    private String jarPath;
    private String jarName;
    private String dump;

    private S3Client s3c;
    private AmazonElasticMapReduce service;
    private MonitorThread mt;

    public EMClient(String accessKey, String secretKey, String keyPair,
                    S3Client s3c, String jarPath, String dump, MonitorThread mt) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.keyPair = keyPair;
        this.s3c = s3c;
        this.jarPath = jarPath;
        this.jarName = jarPath.substring(jarPath.lastIndexOf(File.separator)+1);
        this.dump = dump;
        this.mt = mt;

        AmazonElasticMapReduceConfig config = new AmazonElasticMapReduceConfig();
        config.setSignatureVersion("0");
        service = new AmazonElasticMapReduceClient(accessKey, secretKey, config);
    }

    public S3Client getS3Client() {
        return s3c;
    }

    public String getDump() {
        return dump;
    }

    public MonitorThread getMonitor() {
        return mt;
    }

    public void terminateJobFlow(String jobFlowId) throws AmazonElasticMapReduceException {
        TerminateJobFlowsRequest request = new TerminateJobFlowsRequest();
        List<String> jobFlows = new LinkedList<String>();
        jobFlows.add(jobFlowId);
        request.setJobFlowIds(jobFlows);
        TerminateJobFlowsResponse resp = service.terminateJobFlows(request);
        System.out.println("  Job Flow Killed.\n    Job Flow ID " + jobFlowId);
    }
    public void rt(String configFile, String bucketName, int instances)
            throws IOException, NoSuchAlgorithmException, S3ServiceException, AmazonElasticMapReduceException {
        String name = "RTS_" + formatString(new Date().toString());
        String stepName = UUID.randomUUID().toString();
        String s3Folder = bucketName + "/" + name;

        s3c.put(jarPath, s3Folder);
        String inputFile = createInputFile(configFile, stepName);
        s3c.put(inputFile, s3Folder + "/input/" + stepName);
        createSingleStepJobFlow(s3Folder, name, stepName, instances);
    }

    public String createWaitingJobFlow(String s3Folder, String name, int instances)
            throws IOException, NoSuchAlgorithmException, S3ServiceException, AmazonElasticMapReduceException {
        s3c.put(jarPath, s3Folder);
        JobFlowInstancesConfig conf = new JobFlowInstancesConfig();
        conf.setEc2KeyName(keyPair);
        conf.setInstanceCount(instances);
        conf.setKeepJobFlowAliveWhenNoSteps(true);
        conf.setMasterInstanceType("m1.small");
        conf.setPlacement(new PlacementType("us-east-1a"));
        conf.setSlaveInstanceType("m1.small");

        RunJobFlowRequest request = new RunJobFlowRequest();
        request.setInstances(conf);
		request.setLogUri("s3n://" + s3Folder + "/log/");
		request.setName(name);
        RunJobFlowResponse response = service.runJobFlow(request);
        return response.getRunJobFlowResult().getJobFlowId();
    }

    public void addJobFlowStep(String s3Folder, String stepName, String jobFlowId, String inputFile)
            throws IOException, NoSuchAlgorithmException, S3ServiceException, AmazonElasticMapReduceException {
        s3c.put(inputFile, s3Folder + "/input/" + stepName);
        AddJobFlowStepsRequest request = new AddJobFlowStepsRequest();
        List<String> arguments = new LinkedList<String>();
        arguments.add("s3n://" + s3Folder + "/input/" + stepName + "/");
        arguments.add("s3n://" + s3Folder + "/output/" + stepName + "/");

        HadoopJarStepConfig jarSetup = new HadoopJarStepConfig();
        jarSetup.setArgs(arguments);
        jarSetup.setJar("s3n://" + s3Folder + "/" + jarName);

        StepConfig stepConfig = new StepConfig();
        stepConfig.setName(stepName);
        stepConfig.setActionOnFailure("CANCEL_AND_WAIT");
        stepConfig.setHadoopJarStep(jarSetup);

        List<StepConfig> steps = new LinkedList<StepConfig>();
        steps.add(stepConfig);
		request.setSteps(steps);
        request.setJobFlowId(jobFlowId);
        service.addJobFlowSteps(request);
    }
    
    private void createSingleStepJobFlow(String s3Folder, String name, String stepName, int instances)
            throws AmazonElasticMapReduceException {
        JobFlowInstancesConfig conf = new JobFlowInstancesConfig();
        conf.setEc2KeyName(keyPair);
        conf.setInstanceCount(instances);
        conf.setKeepJobFlowAliveWhenNoSteps(false);
        conf.setMasterInstanceType("m1.small");
        conf.setPlacement(new PlacementType("us-east-1a"));
        conf.setSlaveInstanceType("m1.small");

        RunJobFlowRequest request = new RunJobFlowRequest();
        request.setInstances(conf);
		request.setLogUri("s3n://" + s3Folder + "/log/" + stepName + "/");
		request.setName(name);

        List<String> arguments = new LinkedList<String>();
        arguments.add("s3n://" + s3Folder + "/input/" + stepName + "/");
        arguments.add("s3n://" + s3Folder + "/output/" + stepName + "/");

        HadoopJarStepConfig jarSetup = new HadoopJarStepConfig();
        jarSetup.setArgs(arguments);
        jarSetup.setJar("s3n://" + s3Folder + "/" + jarName);

        StepConfig stepConfig = new StepConfig();
        stepConfig.setName(stepName);
        stepConfig.setActionOnFailure("CANCEL_AND_WAIT");
        stepConfig.setHadoopJarStep(jarSetup);

        List<StepConfig> steps = new LinkedList<StepConfig>();
        steps.add(stepConfig);

		request.setSteps(steps);
        StepInfo info = new StepInfo(s3Folder + "/output/" + stepName + "/part-00000", new ResponseUI(stepName));
        mt.subscribe(stepName, info);
		RunJobFlowResponse resp = service.runJobFlow(request);
        if (resp.isSetRunJobFlowResult()) {
            System.out.println("  Job Flow Created.\n    Job ID: " + resp.getRunJobFlowResult().getJobFlowId());
        }
    }

    private String createInputFile(String configFile, String stepName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(configFile));
        String location = reader.readLine().split("=")[1];
        String direction = reader.readLine().split("=")[1];
        int imgW = Integer.parseInt(reader.readLine().split("=")[1]);
        int imgH = Integer.parseInt(reader.readLine().split("=")[1]);
        int n = Integer.parseInt(reader.readLine().split("=")[1]);
        boolean square = Boolean.parseBoolean(reader.readLine().split("=")[1]);

        File f = new File(dump + File.separator + stepName + ".txt");
        PrintWriter writer = new PrintWriter(f);
        if (square) {
            int steps = (int) Math.sqrt(n);
            int blockWidth = imgW / steps;
            int blockHeight = imgH / steps;
            int minX, minY, maxX, maxY;
            for (int i = 0; i < steps; i++) {
                for (int j = 0; j < steps; j++) {
                    minX = i * blockWidth;
                    maxX = minX + blockWidth - 1;
                    minY = j * blockHeight;
                    maxY = minY + blockHeight - 1;
                    writer.println(minX + ";" + maxX + ";" + minY + ";" + maxY + ";" + location +
                            ";" + direction + ";" + imgW + ";" + imgH);
                }
            }
        } else {
            int blockHeight = imgH / n;
            int minX = 0; int maxX = imgW - 1;
            int minY, maxY;
            for (int i = 0; i < n; i++) {
                minY = i * blockHeight;
                maxY = minY + blockHeight - 1;
                writer.println(minX + ";" + maxX + ";" + minY + ";" + maxY + ";" + location +
                        ";" + direction + ";" + imgW + ";" + imgH);
            }
        }
        writer.close();
        return f.getAbsolutePath();
    }

    public String formatString(String val) {
        String ret = val.replace("-", "_");
        ret = ret.replace(" ", "_");
        return ret.replace(":", "_");
    }
}
