package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

@SuppressWarnings("static-method") public class theTest {
  @Test public void indexTest() {
    azzert.that(2, is(the.index(5, 1, 2, 5, 3, 4)));
  }

  @Test public void noExistingIndex() {
    azzert.that(-1, is(the.index(3, 1, 2, 4, 5, 6)));
  }

  @Test public void nilTest() {
    assert the.nil() == null;
  }

  @Test public void nthTest() {
    azzert.that(" #3/5", is(the.nth(3, IntStream.range(0, 5).boxed().collect(Collectors.toList()))));
  }

  @Test public void PentuliatenullTest() {
    assert the.penultimateOf(null) == null;
  }

  @Test @SuppressWarnings("null") public void penuliateofOneTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(0));
    azzert.that(null, is(the.penultimateOf(l)));
  }

  @Test public void penuliateTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(0));
    l.add(box.it(1));
    l.add(box.it(2));
    l.add(box.it(3));
    azzert.that(box.it(2), is(the.penultimateOf(l)));
  }

  @Test public void nullPrevoiusOf() {
    azzert.that(null, is(the.previous(box.it(3), null)));
  }

  @Test public void PrevoiusofOneElement() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(0));
    azzert.that(null, is(the.previous(box.it(0), l)));
  }

  @Test public void prevoiuseTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(0));
    l.add(box.it(1));
    l.add(box.it(2));
    l.add(box.it(3));
    azzert.that(box.it(1), is(the.previous(box.it(2), l)));
  }

  @Test @SuppressWarnings("null") public void tailOfTest() {
    azzert.that(IntStream.range(1, 5).boxed().collect(Collectors.toList()),
        is(the.tailOf(IntStream.range(0, 5).boxed().collect(Collectors.toList()))));
  }

  @Test public void tailOfString() {
    azzert.that("hello world", is(the.tailOf("hhello world")));
  }

  @Test public void rest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(4));
    l.add(box.it(5));
    azzert.that(l, is(the.rest(box.it(3), IntStream.range(0, 6).boxed().collect(Collectors.toList()))));
  }

  @Test public void headOfNull() {
    assert the.headOf(null) == null;
  }

  @SuppressWarnings("null") @Test  public void headOfEmpty() {
    azzert.that(null, is(the.headOf(new ArrayList<Integer>())));
  }

  @Test @SuppressWarnings("null") public void headOf() {
    azzert.that(box.it(0), is(the.headOf(IntStream.range(0, 6).boxed().collect(Collectors.toList()))));
  }

  @Test public void characterOf() {
    azzert.that('o', is(the.characterOf("hello")));
  }

  @Test public void ith() {
    azzert.that('e', is(the.ith("hello world", 1)));
  }

  @Test public void lastOfNull() {
    azzert.that(null, is(the.lastOf((ArrayList<Integer>) null)));
  }

  @SuppressWarnings("null") @Test public void lastOfEpty() {
    azzert.that(null, is(the.lastOf(new ArrayList<Integer>())));
  }

  @SuppressWarnings("null") @Test  public void lastOf() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(1));
    azzert.that(box.it(1), is(the.lastOf(l)));
  }

  @Test public void lastofString() {
    azzert.that('d', is(the.lastOf("hello world")));
  }

  @Test public void beforeLastOfString() {
    azzert.that('w', is(the.beforeLastOf("hello world", 4)));
  }

  @SuppressWarnings("null") @Test public void lastOfIterable() {
    final Iterator<?> it = the.lastOf((Iterable<?>) (ArrayList<?>) IntStream.range(0, 5).boxed().collect(Collectors.toList())).iterator();
    azzert.that(box.it(1), is(it.next()));
    azzert.that(box.it(2), is(it.next()));
    azzert.that(box.it(3), is(it.next()));
    azzert.that(box.it(4), is(it.next()));
    azzert.that(false, is(it.hasNext()));
  }

  @Test public void onlyOneOfNull() {
    assert the.onlyOneOf(null) == null;
  }

  @SuppressWarnings("null") @Test public void onlyOneOfEmpty() {
    azzert.that(null, is(the.onlyOneOf(new ArrayList<Integer>())));
  }

  @Test  public void onlyOneOf() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(0));
    azzert.that(box.it(0), is(the.onlyOneOf(l)));
  }

  @Test public void secondOfNull() {
    assert the.secondOf(null) == null;
  }

  @SuppressWarnings("null") @Test public void secondOfEmpty() {
    azzert.that(null, is(the.secondOf(new ArrayList<Integer>())));
  }

  @Test  public void secondOf() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(0));
    l.add(box.it(1));
    azzert.that(box.it(1), is(the.secondOf(l)));
  }

  @Test public void max() {
    azzert.that(10, is(the.max(1, 1, 2, 10, 3, 4)));
  }

  @Test public void min() {
    azzert.that(0, is(the.min(1, 1, 2, 0, 3, 4)));
  }

  @Test public void lastOfArray() {
    azzert.that(box.it(5), is(the.lastOf(new Integer[] { box.it(1), box.it(2), box.it(3), box.it(4), box.it(5) })));
  }

  @Test public void lastNull() {
    assert the.last(null) == null;
  }

  @SuppressWarnings("null") @Test  public void lastEmpty() {
    azzert.that(null, is(the.last(new ArrayList<Integer>())));
  }

  @Test  public void last() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(box.it(0));
    azzert.that(box.it(0), is(the.last(l)));
  }

  @Test public void sqr() {
    azzert.that(25, is(the.sqr(5)));
  }

  @Test public void restString() {
    azzert.that("hello world", is(the.rest("hhello world")));
  }

  @Test public void tailOfArray() {
    azzert.that(new Integer[] { box.it(2), box.it(3), box.it(4), box.it(5) },
        is(the.tailOf(new Integer[] { box.it(1), box.it(2), box.it(3), box.it(4), box.it(5) })));
  }
}
