/**
 * Created by IntelliJ IDEA.
 * User: sekanaya
 * Date: Jul 28, 2010
 * Time: 11:23:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    boolean cond = true;
    public void m1() {
        while (cond) {
            m2("hello");
        }

    }

    public void m2(String str) {
        System.out.println("hi" + str);
        if(str.equals("hello")) {
            System.out.println("true");
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.m1();
    }
}
