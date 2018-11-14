package il.org.spartan.utils;
import static fluent.ly.azzert.*;
import org.junit.*;

import fluent.ly.*;
@SuppressWarnings("static-method")
public class TestBool {
  @Test public void testValueOf() {
    azzert.that(Bool.valueOf(true).get(), is(true));
  }

  @Test  public void testClear() {
    final Bool b = new Bool(true);
    b.clear();
    azzert.that(b.get(), is(false));
  }

  @Test public void testSet() {
    final Bool b = new Bool(true);
    b.set(false);
    azzert.that(b.get(), is(false));
    b.set();
    azzert.that(b.get(), is(true));
  }

  @Test public void testInner() {
    azzert.that(Bool.valueOf(true).inner(), is(Boolean.TRUE));
    azzert.that(Bool.valueOf(false).inner(), is(Boolean.FALSE));
  }

  @Test public void testEmptyConst() {
    azzert.that(new Bool().get(), is(false));
    azzert.that(Bool.valueOf(false).inner(), is(Boolean.FALSE));
  }
}
