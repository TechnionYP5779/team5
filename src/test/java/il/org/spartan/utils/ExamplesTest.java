/**add here documentation for file 
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;
 import java.util.*;
 import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Examples.*;
 /**
 * @author Nir Chachamovitz
 * @since 2018-11-21
 */
public class ExamplesTest {
  public class Ex implements Example { // Example is an interface
  }
  @Test public void addTest() {
    Examples e = new Examples();
    Ex ex = new ExamplesTest.Ex();
    e.add(ex);
    Iterator<Example> it = e.iterator();
    Spliterator<Example> split = e.spliterator();
    Converter cv = e.convert("Hello");
    Examples new_s = cv.to("hi");
    Examples exs = e.ignores("123").add(ex); 
    azzert.notNull(it);
    azzert.notNull(new_s);
    azzert.notNull(split);
    azzert.notNull(exs);
  }
}