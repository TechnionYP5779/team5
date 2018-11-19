package fluent.ly;


import java.util.*;

import org.junit.*;



/**
 * @since 2018-11-14
 * @author Nir Chachamovitz
 * Tests for class is, checks several properties on a set of objects
 */
@SuppressWarnings("static-method")
public class IsTest {
   @SuppressWarnings("null") @Test public void testIn() {
    Integer a = null;
    azzert.assertEquals(true, is.in("", ""));
    azzert.assertEquals(true, is.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(false, is.in(box.box(1), a));
    azzert.assertEquals(false, is.in(box.box(1), box.box(3), box.box(8), box.box(5)));
    azzert.assertEquals(false, is.in(""));
  }
  
  @Test public void testNot(){
    azzert.assertEquals(false, is.not.in("", ""));
    azzert.assertEquals(false, is.not.in("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(true, is.not.in(box.box(1), box.box(3), box.box(8), box.box(5)));
    azzert.assertEquals(true, is.not.in(""));
  }
  
  @Test public void testOut() {
    azzert.assertEquals(false, is.out("", ""));
    azzert.assertEquals(false, is.out("nir", "igor", "shaked", "shalev", "lior", "or", "nir"));
    azzert.assertEquals(true, is.out(box.box(1), box.box(3), box.box(8), box.box(5)));
    azzert.assertEquals(true, is.out(""));
  }
  
//  @Test public static void testIsInInt() {
//    int num = 4;
//    azzert.assertEquals(true, is.intIsIn(num, 1,2,3,4,5,6,7,8,9,10));
//    azzert.assertEquals(false, is.intIsIn(num, 1, 2, 3, 5, 6, 7, 8, 9, 10));
//  }
  
  @Test public void testIsEmptyNull() {
    String s = null;
    Object a[] = null;
    Iterable<Object> it = null;
    Collection<Object> coll = null;
    azzert.assertEquals(true, is.empty(s));
    azzert.assertEquals(true, is.empty(a));
    azzert.assertEquals(true, is.empty(it));
    azzert.assertEquals(true, is.empty(coll));
    
  }
  
  @Test public void testIsEmpty() {
    String s = "";
    Object a[] = {};
    Iterable<Object> it = new ArrayList<>();
    Collection<Object> coll = new ArrayList<>();
    azzert.assertEquals(true, is.empty(s));
    azzert.assertEquals(true, is.empty(a));
    azzert.assertEquals(true, is.empty(it));
    azzert.assertEquals(true, is.empty(coll));
  }
  
  @Test public void testIsNotEmpty() {
    String s = "Hello World";
    Integer a[] = {box.box(1),box.box(2),box.box(3),box.box(4)};
    ArrayList<Integer> it = new ArrayList<>();
    it.add(box.box(1));
    azzert.assertEquals(false, is.empty(s));
    azzert.assertEquals(false, is.empty(a));
    azzert.assertEquals(false, is.empty(it));
    azzert.assertEquals(false, is.empty((Iterable<Integer>) it));
  }
}