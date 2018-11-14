package fluent.ly;

import il.org.spartan.utils.*;
import il.org.spartan.utils.Range.*;

public interface range {
  RangeIterator numbers = range.from(Integer.MIN_VALUE).to(Integer.MAX_VALUE).from();

  static Range from(final int ¢) {
    return new Range(¢);
  }

  static Range to(final int ¢) {
    return new Range(¢, true);
  }
}
