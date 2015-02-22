/******************************************************************************* 
 *  Copyright 2008 Amazon Technologies, Inc.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *    __  _    _  ___ 
 *   (  )( \/\/ )/ __)
 *   /__\ \    / \__ \
 *  (_)(_) \/\/  (___/
 * 
 *  Amazon Elastic Map Reduce Java Library
 *  API Version: 2009-03-31
 *  Generated: Tue Apr 21 15:28:09 PDT 2009 
 * 
 */

package com.amazonaws.elasticmapreduce.samples;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import com.amazonaws.elasticmapreduce.*;
import com.amazonaws.elasticmapreduce.model.*;
import com.amazonaws.elasticmapreduce.mock.AmazonElasticMapReduceMock;

/**
 * 
 * Run Job Flow Samples
 * 
 * 
 */
public class RunJobFlowSample {

	/**
	 * Just add few required parameters, and try the service Run Job Flow
	 * functionality
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String... args) {

		String accessKeyId = "AKIAJQCPHO3V27LDQRMQ";
		String secretAccessKey = "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";

		AmazonElasticMapReduceConfig config = new AmazonElasticMapReduceConfig();
		config.setSignatureVersion("0");

        AmazonElasticMapReduce service = new AmazonElasticMapReduceClient(
				accessKeyId, secretAccessKey, config);


        JobFlowInstancesConfig conf = new JobFlowInstancesConfig();
        conf.setEc2KeyName("saliya-key-pair");
        conf.setInstanceCount(4);
        conf.setKeepJobFlowAliveWhenNoSteps(true);
        conf.setMasterInstanceType("m1.small");
        conf.setPlacement(new PlacementType("us-east-1a"));
        conf.setSlaveInstanceType("m1.small");

        RunJobFlowRequest request = new RunJobFlowRequest();
        request.setInstances(conf);
		request.setLogUri("s3n://saliya/api/log");
//		String jobFlowName = "Class-job-flow" + new Date().toString();
		String jobFlowName = Utils.formatString("api-test-3");
		request.setName(jobFlowName);

        List<String> arguments = new LinkedList<String>();
        arguments.add("s3n://saliya/api/input/");
//		arguments.add("s3n://saliya/api/output/"+jobFlowName+"/"+stepName+"/");
        arguments.add("s3n://saliya/api/output/");

        HadoopJarStepConfig jarSetup = new HadoopJarStepConfig();
        jarSetup.setArgs(arguments);
        jarSetup.setJar("s3n://saliya/api/rtfat.jar");
//        jarSetup.setMainClass("edu.indiana.cs.b534.RayTraceMR");

        StepConfig stepConfig = new StepConfig();
        stepConfig.setName("Step-1");
        stepConfig.setActionOnFailure("CANCEL_AND_WAIT");
        stepConfig.setHadoopJarStep(jarSetup);

        List<StepConfig> steps = new LinkedList<StepConfig>();
        steps.add(stepConfig);

		request.setSteps(steps);

		invokeRunJobFlow(service, request);

	}

	/**
	 * Run Job Flow request sample
	 * 
	 * @param service
	 *            instance of AmazonElasticMapReduce service
	 * @param request
	 *            Action to invoke
	 */
	public static void invokeRunJobFlow(AmazonElasticMapReduce service,
			RunJobFlowRequest request) {
		try {

			RunJobFlowResponse response = service.runJobFlow(request);

			System.out.println("RunJobFlow Action Response");
			System.out
					.println("=============================================================================");
			System.out.println();

			System.out.println("    RunJobFlowResponse");
			System.out.println();
			if (response.isSetRunJobFlowResult()) {
				System.out.println("        RunJobFlowResult");
				System.out.println();
				RunJobFlowResult runJobFlowResult = response
						.getRunJobFlowResult();
				if (runJobFlowResult.isSetJobFlowId()) {
					System.out.println("            JobFlowId");
					System.out.println();
					System.out.println("                "
							+ runJobFlowResult.getJobFlowId());
					System.out.println();
				}
			}
			if (response.isSetResponseMetadata()) {
				System.out.println("        ResponseMetadata");
				System.out.println();
				ResponseMetadata responseMetadata = response
						.getResponseMetadata();
				if (responseMetadata.isSetRequestId()) {
					System.out.println("            RequestId");
					System.out.println();
					System.out.println("                "
							+ responseMetadata.getRequestId());
					System.out.println();
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
	}

}
