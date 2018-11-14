package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class asTest {
  @Test public void emptyAsIterableTest() {
    azzert.assertTrue(!as.asIterable().iterator().hasNext());
  }

  @Test public void iterableHasRange10Test() {
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

  public void falseShouldBe0bit() {
    azzert.assertEquals(0, as.bit(false));
  }

  @Test public void trueShouldBe1bit() {
    azzert.assertEquals(1, as.bit(true));
  }

  @Test public void nullShouldBe0bit() {
    azzert.assertEquals(0, as.bit(null));
  }

  @Test public void nonNUllShouldBe1bit() {
    azzert.assertEquals(1, as.bit(new Object()));
  }

  @Test public void emptyIterableListTest() {
    Assert.assertEquals(new ArrayList<>(), as.ingeterList());
  }

  @Test public void range10IterableList() {
    Assert.assertEquals(IntStream.range(1, 11).boxed().collect(Collectors.toList()), as.ingeterList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  @Test public void range10ArrayTest() {
    Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  @Test @SuppressWarnings("boxing") public void iteratorHasRange10Test() {
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

  @Test public void emptyListTest() {
    final Iterable<Integer> i = null;
    Assert.assertEquals(new ArrayList<>(), as.list(i));
  }

  @Test public void range10IterableTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    Assert.assertEquals(l, as.list(l));
  }

  @Test public void rangeA2zListTest() {
    Assert.assertEquals(IntStream.range(0, 26).mapToObj(λ -> String.valueOf((char) (λ + 'A'))).collect(Collectors.toList()),
        as.list("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
  }

  @Test @SuppressWarnings("boxing") public void setOf123Test() {
    final Set<Integer> s = new HashSet<>();
    s.add(1);
    s.add(2);
    s.add(3);
    Assert.assertEquals(s, as.set(1, 1, 2, 3, 2, 3, 1, 2, 3));
  }

  @Test public void nullStringTest() {
    Assert.assertEquals("null", as.string(null));
  }

  @Test public void objectStringTest() {
    final Object o = new Object();
    Assert.assertEquals(o + "", as.string(o));
  }

  @Test public void charAsStringTest() {
    Assert.assertEquals("A", as.string('A'));
  }

  @Test public void nullAsStringTest() {
    Assert.assertEquals("null", as.string(null));
  }

  @Test public void StringasStringTest() {
    Assert.assertEquals("hello world", as.string("hello world"));
  }

  @Test public void iterableAsStringTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    Assert.assertEquals(l + "", as.string(l));
  }

  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    @SuppressWarnings("null") final @NotNull List<Integer> is = as.list(new int @NotNull [] { 12, 13, 14 });
    azzert.that(is.get(0), is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), is(fluent.ly.box.it(14)));
    azzert.that(is.size(), is(3));
  }

  @Test public void stringOfNull() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable public String toString() {
        return null;
      }
    }), is("null"));
  }
}
