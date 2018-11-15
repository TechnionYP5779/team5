package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearLineTest {
  @Test public void testcnstr() {
    LinearLine l = new LinearLine(1.0, 2.0);
    azzert.that(l.beta0, azzert.is(2.0));
  }

  @Test public void testcnstr2() {
    LinearLine l = new LinearLine(1.0, 2.0);
    azzert.that(l.beta1, azzert.is(1.0));
  }

  @Test public void yOf() {
    LinearLine l = new LinearLine(1.0, 2.0);
    azzert.that(l.yOf(2), azzert.is(4.0));
  }
}
