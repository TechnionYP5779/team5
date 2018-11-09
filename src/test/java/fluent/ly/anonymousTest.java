 package fluent.ly;

import org.junit.*;

public class anonymousTest {
  @Test @SuppressWarnings("static-method") public void lyBooleanTest() {
    azzert.assertEquals(true, anonymous.ly(() -> true));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void lyDoubleTest() {
    azzert.assertEquals(1.23, anonymous.ly(() -> 1.23), 0.0001);
  }

  @Test @SuppressWarnings("static-method") public void lyIntTest() {
    azzert.assertEquals(1, anonymous.ly(() -> 1));
  }

  @Test @SuppressWarnings({ "static-access", "static-method" }) public void lylongTest() {
    azzert.assertEquals(Long.MAX_VALUE, anonymous.ly(() -> Long.MAX_VALUE));
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void lyAnyTest() {
    final Object o = new Object();
    azzert.assertEquals(o, anonymous.ly(() -> o));
  }
}
