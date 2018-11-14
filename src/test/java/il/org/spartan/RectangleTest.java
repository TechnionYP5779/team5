package il.org.spartan;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RectangleTest {
  @Test public void test() {
    final Rectangle rec = new Rectangle(1.0, 1.0, 2.0, 2.0);
    azzert.that(rec.getLength(), is(1.0));
    azzert.that(rec.getWidth(), is(1.0));
    azzert.that(rec.getArea(), is(1.0));
    azzert.that(rec.getPerimeter(), is(4.0));
  }

  @Test public void test2() {
    final Rectangle rec = new Rectangle(1, 1, 3, 4);
    azzert.that(rec.getLength(), is(3.0));
    azzert.that(rec.getWidth(), is(2.0));
    azzert.that(rec.getArea(), is(6.0));
    azzert.that(rec.getPerimeter(), is(10.0));
  }

  @Test public void test3() {
    final Rectangle rec = new Rectangle(3, 4, 1, 1);
    azzert.that(rec.getLength(), is(3.0));
    azzert.that(rec.getWidth(), is(2.0));
    azzert.that(rec.getArea(), is(6.0));
    azzert.that(rec.getPerimeter(), is(10.0));
  }

  @Test public void test4() {
    azzert.that(new Rectangle(1, 1, 4, 5).getDiagonallyLength(), is(5.0));
  }
}
