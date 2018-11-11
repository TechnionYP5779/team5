package fluent.ly;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class asTest {
  @Test @SuppressWarnings("static-method") public void emptyAsIterableTest() {
    azzert.assertTrue(!as.asIterable().iterator().hasNext());
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void iterableHasRange10Test() {
    @SuppressWarnings("boxing") final Iterator<Integer> i = as.asIterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).iterator();
    azzert.assertEquals(Integer.valueOf(1), i.next());
    azzert.assertEquals(Integer.valueOf(2), i.next());
    azzert.assertEquals(Integer.valueOf(3), i.next());
    azzert.assertEquals(Integer.valueOf(4), i.next());
    azzert.assertEquals(Integer.valueOf(5), i.next());
    azzert.assertEquals(Integer.valueOf(6), i.next());
    azzert.assertEquals(Integer.valueOf(7), i.next());
    azzert.assertEquals(Integer.valueOf(8), i.next());
    azzert.assertEquals(Integer.valueOf(9), i.next());
    azzert.assertEquals(Integer.valueOf(10), i.next());
    assert !i.hasNext();
  }

  @Test @SuppressWarnings("static-method") public void falseShouldBe0bit() {
    azzert.assertEquals(0, as.bit(false));
  }

  @Test @SuppressWarnings("static-method") public void trueShouldBe1bit() {
    azzert.assertEquals(1, as.bit(true));
  }

  @Test @SuppressWarnings("static-method") public void nullShouldBe0bit() {
    azzert.assertEquals(0, as.bit(null));
  }

  @Test @SuppressWarnings("static-method") public void nonNUllShouldBe1bit() {
    azzert.assertEquals(1, as.bit(new Object()));
  }

  @Test @SuppressWarnings({ "static-method", "static-access", "rawtypes" }) public void emptyIterableListTest() {
    azzert.assertEquals(new ArrayList(), as.ingeterList());
  }

  @Test @SuppressWarnings({ "static-access", "static-method" }) public void range10IterableList() {
    azzert.assertEquals(IntStream.range(1, 11).boxed().collect(Collectors.toList()), as.ingeterList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void range10ArrayTest() {
    azzert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  @Test @SuppressWarnings({ "static-method", "boxing", "static-access" }) public void iteratorHasRange10Test() {
    final Iterator<Integer> i = as.iterator(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    azzert.assertEquals(Integer.valueOf(1), i.next());
    azzert.assertEquals(Integer.valueOf(2), i.next());
    azzert.assertEquals(Integer.valueOf(3), i.next());
    azzert.assertEquals(Integer.valueOf(4), i.next());
    azzert.assertEquals(Integer.valueOf(5), i.next());
    azzert.assertEquals(Integer.valueOf(6), i.next());
    azzert.assertEquals(Integer.valueOf(7), i.next());
    azzert.assertEquals(Integer.valueOf(8), i.next());
    azzert.assertEquals(Integer.valueOf(9), i.next());
    azzert.assertEquals(Integer.valueOf(10), i.next());
    azzert.assertTrue(!i.hasNext());
  }

  @Test @SuppressWarnings({ "static-method", "static-access", "rawtypes" }) public void emptyListTest() {
    final Iterable<Integer> i = null;
    azzert.assertEquals(new ArrayList(), as.list(i));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void range10IterableTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    azzert.assertEquals(l, as.list(l));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void rangeA2zListTest() {
    azzert.assertEquals(IntStream.range(0, 26).mapToObj(λ -> String.valueOf((char) (λ + 'A'))).collect(Collectors.toList()),
        as.list("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
  }

  @Test @SuppressWarnings({ "static-method", "static-access", "boxing" }) public void setOf123Test() {
    final Set<Integer> s = new HashSet<>();
    s.add(1);
    s.add(2);
    s.add(3);
    azzert.assertEquals(s, as.set(1, 1, 2, 3, 2, 3, 1, 2, 3));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void nullStringTest() {
    azzert.assertEquals("null", as.string(null));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void objectStringTest() {
    final Object o = new Object();
    azzert.assertEquals(o + "", as.string(o));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void charAsStringTest() {
    azzert.assertEquals("A", as.string('A'));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void nullAsStringTest() {
    azzert.assertEquals("null", as.string(null));
  }

  @Test @SuppressWarnings({ "static-access", "static-method" }) public void StringasStringTest() {
    azzert.assertEquals("hello world", as.string("hello world"));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void iterableAsStringTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    azzert.assertEquals(l + "", as.string(l));
  }
}
