
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
