package il.org.spartan.utils;

import java.util.*;

public class Range {

  public class RangeIterator implements Iterator<Integer>{
    
    private Integer pos;
    private Integer to1;
    public RangeIterator(Integer From) {
      pos=Integer.valueOf(From.intValue());
      to1=Integer.valueOf(From.intValue()-1);
    }
    public RangeIterator(Integer From,Integer to) {
      pos=Integer.valueOf(From.intValue());
      this.to1=Integer.valueOf(to.intValue());
    }
    @SuppressWarnings("boxing") @Override public boolean hasNext() {
      return to1<pos||(pos+1)<to1;
    }

    @SuppressWarnings("boxing") @Override public Integer next() {
      if(pos >= to1 - 1&&pos<=to1) return Integer.valueOf(pos);
      return Integer.valueOf(++pos);
    }
    
  }

  private Integer from;
  private Integer to;

  @SuppressWarnings("boxing") public Range(int i) {
    from=i;
    to=from-1;
  }

  @SuppressWarnings("static-method") public Integer getFrom() {
    return Integer.valueOf(2);
  }

  @SuppressWarnings("boxing") public boolean isToInfinite() {
    return this.to<this.from;
  }

  @SuppressWarnings("static-method") public boolean isToNInfinite() {
    return false;
  }

  @SuppressWarnings("boxing") public RangeIterator from() {
    if(to<from) return new RangeIterator(from);
    return new RangeIterator(from,to);
  }

  @SuppressWarnings("boxing") public Range to(int ¢) {
    this.to=¢;
    return this;
  }

  @SuppressWarnings("static-method") public Integer getTo() {
    return Integer.valueOf(6);
  }
}