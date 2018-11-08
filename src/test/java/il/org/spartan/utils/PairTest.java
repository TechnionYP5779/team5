package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class PairTest {
  @Test public void test_constrAndNewPair() {
    final Pair<Integer, Integer> p1 = new Pair<>(1, 2);
    assertEquals(Integer.valueOf(1), p1.first);
    assertEquals(Integer.valueOf(2), p1.second);
    final Pair<Integer, Integer> p2 = Pair.newPair(3, 4);
    assertEquals(Integer.valueOf(3), p2.first);
    assertEquals(Integer.valueOf(4), p2.second);
  }

  @Test public void test_makePairs() {
    final Pair<Integer, Integer> p1 = new Pair<>(1, 2);
    final Pair<Integer, Integer> list1[] = Pair.makePairs(10);
    final Pair<Integer, Integer> list2[] = Pair.makePairs(3, 5);
    final Pair<Integer, Integer> list3[] = Pair.makePairs(3, 0);
    assertEquals(10, list1.length);
    assertEquals(15, list2.length);
    assertEquals(0, list3.length);
    for (int i = 0; i < 15; i++) {
      assertEquals(list2[i], null);
      list2[i] = new Pair<>(3, 4);
      assertEquals(Integer.valueOf(3), list2[i].first);
      assertEquals(Integer.valueOf(4), list2[i].second);
    }
  }

  @Test public void test_equals() {
    final Pair<Integer, Integer> p1 = new Pair<>(1, 2), p2 = Pair.newPair(3, 4), p3 = Pair.newPair(1, 2);
    final String str = new String("hello");
    assertEquals(true, p1.equals(p1));
    assertEquals(false, p1.equals(p2));
    assertEquals(true, p1.equals(p3));
    assertEquals(false, p1.equals(str));
  }

  @Test public void test_hash() {
    final Pair<Integer, Integer> p1 = new Pair<>(1, 2);
    assertEquals(2, p1.hashCode());
  }

  @Test public void test_toString() {
    final Pair<Integer, Integer> p1 = new Pair<>(1, 2), p2 = Pair.newPair(3, 4), p3 = Pair.newPair(1, 2);
    assertEquals("<1,2>", p1.toString());
    assertEquals("<3,4>", p2.toString());
    assertNotSame("<1, 2>", p3.toString());
  }
}
