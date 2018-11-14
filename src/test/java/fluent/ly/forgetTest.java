package fluent.ly;

import org.junit.*;

import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class forgetTest {
  @Test  public void test_all() {
    forget.all(new Pair<>(box.box(1), box.box(2)), new Pair<>(box.box(1), box.box(2)), new Pair<>(box.box(1), box.box(2)), new Pair<>(box.box(1), box.box(2)));
    forget.all(new Pair<>(box.box(1),box.box(2)));
    forget.all(new String(), new Pair<>(box.box(1), box.box(2)), new Pair<>(box.box(1), box.box(2)), new Pair<>(box.box(1), box.box(2)));
    forget.all(new String());
    forget.all(new String(), new Pair<>(box.box(1), box.box(2)), new Pair<>(box.box(1), box.box(2)), "varargs");
  }

  @Test public void test_it() {
    forget.it(true);
    forget.it(false);
    forget.it(81);
    forget.it(79.99999999);
    forget.it(Double.MAX_VALUE);
    forget.it(Double.MIN_VALUE);
    forget.it(Long.MAX_VALUE);
    forget.it(new Pair<>(box.box(1), box.box(2)));
    forget.it(Long.MAX_VALUE);
  }

  @Test public void test_last() {
    /**
     *
     */
  }
}
