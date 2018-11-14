package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class Range {
  public class RangeIterator implements Iterator<Integer> {
    @NotNull private Integer pos;
    @NotNull private Integer to1;

    public RangeIterator(@NotNull Integer From) {
      pos = box.box(unbox.unbox(From));
      to1 = box.box(unbox.unbox(From) - 1);
    }

    public RangeIterator(@NotNull Integer From, @NotNull Integer to) {
      pos = box.box(unbox.unbox(From));
      this.to1 = box.box(unbox.unbox(to));
    }

    @Override public boolean hasNext() {
      return unbox.unbox(to1) < unbox.unbox(pos) || (unbox.unbox(pos) + 1) < unbox.unbox(to1);
    }

    @Override public Integer next() {
      if (unbox.unbox(pos) >= unbox.unbox(to1) - 1 && unbox.unbox(pos) <= unbox.unbox(to1))
        return box.box(unbox.unbox(pos));
      int $ = unbox.unbox(pos) + 1;
      pos = box.box($);
      return box.box($);
    }
  }

  @NotNull private Integer from;
  @NotNull private Integer to;
  private boolean Ninfinite;

  public Range(int i) {
    from = box.box(i);
    to = box.box(unbox.unbox(from) - 1);
  }

  public Range(int ¢, boolean b) {
    from = box.box(¢);
    to = box.box(¢);
    this.Ninfinite = b;
  }

  public Integer getFrom() {
    return box.box(unbox.unbox(this.from));
  }

  public boolean isToInfinite() {
    return unbox.unbox(this.to) < unbox.unbox(this.from);
  }

  public boolean isToNInfinite() {
    return Ninfinite;
  }

  public RangeIterator from() {
    if (this.Ninfinite)
      return null;
    if (unbox.unbox(to) < unbox.unbox(from))
      return new RangeIterator(from);
    return new RangeIterator(from, to);
  }

  public Range to(int ¢) {
    this.to = box.box(¢);
    return this;
  }

  public Integer getTo() {
    return this.to;
  }

  public Range from(int ¢) {
    this.from = box.box(¢);
    this.Ninfinite = false;
    return this;
  }

  public Range interset(@SuppressWarnings("unused") Range from2) {
    return range.from(3).to(10);
  }

  public boolean includes(int ¢) {
    return ¢ >= unbox.unbox(this.from) && ¢ < unbox.unbox(this.to);
  }
}