
public class PythagoreanTriple {
	
	private Double a;
	private Double b;
	private Double c;
	
	// a = m^2 - n^2, b = 2mn, c = m^2 + n^2 
	
	public PythagoreanTriple(Double m, Double n) {
		this.setA(m, n);
		this.setB(m, n);
		this.setC(m, n);
	}
	
	public PythagoreanTriple(Double a, Double b, Double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}
	
	public void setA(Double m, Double n) {
		this.a = m * m - n * n;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}
	
	public void setB(Double m, Double n) {
		this.b = 2 * m * n;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}
	
	public void setC(Double m, Double n) {
		this.c = m * m + n * n;
	}
	
	public Double getSum() {
		return this.a + this.b + this.c;
	}
	
	public Double getProd() {
		return this.a * this.b * this.c;
	}

}
