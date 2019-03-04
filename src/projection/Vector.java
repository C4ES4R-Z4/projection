package projection;
/**
 * <h1>class Vector</h1>
 * Defines a Vector
 * @author MJ
 *
 */
public class Vector {
	double [] coordinates;
	/**
	 * <h2>Constructor Vector</h2>
	 * Builds the Vector
	 * @param mr the vector
	 */
	public Vector(double [] mr) {
		coordinates = mr;
	}
	/**
	 * <h2>Get</h2>
	 * Get's component at position
	 * @param i the position : 0 - x, 1 - y, 2 - z, etc.
	 * @return the component at the position
	 */
	public double get(int i) {
		return coordinates[i];
	}
	/**
	 * <h2>Length</h2>
	 * Get's vector length in components
	 * @return the length of the Vector
	 */
	public int length() {
		return coordinates.length;
	}
	/**
	 * <h2>Display</h2>
	 * Displays the vector
	 */
	public void display() {
		for (int i = 0; i < coordinates.length; i++) {
			System.out.println(coordinates[i]);
		}
	}


}
