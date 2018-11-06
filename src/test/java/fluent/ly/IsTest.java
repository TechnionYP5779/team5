package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.English.*;
import il.org.spartan.utils.*;


public class IsTest {
  @Test public void testIn() {
    Integer a = null;
    assertEquals(true, is.in("", ""));
    assertEquals(true, is.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    assertEquals(false, is.in((Integer)1, a));
    assertEquals(false, is.in(1, 3, 8, 5));
    assertEquals(false, is.in(""));
  }
  
  @Test public void testNot(){
    assertEquals(false, is.not.in("", ""));
    assertEquals(false, is.not.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    assertEquals(true, is.not.in(1, 3, 8, 5));
    assertEquals(true, is.not.in(""));
  }
  
  @Test public void testOut() {
    assertEquals(false, is.out("", ""));
    assertEquals(false, is.out("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    assertEquals(true, is.out(1, 3, 8, 5));
    assertEquals(true, is.out(""));
  }
  
  @Test public void testIsInInt() {
    int num = 4;
    assertEquals(true, is.intIsIn(num, 1,2,3,4,5,6,7,8,9,10));
    assertEquals(false, is.intIsIn(num, 1, 2, 3, 5, 6, 7, 8, 9, 10));
  }
  
  @Test public void testIsEmptyNull() {
    String s = null;
    Object a[] = null;
    Iterable<Object> it = null;
    Collection<Object> coll = null;
    assertEquals(true, is.empty(s));
    assertEquals(true, is.empty(a));
    assertEquals(true, is.empty(it));
    assertEquals(true, is.empty(coll));
    
  }
  
  @Test public void testIsEmpty() {
    String s = "";
    Object a[] = {};
    Iterable<Object> it = new ArrayList<Object>();
    Collection<Object> coll = new ArrayList<Object>();
    assertEquals(true, is.empty(s));
    assertEquals(true, is.empty(a));
    assertEquals(true, is.empty(it));
    assertEquals(true, is.empty(coll));
  }
  
  @Test public void testIsNotEmpty() {
    String s = "Hello World";
    Integer a[] = {1,2,3,4};
    ArrayList<Integer> it = new ArrayList<Integer>();
    it.add(1);
    assertEquals(false, is.empty(s));
    assertEquals(false, is.empty(a));
    assertEquals(false, is.empty(it));
    assertEquals(false, is.empty((Iterable<Integer>) it));
  }
}
