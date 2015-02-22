package Thilina110912;

/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 11/9/12 Time: 1:44 PM
 */
public class BitOps {
    public static void main(String[] args) {
        int n = -14;
        SwapOddAndEvenBitsInAnInt(n);
    }
    
    private static void ReverseBits(int n){
        >>>
    }

    private static void SwapOddAndEvenBitsInAnInt(int n) {
        System.out.println(Integer.toBinaryString(n)); // to check
        int oddMask = 0x55555555;
        int evenMask = 0xaaaaaaaa;
        int odd = n&oddMask;
        int even = n&evenMask;

        int shifted = ((odd << 1) | (even >> 1));

        System.out.println(Integer.toBinaryString(shifted));
    }
}
