import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that efficiently generates prime numbers.
 * 
 * @link http://en.wikibooks.org/wiki/Efficient_Prime_Number_Generating_Algorithms
 * @author michelesartini
 *
 */
public class PrimeNumberGenerator {

	/**
	 * PGsimple3
	 * 
	 * @param limit
	 */
	public List<Integer> primeNumberGenerator3(int limit) {
		boolean test = true;
		int primeNumber = 2;
		List<Integer> primeSet = new ArrayList<Integer>();
		primeSet.add(primeNumber);
		primeNumber +=1;
		primeSet.add(primeNumber);
		
		while (primeNumber < limit) {
			primeNumber +=2;
			test = true;
			
			double sqrtPrimeP = Math.sqrt(primeNumber);
			
			for (int prime : primeSet) {
				if (prime > sqrtPrimeP) {
					break;
				}
				
				if (primeNumber % prime == 0) {
					test = false;
					break;
				}
			}
			
			if (test) {
				primeSet.add(primeNumber);
			}
		}
		return primeSet;
	}

	/**
	 * PGsimple4
	 * 
	 * @param limit
	 */
	public List<Integer> primeNumberGenerator4(int limit) {
		boolean test = true;
		int primeNumber = 2;
		
		List<Integer> expectedPrime = new ArrayList<Integer>();
		
		expectedPrime.add(primeNumber);
		primeNumber += 1;
		expectedPrime.add(primeNumber);
		
		while (expectedPrime.size() < limit) {
			primeNumber += 2;
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
		}
//		Collections.reverse(expectedPrime);
		return expectedPrime;
	}
}
