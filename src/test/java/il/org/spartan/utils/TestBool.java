package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TestBool {
  @Test public void testValueOf() {
    assert Bool.valueOf(true).get();
  }

  @Test public void testClear() {
    final Bool b = new Bool(true);
    b.clear();
    assert !b.get();
  }

  @Test public void testSet() {
    final Bool b = new Bool(true);
    b.set(false);
    assert !b.get();
    b.set();
    assert b.get();
  }

  @SuppressWarnings("null") @Test public void testInner() {
    assert unbox.unbox(Bool.valueOf(true).inner());
    assert !unbox.unbox(Bool.valueOf(false).inner());
  }

  @SuppressWarnings("null") @Test public void testEmptyConst() {
    assert !new Bool().get();
    assert !unbox.unbox(Bool.valueOf(false).inner());
  }
}
