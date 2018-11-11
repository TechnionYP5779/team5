package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class RangeTest {
  @SuppressWarnings("static-method") @Test public void rangefrom() {
    azzert.that(range.from(2).getFrom(), azzert.is(2));
    azzert.that(range.from(2).isToInfinite(), azzert.is(true));
    azzert.that(range.from(2).isToNInfinite(), azzert.is(false));
  }
}
