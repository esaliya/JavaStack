package edu.indiana.cs.b534;

import edu.indiana.cs.b534.client.RayTraceClient;
import edu.indiana.cs.b534.client.ui.ClientUI;
import org.apache.axis2.AxisFault;
/**
 * @author Saliya Ekanayake (sekanaya@cs.indiana.edu)
 */

/**
 * Driver for the RayTrace UI
 */
public class RayTraceMain {
    public static void main(String[] args) {
        RayTraceClient rc;
        try {
            if (args != null && args.length != 0 && args[0] != null) {
                rc = new RayTraceClient(args[0]);
            } else {
                rc = new RayTraceClient("http://localhost:8080/axis2/services/RayTracer?wsdl");
            }
            ClientUI ui = new ClientUI(rc);
            ui.createAndShow();
        } catch (AxisFault axisFault) {
            System.out.println("Error occurred while creating client\n" + axisFault.getMessage());
        }
    }
}
