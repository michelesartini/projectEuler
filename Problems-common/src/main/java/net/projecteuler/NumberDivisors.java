package net.projecteuler;

import net.projecteuler.primenumber.PrimeNumberSieve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by michelesartini on 20/06/2015.
 */
public class NumberDivisors {

    public static List<Integer> numberDivisors(int number) {
        Set<Integer> divisors = new HashSet<Integer>();

        for (int i = 1; i<= number; i++) {
            if (number % i == 0) {
                divisors.add(number / i);
            }
        }
        return new ArrayList<Integer>(divisors);
    }

    public static List<Integer> numberDivisorsImproved(int number) {
        int sqrt = (int) Math.sqrt(number);
        Set<Integer> divisors = new HashSet<Integer>();

        for (int i = 1; i<= sqrt; i++) {
            if (number % i == 0) {
                divisors.add(number / i);
                divisors.add(i);
            }
        }

        return new ArrayList<Integer>(divisors);
    }

    public static int numberDivisorsPrimeFactor(int number, List<Integer> primeList) {
        int nod = 1;
        int exponent;
        int remain = number;

        for (int i = 0; i < primeList.size(); i++) {
            // In case there is a remainder this is a prime factor as well
            // The exponent of that factor is 1
            if (primeList.get(i) * primeList.get(i) > number) {
                nod = nod * 2;
                break;
            }

            exponent = 1;
            while (remain % primeList.get(i) == 0) {
                exponent++;
                remain = remain / primeList.get(i);
            }
            nod *= exponent;

            //If there is no remainder, return the count
            if (remain == 1) {
                break;
            }
        }
        return nod;
    }
}
