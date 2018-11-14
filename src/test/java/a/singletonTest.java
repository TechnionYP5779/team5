package a;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

public class singletonTest {
  @Test @SuppressWarnings("static-method") public void testList() {
    final List<Integer> l = singleton.list(Integer.valueOf(5));
    azzert.that(l.size(), azzert.is(1));
    azzert.that(Boolean.valueOf(l.isEmpty()), azzert.is(Boolean.FALSE));
    final Iterator<Integer> itr = l.iterator();
    azzert.that(itr.next(), azzert.is(Integer.valueOf(5)));
    azzert.that(Boolean.valueOf(itr.hasNext()), azzert.is(Boolean.FALSE));
    l.remove(0);
    azzert.that(Boolean.valueOf(l.isEmpty()), azzert.is(Boolean.TRUE));
  }

  @Test @SuppressWarnings("static-method") public void testArray() {
    final Object[] o = singleton.array(null);
    azzert.that(o[0], azzert.is((Object) null));
    azzert.that(Integer.valueOf(o.length), azzert.is(Integer.valueOf(1)));
  }
}
