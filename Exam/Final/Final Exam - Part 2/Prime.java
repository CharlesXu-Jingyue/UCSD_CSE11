import java.util.ArrayList;
import java.util.*;

class Prime {
    // Task 2: main method
    // your code here
    public static void main(String[] args) {
        if(args.length != 0) {
            List<String> primes = new ArrayList<String>();
            for(int i = 0; i < args.length; i ++) {
                int n = Integer.parseInt(args[i]);
                boolean isPrime = isNumPrime(n);
                if(isPrime) {
                    primes.add(args[i]);
                }
            }
            if(primes.size() != 0) {
                for(int i = 0; i < primes.size(); i ++) {
                    System.out.println(primes.get(i));
                }
            }
        }
    }

    // isNumPrime helper method
    // Returns true for prime number, false otherwise
    static boolean isNumPrime(int num) {
        boolean isPrime = true;
        
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}