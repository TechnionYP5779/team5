package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;
import org.junit.*;

public class asTest {
  @Test @SuppressWarnings("static-method") public void emptyAsIterableTest() {
    azzert.assertTrue(!as.asIterable().iterator().hasNext());
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void iterableHasRange10Test() {
    @SuppressWarnings("boxing") final Iterator<Integer> i = as.asIterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).iterator();
    Assert.assertEquals(Integer.valueOf(1), i.next());
    Assert.assertEquals(Integer.valueOf(2), i.next());
    Assert.assertEquals(Integer.valueOf(3), i.next());
    Assert.assertEquals(Integer.valueOf(4), i.next());
    Assert.assertEquals(Integer.valueOf(5), i.next());
    Assert.assertEquals(Integer.valueOf(6), i.next());
    Assert.assertEquals(Integer.valueOf(7), i.next());
    Assert.assertEquals(Integer.valueOf(8), i.next());
    Assert.assertEquals(Integer.valueOf(9), i.next());
    Assert.assertEquals(Integer.valueOf(10), i.next());
    assert !i.hasNext();
  }

  @SuppressWarnings("static-method") public void falseShouldBe0bit() {
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
    Assert.assertEquals(new ArrayList(), as.ingeterList());
  }

  @Test @SuppressWarnings({ "static-access", "static-method" }) public void range10IterableList() {
    Assert.assertEquals(IntStream.range(1, 11).boxed().collect(Collectors.toList()), as.ingeterList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void range10ArrayTest() {
    Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  @Test @SuppressWarnings({ "static-method", "boxing", "static-access" }) public void iteratorHasRange10Test() {
    final Iterator<Integer> i = as.iterator(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Assert.assertEquals(Integer.valueOf(1), i.next());
    Assert.assertEquals(Integer.valueOf(2), i.next());
    Assert.assertEquals(Integer.valueOf(3), i.next());
    Assert.assertEquals(Integer.valueOf(4), i.next());
    Assert.assertEquals(Integer.valueOf(5), i.next());
    Assert.assertEquals(Integer.valueOf(6), i.next());
    Assert.assertEquals(Integer.valueOf(7), i.next());
    Assert.assertEquals(Integer.valueOf(8), i.next());
    Assert.assertEquals(Integer.valueOf(9), i.next());
    Assert.assertEquals(Integer.valueOf(10), i.next());
    azzert.assertTrue(!i.hasNext());
  }

  @Test @SuppressWarnings({ "static-method", "static-access", "rawtypes" }) public void emptyListTest() {
    final Iterable<Integer> i = null;
    Assert.assertEquals(new ArrayList(), as.list(i));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void range10IterableTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    Assert.assertEquals(l, as.list(l));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void rangeA2zListTest() {
    Assert.assertEquals(IntStream.range(0, 26).mapToObj(λ -> String.valueOf((char) (λ + 'A'))).collect(Collectors.toList()),
        as.list("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
  }

  @Test @SuppressWarnings({ "static-method", "static-access", "boxing" }) public void setOf123Test() {
    final Set<Integer> s = new HashSet<>();
    s.add(1);
    s.add(2);
    s.add(3);
    Assert.assertEquals(s, as.set(1, 1, 2, 3, 2, 3, 1, 2, 3));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void nullStringTest() {
    Assert.assertEquals("null", as.string(null));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void objectStringTest() {
    final Object o = new Object();
    Assert.assertEquals(o + "", as.string(o));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void charAsStringTest() {
    Assert.assertEquals("A", as.string('A'));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void nullAsStringTest() {
    Assert.assertEquals("null", as.string(null));
  }

  @Test @SuppressWarnings({ "static-access", "static-method" }) public void StringasStringTest() {
    Assert.assertEquals("hello world", as.string("hello world"));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void iterableAsStringTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    Assert.assertEquals(l + "", as.string(l));
  }

  @SuppressWarnings("static-method") @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), azzert.is(0));
  }

  @SuppressWarnings("static-method") @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), azzert.is(1));
  }

  @SuppressWarnings("static-method") @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @SuppressWarnings("static-method") @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    @SuppressWarnings("null") final @NotNull List<Integer> is = as.list(new int @NotNull [] { 12, 13, 14 });
    azzert.that(is.get(0), azzert.is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), azzert.is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), azzert.is(fluent.ly.box.it(14)));
    azzert.that(is.size(), azzert.is(3));
  }

  @SuppressWarnings("static-method") @Test public void stringOfNull() {
    azzert.that(as.string(null), azzert.is("null"));
  }

  @SuppressWarnings("static-method") @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable public String toString() {
        return null;
      }
    }), azzert.is("null"));
  }
}
