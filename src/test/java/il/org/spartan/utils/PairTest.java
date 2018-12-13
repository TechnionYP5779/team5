package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
public class PairTest {
	@Test
	public void test_constrAndNewPair() {
		final Pair<Integer, Integer> p1 = new Pair<>(box.it(1), box.it(2));
		azzert.that(p1.first, is(box.it(1)));
		azzert.that(p1.second, is(box.it(2)));
		final Pair<Integer, Integer> p2 = Pair.newPair(box.it(3), box.it(4));
		azzert.that(p2.first, is(box.it(3)));
		azzert.that(p2.second, is(box.it(4)));
	}

	@Test
	public void test_makePairs() {
		final Pair<Integer, Integer> list1[] = Pair.makePairs(10), list2[] = Pair.makePairs(3, 5),
				list3[] = Pair.makePairs(3, 0);
		azzert.that(list1.length, is(10));
		azzert.that(list2.length, is(15));
		azzert.that(list3.length, is(0));
		for (int ¢ = 0; ¢ < 15; ¢++) {
			azzert.that(null, is(list2[¢]));
			list2[¢] = new Pair<>(box.it(3), box.it(4));
			azzert.that(list2[¢].first, is(box.it(3)));
			azzert.that(list2[¢].second, is(box.it(4)));
		}
	}

	@Test
	public void test_equals() {
		final Pair<Integer, Integer> p1 = new Pair<>(box.it(1), box.it(2)), p2 = Pair.newPair(box.it(3), box.it(4)),
				p3 = Pair.newPair(box.it(1), box.it(2));
		assert p1.equals(p1);
		assert !p1.equals(p2);
		assert p1.equals(p3);
	}

	@Test
	public void test_hash() {
		azzert.that(new Pair<>(box.it(1), box.it(2)).hashCode(), is(2));
	}

	@Test
	public void test_toString() {
		final Pair<Integer, Integer> p2 = Pair.newPair(box.it(3), box.it(4)), p3 = Pair.newPair(box.it(1), box.it(2));
		azzert.that(new Pair<>(box.it(1), box.it(2)) + "", is("<1,2>"));
		azzert.that(p2 + "", is("<3,4>"));
		assert !"<1, 2>".equals(p3 + "");
	}
}
