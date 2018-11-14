package a;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;
@SuppressWarnings("static-method") 
public class singletonTest {
  @Test public void testList() {
    final List<Integer> l = singleton.list(box.box(5));
    azzert.that(l.size(), is(1));
    azzert.that(box.box(l.isEmpty()), is(Boolean.FALSE));
    final Iterator<Integer> itr = l.iterator();
    azzert.that(itr.next(),is(box.box(5)));
    azzert.that(box.box(itr.hasNext()), is(Boolean.FALSE));
    l.remove(0);
assert box.box(l.isEmpty());
  }

  @Test public void testArray() {
    final Object[] o = singleton.array(null);
    azzert.that(o[0], is((Object)null));
    azzert.that(box.box(o.length), is(box.box(1)));
  }
}
