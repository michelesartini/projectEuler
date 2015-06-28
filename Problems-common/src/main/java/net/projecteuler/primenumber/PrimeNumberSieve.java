package net.projecteuler.primenumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class that implements some known sieve for the prime number generation upon a maximum value.
 * 
 * @author michelesartini
 * 
 */
public class PrimeNumberSieve {

	/**
	 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * 
	 * O(N)
	 * 
	 * @param maxValue
	 * @return
	 */
	public static List<Integer> eratosthenesSieve(Integer maxValue) {
		Set<Integer> notPrimes = new HashSet<Integer>();
		List<Integer> primes = new ArrayList<Integer>();
		// Initialising the primes array.
		for (int i = 1; i < maxValue; i++, primes.add(i)) {
		}

		for (int i = 0; i < Math.sqrt(maxValue); i++) {
			Integer value = primes.get(i);
			for (int j = 2 * value; j <= maxValue; j = j + value) {
				notPrimes.add(j);
			}
		}
		// Removing the not primes values from the primes list
		primes.removeAll(notPrimes);
		return primes;
	}

	/**
	 *
	 * In mathematics, the sieve of Atkin is a fast, modern algorithm for finding all prime numbers
	 * up to a specified integer.
	 *
	 * O(N/log log N)
	 *
	 * @link https://en.wikipedia.org/wiki/Sieve_of_Atkin
	 * @link http://stackoverflow.com/questions/10580159/sieve-of-atkin-explanation-and-java-example
	 * @link http://www.sanfoundry.com/java-program-sieve-of-atkin-algorithm/
	 * 
	 * @param maxValue
	 * @return
	 */
	public static List<Integer> atkinSieve(Integer maxValue) {
		List<Integer> primes = new ArrayList<Integer>();

		if (maxValue <= 3) {
			throw new IllegalArgumentException("Please submit a value greater than 2");
		}
		
		int sqrt = (int) Math.sqrt(maxValue) + 1;
		boolean[] isPrime = new boolean[maxValue];

		for (int x = 1; x < sqrt; x++) {
			for (int y = 1; y < sqrt; y++) {

				int k = 4 * x * x + y * y;
				if ((k < maxValue) && ((k % 12 == 1) || (k % 12 == 5))) {
					isPrime[k] = !isPrime[k];
				}

				k = 3 * x * x + y * y;
				if ((k < maxValue) && (k % 12 == 7)) {
					isPrime[k] = !isPrime[k];
				}

				if (x > y) {
					k = 3 * x * x - y * y;
					if ((k < maxValue) && (k % 12 == 11)) {
						isPrime[k] = !isPrime[k];
					}
				}
			}
		}
		isPrime[2] = true;
		isPrime[3] = true;
		for (int n = 5; n <= sqrt; n++) {
			if (isPrime[n]) {
				int n2 = n * n;
				for (int k = n2; k < maxValue; k += n2) {
					isPrime[k] = false;
				}
			}
		}
		
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
		
		return primes;
	}

}
