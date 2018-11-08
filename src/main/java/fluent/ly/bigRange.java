package fluent.ly;

import java.math.*;
import java.util.*;

public class bigRange {

  public static Iterable<BigInteger> withDiff(long i) {
   return new Iterable<BigInteger>(){

    @Override public Iterator<BigInteger> iterator() {
      return new Iterator<BigInteger>() {

        private BigInteger current=BigInteger.valueOf(0-i);
        
        @Override public boolean hasNext() {
          return true;
        }

        @Override public BigInteger next() {
          current=current.add(BigInteger.valueOf(i));
          System.out.println(current);
          return current;
        }
        
      };
    }
     
   };
  }

  
  public static class afterFrom{
    final long first;
    public afterFrom(long first) {
      this.first=first;
    }
    
    public  Iterable<BigInteger> withDiff(long i) {
      return new Iterable<BigInteger>(){

       @Override public Iterator<BigInteger> iterator() {
         return new Iterator<BigInteger>() {

           private BigInteger current=BigInteger.valueOf(first-i);
           
           @Override public boolean hasNext() {
             return true;
           }

           @Override public BigInteger next() {
             current=current.add(BigInteger.valueOf(i));
             System.out.println(current);
             return current;
           }
           
         };
       }
        
      };
     }
  }
  
  public static afterFrom from(long i) {
    return new afterFrom(i);
  }

  
}
