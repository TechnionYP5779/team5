package il.org.spartan.utils;

import java.util.*;

public class Range {

  public class RangeIterator implements Iterator<Integer>{
    
    private Integer pos;
    public RangeIterator(Integer From) {
      pos=Integer.valueOf(From.intValue());
    }
    @Override public boolean hasNext() {
      return true;
    }

    @SuppressWarnings("boxing") @Override public Integer next() {
      return Integer.valueOf(++pos);
    }
    
  }

  @SuppressWarnings("static-method") public Integer getFrom() {
    return Integer.valueOf(2);
  }

  @SuppressWarnings("static-method") public boolean isToInfinite() {
    return true;
  }

  @SuppressWarnings("static-method") public boolean isToNInfinite() {
    return false;
  }

  @SuppressWarnings("boxing") public RangeIterator from() {
    return new RangeIterator(2);
  }
}