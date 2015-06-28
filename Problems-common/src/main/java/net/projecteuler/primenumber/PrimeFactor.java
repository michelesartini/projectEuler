package net.projecteuler.primenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michelesartini on 20/06/2015.
 */
public class PrimeFactor {

    /**
     * In number theory, the prime factors of a positive integer are the prime numbers
     * that divide that integer exactly.
     *
     * That means that the reminder of the division between a positive integer and
     * a number and  is 0.
     *
     * The following algorithm executes the prime factorization of the number passed as input.
     * It returns a list of prime numbers that divide the number exactly.
     *
     * @return List<Integer>
     */
    public static List<Integer> primeFactors(long value) {
        List<Integer> primes = new ArrayList<Integer>();

        long start = System.currentTimeMillis();
        while (value > 1) {
            int div = 2;
            // The following for will stop when i divides value exactly, reminder == 0
            for (int i = 2; value % i != 0; i++, div = i) {}
            primes.add(Integer.valueOf(div));
            System.out.println("Value: " + value + " div: " + div);
            value = value / div;
        }
        long finish = System.currentTimeMillis();
        start = finish / start;
        System.out.println("The prime factorization took: " + start + "(ms)");

        return primes;
    }
}
