package fluent.ly;

import java.math.*;
import java.util.*;

public class bigRange {

  public static theRange withDiff(long i) {
   return new theRange(){

    @Override public Iterator<BigInteger> iterator() {
      return new Iterator<BigInteger>() {

        private BigInteger current=BigInteger.valueOf(0-i);
        
        @Override public boolean hasNext() {
          return true;
        }

        @Override public BigInteger next() {
          current=current.add(BigInteger.valueOf(i));
          return current;
        }
      };
    }
    @Override public BigInteger Sum() {
      if(i!=0)
        return null;
      return BigInteger.valueOf(0);
    }
   };
  }
  
  public interface theRange extends Iterable<BigInteger>{
    public  BigInteger Sum();
  }

  
  public static class afterFrom{
    final long first;
    final long last;
    final boolean isFinit;
    public afterFrom(long first) {
      this.first=first;
      last=0;
      isFinit=false;
    }
    
    public afterFrom(long f,long l) {
      first=f;
      last=l;
      isFinit=true;
    }
    
    public  theRange withDiff(long i) {
      return new theRange(){

       @Override public Iterator<BigInteger> iterator() {
         return new Iterator<BigInteger>() {

           private BigInteger current=BigInteger.valueOf(first-i);
           private BigInteger l=BigInteger.valueOf(last);
           
           @Override public boolean hasNext() {
             return !isFinit|| current.compareTo(l)<0;
           }

           @Override public BigInteger next() {
             if(hasNext())
               current=current.add(BigInteger.valueOf(i));
             return current;
           }
           
         };
       }

      @Override public BigInteger Sum() {
        if(!isFinit)
          return null;
        BigInteger f=BigInteger.valueOf(first);
        BigInteger l=BigInteger.valueOf(last);
        BigInteger s=BigInteger.valueOf(i);
        BigInteger n=l.subtract(f).divide(s).add(BigInteger.valueOf(1));
        return n.multiply(f.multiply(BigInteger.valueOf(2)).add(s.multiply(n.subtract(BigInteger.valueOf(1))))).divide(BigInteger.valueOf(2)); 
      }
        
      };
     }

    public afterFrom to(long i) {
      return new afterFrom(first,i);
    }
  }
  
  public static afterFrom from(long i) {
    return new afterFrom(i);
  }

  
}
