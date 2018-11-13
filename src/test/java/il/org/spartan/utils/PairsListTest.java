package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class PairsListTest {
  @SuppressWarnings("static-method") @Test public void test() {
    PairsList p = new PairsList();
    p.record(1.1,2.2);
    azzert.that(p.contains(1.1,2.2), azzert.is(true));
  }
}
