package edu.indiana.cs.b534.bean;

import edu.indiana.cs.b534.thread.callback.MonitorCallback;

public class StepInfo {
    private String s3OutputPath;
    private MonitorCallback callback;

    public StepInfo(String s3OutputPath, MonitorCallback callback) {
        this.s3OutputPath = s3OutputPath;
        this.callback = callback;
    }

    public String getS3OutputPath() {
        return s3OutputPath;
    }

    public MonitorCallback getCallback() {
        return callback;
    }
}
