package fluent.ly;

import static fluent.ly.azzert.*;

import java.math.*;

import org.junit.*;

@SuppressWarnings("static-method")
public class bigRangeTest {
	@Test
	public void withDiffOnly() {
		final Iterable<BigInteger> iter = bigRange.withDiff(1);
		BigInteger count = BigInteger.valueOf(0);
		for (final BigInteger ¢ : iter) {
			azzert.that(count, is(¢));
			count.add(BigInteger.valueOf(1));
			if (count.equals(BigInteger.valueOf(1000)))
				break;
			count = count.add(BigInteger.valueOf(1));
		}
	}

	@Test
	public void withDiff3Only() {
		final Iterable<BigInteger> iter = bigRange.withDiff(3);
		BigInteger count = BigInteger.valueOf(0);
		for (final BigInteger ¢ : iter) {
			azzert.that(count, is(¢));
			count.add(BigInteger.valueOf(1));
			if (count.equals(BigInteger.valueOf(999)))
				break;
			count = count.add(BigInteger.valueOf(3));
		}
	}

	@Test
	public void fromAndWithDiff() {
		final Iterable<BigInteger> iter = bigRange.from(2).withDiff(3);
		BigInteger count = BigInteger.valueOf(2);
		for (final BigInteger ¢ : iter) {
			azzert.that(count, is(¢));
			count.add(BigInteger.valueOf(1));
			if (count.equals(BigInteger.valueOf(998)))
				break;
			count = count.add(BigInteger.valueOf(3));
		}
	}

	@Test
	public void fromToAndWithDiff() {
		final Iterable<BigInteger> iter = bigRange.from(5).to(123).withDiff(3);
		BigInteger count = BigInteger.valueOf(5);
		for (final BigInteger ¢ : iter) {
			azzert.that(count, is(¢));
			count.add(BigInteger.valueOf(1));
			count = count.add(BigInteger.valueOf(3));
		}
	}

	@Test
	public void infinitSumWithDiff() {
		azzert.that(null, is(bigRange.withDiff(1).Sum()));
	}

	@Test
	public void finiteSumWithDiff() {
		azzert.that(BigInteger.valueOf(0), is(bigRange.withDiff(0).Sum()));
	}

	@Test
	public void sumWithFrom() {
		azzert.that(null, is(bigRange.from(5).withDiff(2).Sum()));
	}

	@Test
	public void SumToandFrom() {
		azzert.that(BigInteger.valueOf(20), is(bigRange.from(2).to(8).withDiff(2).Sum()));
	}

	@Test
	public void SumToandFromandDiffof3() {
		azzert.that(BigInteger.valueOf(18), is(bigRange.from(3).to(9).withDiff(3).Sum()));
	}

	@Test
	public void impossibleRangeNegative() {
		azzert.that(null, is(bigRange.to(-5).withDiff(1)));
	}

	@Test
	public void impossibleRangePossitive() {
		azzert.that(null, is(bigRange.from(2).to(5).withDiff(-1)));
	}

	@Test
	public void naturals() {
		BigInteger count = BigInteger.valueOf(0);
		for (final BigInteger ¢ : bigRange.naturals()) {
			azzert.that(count, is(¢));
			count.add(BigInteger.valueOf(1));
			if (count.equals(BigInteger.valueOf(1000)))
				break;
			count = count.add(BigInteger.valueOf(1));
		}
	}

	@Test
	public void bigIntegersRange() {
		final Iterable<BigInteger> iter = bigRange.from(BigInteger.valueOf(5)).to(BigInteger.valueOf(123))
				.withDiff(BigInteger.valueOf(3));
		BigInteger count = BigInteger.valueOf(5);
		for (final BigInteger ¢ : iter) {
			azzert.that(count, is(¢));
			count.add(BigInteger.valueOf(1));
			count = count.add(BigInteger.valueOf(3));
		}
	}

	@Test
	public void bigIntegerTo() {
		final Iterable<BigInteger> iter = bigRange.to(BigInteger.valueOf(123)).withDiff(BigInteger.valueOf(3));
		BigInteger count = BigInteger.valueOf(0);
		for (final BigInteger ¢ : iter) {
			azzert.that(count, is(¢));
			count.add(BigInteger.valueOf(1));
			count = count.add(BigInteger.valueOf(3));
		}
	}
}
