package il.org.spartan;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.*;
import il.org.spartan.Utils.FoundHandleForT.*;

@SuppressWarnings("static-method") 
public class UtilsTest {
  static final Integer i = null;
  
  @Test public void addTest() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(box.box(5));
    Utils.add(a, box.box(5));
    azzert.that(a.size(), azzert.is(2));
    ArrayList<Integer> b = new ArrayList<>();
    b.add(null);
    b.add(box.box(5));
    Utils.add(a, b);
    azzert.that(a.size(), azzert.is(3));
    Utils.add(a, i);
    azzert.that(a.size(), azzert.is(3));
  }
  
  static Iterable<Integer> range(final int from, final int to) {
    return new Iterable<Integer>() {
        @Override public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int current = from;
                @Override public boolean hasNext() { return current < to; }
                @Override public Integer next() {
                  return box.box(current++) ;
                }
            };
        }
    };
}
  
  
  @Test public void addAllTest() {
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> b = new ArrayList<>();
    b.add(box.box(5));
    azzert.that(a.size(), azzert.is(0));
    Utils.addAll(a, b);
    azzert.that(a.size(), azzert.is(1));
    Utils.addAll(a, box.box(5));
    azzert.that(a.size(), azzert.is(2));
    Utils.addAll(a, i);
    azzert.that(a.size(), azzert.is(2));
    Utils.addAll(a, range(3, 5));
    azzert.that(a.size(), azzert.is(4));
  }
  
  @Test public void appendTest() {
    int[] arr=new int[10];
    azzert.that(Utils.append(box.box(arr), box.box(5))[10], azzert.is(5));
  }
  
  @Test public void canBeNullTest() {
    azzert.that(Utils.canBeNull(box.box(5)), azzert.is(5));
  }
  
  @Test public void cantBeNullTest() {
    azzert.that(Utils.cantBeNull(box.box(5)), azzert.is(5));
  }
  
  @Test public void compareTest() {
    azzert.that(Utils.compare(false, false), azzert.is(0));
    azzert.that(Utils.compare(false, true), azzert.is(-1));
    azzert.that(Utils.compare(true, true), azzert.is(0));
    azzert.that(Utils.compare(true, false), azzert.is(1));
  }
  
  @Test public void compressSpacesTest() {
    azzert.that(Utils.compressSpaces("Lior Has A  Lot Courses"), azzert.is("Lior Has A Lot Courses"));
  }
  
  @Test public void containsTest() {
    azzert.that(Utils.contains("Lior Has A Lot Courses", "Courses"), azzert.is(true));
    azzert.that(Utils.contains("Lior Has A Lot Courses", "Dourses"), azzert.is(false));
    azzert.that(Utils.contains("Lior Has A Lot Courses", (String) null), azzert.is(false));
  }
  
  @Test public void deleteTest() {
    Integer[] Arr = new Integer[3];
    Arr[0]=box.box(0);
    Arr[1]=box.box(1);
    Arr[2]=box.box(2);
    azzert.that(Arr[1], azzert.is(1));
    Arr = Utils.delete(Arr, 1);
    azzert.that(Arr[1], azzert.is(2));
  }
  
  @Test public void hasNullTest() {
    Integer x = box.box(5);
    azzert.that(Utils.hasNull(x), azzert.is(false));
    x =null;
    azzert.that(Utils.hasNull(x), azzert.is(true));
  }
  
  @Test public void foundTest() {
    FoundHandleForInt f = Utils.found(5);
    azzert.that(f.candidate, azzert.is(5));
    azzert.that(f.in(5), azzert.is(true));
    azzert.that(f.in(7), azzert.is(false));
    FoundHandleForT<Integer> g = Utils.found(box.box(6));
    azzert.that(g.candidate, azzert.is(6));
    azzert.that(g.in(box.box(6)), azzert.is(true));
    azzert.that(g.in(box.box(7)), azzert.is(false));
    azzert.that(g.in(i), azzert.is(false));
  }
  
  
  @Test public void inRangeTest() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(box.box(2));
    a.add(box.box(2));
    azzert.that(Utils.inRange(0, a), azzert.is(true));
    azzert.that(Utils.inRange(1, a), azzert.is(true));
    azzert.that(Utils.inRange(2, a), azzert.is(false));
    azzert.that(Utils.inRange(3, a), azzert.is(false));
    azzert.that(Utils.inRange(-1, a), azzert.is(false));
  }
  
  @Test public void lastTest() {
    ArrayList<Integer> a = new ArrayList<>();
    Integer x2 = box.box(2);
    Integer x3 = box.box(3);
    a.add(x2);
    a.add(x3);
    azzert.that(Utils.lastIn(x3, a),azzert.is(true));
    azzert.that(Utils.lastIn(x2, a),azzert.is(false));
  }
  
  @Test public void intIsInTest() {
    int[] a = new int[3];
    a[0]=0;
    a[1]=1;
    a[2]=2;
    azzert.that(Utils.intIsIn(2, a) ,azzert.is(true));
    azzert.that(Utils.intIsIn(3, a) ,azzert.is(false));
  }
  
  @Test public void mustBeNullTest() {
    azzert.that(Utils.mustBeNull(null) ,azzert.is((Void)null));
  }
  
  @Test public void runUtilsTests() {
    TEST t = new TEST();
    t.addAllTypical();
    t.addTypical();
    t.cantBeNullOfNull();
    t.cantBeNullTypical();
    t.isNullTypical();
    t.mustBeNullOfNotNull();
    t.quoteEmptyString();
    t.quoteNull();
    t.quoteSimpleString();
    t.swapDegenerate();
    t.swapTypical();
    t.swapTypicalCase();
  }
  
  @Test public void nameTest() {
    azzert.that(Utils.name(new File("File1")) ,azzert.is("File1"));
  }
  
  @Test public void penultimateInTest() {
    ArrayList<Integer> a = new ArrayList<>();
    Integer x2 = box.box(2);
    Integer x3 = box.box(3);
    a.add(x2);
    a.add(x3);
    azzert.that(Utils.penultimateIn(x2, a),azzert.is(true));
    azzert.that(Utils.penultimateIn(x3, a),azzert.is(false));
  }
  
  @Test public void prependTest() {
    StringBuilder s = Utils.prepend(new StringBuilder(), 'c');
    azzert.that(s.charAt(0), azzert.is('c'));
    s = Utils.prepend(s, "str");
    azzert.that(s.charAt(0), azzert.is('s'));
  }
  
  @Test public void quoteTest() {
    azzert.that(Utils.quote("Lior"),azzert.is("\'Lior\'"));
    azzert.that(Utils.quote(null),azzert.is("<null reference>"));
  }
  
  @Test public void removeTests() {
    ArrayList<Integer> a = new ArrayList<>();
    Integer x2 = box.box(2);
    Integer x3 = box.box(2);
    a.add(x2);
    a.add(x3);
    Utils.removeDuplicates(a);
    azzert.that(a.size(),azzert.is(1));
    azzert.that(Utils.removePrefix("LiorL", "L"),azzert.is("iorL"));
    azzert.that(Utils.removeSuffix("LiorL", "L"),azzert.is("Lior"));
    azzert.that(Utils.removeWhites("Lior Ben Yamin"),azzert.is("LiorBenYamin"));
  }
  
  @Test public void sortTest() {
    int[] arr = Utils.sort(new int[] { 3, 2, 4, 1, 5 });
    azzert.that(arr[0],azzert.is(1));
    azzert.that(arr[1],azzert.is(2));
    azzert.that(arr[2],azzert.is(3));
    azzert.that(arr[3],azzert.is(4));
    azzert.that(arr[4],azzert.is(5));
  }
  
  @Test public void sqrTest() {
    azzert.that(Utils.sqr(4.0),azzert.is(16.0));
  }
  
  @Test public void suffixedByTest() {
    File f = new File("file1");
    File g = new File("file2");
    ArrayList<String> slist = new ArrayList<>();
    slist.add("suf1");
    slist.add("e1");
    azzert.that(Utils.suffixedBy(f, slist), azzert.is(true));
    azzert.that(Utils.suffixedBy(g, slist), azzert.is(false));
    azzert.that(Utils.suffixedBy(g, "e2"), azzert.is(true));
    azzert.that(Utils.suffixedBy("file1", "e2"), azzert.is(false));
  }
  
}
