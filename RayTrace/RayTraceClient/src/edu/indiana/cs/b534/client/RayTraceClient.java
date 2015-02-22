package edu.indiana.cs.b534.client;

import edu.indiana.cs.b534.client.callback.SimpleRequestCallback;
import edu.indiana.cs.b534.client.stub.RayTracerStub;
import edu.indiana.cs.b534.client.thread.SubViewRequestManager;
import edu.indiana.cs.b534.client.util.MovieBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.ServiceClient;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 * @author Li, Hui
 */
public class RayTraceClient {
    private RayTracerStub stub;
    private AtomicInteger ai;

    public RayTraceClient(String epr) throws AxisFault {
        stub = new RayTracerStub(epr);
        ServiceClient svc =stub._getServiceClient();
        svc.engageModule("addressing");
        svc.getOptions().setUseSeparateListener(true);
        ai = new AtomicInteger();
    }

    public void rayTrace(double locX, double locY, double locZ,
                         double dirX, double dirY, double dirZ,
                         int width, int height, String sceneUrl)
            throws RemoteException {
        RayTracerStub.RayTrace rt = new RayTracerStub.RayTrace();
        rt.setCamera(generateCameraSetup(locX, locY, locZ, dirX, dirY, dirZ));
        rt.setImageWidth(width);
        rt.setImageHeight(height);
        rt.setSceneURL(sceneUrl);
        SimpleRequestCallback cb = new SimpleRequestCallback(ai);
        cb.setStartTime(System.currentTimeMillis());
        stub.startrayTrace(rt, cb);
        // this may cause a block in UI, but if we spawn a new updater
        // thread to do this then there is a chance that we may see
        // negative values (may be I am being too theoretical here).
        // So hoping for the best I will do like this.
        ai.incrementAndGet();
    }

    public void rayTraceUrl (double locX, double locY, double locZ,
                         double dirX, double dirY, double dirZ,
                         int width, int height, String sceneUrl)
            throws RemoteException {
        RayTracerStub.RayTraceURL rtUrl = new RayTracerStub.RayTraceURL();
        rtUrl.setCamera(generateCameraSetup(locX, locY, locZ, dirX, dirY, dirZ));
        rtUrl.setImageWidth(width);
        rtUrl.setImageHeight(height);
        rtUrl.setSceneURL(sceneUrl);
        SimpleRequestCallback cb = new SimpleRequestCallback(ai);
        cb.setStartTime(System.currentTimeMillis());
        stub.startrayTraceURL(rtUrl, cb);
        ai.incrementAndGet();
    }

    public void rayTraceMovie (String path) throws RemoteException, XMLStreamException, FileNotFoundException {
        RayTracerStub.RayTraceMovie rtMovie = MovieBuilder.buildMovie(path);
        SimpleRequestCallback cb = new SimpleRequestCallback(ai);
        cb.setStartTime(System.currentTimeMillis());
        stub.startrayTraceMovie(rtMovie, cb);
        ai.incrementAndGet();
    }

    public void rayTraceSubView(double locX, double locY, double locZ,
                         double dirX, double dirY, double dirZ,
                         int width, int height, String sceneUrl, int blocks)
            throws RemoteException {
        RayTracerStub.CameraSetup cameraSetup = generateCameraSetup(locX, locY, locZ, dirX, dirY, dirZ);
        SubViewRequestManager mgr = new SubViewRequestManager(stub, cameraSetup, width, height, sceneUrl, blocks, ai);
        mgr.start();
    }

    private RayTracerStub.CameraSetup generateCameraSetup(double locX, double locY, double locZ,
                                                          double dirX, double dirY, double dirZ) {
        RayTracerStub.CameraSetup cameraSetup = new RayTracerStub.CameraSetup();
        RayTracerStub.Point3D location = new RayTracerStub.Point3D();
        location.setX(locX);
        location.setY(locY);
        location.setZ(locZ);
        cameraSetup.setLocation(location);

        RayTracerStub.Point3D direction = new RayTracerStub.Point3D();
        direction.setX(dirX);
        direction.setY(dirY);
        direction.setZ(dirZ);
        cameraSetup.setDirection(direction);
        return cameraSetup;
    }

    public AtomicInteger getAi() {
        return ai;
    }
}
