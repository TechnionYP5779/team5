/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Examples.*;

/** @author Nir Chachamovitz
 * @since 2018-11-21 */
public class ExamplesTest {
  public class Ex implements Example { // Example is an interface
  }

  @Test public void addTest() {
    final Examples e = new Examples();
    final Ex ex = new ExamplesTest.Ex();
    e.add(ex);
    final Iterator<Example> it = e.iterator();
    final Spliterator<Example> split = e.spliterator();
    final Converter cv = e.convert("Hello");
    final Examples new_s = cv.to("hi");
    final Examples exs = e.ignores("123").add(ex);
    azzert.notNull(it);
    azzert.notNull(new_s);
    azzert.notNull(split);
    azzert.notNull(exs);
  }
}