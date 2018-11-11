package fluent.ly;

import il.org.spartan.utils.*;

public interface range {

  static Range from(int ¢) {
    return new Range(¢);
  }

  static Range to(int ¢) {
    return new Range(¢,true);
  }
}
