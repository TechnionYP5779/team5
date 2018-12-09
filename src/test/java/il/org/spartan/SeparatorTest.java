/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

/** @author Nir Chachamovitz */
@SuppressWarnings({ "static-method", "null" })
public class SeparatorTest {
	@Test
	public void constructorTest() {
		Separator s = new Separator(",");
		final Separator s2 = new Separator(',');
		azzert.that(s + "", is(""));
		azzert.that(s + "", is(","));
		s = s2;
	}

	@Test
	public void seperateBy1Test() {
		final int[] arr = { 1, 2, 3, 4, 5 };
		final String s = new String(", ");
		final String after_sep = Separator.separateBy(arr, s);
		azzert.that(after_sep, is("1, 2, 3, 4, 5"));
		final int[] arr2 = {};
		final String null_after_sep = Separator.separateBy(arr2, s);
		azzert.that(null_after_sep, is(""));
	}

	@Test
	public void seperateBy2Test() {
		final Integer[] arr = { box.it(1), box.it(2), box.it(3), box.it(4), box.it(5) };
		final String s = new String("@ ");
		final String after_sep = Separator.separateBy(s, arr);
		azzert.that(after_sep, is("1@ 2@ 3@ 4@ 5"));
		final Integer[] arr2 = {};
		final String null_after_sep = Separator.separateBy(s, arr2);
		azzert.that(null_after_sep, is(""));
	}

	@Test
	public void seperateBy3Test() {
		final ArrayList<Integer> ts = new ArrayList<>();
		ts.add(box.it(1));
		ts.add(box.it(2));
		ts.add(box.it(3));
		ts.add(box.it(4));
		ts.add(box.it(5));
		final String wrap = new String("\nHere it goes and ends!\n");
		final String between = new String(", ");
		final String after_sep = Separator.wrap(wrap, ts, between);
		azzert.that(after_sep, is("\nHere it goes and ends!\n1, 2, 3, 4, 5\nHere it goes and ends!\n"));
		final ArrayList<Integer> empty_ts = new ArrayList<>();
		final String null_after_sep = Separator.wrap(wrap, empty_ts, between);
		azzert.that(null_after_sep, is(""));
	}
}
