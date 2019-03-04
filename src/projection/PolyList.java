package projection;
import java.awt.Color;
/**
 * <h1>class Polygon</h1>
 * Defines a Polygon
 * @author MJ
 *
 */
public class PolyList {
	Poly[] in;
	/**
	 * <h2>Constructor Polygon</h2>
	 * Builds the Polygon
	 * @param mr the Polygon
	 */
	public PolyList(Poly [] mr) {
		in = mr;
	}
	/**
	 * <h2>Get</h2>
	 * Get's Vector at position
	 * @param i the position : 0 - x, 1 - y, 2 - z, etc.
	 * @return the component at the position
	 */
	public Poly get(int i) {
		return in[i];
	}

	/**
	 * <h2>Length</h2>
	 * Get's vector length in components
	 * @return the length of the Vector
	 */
	public int length() {
		return in.length;
	}

  public double calcZ(int j) {
    double z = 0;
    for (int i = 0; i < in[j].length(); i++) {
      z += in[j].getComp(i, 2);
    }
    return z;
  }

  public void sortByFront() {
    Poly placeholder;
    for (int i = 0; i < in.length; i++) {
      for (int j = 0; j < in.length; j++) {
        if (i == j) {}
        else {
          if (calcZ(i) < calcZ(j)) {
            placeholder = in[i];
            in[i] = in[j];
            in[j] = placeholder;
          }
        }
      }
    }
  }

  public void display() {
    for (int i = 0; i < in.length; i++) {
      System.out.println(calcZ(i));
    }
  }


}
