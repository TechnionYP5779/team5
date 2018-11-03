package fluent.ly;
import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.*;

import org.junit.*;
import fluent.ly.*;

public class asTest {
  @Test
  public void emptyAsIterableTest() {
    assertFalse(as.asIterable().iterator().hasNext());
  }
  
  @Test
  public void iterableHasRange10Test(){
    Iterator<Integer> i=as.asIterable(1,2,3,4,5,6,7,8,9,10).iterator();
    
    assertEquals(Integer.valueOf(1),i.next());
    assertEquals(Integer.valueOf(2),i.next());
    assertEquals(Integer.valueOf(3),i.next());
    assertEquals(Integer.valueOf(4),i.next());
    assertEquals(Integer.valueOf(5),i.next());
    assertEquals(Integer.valueOf(6),i.next());
    assertEquals(Integer.valueOf(7),i.next());
    assertEquals(Integer.valueOf(8),i.next());
    assertEquals(Integer.valueOf(9),i.next());
    assertEquals(Integer.valueOf(10),i.next());
    assertFalse(i.hasNext());
  }
  
  @Test
  public void falseShouldBe0bit() {
    assertEquals(0,as.bit(false));
  }
  
  @Test
  public void trueShouldBe1bit() {
    assertEquals(1,as.bit(true));
  }
  
  @Test
  public void nullShouldBe0bit() {
    assertEquals(0,as.bit(null));
  }
  
  @Test
  public void nonNUllShouldBe1bit() {
    assertEquals(1,as.bit(new Object()));
  }
  
  @Test
  public void emptyIterableListTest(){
    assertEquals(new ArrayList(),as.ingeterList());
  }
  
  @Test
  public void range10IterableList() {
    assertEquals(IntStream.range(1,11).boxed().collect(Collectors.toList()),as.ingeterList(1,2,3,4,5,6,7,8,9,10));
  }
  
  @Test
  public void range10ArrayTest() {
   int[] a= new int[] {1,2,3,4,5,6,7,8,9,10};
   
   assertArrayEquals(a,as.intArray(1,2,3,4,5,6,7,8,9,10));
  }
  
  @Test
  public void iteratorHasRange10Test(){
    Iterator<Integer> i=as.iterator(1,2,3,4,5,6,7,8,9,10);
    
    assertEquals(Integer.valueOf(1),i.next());
    assertEquals(Integer.valueOf(2),i.next());
    assertEquals(Integer.valueOf(3),i.next());
    assertEquals(Integer.valueOf(4),i.next());
    assertEquals(Integer.valueOf(5),i.next());
    assertEquals(Integer.valueOf(6),i.next());
    assertEquals(Integer.valueOf(7),i.next());
    assertEquals(Integer.valueOf(8),i.next());
    assertEquals(Integer.valueOf(9),i.next());
    assertEquals(Integer.valueOf(10),i.next());
    assertFalse(i.hasNext());
  }
  
//  @Test
//  public void listTest() {
//    List<Integer> l=as.list(1,2,3,4,5,6,7,8,9,10);
////    assertEquals(IntStream.range(1,11).boxed().collect(Collectors.toList()),as.list(1,2,3,4,5,6,7,8,9,10));
//    assertEquals(IntStream.range(1,11).boxed().collect(Collectors.toList()),l);
//
//  }
  
  @Test
  public void emptyListTest() {
    Iterable<Integer> i=null;
    assertEquals(new ArrayList(),as.list(i));
  }
 
  
  @Test
  public void range10IterableTest() {
    List<Integer> l=IntStream.range(1,11).boxed().collect(Collectors.toList());
    Iterable<Integer> i=l;
    assertEquals(l,as.list(i));
  }
  
  @Test
  public void rangeA2zListTest() {
    assertEquals(IntStream.range(0, 26).mapToObj(x->(String.valueOf(((char)(x+'A'))))).collect(Collectors.toList()),as.list("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
  }
  
  @Test 
  public void setOf123Test() {
    Set<Integer> s=new HashSet<Integer>();
    s.add(1);
    s.add(2);
    s.add(3);
    
    assertEquals(s,as.set(1,1,2,3,2,3,1,2,3));
  }
  
  @Test
  public void nullStringTest() {
    assertEquals("null",as.string(null));
  }
  
  @Test
  public void objectStringTest() {
    Object o=new Object();
    assertEquals(o.toString(),as.string(o));
  }
  
  @Test
  public void charAsStringTest() {
    assertEquals("A",as.string('A')) ;
  }
  
  @Test
  public void nullAsStringTest() {
    String s=null;
    assertEquals("null",as.string(s));
  }
  
  @Test
  public void StringasStringTest() {
    assertEquals("hello world",as.string("hello world"));
  }
  
  @Test 
  public void iterableAsStringTest() {
    List<Integer> l=IntStream.range(1, 11).boxed().collect(Collectors.toList());
    assertEquals(l.toString(),as.string(l));
  }
}

