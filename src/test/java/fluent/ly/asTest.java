package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class asTest {
  @Test public void emptyAsIterableTest() {
    assert !as.asIterable().iterator().hasNext();
  }

  @Test public void iterableHasRange10Test() {
    final Iterator<Integer> i = as
        .asIterable(box.it(1), box.it(2), box.it(3), box.it(4), box.it(5), box.it(6), box.it(7), box.it(8), box.it(9), box.it(10)).iterator();
    azzert.that(box.it(1), is(i.next()));
    azzert.that(box.it(2), is(i.next()));
    azzert.that(box.it(3), is(i.next()));
    azzert.that(box.it(4), is(i.next()));
    azzert.that(box.it(5), is(i.next()));
    azzert.that(box.it(6), is(i.next()));
    azzert.that(box.it(7), is(i.next()));
    azzert.that(box.it(8), is(i.next()));
    azzert.that(box.it(9), is(i.next()));
    azzert.that(box.it(10), is(i.next()));
    assert !i.hasNext();
  }

  public void falseShouldBe0bit() {
    azzert.that(0, is(as.bit(false)));
  }

  @Test public void trueShouldBe1bit() {
    azzert.that(1, is(as.bit(true)));
  }

  @Test public void nullShouldBe0bit() {
    azzert.that(0, is(as.bit(null)));
  }

  @Test public void nonNUllShouldBe1bit() {
    azzert.that(1, is(as.bit(new Object())));
  }

  @Test public void emptyIterableListTest() {
    azzert.that(new ArrayList<>(), is(as.ingeterList()));
  }

  @Test public void range10IterableList() {
    azzert.that(IntStream.range(1, 11).boxed().collect(Collectors.toList()), is(as.ingeterList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
  }

  @Test public void range10ArrayTest() {
    azzert.that(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, is(as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
  }

  @Test public void iteratorHasRange10Test() {
    final Iterator<Integer> i = as.iterator(box.it(1), box.it(2), box.it(3), box.it(4), box.it(5), box.it(6), box.it(7), box.it(8), box.it(9),
        box.it(10));
    azzert.that(box.it(1), is(i.next()));
    azzert.that(box.it(2), is(i.next()));
    azzert.that(box.it(3), is(i.next()));
    azzert.that(box.it(4), is(i.next()));
    azzert.that(box.it(5), is(i.next()));
    azzert.that(box.it(6), is(i.next()));
    azzert.that(box.it(7), is(i.next()));
    azzert.that(box.it(8), is(i.next()));
    azzert.that(box.it(9), is(i.next()));
    azzert.that(box.it(10), is(i.next()));
    assert !i.hasNext();
  }

  @Test public void emptyListTest() {
    final Iterable<Integer> i = null;
    azzert.that(new ArrayList<>(), is(as.list(i)));
  }

  @Test public void range10IterableTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    azzert.that(l, is(as.list(l)));
  }

  @SuppressWarnings("null") @Test public void rangeA2zListTest() {
    azzert.that(IntStream.range(0, 26).mapToObj(λ -> String.valueOf((char) (λ + 'A'))).collect(Collectors.toList()), is(
        as.list("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")));
  }

  @Test public void setOf123Test() {
    final Set<Integer> s = new HashSet<>();
    s.add(box.it(1));
    s.add(box.it(2));
    s.add(box.it(3));
    azzert.that(s, is(as.set(box.it(1), box.it(1), box.it(2), box.it(3), box.it(2), box.it(3), box.it(1), box.it(2), box.it(3))));
  }

  @Test public void nullStringTest() {
    azzert.that("null", is(as.string(null)));
  }

  @Test public void objectStringTest() {
    final Object o = new Object();
    azzert.that(o + "", is(as.string(o)));
  }

  @Test public void charAsStringTest() {
    azzert.that("A", is(as.string('A')));
  }

  @Test public void nullAsStringTest() {
    azzert.that("null", is(as.string(null)));
  }

  @Test public void StringasStringTest() {
    azzert.that("hello world", is(as.string("hello world")));
  }

  @Test public void iterableAsStringTest() {
    final List<Integer> l = IntStream.range(1, 11).boxed().collect(Collectors.toList());
    azzert.that(l + "", is(as.string(l)));
  }

  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    azzert.that(is, is(as.intArray(as.ingeterList(is))));
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
