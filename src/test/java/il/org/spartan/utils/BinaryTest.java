/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

/** @author Nir Chachamovitz */
@SuppressWarnings({"static-method", "unused", "static-access"}) public class BinaryTest {
  @Test public void cloneTest() {
    Binary b = Binary.T.clone();
  }

  @Test public void hashCodeTest() {
    Binary b = Binary.T.clone();
    int res = b.hashCode();
    azzert.assertEquals(1, res);
  }

  @Test public void andTest() {
    Binary b1 = Binary.T.clone();
    Binary true_b = b1.of(true);
    Binary b2 = Binary.F;
    Binary false_b = b2.of(false);
    Binary new_b = Binary.and(true_b, false_b);
    azzert.assertEquals(Binary.F.of(false), new_b.of(false));
    Binary true_b2 = b1.of(true);
    Binary new_b2 = Binary.and(true_b, true_b2);
    // azzert.assertEquals(b1, azzert.is(b1));
    Binary new_b3 = Binary.and(false_b, false_b);
    Binary new_b4 = Binary.and(false_b, true_b);
    // azzert.that(Binary.T.of(false), new_b3.of(false));
  }

  @Test public void eqTest() {
    Binary b1 = Binary.T.clone();
    Binary b2 = Binary.F;
    Binary b_neq = Binary.eq(b1, b2);
    Binary b_eq = Binary.eq(b1, b1);
  }

  @Test public void asBooleanTest() {
    Binary b1 = Binary.T.clone();
    Binary b_true = b1.asBoolean(b1);
    Binary b_false = b1.asBoolean(Binary.F);
  }

  @Test public void notTest() {
    Binary b1 = Binary.T.clone();
    Binary b2 = Binary.F;
    Binary not_b1 = Binary.not(b1);
    Binary not_b2 = Binary.not(b2);
  }

  @Test public void orTest() {
    Binary b1 = Binary.T.clone();
    Binary true_b = b1.of(true);
    Binary b2 = Binary.F;
    Binary false_b = b2.of(false);
    Binary new_b = Binary.or(true_b, false_b);
    azzert.assertEquals(Binary.F.of(false), new_b.of(false));
    Binary true_b2 = b1.of(true);
    Binary new_b2 = Binary.or(true_b, true_b2);
    Binary new_b3 = Binary.or(false_b, false_b);
    Binary new_b4 = Binary.or(false_b, true_b);
  }
}
