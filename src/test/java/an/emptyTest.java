package an;

import java.util.*;
import org.junit.*;
import fluent.ly.*;

public class emptyTest {
  @Test public void testEmptyList() {
    List<Object> testList = empty.list();
    
    azzert.that(testList.size(), azzert.is(0));
  }
  
  @Test public void testEmptyIterable() {
    Iterator<Object> testIterable = empty.iterable().iterator();
    
    azzert.that(Boolean.valueOf(testIterable.hasNext()), azzert.is(Boolean.valueOf(false)));
    azzert.isNull(testIterable.next());
  }
}
