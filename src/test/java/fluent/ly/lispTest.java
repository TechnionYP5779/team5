package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class lispTest {
  @Test public void chop1() {
    List<Integer> l = new ArrayList<>();
    azzert.that(null, azzert.is(lisp.chop(l)));
  }

  @Test public void chop2() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    l1.add(box.box(1));
    for (int ¢ = 2; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢));
    }
    azzert.that(lisp.chop(l1), azzert.is(l2));
  }

  @Test public void cons() {
    ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(box.box(0), box.box(1))), l2 = new ArrayList<>(Arrays.asList(box.box(1)));
    assert l2 != null;
    for (int ¢ = 2; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢));
    }
    azzert.that(lisp.cons(box.box(0), l2), azzert.is(l1));
  }

  @Test public void next1() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(lisp.next(0, l1), azzert.is(box.box(2)));
  }

  @Test public void next2() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(lisp.next(11, l1), azzert.is(10));
  }

  @Test public void get1() {
    assert lisp.get(null, 0) == null;
  }

  /** warning! not protected against out-of-bound index **/
  @Test public void get2() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(lisp.get(l1, 2), azzert.is(4));
  }

  @Test public void prev1() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(lisp.prev(2, l1), azzert.is(2));
  }

  @Test public void prev2() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(lisp.prev(0, l1), azzert.is(1));
    azzert.that(lisp.prev(-7, l1), azzert.is(1));
  }

  @Test public void replace1() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(null, azzert.is(lisp.replace(null, box.box(1), 2)));
  }

  @Test public void replace2() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(l1, azzert.is(lisp.replace(l1, box.box(1), -1)));
    azzert.that(l1, azzert.is(lisp.replace(l1, box.box(1), 20)));
  }

  @Test public void replace3() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢ == 4 ? 7 : ¢));
    }
    azzert.that(l2, azzert.is(lisp.replace(l1, box.box(7), 3)));
  }

  @Test public void replaceFirst() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢ == 1 ? 7 : ¢));
    }
    azzert.that(l2, azzert.is(lisp.replaceFirst(l1, box.box(7))));
  }

  @Test public void replaceLast() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢ == 10 ? 7 : ¢));
    }
    azzert.that(l2, azzert.is(lisp.replaceLast(l1, box.box(7))));
  }

  @Test public void rest2() {
    ArrayList<Integer> l1 = new ArrayList<>();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      l1.add(box.box(¢));
    azzert.that(box.box(3), azzert.is(lisp.rest2(l1).iterator().next()));
  }

  @Test public void areEqual() {
    assert lisp.areEqual(box.box(4), box.box(4), box.box(4), box.box(4), box.box(4));
    assert !lisp.areEqual(box.box(4), null, box.box(4), box.box(4), box.box(4), box.box(4));
  }

  @Test public void chopLast1() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 2; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢));
    }
    l1.add(box.box(10));
    azzert.that(lisp.chopLast(l1), azzert.is(l2));
  }

  @Test public void chopLast2() {
    azzert.that(lisp.chopLast("ddddd"), azzert.is("dddd"));
    azzert.that(lisp.chopLast("d"), azzert.is(""));
  }

  @Test public void removeFromList() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 2; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢));
    }
    lisp.removeFromList(l1, l2);
    azzert.that(new ArrayList<Integer>(), azzert.is(l2));
  }

  @Test public void removeLast() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 2; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢));
    }
    l1.add(box.box(11));
    lisp.removeLast(l1);
    azzert.that(l1, azzert.is(l2));
  }

  @Test public void swap1() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 2; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢));
    }
    azzert.that(l1, azzert.is(lisp.swap(l1, 10, 3)));
    azzert.that(l1, azzert.is(lisp.swap(l1, 3, 10)));
    azzert.that(l1, azzert.is(lisp.swap(l1, 10, 10)));
  }

  @Test public void swap2() {
    ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    for (int ¢ = 2; ¢ <= 10; ¢++) {
      l1.add(box.box(¢));
      l2.add(box.box(¢ == 3 ? 7 : ¢ == 7 ? 3 : ¢));
    }
    azzert.that(l1, azzert.is(lisp.swap(l2, 1, 5)));
  }
}
