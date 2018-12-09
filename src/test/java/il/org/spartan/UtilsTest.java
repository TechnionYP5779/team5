package il.org.spartan;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.FoundHandleForT.*;

@SuppressWarnings("static-method")
public class UtilsTest {
	static final Integer i = null;

	@Test
	public void addTest() {
		final ArrayList<Integer> a = new ArrayList<>();
		a.add(box.it(5));
		Utils.add(a, box.it(5));
		azzert.that(a.size(), is(2));
		final ArrayList<Integer> b = new ArrayList<>();
		b.add(null);
		b.add(box.it(5));
		Utils.add(a, b);
		azzert.that(a.size(), is(3));
		Utils.add(a, i);
		azzert.that(a.size(), is(3));
	}

	static Iterable<Integer> range(final int from, final int to) {
		return () -> new Iterator<Integer>() {
			int current = from;

			@Override
			public boolean hasNext() {
				return current < to;
			}

			@Override
			public Integer next() {
				return box.it(current++);
			}
		};
	}

	@Test
	public void addAllTest() {
		final ArrayList<Integer> a = new ArrayList<>();
		final ArrayList<Integer> b = new ArrayList<>();
		b.add(box.it(5));
		azzert.that(a.size(), is(0));
		Utils.addAll(a, b);
		azzert.that(a.size(), is(1));
		Utils.addAll(a, box.it(5));
		azzert.that(a.size(), is(2));
		Utils.addAll(a, i);
		azzert.that(a.size(), is(2));
		Utils.addAll(a, range(3, 5));
		azzert.that(a.size(), is(4));
	}

	@Test
	public void appendTest() {
		final int[] arr = new int[10];
		azzert.that(Utils.append(box.it(arr), box.it(5))[10], is(5));
	}

	@Test
	public void canBeNullTest() {
		azzert.that(canBeNull(box.it(5)), is(5));
	}

	@Test
	public void cantBeNullTest() {
		azzert.that(cantBeNull(box.it(5)), is(5));
	}

	@Test
	public void compareTest() {
		azzert.that(Utils.compare(false, false), is(0));
		azzert.that(Utils.compare(false, true), is(-1));
		azzert.that(Utils.compare(true, true), is(0));
		azzert.that(Utils.compare(true, false), is(1));
	}

	@Test
	public void compressSpacesTest() {
		azzert.that(Utils.compressSpaces("Lior Has A  Lot Courses"), is("Lior Has A Lot Courses"));
	}

	@Test
	public void containsTest() {
		assert Utils.contains("Lior Has A Lot Courses", "Courses");
		assert !Utils.contains("Lior Has A Lot Courses", "Dourses");
		assert !Utils.contains("Lior Has A Lot Courses", (String) null);
	}

	@Test
	public void deleteTest() {
		Integer[] Arr = new Integer[3];
		Arr[0] = box.it(0);
		Arr[1] = box.it(1);
		Arr[2] = box.it(2);
		azzert.that(Arr[1], is(1));
		Arr = Utils.delete(Arr, 1);
		azzert.that(Arr[1], is(2));
	}

	@Test
	public void hasNullTest() {
		Integer x = box.it(5);
		assert !Utils.hasNull(x);
		x = null;
		assert Utils.hasNull(x);
	}

	@Test
	public void foundTest() {
		final FoundHandleForInt f = Utils.found(5);
		azzert.that(f.candidate, is(5));
		assert f.in(5);
		assert !f.in(7);
		final FoundHandleForT<Integer> g = Utils.found(box.it(6));
		azzert.that(g.candidate, is(6));
		assert g.in(box.it(6));
		assert !g.in(box.it(7));
		assert !g.in(i);
	}

	@Test
	public void inRangeTest() {
		final ArrayList<Integer> a = new ArrayList<>();
		a.add(box.it(2));
		a.add(box.it(2));
		assert Utils.inRange(0, a);
		assert Utils.inRange(1, a);
		assert !Utils.inRange(2, a);
		assert !Utils.inRange(3, a);
		assert !Utils.inRange(-1, a);
	}

	@Test
	public void lastTest() {
		final ArrayList<Integer> a = new ArrayList<>();
		final Integer x2 = box.it(2);
		final Integer x3 = box.it(3);
		a.add(x2);
		a.add(x3);
		assert Utils.lastIn(x3, a);
		assert !Utils.lastIn(x2, a);
	}

	@Test
	public void intIsInTest() {
		final int[] a = new int[3];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		assert Utils.intIsIn(2, a);
		assert !Utils.intIsIn(3, a);
	}

	@Test
	public void mustBeNullTest() {
		azzert.that(Utils.mustBeNull(null), is((Void) null));
	}

	/**
	 * A static nested class hosting 12 unit tests for the nesting class Unit test
	 * for the containing class. Note the naming convention: a) names of test
	 * methods do not use are not prefixed by "test". This prefix is redundant. b)
	 * test methods begin with the name of the method they check.
	 * 
	 * @author Yossi Gil
	 * @since 2014-05-31
	 */

	@SuppressWarnings("null")
	@NotNull
	public Integer[] intToIntegers(final int... is) {
		final Integer @NotNull [] $ = new Integer @NotNull [is.length];
		for (int ¢ = 0; ¢ < is.length; ++¢)
			$[¢] = fluent.ly.box.it(is[¢]);
		return $;
	}

