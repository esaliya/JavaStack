package edu.indiana.cs.b534.client.thread;

import edu.indiana.cs.b534.client.callback.SubViewRequestCallback;
import edu.indiana.cs.b534.client.stub.RayTracerStub;

import java.rmi.RemoteException;
import java.util.concurrent.CountDownLatch;
/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Class <code>SubViewRequester</code> is a runnable
 * task which call offs the Web service method
 * <code>rayTraceSubView</code> asynchronously.
 */
public class SubViewRequester extends Thread{
    private RayTracerStub stub;
    private SubViewRequestCallback cb;
    private RayTracerStub.RayTraceSubView sv;
    private CountDownLatch startSignal;

    public SubViewRequester(RayTracerStub stub, SubViewRequestCallback cb,
                            RayTracerStub.CameraSetup cameraSetup, int width, int height,
                            String sceneUrl, RayTracerStub.Rectangle rectangle, CountDownLatch startSignal) {
        this.startSignal = startSignal;
        this.stub = stub;
        this.cb = cb;
        sv = new RayTracerStub.RayTraceSubView();
        sv.setCamera(cameraSetup);
        sv.setImageWidth(width);
        sv.setImageHeight(height);
        sv.setSceneURL(sceneUrl);
        sv.setSubView(rectangle);
    }

    @Override
    public void run() {
        try {
            // wait for the green light
            startSignal.await();
            cb.setStartTime(System.currentTimeMillis());
            stub.startrayTraceSubView(sv, cb);
        } catch (RemoteException e) {
            // todo: handle exception to write a black image of w x h later
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }
    }
}
