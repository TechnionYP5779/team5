package il.org.spartan.utils;

/** @since 2018-11-13
 * @author Lior Ben-Yamin */
public class angle {
  public static final angle pi = new angle(180);
  private static final double deg2Rad = Math.PI / 180;
  private static final double rad2Deg = 180 / Math.PI;
  private final double deg;
  private final double rad;

  public angle(final double i) {
    deg = i;
    rad = i * deg2Rad;
  }

  public double getDegrees() {
    return deg;
  }

  public double getRadians() {
    return rad;
  }

  public static angle degrees(final double i) {
    return new angle(i);
  }

  public static angle radians(final double i) {
    return new angle(i * rad2Deg);
  }
}