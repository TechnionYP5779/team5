package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class PairsListTest {
  @SuppressWarnings("static-method") @Test public void record() {
    final PairsList p = new PairsList();
    p.record(1.1, 2.2);
    // System.out.println(p.l.get(0).p + "");
    azzert.that(p.contains(1.1, 2.2), azzert.is(true));
  }

  @SuppressWarnings({ "static-method", "boxing" }) @Test public void sort() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    p.sortAsc();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      azzert.that(p.l.get(¢ - 1).p.equals(new Pair<>(1. * ¢, 1. * (¢ + 10))), azzert.is(true));
    p.sortDesc();
    for (int ¢ = 0; ¢ < 10; ¢++)
      azzert.that(p.l.get(¢).p.equals(new Pair<>(10.0 - ¢, 20.0 - ¢)), azzert.is(true));
  }

  @SuppressWarnings({ "static-method", "boxing" }) @Test public void statistics() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.max(), azzert.is(new Pair<>(10.0, 20.0)));
    azzert.that(p.min(), azzert.is(new Pair<>(1.0, 11.0)));
    azzert.that(p.size(), azzert.is(10));
    azzert.that(p.mean("X"), azzert.is(5.5));
    azzert.that(p.mean("Y"), azzert.is(15.5));
    azzert.that(p.median("X"), azzert.is(5.5));
    azzert.that(p.median("Y"), azzert.is(15.5));
    azzert.that(p.variance("X"), azzert.is(9.166666666666664));
    azzert.that(p.variance("Y"), azzert.is(9.166666666666629));
    azzert.that(p.squaresSum("X"), azzert.is(385.0));
    azzert.that(p.squaresSum("Y121"), azzert.is(2485.0));
  }
}
