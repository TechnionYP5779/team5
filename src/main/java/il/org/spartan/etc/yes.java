package il.org.spartan.etc;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-10 */
@SuppressWarnings("unused") public interface yes {
  interface On<T, R> {
    R on(T t);
  }

  static boolean forgetting(final Runnable ¢) {
    ¢.run();
    return true;
  }

  static boolean forgetting(final Object _1, final Object... _2) {
    return true;
  }

  static boolean ignoring(final boolean __) {
    return true;
  }

  static boolean ignoring(final double __) {
    return true;
  }

  static boolean ignoring(final long __) {
    return true;
  }
}
