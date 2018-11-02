package a;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class singletonTest {
  @SuppressWarnings("static-method") @Test public void testList() {
    Integer x = Integer.valueOf(5);
    List<Integer> l= singleton.list(x);
    assertEquals(1, l.size());
    assertEquals(Boolean.valueOf(false),Boolean.valueOf(l.isEmpty()));
    Iterator<Integer> itr = l.iterator();
    assertEquals(Integer.valueOf(5),itr.next());
    assertEquals(Boolean.valueOf(false), Boolean.valueOf(itr.hasNext()));
    l.remove(0);
    assertEquals(Boolean.valueOf(true), Boolean.valueOf(l.isEmpty()));
  }
  
  @SuppressWarnings("static-method") @Test public void testArray() {
    Object x = null;
    Object[] o = singleton.array(x);
    assertEquals(null,o[0]);
    assertEquals(Integer.valueOf(1), Integer.valueOf(o.length));
  }
}
