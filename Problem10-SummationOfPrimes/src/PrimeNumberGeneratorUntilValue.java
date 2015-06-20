import net.projecteuler.primenumber.PrimeNumberGenerator;

import java.util.ArrayList;
import java.util.List;


public class PrimeNumberGeneratorUntilValue extends PrimeNumberGenerator {

	/**
	 * PGsimple4
	 * Generates prime number until the prime is lower than the parameter passed as input.
	 * 
	 * @param maxValue
	 */
	public List<Integer> primeNumberGenerator4(int maxValue) {
		boolean test = true;
		int primeNumber = 2;
		
		List<Integer> expectedPrime = new ArrayList<Integer>();
		
		expectedPrime.add(primeNumber);
		primeNumber += 1;
		expectedPrime.add(primeNumber);
		primeNumber += 2;
		while (primeNumber < maxValue) {
			test = true;
			
			double sqrtPrimeP = Math.sqrt(primeNumber);
			
			for (int prime : expectedPrime) {
				if (prime > sqrtPrimeP) {
					break;
				}
				
				if (primeNumber % prime == 0) {
					test = false;
					break;
				}
			}
			if (test) {
				expectedPrime.add(primeNumber);
			}
			primeNumber += 2;
		}
		return expectedPrime;
	}

}
