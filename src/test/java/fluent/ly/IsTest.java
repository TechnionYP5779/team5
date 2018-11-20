package fluent.ly;

import java.util.*;
import static fluent.ly.azzert.is;
import org.junit.*;

/** @since 2018-11-14
 * @author Nir Chachamovitz Tests for class is, checks several properties on a
 *         set of objects */
@SuppressWarnings("static-method") public class IsTest {
  @SuppressWarnings("null") @Test public void testIn() {
    final Integer a = null;
    azzert.that(true, is(is.in("", "")));
    azzert.that(true, is(is.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir")));
    azzert.that(false, is(is.in(box.it(1), a)));
    azzert.that(false, is(is.in(box.it(1), box.it(3), box.it(8), box.it(5))));
    azzert.that(false, is(is.in("")));
  }

  @Test public void testNot() {
    azzert.that(false, is(is.not.in("", "")));
    azzert.that(false, is(is.not.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir")));
    azzert.that(true, is(is.not.in(box.it(1), box.it(3), box.it(8), box.it(5))));
    azzert.that(true, is(is.not.in("")));
  }

  @Test public void testOut() {
    azzert.that(false, is(is.out("", "")));
    azzert.that(false, is(is.out("nir", "igor", "shaked", "shalev", "lior", "or", "nir")));
    azzert.that(true, is(is.out(box.it(1), box.it(3), box.it(8), box.it(5))));
    azzert.that(true, is(is.out("")));
  }

  // @Test public static void testIsInInt() {
  // int num = 4;
  // azzert.assertEquals(true, is.intIsIn(num, 1,2,3,4,5,6,7,8,9,10));
  // azzert.assertEquals(false, is.intIsIn(num, 1, 2, 3, 5, 6, 7, 8, 9, 10));
  // }
  @Test public void testIsEmptyNull() {
    final String s = null;
    final Object a[] = null;
    final Iterable<Object> it = null;
    final Collection<Object> coll = null;
    azzert.that(true, is(is.empty(s)));
    azzert.that(true, is(is.empty(a)));
    azzert.that(true, is(is.empty(it)));
    azzert.that(true, is(is.empty(coll)));
  }

  @Test public void testIsEmpty() {
    final String s = "";
    final Object a[] = {};
    final Iterable<Object> it = new ArrayList<>();
    final Collection<Object> coll = new ArrayList<>();
    azzert.that(true, is(is.empty(s)));
    azzert.that(true, is(is.empty(a)));
    azzert.that(true, is(is.empty(it)));
    azzert.that(true, is(is.empty(coll)));
  }

  @Test public void testIsNotEmpty() {
    final String s = "Hello World";
    final Integer a[] = { box.it(1), box.it(2), box.it(3), box.it(4) };
    final ArrayList<Integer> it = new ArrayList<>();
    it.add(box.it(1));
    azzert.that(false, is(is.empty(s)));
    azzert.that(false, is(is.empty(a)));
    azzert.that(false, is(is.empty(it)));
    azzert.that(false, is(is.empty((Iterable<Integer>) it)));
  }
}