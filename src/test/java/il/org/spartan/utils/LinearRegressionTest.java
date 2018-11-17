package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearRegressionTest {
  @Test public void constr1() {
    final double[] l1 = new double[5], l2 = new double[5];
    for (int ¢ = 0; ¢ < 5; ¢++) {
      l1[¢] = ¢ + 1;
      l2[¢] = ¢ + 4;
    }
    final LinearRegression l = new LinearRegression(l1, l2);
    for (int ¢ = 0; ¢ < 5; ¢++) {
      azzert.that(l.getX()[¢], azzert.is(l1[¢]));
      azzert.that(l.getY()[¢], azzert.is(l2[¢]));
    }
  }

  @Test public void constr2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    for (int ¢ = 0; ¢ < 5; ¢++) {
      azzert.that(l.getX()[¢], azzert.is(p.l.get(¢).p.first));
      azzert.that(l.getY()[¢], azzert.is(p.l.get(¢).p.second));
    }
  }

  @Test public void testSetX() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setX(new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getX()[¢], azzert.is(1.0));
  }

  @Test public void testSetXnull() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setX(null);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getX()[¢], azzert.is(¢ + 1.0));
  }

  @Test public void testSetY() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setY(new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getY()[¢], azzert.is(1.0));
  }

  @Test public void testSetYnull() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setY(null);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getY()[¢], azzert.is(¢ + 4.0));
  }

  @Test public void sxx() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    azzert.that(l.SXX(), azzert.is(10.0));
  }

  @Test public void sxy() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    azzert.that(l.SXY(), azzert.is(0.0));
  }

  @Test public void syy() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    azzert.that(l.SYY(), azzert.is(0.0));
  }

  @Test public void predictZero() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), azzert.is(0.0));
    /** check new dots - predict **/
    for (double ¢ = 70; ¢ < 200; ¢ += 3.5)
      azzert.that(l.RegressionLine().yOf(¢ + 1), azzert.is(0.0));
  }

  @Test public void predictConst() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(1.0, 4.0);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), azzert.is(4.0));
    /** check new dots - predict **/
    for (double ¢ = 70; ¢ < 200; ¢ += 3.5)
      azzert.that(l.RegressionLine().yOf(¢ + 1), azzert.is(4.0));
  }

  @Test public void predictLinearUp() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), azzert.is(¢ + 4.0));
    /** check new dots - predict **/
    for (int ¢ = 5; ¢ < 10; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), azzert.is(¢ + 4.0));
  }

  @Test public void predictLinearDown() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ - 4);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.yOf(¢ + 1.0), azzert.is(¢ - 4.0));
    /** check new dots - predict **/
    for (int ¢ = 5; ¢ < 10; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), azzert.is(¢ - 4.0));
  }

  @Test public void predictAlmostConst() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 3000; ¢++)
      if (¢ % 2 == 0)
        p.record(¢ + 1, 4.0);
      else
        p.record(¢ + 1, 6.0);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      assert Math.abs(l.RegressionLine().yOf(¢ + 1) - 5) < 0.01;
    /** check new dots - predict **/
    for (int ¢ = 5; ¢ < 10; ¢++)
      assert Math.abs(l.RegressionLine().yOf(¢ + 1) - 5) < 0.01;
  }
}
