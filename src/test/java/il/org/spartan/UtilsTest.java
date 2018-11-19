package il.org.spartan;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.*;
import il.org.spartan.Utils.FoundHandleForT.*;

@SuppressWarnings("static-method") public class UtilsTest {
  static final Integer i = null;

  @Test public void addTest() {
    final ArrayList<Integer> a = new ArrayList<>();
    a.add(box.it(5));
    Utils.add(a, box.it(5));
    azzert.that(a.size(), is(2));
    final ArrayList<Integer> b = new ArrayList<>();
    b.add(null);
    b.add(box.it(5));
    Utils.add(a, b);
    azzert.that(a.size(), is(3));
    Utils.add(a, i);
    azzert.that(a.size(), is(3));
  }

  static Iterable<Integer> range(final int from, final int to) {
    return () -> new Iterator<Integer>() {
      int current = from;

      @Override public boolean hasNext() {
        return current < to;
      }

      @Override public Integer next() {
        return box.it(current++);
      }
    };
  }

  @Test public void addAllTest() {
    final ArrayList<Integer> a = new ArrayList<>();
    final ArrayList<Integer> b = new ArrayList<>();
    b.add(box.it(5));
    azzert.that(a.size(), is(0));
    Utils.addAll(a, b);
    azzert.that(a.size(), is(1));
    Utils.addAll(a, box.it(5));
    azzert.that(a.size(), is(2));
    Utils.addAll(a, i);
    azzert.that(a.size(), is(2));
    Utils.addAll(a, range(3, 5));
    azzert.that(a.size(), is(4));
  }

  @Test public void appendTest() {
    final int[] arr = new int[10];
    azzert.that(Utils.append(box.it(arr), box.it(5))[10], is(5));
  }

  @Test public void canBeNullTest() {
    azzert.that(Utils.canBeNull(box.it(5)), is(5));
  }

  @Test public void cantBeNullTest() {
    azzert.that(Utils.cantBeNull(box.it(5)), is(5));
  }

  @Test public void compareTest() {
    azzert.that(Utils.compare(false, false), is(0));
    azzert.that(Utils.compare(false, true), is(-1));
    azzert.that(Utils.compare(true, true), is(0));
    azzert.that(Utils.compare(true, false), is(1));
  }

  @Test public void compressSpacesTest() {
    azzert.that(Utils.compressSpaces("Lior Has A  Lot Courses"), is("Lior Has A Lot Courses"));
  }

  @Test public void containsTest() {
    assert Utils.contains("Lior Has A Lot Courses", "Courses");
    assert !Utils.contains("Lior Has A Lot Courses", "Dourses");
    assert !Utils.contains("Lior Has A Lot Courses", (String) null);
  }

  @Test public void deleteTest() {
    Integer[] Arr = new Integer[3];
    Arr[0] = box.it(0);
    Arr[1] = box.it(1);
    Arr[2] = box.it(2);
    azzert.that(Arr[1], is(1));
    Arr = Utils.delete(Arr, 1);
    azzert.that(Arr[1], is(2));
  }

  @Test public void hasNullTest() {
    Integer x = box.it(5);
    assert !Utils.hasNull(x);
    x = null;
    assert Utils.hasNull(x);
  }

  @Test public void foundTest() {
    final FoundHandleForInt f = Utils.found(5);
    azzert.that(f.candidate, is(5));
    assert f.in(5);
    assert !f.in(7);
    final FoundHandleForT<Integer> g = Utils.found(box.it(6));
    azzert.that(g.candidate, is(6));
    assert g.in(box.it(6));
    assert !g.in(box.it(7));
    assert !g.in(i);
  }

  @Test public void inRangeTest() {
    final ArrayList<Integer> a = new ArrayList<>();
    a.add(box.it(2));
    a.add(box.it(2));
    assert Utils.inRange(0, a);
    assert Utils.inRange(1, a);
    assert !Utils.inRange(2, a);
    assert !Utils.inRange(3, a);
    assert !Utils.inRange(-1, a);
  }

  @Test public void lastTest() {
    final ArrayList<Integer> a = new ArrayList<>();
    final Integer x2 = box.it(2);
    final Integer x3 = box.it(3);
    a.add(x2);
    a.add(x3);
    assert Utils.lastIn(x3, a);
    assert !Utils.lastIn(x2, a);
  }

  @Test public void intIsInTest() {
    final int[] a = new int[3];
    a[0] = 0;
    a[1] = 1;
    a[2] = 2;
    assert Utils.intIsIn(2, a);
    assert !Utils.intIsIn(3, a);
  }

  @Test public void mustBeNullTest() {
    azzert.that(Utils.mustBeNull(null), is((Void) null));
  }

  @Test public void runUtilsTests() {
    final TEST t = new TEST();
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
    azzert.that(Utils.name(new File("File1")), is("File1"));
  }

  @Test public void penultimateInTest() {
    final ArrayList<Integer> a = new ArrayList<>();
    final Integer x2 = box.it(2);
    final Integer x3 = box.it(3);
    a.add(x2);
    a.add(x3);
    assert Utils.penultimateIn(x2, a);
    assert !Utils.penultimateIn(x3, a);
  }

  @Test public void prependTest() {
    StringBuilder s = Utils.prepend(new StringBuilder(), 'c');
    azzert.that(s.charAt(0), is('c'));
    s = Utils.prepend(s, "str");
    azzert.that(s.charAt(0), is('s'));
  }

  @Test public void quoteTest() {
    azzert.that(Utils.quote("Lior"), is("\'Lior\'"));
    azzert.that(Utils.quote(null), is("<null reference>"));
  }

  @Test public void removeTests() {
    final ArrayList<Integer> a = new ArrayList<>();
    final Integer x2 = box.it(2);
    final Integer x3 = box.it(2);
    a.add(x2);
    a.add(x3);
    Utils.removeDuplicates(a);
    azzert.that(a.size(), is(1));
    azzert.that(Utils.removePrefix("LiorL", "L"), is("iorL"));
    azzert.that(Utils.removeSuffix("LiorL", "L"), is("Lior"));
    azzert.that(Utils.removeWhites("Lior Ben Yamin"), is("LiorBenYamin"));
  }

  @Test public void sortTest() {
    final int[] arr = Utils.sort(new int[] { 3, 2, 4, 1, 5 });
    azzert.that(arr[0], is(1));
    azzert.that(arr[1], is(2));
    azzert.that(arr[2], is(3));
    azzert.that(arr[3], is(4));
    azzert.that(arr[4], is(5));
  }

  @Test public void sqrTest() {
    azzert.that(Utils.sqr(4.0), is(16.0));
  }

  @Test public void suffixedByTest() {
    final File f = new File("file1");
    final File g = new File("file2");
    final ArrayList<String> slist = new ArrayList<>();
    slist.add("suf1");
    slist.add("e1");
    assert Utils.suffixedBy(f, slist);
    assert !Utils.suffixedBy(g, slist);
    assert Utils.suffixedBy(g, "e2");
    assert !Utils.suffixedBy("file1", "e2");
  }
}
