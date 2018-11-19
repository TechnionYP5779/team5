/** @author Or Feldman
 * @since 2018-11-19 */
package il.org.spartan.utils;

import org.junit.*;

@SuppressWarnings("static-method") public class PropositionTest {
  @Test public void simpleAND() {
    assert !Proposition.AND(() -> true, () -> false).eval();
    assert Proposition.AND(() -> true, () -> true).eval();
    assert !Proposition.AND(() -> false, () -> true).eval();
    assert !Proposition.AND(() -> false, () -> false).eval();
  }

  @Test public void simpleOR() {
    assert Proposition.OR(() -> true, () -> false).eval();
    assert Proposition.OR(() -> true, () -> true).eval();
    assert Proposition.OR(() -> false, () -> true).eval();
    assert !Proposition.OR(() -> false, () -> false).eval();
  }

  @Test public void simplenot() {
    assert !Proposition.not(() -> true).eval();
    assert Proposition.not(() -> false).eval();
  }

  @Test public void simplethat() {
    assert Proposition.that(() -> true).eval();
    assert !Proposition.that(() -> false).eval();
  }

  @Test public void nullStringAND() {
    assert !Proposition.AND((String) null, () -> true, () -> false).eval();
  }

  @Test public void EmptyStringOR() {
    assert Proposition.OR("", () -> true, () -> false).eval();
  }

  @Test public void or() {
    assert Proposition.OR(() -> true, () -> false).or(() -> false, () -> false).eval();
  }

  @Test public void and() {
    assert !Proposition.AND(() -> true, () -> true).and(()->true,() -> false).eval();
  }

  @Test public void reduce() {
    // TODO: finish
  }
}
