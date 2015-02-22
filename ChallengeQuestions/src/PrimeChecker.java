import java.util.Arrays;

/**
 * Author: Saliya Ekanayake (esaliya at gmail dot com)
 * Date: 10/12/12 Time: 12:18 PM
 */
public class PrimeChecker {
    
    private boolean [] arr = new boolean[10];
    /* Naive way to check if n is prime */
    public static boolean isPrimeNaive(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static boolean isPrimeBetter(int n){
        if (n < 2) return false;
        for (int i = 2; i < Math.sqrt(n); ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static boolean[] findPrimesSE(int max){
        boolean [] primes = new boolean[max+1];

        /* Initialization */
        if (max > 1){
            primes[0] = false;
            primes[1] = false;
            for (int i = 2; i < max+1; ++i){
                primes[i] = true;
            }
        }

        int prime = 2;
        while (prime <= max){
            crossOff(primes, prime);
            
            prime = getNextPrime(primes, prime);
            
            if (prime >= primes.length){
                break;
            }
        }
        
        return primes;
        
    }

    private static int getNextPrime(boolean[] primes, int prime) {
        int next = prime+1;
        while (next < primes.length && !primes[next]){
            ++next;
        }
        return next;
    }

    private static void crossOff(boolean[] primes, int prime) {
        for(int i = prime*prime; i < primes.length; i+=prime){
            primes[i] = false;
        }
    }


    public static void main(String[] args) {
//        System.out.println(isPrimeNaive(2));
//        System.out.println(isPrimeNaive(5));
//        System.out.println(isPrimeNaive(12));
//        System.out.println(isPrimeNaive(23));
//        System.out.println(isPrimeNaive(256789));

        boolean [] primes = findPrimesSE(20);
        for(int i = 0; i < primes.length; ++i){
            System.out.println(i + "\t" + primes[i]);
        }

        /* A test to determine if local arrays get initialized automatically */
        Boolean [] arr = new Boolean[4];
        // Note. A neat way to fill up an array
        Arrays.fill(arr, false);
        for(Boolean a : arr){
            System.out.println(a);
        }
    }

}
