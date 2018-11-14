package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void angleCreate() {
    azzert.that(angle.degrees(20).getDegrees(), is((double) 20));
    azzert.that(angle.radians(1).getRadians(), is((double) 1));
    azzert.that(angle.pi.getRadians(), is(Math.PI));
  }
}
