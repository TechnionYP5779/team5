package an;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

public class emptyTest {
  @Test @SuppressWarnings("static-method") public void testEmptyList() {
    azzert.that(empty.list().size(), azzert.is(0));
  }

  @Test @SuppressWarnings("static-method") public void testEmptyIterable() {
    final Iterator<Object> testIterable = empty.iterable().iterator();
    azzert.that(Boolean.valueOf(testIterable.hasNext()), azzert.is(Boolean.FALSE));
    azzert.isNull(testIterable.next());
  }
}
