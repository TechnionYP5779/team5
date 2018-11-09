package il.org.spartan;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.*;
import il.org.spartan.Utils.FoundHandleForT.*;

public class UtilsTest {
  static final Integer i = null;
  
  @Test @SuppressWarnings("static-method") public void addTest() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(Integer.valueOf(5));
    Utils.add(a, Integer.valueOf(5));
    azzert.that(a.size(), azzert.is(2));
    ArrayList<Integer> b = new ArrayList<>();
    b.add(null);
    b.add(Integer.valueOf(5));
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
                @Override @SuppressWarnings("boxing") public Integer next() {
                  return current++;
                }
            };
        }
    };
}
  
  
  @Test @SuppressWarnings("static-method") public void addAllTest() {
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> b = new ArrayList<>();
    b.add(Integer.valueOf(5));
    azzert.that(a.size(), azzert.is(0));
    Utils.addAll(a, b);
    azzert.that(a.size(), azzert.is(1));
    Utils.addAll(a, Integer.valueOf(5));
    azzert.that(a.size(), azzert.is(2));
    Utils.addAll(a, i);
    azzert.that(a.size(), azzert.is(2));
    Utils.addAll(a, range(3, 5));
    azzert.that(a.size(), azzert.is(4));
  }
  
  @Test @SuppressWarnings({ "static-method", "null" }) public void appendTest() {
    azzert.that(Utils.append(new Integer[10], Integer.valueOf(5))[10], azzert.is(5));
  }
  
  @Test @SuppressWarnings("static-method") public void canBeNullTest() {
    azzert.that(Utils.canBeNull(Integer.valueOf(5)), azzert.is(5));
  }
  
  @Test @SuppressWarnings("static-method") public void cantBeNullTest() {
    azzert.that(Utils.cantBeNull(Integer.valueOf(5)), azzert.is(5));
  }
  
  @Test @SuppressWarnings("static-method") public void compareTest() {
    azzert.that(Utils.compare(false, false), azzert.is(0));
    azzert.that(Utils.compare(false, true), azzert.is(-1));
    azzert.that(Utils.compare(true, true), azzert.is(0));
    azzert.that(Utils.compare(true, false), azzert.is(1));
  }
  
  @Test @SuppressWarnings("static-method") public void compressSpacesTest() {
    azzert.that(Utils.compressSpaces("Lior Has A  Lot Courses"), azzert.is("Lior Has A Lot Courses"));
  }
  
  @Test @SuppressWarnings("static-method") public void containsTest() {
    azzert.that(Utils.contains("Lior Has A Lot Courses", "Courses"), azzert.is(true));
    azzert.that(Utils.contains("Lior Has A Lot Courses", "Dourses"), azzert.is(false));
    azzert.that(Utils.contains("Lior Has A Lot Courses", (String) null), azzert.is(false));
  }
  
  @Test @SuppressWarnings({ "static-method", "boxing", "null" }) public void deleteTest() {
    Integer[] Arr = new Integer[3];
    Arr[0]=0;
    Arr[1]=1;
    Arr[2]=2;
    azzert.that(Arr[1], azzert.is(1));
    Arr = Utils.delete(Arr, 1);
    azzert.that(Arr[1], azzert.is(2));
  }
  
  @Test @SuppressWarnings("static-method") public void hasNullTest() {
    Integer x = Integer.valueOf(5);
    azzert.that(Utils.hasNull(x), azzert.is(false));
    x =null;
    azzert.that(Utils.hasNull(x), azzert.is(true));
  }
  
  @Test @SuppressWarnings({ "static-method", "null" }) public void foundTest() {
    FoundHandleForInt f = Utils.found(5);
    azzert.that(f.candidate, azzert.is(5));
    azzert.that(f.in(5), azzert.is(true));
    azzert.that(f.in(7), azzert.is(false));
    FoundHandleForT<Integer> g = Utils.found(Integer.valueOf(6));
    azzert.that(g.candidate, azzert.is(6));
    azzert.that(g.in(Integer.valueOf(6)), azzert.is(true));
    azzert.that(g.in(Integer.valueOf(7)), azzert.is(false));
    azzert.that(g.in(i), azzert.is(false));
  }
  
  
  @Test @SuppressWarnings("static-method") public void inRangeTest() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(Integer.valueOf(2));
    a.add(Integer.valueOf(2));
    azzert.that(Utils.inRange(0, a), azzert.is(true));
    azzert.that(Utils.inRange(1, a), azzert.is(true));
    azzert.that(Utils.inRange(2, a), azzert.is(false));
    azzert.that(Utils.inRange(3, a), azzert.is(false));
    azzert.that(Utils.inRange(-1, a), azzert.is(false));
  }
  
  @Test @SuppressWarnings("static-method") public void lastTest() {
    ArrayList<Integer> a = new ArrayList<>();
    Integer x2 = Integer.valueOf(2);
    Integer x3 = Integer.valueOf(3);
    a.add(x2);
    a.add(x3);
    azzert.that(Utils.lastIn(x3, a),azzert.is(true));
    azzert.that(Utils.lastIn(x2, a),azzert.is(false));
  }
  
  @Test @SuppressWarnings("static-method") public void intIsInTest() {
    int[] a = new int[3];
    a[0]=0;
    a[1]=1;
    a[2]=2;
    azzert.that(Utils.intIsIn(2, a) ,azzert.is(true));
    azzert.that(Utils.intIsIn(3, a) ,azzert.is(false));
  }
  
  @Test @SuppressWarnings("static-method") public void mustBeNullTest() {
    azzert.that(Utils.mustBeNull(null) ,azzert.is((Void)null));
  }
  
  @Test @SuppressWarnings("static-method") public void runUtilsTests() {
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
  
  @Test @SuppressWarnings("static-method") public void nameTest() {
    azzert.that(Utils.name(new File("File1")) ,azzert.is("File1"));
  }
  
  @Test @SuppressWarnings({ "static-method", "null" }) public void penultimateInTest() {
    ArrayList<Integer> a = new ArrayList<>();
    Integer x2 = Integer.valueOf(2);
    Integer x3 = Integer.valueOf(3);
    a.add(x2);
    a.add(x3);
    azzert.that(Utils.penultimateIn(x2, a),azzert.is(true));
    azzert.that(Utils.penultimateIn(x3, a),azzert.is(false));
  }
  
  @Test @SuppressWarnings("static-method") public void prependTest() {
    StringBuilder s = Utils.prepend(new StringBuilder(), 'c');
    azzert.that(s.charAt(0), azzert.is('c'));
    s = Utils.prepend(s, "str");
    azzert.that(s.charAt(0), azzert.is('s'));
  }
  
  @Test @SuppressWarnings("static-method") public void quoteTest() {
    azzert.that(Utils.quote("Lior"),azzert.is("\'Lior\'"));
    azzert.that(Utils.quote(null),azzert.is("<null reference>"));
  }
  
  @Test @SuppressWarnings("static-method") public void removeTests() {
    ArrayList<Integer> a = new ArrayList<>();
    Integer x2 = Integer.valueOf(2);
    Integer x3 = Integer.valueOf(2);
    a.add(x2);
    a.add(x3);
    Utils.removeDuplicates(a);
    azzert.that(a.size(),azzert.is(1));
    azzert.that(Utils.removePrefix("LiorL", "L"),azzert.is("iorL"));
    azzert.that(Utils.removeSuffix("LiorL", "L"),azzert.is("Lior"));
    azzert.that(Utils.removeWhites("Lior Ben Yamin"),azzert.is("LiorBenYamin"));
  }
  
  @Test @SuppressWarnings("static-method") public void sortTest() {
    int[] arr = Utils.sort(new int[] { 3, 2, 4, 1, 5 });
    azzert.that(arr[0],azzert.is(1));
    azzert.that(arr[1],azzert.is(2));
    azzert.that(arr[2],azzert.is(3));
    azzert.that(arr[3],azzert.is(4));
    azzert.that(arr[4],azzert.is(5));
  }
  
  @Test @SuppressWarnings("static-method") public void sqrTest() {
    azzert.that(Utils.sqr(4.0),azzert.is(16.0));
  }
  
  @Test @SuppressWarnings("static-method") public void suffixedByTest() {
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
