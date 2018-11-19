/**add here documentation for file 
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

/**
 * @author Nir Chachamovitz
 *
 */
@SuppressWarnings("static-method") 
public class StrTest {
  @Test public void constructorTest() {
    Str s2 = new Str(new String("Hello"));
    s2.set("Hello");
  }
  
  @Test public void setTest() {
    Str s1 = new Str();
    s1.set("World");
    azzert.that(s1.inner(), azzert.is("World"));
  }
  
  @Test public void emptyTest() {
    Str s = new Str();
    azzert.that(true, azzert.is(s.isEmptyx()));
    s.set("World");
    azzert.that(false, azzert.is(s.isEmptyx()));
  }
  
  @Test public void notemptyTest() {
    Str s = new Str();
    azzert.that(false, azzert.is(s.notEmpty()));
    s.set("World");
    azzert.that(true, azzert.is(s.notEmpty()));

  }
}
