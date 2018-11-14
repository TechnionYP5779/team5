package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PairsListTest {
  @Test public void record() {
    PairsList p = new PairsList();
    p.record(1.1,2.2);
//    System.out.println(p.l.get(0).p + "");
    azzert.that(p.contains(1.1,2.2), azzert.is(true));
  }
  
  @Test public void sort() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++)
      p.record(10.0-¢, 20.0-¢);
    p.sortAsc();
    for(int ¢=1;¢<=10;¢++)
      azzert.that(p.l.get(¢ - 1).p.equals(new Pair<>(box.box(1. * ¢), box.box(1. * (¢ + 10)))), azzert.is(true));
    p.sortDesc();
    for(int ¢=0;¢<10;¢++)
      azzert.that(p.l.get(¢).p.equals(new Pair<>(box.box(10.0 - ¢), box.box(20.0 - ¢))), azzert.is(true));
  }
  
  @Test public void statistics() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.max(), azzert.is(new Pair<>(box.box(10.0),box.box(20.0))));
    azzert.that(p.min(), azzert.is(new Pair<>(box.box(1.0),box.box(11.0))));
    azzert.that(p.size(), azzert.is(10));
    azzert.that(p.mean("X"), azzert.is(5.5));
    azzert.that(p.mean("Y"), azzert.is(15.5));
    azzert.that(p.median("X"), azzert.is(5.5));
    azzert.that(p.median("Y"), azzert.is(15.5));
    azzert.that(p.variance("X"), azzert.is(9.166666666666664));
    azzert.that(p.variance("Y"), azzert.is(9.166666666666629));
    azzert.that(p.sum("X"), azzert.is(55.0));
    azzert.that(p.sum("Y"), azzert.is(155.0));
    azzert.that(p.squaresSum("X"), azzert.is(385.0));
    azzert.that(p.squaresSum("Y"), azzert.is(2485.0));

  }
}
