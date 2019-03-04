import projection.*;
public class Test {

  public static void main(String[] args) {
    Vector x = new Vector(new double[]{3, 5, 6});
    Vector y = new Vector(new double[]{3, 5, 6});
    Vector z = new Vector(new double[]{1, 1, 1});

    Vector j = Operations.subtract(new Vector[]{x, y});
    //j = Operations.add(new Vector[]{j, z});
    j.display();

  }

}
