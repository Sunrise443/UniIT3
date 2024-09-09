package lab1;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    public static void main (String[] args) {
        List <Integer> primes = new ArrayList<Integer>();
        for (int i=2; i<=100; i++) {
            if (isPrime(i)==true) {
                primes.add(i);
            }
        }
        System.out.println(primes);
    }

    public static boolean isPrime(int n) {
        for (int j=2; j<n; j++) {
            if (n%j == 0) {
                return false;
            }
        }
        return true;
    }
}
