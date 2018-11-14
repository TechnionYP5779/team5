package a;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") 
public class singletonTest {
  @Test public void testList() {
    final List<Integer> l = singleton.list(box.box(5));
    azzert.that(l.size(), azzert.is(1));
    azzert.that(box.box(l.isEmpty()), azzert.is(Boolean.FALSE));
    final Iterator<Integer> itr = l.iterator();
    azzert.that(itr.next(),azzert.is(box.box(5)));
    azzert.that(box.box(itr.hasNext()), azzert.is(Boolean.FALSE));
    l.remove(0);
    azzert.that(box.box(l.isEmpty()), azzert.is(Boolean.TRUE));
  }

  @Test public void testArray() {
    final Object[] o = singleton.array(null);
    azzert.that(o[0], azzert.is((Object)null));
    azzert.that(box.box(o.length), azzert.is(box.box(1)));
  }
}
