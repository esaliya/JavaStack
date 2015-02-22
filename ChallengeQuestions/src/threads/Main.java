package threads;

/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/12/12 Time: 3:52 PM
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo f = new Foo();
        Thread A = new Thread(new Caller(1, f));
        Thread B = new Thread(new Caller(2, f));
        Thread C = new Thread(new Caller(3, f));

        // If we implement this correctly still this should give m1, m2 m3
        // instead of m3,m2,m1
        C.run();B.run();A.run();
        
        Thread.sleep(1000);
    }
}
