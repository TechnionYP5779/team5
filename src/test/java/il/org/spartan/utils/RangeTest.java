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
    final RangeIterator it = range.from(2).from();
    azzert.that(it.next(), azzert.is(Integer.valueOf(3)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(4)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(5)));
    azzert.that(it.hasNext(), azzert.is(true));
  }

  @SuppressWarnings("static-method") @Test public void fromTo() {
    final Range r = range.from(2).to(6);
    azzert.that(r.getFrom(), azzert.is(2));
    azzert.that(r.getTo(), azzert.is(6));
    azzert.that(r.isToInfinite(), azzert.is(false));
    azzert.that(r.isToNInfinite(), azzert.is(false));
    final RangeIterator it = range.from(2).to(6).from();
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(3)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(4)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(5)));
    azzert.that(it.hasNext(), azzert.is(false));
    azzert.that(it.next(), azzert.is(Integer.valueOf(5)));
    azzert.that(it.hasNext(), azzert.is(false));
    azzert.that(it.next(), azzert.is(Integer.valueOf(5)));
    azzert.that(it.hasNext(), azzert.is(false));
  }

  @SuppressWarnings("static-method") @Test public void to() {
    final Range r = range.to(2);
    azzert.that(r.isToInfinite(), azzert.is(false));
    azzert.that(r.isToNInfinite(), azzert.is(true));
    azzert.that(r.getTo(), azzert.is(2));
    azzert.isNull(r.from());
  }

  @SuppressWarnings("static-method") @Test public void toFrom() {
    final Range r = range.to(2).from(-5);
    azzert.that(r.isToInfinite(), azzert.is(false));
    azzert.that(r.isToNInfinite(), azzert.is(false));
    azzert.that(r.getTo(), azzert.is(2));
    azzert.that(r.getFrom(), azzert.is(-5));
    final RangeIterator it = r.from();
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(-4)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(-3)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(-2)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(-1)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(0)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(1)));
    azzert.that(it.hasNext(), azzert.is(false));
    azzert.that(it.next(), azzert.is(Integer.valueOf(1)));
    azzert.that(it.hasNext(), azzert.is(false));
  }

  @SuppressWarnings("static-method") @Test public void numbers() {
    final RangeIterator it = range.numbers;
    for (int ¢ = 1; ¢ < 10000; ++¢) {
      azzert.that(it.hasNext(), azzert.is(true));
      azzert.that(it.next(), azzert.is(Integer.valueOf(Integer.MIN_VALUE + ¢)));
    }
  }

  @SuppressWarnings("static-method") @Test public void intersect() {
    final Range r = range.to(10).interset(range.from(3));
    azzert.that(r.isToInfinite(), azzert.is(false));
    azzert.that(r.isToNInfinite(), azzert.is(false));
    azzert.that(r.getTo(), azzert.is(10));
    azzert.that(r.getFrom(), azzert.is(3));
    final RangeIterator it = r.from();
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(4)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(5)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(6)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(7)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(8)));
    azzert.that(it.hasNext(), azzert.is(true));
    azzert.that(it.next(), azzert.is(Integer.valueOf(9)));
    azzert.that(it.hasNext(), azzert.is(false));
    azzert.that(it.next(), azzert.is(Integer.valueOf(9)));
  }

  @SuppressWarnings("static-method") @Test public void includes() {
    final Range r = range.from(5).to(20);
    azzert.that(r.isToInfinite(), azzert.is(false));
    azzert.that(r.isToNInfinite(), azzert.is(false));
    azzert.that(r.getTo(), azzert.is(20));
    azzert.that(r.getFrom(), azzert.is(5));
    azzert.that(r.includes(6), azzert.is(true));
    azzert.that(r.includes(19), azzert.is(true));
    azzert.that(r.includes(20), azzert.is(false));
    azzert.that(r.includes(25), azzert.is(false));
    azzert.that(r.includes(2), azzert.is(false));
  }
}
