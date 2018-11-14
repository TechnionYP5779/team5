package fluent.ly;

import org.junit.*;

import il.org.spartan.utils.*;

public class forgetTest {
  @Test @SuppressWarnings({ "static-method", "boxing" }) public void test_all() {
    forget.all(new Pair<>(1, 2), new Pair<>(1, 2), new Pair<>(1, 2), new Pair<>(1, 2));
    forget.all(new Pair<>(1, 2));
    forget.all(new String(), new Pair<>(1, 2), new Pair<>(1, 2), new Pair<>(1, 2));
    forget.all(new String());
    forget.all(new String(), new Pair<>(1, 2), new Pair<>(1, 2), "varargs");
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void test_it() {
    forget.it(true);
    forget.it(false);
    forget.it(81);
    forget.it(79.99999999);
    forget.it(Double.MAX_VALUE);
    forget.it(Double.MIN_VALUE);
    forget.it(Long.MAX_VALUE);
    forget.it(new Pair<>(1, 2));
    forget.it((Object) Long.MAX_VALUE);
  }

  @Test public void test_last() {
    /**
     *
     */
  }
}
