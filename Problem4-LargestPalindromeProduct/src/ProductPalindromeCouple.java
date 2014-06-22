/**
 * Class that represents a couple of integer numbers.
 * It provides some helper methods that help you to identify 
 * if the internal numbers product is a palindrome number. 
 * 
 * @author michelesartini
 *
 */
public class ProductPalindromeCouple {
	private int p1, p2, prod = 0;
	private String product, productReverse = "";

	public ProductPalindromeCouple(int p1, int p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.prod = this.p1 * this.p2;
		this.product = "" + this.prod;
		this.productReverse = new StringBuilder(this.product).reverse().toString();
		System.out.println("p1= " + this.p1 + " p2= " + this.p2);
		System.out.println("product= " + this.product 
								+ " palindromeProduct: " + this.productReverse);
	}

	public boolean isPalindromeProduct() {
		return (this.product.equals(this.productReverse) ? true : false);
	}

	public int getP1() {
		return p1;
	}

	public int getP2() {
		return p2;
	}

	public String getProduct() {
		return product;
	}
	
	public int getProd() {
		return this.prod;
	}
	
	public boolean isInputProductGreater(int value) {
		return (value > this.prod) ? true : false;
	}

	public String getProductReverse() {
		return productReverse;
	}
}
