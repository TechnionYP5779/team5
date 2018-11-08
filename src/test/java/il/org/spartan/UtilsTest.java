package il.org.spartan;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

public class UtilsTest {
  final static Integer i = null;

  @SuppressWarnings("static-method") @Test public void addTest() {
    final ArrayList<Integer> a = new ArrayList<>();
    a.add(Integer.valueOf(5));
    Utils.add(a, Integer.valueOf(5));
    azzert.that(a.size(), azzert.is(2));
    final ArrayList<Integer> b = new ArrayList<>();
    b.add(null);
    b.add(Integer.valueOf(5));
    Utils.add(a, b);
    azzert.that(a.size(), azzert.is(3));
    Utils.add(a, i);
    azzert.that(a.size(), azzert.is(3));
  }

  static Iterable<Integer> range(final int from, final int to) {
    return () -> new Iterator<Integer>() {
      int current = from;

      @Override public boolean hasNext() {
        return current < to;
      }

      @SuppressWarnings("boxing") @Override public Integer next() {
        return current++;
      }
    };
  }

  @SuppressWarnings("static-method") @Test public void addAllTest() {
    final ArrayList<Integer> a = new ArrayList<>();
    final ArrayList<Integer> b = new ArrayList<>();
    b.add(Integer.valueOf(5));
    azzert.that(a.size(), azzert.is(0));
    Utils.addAll(a, b);
    azzert.that(a.size(), azzert.is(1));
    Utils.addAll(a, Integer.valueOf(5));
    azzert.that(a.size(), azzert.is(2));
    Utils.addAll(a, i);
    azzert.that(a.size(), azzert.is(2));
    Utils.addAll(a, range(3, 5));
    azzert.that(a.size(), azzert.is(4));
  }

  @SuppressWarnings("static-method") @Test public void appendTest() {
    final Integer[] arr = new Integer[10];
    azzert.that(Utils.append(arr, Integer.valueOf(5))[10], azzert.is(5));
  }

  @SuppressWarnings("static-method") @Test public void applyTest() {
    // TO DO - test
  }

  @SuppressWarnings("static-method") @Test public void canBeNullTest() {
    azzert.that(Utils.canBeNull(Integer.valueOf(5)), azzert.is(5));
  }

  @SuppressWarnings("static-method") @Test public void cantBeNullTest() {
    azzert.that(Utils.cantBeNull(Integer.valueOf(5)), azzert.is(5));
  }

  @SuppressWarnings("static-method") @Test public void compareTest() {
  }
}
