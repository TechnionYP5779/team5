package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void test1() {
    azzert.that(angle.degrees(20).degrees(), is((double) 20));
  }
  
  @Test public void test2() {
    azzert.that(angle.radians(1).radians(), is((double) 1));
  }
  
  @Test public void test3() {
    azzert.that(angle.pi.radians(), is(Math.PI));
  }
  
  @Test public void test4() {
    azzert.that(angle.halfPi.radians(), is(Math.PI/2));
  }
  
  @Test public void test5() {
    azzert.that(angle.halfPi.add(angle.degrees(20)).degrees(), is((double)110));
  }
  
  @Test public void test6() {
    azzert.that(angle.halfPi.add(20).degrees(), is((double)110));
  }
  
  @Test public void test7() {
    azzert.that(angle.pi.degrees(), is((double)180));
  }
  
  @Test public void test8() {
    azzert.that(angle.of(180).degrees(), is((double)180));
  }
  
  @Test public void test9() {
    azzert.that(angle.pi.radians(), is(Math.PI));
  }
  
  @Test public void test10() {
    azzert.that(angle.pi.negate().radians(), is(-Math.PI));
  }
  
  @Test public void test11() {
    azzert.that(angle.halfPi.substract(angle.degrees(20)).degrees(), is((double)70));
  }
  
  @Test public void test12() {
    azzert.that(angle.halfPi.substract(20).degrees(), is((double)70));
  }
}
