package il.org.spartan;

/**
 * Since 2018/11/20
 * 
 * @author Igor Bashmashnikov A class that represents a rectangle by two points
 */
public class Rectangle {
	private final double x1;
	private final double y1;
	private final double x2;
	private final double y2;

	/**
	 * @param x1 x coordinate of first point
	 * @param y1 y coordinate of first point
	 * @param x2 x coordinate of second point
	 * @param y2 y coordinate of second point
	 */
	public Rectangle(final double x1, final double y1, final double x2, final double y2) {
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
		return 2 * getWidth() + 2 * getLength();
	}

	public double getDiagonallyLength() {
		return Math.sqrt(Math.pow(getLength(), 2) + Math.pow(getWidth(), 2));
	}
}
