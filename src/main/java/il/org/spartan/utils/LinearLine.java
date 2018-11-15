package il.org.spartan.utils;

/** this class represents a linear line holds for the linear function
 * {@code y = beta0 + beta1*x }
 * @author Shaked Sapir
 * @since 2018-11-15 */
public class LinearLine {
  double beta1;
  double beta0;

  public LinearLine(double b1, double b0) {
    beta1 = b1;
    beta0 = b0;
  }

  public double yOf(double x) {
    return beta0 + x * beta1;
  }
}
