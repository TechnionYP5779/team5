/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

/** @author Nir Chachamovitz */
@SuppressWarnings({ "static-method", "null" }) public class SeparatorTest {
  @Test public void constructorTest() {
    Separator s = new Separator(",");
    final Separator s2 = new Separator(',');
    azzert.that(s + "", azzert.is(""));
    azzert.that(s + "", azzert.is(","));
    s = s2;
  }

  @Test public void seperateBy1Test() {
    final int[] arr = { 1, 2, 3, 4, 5 };
    final String s = new String(", ");
    final String after_sep = Separator.separateBy(arr, s);
    azzert.that(after_sep, azzert.is("1, 2, 3, 4, 5"));
    final int[] arr2 = {};
    final String null_after_sep = Separator.separateBy(arr2, s);
    azzert.that(null_after_sep, azzert.is(""));
  }

  @Test public void seperateBy2Test() {
    final Integer[] arr = { new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5) };
    final String s = new String("@ ");
    final String after_sep = Separator.separateBy(s, arr);
    azzert.that(after_sep, azzert.is("1@ 2@ 3@ 4@ 5"));
    final Integer[] arr2 = {};
    final String null_after_sep = Separator.separateBy(s, arr2);
    azzert.that(null_after_sep, azzert.is(""));
  }

  @Test public void seperateBy3Test() {
    final ArrayList<Integer> ts = new ArrayList<>();
    ts.add(new Integer(1));
    ts.add(new Integer(2));
    ts.add(new Integer(3));
    ts.add(new Integer(4));
    ts.add(new Integer(5));
    final String wrap = new String("\nHere it goes and ends!\n");
    final String between = new String(", ");
    final String after_sep = Separator.wrap(wrap, ts, between);
    azzert.that(after_sep, azzert.is("\nHere it goes and ends!\n1, 2, 3, 4, 5\nHere it goes and ends!\n"));
    final ArrayList<Integer> empty_ts = new ArrayList<>();
    final String null_after_sep = Separator.wrap(wrap, empty_ts, between);
    azzert.that(null_after_sep, azzert.is(""));
  }
}
