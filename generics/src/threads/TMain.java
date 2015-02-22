package threads;

public class TMain {
    public static void main(String[] args) {
        System.out.println("Main Started");
        int y = 0;
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread Started");
                int x = 10;

                for (int i = 0; i < 1000; i++) {
                    if (i % x == 0) {
                        System.out.println("Doing some dumb work for " + i + " th time");
                    }
                }
                System.out.println("Thread Ending");
            }
        });

        t.setDaemon(true);
        t.start();

        System.out.println("Main Ending");
//        System.exit(0);
    }
}
