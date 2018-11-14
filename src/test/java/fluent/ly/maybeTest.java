package fluent.ly;

import org.junit.*;
import static fluent.ly.azzert.*;
@SuppressWarnings("static-method") public class maybeTest {
  @Test public void usecase0() {
    isNull(maybe.no().get());
  }

  @Test public void usecase1() {
    isNull(maybe.yes(null).get());
  }

  @Test public void usecase2() {
    assert maybe.yes(new Object()).get() != null;
  }
}
