package cgl.perfmon;


/**
 * Listener for NaradaBrokering inside a WebService. A shared object is used to
 * communicate between the listener and the Web Service.
 *
 * @author Jaliya Ekanayake (jaliyae@gmail.com) 11/03/2009
 */
public class ServiceListener implements Subscribable {

    private PubSubBase pubSubBase;

    public ServiceListener(String host, String port, Object sharedObject)
            throws MonitorExecption {
        pubSubBase = new PubSubBase(host, port, this);
        pubSubBase.subscribeToProfile(Constants.SUMMERIZER_OUT_COMM_TOPIC);
    }

    @Override
    public void onEvent(byte[] message) {

        if (message[0] == Constants.PERF_MESSAGE) {

            // Update Shared Object.
            Measurements msg = new Measurements();
            try {
                msg.fromBytes(message);
                System.out.println("Performance Event received");
            } catch (MonitorExecption e) {
                e.printStackTrace();
            }
        } else if (message[0] == Constants.STATUS_MESSAGE) {

            System.out.println("Status Event received");
        } else {
            System.out.println("Unknown Event received");
        }


    }

    public void close() throws MonitorExecption {
        pubSubBase.closeBrokerConnection();
    }

    /*
      * Simple test method. Intended to create from a WebService.
      * */
    public static void main(String[] args) {
        ServiceListener listener = null;
        ;
        try {
            if (args.length != 2) {
                System.out
                        .println("Usage: cgl.perfmon.ServiceListener [Broker Host][Broker Port]");
                return;
            }

            listener = new ServiceListener(args[0], args[1], new Object());
            System.out.println("Testing ServiceListener - Started.");
            System.in.read();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (listener != null) {
                    listener.close();
                }
            } catch (MonitorExecption e1) {
                e1.printStackTrace();
            }

        }
    }

}
