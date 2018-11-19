package il.org.spartan.iterables;

import static il.org.spartan.Utils.*;

import java.util.*;

import org.junit.*;

import an.*;
import fluent.ly.*;

/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. Note the naming convention: a) names of test methods do
 * not use are not prefixed by "test". This prefix is redundant. b) test methods
 * begin with the name of the method they check.
 * @author Yossi Gil
 * @since 2014-05-31 */

@SuppressWarnings({"static-method", "boxing"})
public class iterablesTest {
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
    azzert.assertEquals(3, iterables.count(iterable.over(null, "One", null, "Two", null, "Three")));
  }

  @Test public void countEmpty() {
    azzert.assertEquals(0, iterables.count(iterables.<String> empty()));
  }

  @Test public void countSingleton() {
    azzert.assertEquals(1, iterables.count(iterable.singleton(new Object())));
  }

  @Test public void countThree() {
    azzert.assertEquals(3, iterables.count(iterable.over("One", "Two", "Three")));
  }
  
  @Test public void alternateNewIntegerIterablesTest() {
    Iterable<Integer> it1 = new ArrayList<>();
    Iterable<Integer> it2 = new ArrayList<>();
    iterables.alternate(it1, it2);
  }
  
  @Test public void alternateFirstIterableNullTest() {
    Iterable<Integer> it1 = new ArrayList<>();
    azzert.isNull(iterables.alternate(it1, null));
    azzert.isNull(iterables.alternate(null, it1));
    
  }
  
  @Test public void alternateGenericAlternate() {
    iterables.alternate(new ArrayList<>(), new ArrayList<>());
  }
  
  @Test public void alternateTwoIntegerSingletonListsReturnListWithBothIntegers() {
    List<Integer> lst1 = new ArrayList<>();
    List<Integer> lst2 = new ArrayList<>();
    lst1.add(100);
    lst2.add(200);
    azzert.assertEquals(100, iterables.alternate(lst1, lst2).iterator().next());
  }
  
  @Test public void alternateAddUntilTheShortestFirst() {
    List<Integer> lst1 = new ArrayList<>();
    List<Integer> lst2 = new ArrayList<>();
    lst2.add(1);
    lst1.add(2);
    lst2.add(3);
    lst2.add(4);
    Iterator<Integer> new_lst_it = iterables.alternate(lst1, lst2).iterator();
    azzert.assertEquals(2,new_lst_it.next());
    azzert.assertEquals(1, new_lst_it.next());
    azzert.assertEquals(false, new_lst_it.hasNext());
  }
  
  @Test public void alternateAddUntilTheShortestSecond() {
    List<Integer> lst1 = new ArrayList<>();
    List<Integer> lst2 = new ArrayList<>();
    lst1.add(1);
    lst2.add(2);
    lst1.add(3);
    Iterator<Integer> new_lst_it = iterables.alternate(lst1, lst2).iterator();
    azzert.assertEquals(1,new_lst_it.next());
    azzert.assertEquals(2, new_lst_it.next());
    azzert.assertEquals(false, new_lst_it.hasNext());
  }
}
