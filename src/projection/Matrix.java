package projection;
/**
 * <h1>class Matrix</h1>
 * Defines a matrix
 * @author MJ
 *
 */
public class Matrix {
	double [][] matrix ;
	/**
	 * <h2>Constructor Matrix</h2>
	 * Builds the matrix
	 * @param mr the matrix
	 */
	public Matrix(double [][] mr) {
		matrix = mr;
	}
	/**
	 * <h2>Get</h2>
	 * Get's component at position
	 * @param i the i-th position
	 * @param j the j-th position
	 */
	public double get(int i, int j) {
		return matrix[i][j];
	}
	/**
	 * <h2>Get Side Length</h2>
	 * Get's a matrix's square length
	 * @return the length of the matrix
	 */
	public int getLength() {
		return matrix.length;
	}
	/**
	 * <h2>Transpose</h2>
	 * Transpose the matrix
	 */
	public void transpose() {
		double [][] mr = matrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = mr[j][i];
			}
		}
	}
	/**
	 * <h2>Get Row Vector</h2>
	 * Gets row vector at row position
	 * @param i-th row you want returned
	 */
	public Vector getRowVector(int i) {
		double [] arr = new double[matrix.length];
		for (int j = 0; j < matrix.length; j++) {
			arr[j] = matrix[i][j];
		}
		return new Vector(arr);
	}
	/**
	 * <h2>Get Column Vector</h2>
	 * Gets column vector at column position
	 * @param j-th column you want returned
	 */
	public Vector getColVector(int i) {
		double [] arr = new double[matrix.length];
		for (int j = 0; j < matrix.length; j++) {
			arr[j] = matrix[j][i];
		}
		return new Vector(arr);
	}
	/**
	 * <h2>Display</h2>
	 * Displays the matrix
	 */
	public void display() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
