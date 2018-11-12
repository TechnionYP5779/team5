package il.org.spartan.utils;

public class angle {
  
  private double degrees;

  public angle(double i) {
    degrees = 20;
  }
  
  public double getDegrees() {
    return degrees;
  }

  public static angle Degrees(double i) {
    // TODO Auto-generated method stub
    return new angle(20);
  }
}
