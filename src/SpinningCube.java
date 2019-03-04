
import projection.*;

public class SpinningCube {

	static double angle = 0;

	static Vector a = new Vector(new double[] {-1, 1, 1});
	static Vector b = new Vector(new double[] {-1, -1, 1});
	static Vector c = new Vector(new double[] {1, 1, 1});
	static Vector d = new Vector(new double[] {1, -1, 1});
	static Vector e = new Vector(new double[] {-1, 1, -1});
	static Vector f = new Vector(new double[] {-1, -1, -1});
	static Vector g = new Vector(new double[] {1, 1, -1});
	static Vector h = new Vector(new double[] {1, -1, -1});

	static Vector [] square = new Vector[8];

	public static void main(String [] args) throws InterruptedException {
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(-5, 5);
		StdDraw.setYscale(-5, 5);
		StdDraw.setPenRadius(0.01);
		StdDraw.enableDoubleBuffering();
		update();
	}

	public static void update() throws InterruptedException {
		Vector point = new Vector(new double[] {-1, 1});
		while(true) {
			for (angle = 0; angle < 360; angle+=0.017) {
				draw2DVectorPoint(new Vector[]{a, b, c, d, e, f, g, h});
				drawLines();
				StdDraw.show();
				Thread.sleep((long) 16.7);
				erase();
			}
		}
	}

	public static void draw2DVectorPoint(Vector [] x) {
		for (int i = 0; i < x.length; i++) {
			Vector point = x[i];

				point = Operations.project3dX(point, angle);

				point = Operations.project3dY(point, angle);

				point = Operations.project3dZ(point, angle);

			StdDraw.point(point.get(0), point.get(1));
			square[i] = point;
		}
	}

	public static void drawLines() {
		StdDraw.line(square[0].get(0), square[0].get(1), square[1].get(0), square[1].get(1));
		StdDraw.line(square[1].get(0), square[1].get(1), square[3].get(0), square[3].get(1));
		StdDraw.line(square[3].get(0), square[3].get(1), square[2].get(0), square[2].get(1));
		StdDraw.line(square[2].get(0), square[2].get(1), square[0].get(0), square[0].get(1));

		StdDraw.line(square[4].get(0), square[4].get(1), square[5].get(0), square[5].get(1));
		StdDraw.line(square[5].get(0), square[5].get(1), square[7].get(0), square[7].get(1));
		StdDraw.line(square[7].get(0), square[7].get(1), square[6].get(0), square[6].get(1));
		StdDraw.line(square[6].get(0), square[6].get(1), square[4].get(0), square[4].get(1));

		StdDraw.line(square[0].get(0), square[0].get(1), square[4].get(0), square[4].get(1));
		StdDraw.line(square[1].get(0), square[1].get(1), square[5].get(0), square[5].get(1));
		StdDraw.line(square[2].get(0), square[2].get(1), square[6].get(0), square[6].get(1));
		StdDraw.line(square[3].get(0), square[3].get(1), square[7].get(0), square[7].get(1));
	}

	public static void erase() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(0, 0, 10, 10);
		StdDraw.setPenColor(StdDraw.BLACK);
	}
}
