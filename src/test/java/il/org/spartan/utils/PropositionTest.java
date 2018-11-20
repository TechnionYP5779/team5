/** @author Or Feldman
 * @since 2018-11-19 */
package il.org.spartan.utils;

import static il.org.spartan.utils.Proposition.*;

import org.junit.*;

@SuppressWarnings("static-method") public class PropositionTest {
  @Test public void simpleAND() {
    assert !AND(() -> true, () -> false).eval();
    assert AND(() -> true, () -> true).eval();
    assert !AND(() -> false, () -> true).eval();
    assert !AND(() -> false, () -> false).eval();
  }

  @Test public void simpleOR() {
    assert OR(() -> true, () -> false).eval();
    assert OR(() -> true, () -> true).eval();
    assert OR(() -> false, () -> true).eval();
    assert !OR(() -> false, () -> false).eval();
  }

  @Test public void simplenot() {
    assert !not(() -> true).eval();
    assert not(() -> false).eval();
  }

  @Test public void simplethat() {
    assert that(() -> true).eval();
    assert !that(() -> false).eval();
  }

  @Test public void nullStringAND() {
    assert !AND((String) null, () -> true, () -> false).eval();
  }

  @Test public void EmptyStringOR() {
    assert OR("", () -> true, () -> false).eval();
  }

  @Test public void or() {
    assert OR(() -> true, () -> false).or(() -> false, () -> false).eval();
  }

  @Test public void and() {
    assert !AND(() -> true, () -> true).and(() -> true, () -> false).eval();
  }

  @Test public void FProp() {
    assert !F.eval();
    Assert.assertEquals("F", F + "");
  }

  @Test public void TProp() {
    assert T.eval();
    Assert.assertEquals("T", T + "");
  }

  @Test(expected = NullPointerException.class) public void NProp() {
    Assert.assertEquals("N", N + "");
    N.getAsBoolean();
  }

  @Test(expected = AssertionError.class) public void XProp() {
    Assert.assertEquals("X", X + "");
    X.getAsBoolean();
  }

  @Test public void stringand() {
    assert !AND(() -> true, () -> true).and("", () -> false).eval();
  }

  @Test public void stringor() {
    assert OR(() -> true, () -> false).or("", () -> false).eval();
  }

  @Test public void complexthat() {
    assert !that(() -> true).and(() -> false).eval();
    assert that(() -> false).or(() -> true).eval();
  }
}
