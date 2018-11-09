package il.org.spartan.utils;

//import static org.junit.Assert.*;

import org.junit.*;

import fluent.ly.*;

public class IntTest {
  @Test public void test_constrAndValueOf() {
    final Int i = new Int(10);
    azzert.that(i.get(),azzert.is(10));
    final Int i2 = Int.valueOf(9);
    azzert.that(i2.get(), azzert.is(9));
  }

  @Test public void test_inner() {
    final Int i1 = new Int(10);
    final Integer inner = i1.inner(), inner2 = i1.inner();
    azzert.that(inner.intValue(),azzert.is(10));
    azzert.that(inner2.intValue(),azzert.is(10));
    azzert.that(inner.equals(inner2),azzert.is(true));
  }

  @Test public void test_stepAndGet() {
    final Int i = new Int(0);
    for (int x = 1; x <= 10; x++) {
      i.step();
      azzert.that(i.get(),azzert.is(x));
    }
  }

  @Test public void test_add() {
    final Int i = new Int(0);
    final int arr[] = { 1, 3, 6, 10, 15, 21, 28, 36, 45, 55 };
    for (int x = 1; x <= 10; x++) {
      i.add(x);
      azzert.that(i.get(),azzert.is(arr[x-1]));
    }
    for (int x = 10; x >= 2; x--) {
      i.add(-x);
      azzert.that(i.get(),azzert.is(arr[x-2]));
    }
  }

  @Test public void test_set() {
    final Int i = new Int(0);
    azzert.that(i.get(),azzert.is(0));
    for (int x = 1; x <= 10; x++) {
      i.set(x);
      azzert.that(i.get(),azzert.is(x));
    }
  }

  @Test public void test_toString() {
    final Int i = new Int(0);
    for (int x = 1; x <= 10; x++) {
      i.set(x);
      azzert.that(i.toString(),azzert.is(x+""));
      azzert.that(i.toString(),azzert.is(""+x));
      azzert.that(i.toString(),azzert.is(""+x+""));
    }
  }

  @Test public void test_nextAndGet() {
    final Int i = new Int(0);
    for (int x = 1; x <= 10; x++) {
      final int d = i.next();
      azzert.that(d,azzert.is(x));
    }
  }

  @Test public void test_add2() {
    final Int i = new Int(0);
    final int arr[] = { 1, 3, 6, 10, 15, 21, 28, 36, 45, 55 };
    for (int x = 1; x <= 10; x++) {
      final Int i2 = new Int(x);
      i.add(i2);
      azzert.that(i.get(),azzert.is(arr[x-1]));
    }
    for (int x = 10; x >= 2; x--) {
      final Int i2 = new Int(-x);
      i.add(i2);
      azzert.that(i.get(),azzert.is(arr[x-2]));
    }
  }

  @Test public void test_clear() {
    final Int i = new Int(10);
    azzert.that(i.get(),azzert.is(10));
    i.clear();
    azzert.that(i.get(),azzert.is(0));
    i.add(0);
    final int old = i.get();
    i.clear();
    azzert.that(i.get(),azzert.is(old));
  }
}
