/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

/** @author Nir Chachamovitz */
@SuppressWarnings("static-method") public class StrTest {
  @Test public void constructorTest() {
    final Str s2 = new Str(new String("Hello"));
    s2.set("Hello");
  }

  @Test public void setTest() {
    final Str s1 = new Str();
    s1.set("World");
    azzert.that(s1.inner(), is("World"));
  }

  @Test public void emptyTest() {
    final Str s = new Str();
    assert s.isEmptyx();
    s.set("World");
    assert !s.isEmptyx();
  }

  @Test public void notemptyTest() {
    final Str s = new Str();
    assert !s.notEmpty();
    s.set("World");
    assert s.notEmpty();
  }
}
