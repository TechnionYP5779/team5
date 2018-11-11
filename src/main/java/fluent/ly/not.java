package fluent.ly;

public interface not {
  @SafeVarargs @SuppressWarnings("null") static <T> boolean in(final T t, final T... ts) {
    return !is.in(t, ts);
  }

  static boolean nil(final Object ¢) {
    return ¢ != null;
  }
}