import java.util.concurrent.Callable;


/**
 * Returns the greatest productuct in a matrix N x M, where N is equal to ADIACENT_NUMBERS.
 *  
 * @author michelesartini
 *
 */
public class MatrixProductMultiThreaded implements Callable<Double> {
	/**
	 * COL: maximum number of columns.
	 * ADIACENT_NUMBERS:
	 */
	private static int ROW, COL, ADIACENT_NUMBERS;
	private int [][] matrix;
	private int row;
	private volatile Double product = 1d;
	private String threadName;
	
	
	public MatrixProductMultiThreaded(String threadName, int [][] matrix, int row, int rowMax, int colMax, int adiacentNumbers) {
		this.threadName = threadName;
		this.matrix = matrix;
		this.COL = colMax;
		this.ROW = rowMax;
		this.row = row;
		this.ADIACENT_NUMBERS = adiacentNumbers;
	}

	@Override
	public Double call() throws Exception {
		Double currentproduct = 1d;

		for (int j = 0; j < COL; j++) {
			System.out.println(this.threadName + " column: " + j);
			
			int horiz = j + ADIACENT_NUMBERS;
			int vertic = ADIACENT_NUMBERS;
			
			// check horizontally
			if (horiz <= COL) {
				currentproduct *= matrix[row][j] * matrix[row][j+1] * matrix[row][j+2] * matrix[row][j+3];
				product = product < currentproduct ? currentproduct : product;
				currentproduct = 1d;
			}
			
			// check vertically
			if (vertic <= ROW) {
				currentproduct *= matrix[row][j] * matrix[row+1][j] * matrix[row+2][j] * matrix[row+3][j];
				product = product < currentproduct ? currentproduct : product;
				currentproduct = 1d;
			}
			
			// check diagonally forward
			if (vertic <= ROW && horiz <= COL) {
				currentproduct *= matrix[row][j] * matrix[row+1][j+1] * matrix[row+2][j+2] * matrix[row+3][j+3];
				product = product < currentproduct ? currentproduct : product;
				currentproduct = 1d;
			}
			
			// check diagonally backward
			if (vertic <= ROW && j - ADIACENT_NUMBERS >= 0) {
				currentproduct *= matrix[row][j] * matrix[row+1][j-1] * matrix[row+2][j-2] * matrix[row+3][j-3];
				product = product < currentproduct ? currentproduct : product;
				currentproduct = 1d;
			}
		}
		
		this.product = this.product < currentproduct ? currentproduct : this.product;
		System.out.printf(this.threadName + " product %8.0f \n", this.product);
		return this.product;
	}

}
