/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

/**
 * A test for class Binary.java
 * 
 * @author Nir Chachamovitz
 * @since 2018-11-20
 */
@SuppressWarnings("static-method")
public class BinaryTest {
	@Test
	public void cloneTest() {
		Binary.T.clone();
	}

	@Test
	public void hashCodeTest() {
		final Binary b = Binary.T.clone();
		final int res = b.hashCode();
		azzert.that(1, is(res));
	}

	@Test
	public void andTest() {
		Binary.T.clone();
		final Binary true_b = Binary.of(true);
		final Binary false_b = Binary.of(false);
		Binary.and(true_b, false_b);
		azzert.that(Binary.F, is(Binary.of(false)));
		final Binary true_b2 = Binary.of(true);
		Binary.and(true_b, true_b2);
		Binary.and(false_b, false_b);
		Binary.and(false_b, true_b);
	}

	@Test
	public void eqTest() {
		final Binary b1 = Binary.T.clone();
		final Binary b2 = Binary.F;
		Binary.eq(b1, b2);
		Binary.eq(b1, b1);
	}

	@Test
	public void asBooleanTest() {
		final Binary b1 = Binary.T.clone();
		Binary.asBoolean(b1);
		Binary.asBoolean(Binary.F);
	}

	@Test
	public void notTest() {
		final Binary b1 = Binary.T.clone();
		final Binary b2 = Binary.F;
		Binary.not(b1);
		Binary.not(b2);
	}

	@Test
	public void orTest() {
		Binary.T.clone();
		final Binary true_b = Binary.of(true);
		final Binary false_b = Binary.of(false);
		Binary.or(true_b, false_b);
		azzert.that(Binary.F, is(Binary.of(false)));
		final Binary true_b2 = Binary.of(true);
		Binary.or(true_b, true_b2);
		Binary.or(false_b, false_b);
		Binary.or(false_b, true_b);
	}
}
