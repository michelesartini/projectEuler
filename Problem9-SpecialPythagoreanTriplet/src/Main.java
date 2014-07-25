/**
 * Problem 9
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000
 * Find the product abc.
 * 
 * @author michelesartini
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		PythagoreanTriple triplet = findTriplet(1000);
		System.out.printf("Product: %6.0f \n", triplet.getProd());
		
		long end = System.currentTimeMillis();
		end = end - start;
		System.out.println("Execution time: " + end + "(ms)");

	}
	
	private static PythagoreanTriple findTriplet(int max) {
		PythagoreanTriple triplet = null;
		for (Double n = 1d; n < max; n++) {
			for (Double m = n + 1; m < max; m++) {
				triplet = new PythagoreanTriple(m, n);
				if (triplet.getSum() == max) {
					return triplet;
				} else if (triplet.getSum() > max) {
					break;
				}
			}
		}
		return triplet;
	}

}
