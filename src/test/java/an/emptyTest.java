package an;

import static org.junit.Assert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import an.*;

public class emptyTest {
  @Test public void testEmptyList() {
    List<Object> testList = empty.list();
    
    assertEquals(0, testList.size());
  }
  
  @Test public void testEmptyIterable() {
    Iterator<Object> testIterable = empty.iterable().iterator();
    
    assertEquals(Boolean.valueOf(false), Boolean.valueOf(testIterable.hasNext()));
    assertEquals(null, testIterable.next());
  }
}
