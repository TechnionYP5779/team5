/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

/** @author Nir Chachamovitz */
@SuppressWarnings("static-method") public class BinaryTest {
  @Test public void cloneTest() {
    Binary.T.clone();
  }

  @Test public void hashCodeTest() {
    Binary b = Binary.T.clone();
    int res = b.hashCode();
    azzert.that(1, azzert.is(res));
  }

  @Test public void andTest() {
    Binary.T.clone();
    Binary true_b = Binary.of(true);
    Binary false_b = Binary.of(false);
    Binary.and(true_b, false_b);
    azzert.that(Binary.F, azzert.is(Binary.of(false)));
    Binary true_b2 = Binary.of(true);
    Binary.and(true_b, true_b2);
    Binary.and(false_b, false_b);
    Binary.and(false_b, true_b);
  }

  @Test public void eqTest() {
    Binary b1 = Binary.T.clone();
    Binary b2 = Binary.F;
    Binary.eq(b1, b2);
    Binary.eq(b1, b1);
  }

  @Test public void asBooleanTest() {
    Binary b1 = Binary.T.clone();
    Binary.asBoolean(b1);
    Binary.asBoolean(Binary.F);
  }

  @Test public void notTest() {
    Binary b1 = Binary.T.clone();
    Binary b2 = Binary.F;
    Binary.not(b1);
    Binary.not(b2);
  }

  @Test public void orTest() {
    Binary.T.clone();
    Binary true_b = Binary.of(true);
    Binary false_b = Binary.of(false);
    Binary.or(true_b, false_b);
    azzert.that(Binary.F, azzert.is(Binary.of(false)));
    Binary true_b2 = Binary.of(true);
    Binary.or(true_b, true_b2);
    Binary.or(false_b, false_b);
    Binary.or(false_b, true_b);
  }
}
