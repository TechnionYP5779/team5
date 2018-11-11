package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class TruthTest {
  @SuppressWarnings("static-method") @Test public void testTruthOf() {
    azzert.that(Truth.truthOf(() -> 1 == 2), azzert.is(Truth.F));
    azzert.that(Truth.truthOf(null), azzert.is(Truth.N));
    azzert.that(Truth.truthOf(() -> {
      throw new AssertionError();
    }), azzert.is(Truth.X));
    azzert.that(Truth.truthOf(() -> {
      throw new RuntimeException();
    }), azzert.is(Truth.R));
    azzert.that(Truth.truthOf(() -> {
      throw new Error();
    }), azzert.is(Truth.Ħ));
  }

  @SuppressWarnings("static-method") @Test public void testNot() {
    final Truth t = Truth.T;
    final Truth f = Truth.F;
    azzert.that(t.not(), azzert.is(Truth.F));
    azzert.that(f.not(), azzert.is(Truth.T));
  }

  @SuppressWarnings("static-method") @Test public void testOr() {
    azzert.that(Truth.T.or(Truth.T), azzert.is(Truth.T));
    azzert.that(Truth.T.or(Truth.F), azzert.is(Truth.T));
    azzert.that(Truth.F.or(Truth.T), azzert.is(Truth.T));
    azzert.that(Truth.F.or(Truth.F), azzert.is(Truth.F));
  }

  @SuppressWarnings("static-method") @Test public void testAnd() {
    azzert.that(Truth.T.and(Truth.T), azzert.is(Truth.T));
    azzert.that(Truth.T.and(Truth.F), azzert.is(Truth.F));
    azzert.that(Truth.F.and(Truth.T), azzert.is(Truth.F));
    azzert.that(Truth.F.and(Truth.F), azzert.is(Truth.F));
  }
}