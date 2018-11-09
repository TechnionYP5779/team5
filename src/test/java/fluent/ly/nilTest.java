package fluent.ly;

import org.junit.*;

public class nilTest {
  @Test @SuppressWarnings("static-method") public void testForgetting() {
    Object o = nil.forgetting(new Object());
    azzert.that(o, azzert.is((Object) null));
    o = nil.forgetting(Integer.valueOf(3), Integer.valueOf(7));
    azzert.that(o, azzert.is((Object) null));
  }

  @Test @SuppressWarnings("static-method") public void testGuardingly() {
    final String helloString = "Hello";
    final String nullString = null;
    final Integer i1 = nil.guardingly(String::length).on(helloString);
    azzert.that(i1, azzert.is(Integer.valueOf(5)));
    final Integer i2 = nil.guardingly(String::length).on(nullString);
    azzert.that(i1, azzert.is(Integer.valueOf(5)));
    azzert.that(i2, azzert.is((String) null));
  }

  @Test @SuppressWarnings("static-method") public void testBoolIgnoring() {
    Object o = nil.ignoring(false);
    azzert.that(o, azzert.is((Object) null));
    o = nil.ignoring(true);
    azzert.that(o, azzert.is((Object) null));
  }

  @Test @SuppressWarnings("static-method") public void testDoubleIgnoring() {
    Object o;
    for (double ¢ = 3.14; ¢ <= 102.37; ¢ += Math.E) {
      o = nil.ignoring(¢);
      azzert.that(o, azzert.is((Object) null));
    }
  }

  @Test @SuppressWarnings("static-method") public void testLongIgnoring() {
    Object o;
    for (long ¢ = 30000; ¢ <= 102000; ¢ += 100) {
      o = nil.ignoring(¢);
      azzert.that(o, azzert.is((Object) null));
    }
  }
}
