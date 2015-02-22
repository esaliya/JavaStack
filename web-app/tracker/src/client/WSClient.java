package client;


import java.rmi.RemoteException;

import salsa.services.StatServiceStub;
import salsa.services.xsd.ClusStat;
import org.apache.axis2.AxisFault;

public class WSClient {

    private StatServiceStub stub;
    public WSClient () {
        try {
            this.stub = new StatServiceStub("http://localhost:8080/axis2/services/StatService");
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace(); // later log this
        }
    }

    public ClusStat[] getStat() throws RemoteException {
        return stub.getStat();
    }
}