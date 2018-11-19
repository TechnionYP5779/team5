package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void lyBooleanTest() {
    azzert.that(true, azzert.is(anonymous.ly(() -> true)));
  }

  @Test public void lyDoubleTest() {
    azzert.that(anonymous.ly(() -> 1.23), azzert.is(1.23));
  }

  @Test public void lyIntTest() {
    azzert.that(1, azzert.is(anonymous.ly(() -> 1)));
  }

  @Test public void lylongTest() {
    azzert.that(anonymous.ly(() -> Long.MAX_VALUE), azzert.is(Long.MAX_VALUE));
  }

  @Test public void lyAnyTest() {
    final Object o = new Object();
    azzert.that(anonymous.ly(() -> o), azzert.is(o));
  }
}
