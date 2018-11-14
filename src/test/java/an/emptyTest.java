package an;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testEmptyList() {
    azzert.that(empty.list().size(), is(0));
  }

  @Test public void testEmptyIterable() {
    final Iterator<Object> testIterable = empty.iterable().iterator();
    azzert.that(box.box(testIterable.hasNext()), is(Boolean.FALSE));
    isNull(testIterable.next());
  }
}
