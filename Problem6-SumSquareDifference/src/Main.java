/**
 * https://projecteuler.net
 * 
 * Problem 6:
 * Sum square difference
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * 
 * Hence the difference between the sum of the squares of the first 
 * ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one 
 * hundred natural numbers and the square of the sum.
 * 
 * @author michelesartini
 *
 */
public class Main {

	private static int n = 100;
	
	public static void main(String[] args) {

		// The following two approaches are brute force approaching:
		long start = System.currentTimeMillis();
		int sumOfSquares = findSum(n, 2);
		int squareOfSum = (int) Math.pow(findSum(n, 1), 2);
		int result = squareOfSum - sumOfSquares;
		long end = System.currentTimeMillis();
		System.out.println("Result: " + result);
		end = end - start;
		System.out.println("Execution time 1st approach: " + end + "(ms)");
		
		start = System.currentTimeMillis();
		result = findDiff(n, 2, 1);
		end = System.currentTimeMillis();
		System.out.println("Result: " + result);
		end = end - start;
		System.out.println("Execution time 2nd approach: " + end + "(ms)");
		
		// Best approach:
		start = System.currentTimeMillis();
		// The sum of all natural numbers 1 + 2 + 3 + 4 + á á á is a divergent series:
		// SUM from k=1 to n = n (n + 1) / 2 
		squareOfSum = (n * (n + 1)) / 2;
		squareOfSum *= squareOfSum;
		// SUM^2 from k=1 to n = (n (n + 1) (2n + 1))/6 = n/3 (n + 1) (n + 1/2) = n^3/3 + n^2/2 + n/6
		sumOfSquares = (n * (n + 1) * ( 2 * n + 1 )) / 6;
		result = squareOfSum - sumOfSquares;
		end = System.currentTimeMillis();
		System.out.println("Result: " + result);
		end = end - start;
		System.out.println("Execution time 3rd approach: " + end + "(ms)");
	}
	
	private static int findSum(int numbers, int power) {
		int sum = 0;
		for (int i=1; i<=numbers; i++) {
			sum = (int) (sum + Math.pow(i, power));
		}
		return sum;
	}
	
	private static int findDiff(int numbers, int power1, int power2) {
		int sumOfSquares = 0;
		int squareOfSum = 0;
		for (int i=1; i<=numbers; i++, squareOfSum += i) {
			sumOfSquares += i * i;
		}
		return (squareOfSum * squareOfSum)- sumOfSquares;
	}

}
