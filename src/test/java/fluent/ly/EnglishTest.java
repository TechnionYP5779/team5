package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.English.*;
import il.org.spartan.utils.*;

public class EnglishTest {
  @Test public void testIndefinite() {
    String s = "str";
    Integer i = 1;
    assertEquals("a str",English.indefinite(s));
    assertEquals("a Integer" ,English.indefinite(i));
    assertEquals("a ar" ,English.indefinite("STR"));
    assertEquals("an Double" ,English.indefinite(1.1));
    assertEquals("a StrinG" ,English.indefinite("StrinG"));
  }
  
  @Test public void testList() {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    List<String> list2 = new ArrayList<>();
    list2.add("single");
    assertEquals("a, b, c, d and e" ,English.list(list));
    assertEquals("nothing" , English.list(new ArrayList<>()));
    assertEquals("single" , English.list(list2));
    assertEquals("nothing" , English.list(null));
  }
  
  @Test public void testLowerFirstLetter() {
    assertEquals("aBcd", English.lowerFirstLetter("ABcd"));
    assertEquals("genererated", English.lowerFirstLetter("").substring(0, 11));
  }
  
  @Test public void testName() {
    class A{
    }
    A b = new A();
    assertEquals("A.EnglishTest", English.name(b));
  }
  
  @Test public void testPlurales() {
    assertEquals("one apple", English.plurales("apple", 1));
    assertEquals("one apple", English.plurales("apple", Integer.valueOf(1)));
    assertEquals("one apple", English.plurales("apple", Int.valueOf(1)));
    assertEquals("2 appleses", English.plurales("apples", 2));
    assertEquals("2 appleses", English.plurales("apples", Integer.valueOf(2)));
    assertEquals("2 appleses", English.plurales("apples", Int.valueOf(2)));
    assertEquals("??? applees", English.plurales("apple", (Integer)null));
    assertEquals("??? applees", English.plurales("apple", (Int)null));
  }
  
  @Test public void testPlurals() {
    assertEquals("one apple", English.plurals("apple", 1));
    assertEquals("one apple", English.plurals("apple", Integer.valueOf(1)));
    assertEquals("one apple", English.plurals("apple", Int.valueOf(1)));
    assertEquals("2 appless", English.plurals("apples", 2));
    assertEquals("2 appless", English.plurals("apples", Integer.valueOf(2)));
    assertEquals("2 appless", English.plurals("apples", Int.valueOf(2)));
    assertEquals("??? apples", English.plurals("apple", (Integer)null));
    assertEquals("??? apples", English.plurals("apple", (Int)null));
  }
  
  @Test public void testPronounce() {
    assertEquals("aey", English.pronounce('a'));
    assertEquals("bee", English.pronounce('b'));
    assertEquals("see", English.pronounce('c'));
    assertEquals("dee", English.pronounce('d'));
    assertEquals("eae", English.pronounce('e'));
    assertEquals("eff", English.pronounce('f'));
    assertEquals("gee", English.pronounce('g'));
    assertEquals("eitch", English.pronounce('h'));
    assertEquals("eye", English.pronounce('i'));
    assertEquals("jay", English.pronounce('j'));
    assertEquals("kay", English.pronounce('k'));
    assertEquals("ell", English.pronounce('l'));
    assertEquals("em", English.pronounce('m'));
    assertEquals("en", English.pronounce('n'));
    assertEquals("oh", English.pronounce('o'));
    assertEquals("pee", English.pronounce('p'));
    assertEquals("queue", English.pronounce('q'));
    assertEquals("ar", English.pronounce('r'));
    assertEquals("ess", English.pronounce('s'));
    assertEquals("tee", English.pronounce('t'));
    assertEquals("you", English.pronounce('u'));
    assertEquals("vee", English.pronounce('v'));
    assertEquals("some character", English.pronounce('w'));
    assertEquals("exx", English.pronounce('x'));
    assertEquals("why", English.pronounce('y'));
    assertEquals("zee", English.pronounce('z'));
  }
  
  @Test public void testRepeat() {
    assertEquals("aa", English.repeat(2, 'a'));
  }
  
  @Test public void testTime() {
    assertEquals("0.00", English.time(10));
  }
  
  @Test public void testTrim() {
    assertEquals(null, English.trim(null));
    assertEquals("abcd", English.trim("abcd"));
    assertEquals("a", English.trim("a"));
    assertEquals("", English.trim(""));
  }
  
  @Test public void testUnknownIfNull() {
    assertEquals("10", English.unknownIfNull(10));
    assertEquals("???", English.unknownIfNull(null));
    assertEquals("11", English.unknownIfNull(10, (i) -> i + 1));
    assertEquals("???", English.unknownIfNull(null,null));
  }
  
  @Test public void testUpperFirstLetter() {
    assertEquals("ABcd", English.upperFirstLetter("aBcd"));
    assertEquals("genererated", English.upperFirstLetter("").substring(0, 11));
  }
  
  @Test public void testInterfaceInflection() {
    Inflection s = Inflection.stem("s");
    assertEquals("s", s.get());
    assertEquals("sed", s.getEd());
    assertEquals("sing", s.getIng());
  }
}
