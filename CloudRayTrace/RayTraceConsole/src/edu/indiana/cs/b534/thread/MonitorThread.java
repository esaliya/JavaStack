package edu.indiana.cs.b534.thread;

import com.amazonaws.elasticmapreduce.AmazonElasticMapReduce;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceConfig;
import com.amazonaws.elasticmapreduce.AmazonElasticMapReduceException;
import com.amazonaws.elasticmapreduce.model.*;
import edu.indiana.cs.b534.bean.StepInfo;
import edu.indiana.cs.b534.clients.EMClient;
import edu.indiana.cs.b534.clients.S3Client;
import edu.indiana.cs.b534.thread.callback.MonitorCallback;
import org.jets3t.service.S3ServiceException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MonitorThread implements Runnable{
    private boolean stop;
    private ConcurrentHashMap<String, StepInfo> stepMap;
    private S3Client s3c;
    private String dump;
    private AmazonElasticMapReduce service;
    private DescribeJobFlowsRequest request;
    

    public MonitorThread(String accessKey, String secretKey, S3Client s3c, String dump) {
        stepMap = new ConcurrentHashMap<String, StepInfo>();
        this.s3c = s3c;
        AmazonElasticMapReduceConfig config = new AmazonElasticMapReduceConfig();
        config.setSignatureVersion("0");
        service = new AmazonElasticMapReduceClient(accessKey, secretKey, config);
        request = new DescribeJobFlowsRequest();
        List<String> jobFlowIds = new LinkedList<String>();
        request.setJobFlowIds(jobFlowIds );
        this.dump = dump;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void subscribe(String stepName, StepInfo info) {
        stepMap.put(stepName, info);
    }

    public void run() {
        while (!stop) {
            while (stepMap.isEmpty()) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted\n" + e.getMessage());
                }
            }
            try {
                String stepName;
                StepInfo info;
                DescribeJobFlowsResponse response = service.describeJobFlows(request);
                if (response.isSetDescribeJobFlowsResult()) {
                    DescribeJobFlowsResult result = response.getDescribeJobFlowsResult();
                    List<JobFlowDetail> jobFlows = result.getJobFlows();
                    for (JobFlowDetail jobFlow : jobFlows) {
                        List<StepDetail> steps = jobFlow.getSteps();
                        for (StepDetail step : steps) {
                            if (step.isSetStepConfig()) {
                                stepName = step.getStepConfig().getName();
                                if (stepMap.containsKey(stepName)) {
                                    if (step.isSetExecutionStatusDetail()) {
                                        StepExecutionStatusDetail state = step.getExecutionStatusDetail();
                                        if ("COMPLETED".equals(state.getState())) {
                                            info = stepMap.get(stepName);
                                            stepMap.remove(stepName);
                                            s3c.get(info.getS3OutputPath(), dump);
                                            info.getCallback()
                                                    .onComplete(dump + File.separator + "part-00000",
                                                            state.getStartDateTime(),
                                                            state.getEndDateTime());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                Thread.sleep(15000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
