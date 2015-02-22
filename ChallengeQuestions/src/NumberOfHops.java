/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/12/12 Time: 2:19 PM
 */
public class NumberOfHops {
    private static int [] hopsForN;
    public static int numberOfHops(int n){
        if (n < 0){
            return 0;
        }
        if (n == 0){
            return 1;
        } else {
            return numberOfHops(n-1) + numberOfHops(n-2) + numberOfHops(n-3);
        }
        
        /* An optimization - which is bit ugly*/
        /*if (n == 1){
            return 1;
        } else if (n ==2){
            return 2;
        } else if (n ==3){
            return 4;
        }
        else {
            
            int x = hopsForN[n-1] != 0 ? hopsForN[n-1] : numberOfHops(n-1);
            int y = hopsForN[n-2] != 0 ? hopsForN[n-2] : numberOfHops(n-2);
            int z = hopsForN[n-3] != 0 ? hopsForN[n-3] : numberOfHops(n-3);
            
            
            
            int total = x+y+z;
            hopsForN[n] = total;
            return total;

        }*/
    }

    public static void main(String[] args) {
        hopsForN = new int[10];
        System.out.println(numberOfHops(3));
    }
    
    
}
