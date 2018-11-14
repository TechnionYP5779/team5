package an;

import java.util.*;
import org.junit.*;
import fluent.ly.*;
@SuppressWarnings("static-method") 
public class emptyTest {
  @Test public void testEmptyList() {
    azzert.that(empty.list().size(), azzert.is(0));
  }

  @Test public void testEmptyIterable() {
    final Iterator<Object> testIterable = empty.iterable().iterator();
    azzert.that(Boolean.valueOf(testIterable.hasNext()), azzert.is(Boolean.FALSE));
    azzert.isNull(testIterable.next());
  }
}
