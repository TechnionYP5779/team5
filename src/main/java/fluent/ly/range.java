package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

/** @author Nir Chachamovitz
 * @since 2018-11-22 */
@SuppressWarnings({ "static-method", "boxing" }) public class range {
  public class rangeIterator implements Iterator<Integer> {
    @NotNull private Integer pos;
    @NotNull private final Integer to1;

    public rangeIterator(@NotNull final Integer From) {
      pos = box.it(unbox.it(From));
      to1 = box.it(unbox.it(From) - 1);
    }

    public rangeIterator(@NotNull final Integer From, @NotNull final Integer to) {
      pos = box.it(unbox.it(From));
      to1 = box.it(unbox.it(to));
    }

    @Override public boolean hasNext() {
      return unbox.it(to1) < unbox.it(pos) || unbox.it(pos) < unbox.it(to1) - 1;
    }

    @Override public Integer next() {
      if (unbox.it(pos) >= unbox.it(to1) - 1 && unbox.it(pos) <= unbox.it(to1))
        return box.it(unbox.it(pos));
      final int $ = unbox.it(pos) + 1;
      pos = box.it($);
      return box.it($);
    }
  }

  @NotNull Integer from;
  @NotNull Integer to;
  public static rangeIterator numbers = range.from(Integer.MIN_VALUE).to(Integer.MAX_VALUE).from();
  boolean bounded_below, bounded_above;
  boolean is_empty;

  // bounded = false => bounded below
  // bounded = true => bounded above
  public range(final int a, final boolean bounded) {
    from = !bounded ? box.it(a) : Integer.MIN_VALUE;
    to = bounded ? box.it(a) : Integer.MAX_VALUE;
    bounded_below = !bounded;
    bounded_above = bounded;
  }

  public range(final int a, final int b) {
    from = box.it(a);
    to = box.it(b);
    bounded_below = false;
    bounded_above = false;
    is_empty = b < a;
  }

  /**
   *
   */
  @SuppressWarnings("null") public range() {
  }

  // public range(final int ¢, final boolean b) {
  // from = box.it(¢);
  // to = box.it(¢);
  // Ninfinite = b;
  // }
  public boolean isToInfinite() {
    return bounded_below && !bounded_above;
  }

  public boolean isFromInfinite() {
    return bounded_above && !bounded_below;
  }

  public rangeIterator from() {
    if (isFromInfinite())
      return null;
    if (unbox.it(to) < unbox.it(from))
      return new rangeIterator(from);
    return new rangeIterator(from, to);
  }

  // public range to(final int ¢) {
  // // to = box.it(¢);
  // // bounded_above = true;
  // // return this;
  // if (from != Integer.MIN_VALUE)
  // return new range(from, box.it(¢));
  // return new range(box.it(¢), true);
  // }
  public static rangedFrom from(final int ¢) {
    // from = box.it(¢);
    // bounded_below = true;
    // return this;
    // return new range(box.it(¢), false).new rangedFrom();
    return new range() {
      {
        from = ¢;
        bounded_below = true;
        bounded_above = false;
      }
    }.new rangedFrom();
  }

  public rangedTo interset(final range from2) {
    return range.from(from2.from).to(from2.to);
  }

  // public boolean includes(final int ¢) {
  // return ¢ >= unbox.it(from) && ¢ < unbox.it(to);
  // }
  public static rangedTo to(final int ¢) {
    return new range() {
      {
        from = to = ¢;
        bounded_below = true;
        bounded_above = false;
      }
    }.new rangedTo();
  }

  public class rangedFrom {
    public rangedTo to(final int ¢) {
      to = ¢;
      return new rangedTo() {
        {
          to = ¢;
          bounded_above = false;
        }
      };
    }

    public int getFrom() {
      return from;
    }

    public rangeIterator from() {
      return new rangeIterator(from);
    }

    public boolean isToInfinite() {
      return bounded_below;
    }

    public boolean isFromInfinite() {
      return !bounded_below;
    }
    // range from(final int ¢) {
    // return new range(¢, false);
    // }
    // range to(final int ¢) {
    // return new range(¢, true);
    // }
  }

  public class rangedTo {
    public rangeIterator from() {
      return new rangeIterator(from);
    }

    public boolean includes(final int ¢) {
      return ¢ >= unbox.it(from) && ¢ < unbox.it(to);
    }

    public rangedTo from(final int ¢) {
      return new rangedTo() {
        {
          from = ¢;
          bounded_above = false;
          bounded_below = false;
        }
      };
    }

    public int getFrom() {
      return from;
    }

    public int getTo() {
      return to;
    }

    public rangedTo interset(final rangedFrom ¢) {
      return range.from(¢.getFrom()).to(to);
    }
  }
}