package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
@SuppressWarnings("static-method")
public class TestBool {
  @Test public void testValueOf() {
    azzert.that(Bool.valueOf(true).get(), azzert.is(true));
  }

  @Test  public void testClear() {
    final Bool b = new Bool(true);
    b.clear();
    azzert.that(b.get(), azzert.is(false));
  }

  @Test public void testSet() {
    final Bool b = new Bool(true);
    b.set(false);
    azzert.that(b.get(), azzert.is(false));
    b.set();
    azzert.that(b.get(), azzert.is(true));
  }

  @Test public void testInner() {
    azzert.that(Bool.valueOf(true).inner(), azzert.is(Boolean.TRUE));
    azzert.that(Bool.valueOf(false).inner(), azzert.is(Boolean.FALSE));
  }

  @Test public void testEmptyConst() {
    azzert.that(new Bool().get(), azzert.is(false));
    azzert.that(Bool.valueOf(false).inner(), azzert.is(Boolean.FALSE));
  }
}
