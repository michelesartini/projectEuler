/**
 * https://projecteuler.net
 * 
 * Problem 1:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author michelesartini
 *
 */

public class Main {
	
	private static int limit = 1000;
	
	public static void main(String [] args) {
		limit = parseArgument(args);
		int sum = calculateSum(limit);
		System.out.println("Result: " + sum);
	}

	private static int calculateSum(int limit) {
		int sum = 0;
		
		for (int i = 0; i < limit; i++){
			if (i % 5 == 0 || i % 3 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	private static int parseArgument(String[] args) {
		return args.length == 0 ? limit : Integer.parseInt(args[0]);  
	}	

}
