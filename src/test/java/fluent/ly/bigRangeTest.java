package fluent.ly;

import java.math.*;
import org.junit.*;

public class bigRangeTest {
   @SuppressWarnings({ "static-method", "static-access" }) @Test 
  public  void withDiffOnly() {
    Iterable<BigInteger> iter=bigRange.withDiff(1);
    BigInteger count=BigInteger.valueOf(0);
    for(BigInteger i : iter) {
      azzert.assertEquals(count,i);
      count.add(BigInteger.valueOf(1));
      if(count.equals(BigInteger.valueOf(1000)))
        break;
      count=count.add(BigInteger.valueOf(1));
    }
  }
  
   @SuppressWarnings({ "static-method", "static-access" }) @Test
  public  void withDiff3Only() {
    Iterable<BigInteger> iter=bigRange.withDiff(3);
    BigInteger count=BigInteger.valueOf(0);
    for(BigInteger i : iter) {
      azzert.assertEquals(count,i);
      count.add(BigInteger.valueOf(1));
      if(count.equals(BigInteger.valueOf(999)))
        break;
      count=count.add(BigInteger.valueOf(3));
    }
  }
  
   @SuppressWarnings({ "static-method", "static-access" }) @Test
  public  void fromAndWithDiff() {
    Iterable<BigInteger> iter=bigRange.from(2).withDiff(3);
    BigInteger count=BigInteger.valueOf(2);
    for(BigInteger i : iter) {
      azzert.assertEquals(count,i);
      count.add(BigInteger.valueOf(1));
      if(count.equals(BigInteger.valueOf(998)))
        break;
   count=count.add(BigInteger.valueOf(3));
    }
  }
}
