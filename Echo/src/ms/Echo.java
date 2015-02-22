package ms;

import threads.MyThread;

import java.util.ArrayList;

import data.Stat;
import org.apache.axis2.engine.ServiceLifeCycle;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;


public class Echo implements ServiceLifeCycle {
    public boolean running =false;
//    public Stat tmpObj, realObj;
    public double tmpVal, realVal;
    private MyThread mt;

    private ArrayList arr;

    public Echo() {
        tmpVal = realVal = 0.0;
    }

    public void startUp(ConfigurationContext configurationContext, AxisService axisService) {
//        System.out.println("started");
//        configurationContext.setProperty("mythread", mt);
//        arr = new ArrayList();
//        mt  = new MyThread(this);
//        Thread t = new Thread(mt);
//        t.start();
    }

    public void shutDown(ConfigurationContext configurationContext, AxisService axisService) {
//        mt.stop();
    }

    public String start() {
        arr = new ArrayList();
        mt  = new MyThread(this);
        Thread t = new Thread(mt);
        t.start();
        return "started";
    }

    public String stop() {
        mt.stop();
        return "stopped";
    }

//    public Stat getStat() {
    public double getStat() {
        if (running) {
//            return tmpObj;
            return tmpVal;
        } else {
//            return realObj;
            return realVal;
        }
    }


}
