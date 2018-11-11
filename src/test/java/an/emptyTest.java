package an;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

public class emptyTest {
  @SuppressWarnings("static-method") @Test public void testEmptyList() {
    final List<Object> testList = empty.list();
    azzert.that(testList.size(), azzert.is(0));
  }

  @SuppressWarnings("static-method") @Test public void testEmptyIterable() {
    final Iterator<Object> testIterable = empty.iterable().iterator();
    azzert.that(Boolean.valueOf(testIterable.hasNext()), azzert.is(Boolean.valueOf(false)));
    azzert.isNull(testIterable.next());
  }
}
