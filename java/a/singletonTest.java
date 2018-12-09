package a;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class singletonTest {
  @Test public void testList() {
    final List<Integer> l = singleton.list(box.it(5));
    azzert.that(l.size(), is(1));
    assert !l.isEmpty();
    final Iterator<Integer> itr = l.iterator();
    azzert.that(itr.next(), is(box.it(5)));
    assert !itr.hasNext();
    l.remove(0);
    assert l.isEmpty();
  }

  @Test public void testArray() {
    final Object[] o = singleton.array(null);
    azzert.that(o[0], is((Object) null));
    azzert.that(box.it(o.length), is(box.it(1)));
  }
}
