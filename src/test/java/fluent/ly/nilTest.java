package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

public class nilTest {
  @SuppressWarnings("static-method") @Test public void testForgetting() {
    Object o = nil.forgetting(new Object());
    assertEquals(null, o);
    o = nil.forgetting(new Integer(3), new Integer(7));
    assertEquals(null, o);
  }
  
  
  @SuppressWarnings("static-method") @Test public void testGuardingly() {
    String helloString = "Hello";
    String nullString = null;
    final Integer i1 = nil.guardingly(String::length).on(helloString);
    assertEquals(Integer.valueOf(5),i1);
    final Integer i2 = nil.guardingly(String::length).on(nullString);
    assertEquals(Integer.valueOf(5),i1);
    assertEquals(null,i2);
  }
  
  @SuppressWarnings("static-method") @Test public void testBoolIgnoring() {
    Object o = nil.ignoring(false);
    assertEquals(null, o);
    o = nil.ignoring(true);
    assertEquals(null, o);
  }
  
  @SuppressWarnings("static-method") @Test public void testDoubleIgnoring() {
    Object o;
    for (double d = 3.14; d<=102.37; d+=Math.E) {
      o = nil.ignoring(d);
      assertEquals(null, o);
    }
  }
  
  @SuppressWarnings("static-method") @Test public void testLongIgnoring() {
    Object o;
    for (long l = 30000; l<=102000; l+=100) {
      o = nil.ignoring(l);
      assertEquals(null, o);
    }
  }
}
