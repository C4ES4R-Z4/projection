import projection.*;
import java.awt.Color;

public class Polygon {
	static Vector [] points = new Vector[10];
	static Vector [] polygon = new Vector[10];
	static PolyList group;
	static Vector e = new Vector(new double[]{0.5,0.5,0.5});
	/*
	 * MAIN
	 */
	public static void main(String [] args) throws InterruptedException {
		//GUI
		StdDraw.setCanvasSize(500,500);
		StdDraw.setXscale(-5, 5);
		StdDraw.setYscale(-5, 5);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(StdDraw.BLACK);
		drawVectors();
		rotate();
		//drawLines();
		//StdDraw.show();
	}


	public static void drawVectors() {
		points[0] = new Vector(new double[]{0, 0, 0});
		points[1] = new Vector(new double[]{-1.5, 0, -3});
		points[2] = new Vector(new double[]{-1, 1, -3});
		points[3] = new Vector(new double[]{0, 1.5, -3});
		points[4] = new Vector(new double[]{1, 1, -3});
		points[5] = new Vector(new double[]{1.5, 0, -3});
		points[6] = new Vector(new double[]{1, -1, -3});
		points[7] = new Vector(new double[]{0, -1.5, -3});
		points[8] = new Vector(new double[]{-1, -1, -3});
		points[9] = new Vector(new double[]{0, 0, 3});

		for (int i = 0; i < points.length; i++) {
			polygon[i] = points[i];
		}
	}

	public static void drawLines() {
		StdDraw.line(points[1].get(0), points[1].get(1), points[2].get(0), points[2].get(1));
			StdDraw.line(points[1].get(0), points[1].get(1), points[9].get(0), points[9].get(1));
		StdDraw.line(points[2].get(0), points[2].get(1), points[3].get(0), points[3].get(1));
			StdDraw.line(points[2].get(0), points[2].get(1), points[9].get(0), points[9].get(1));
		StdDraw.line(points[3].get(0), points[3].get(1), points[4].get(0), points[4].get(1));
			StdDraw.line(points[3].get(0), points[3].get(1), points[9].get(0), points[9].get(1));
		StdDraw.line(points[4].get(0), points[4].get(1), points[5].get(0), points[5].get(1));
			StdDraw.line(points[4].get(0), points[4].get(1), points[9].get(0), points[9].get(1));
		StdDraw.line(points[5].get(0), points[5].get(1), points[6].get(0), points[6].get(1));
			StdDraw.line(points[5].get(0), points[5].get(1), points[9].get(0), points[9].get(1));
		StdDraw.line(points[6].get(0), points[6].get(1), points[7].get(0), points[7].get(1));
			StdDraw.line(points[6].get(0), points[6].get(1), points[9].get(0), points[9].get(1));
		StdDraw.line(points[7].get(0), points[7].get(1), points[8].get(0), points[8].get(1));
			StdDraw.line(points[7].get(0), points[7].get(1), points[9].get(0), points[9].get(1));
		StdDraw.line(points[8].get(0), points[8].get(1), points[1].get(0), points[1].get(1));
			StdDraw.line(points[8].get(0), points[8].get(1), points[9].get(0), points[9].get(1));
		//	fill(new Poly(new Vector[]{points[1], points[2], points[9]}), StdDraw.RED);

		group = new PolyList(new Poly[]{
			new Poly(new Vector[]{points[1], points[2], points[9]}, StdDraw.RED),
			new Poly(new Vector[]{points[2], points[3], points[9]}, StdDraw.GREEN),
			new Poly(new Vector[]{points[3], points[4], points[9]}, StdDraw.BLUE),
			new Poly(new Vector[]{points[4], points[5], points[9]}, StdDraw.YELLOW),
			new Poly(new Vector[]{points[5], points[6], points[9]}, StdDraw.CYAN),
			new Poly(new Vector[]{points[6], points[7], points[9]}, StdDraw.MAGENTA),
			new Poly(new Vector[]{points[7], points[8], points[9]}, StdDraw.PINK),
			new Poly(new Vector[]{points[8], points[1], points[9]}, StdDraw.GRAY),

		});

		group.sortByFront();
		fillBy();

	}

	public static void fillBy() {
		for (int i = 0; i < group.length(); i++) {
			fill(group.get(i), group.get(i).getColor());
		}
	}


	public static boolean check(Vector[] o, Vector[] y) {
		double z1 = o[0].get(2) + o[1].get(2) + o[2].get(2);
		double z2 = y[0].get(2) + y[1].get(2) + y[2].get(2);
		return z1 < z2;
	}

	public static void rotate() throws InterruptedException {
		while(true) {
		//	for (double j = 0; j < 360; j+=0.017) {
				for (int i = 0; i < points.length; i++) {
					points[i] = Operations.project3dZ(points[i], 0.017);
					points[i] = Operations.project3dY(points[i], 0.017);
					points[i] = Operations.project3dX(points[i], 0.017);
					//points[i] = Operations.project3dZ(polygon[i], j);
					//System.out.println("z: " + points[9].get(2));
				}
				drawLines();
				StdDraw.show();
				Thread.sleep((long) 66.7); //66.7 for 60fps
				erase();
			}
		//}
	}



	public static void fill(Poly in, Color cl) {
    double []x = new double[in.length()];
    double []y = new double[in.length()];
    for (int i = 0; i < x.length; i++) {
      x[i] = in.getComp(i, 0);
      y[i] = in.getComp(i, 1);
    }
    Color before = StdDraw.getPenColor();
    StdDraw.setPenColor(cl);
    StdDraw.filledPolygon(x, y);
    StdDraw.setPenColor(before);
  }

	public static void erase() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(0, 0, 10, 10);
		StdDraw.setPenColor(StdDraw.BLACK);
	}

	public static void project3D() throws InterruptedException {
		for (int i = 0; i < points.length; i++) {
			points[i] = Operations.project3dX(points[i], 45);
			points[i] = Operations.project3dY(points[i], 90);
		}
	}

}
