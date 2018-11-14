package il.org.spartan.utils;
import fluent.ly.*;
import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PairTest {

  @Test public void test_constrAndNewPair() {
    final Pair<Integer, Integer> p1 = new Pair<>(box.box(1),box.box(2));
    azzert.that(p1.first, is(Integer.valueOf(1)));
    azzert.that(p1.second, is(Integer.valueOf(2)));
    final Pair<Integer, Integer> p2 = Pair.newPair(box.box(3),box.box(4));
    azzert.that(p2.first, is(Integer.valueOf(3)));
    azzert.that(p2.second, is(Integer.valueOf(4)));
  }

  @Test public void test_makePairs() {
    final Pair<Integer, Integer> list1[] = Pair.makePairs(10);
    final Pair<Integer, Integer> list2[] = Pair.makePairs(3, 5);
    final Pair<Integer, Integer> list3[] = Pair.makePairs(3, 0);
    azzert.that(list1.length, is(10));
    azzert.that(list2.length, is(15));
    azzert.that(list3.length, is(0));
    for (int ¢ = 0; ¢ < 15; ¢++) {
      azzert.that(null, is(list2[¢]));
      list2[¢] = new Pair<>(box.box(3),box.box(4));
      azzert.that(list2[¢].first, is(Integer.valueOf(3)));
      azzert.that(list2[¢].second, is(Integer.valueOf(4)));
    }
  }

  @Test public void test_equals() {
    final Pair<Integer, Integer> p1 = new Pair<>(box.box(1),box.box(2)), p2 = Pair.newPair(box.box(3),box.box(4)), p3 = Pair.newPair(box.box(1),box.box(2));
    azzert.that(p1.equals(p1), is(true));
    azzert.that(p1.equals(p2), is(false));
    azzert.that(p1.equals(p3), is(true));
  }

  @Test public void test_hash() {
    azzert.that(new Pair<>(box.box(1),box.box(2)).hashCode(), is(2));
  }

  @Test public void test_toString() {
    final Pair<Integer, Integer> p2 = Pair.newPair(box.box(3),box.box(4)), p3 = Pair.newPair(box.box(1),box.box(2));
    azzert.that(new Pair<>(box.box(1),box.box(2)) + "", is("<1,2>"));
    azzert.that(p2 + "", is("<3,4>"));
    azzert.that(false, is("<1, 2>".equals(p3 + "")));
  }
}
