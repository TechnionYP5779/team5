package fluent.ly;

import java.math.*;

import org.junit.*;

@SuppressWarnings("static-method") public class bigRangeTest {
  @SuppressWarnings("static-method") @Test public void withDiffOnly() {
    final Iterable<BigInteger> iter = bigRange.withDiff(1);
    BigInteger count = BigInteger.valueOf(0);
    for (final BigInteger i : iter) {
      azzert.that(count, azzert.is(i));
      count.add(BigInteger.valueOf(1));
      if (count.equals(BigInteger.valueOf(1000)))
        break;
      count = count.add(BigInteger.valueOf(1));
    }
  }

  @SuppressWarnings("static-method") @Test public void withDiff3Only() {
    final Iterable<BigInteger> iter = bigRange.withDiff(3);
    BigInteger count = BigInteger.valueOf(0);
    for (final BigInteger i : iter) {
      azzert.that(count, azzert.is(i));
      count.add(BigInteger.valueOf(1));
      if (count.equals(BigInteger.valueOf(999)))
        break;
      count = count.add(BigInteger.valueOf(3));
    }
  }

  @Test  public void fromAndWithDiff() {
    final Iterable<BigInteger> iter = bigRange.from(2).withDiff(3);
    BigInteger count = BigInteger.valueOf(2);
    for (final BigInteger i : iter) {
      azzert.that(count, azzert.is(i));
      count.add(BigInteger.valueOf(1));
      if (count.equals(BigInteger.valueOf(998)))
        break;
      count = count.add(BigInteger.valueOf(3));
    }
  }

  @Test public void fromToAndWithDiff() {
    final Iterable<BigInteger> iter = bigRange.from(5).to(123).withDiff(3);
    BigInteger count = BigInteger.valueOf(5);
    for (final BigInteger i : iter) {
      Assert.assertEquals(count, i);
      count.add(BigInteger.valueOf(1));
      count = count.add(BigInteger.valueOf(3));
    }
  }

  @Test @SuppressWarnings("static-method") public void infinitSumWithDiff() {
    Assert.assertEquals(null, bigRange.withDiff(1).Sum());
  }

  @Test public void finiteSumWithDiff() {
    Assert.assertEquals(BigInteger.valueOf(0), bigRange.withDiff(0).Sum());
  }

  @Test @SuppressWarnings("static-method") public void sumWithFrom() {
    Assert.assertEquals(null, bigRange.from(5).withDiff(2).Sum());
  }

  @Test @SuppressWarnings("static-method") public void SumToandFrom() {
    Assert.assertEquals(BigInteger.valueOf(20), bigRange.from(2).to(8).withDiff(2).Sum());
  }

  @Test @SuppressWarnings("static-method") public void SumToandFromandDiffof3() {
    Assert.assertEquals(BigInteger.valueOf(18), bigRange.from(3).to(9).withDiff(3).Sum());
  }

  @Test  public void impossibleRangeNegative() {
    Assert.assertEquals(null, bigRange.to(-5).withDiff(1));
  }

  @Test @SuppressWarnings("static-method") public void impossibleRangePossitive() {
    Assert.assertEquals(null, bigRange.from(2).to(5).withDiff(-1));
  }

  @Test public void naturals() {
    BigInteger count = BigInteger.valueOf(0);
    for (final BigInteger i : bigRange.naturals()) {
      azzert.that(count, azzert.is(i));
      count.add(BigInteger.valueOf(1));
      if (count.equals(BigInteger.valueOf(1000)))
        break;
      count = count.add(BigInteger.valueOf(1));
    }
  }

  @SuppressWarnings({  "static-method" }) @Test public void bigIntegersRange() {
    final Iterable<BigInteger> iter = bigRange.from(BigInteger.valueOf(5)).to(BigInteger.valueOf(123)).withDiff(BigInteger.valueOf(3));
    BigInteger count = BigInteger.valueOf(5);
    for (final BigInteger i : iter) {
      Assert.assertEquals(count, i);
      count.add(BigInteger.valueOf(1));
      count = count.add(BigInteger.valueOf(3));
    }
  }
}
