package edu.indiana.cs.b534.client.util;

import edu.indiana.cs.b534.client.stub.RayTracerStub;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * A utility class to build a <code>RayTraceMovie</code>
 * object from the given input XML 
 */
public class MovieBuilder {
    public static RayTracerStub.RayTraceMovie buildMovie (String path)
            throws XMLStreamException, FileNotFoundException {
        String sceneUrl;
        int width, height;
        ArrayList<RayTracerStub.CameraSetup> setupList = new ArrayList<RayTracerStub.CameraSetup>();
        StAXOMBuilder builder = new StAXOMBuilder(path);
        OMElement root = builder.getDocumentElement();
        OMElement e = root.getFirstChildWithName(new QName("scene"));
        sceneUrl = e.getText();
        e = root.getFirstChildWithName(new QName("image"));
        width = Integer.parseInt(e.getFirstChildWithName(new QName("width")).getText());
        height = Integer.parseInt(e.getFirstChildWithName(new QName("height")).getText());

        Iterator itr = root.getChildrenWithName(new QName("camera"));
        while (itr.hasNext()) {
            e = (OMElement)itr.next();
            setupList.add(getCameraSetup(e));
        }
        RayTracerStub.RayTraceMovie rtMovie = new RayTracerStub.RayTraceMovie();
        rtMovie.setSceneURL(sceneUrl);
        rtMovie.setImageWidth(width);
        rtMovie.setImageHeight(height);
        RayTracerStub.CameraSetup [] cameraSetup = new RayTracerStub.CameraSetup[setupList.size()];
        rtMovie.setCamera(setupList.toArray(cameraSetup));
        return rtMovie;
    }

    private static RayTracerStub.CameraSetup getCameraSetup (OMElement cameraElement) {
        RayTracerStub.CameraSetup cameraSetup = new RayTracerStub.CameraSetup();
        RayTracerStub.Point3D location = new RayTracerStub.Point3D();
        RayTracerStub.Point3D direction = new RayTracerStub.Point3D();

        OMElement e = cameraElement.getFirstChildWithName(new QName("location"));
        location.setX(Double.parseDouble(e.getFirstChildWithName(new QName("x")).getText()));
        location.setY(Double.parseDouble(e.getFirstChildWithName(new QName("y")).getText()));
        location.setZ(Double.parseDouble(e.getFirstChildWithName(new QName("z")).getText()));

        e = cameraElement.getFirstChildWithName(new QName("direction"));
        direction.setX(Double.parseDouble(e.getFirstChildWithName(new QName("x")).getText()));
        direction.setY(Double.parseDouble(e.getFirstChildWithName(new QName("y")).getText()));
        direction.setZ(Double.parseDouble(e.getFirstChildWithName(new QName("z")).getText()));

        cameraSetup.setLocation(location);
        cameraSetup.setDirection(direction);
        return cameraSetup;
    }
}
