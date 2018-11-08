package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class IsTest {
  @Test public void testIn() {
    final Integer a = null;
    assertEquals(true, is.in("", ""));
    assertEquals(true, is.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    assertEquals(false, is.in((Integer) 1, a));
    assertEquals(false, is.in(1, 3, 8, 5));
    assertEquals(false, is.in(""));
  }

  @Test public void testNot() {
    assertEquals(false, is.not.in("", ""));
    assertEquals(false, is.not.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    assertEquals(true, is.not.in(1, 3, 8, 5));
    assertEquals(true, is.not.in(""));
  }

  @Test public void testOut() {
    assertEquals(false, is.out("", ""));
    assertEquals(false, is.out("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    assertEquals(true, is.out(1, 3, 8, 5));
    assertEquals(true, is.out(""));
  }

  @Test public void testIsInInt() {
    final int num = 4;
    assertEquals(true, is.intIsIn(num, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    assertEquals(false, is.intIsIn(num, 1, 2, 3, 5, 6, 7, 8, 9, 10));
  }

  @Test public void testIsEmptyNull() {
    final String s = null;
    final Object a[] = null;
    final Iterable<Object> it = null;
    final Collection<Object> coll = null;
    assertEquals(true, is.empty(s));
    assertEquals(true, is.empty(a));
    assertEquals(true, is.empty(it));
    assertEquals(true, is.empty(coll));
  }

  @Test public void testIsEmpty() {
    final String s = "";
    final Object a[] = {};
    final Iterable<Object> it = new ArrayList<>();
    final Collection<Object> coll = new ArrayList<>();
    assertEquals(true, is.empty(s));
    assertEquals(true, is.empty(a));
    assertEquals(true, is.empty(it));
    assertEquals(true, is.empty(coll));
  }

  @Test public void testIsNotEmpty() {
    final String s = "Hello World";
    final Integer a[] = { 1, 2, 3, 4 };
    final ArrayList<Integer> it = new ArrayList<>();
    it.add(1);
    assertEquals(false, is.empty(s));
    assertEquals(false, is.empty(a));
    assertEquals(false, is.empty(it));
    assertEquals(false, is.empty((Iterable<Integer>) it));
  }
}
