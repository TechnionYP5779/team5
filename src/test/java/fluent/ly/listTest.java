package fluent.ly;

import java.util.*;
import java.util.stream.*;
import static fluent.ly.azzert.is;
import static fluent.ly.azzert.isNull;
import org.junit.*;

@SuppressWarnings("static-method") public class listTest {
  @SuppressWarnings("null") @Test public void append() {
    final List<Integer> l = IntStream.range(0, 5).boxed().collect(Collectors.toList()),
        until5 = IntStream.range(0, 6).boxed().collect(Collectors.toList());
    azzert.that(until5, is(list.append(box.it(5)).to(l)));
  }

  @SuppressWarnings("null") @Test public void preppend() {
    final List<Integer> l = IntStream.range(0, 5).boxed().collect(Collectors.toList()),
        fromM1 = IntStream.range(-1, 5).boxed().collect(Collectors.toList());
    azzert.that(fromM1, is(list.prepend(box.it(-1)).to(l)));
  }

  @Test public void nullPenultimate() {
    isNull(list.penultimate(null));
  }

  @Test public void emptyPenultimate() {
    isNull(list.penultimate(new ArrayList<Integer>()));
  }

  @Test public void penultimate() {
    azzert.that(box.it(3), is(list.penultimate(IntStream.range(0, 5).boxed().collect(Collectors.toList()))));
  }

  @SuppressWarnings("null") @Test public void emptyTo() {
    final List<Integer> l = IntStream.range(1, 4).boxed().collect(Collectors.toList());
    azzert.that(l, is(list.append(box.it(1)).to().append(box.it(2)).to().append(box.it(3)).to(new ArrayList<Integer>())));
  }
}
