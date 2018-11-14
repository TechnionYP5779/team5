package il.org.spartan.utils;
import static fluent.ly.azzert.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Range.*;
@SuppressWarnings("static-method")
public class RangeTest {
   @Test public void rangefrom() {
    azzert.that(range.from(2).getFrom(), is(2));
    azzert.that(range.from(2).isToInfinite(), is(true));
    azzert.that(range.from(2).isToNInfinite(), is(false));
  }
  @Test public void Rangefrom() {
    azzert.that(range.from(2).from().hasNext(), is(true));
    RangeIterator it=range.from(2).from();
    azzert.that(it.next(), is(box.box(3)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(4)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(5)));
    azzert.that(it.hasNext(), is(true));
  }
  @Test public void fromTo() {
    Range r=range.from(2).to(6);
    azzert.that(r.getFrom(), is(2));
    azzert.that(r.getTo(), is(6));
    azzert.that(r.isToInfinite(), is(false));
    azzert.that(r.isToNInfinite(), is(false));
    RangeIterator it=range.from(2).to(6).from();
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(3)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(4)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(5)));
    azzert.that(it.hasNext(), is(false));
    azzert.that(it.next(), is(box.box(5)));
    azzert.that(it.hasNext(), is(false));
    azzert.that(it.next(), is(box.box(5)));
    azzert.that(it.hasNext(), is(false));
   }
  
  @Test public void to() {
    Range r=range.to(2);
    azzert.that(r.isToInfinite(), is(false));
    azzert.that(r.isToNInfinite(), is(true));
    azzert.that(r.getTo(), is(2));
    isNull(r.from());
   }
  
  @Test public void toFrom() {
    Range r=range.to(2).from(-5);
    azzert.that(r.isToInfinite(), is(false));
    azzert.that(r.isToNInfinite(), is(false));
    azzert.that(r.getTo(), is(2));
    azzert.that(r.getFrom(), is(-5));
    RangeIterator it=r.from();
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(-4)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(-3)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(-2)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(-1)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(0)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(1)));
    azzert.that(it.hasNext(), is(false));
    azzert.that(it.next(), is(box.box(1)));
    azzert.that(it.hasNext(), is(false));
   }
  @Test public void numbers() {
    RangeIterator it=range.numbers;
    for(int ¢=1;¢<10000;++¢) {
      azzert.that(it.hasNext(), is(true));
      azzert.that(it.next(), is(box.box(Integer.MIN_VALUE+¢)));
    }
  }
  
 @Test public void intersect() {
    Range r=range.to(10).interset(range.from(3));
    azzert.that(r.isToInfinite(), is(false));
    azzert.that(r.isToNInfinite(), is(false));
    azzert.that(r.getTo(), is(10));
    azzert.that(r.getFrom(), is(3));
    RangeIterator it=r.from();
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(4)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(5)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(6)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(7)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(8)));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(box.box(9)));
    azzert.that(it.hasNext(), is(false));
    azzert.that(it.next(), is(box.box(9)));
  }
  @Test public void includes() {
    Range r=range.from(5).to(20);
    azzert.that(r.isToInfinite(), is(false));
    azzert.that(r.isToNInfinite(), is(false));
    azzert.that(r.getTo(), is(20));
    azzert.that(r.getFrom(), is(5));
    azzert.that(r.includes(6), is(true));
    azzert.that(r.includes(19), is(true));
    azzert.that(r.includes(20), is(false));
    azzert.that(r.includes(25), is(false));
    azzert.that(r.includes(2), is(false));
  }
}
