package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearLineTest {
  @Test public void testcnstr() {
    final LinearLine l = new LinearLine(1.0, 2.0);
    azzert.that(l.beta0, is(2.0));
  }

  @Test public void testcnstr2() {
    final LinearLine l = new LinearLine(1.0, 2.0);
    azzert.that(l.beta1, is(1.0));
  }

  @Test public void yOf() {
    final LinearLine l = new LinearLine(1.0, 2.0);
    azzert.that(l.yOf(2), is(4.0));
  }
}
