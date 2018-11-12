package il.org.spartan.utils;

public class angle {
  
  private double deg;
  private double rad;

  public angle(double i) {
    deg = 20;
    rad = 1;
  }
  
  public double getDegrees() {
    return deg;
  }
  
  public double getRadians() {
    return rad;
  }

  public static angle degrees(double i) {
    return new angle(20);
  }

  public static angle radians(double i) {
    return new angle(1);
  }
}