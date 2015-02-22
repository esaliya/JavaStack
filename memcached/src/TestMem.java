import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactory;
import net.spy.memcached.DefaultConnectionFactory;
import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestMem {
    public static void main(String[] argv) throws IOException, ExecutionException, InterruptedException {
        System.out.println("Starting memcached trivial");
        MemcachedClient c = null;
        try {
//            c = new MemcachedClient(new InetSocketAddress("149.165.146.153", 11211));
//            c = new MemcachedClient(new InetSocketAddress("10.0.3.66", 11211));
            c = new MemcachedClient(AddrUtil.getAddresses("149.165.146.153:11211 149.165.146.181:11211"));
        } catch (IOException e) {
            System.out.println("Can't establish connection to Memcached client: "
                            + e.toString());
            System.exit(1);
        }
        System.out.println("Memcached trivial connected to client successfully.");
        String storeString = "CSCI-B 649 Cloud Computing";
        Future<Boolean> fset = c.set("someKey", 3600, storeString);
        while (!fset.isDone()) {

        }
        System.out.println("Set status: good");
        System.out.println("Memcached trivial stored a key.");

        Object myObj = null;
        Future<Object> f = c.asyncGet("someKey");
        try {
            myObj = f.get(5, TimeUnit.SECONDS);
            System.out.println(myObj.toString());
        } catch (TimeoutException e) {
            // Since we don't need this, go ahead and cancel the operation.  This
            // is not strictly necessary, but it'll save some work on the server.
            System.out.println("***********TImed out**********");
            f.cancel(false);

            // Do other timeout related stuff
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Object myObject = c.get("someKey");
        System.out.println("Got object back: " + myObject.toString());
        if (myObject.toString().equals(storeString)) {
            System.out.println("Object matches.");
        } else {
            System.out.println("Object does not match, failing.");
            System.exit(1);
        }
        c.delete("someKey");
        System.out.println("Memcached trivial deleted a key, and is exiting.");
        

    }
}
