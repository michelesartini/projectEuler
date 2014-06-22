import java.util.ArrayList;
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
		List<Integer> primes = primeFactors(lpfNumber);
		int largestPrimeNumber = findGreatestNumber(primes);
		System.out.println("The largest prime factor of " + lpfNumber + " is: " + largestPrimeNumber);
	}

	/**
	 * In number theory, the prime factors of a positive integer are the prime numbers 
	 * that divide that integer exactly.
	 * 
	 * That means that the reminder of the division between a positive integer and 
	 * a number and  is 0.
	 * 
	 * The following algorithm executes the prime factorization of the number passed ad input.
	 * It returns a list of prime numbers that divide the number exactly.
	 * 
	 * @return List<Integer>
	 */
	private static List<Integer> primeFactors(long lpfNumber) {
		List<Integer> primes = new ArrayList<Integer>();
		long value = lpfNumber;
		
		long start = System.currentTimeMillis();
		
		while (value > 1) {
			int div = 0;
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
	
	private static int findGreatestNumber(List<Integer> primes) {
		long start = System.currentTimeMillis();
		int largest = primes.get(0);
		for (int prime : primes) {
			largest = (prime > largest) ? prime : largest;
		}
		long finish = System.currentTimeMillis();
		start = finish / start;
		System.out.println("Finding the greatest number took: " + start + "(ms)");
		
		return largest;
	}

}
