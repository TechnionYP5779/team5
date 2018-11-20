package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void test1() {
    azzert.that(angle.degrees(20).getDegrees(), is((double) 20));
  }
  
  @Test public void test2() {
    azzert.that(angle.radians(1).getRadians(), is((double) 1));
  }
  
  @Test public void test3() {
    azzert.that(angle.pi.getRadians(), is(Math.PI));
  }
  
  @Test public void test4() {
    azzert.that(angle.halfPi.getRadians(), is(Math.PI/2));
  }
  
  @Test public void test5() {
    azzert.that(angle.halfPi.add(angle.degrees(20)).getDegrees(), is((double)110));
  }
  
  @Test public void test6() {
    azzert.that(angle.halfPi.add(20).getDegrees(), is((double)110));
  }
}
