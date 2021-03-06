package il.org.spartan.utils;

/** A class for utility methods to create angles.
 * @since 2018-11-13
 * @author lior.b */
public class angle {
  public static final angle pi = new angle(180);
  private static final double deg2Rad = Math.PI / 180;
  private static final double rad2Deg = 180 / Math.PI;
  public static final angle halfPi = new angle(90);
  private final double deg;
  private final double rad;

  public angle(final double i) {
    deg = i;
    rad = i * deg2Rad;
  }

  public static angle degrees(final double i) {
    return new angle(i);
  }

  public static angle radians(final double i) {
    return new angle(i * rad2Deg);
  }

  /** @param angle a
   * @return new angle that is the sum of a and this */
  public angle add(final angle ¢) {
    return new angle(this.deg + ¢.deg);
  }

  /** @param double i
   * @return new angle that is the substract of this angle and d degrees */
  public angle substract(final double ¢) {
    return new angle(this.deg - ¢);
  }

  /** @param angle a
   * @return new angle that is the substract of a and this */
  public angle substract(final angle ¢) {
    return new angle(this.deg - ¢.deg);
  }

  /** @param double i
   * @return new angle that is the sum of this angle and d degrees */
  public angle add(final double ¢) {
    return new angle(this.deg + ¢);
  }

  public angle negate() {
    return new angle(-this.deg);
  }

  /** @return the degrees of the angle */
  public double degrees() {
    return deg;
  }

  public static angle of(final double ¢) {
    return new angle(¢);
  }

  public double radians() {
    return rad;
  }
}