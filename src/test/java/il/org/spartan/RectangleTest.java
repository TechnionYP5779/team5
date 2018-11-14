package il.org.spartan;

import org.junit.*;
import fluent.ly.*;

@SuppressWarnings("static-method")
public class RectangleTest {
  @Test  public void test() {
    final Rectangle rec = new Rectangle(1.0, 1.0, 2.0, 2.0);
    azzert.that(rec.getLength(), azzert.is(1.0));
    azzert.that(rec.getWidth(), azzert.is(1.0));
    azzert.that(rec.getArea(), azzert.is(1.0));
    azzert.that(rec.getPerimeter(), azzert.is(4.0));
  }

  @Test public void test2() {
    final Rectangle rec = new Rectangle(1, 1, 3, 4);
    azzert.that(rec.getLength(), azzert.is(3.0));
    azzert.that(rec.getWidth(), azzert.is(2.0));
    azzert.that(rec.getArea(), azzert.is(6.0));
    azzert.that(rec.getPerimeter(), azzert.is(10.0));
  }

  @Test public void test3() {
    final Rectangle rec = new Rectangle(3, 4, 1, 1);
    azzert.that(rec.getLength(), azzert.is(3.0));
    azzert.that(rec.getWidth(), azzert.is(2.0));
    azzert.that(rec.getArea(), azzert.is(6.0));
    azzert.that(rec.getPerimeter(), azzert.is(10.0));
  }

  @Test public void test4() {
    azzert.that(new Rectangle(1, 1, 4, 5).getDiagonallyLength(), azzert.is(5.0));
  }
}
