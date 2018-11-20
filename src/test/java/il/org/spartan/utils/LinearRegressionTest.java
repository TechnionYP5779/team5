package il.org.spartan.utils;

import org.junit.*;
import static fluent.ly.azzert.is;
import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearRegressionTest {
  @Test public void constr10() {
    final double[] l1 = new double[5], l2 = new double[5];
    for (int ¢ = 0; ¢ < 5; ¢++) {
      l1[¢] = ¢ + 1;
      l2[¢] = ¢ + 4;
    }
    final LinearRegression l = new LinearRegression(l1, l2);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getX()[¢], is(l1[¢]));
  }

  @Test public void constr11() {
    final double[] l1 = new double[5], l2 = new double[5];
    for (int ¢ = 0; ¢ < 5; ¢++) {
      l1[¢] = ¢ + 1;
      l2[¢] = ¢ + 4;
    }
    final LinearRegression l = new LinearRegression(l1, l2);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getY()[¢], is(l2[¢]));
  }

  @Test public void constr20() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getX()[¢], is(p.l.get(¢).p.first));
  }

  @Test public void constr21() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getY()[¢], is(p.l.get(¢).p.second));
  }

  @Test public void testSetX() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setX(new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getX()[¢], is(1.0));
  }

  @Test public void testSetXnull() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setX(null);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getX()[¢], is(¢ + 1.0));
  }

  @Test public void testSetY() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setY(new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 });
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getY()[¢], is(1.0));
  }

  @Test public void testSetYnull() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    l.setY(null);
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.getY()[¢], is(¢ + 4.0));
  }

  @Test public void sxx() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    azzert.that(l.SXX(), is(10.0));
  }

  @Test public void sxy() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    azzert.that(l.SXY(), is(0.0));
  }

  @Test public void syy() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    azzert.that(l.SYY(), is(0.0));
  }

  @Test public void predictZero() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), is(0.0));
  }

  @Test public void predictZero2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢, 0.0);
    final LinearRegression l = new LinearRegression(p);
    /** check new dots - predict **/
    for (double ¢ = 70; ¢ < 200; ¢ += 3.5)
      azzert.that(l.RegressionLine().yOf(¢ + 1), is(0.0));
  }

  @Test public void predictConst() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(1.0, 4.0);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), is(4.0));
  }

  @Test public void predictConst2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(1.0, 4.0);
    final LinearRegression l = new LinearRegression(p);
    /** check new dots - predict **/
    for (double ¢ = 70; ¢ < 200; ¢ += 3.5)
      azzert.that(l.RegressionLine().yOf(¢ + 1), is(4.0));
  }

  @Test public void predictLinearUp() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    /** check new dots - predict **/
    for (int ¢ = 5; ¢ < 10; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), is(¢ + 4.0));
  }

  @Test public void predictLinearUp2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ + 4);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), is(¢ + 4.0));
  }

  @Test public void predictLinearDown() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ - 4);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      azzert.that(l.yOf(¢ + 1.0), is(¢ - 4.0));
  }

  @Test public void predictLinearDown2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 5; ¢++)
      p.record(¢ + 1, ¢ - 4);
    final LinearRegression l = new LinearRegression(p);
    /** check new dots - predict **/
    for (int ¢ = 5; ¢ < 10; ¢++)
      azzert.that(l.RegressionLine().yOf(¢ + 1), is(¢ - 4.0));
  }

  @Test public void predictAlmostConst() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 3000; ¢++)
      p.record(¢ + 1, ¢ % 2 == 0 ? 4.0 : 6.0);
    final LinearRegression l = new LinearRegression(p);
    /** check existing dots **/
    for (int ¢ = 0; ¢ < 5; ¢++)
      assert Math.abs(l.RegressionLine().yOf(¢ + 1) - 5) < 0.01;
  }

  @Test public void predictAlmostConst2() {
    final PairsList p = new PairsList();
    for (int ¢ = 0; ¢ < 3000; ¢++)
      p.record(¢ + 1, ¢ % 2 == 0 ? 4.0 : 6.0);
    final LinearRegression l = new LinearRegression(p);
    /** check new dots - predict **/
    for (int ¢ = 5; ¢ < 10; ¢++)
      assert Math.abs(l.RegressionLine().yOf(¢ + 1) - 5) < 0.01;
  }
}
