package fluent.ly;

import org.junit.*;
@SuppressWarnings("static-method")
public class anonymousTest {
  @Test public void lyBooleanTest() {
    azzert.assertEquals(true, anonymous.ly(() -> true));
  }

  @Test public void lyDoubleTest() {
    Assert.assertEquals(1.23, anonymous.ly(() -> 1.23), 0.0001);
  }

  @Test  public void lyIntTest() {
    azzert.assertEquals(1, anonymous.ly(() -> 1));
  }

  @Test public void lylongTest() {
    Assert.assertEquals(Long.MAX_VALUE, anonymous.ly(() -> Long.MAX_VALUE));
  }

  @Test public void lyAnyTest() {
    final Object o = new Object();
    Assert.assertEquals(o, anonymous.ly(() -> o));
  }
}
