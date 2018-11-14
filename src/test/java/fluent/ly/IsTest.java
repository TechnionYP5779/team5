package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class IsTest {
  @Test @SuppressWarnings("null") public void testIn() {
    final Integer a = null;
    azzert.assertEquals(true, is.in("", ""));
    azzert.assertEquals(true, is.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(false, is.in(box.it(1), a));
    azzert.assertEquals(false, is.in(box.it(1), box.it(3), box.it(8), box.it(5)));
    azzert.assertEquals(false, is.in(""));
  }

  @Test public void testNot() {
    azzert.assertEquals(false, is.not.in("", ""));
    azzert.assertEquals(false, is.not.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(true, is.not.in(box.it(1), box.it(3), box.it(8), box.it(5)));
    azzert.assertEquals(true, is.not.in(""));
  }

  @Test public void testOut() {
    azzert.assertEquals(false, is.out("", ""));
    azzert.assertEquals(false, is.out("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(true, is.out(box.it(1), box.it(3), box.it(8), box.it(5)));
    azzert.assertEquals(true, is.out(""));
  }

  @Test public void testIsInInt() {
    final int num = 4;
    azzert.assertEquals(true, is.intIsIn(num, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    azzert.assertEquals(false, is.intIsIn(num, 1, 2, 3, 5, 6, 7, 8, 9, 10));
  }

  @Test public void testIsEmptyNull() {
    final String s = null;
    final Object a[] = null;
    final Iterable<Object> it = null;
    final Collection<Object> coll = null;
    azzert.assertEquals(true, is.empty(s));
    azzert.assertEquals(true, is.empty(a));
    azzert.assertEquals(true, is.empty(it));
    azzert.assertEquals(true, is.empty(coll));
  }

  @Test public void testIsEmpty() {
    final String s = "";
    final Object a[] = {};
    final Iterable<Object> it = new ArrayList<>();
    final Collection<Object> coll = new ArrayList<>();
    azzert.assertEquals(true, is.empty(s));
    azzert.assertEquals(true, is.empty(a));
    azzert.assertEquals(true, is.empty(it));
    azzert.assertEquals(true, is.empty(coll));
  }

  @Test public void testIsNotEmpty() {
    final String s = "Hello World";
    final Integer a[] = { box.it(1), box.it(2), box.it(3), box.it(4) };
    final ArrayList<Integer> it = new ArrayList<>();
    it.add(box.it(1));
    azzert.assertEquals(false, is.empty(s));
    azzert.assertEquals(false, is.empty(a));
    azzert.assertEquals(false, is.empty(it));
    azzert.assertEquals(false, is.empty((Iterable<Integer>) it));
  }
}
