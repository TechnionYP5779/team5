package fluent.ly;

import static org.junit.Assert.*;
import org.junit.*;
import il.org.spartan.utils.*;

public class TestBool {
  @Test public void testValueOf() {
    Bool b = Bool.valueOf(true);
    assertEquals(b.get(), true);
  }
  
  @Test public void testClear() {
    Bool b = new Bool(true);
    b.clear();
    assertEquals(b.get(), false);
  }
  
  @Test public void testSet() {
    Bool b = new Bool(true);
    b.set(false);
    assertEquals(b.get(), false);
    
    b.set();
    assertEquals(b.get(), true);
  }
  
  @Test public void testInner() {
    assertEquals(Boolean.TRUE, Bool.valueOf(true).inner());
    assertEquals(Boolean.FALSE, Bool.valueOf(false).inner());

  }
  
  @Test public void testEmptyConst() {
    assertEquals((new Bool()).get(), false);
    assertEquals(Boolean.FALSE, Bool.valueOf(false).inner());

  }

}

