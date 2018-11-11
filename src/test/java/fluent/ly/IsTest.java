package fluent.ly;

import java.util.*;

import org.junit.*;

public class IsTest {
  @Test @SuppressWarnings({ "static-method", "boxing", "null" }) public void testIn() {
    final Integer a = null;
    azzert.assertEquals(true, is.in("", ""));
    azzert.assertEquals(true, is.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(false, is.in((Integer) 1, a));
    azzert.assertEquals(false, is.in(1, 3, 8, 5));
    azzert.assertEquals(false, is.in(""));
  }

  @Test @SuppressWarnings({ "boxing", "static-method" }) public void testNot() {
    azzert.assertEquals(false, is.not.in("", ""));
    azzert.assertEquals(false, is.not.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(true, is.not.in(1, 3, 8, 5));
    azzert.assertEquals(true, is.not.in(""));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testOut() {
    azzert.assertEquals(false, is.out("", ""));
    azzert.assertEquals(false, is.out("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(true, is.out(1, 3, 8, 5));
    azzert.assertEquals(true, is.out(""));
  }

  @Test @SuppressWarnings("static-method") public void testIsInInt() {
    final int num = 4;
    azzert.assertEquals(true, is.intIsIn(num, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    azzert.assertEquals(false, is.intIsIn(num, 1, 2, 3, 5, 6, 7, 8, 9, 10));
  }

  @Test @SuppressWarnings("static-method") public void testIsEmptyNull() {
    final String s = null;
    final Object a[] = null;
    final Iterable<Object> it = null;
    final Collection<Object> coll = null;
    azzert.assertEquals(true, is.empty(s));
    azzert.assertEquals(true, is.empty(a));
    azzert.assertEquals(true, is.empty(it));
    azzert.assertEquals(true, is.empty(coll));
  }

  @Test @SuppressWarnings("static-method") public void testIsEmpty() {
    final String s = "";
    final Object a[] = {};
    final Iterable<Object> it = new ArrayList<>();
    final Collection<Object> coll = new ArrayList<>();
    azzert.assertEquals(true, is.empty(s));
    azzert.assertEquals(true, is.empty(a));
    azzert.assertEquals(true, is.empty(it));
    azzert.assertEquals(true, is.empty(coll));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testIsNotEmpty() {
    final String s = "Hello World";
    final Integer a[] = { 1, 2, 3, 4 };
    final ArrayList<Integer> it = new ArrayList<>();
    it.add(1);
    azzert.assertEquals(false, is.empty(s));
    azzert.assertEquals(false, is.empty(a));
    azzert.assertEquals(false, is.empty(it));
    azzert.assertEquals(false, is.empty((Iterable<Integer>) it));
  }
}
