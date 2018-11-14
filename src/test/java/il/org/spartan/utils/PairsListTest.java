package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PairsListTest {
  @Test public void record() {
    PairsList p = new PairsList();
    p.record(1.1,2.2);
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
  
  @Test public void statistics0() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.max(), azzert.is(new Pair<>(box.box(10.0),box.box(20.0))));
    azzert.that(p.min(), azzert.is(new Pair<>(box.box(1.0),box.box(11.0))));
    azzert.that(p.size(), azzert.is(10));
  }
  
  @Test public void statistics1() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.mean("X"), azzert.is(5.5));
    azzert.that(p.mean("Y"), azzert.is(15.5));
  }
  
  @Test public void statistics20() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.median("X"), azzert.is(5.5));
    azzert.that(p.median("Y"), azzert.is(15.5));
  }
  
  @Test public void statistics21() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.firstQuarter("X"), azzert.is(3.5));
    azzert.that(p.firstQuarter("Y"), azzert.is(13.5));
  }
  
  @Test public void statistics22() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.thirdQuarter("X"), azzert.is(8.5));
    azzert.that(p.thirdQuarter("Y"), azzert.is(18.5));
  }
  
  @Test public void statistics3() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.variance("X"), azzert.is(9.166666666666664));
    azzert.that(p.variance("Y"), azzert.is(9.166666666666629));
  }
  
  @Test public void statistics4() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.sum("X"), azzert.is(55.0));
    azzert.that(p.sum("Y"), azzert.is(155.0));
  }
  
  @Test public void statistics5() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.squaresSum("X"), azzert.is(385.0));
    azzert.that(p.squaresSum("Y"), azzert.is(2485.0));

  }
  
  @Test public void statistics6() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.sd("X"), azzert.is(Math.sqrt(9.166666666666664)));
    azzert.that(p.sd("Y"), azzert.is(Math.sqrt(9.166666666666629)));
  }
  
  @Test public void statistics7() {
    PairsList p = new PairsList();
    for(int ¢=0;¢<10;¢++) 
      p.record(10.0-¢, 20.0-¢);
    azzert.that(p.orderStatistic(1), azzert.is(new Pair<>(box.box(1.0),box.box(11.0))));
    azzert.that(p.orderStatistic(2), azzert.is(new Pair<>(box.box(2.0),box.box(12.0))));
    azzert.that(p.orderStatistic(3), azzert.is(new Pair<>(box.box(3.0),box.box(13.0))));
    azzert.that(p.orderStatistic(4), azzert.is(new Pair<>(box.box(4.0),box.box(14.0))));
    azzert.that(p.orderStatistic(5), azzert.is(new Pair<>(box.box(5.0),box.box(15.0))));
    azzert.that(p.orderStatistic(6), azzert.is(new Pair<>(box.box(6.0),box.box(16.0))));
    azzert.that(p.orderStatistic(7), azzert.is(new Pair<>(box.box(7.0),box.box(17.0))));
    azzert.that(p.orderStatistic(8), azzert.is(new Pair<>(box.box(8.0),box.box(18.0))));
    azzert.that(p.orderStatistic(9), azzert.is(new Pair<>(box.box(9.0),box.box(19.0))));
    azzert.that(p.orderStatistic(10), azzert.is(new Pair<>(box.box(10.0),box.box(20.0))));
  }
}
