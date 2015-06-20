import net.projecteuler.primenumber.PrimeFactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://projecteuler.net
 * 
 * Problem 3:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author michelesartini
 *
 */
public class Main {

	private static long lpfNumber = 600851475143L;
	
	public static void main(String[] args) {
		List<Integer> primes = PrimeFactor.primeFactors(lpfNumber);
		int largestPrimeNumber = Collections.max(primes);
		System.out.println("The largest prime factor of " + lpfNumber + " is: " + largestPrimeNumber);
	}
}
