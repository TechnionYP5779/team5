package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings(lispTest.STATIC_METHOD)
public class lispTest {
	static final String STATIC_METHOD = "static-method";

	@Test
	public void chop1() {
		final List<Integer> l = new ArrayList<>();
		azzert.that(null, is(lisp.chop(l)));
	}

	@Test
	public void chop2() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		l1.add(box.it(1));
		for (int ¢ = 2; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢));
		}
		azzert.that(lisp.chop(l1), is(l2));
	}

	@Test
	public void cons() {
		final ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(box.it(0), box.it(1))),
				l2 = new ArrayList<>(Arrays.asList(box.it(1)));
		assert l2 != null;
		for (int ¢ = 2; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢));
		}
		azzert.that(lisp.cons(box.it(0), l2), is(l1));
	}

	@Test
	public void next1() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(lisp.next(0, l1), is(box.it(2)));
	}

	@Test
	public void next2() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(lisp.next(11, l1), is(10));
	}

	@Test
	public void get1() {
		assert lisp.get(null, 0) == null;
	}

	/** warning! not protected against out-of-bound index **/
	@Test
	public void get2() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(lisp.get(l1, 2), is(4));
	}

	@Test
	public void prev1() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(lisp.prev(2, l1), is(2));
	}

	@Test
	public void prev2() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(lisp.prev(0, l1), is(1));
		azzert.that(lisp.prev(-7, l1), is(1));
	}

	@Test
	public void replace1() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(null, is(lisp.replace(null, box.it(1), 2)));
	}

	@Test
	public void replace2() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(l1, is(lisp.replace(l1, box.it(1), -1)));
		azzert.that(l1, is(lisp.replace(l1, box.it(1), 20)));
	}

	@Test
	public void replace3() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢ == 4 ? 7 : ¢));
		}
		azzert.that(l2, is(lisp.replace(l1, box.it(7), 3)));
	}

	@Test
	public void replaceFirst() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢ == 1 ? 7 : ¢));
		}
		azzert.that(l2, is(lisp.replaceFirst(l1, box.it(7))));
	}

	@Test
	public void replaceLast() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢ == 10 ? 7 : ¢));
		}
		azzert.that(l2, is(lisp.replaceLast(l1, box.it(7))));
	}

	@Test
	public void rest2() {
		final ArrayList<Integer> l1 = new ArrayList<>();
		for (int ¢ = 1; ¢ <= 10; ¢++)
			l1.add(box.it(¢));
		azzert.that(box.it(3), is(lisp.rest2(l1).iterator().next()));
	}

	@Test
	public void areEqual() {
		assert lisp.areEqual(box.it(4), box.it(4), box.it(4), box.it(4), box.it(4));
		assert !lisp.areEqual(box.it(4), null, box.it(4), box.it(4), box.it(4), box.it(4));
	}

	@Test
	public void chopLast1() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 2; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢));
		}
		l1.add(box.it(10));
		azzert.that(lisp.chopLast(l1), is(l2));
	}

	@Test
	public void chopLast2() {
		azzert.that(lisp.chopLast("ddddd"), is("dddd"));
		azzert.that(lisp.chopLast("d"), is(""));
	}

	@Test
	public void removeFromList() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 2; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢));
		}
		lisp.removeFromList(l1, l2);
		azzert.that(new ArrayList<Integer>(), is(l2));
	}

	@Test
	public void removeLast() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 2; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢));
		}
		l1.add(box.it(11));
		lisp.removeLast(l1);
		azzert.that(l1, is(l2));
	}

	@Test
	public void swap1() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 2; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢));
		}
		azzert.that(l1, is(lisp.swap(l1, 10, 3)));
		azzert.that(l1, is(lisp.swap(l1, 3, 10)));
		azzert.that(l1, is(lisp.swap(l1, 10, 10)));
	}

	@Test
	public void swap2() {
		final ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int ¢ = 2; ¢ <= 10; ¢++) {
			l1.add(box.it(¢));
			l2.add(box.it(¢ == 3 ? 7 : ¢ == 7 ? 3 : ¢));
		}
		azzert.that(l1, is(lisp.swap(l2, 1, 5)));
	}
}
