package a;

public class Rectangle {

  private double x1;
  private double y1;
  private double x2;
  private double y2;

  public Rectangle(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public double getLength() {
    return Math.abs(y2 - y1);
  }

  public double getWidth() {
    return Math.abs(x2 - x1);
  }

  public double getArea() {
    return getWidth() * getLength();
  }

  public double getPerimeter() {
    return 2*getWidth() + 2*getLength();
  }

  public double getDiagonallyLength() {
    return Math.sqrt(Math.pow(getLength(), 2) + Math.pow(getWidth(), 2));
  }
}
