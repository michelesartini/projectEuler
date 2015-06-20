import net.projecteuler.primenumber.PrimeNumberGenerator;

import java.util.Collections;
import java.util.List;

/**
 * Problem 7
 * 
 * 10001st prime
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * 
 * What is the 10001st prime number?
 * 
 * @author michelesartini
 *
 */
public class Main {

	public static void main(String[] args) {
		PrimeNumberGenerator generator = new PrimeNumberGenerator();
		long start = System.currentTimeMillis();
		List<Integer> list = generator.primeNumberGenerator4(10001);
		long end = System.currentTimeMillis();
		System.out.println("Result: " + Collections.max(list));
		end = end - start;
		System.out.println("Execution time: " + end + "(ms)");
	}

}
