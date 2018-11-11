package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Range.*;

public class RangeTest {
  @SuppressWarnings("static-method") @Test public void rangefrom() {
    azzert.that(range.from(2).getFrom(), azzert.is(2));
    azzert.that(range.from(2).isToInfinite(), azzert.is(true));
    azzert.that(range.from(2).isToNInfinite(), azzert.is(false));
  }
  @SuppressWarnings("static-method") @Test public void Rangefrom() {
    azzert.that(range.from(2).from().hasNext(), azzert.is(true));
    RangeIterator it=range.from(2).from();
    azzert.that(it.next(), azzert.is(Integer.valueOf(3)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(4)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(5)));
    azzert.that(it.hasNext(), azzert.is(true));
  }
}
