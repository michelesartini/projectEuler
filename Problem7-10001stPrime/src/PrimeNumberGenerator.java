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
		List<Integer> testPrime = new ArrayList<Integer>();
		
		expectedPrime.add(primeNumber);
		testPrime.add(primeNumber);
		primeNumber += 1;
		testPrime.add(primeNumber);
		
		while (testPrime.size() < limit) {
			primeNumber += 2;
			test = true;
			
			double sqrtPrimeP = Math.sqrt(primeNumber);
			
			for (int prime : testPrime) {
				if (prime > sqrtPrimeP) {
					break;
				}
				
				if (primeNumber % prime == 0) {
					test = false;
					break;
				}
			}
			
			if (test) {
				testPrime.add(primeNumber);
			}
		}
		Collections.reverse(expectedPrime);
		testPrime.addAll(0, expectedPrime);
		return testPrime;
	}
}
