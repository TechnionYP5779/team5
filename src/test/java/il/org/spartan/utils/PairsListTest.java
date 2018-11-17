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
    assert !p.contains(1.0, 2.2);
  }

  @Test public void sort() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    p.sortAsc();
    for (int ¢ = 1; ¢ <= 10; ¢++)
      assert p.l.get(¢ - 1).p.equals(new Pair<>(box.box(1. * ¢), box.box(1. * (¢ + 10))));
    p.sortDesc();
    for (int ¢ = 0; ¢ < 10; ¢++)
      assert p.l.get(¢).p.equals(new Pair<>(box.box(10.0 - ¢), box.box(20.0 - ¢)));
  }

  @Test public void sort1() {
    final PairsList p = new PairsList();
    p.record(3.1, 1.1);
    p.record(3.1, 1.7);
    p.record(1.1, 1.4);
    p.record(2.1, 1.1);
    p.sortAsc();
    azzert.that(p.l.get(0).p, azzert.is(new Pair<>(box.box(1.1), box.box(1.4))));
    p.sortDesc();
    azzert.that(p.l.get(0).p, azzert.is(new Pair<>(box.box(3.1), box.box(1.7))));
  }

  @Test public void iter() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.iterator();
    for (; itr.hasNext(); d++)
      azzert.that(itr.next().p, azzert.is(new Pair<>(box.box(d + 1.0), box.box(d + 11.0))));
    azzert.that(itr.next().p, azzert.is(new Pair<>(box.box(d + 1.0 - 1), box.box(d + 11.0 - 1))));
    azzert.that(itr.next().p, azzert.is(new Pair<>(box.box(d + 1.0 - 1), box.box(d + 11.0 - 1))));
  }

  @Test public void reti() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    double d = 0;
    final Iterator<PAIR<Double, Double>> itr = p.revIterator();
    for (; itr.hasNext(); d++)
      azzert.that(itr.next().p, azzert.is(new Pair<>(box.box(10.0 - d), box.box(20.0 - d))));
    azzert.that(itr.next().p, azzert.is(new Pair<>(box.box(-d + 10.0 + 1), box.box(-d + 20.0 + 1))));
    azzert.that(itr.next().p, azzert.is(new Pair<>(box.box(-d + 10.0 + 1), box.box(-d + 20.0 + 1))));
  }

  @Test public void statistics0() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.max(), is(new Pair<>(box.box(10.0), box.box(20.0))));
    assert new PairsList().max() == null;
    assert new PairsList().min() == null;
    azzert.that(p.min(), is(new Pair<>(box.box(1.0), box.box(11.0))));
    azzert.that(p.size(), is(10));
  }

  @Test public void statistics1() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.meanOf("X"), is(5.5));
    azzert.that(p.meanOf("Y"), is(15.5));
  }

  @Test public void statistics20() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.medianOf("X"), is(5.5));
    azzert.that(p.medianOf("Y"), is(15.5));
  }

  @Test public void statistics21() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.firstQuarterOf("X"), is(3.5));
    azzert.that(p.firstQuarterOf("Y"), is(13.5));
  }

  @Test public void statistics210() {
    final PairsList p = new PairsList();
    for (int ¢ = 1; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.firstQuarterOf("X"), is(3.0));
    azzert.that(p.firstQuarterOf("Y"), is(13.0));
  }

  @Test public void statistics22() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.thirdQuarterOf("X"), is(8.5));
    azzert.that(p.thirdQuarterOf("Y"), is(18.5));
  }

  @Test public void statistics220() {
    final PairsList p = new PairsList();
    for (int ¢ = 1; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.thirdQuarterOf("X"), is(7.0));
    azzert.that(p.thirdQuarterOf("Y"), is(17.0));
  }

  @Test public void statistics3() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.varianceOf("X"), is(9.166666666666664));
    azzert.that(p.varianceOf("Y"), is(9.166666666666629));
  }

  @Test public void statistics4() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.sumOf("X"), is(55.0));
    azzert.that(p.sumOf("Y"), is(155.0));
  }

  @Test public void statistics5() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.squaresSumOf("X"), is(385.0));
    azzert.that(p.squaresSumOf("Y"), is(2485.0));
  }

  @Test public void statistics6() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.sdOf("X"), is(Math.sqrt(9.166666666666664)));
    azzert.that(p.sdOf("Y"), is(Math.sqrt(9.166666666666629)));
  }

  @Test public void statistics7() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    azzert.that(p.orderStatistic(1), is(new Pair<>(box.box(1.0), box.box(11.0))));
    azzert.that(p.orderStatistic(2), is(new Pair<>(box.box(2.0), box.box(12.0))));
    azzert.that(p.orderStatistic(3), is(new Pair<>(box.box(3.0), box.box(13.0))));
    azzert.that(p.orderStatistic(4), is(new Pair<>(box.box(4.0), box.box(14.0))));
    azzert.that(p.orderStatistic(5), is(new Pair<>(box.box(5.0), box.box(15.0))));
    azzert.that(p.orderStatistic(6), is(new Pair<>(box.box(6.0), box.box(16.0))));
    azzert.that(p.orderStatistic(7), is(new Pair<>(box.box(7.0), box.box(17.0))));
    azzert.that(p.orderStatistic(8), is(new Pair<>(box.box(8.0), box.box(18.0))));
    azzert.that(p.orderStatistic(9), is(new Pair<>(box.box(9.0), box.box(19.0))));
    azzert.that(p.orderStatistic(10), is(new Pair<>(box.box(10.0), box.box(20.0))));
  }

  @Test public void Regression() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 10; ¢++)
      p.record(10.0 - ¢, 20.0 - ¢);
    for (int ¢ = 0; ¢ < 10; ¢++)
      azzert.that(p.LinearRegression().yOf(10.0 - ¢), azzert.is(20.0 - ¢));
  }
}
