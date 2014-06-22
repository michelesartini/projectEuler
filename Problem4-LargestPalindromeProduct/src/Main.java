/**
 * https://projecteuler.net
 * 
 * Problem 4:
 * Largest palindrome product
 * 
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 *
 * @author michelesartini
 *
 */
public class Main {
	
	static int startingNumber = 999;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ProductPalindromeCouple pCouple = findLargestPalindromeBruteForce(startingNumber);
		long end = System.currentTimeMillis();
		System.out.println("--------------------");
		System.out.println("Result:");
		System.out.println("P1: " + pCouple.getP1() + " P2:" + pCouple.getP2());
		System.out.println("Product: " + pCouple.getProduct() 
								+ " palindrome:" + pCouple.getProductReverse());
		end = end - start;
		System.out.println("Execution time: " + end + "(ms)");
	}

	private static ProductPalindromeCouple findLargestPalindromeBruteForce(int startingNumber) {
		ProductPalindromeCouple pCouple = new ProductPalindromeCouple(1, 1);
		
		// As a matter of fact we know that the largest palindrome is made by a 3 digits number, 
		// therefore we can exclude all the values under 100.
		for (int i=startingNumber; i>99; i--) {
			for (int j=i-1; j>99; j--) {		
				ProductPalindromeCouple newCouple = new ProductPalindromeCouple(i, j);
				if (newCouple.isPalindromeProduct() 
						&& pCouple.isInputProductGreater(newCouple.getProd())) {
					pCouple = newCouple;
				} 
			}
		}
		return pCouple;
	}

}