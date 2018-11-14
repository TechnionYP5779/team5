package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class PairsListTest {
  @SuppressWarnings("static-method") @Test public void record() {
    PairsList p = new PairsList();
    p.record(1.1,2.2);
//    System.out.println(p.l.get(0).p + "");
    azzert.that(p.contains(1.1,2.2), azzert.is(true));
  }
  
  @SuppressWarnings({ "static-method", "boxing" }) @Test public void sort() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++)
      p.record(10.0-¢, 20.0-¢);
    p.sortAsc();
    for(int ¢=1;¢<=10;¢++)
      azzert.that(p.l.get(¢ - 1).p.equals(new Pair<>(1. * ¢, 1. * (¢ + 10))), azzert.is(true));
    p.sortDesc();
    for(int ¢=0;¢<10;¢++)
      azzert.that(p.l.get(¢).p.equals(new Pair<>(10.0 - ¢, 20.0 - ¢)), azzert.is(true));
  }
  
  @SuppressWarnings({ "static-method", "boxing" }) @Test public void statistics() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++)
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.max(), azzert.is(new Pair<>(10.0,20.0)));
    azzert.that(p.min(), azzert.is(new Pair<>(1.0,11.0)));
    azzert.that(p.size(), azzert.is(10));

  }
}
