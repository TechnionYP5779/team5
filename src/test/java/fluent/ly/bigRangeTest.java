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
   
   @SuppressWarnings({ "static-access", "static-method" }) @Test
   public void fromToAndWithDiff() {
     Iterable<BigInteger> iter=bigRange.from(5).to(123).withDiff(3);
     BigInteger count=BigInteger.valueOf(5);
     for(BigInteger i : iter) {
       azzert.assertEquals(count,i);
       count.add(BigInteger.valueOf(1));
       count=count.add(BigInteger.valueOf(3));
   }
  }
   
   @SuppressWarnings({ "static-access", "static-method" }) @Test
   public void infinitSumWithDiff() {
     azzert.assertEquals(null,bigRange.withDiff(1).Sum());
   }
   
   @SuppressWarnings({ "static-method", "static-access" }) @Test
   public void finiteSumWithDiff() {
     azzert.assertEquals(BigInteger.valueOf(0),bigRange.withDiff(0).Sum());
   }
   
   @SuppressWarnings({ "static-method", "static-access" }) @Test
   public void sumWithFrom() {
     azzert.assertEquals(null,bigRange.from(5).withDiff(2).Sum());
   }
   
   @SuppressWarnings({ "static-method", "static-access" }) @Test 
   public void SumToandFrom() {
     azzert.assertEquals(BigInteger.valueOf(20),bigRange.from(2).to(8).withDiff(2).Sum());
   }
   
   @SuppressWarnings({ "static-method", "static-access" }) @Test 
   public void SumToandFromandDiffof3() {
     azzert.assertEquals(BigInteger.valueOf(18),bigRange.from(3).to(9).withDiff(3).Sum());
   }
  
}
