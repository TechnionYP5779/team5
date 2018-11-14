package il.org.spartan.utils;

/** A class for utility methods to create angles.
 * @since 2018-11-13
 * @author lior.b */
public class angle {
  public static final angle pi = new angle(180);
  private static final double deg2Rad = Math.PI / 180;
  private static final double rad2Deg = 180 / Math.PI;
  private double deg;
  private double rad;

  public angle(double i) {
    deg = i;
    rad = i * deg2Rad;
  }

  public double getDegrees() {
    return deg;
  }

  public double getRadians() {
    return rad;
  }

  public static angle degrees(double i) {
    return new angle(i);
  }

  public static angle radians(double i) {
    return new angle(i * rad2Deg);
  }
}