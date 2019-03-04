package projection;
/**
 * <h1>Operations</h1>
 * Operations on Vectors and Matrices
 * @author MJ
 */
public class Operations {
	/**
	 * <h2>Dot Product</h2>
	 * Returns the dot product of two vectors
	 * @param x - the first vector
	 * @param y - the second vector
	 * @return the Dot Product
	 */
	public static double dotProduct(Vector x, Vector y) {
		double result = 0;
		for (int i = 0; i < x.length(); i++) {
			result += (x.get(i) * y.get(i));
		}
		return result;
	}
	/**
	*<h2>Add</h2>
	* Adds vectors
	* @param x list of vectors
	* @return the new vector
	*/
	public static Vector add(Vector[] x) {
		double []y = new double[3];
		for (int i = 0; i < x.length; i++) {
			for (int j =0; j < 3; j++) {
					y[j] += x[i].get(j);
			}
		}
		Vector ret = new Vector(y);
		return ret;
	}
	/**
	*<h2>Subtract</h2>
	* Adds vectors
	* @param x list of vectors
	* @return the new vector
	*/
	public static Vector subtract(Vector[] x) {
		double []y = new double[3];
		for (int i = 0; i < x.length; i++) {
			if (i == 0) {
				for (int k = 0; k < 3; k++) {
					y[k] = x[i].get(k);
				}
			}else {
				for (int j =0; j < 3; j++) {
					y[j] -= x[i].get(j);
				}
			}
		}
		Vector ret = new Vector(y);
		return ret;
	}
	/**
	 * <h2>Row Matrix</h2>
	 * Make a row matrix out of row vectors
	 * @param arr - List of vectors
	 * @return the new matrix
	 */
	public static Matrix rowMatrix(Vector [] arr) {
		double [][] arrx = new double[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arrx[i][j] = arr[i].get(j);
			}
		}
		return new Matrix(arrx);
	}
	/**
	 * <h2>Column Matrix</h2>
	 * Make a column matrix out of column vectors
	 * @param arr - List of vectors
	 * @return the new matrix
	 */
	public static Matrix colMatrix(Vector [] arr) {
		double [][] arrx = new double[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arrx[i][j] = arr[j].get(i);
			}
		}
		return new Matrix(arrx);
	}
	/**
	 * <h2>Matrix Multiplication</h2>
	 * Multiplies two square matrices
	 * @param x - matrix
	 * @param y - matrix
	 * @return the new matrix
	 */
	public static Matrix matrixMultiply(Matrix x, Matrix y) {
		double[][] arrx = new double[x.getLength()][x.getLength()];
		for (int i = 0; i < x.getLength(); i++) {
			for (int j = 0; j < x.getLength(); j++) {
				arrx[i][j] = dotProduct(x.getRowVector(i), y.getColVector(j));
			}
		}
		return new Matrix(arrx);
	}
	/**
	 * <h2>Matrix Column</h2>
	 * Multiplies a matrix and a column vector
	 * @param x - Matrix
	 * @param y - Column vector
	 * @return the new column vector
	 */
	public static Vector matrixMultiply(Matrix x, Vector y) {
		double[] arrx = new double[y.length()];
		for (int i = 0; i < y.length(); i++) {
				arrx[i] = dotProduct(x.getRowVector(i), y);
		}
		return new Vector(arrx);
	}
	/**
	 * <h2>Matrix Row</h2>
	 * Multiplies a matrix and a row vector
	 * @param x - Row Vector
	 * @param y - Matrix
	 * @return the new row vector
	 */
	public static Vector matrixMultiply(Vector x, Matrix y) {
		double[] arrx = new double[x.length()];
		for (int i = 0; i < x.length(); i++) {
				arrx[i] = dotProduct(x, y.getColVector(i));
		}
		return new Vector(arrx);
	}

	/**
	 * <h2>RotationX</h2>
	 * Projects a rotation around the X axistwo
	 * @param x - Vector
	 * @param angle - degrees of rotation - incremental
	 */
	public static Vector project3dX(Vector x, double angle) {
		return Operations.matrixMultiply(new Matrix(new double[][] {
				{1, 0, 0},
				{0, Math.cos(angle), -Math.sin(angle)},
				{0, Math.sin(angle), Math.cos(angle)}
			}), x);
	}
	/**
	 * <h2>RotationY</h2>
	 * Projects a rotation around the Y axis
	 * @param x - Vector
	 * @param angle - degrees of rotation - incremental
	 */
	public static Vector project3dY(Vector x, double angle) {
		return Operations.matrixMultiply(new Matrix(new double[][] {
				{Math.cos(angle), 0, Math.sin(angle)},
				{0, 1, 0},
				{-Math.sin(angle), 0, Math.cos(angle)}
			}), x);
	}
	/**
	 * <h2>RotationZ</h2>
	 * Projects a rotation around the Z axis
	 * @param x - Vector
	 * @param angle - degrees of rotation - incremental
	 */
	public static Vector project3dZ(Vector x, double angle) {
		return Operations.matrixMultiply(new Matrix(new double[][] {
				{Math.cos(angle), -Math.sin(angle), 0},
				{Math.sin(angle), Math.cos(angle), 0},
				{0, 0, 1}
			}), x);
	}
	/**
	 * <h2>RotationXPersepective</h2>
	 * Projects a rotation around the X axis
	 * @param x - Vector
	 * @param c - Camera
	 * @param angle - degrees of rotation - incremental
	 */
	public static Vector projectP3dX(Vector x, Vector c, double angle) {
		Vector ret =  Operations.matrixMultiply(new Matrix(new double[][] {
				{1, 0, 0},
				{0, Math.cos(angle), -Math.sin(angle)},
				{0, Math.sin(angle), Math.cos(angle)}
			}), subtract(new Vector[]{x, c}));

			double x1 = (ret.get(0) * 0.5)/(ret.get(2) * 0.05) * 1;
			double y = (ret.get(1) * 0.5)/(ret.get(2) * 0.05) * 1;
			double z = ret.get(2);

			ret = new Vector(new double[]{x1,y,z});

			return ret;
	}
	/**
	 * <h2>RotationYPerspective</h2>
	 * Projects a rotation around the Y axis
	 * @param x - Vector
	 * @param angle - degrees of rotation - incremental
	 */
	public static Vector projectP3dY(Vector x, Vector c, double angle) {
		return Operations.matrixMultiply(new Matrix(new double[][] {
				{Math.cos(angle), 0, Math.sin(angle)},
				{0, 1, 0},
				{-Math.sin(angle), 0, Math.cos(angle)}
			}), subtract(new Vector[]{x, c}));
	}
	/**
	 * <h2>RotationZPerspective</h2>
	 * Projects a rotation around the Z axis
	 * @param x - Vector
	 * @param angle - degrees of rotation - incremental
	 */
	public static Vector projectP3dZ(Vector x, Vector c, double angle) {
		return Operations.matrixMultiply(new Matrix(new double[][] {
				{Math.cos(angle), -Math.sin(angle), 0},
				{Math.sin(angle), Math.cos(angle), 0},
				{0, 0, 1}
			}), subtract(new Vector[]{x, c}));
	}
}
