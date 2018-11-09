package il.org.spartan;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.*;
import il.org.spartan.Utils.FoundHandleForT.*;
import il.org.spartan.iteration.closures.*;

public class UtilsTest {
  final static Integer i = null;
  
  @SuppressWarnings("static-method") @Test public void addTest() {
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
                @SuppressWarnings("boxing") @Override public Integer next() {
                    return current++;
                }
            };
        }
    };
}
  
  
  @SuppressWarnings("static-method") @Test public void addAllTest() {
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
    Utils.addAll(a, range(3,5));
    azzert.that(a.size(), azzert.is(4));
  }
  
  @SuppressWarnings("static-method") @Test public void appendTest() {
    Integer[] arr = new Integer[10];
    azzert.that(Utils.append(arr,Integer.valueOf(5))[10], azzert.is(5));
  }
  
  @SuppressWarnings("static-method") @Test public void canBeNullTest() {
    azzert.that(Utils.canBeNull(Integer.valueOf(5)), azzert.is(5));
  }
  
  @SuppressWarnings("static-method") @Test public void cantBeNullTest() {
    azzert.that(Utils.cantBeNull(Integer.valueOf(5)), azzert.is(5));
  }
  
  @SuppressWarnings("static-method") @Test public void compareTest() {
    azzert.that(Utils.compare(false, false), azzert.is(0));
    azzert.that(Utils.compare(false, true), azzert.is(-1));
    azzert.that(Utils.compare(true, true), azzert.is(0));
    azzert.that(Utils.compare(true, false), azzert.is(1));
  }
  
  @SuppressWarnings("static-method") @Test public void compressSpacesTest() {
    azzert.that(Utils.compressSpaces("Lior Has A  Lot Courses"), azzert.is("Lior Has A Lot Courses"));
  }
  
  @Test @SuppressWarnings("static-method") public void containsTest() {
    azzert.that(Utils.contains("Lior Has A Lot Courses", "Courses"), azzert.is(true));
    azzert.that(Utils.contains("Lior Has A Lot Courses", "Dourses"), azzert.is(false));
    azzert.that(Utils.contains("Lior Has A Lot Courses", (String) null), azzert.is(false));
  }
  
  @Test @SuppressWarnings("static-method") public void deleteTest() {
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
  
  @Test @SuppressWarnings("static-method") public void foundTest() {
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
  
  
  
  
}
