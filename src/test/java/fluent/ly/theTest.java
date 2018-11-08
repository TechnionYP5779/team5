package fluent.ly;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class theTest {
  @Test public void indexTest() {
    azzert.that(2, azzert.is(the.index(5, 1, 2, 5, 3, 4)));
  }

  @Test public void noExistingIndex() {
    azzert.that(-1, azzert.is(the.index(3, 1, 2, 4, 5, 6)));
  }

  @Test public void nilTest() {
    Assert.assertEquals(null, the.nil());
  }

  @Test public void nthTest() {
    final Collection c = IntStream.range(0, 5).boxed().collect(Collectors.toList());
    azzert.that(" #3/5", azzert.is(the.nth(3, c)));
  }

  @Test public void PentuliatenullTest() {
    Assert.assertEquals(null, the.penultimateOf(null));
  }

  @Test public void penuliateofOneTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    azzert.that(null, azzert.is(the.penultimateOf(l)));
  }

  @Test public void penuliateTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    l.add(1);
    l.add(2);
    l.add(3);
    azzert.that(Integer.valueOf(2), azzert.is(the.penultimateOf(l)));
  }

  @Test public void nullPrevoiusOf() {
    azzert.that(null, azzert.is(the.previous(3, null)));
  }

  @Test public void PrevoiusofOneElement() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    azzert.that(null, azzert.is(the.previous(0, l)));
  }

  @Test public void prevoiuseTest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    l.add(1);
    l.add(2);
    l.add(3);
    azzert.that(Integer.valueOf(1), azzert.is(the.previous(2, l)));
  }

  @Test public void tailOfTest() {
    azzert.that(IntStream.range(1, 5).boxed().collect(Collectors.toList()),
        azzert.is(the.tailOf(IntStream.range(0, 5).boxed().collect(Collectors.toList()))));
  }

  @Test public void tailOfString() {
    azzert.that("hello world", azzert.is(the.tailOf("hhello world")));
  }

  @Test public void rest() {
    final ArrayList<Integer> l = new ArrayList<>();
    l.add(4);
    l.add(5);
    azzert.that(l, azzert.is(the.rest(3, IntStream.range(0, 6).boxed().collect(Collectors.toList()))));
  }

  @Test public void headOfNull() {
    Assert.assertEquals(null, the.headOf(null));
  }

  @Test public void headOfEmpty() {
    azzert.that(null, azzert.is(the.headOf(new ArrayList())));
  }

  @Test public void headOf() {
    azzert.that(Integer.valueOf(0), azzert.is(the.headOf(IntStream.range(0, 6).boxed().collect(Collectors.toList()))));
  }

  @Test public void characterOf() {
    azzert.that('o', azzert.is(the.characterOf("hello")));
  }

  @Test public void ith() {
    azzert.that('e', azzert.is(the.ith("hello world", 1)));
  }

  @Test public void lastOfNull() {
    final ArrayList<Integer> l = null;
    azzert.that(null, azzert.is(the.lastOf(l)));
  }

  @Test public void lastOfEpty() {
    azzert.that(null, azzert.is(the.lastOf(new ArrayList())));
  }

  @Test public void lastOf() {
    final ArrayList l = new ArrayList();
    l.add(1);
    azzert.that(Integer.valueOf(1), azzert.is(the.lastOf(l)));
  }

  @Test public void lastofString() {
    azzert.that('d', azzert.is(the.lastOf("hello world")));
  }

  @Test public void beforeLastOfString() {
    azzert.that('w', azzert.is(the.beforeLastOf("hello world", 4)));
  }

  @Test public void lastOfIterable() {
    final ArrayList l = (ArrayList) IntStream.range(0, 5).boxed().collect(Collectors.toList());
    final Iterable i = the.lastOf((Iterable) l);
    final Iterator it = i.iterator();
    azzert.that(Integer.valueOf(1), azzert.is(it.next()));
    azzert.that(Integer.valueOf(2), azzert.is(it.next()));
    azzert.that(Integer.valueOf(3), azzert.is(it.next()));
    azzert.that(Integer.valueOf(4), azzert.is(it.next()));
    azzert.that(false, azzert.is(it.hasNext()));
  }

  @Test public void onlyOneOfNull() {
    Assert.assertEquals(null, the.onlyOneOf(null));
  }

  @Test public void onlyOneOfEmpty() {
    azzert.that(null, azzert.is(the.onlyOneOf(new ArrayList())));
  }

  @Test public void onlyOneOf() {
    final ArrayList l = new ArrayList();
    l.add(0);
    azzert.that(Integer.valueOf(0), azzert.is(the.onlyOneOf(l)));
  }

  @Test public void secondOfNull() {
    Assert.assertEquals(null, the.secondOf(null));
  }

  @Test public void secondOfEmpty() {
    azzert.that(null, azzert.is(the.secondOf(new ArrayList())));
  }

  @Test public void secondOf() {
    final ArrayList l = new ArrayList();
    l.add(0);
    l.add(1);
    azzert.that(Integer.valueOf(1), azzert.is(the.secondOf(l)));
  }

  @Test public void max() {
    azzert.that(10, azzert.is(the.max(1, 1, 2, 10, 3, 4)));
  }

  @Test public void min() {
    azzert.that(0, azzert.is(the.min(1, 1, 2, 0, 3, 4)));
  }

  @Test public void lastOfArray() {
    final Integer[] arr = new Integer[] { 1, 2, 3, 4, 5 };
    azzert.that(Integer.valueOf(5), azzert.is(the.lastOf(arr)));
  }

  @Test public void lastNull() {
    Assert.assertEquals(null, the.last(null));
  }

  @Test public void lastEmpty() {
    azzert.that(null, azzert.is(the.last(new ArrayList())));
  }

  @Test public void last() {
    final ArrayList l = new ArrayList();
    l.add(0);
    azzert.that(Integer.valueOf(0), azzert.is(the.last(l)));
  }

  @Test public void sqr() {
    azzert.that(25, azzert.is(the.sqr(5)));
  }

  @Test public void restString() {
    azzert.that("hello world", azzert.is(the.rest("hhello world")));
  }

  @Test public void tailOfArray() {
    final Integer[] arr = new Integer[] { 1, 2, 3, 4, 5 };
    final Integer[] arr2 = new Integer[] { 2, 3, 4, 5 };
    azzert.that(arr2, azzert.is(the.tailOf(arr)));
  }
}
