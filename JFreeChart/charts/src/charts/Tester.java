package charts;

public class Tester {
    public static void main(String[] args) {
        sayHello();
        String str = "linux_vm#what a wonderful life";
        String[] arr = str.split("#");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    public static void sayHello() {
        sayHi();

    }

    public static void sayHi() {
        System.out.println("Hi");
    }
}
