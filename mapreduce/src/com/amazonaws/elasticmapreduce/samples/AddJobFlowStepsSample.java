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

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import com.amazonaws.elasticmapreduce.*;
import com.amazonaws.elasticmapreduce.model.*;
import com.amazonaws.elasticmapreduce.mock.AmazonElasticMapReduceMock;

/**
 * 
 * Add Job Flow Steps Samples
 * 
 * 
 */
public class AddJobFlowStepsSample {

	/**
	 * Just add few required parameters, and try the service Add Job Flow Steps
	 * functionality
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String... args) {

		/************************************************************************
		 * Access Key ID and Secret Acess Key ID, obtained from:
		 * http://aws.amazon.com
		 ***********************************************************************/

		String accessKeyId = "AKIAI4BKZTNUUMWFMJ5Q";
		String secretAccessKey = "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";

		
		/************************************************************************
		 * Instantiate Http Client Implementation of Amazon Elastic Map Reduce
		 ***********************************************************************/
		AmazonElasticMapReduce service = new AmazonElasticMapReduceClient(
				accessKeyId, secretAccessKey);

		/************************************************************************
		 * Uncomment to try advanced configuration options. Available options
		 * are:
		 * 
		 * - Signature Version - Proxy Host and Proxy Port - Service URL - User
		 * Agent String to be sent to Amazon Elastic Map Reduce service
		 * 
		 ***********************************************************************/
		// AmazonElasticMapReduceConfig config = new
		// AmazonElasticMapReduceConfig();
		// config.setSignatureVersion("0");
		// AmazonElasticMapReduce service = new
		// AmazonElasticMapReduceClient(accessKeyId, secretAccessKey, config);
		/************************************************************************
		 * Uncomment to try out Mock Service that simulates Amazon Elastic Map
		 * Reduce responses without calling Amazon Elastic Map Reduce service.
		 * 
		 * Responses are loaded from local XML files. You can tweak XML files to
		 * experiment with various outputs during development
		 * 
		 * XML files available under com/amazonaws/elasticmapreduce/mock tree
		 * 
		 ***********************************************************************/
		// AmazonElasticMapReduce service = new AmazonElasticMapReduceMock();
		/************************************************************************
		 * Setup request parameters and uncomment invoke to try out sample for
		 * Add Job Flow Steps
		 ***********************************************************************/
		AddJobFlowStepsRequest request = new AddJobFlowStepsRequest();
		String stepName = "Step" + System.currentTimeMillis();
		System.err.println(stepName);
		
		request.setJobFlowId("j-1BS71HJL020AR");
		String jobFlowName = "Class_job_flowSun_Mar_07_18_36_07_EST_2010";
		
		List<StepConfig> steps = new LinkedList<StepConfig>();
		StepConfig stepConfig = new StepConfig();
		stepConfig.setActionOnFailure("CANCEL_AND_WAIT");
		HadoopJarStepConfig jarsetup = new HadoopJarStepConfig();
		List<String> arguments = new LinkedList<String>();
		arguments.add("s3n://b534/inputs/");
//		
//		arguments.add("s3n://b534/outputs/t1/");
		arguments.add("s3n://b534/outputs/"+jobFlowName +"/"+stepName+"/");
		
		jarsetup.setArgs(arguments);
		jarsetup.setJar("s3n://b534/Hadoopv21.jar");
		jarsetup.setMainClass("edu.indiana.extreme.HadoopRayTracer");
		stepConfig.setHadoopJarStep(jarsetup);
		
		stepConfig.setName(stepName);
		steps.add(stepConfig);

		request.setSteps(steps);

		invokeAddJobFlowSteps(service, request);

	}

	/**
	 * Add Job Flow Steps request sample
	 * 
	 * @param service
	 *            instance of AmazonElasticMapReduce service
	 * @param request
	 *            Action to invoke
	 */
	public static void invokeAddJobFlowSteps(AmazonElasticMapReduce service,
			AddJobFlowStepsRequest request) {
		try {

			AddJobFlowStepsResponse response = service.addJobFlowSteps(request);

			System.out.println("AddJobFlowSteps Action Response");
			System.out
					.println("=============================================================================");
			System.out.println();

			System.out.println("    AddJobFlowStepsResponse");
			System.out.println();
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
