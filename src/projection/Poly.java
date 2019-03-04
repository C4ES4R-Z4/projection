package projection;
import java.awt.Color;
/**
 * <h1>class Polygon</h1>
 * Defines a Polygon
 * @author MJ
 *
 */
public class Poly {
	Vector[] in;
	Color n;
	/**
	 * <h2>Constructor Polygon</h2>
	 * Builds the Polygon
	 * @param mr the Polygon
	 */
	public Poly(Vector [] mr) {
		in = mr;
	}
	public Poly(Vector [] mr, Color k) {
		in = mr;
		n = k;
	}
	/**
	 * <h2>Get</h2>
	 * Get's Vector at position
	 * @param i the position : 0 - x, 1 - y, 2 - z, etc.
	 * @return the component at the position
	 */
	public Vector get(int i) {
		return in[i];
	}
  /**
	 * <h2>GetComp</h2>
	 * Get's component at position
	 * @param i the position : 0 - x, 1 - y, 2 - z, etc.
	 * @return the component at the position
	 */
	public double getComp(int i, int j) {
		return in[i].get(j);
	}

	public Color getColor() {
		return n;
	}
	/**
	 * <h2>Length</h2>
	 * Get's vector length in components
	 * @return the length of the Vector
	 */
	public int length() {
		return in.length;
	}

  public Vector[] fill() {
		return in;
  }


}
