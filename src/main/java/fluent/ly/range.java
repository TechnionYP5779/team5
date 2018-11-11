package fluent.ly;

import il.org.spartan.utils.*;

public interface range {

  static Range from(@SuppressWarnings("unused") int i) {
    return new Range();
  }
}
