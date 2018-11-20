package il.org.spartan.iterables;

import static il.org.spartan.Utils.*;

import java.util.*;
import static fluent.ly.azzert.is;
import org.junit.*;
import static fluent.ly.azzert.isNull;
import an.*;
import fluent.ly.*;

/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. Note the naming convention: a) names of test methods do
 * not use are not prefixed by "test". This prefix is redundant. b) test methods
 * begin with the name of the method they check.
 * @author Yossi Gil
 * @since 2014-05-31 */
@SuppressWarnings("static-method") public class iterablesTest {
  @Test public void containsDegenerate() {
    azzert.nay(contains("Hello"));
  }

  @Test public void containseturnsFalseTypical() {
    azzert.nay(contains("Hello", null, "x", "y", null, "z", "w", "u", "v"));
  }

  @Test public void containsSimple() {
    azzert.aye("", contains("Hello", "e"));
  }

  @Test public void containsTypical() {
    azzert.aye("", contains("Hello", "a", "b", "c", "d", "e", "f"));
  }

  @Test public void containsWithNulls() {
    azzert.aye("", contains("Hello", null, "a", "b", null, "c", "d", "e", "f", null));
  }

  @Test public void countDoesNotIncludeNull() {
    azzert.that(3, is(iterables.count(iterable.over(null, "One", null, "Two", null, "Three"))));
  }

  @Test public void countEmpty() {
    azzert.that(0, is(iterables.count(iterables.<String> empty())));
  }

  @Test public void countSingleton() {
    azzert.that(1, is(iterables.count(iterable.singleton(new Object()))));
  }

  @Test public void countThree() {
    azzert.that(3, is(iterables.count(iterable.over("One", "Two", "Three"))));
  }

  @Test public void alternateNewIntegerIterablesTest() {
    final Iterable<Integer> it1 = new ArrayList<>();
    final Iterable<Integer> it2 = new ArrayList<>();
    iterables.alternate(it1, it2);
  }

  @Test public void alternateFirstIterableNullTest() {
    final Iterable<Integer> it1 = new ArrayList<>();
    isNull(iterables.alternate(it1, null));
    isNull(iterables.alternate(null, it1));
  }

  @Test public void alternateGenericAlternate() {
    iterables.alternate(new ArrayList<>(), new ArrayList<>());
  }

  @Test public void alternateTwoIntegerSingletonListsReturnListWithBothIntegers() {
    final List<Integer> lst1 = new ArrayList<>();
    final List<Integer> lst2 = new ArrayList<>();
    lst1.add(box.it(100));
    lst2.add(box.it(200));
    azzert.that(iterables.alternate(lst1, lst2).iterator().next(), is(100));
  }

  @Test public void alternateAddUntilTheShortestFirst() {
    final List<Integer> lst1 = new ArrayList<>();
    final List<Integer> lst2 = new ArrayList<>();
    lst2.add(box.it(1));
    lst1.add(box.it(2));
    lst2.add(box.it(3));
    lst2.add(box.it(4));
    final Iterator<Integer> new_lst_it = iterables.alternate(lst1, lst2).iterator();
    azzert.that(new_lst_it.next(), azzert.is(2));
    azzert.that(new_lst_it.next(), azzert.is(1));
    assert !new_lst_it.hasNext();
  }

  @Test public void alternateAddUntilTheShortestSecond() {
    final List<Integer> lst1 = new ArrayList<>();
    final List<Integer> lst2 = new ArrayList<>();
    lst1.add(box.it(1));
    lst2.add(box.it(2));
    lst1.add(box.it(3));
    final Iterator<Integer> new_lst_it = iterables.alternate(lst1, lst2).iterator();
    azzert.that(new_lst_it.next(), azzert.is(1));
    azzert.that(new_lst_it.next(), azzert.is(2));
    assert !new_lst_it.hasNext();
  }
}
