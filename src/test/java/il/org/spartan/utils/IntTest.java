package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class IntTest {
  @Test public void test_constrAndValueOf() {
    Int i = new Int(10);
    assertEquals(10,i.get());
    Int i2 = i.valueOf(9);
    assertEquals(9,i2.get());  
  }
  
  @Test public void test_inner() {
    Int i1 = new Int(10);
    Integer inner = i1.inner(), inner2 = i1.inner();
    assertEquals(10,inner.intValue());
    assertEquals(10,inner2.intValue());
    assert(inner.equals(inner2));
  }
  
  @Test public void test_stepAndGet() {
    Int i = new Int(0);
    for(int x = 1;x<=10;x++) {
      i.step();
      assertEquals(x,i.get());
    }
  }
  
  @Test public void test_add() {
    Int i = new Int(0);
    int arr[] = {1,3,6,10,15,21,28,36,45,55};
    for(int x=1;x<=10;x++) {
      i.add(x);
      assertEquals(arr[x-1],i.get());
    }
    for(int x=10;x>=2;x--) {
      i.add(-x);
      assertEquals(arr[x-2],i.get());
    }
  }
  
  @Test public void test_set() {
    Int i = new Int (0);
    assertEquals(0,i.get());
    for(int x=1;x<=10;x++) {
      i.set(x);
      assertEquals(x,i.get());
    }
  }
  
  @Test public void test_toString() {
    Int i = new Int(0);
    for(int x=1;x<=10;x++) {
      i.set(x);
      assertEquals(x+"",i.toString());
      assertEquals(""+x,i.toString());
      assertEquals(""+x+"",i.toString());
    }
  }
  
  @Test public void test_nextAndGet() {
    Int i = new Int(0);
    for(int x = 1;x<=10;x++) {
      int d = i.next();
      assertEquals(x,d);
    }
  }
  
  @Test public void test_add2() {
    Int i = new Int(0);
    int arr[] = {1,3,6,10,15,21,28,36,45,55};
    for(int x=1;x<=10;x++) {
      Int i2 = new Int(x);
      i.add(i2);
      assertEquals(arr[x-1],i.get());
    }
    for(int x=10;x>=2;x--) {
      Int i2 = new Int(-x);
      i.add(i2);
      assertEquals(arr[x-2],i.get());
    }
  }
  
  @Test public void test_clear() {
    Int i = new Int(10);
    assertEquals(10,i.get());
    i.clear();
    assertEquals(0,i.get());
    i.add(0);
    int old = i.get();
    i.clear();
    assertEquals(old,i.get());
  }
}
