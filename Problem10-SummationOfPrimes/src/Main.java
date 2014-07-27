
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
		long start = System.currentTimeMillis();

		int maxValue = parseArgument(args);
		PrimeNumberGeneratorUntilValue primeGenerator = new PrimeNumberGeneratorUntilValue();
		List<Integer> primes = primeGenerator.primeNumberGenerator4(maxValue);
		Double result = 0d;
		for (Integer value : primes) {
			result += value;
		}
		System.out.printf("Sum: %8.0f \n", result);
		
		long end = System.currentTimeMillis();
		end = end - start;
		System.out.println("Execution time: " + end + "(ms)");
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
