package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class theTest {
  @Test @SuppressWarnings("static-method") public void indexTest() {
    azzert.that(2, is(the.index(5, 1, 2, 5, 3, 4)));
  }

  @Test @SuppressWarnings("static-method") public void noExistingIndex() {
    azzert.that(-1, is(the.index(3, 1, 2, 4, 5, 6)));
  }

  @Test @SuppressWarnings("static-method") public void nilTest() {
    assert the.nil() == null;
  }

  @Test @SuppressWarnings("static-method") public void nthTest() {
    azzert.that(" #3/5", is(the.nth(3, IntStream.range(0, 5).boxed().collect(Collectors.toList()))));
  }

  @Test @SuppressWarnings("static-method") public void PentuliatenullTest() {
    assert the.penultimateOf(null) == null;
  }

  @Test @SuppressWarnings({ "boxing", "static-method", "null" }) public void penuliateofOneTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    azzert.that(null, is(the.penultimateOf(l)));
  }

  @Test @SuppressWarnings({ "boxing", "static-method", "null" }) public void penuliateTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    l.add(1);
    l.add(2);
    l.add(3);
    azzert.that(Integer.valueOf(2), is(the.penultimateOf(l)));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void nullPrevoiusOf() {
    azzert.that(null, is(the.previous(3, null)));
  }

  @Test @SuppressWarnings({ "static-method", "boxing", "null" }) public void PrevoiusofOneElement() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    azzert.that(null, is(the.previous(0, l)));
  }

  @Test @SuppressWarnings({ "boxing", "static-method", "null" }) public void prevoiuseTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    l.add(1);
    l.add(2);
    l.add(3);
    azzert.that(Integer.valueOf(1), is(the.previous(2, l)));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void tailOfTest() {
    azzert.that(IntStream.range(1, 5).boxed().collect(Collectors.toList()),
        is(the.tailOf(IntStream.range(0, 5).boxed().collect(Collectors.toList()))));
  }

  @Test @SuppressWarnings("static-method") public void tailOfString() {
    azzert.that("hello world", is(the.tailOf("hhello world")));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void rest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(4);
    l.add(5);
    azzert.that(l, is(the.rest(3, IntStream.range(0, 6).boxed().collect(Collectors.toList()))));
  }

  @Test @SuppressWarnings("static-method") public void headOfNull() {
    assert the.headOf(null) == null;
  }

  @Test @SuppressWarnings({ "static-method", "unchecked", "rawtypes" }) public void headOfEmpty() {
    azzert.that(null, is(the.headOf(new ArrayList())));
  }

  @Test @SuppressWarnings({ "null", "static-method" }) public void headOf() {
    azzert.that(Integer.valueOf(0), is(the.headOf(IntStream.range(0, 6).boxed().collect(Collectors.toList()))));
  }

  @Test @SuppressWarnings("static-method") public void characterOf() {
    azzert.that('o', is(the.characterOf("hello")));
  }

  @Test @SuppressWarnings("static-method") public void ith() {
    azzert.that('e', is(the.ith("hello world", 1)));
  }

  @Test @SuppressWarnings("static-method") public void lastOfNull() {
    azzert.that(null, is(the.lastOf((ArrayList<Integer>) null)));
  }

  @Test @SuppressWarnings({ "static-method", "unchecked", "rawtypes", "null" }) public void lastOfEpty() {
    azzert.that(null, is(the.lastOf(new ArrayList())));
  }

  @Test @SuppressWarnings({ "unchecked", "boxing", "static-method", "rawtypes", "null" }) public void lastOf() {
    final ArrayList l = new ArrayList();
    l.add(1);
    azzert.that(Integer.valueOf(1), is(the.lastOf(l)));
  }

  @Test @SuppressWarnings("static-method") public void lastofString() {
    azzert.that('d', is(the.lastOf("hello world")));
  }

  @Test @SuppressWarnings("static-method") public void beforeLastOfString() {
    azzert.that('w', is(the.beforeLastOf("hello world", 4)));
  }

  @Test @SuppressWarnings({ "unchecked", "rawtypes", "null", "static-method" }) public void lastOfIterable() {
    final Iterator it = the.lastOf((Iterable) (ArrayList) IntStream.range(0, 5).boxed().collect(Collectors.toList())).iterator();
    azzert.that(Integer.valueOf(1), is(it.next()));
    azzert.that(Integer.valueOf(2), is(it.next()));
    azzert.that(Integer.valueOf(3), is(it.next()));
    azzert.that(Integer.valueOf(4), is(it.next()));
    azzert.that(false, is(it.hasNext()));
  }

  @Test @SuppressWarnings("static-method") public void onlyOneOfNull() {
    assert the.onlyOneOf(null) == null;
  }

  @Test @SuppressWarnings({ "static-method", "unchecked", "rawtypes" }) public void onlyOneOfEmpty() {
    azzert.that(null, is(the.onlyOneOf(new ArrayList())));
  }

  @Test @SuppressWarnings({ "static-method", "rawtypes", "unchecked", "boxing" }) public void onlyOneOf() {
    final ArrayList l = new ArrayList();
    l.add(0);
    azzert.that(Integer.valueOf(0), is(the.onlyOneOf(l)));
  }

  @Test @SuppressWarnings("static-method") public void secondOfNull() {
    assert the.secondOf(null) == null;
  }

  @Test @SuppressWarnings({ "static-method", "unchecked", "rawtypes" }) public void secondOfEmpty() {
    azzert.that(null, is(the.secondOf(new ArrayList())));
  }

  @Test @SuppressWarnings({ "static-method", "rawtypes", "unchecked", "boxing" }) public void secondOf() {
    final ArrayList l = new ArrayList();
    l.add(0);
    l.add(1);
    azzert.that(Integer.valueOf(1), is(the.secondOf(l)));
  }

  @Test @SuppressWarnings("static-method") public void max() {
    azzert.that(10, is(the.max(1, 1, 2, 10, 3, 4)));
  }

  @Test @SuppressWarnings("static-method") public void min() {
    azzert.that(0, is(the.min(1, 1, 2, 0, 3, 4)));
  }

  @Test @SuppressWarnings({ "static-method", "boxing", "null" }) public void lastOfArray() {
    azzert.that(Integer.valueOf(5), is(the.lastOf(new Integer[] { 1, 2, 3, 4, 5 })));
  }

  @Test @SuppressWarnings("static-method") public void lastNull() {
    assert the.last(null) == null;
  }

  @Test @SuppressWarnings({ "static-method", "unchecked", "rawtypes" }) public void lastEmpty() {
    azzert.that(null, is(the.last(new ArrayList())));
  }

  @Test @SuppressWarnings({ "static-method", "rawtypes", "unchecked", "boxing" }) public void last() {
    final ArrayList l = new ArrayList();
    l.add(0);
    azzert.that(Integer.valueOf(0), is(the.last(l)));
  }

  @Test @SuppressWarnings("static-method") public void sqr() {
    azzert.that(25, is(the.sqr(5)));
  }

  @Test @SuppressWarnings("static-method") public void restString() {
    azzert.that("hello world", is(the.rest("hhello world")));
  }

  @Test @SuppressWarnings({ "boxing", "static-method" }) public void tailOfArray() {
    azzert.that(new Integer[] { 2, 3, 4, 5 }, is(the.tailOf(new Integer[] { 1, 2, 3, 4, 5 })));
  }
}
