//package il.org.spartan.utils;
//
//import java.util.*;
//
//import org.jetbrains.annotations.*;
//
//import fluent.ly.*;
//
//@SuppressWarnings("static-method") public class Range {
//  public class RangeIterator implements Iterator<Integer> {
//    @NotNull private Integer pos;
//    @NotNull private final Integer to1;
//
//    public RangeIterator(@NotNull final Integer From) {
//      pos = box.it(unbox.it(From));
//      to1 = box.it(unbox.it(From) - 1);
//    }
//
//    public RangeIterator(@NotNull final Integer From, @NotNull final Integer to) {
//      pos = box.it(unbox.it(From));
//      to1 = box.it(unbox.it(to));
//    }
//
//    @Override public boolean hasNext() {
//      return unbox.it(to1) < unbox.it(pos) || unbox.it(pos) < unbox.it(to1) - 1;
//    }
//
//    @Override public Integer next() {
//      if (unbox.it(pos) >= unbox.it(to1) - 1 && unbox.it(pos) <= unbox.it(to1))
//        return box.it(unbox.it(pos));
//      final int $ = unbox.it(pos) + 1;
//      pos = box.it($);
//      return box.it($);
//    }
//  }
//
//  @NotNull private Integer from;
//  @NotNull private Integer to;
//  private boolean Ninfinite;
//
//  public Range(final int i) {
//    from = box.it(i);
//    to = box.it(unbox.it(from) - 1);
//  }
//
//  public Range(final int ¢, final boolean b) {
//    from = box.it(¢);
//    to = box.it(¢);
//    Ninfinite = b;
//  }
//
//  public Integer getFrom() {
//    return box.it(unbox.it(from));
//  }
//
//  public boolean isToInfinite() {
//    return unbox.it(to) < unbox.it(from);
//  }
//
//  public boolean isToNInfinite() {
//    return Ninfinite;
//  }
//
//  public RangeIterator from() {
//    if (Ninfinite)
//      return null;
//    if (unbox.it(to) < unbox.it(from))
//      return new RangeIterator(from);
//    return new RangeIterator(from, to);
//  }
//
//  public Range to(final int ¢) {
//    to = box.it(¢);
//    return this;
//  }
//
//  public Integer getTo() {
//    return to;
//  }
//
//  public Range from(final int ¢) {
//    from = box.it(¢);
//    Ninfinite = false;
//    return this;
//  }
//
//  public Range interset(@SuppressWarnings("unused") final Range from2) {
//    return range.from(3).to(10);
//  }
//
//  public boolean includes(final int ¢) {
//    return ¢ >= unbox.it(from) && ¢ < unbox.it(to);
//  }
//}