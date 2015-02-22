package edu.indiana.cs.b534;

import com.amazonaws.elasticmapreduce.AmazonElasticMapReduce;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceConfig;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceException;
import com.amazonaws.elasticmapreduce.model.*;
import edu.indiana.cs.b534.clients.S3Client;
import org.jets3t.service.S3ServiceException;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

public class RayTracePerf2 {
    static String accessKey;
       static String secretKey;
       static String keyPair;

       static String jarPath;
       static String jarName;

       static int [] sizes = {300, 240, 180, 120, 60};
       static String location = "0;-1;10";
       static String direction = "0;0;-1";

       static S3Client s3c;

    public static void main(String[] args) throws IOException, S3ServiceException, NoSuchAlgorithmException, AmazonElasticMapReduceException {
           BufferedReader reader = new BufferedReader(new FileReader(args[0]));
           accessKey = reader.readLine();
           secretKey = reader.readLine();
           keyPair = reader.readLine();
           reader.close();
           s3c = new S3Client(accessKey, secretKey);
           jarPath = args[1];
           jarName = jarPath.substring(jarPath.lastIndexOf(File.separator) + 1);

           String name = "Multi_Size_2";
           String s3Folder = args[2] + "/" + name;

           createAndUploadInputs(2, s3Folder);
           s3c.put(jarPath, s3Folder);

        createMultiStepJobFlow(s3Folder, name);
       }

       public static void createAndUploadInputs(int blocks, String s3Folder)
               throws IOException, NoSuchAlgorithmException, S3ServiceException {
           for (int n : sizes) {
               File f = new File("inputs\\input" + n + ".txt");
               PrintWriter writer = new PrintWriter(f);
               int blockHeight = n / blocks;
               int minX = 0;
               int maxX = n - 1;
               int minY, maxY;
               for (int j = 0; j < blocks; j++) {
                   minY = j * blockHeight;
                   maxY = minY + blockHeight - 1;
                   writer.println(minX + ";" + maxX + ";" + minY + ";" + maxY + ";" + location +
                           ";" + direction + ";" + n + ";" + n);
               }
               writer.close();
               s3c.put(f.getAbsolutePath(), s3Folder + "/input/" + n);
           }
       }

       public static void createMultiStepJobFlow(String s3Folder, String name)
               throws AmazonElasticMapReduceException {
           AmazonElasticMapReduceConfig config = new AmazonElasticMapReduceConfig();
           config.setSignatureVersion("0");

           AmazonElasticMapReduce service = new AmazonElasticMapReduceClient(
                   accessKey, secretKey, config);

           JobFlowInstancesConfig conf = new JobFlowInstancesConfig();
           conf.setEc2KeyName(keyPair);
           conf.setInstanceCount(2); // max num of instances
           conf.setKeepJobFlowAliveWhenNoSteps(false);
           conf.setMasterInstanceType("c1.medium");
           conf.setPlacement(new PlacementType("us-east-1a"));
           conf.setSlaveInstanceType("c1.medium");

           RunJobFlowRequest request = new RunJobFlowRequest();
           request.setInstances(conf);
           request.setLogUri("s3n://" + s3Folder + "/log/");
           request.setName(name);


           List<StepConfig> steps = new LinkedList<StepConfig>();
           for (int n : sizes) {
               List<String> arguments = new LinkedList<String>();
               arguments.add("s3n://" + s3Folder + "/input/" + n + "/");
               arguments.add("s3n://" + s3Folder + "/output/" + n + "/");
               HadoopJarStepConfig jarSetup = new HadoopJarStepConfig();
               jarSetup.setArgs(arguments);
               jarSetup.setJar("s3n://" + s3Folder + "/" + jarName);

               StepConfig stepConfig = new StepConfig();
               stepConfig.setName("Step" + n);
               stepConfig.setActionOnFailure("CANCEL_AND_WAIT");
               stepConfig.setHadoopJarStep(jarSetup);
               steps.add(stepConfig);
           }
           request.setSteps(steps);
           service.runJobFlow(request);
       }


}
