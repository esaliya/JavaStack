package bitwise;

public class BitwiseChecker {
    public static void main(String[] args) {
        int x = 12;
        int r = 2;
        System.out.println(1 << r-1);
        if((x & (1 << r-1)) == 0) {
            // rth bit is zero
        } else {
            // rth bit is one
        }
    }
}
