package fluent.ly;

import java.math.*;

import org.junit.*;

public class bigRangeTest {
  @SuppressWarnings({ "static-method", "static-access" }) @Test public void withDiffOnly() {
    final Iterable<BigInteger> iter = bigRange.withDiff(1);
    BigInteger count = BigInteger.valueOf(0);
    for (final BigInteger i : iter) {
      Assert.assertEquals(count, i);
      count.add(BigInteger.valueOf(1));
      if (count.equals(BigInteger.valueOf(1000)))
        break;
      count = count.add(BigInteger.valueOf(1));
    }
  }

  @SuppressWarnings({ "static-method", "static-access" }) @Test public void withDiff3Only() {
    final Iterable<BigInteger> iter = bigRange.withDiff(3);
    BigInteger count = BigInteger.valueOf(0);
    for (final BigInteger i : iter) {
      Assert.assertEquals(count, i);
      count.add(BigInteger.valueOf(1));
      if (count.equals(BigInteger.valueOf(999)))
        break;
      count = count.add(BigInteger.valueOf(3));
    }
  }

  @SuppressWarnings({ "static-method", "static-access" }) @Test public void fromAndWithDiff() {
    final Iterable<BigInteger> iter = bigRange.from(2).withDiff(3);
    BigInteger count = BigInteger.valueOf(2);
    for (final BigInteger i : iter) {
      Assert.assertEquals(count, i);
      count.add(BigInteger.valueOf(1));
      if (count.equals(BigInteger.valueOf(998)))
        break;
      count = count.add(BigInteger.valueOf(3));
    }
  }
}
