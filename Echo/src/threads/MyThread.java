package threads;

import ms.Echo;

import java.util.ArrayList;

import data.Stat;


public class MyThread implements  Runnable{
    private Echo e;
    private boolean stop = false;

    public MyThread (Echo e) {
        this.e = e;
    }

    public void run() {
        int i = 0;
        while (! stop) {
            e.running = true;
//            e.realObj = new Stat(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(),
//                    Math.random(), Math.random(), Math.random());
            e.realVal = Math.random();
            e.running = false;
//            e.tmpObj = e.realObj;
            e.tmpVal = e.realVal;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }
        }
    }

    public void stop() {
        stop = true;
    }
}