	@Test
	@SuppressWarnings({ "unchecked", "null" })
	public void addAllTypicalTest() {
		final Set<String> ss = new HashSet<>();
		accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
		azzert.nay(ss.contains("E"));
		azzert.nay(ss.contains(null));
		azzert.that(ss.size(), is(4));
		for (final @NotNull String ¢ : ss)
			azzert.aye("", ss.contains(¢));
	}

	@SuppressWarnings("null")
	@Test
	public void addTypicalTest() {
		final Set<String> ss = new HashSet<>();
		accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
		azzert.nay(ss.contains("E"));
		azzert.nay(ss.contains(null));
		azzert.that(ss.size(), is(4));
		for (final @NotNull String ¢ : ss)
			azzert.aye("", ss.contains(¢));
		azzert.aye(ss.contains("A"));
	}

	@Test
	public void cantBeNullOfNullTest() {
		try {
			cantBeNull(null);
			azzert.fail("AssertionError expected prior to this line.");
		} catch (final AssertionError ¢) {
			forget.it(¢);
			azzert.aye("", true);
		}
	}

	@Test
	public void cantBeNullTypicalTest() {
		assert cantBeNull(new Object()) != null;
	}

	@Test
	public void isNullTypicalTest() {
		try {
			isNull(mustBeNull(null));
			azzert.fail("AssertionError expected prior to this line.");
		} catch (final AssertionError ¢) {
			forget.it(¢);
			azzert.aye("", true);
		}
	}

	@Test
	public void mustBeNullOfNotNullTest() {
		try {
			mustBeNull(new Object());
			azzert.fail("AssertionError expected prior to this line.");
		} catch (final AssertionError ¢) {
			forget.it(¢);
			azzert.aye("", true);
		}
	}

	@Test
	public void quoteEmptyStringTest() {
		azzert.that(string.quote(""), is("''"));
	}

	@Test
	public void quoteNullTest() {
		azzert.that(string.quote(null), is("<null reference>"));
	}

	@Test
	public void quoteSimpleStringTest() {
		azzert.that(string.quote("A"), is("'A'"));
	}

	@Test
	public void swapDegenerateTest() {
		@SuppressWarnings("null")
		final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
		swap(ss, 1, 1);
		assertArrayEquals(as.array("A", "B", "C", "D"), ss);
	}

	@Test
	public void swapTypicalTest() {
		@SuppressWarnings("null")
		final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
		swap(ss, 1, 2);
		assertArrayEquals(as.array("A", "C", "B", "D"), ss);
	}

	@Test
	public void swapTypicalCaseTest() {
		@SuppressWarnings("null")
		final Integer @NotNull [] $ = intToIntegers(29, 1, 60);
		swap($, 0, 1);
		assertArrayEquals(intToIntegers(1, 29, 60), $);
	}

	@Test
	public void nameTest() {
		azzert.that(Utils.name(new File("File1")), is("File1"));
	}

	@Test
	public void penultimateInTest() {
		final ArrayList<Integer> a = new ArrayList<>();
		final Integer x2 = box.it(2);
		final Integer x3 = box.it(3);
		a.add(x2);
		a.add(x3);
		assert Utils.penultimateIn(x2, a);
		assert !Utils.penultimateIn(x3, a);
	}

	@Test
	public void prependTest() {
		StringBuilder s = Utils.prepend(new StringBuilder(), 'c');
		azzert.that(s.charAt(0), is('c'));
		s = Utils.prepend(s, "str");
		azzert.that(s.charAt(0), is('s'));
	}

	@Test
	public void removeTests() {
		final ArrayList<Integer> a = new ArrayList<>();
		final Integer x2 = box.it(2);
		final Integer x3 = box.it(2);
		a.add(x2);
		a.add(x3);
		Utils.removeDuplicates(a);
		azzert.that(a.size(), is(1));
		azzert.that(Utils.removePrefix("LiorL", "L"), is("iorL"));
		azzert.that(Utils.removeSuffix("LiorL", "L"), is("Lior"));
		azzert.that(Utils.removeWhites("Lior Ben Yamin"), is("LiorBenYamin"));
	}

	@Test
	public void sortTest() {
		final int[] arr = Utils.sort(new int[] { 3, 2, 4, 1, 5 });
		azzert.that(arr[0], is(1));
		azzert.that(arr[1], is(2));
		azzert.that(arr[2], is(3));
		azzert.that(arr[3], is(4));
		azzert.that(arr[4], is(5));
	}

	@Test
	public void sqrTest() {
		azzert.that(Utils.sqr(4.0), is(16.0));
	}

	@Test
	public void suffixedByTest() {
		final File f = new File("file1");
		final File g = new File("file2");
		final ArrayList<String> slist = new ArrayList<>();
		slist.add("suf1");
		slist.add("e1");
		assert Utils.suffixedBy(f, slist);
		assert !Utils.suffixedBy(g, slist);
		assert Utils.suffixedBy(g, "e2");
		assert !Utils.suffixedBy("file1", "e2");
	}
}
