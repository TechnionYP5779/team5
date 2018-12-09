package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
public class TruthTest {
	@Test
	public void testTruthOf() {
		azzert.that(Truth.truthOf(() -> 1 == 2), is(Truth.F));
		azzert.that(Truth.truthOf(null), is(Truth.N));
		azzert.that(Truth.truthOf(() -> {
			throw new AssertionError();
		}), is(Truth.X));
		azzert.that(Truth.truthOf(() -> {
			throw new RuntimeException();
		}), is(Truth.R));
		azzert.that(Truth.truthOf(() -> {
			throw new Error();
		}), is(Truth.Ħ));
	}

	@Test
	public void testNot() {
		final Truth f = Truth.F;
		azzert.that(Truth.T.not(), is(Truth.F));
		azzert.that(f.not(), is(Truth.T));
	}

	@Test
	public void testOr() {
		azzert.that(Truth.T.or(Truth.T), is(Truth.T));
		azzert.that(Truth.T.or(Truth.F), is(Truth.T));
		azzert.that(Truth.F.or(Truth.T), is(Truth.T));
		azzert.that(Truth.F.or(Truth.F), is(Truth.F));
	}

	@Test
	public void testAnd() {
		azzert.that(Truth.T.and(Truth.T), is(Truth.T));
		azzert.that(Truth.T.and(Truth.F), is(Truth.F));
		azzert.that(Truth.F.and(Truth.T), is(Truth.F));
		azzert.that(Truth.F.and(Truth.F), is(Truth.F));
	}
}