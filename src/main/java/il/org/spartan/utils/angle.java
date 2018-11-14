package il.org.spartan.utils;

/*
 * Since 2018-13-11
 *  Author: Lior Ben-Yamin
 */

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