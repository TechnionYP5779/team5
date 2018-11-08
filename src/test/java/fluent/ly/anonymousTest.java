package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

public class anonymousTest {
  @Test public void lyBooleanTest() {
    assertEquals(true, anonymous.ly(() -> true));
  }

  @Test public void lyDoubleTest() {
    assertEquals(1.23, anonymous.ly(() -> 1.23), 0.0001);
  }

  @Test public void lyIntTest() {
    assertEquals(1, anonymous.ly(() -> 1));
  }

  @Test public void lylongTest() {
    assertEquals(Long.MAX_VALUE, anonymous.ly(() -> Long.MAX_VALUE));
  }

  @Test public void lyAnyTest() {
    final Object o = new Object();
    assertEquals(o, anonymous.ly(() -> o));
  }
}
