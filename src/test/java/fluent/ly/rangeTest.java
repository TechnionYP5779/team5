package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.range.*;

@SuppressWarnings("static-method") public class rangeTest {
  @Test public void rangefrom() {
    azzert.that(range.from(2).getFrom(), is(2));
    assert range.from(2).isToInfinite();
    assert !range.from(2).isFromInfinite();
    range r = new range(1, true);
    assert r.isFromInfinite();
    assert !r.isToInfinite();
  }

  @Test public void Rangefrom() {
    assert range.from(2).from().hasNext();
    final rangeIterator it = range.from(2).from();
    azzert.that(it.next(), is(box.it(3)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(4)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(5)));
    assert it.hasNext();
  }

  @Test public void fromTo() {
    final rangedTo r = range.from(2).to(6);
    azzert.that(r.getFrom(), is(2));
    azzert.that(r.getTo(), is(6));
    final rangeIterator it = range.from(2).to(6).from();
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(3)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(4)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(5)));
    assert it.hasNext();
  }


  @Test public void to() {
    final rangedTo r = range.to(2);
    azzert.that(r.getTo(), is(2));
  }

  @Test public void toFrom() {
    final rangedTo r = range.to(2).from(-5);
    azzert.that(r.getTo(), is(2));
    azzert.that(r.getFrom(), is(-5));
    final range rr = new range(1, 7);
    final range rr_in1 = new range(1, true);
    assert !rr_in1.isToInfinite();
    assert rr_in1.isFromInfinite();
    final range rr_in2 = new range(1, false);
    assert rr_in2.isToInfinite();
    assert !rr_in2.isFromInfinite();
    azzert.isNull(rr_in1.from());
    final rangedTo in = rr.interset(rr);
    final rangeIterator itt = rr.from();
    final rangeIterator it = r.from();
    assert in.from().hasNext();
    assert itt.hasNext();
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(-4)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(-3)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(-2)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(-1)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(0)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(1)));
    assert it.hasNext();
  }
//
  @Test public void numbers() {
    final rangeIterator it = range.numbers;
    for (int ¢ = 1; ¢ < 10000; ++¢) {
      assert it.hasNext();
      azzert.that(it.next(), is(box.it(Integer.MIN_VALUE + ¢)));
    }
  }

  @Test public void intersect() {
    final rangedTo r = range.to(10).interset(range.from(3));
    azzert.that(r.getTo(), is(10));
    azzert.that(r.getFrom(), is(3));
    final rangeIterator it = r.from();
    final rangedFrom fr = range.from(3);
    assert fr.isToInfinite();
    assert !fr.isFromInfinite();
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(4)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(5)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(6)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(7)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(8)));
    assert it.hasNext();
    azzert.that(it.next(), is(box.it(9)));
    assert it.hasNext();
  }

  @Test public void includes() {
    final rangedTo r = range.from(5).to(20);
    azzert.that(r.getTo(), is(20));
    azzert.that(r.getFrom(), is(5));
    assert r.includes(6);
    assert r.includes(19);
    assert !r.includes(20);
    assert !r.includes(25);
    assert !r.includes(2);
  }
}
