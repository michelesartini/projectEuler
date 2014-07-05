import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net
 * 
 * Problem 5:
 * Smallest multiple
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder. 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author michelesartini
 *
 */

public class Main {
	
	private static int limit = 20;
	private static List<Integer> numbers;
	private static EuclideanAlgorithm gcd = null;
	
	public static void main(String[] args) {
		numbers = initialiseArray(limit);
		gcd = new EuclideanAlgorithm();
		long start = System.currentTimeMillis();
		int smallests = lcmRecursive(numbers);
		long end = System.currentTimeMillis();
		System.out.println("Result: " + smallests);
		end = end - start;
		System.out.println("Execution time: " + end + "(ms)");
	}

	/**
	 * In arithmetic and number theory, the least common multiple 
	 * (also called the lowest common multiple or smallest common multiple) of two integers a and b, 
	 * usually denoted by LCM(a, b), is the smallest positive integer that is divisible by both a and b.
	 * 
	 * lcm(a, b) = (|a| / gcd(a,b)) * |b| = (|b| / gcd(a,b)) * |a| 
	 * 
	 */
	public static int lcm(int a, int b) {
		return (a / gcd.gcdBySubtraction(a, b)) * b; 
	}
	
	public static int lcmRecursive(List<Integer> numbers) {
		// lcm for more that two numbers:
		// lcm(a,b,c) = lcm(a,lcm(b,c))
		
		if (numbers.size() == 2) {
			return lcm(numbers.get(0), numbers.get(1));
		}
		int a = numbers.get(0); 
		numbers.remove(0);
		return lcm(a, lcmRecursive(numbers));
	}
	
	private static List<Integer> initialiseArray(int limit) {
		List<Integer> list = new ArrayList<Integer>(limit);
		for (int i=1; i<=limit; i++) {
			list.add(i);
		}
		return list;
	}
}