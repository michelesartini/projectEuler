/**
 * In mathematics, the Euclidean algorithm, or Euclid's algorithm,
 * is a method for computing the greatest common divisor (GCD) 
 * of two (usually positive) integers.
 * 
 * @author michelesartini
 * 
 */
public class EuclideanAlgorithm {

	public int gcdByDivision(int v1, int v2) {
		int t = v2;
		while (v2 != 0) {
			t = v2;
			v2 = v1 % v2;
			v1 = t;
		}
		return v1;
	}
	
	public int gcdBySubtraction(int v1, int v2) {
		while (v1 != v2) {
			if (v1 > v2) {
				v1 = v1 - v2;
			} else {
				v2 = v2 - v1;
			}
		}
		return v1;
	}

}
