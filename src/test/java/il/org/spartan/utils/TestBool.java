package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class TestBool {
  @Test @SuppressWarnings("static-method") public void testValueOf() {
    azzert.that(Bool.valueOf(true).get(), azzert.is(true));
  }

  @Test @SuppressWarnings("static-method") public void testClear() {
    final Bool b = new Bool(true);
    b.clear();
    azzert.that(b.get(), azzert.is(false));
  }

  @Test @SuppressWarnings("static-method") public void testSet() {
    final Bool b = new Bool(true);
    b.set(false);
    azzert.that(b.get(), azzert.is(false));
    b.set();
    azzert.that(b.get(), azzert.is(true));
  }

  @Test @SuppressWarnings("static-method") public void testInner() {
    azzert.that(Bool.valueOf(true).inner(), azzert.is(Boolean.TRUE));
    azzert.that(Bool.valueOf(false).inner(), azzert.is(Boolean.FALSE));
  }

  @Test @SuppressWarnings("static-method") public void testEmptyConst() {
    azzert.that(new Bool().get(), azzert.is(false));
    azzert.that(Bool.valueOf(false).inner(), azzert.is(Boolean.FALSE));
  }
}
