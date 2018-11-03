package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class RangeTest {
  @Test public void test_cnstr() {
    Range r = new Range(0,10);
    assertEquals(0,r.from);
    assertEquals(10,r.to);
     Range r2 = new Range(r);
     assertEquals(0,r2.from);
     assertEquals(10,r2.to);  
  }
  
  @Test public void test_equals() {
    Range r1 = new Range(0,10);
    Range r2 = new Range(10,20);
    Range r3 = new Range(r2);
    String str = new String("hello");
    assert(r1.equals(r1));
    assert(r2.equals(r3));
    assert(!r1.equals(r3));
    assert(!r1.equals(str));
  }
  
  @Test public void test_findIbcludedIn() {
    Range r1 = new Range(0,4);
    ArrayList<Range> list = new ArrayList<>();
    for(int i=0;i<4;i++) {
      list.add(new Range(0,i));
      assertEquals(null,r1.findIncludedIn(list));
    }
    for(int i=9;i>=4;i--) {
      ArrayList<Range> l2 = new ArrayList<>();
      Range r2 = new Range(0,i);
      l2.add(r2);
      assertEquals(r2,r1.findIncludedIn(l2));
    }
  }
  
  @Test public void test_isEmpty() {
    Range r1 = new Range(0,10), r2 = new Range(0,0), r3 = new Range(-1,14), r4 = new Range(1,0), r5 = new Range(9,9);
    assert(!r1.isEmpty());
    assert(r2.isEmpty());
    assert(!r3.isEmpty());
    assert(r4.isEmpty());
    assert(r5.isEmpty());
  }
  
  @Test public void test_merge() {
    Range r1 = new Range(0,10);
    Range r2 = r1.merge(new Range(-1,11));
    Range r3 = r1.merge(new Range(-1,9));
    Range r4 = r1.merge(new Range(1,15));
    
    assertEquals(-1,r2.from);
    assertEquals(-1,r3.from);
    assertEquals(0,r4.from);
    assertEquals(11,r2.to);
    assertEquals(10,r3.to);
    assertEquals(15,r4.to);
  }
  
  @Test public void test_overlapping() {
    /**
     *  public boolean overlapping(final @NotNull Range ¢) {
    return from >= ¢.from || to <= ¢.to;
  }
     */
    Range r1 = new Range(0,10);
    Range r2 = new Range(0,11), r3 = new Range(-1,15), r4 = new Range(-4,9), r5 = new Range(1,9);
    assert(r1.overlapping(r2));
    assert(r1.overlapping(r3));
    assert(r1.overlapping(r4));
    assert(!r1.overlapping(r5));
    assert(r5.overlapping(r1)); // fadiha
  }
  
  @Test public void test_pruneIncluders() {
    Range r1 = new Range(0,4);
    ArrayList<Range> list = new ArrayList<>();
    for(int i=0;i<10;i++) {
      list.add(new Range(0,i));
    }
    assertEquals(10,list.size());
    r1.pruneIncluders(list);
    assertEquals(4,list.size());
  }
  
  @Test public void test_size() {
    for(int i=0;i<10;i++) {
      Range r = new Range(0,i), r2 = new Range(i,0);
      assertEquals(i,r.size());
      assertEquals(-i,r2.size());
    }
  }
  
  @Test public void test_toString() {
    for(int i=0;i<10;i++) {
      Range r = new Range(0,i), r2 = new Range(i,0);
      assertEquals("["+0+", "+i+"]",r.toString());
      assertEquals("["+i+", "+0+"]",r2.toString());
    }
  }
}
