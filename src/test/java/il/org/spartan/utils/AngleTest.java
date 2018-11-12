package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

import fluent.ly.*;

public class angleTest {
  @Test public void angleCreate() {
    azzert.that(angle.Degrees(20).getDegrees(), azzert.is((double)20));
  }
}
