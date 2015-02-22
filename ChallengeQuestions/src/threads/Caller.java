package threads;

/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/12/12 Time: 3:50 PM
 */
public class Caller implements Runnable {
    int idx;
    private Foo f;

    public Caller(int idx, Foo f) {
        this.idx = idx;
        this.f = f;
    }

    @Override
    public void run() {
        switch (idx){
            case 1:
                f.m1();
                break;
            case 2:
                f.m2();
                break;
            case 3:
                f.m3();
                break;
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
