package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @AfterClass public static void test_constrAndValueOf() {
    azzert.that(new Int(10).get(), is(10));
    azzert.that(unbox.it(box.it(9)), is(9));
  }

  @SuppressWarnings("null") @AfterClass public static void test_inner() {
    final Int i1 = new Int(10);
    final Integer inner = i1.inner(), inner2 = i1.inner();
    azzert.that(unbox.it(inner), is(10));
    azzert.that(unbox.it(inner2), is(10));
    assert inner.equals(inner2);
  }

  @AfterClass public static void test_stepAndGet() {
    final Int i = new Int(0);
    for (int x = 1; x <= 10; x++) {
      i.step();
      azzert.that(i.get(), is(x));
    }
  }

  @AfterClass public static void test_add() {
    final Int i = new Int(0);
    final int arr[] = { 1, 3, 6, 10, 15, 21, 28, 36, 45, 55 };
    for (int x = 1; x <= 10; x++) {
      i.add(x);
      azzert.that(i.get(), is(arr[x - 1]));
    }
    for (int x = 10; x >= 2; x--) {
      i.add(-x);
      azzert.that(i.get(), is(arr[x - 2]));
    }
  }

  @AfterClass public static void test_set() {
    final Int i = new Int(0);
    azzert.that(i.get(), is(0));
    for (int x = 1; x <= 10; x++) {
      i.set(x);
      azzert.that(i.get(), is(x));
    }
  }

  @AfterClass public static void test_toString() {
    final Int i = new Int(0);
    for (int x = 1; x <= 10; x++) {
      i.set(x);
      azzert.that(i + "", is(x + ""));
    }
  }

  @AfterClass public static void test_nextAndGet() {
    final Int i = new Int(0);
    for (int x = 1; x <= 10; x++)
      azzert.that(i.next(), is(x));
  }

  @AfterClass public static void test_add2() {
    final Int i = new Int(0);
    final int arr[] = { 1, 3, 6, 10, 15, 21, 28, 36, 45, 55 };
    for (int x = 1; x <= 10; x++) {
      i.add(new Int(x));
      azzert.that(i.get(), is(arr[x - 1]));
    }
    for (int x = 10; x >= 2; x--) {
      i.add(new Int(-x));
      azzert.that(i.get(), is(arr[x - 2]));
    }
  }

  @AfterClass public static void test_clear() {
    final Int i = new Int(10);
    azzert.that(i.get(), is(10));
    i.clear();
    azzert.that(i.get(), is(0));
    i.add(0);
    final int old = i.get();
    i.clear();
    azzert.that(i.get(), is(old));
  }

  @Test public void testValueOf() {
    final Int j = Int.valueOf(5);
    azzert.that(j.inner, is(5));
  }
}
