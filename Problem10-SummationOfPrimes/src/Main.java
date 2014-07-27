
import java.util.List;

/**
 * Problem 10
 * 
 * Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * 
 * @author michelesartini
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		int maxValue = parseArgument(args);
		
		long start = System.currentTimeMillis();
		PrimeNumberGeneratorUntilValue primeGenerator = new PrimeNumberGeneratorUntilValue();
		List<Integer> primes = primeGenerator.primeNumberGenerator4(maxValue);
		System.out.printf("Sum: %8.0f \n", getSum(primes));
		long end = System.currentTimeMillis();
		end = end - start;
		System.out.println("1st execution time: " + end + "(ms)");
		
		start = System.currentTimeMillis();
		PrimeNumberSieve sieve = new PrimeNumberSieve();
		primes = sieve.atkinSieve(maxValue);
		System.out.printf("Sum: %8.0f \n", getSum(primes));
		end = System.currentTimeMillis();
		end = end - start;
		System.out.println("2nd execution time: " + end + "(ms)");
		
	}
	
	private static Double getSum(List<Integer> primes) {
		Double result = 0d;
		for (Integer value : primes) {
			result += value;
		}
		return result;
	}
	
	private static int parseArgument(String[] args) {
		int maxValue;
		try {
			maxValue = Integer.parseInt(args[0]);
		} catch (java.lang.ArrayIndexOutOfBoundsException o) {
			// default
			maxValue = 2000000;
		}
		return maxValue;
	}
}
