package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import fluent.ly.*;
import il.org.spartan.statistics.*;
import il.org.spartan.utils.PairsList.*;

/** this class implements simple linear regression, it gets lists of (x,y)
 * coordinates, uses the "least-squares-minimization" approach (ref :
 * https://en.wikipedia.org/wiki/Simple_linear_regression) to find the
 * representing linear line of the data. assumption: the x,y values containers
 * are of the same size
 * @author Shaked Sapir
 * @since 2018-11-15 */
public class LinearRegression {
  private double @NotNull [] x_vals;
  private double @NotNull [] y_vals;

  public LinearRegression(final double[] x, final double[] y) {
    x_vals = new double[x.length];
    y_vals = new double[y.length];
    for (int ¢ = 0; ¢ < x_vals.length; ¢++) {
      x_vals[¢] = x[¢];
      y_vals[¢] = y[¢];
    }
  }

  public LinearRegression(final PairsList a) {
    x_vals = new double[a.size()];
    y_vals = new double[a.size()];
    int idx = 0;
    for (final PAIR<Double, Double> ¢ : a.l) {
      x_vals[idx] = unbox.it(¢.p.first);
      y_vals[idx++] = unbox.it(¢.p.second);
    }
  }

  public double[] getX() {
    return x_vals;
  }

  public double[] getY() {
    return y_vals;
  }

  /** this function computes a representong linear line of the data and retrives
   * it. **/
  public LinearLine RegressionLine() {
    final double x_mean = Statistics.sampleMean(x_vals), y_mean = Statistics.sampleMean(y_vals);
    double sxx = 0, sxy = 0;
    for (int ¢ = 0; ¢ < x_vals.length; ¢++) {
      sxx += (x_vals[¢] - x_mean) * (x_vals[¢] - x_mean);
      sxy += (x_vals[¢] - x_mean) * (y_vals[¢] - y_mean);
    }
    /** careful... sxx = 0 causes a constant line **/
    final double $ = sxx == 0 ? 0 : sxy / sxx;
    return new LinearLine($, y_mean - $ * x_mean);
  }

  public void setX(final double[] ¢) {
    if (¢ != null)
      x_vals = ¢.clone();
  }

  public void setY(final double[] ¢) {
    if (¢ != null)
      y_vals = ¢.clone();
  }

  public double SXX() {
    final double x_mean = Statistics.sampleMean(x_vals);
    double $ = 0;
    for (final double x_val : x_vals)
      $ += (x_val - x_mean) * (x_val - x_mean);
    return $;
  }

  public double SXY() {
    final double y_mean = Statistics.sampleMean(y_vals);
    double $ = 0;
    final double x_mean = Statistics.sampleMean(x_vals);
    for (int ¢ = 0; ¢ < x_vals.length; ¢++)
      $ += (x_vals[¢] - x_mean) * (y_vals[¢] - y_mean);
    return $;
  }

  public double SYY() {
    final double y_mean = Statistics.sampleMean(y_vals);
    double $ = 0;
    for (int ¢ = 0; ¢ < x_vals.length; ¢++)
      $ += (y_vals[¢] - y_mean) * (y_vals[¢] - y_mean);
    return $;
  }

  public double yOf(final double x) {
    return RegressionLine().yOf(x);
  }
}
