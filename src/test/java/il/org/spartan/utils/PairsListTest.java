package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.PairsList.*;

@SuppressWarnings("static-method") public class PairsListTest {
  @Test public void record() {
    final PairsList p = new PairsList();
    p.record(1.1, 2.2);
    assert p.contains(1.1, 2.2);
  }

  @Test public void record1() {
    final PairsList p = new PairsList();
    p.record(1.1, 2.2);
    assert !p.contains(1.0, 2.2);
  }

  @Test public void sort1() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    p.sortAsc();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      assert p.l.get(¢ - 1).p.equals(new Pair<>(box.it(1. * ¢), box.it(1. * (¢ + 10))));
  }

  @Test public void sort2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    p.sortDesc();
    for (int ¢ = 0; ¢ < 10; ¢++)
      assert p.l.get(¢).p.equals(new Pair<>(box.it(10.0 - ¢), box.it(20.0 - ¢)));
  }

  @Test public void sort3() {
    final PairsList p = new PairsList();
    p.record(3.1, 1.1);
    p.record(3.1, 1.7);
    p.record(1.1, 1.4);
    p.record(2.1, 1.1);
    p.sortAsc();
    azzert.that(p.l.get(0).p, is(new Pair<>(box.it(1.1), box.it(1.4))));
  }

  @Test public void sort4() {
    final PairsList p = new PairsList();
    p.record(3.1, 1.1);
    p.record(3.1, 1.7);
    p.record(1.1, 1.4);
    p.record(2.1, 1.1);
    p.sortDesc();
    azzert.that(p.l.get(0).p, is(new Pair<>(box.it(3.1), box.it(1.7))));
  }

  @Test public void iter1() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.iterator();
    for (; itr.hasNext(); d++)
      azzert.that(itr.next().p, is(new Pair<>(box.it(d + 1.0), box.it(d + 11.0))));
    azzert.that(itr.next().p, is(new Pair<>(box.it(d + 1.0 - 1), box.it(d + 11.0 - 1))));
    azzert.that(itr.next().p, is(new Pair<>(box.it(d + 1.0 - 1), box.it(d + 11.0 - 1))));
  }

  @Test public void iter2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.iterator();
    for (; itr.hasNext(); d++)
      itr.next();
    azzert.that(itr.next().p, is(new Pair<>(box.it(d + 1.0 - 1), box.it(d + 11.0 - 1))));
  }

  @Test public void iter3() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.iterator();
    for (; itr.hasNext(); d++)
      itr.next();
    itr.next();
    azzert.that(itr.next().p, is(new Pair<>(box.it(d + 1.0 - 1), box.it(d + 11.0 - 1))));
  }

  @Test public void reti1() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.revIterator().iterator();
    for (; itr.hasNext(); d++)
      azzert.that(itr.next().p, is(new Pair<>(box.it(10.0 - d), box.it(20.0 - d))));
  }

  @Test public void reti2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.revIterator();
    for (; itr.hasNext(); d++)
      itr.next();
    azzert.that(itr.next().p, is(new Pair<>(box.it(-d + 10.0 + 1), box.it(-d + 20.0 + 1))));
  }

  @Test public void reti3() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.revIterator();
    for (; itr.hasNext(); d++)
      itr.next();
    itr.next();
    azzert.that(itr.next().p, is(new Pair<>(box.it(-d + 10.0 + 1), box.it(-d + 20.0 + 1))));
  }

  @Test public void statistics0() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.max(), is(new Pair<>(box.it(10.0), box.it(20.0))));
  }

  @Test public void statistics01() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.min(), is(new Pair<>(box.it(1.0), box.it(11.0))));
  }

  @Test public void statistics02() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.size(), is(10));
  }

  @Test public void statistics03() {
    assert new PairsList().max() == null;
  }

  @Test public void statistics04() {
    assert new PairsList().min() == null;
  }

  @Test public void statistics10() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.meanOf("X"), is(5.5));
  }

  @Test public void statistics11() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.meanOf("Y"), is(15.5));
  }

  @Test public void statistics200() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.medianOf("X"), is(5.5));
  }

  @Test public void statistics201() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.medianOf("Y"), is(15.5));
  }

  @Test public void statistics210() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.firstQuarterOf("X"), is(3.5));
  }

  @Test public void statistics211() {
    final PairsList p = new PairsList();
    for (int ¢ = 1; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.firstQuarterOf("Y"), is(13.0));
  }

  @Test public void statistics220() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.thirdQuarterOf("X"), is(8.5));
  }

  @Test public void statistics2201() {
    final PairsList p = new PairsList();
    for (int ¢ = 1; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.thirdQuarterOf("Y"), is(17.0));
  }

  @Test public void statistics30() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.varianceOf("X"), is(9.166666666666664));
  }

  @Test public void statistics31() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.varianceOf("Y"), is(9.166666666666629));
  }

  @Test public void statistics40() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.sumOf("X"), is(55.0));
  }

  @Test public void statistics41() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.sumOf("Y"), is(155.0));
  }

  @Test public void statistics50() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.squaresSumOf("X"), is(385.0));
  }

  @Test public void statistics51() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.squaresSumOf("Y"), is(2485.0));
  }

  @Test public void statistics60() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.sdOf("X"), is(Math.sqrt(9.166666666666664)));
  }

  @Test public void statistics61() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.sdOf("Y"), is(Math.sqrt(9.166666666666629)));
  }

  @Test public void statistics70() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(1), is(new Pair<>(box.it(1.0), box.it(11.0))));
  }

  @Test public void statistics71() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(2), is(new Pair<>(box.it(2.0), box.it(12.0))));
  }

  @Test public void statistics72() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(3), is(new Pair<>(box.it(3.0), box.it(13.0))));
  }

  @Test public void statistics73() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(4), is(new Pair<>(box.it(4.0), box.it(14.0))));
  }

  @Test public void statistics74() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(5), is(new Pair<>(box.it(5.0), box.it(15.0))));
  }

  @Test public void statistics75() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(6), is(new Pair<>(box.it(6.0), box.it(16.0))));
  }

  @Test public void statistics76() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(7), is(new Pair<>(box.it(7.0), box.it(17.0))));
  }

  @Test public void statistics77() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(8), is(new Pair<>(box.it(8.0), box.it(18.0))));
  }

  @Test public void statistics78() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(9), is(new Pair<>(box.it(9.0), box.it(19.0))));
  }

  @Test public void statistics79() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(10), is(new Pair<>(box.it(10.0), box.it(20.0))));
  }

  @Test public void Regression() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    for (int ¢ = 0; ¢ < 10; ¢++)
      azzert.that(p.LinearRegression().yOf(10.0 - ¢), is(20.0 - ¢));
  }
}
