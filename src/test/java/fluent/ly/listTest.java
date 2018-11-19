package fluent.ly;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

@SuppressWarnings("static-method") public class listTest {
  @SuppressWarnings("null") @Test public void append() {
    final List<Integer> l = IntStream.range(0, 5).boxed().collect(Collectors.toList()),
        until5 = IntStream.range(0, 6).boxed().collect(Collectors.toList());
    azzert.that(until5, azzert.is(list.append(box.box(5)).to(l)));
  }

  @SuppressWarnings("null") @Test public void preppend() {
    final List<Integer> l = IntStream.range(0, 5).boxed().collect(Collectors.toList()),
        fromM1 = IntStream.range(-1, 5).boxed().collect(Collectors.toList());
    azzert.that(fromM1, azzert.is(list.prepend(box.box(-1)).to(l)));
  }

  @Test public void nullPenultimate() {
    azzert.isNull(list.penultimate(null));
  }

  @Test public void emptyPenultimate() {
    azzert.isNull(list.penultimate(new ArrayList<Integer>()));
  }

  @Test public void penultimate() {
    azzert.that(box.box(3), azzert.is(list.penultimate(IntStream.range(0, 5).boxed().collect(Collectors.toList()))));
  }

  @SuppressWarnings("null") @Test public void emptyTo() {
    final List<Integer> l = IntStream.range(1, 4).boxed().collect(Collectors.toList());
    azzert.that(l, azzert.is(list.append(box.box(1)).to().append(box.box(2)).to().append(box.box(3)).to(new ArrayList<Integer>())));
  }
}
