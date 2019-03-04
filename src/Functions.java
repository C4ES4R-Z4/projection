import projection.*;

public class Functions {
  public static Vector[] f = new Vector[20000];
  public static Vector[] axis = new Vector[6];
  static final double angle = 15;

  public static void main(String[] args) throws Exception{
    StdDraw.setCanvasSize(500, 500);
    StdDraw.setXscale(-10, 10);
    StdDraw.setYscale(-10, 10);
    StdDraw.enableDoubleBuffering();
    drawFunction();
    int counter = 0;
    //
      for (int i = 0; i < 6; i++) {
        axis[i] = Operations.project3dX(axis[i], angle);
      //  axis[i] = Operations.project3dY(axis[i], angle);
      //  axis[i] = Operations.project3dZ(axis[i], angle);
      }
      drawAxis();
    for (double t = -100; t < 100; t+=0.1) {
      f[counter] = Operations.project3dX(f[counter], angle);
    //  f[counter] = Operations.project3dY(f[counter], angle);
    //  f[counter] = Operations.project3dZ(f[counter], angle);
      //StdDraw.point(f[counter].get(0), f[counter].get(1));
      if (counter != 0) {
        StdDraw.line(f[counter - 1].get(0), f[counter - 1].get(1), f[counter].get(0), f[counter].get(1));
      }
      counter++;
    }
    System.out.print("\n\ndone 2\n\n");
    StdDraw.show();
    while(true) {
      //Thread.sleep((long) 66.7);
    }
  }

  public static void drawAxis() {
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.line(axis[0].get(0), axis[0].get(1), axis[1].get(0), axis[1].get(1));
    StdDraw.setPenColor(StdDraw.GREEN);
    StdDraw.line(axis[2].get(0), axis[2].get(1), axis[3].get(0), axis[3].get(1));
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.line(axis[4].get(0), axis[4].get(1), axis[5].get(0), axis[5].get(1));
    StdDraw.setPenColor(StdDraw.BLACK);
  }

  public static void drawFunction() {
    //axis
    axis[0] = new Vector(new double[]{-100, 0, 0}); //x line
    axis[1] = new Vector(new double[]{100, 0, 0});
    axis[2] = new Vector(new double[]{0, -100, 0}); //y line
    axis[3] = new Vector(new double[]{0, 100, 0});
    axis[4] = new Vector(new double[]{0, 0, -100}); //z line
    axis[5] = new Vector(new double[]{0, 0, 100});
    //function
    int counter = 0;
    double y = 0;
    double z = 0;
    double x = 0;
    for (double t = -100; t < 100; t+=0.1) {
        x = Math.sin(t);
        y = Math.cos(t);
        z = t;
        f[counter] = new Vector(new double[]{x, y, z});
        System.out.println("Vector " + counter + ": { " + x + ", " + y + ", " + z + "}");
        counter++;
    }
    System.out.print("\n\ndone 1\n\n");
  }

}
