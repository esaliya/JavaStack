package edu.indiana.cs.b534.client.callback;

import edu.indiana.cs.b534.client.bean.ImageInfo;
import edu.indiana.cs.b534.client.stub.RayTracerCallbackHandler;
import edu.indiana.cs.b534.client.stub.RayTracerStub;

import java.util.concurrent.CountDownLatch;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Class <code>SubViewRequestCallback</code> extends the
 * <code>RayTracerCallbackHandler</code> to provide custom
 * call back facility for sub view ray tracing with blocks
 */
public class SubViewRequestCallback extends RayTracerCallbackHandler{
    private long startTime, endTime;
    private CountDownLatch doneSignal;
    private ImageInfo imageInfo;

    public SubViewRequestCallback(CountDownLatch doneSignal, ImageInfo imageInfo) {
        this.doneSignal = doneSignal;
        this.imageInfo = imageInfo;
     }

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    @Override
    public void receiveResultrayTraceSubView(RayTracerStub.RayTraceSubViewResponse result) {
        endTime = System.currentTimeMillis();
        imageInfo.setImageUrl(result.getImageURL());
        doneSignal.countDown();
    }
    // Note. There is a subtle bug in the case if an error is received. This is because then
    // I would not be setting an image url for this call back which will screw back when
    // trying to draw the image. I could improve it to skip such blanks and draw an incomplete
    // image.
}
