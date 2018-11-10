package fluent.ly;

import java.math.*;
import java.util.*;

public class bigRange {

  public static theRange withDiff(long i) {
   return withDiff(BigInteger.valueOf(i));
  }
  
  public static theRange withDiff(BigInteger i) {
    return new theRange(){

     @Override public Iterator<BigInteger> iterator() {
       return new Iterator<BigInteger>() {

         BigInteger current=BigInteger.valueOf(0).subtract(i);
         
         @Override public boolean hasNext() {
           return true;
         }

         @Override public BigInteger next() {
           current=current.add(i);
           return current;
         }
       };
     }
     @Override public BigInteger Sum() {
       if(i.compareTo(BigInteger.valueOf(0))!=0)
         return null;
       return BigInteger.valueOf(0);
     }
    };
   }
  
  public interface theRange extends Iterable<BigInteger>{
    BigInteger Sum();
  }

  
  public static class afterFrom{
    final BigInteger first;
    final BigInteger last;
    final boolean isFinit;
    public afterFrom(BigInteger first) {
      last=BigInteger.valueOf(0);
      this.first=first.add(last);
      isFinit=false;
    }
    
    public afterFrom(BigInteger f,BigInteger l) {
      first=f;
      last=l;
      isFinit=true;
    }
    
    public  theRange withDiff(long i) {
      return withDiff(BigInteger.valueOf(i));
     }

    public afterFrom to(long i) {
      return new afterFrom(first,BigInteger.valueOf( i));
    }
    
    public afterFrom to(BigInteger ¢) {
      return new afterFrom(first,¢);
    }

    public theRange withDiff(BigInteger i) {
      if(isFinit&&((last.compareTo(first)==1 && i.compareTo(BigInteger.valueOf(0))<0)||(first.compareTo(last)==1 && i.compareTo(BigInteger.valueOf(0))>0)))
        return null;
    return  new theRange(){

     @Override public Iterator<BigInteger> iterator() {
       return new Iterator<BigInteger>() {

         BigInteger current=first.subtract(i);
         
         @Override public boolean hasNext() {
           return !isFinit|| current.compareTo(last)<0;
         }

         @Override public BigInteger next() {
           if(hasNext())
             current=current.add(i);
           return current;
         }
         
       };
     }

    @Override public BigInteger Sum() {
      if(!isFinit)
        return null;
      BigInteger f=first;
      BigInteger l=last;
      BigInteger s=i;
      BigInteger n=l.subtract(f).divide(s).add(BigInteger.valueOf(1));
      return n.multiply(f.multiply(BigInteger.valueOf(2)).add(s.multiply(n.subtract(BigInteger.valueOf(1))))).divide(BigInteger.valueOf(2)); 
    }
      
    };
   }
    }
  
  public static afterFrom from(long i) {
    return new afterFrom(BigInteger.valueOf(i));
  }
  
  public static afterFrom from(BigInteger ¢) {
    return new afterFrom(¢);
  }

  public static afterFrom to(long i) {
    return new afterFrom(BigInteger.valueOf(0),BigInteger.valueOf(i));
  }
  
  public static afterFrom to(BigInteger ¢) {
    return new afterFrom(BigInteger.valueOf(0),¢);
  }
  
  public static theRange naturals() {
    return withDiff(1);
  }
  
}
