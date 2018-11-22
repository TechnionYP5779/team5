// package il.org.spartan.utils;
//
// import static fluent.ly.azzert.*;
//
// import org.junit.*;
//
// import fluent.ly.*;
// import il.org.spartan.utils.Range.*;
//
// @SuppressWarnings("static-method") public class RangeTest {
// @Test public void rangefrom() {
// azzert.that(range.from(2).getFrom(), is(2));
// assert range.from(2).isToInfinite();
// assert !range.from(2).isToNInfinite();
// }
//
// @Test public void Rangefrom() {
// assert range.from(2).from().hasNext();
// final RangeIterator it = range.from(2).from();
// azzert.that(it.next(), is(box.it(3)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(4)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(5)));
// assert it.hasNext();
// }
//
// @Test public void fromTo() {
// final Range r = range.from(2).to(6);
// azzert.that(r.getFrom(), is(2));
// azzert.that(r.getTo(), is(6));
// assert !r.isToInfinite();
// assert !r.isToNInfinite();
// final RangeIterator it = range.from(2).to(6).from();
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(3)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(4)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(5)));
// assert !it.hasNext();
// azzert.that(it.next(), is(box.it(5)));
// assert !it.hasNext();
// azzert.that(it.next(), is(box.it(5)));
// assert !it.hasNext();
// }
//
// @Test public void to() {
// final Range r = range.to(2);
// assert !r.isToInfinite();
// assert r.isToNInfinite();
// azzert.that(r.getTo(), is(2));
// isNull(r.from());
// }
//
// @Test public void toFrom() {
// final Range r = range.to(2).from(-5);
// assert !r.isToInfinite();
// assert !r.isToNInfinite();
// azzert.that(r.getTo(), is(2));
// azzert.that(r.getFrom(), is(-5));
// final RangeIterator it = r.from();
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(-4)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(-3)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(-2)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(-1)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(0)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(1)));
// assert !it.hasNext();
// azzert.that(it.next(), is(box.it(1)));
// assert !it.hasNext();
// }
//
// @Test public void numbers() {
// final RangeIterator it = range.numbers;
// for (int ¢ = 1; ¢ < 10000; ++¢) {
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(Integer.MIN_VALUE + ¢)));
// }
// }
//
// @Test public void intersect() {
// final Range r = range.to(10).interset(range.from(3));
// assert !r.isToInfinite();
// assert !r.isToNInfinite();
// azzert.that(r.getTo(), is(10));
// azzert.that(r.getFrom(), is(3));
// final RangeIterator it = r.from();
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(4)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(5)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(6)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(7)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(8)));
// assert it.hasNext();
// azzert.that(it.next(), is(box.it(9)));
// assert !it.hasNext();
// azzert.that(it.next(), is(box.it(9)));
// }
//
// @Test public void includes() {
// final Range r = range.from(5).to(20);
// assert !r.isToInfinite();
// assert !r.isToNInfinite();
// azzert.that(r.getTo(), is(20));
// azzert.that(r.getFrom(), is(5));
// assert r.includes(6);
// assert r.includes(19);
// assert !r.includes(20);
// assert !r.includes(25);
// assert !r.includes(2);
// }
// }
