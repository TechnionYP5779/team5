package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.idiomatic.*;
import il.org.spartan.beginning.with.C.D.E.*;

@SuppressWarnings("static-method") public class TestIdiomatic {
  @Test public void testHolder() {
    Holder<Integer> hold=idiomatic.eval(()->42);
    assertEquals(hold.when(true), Integer.valueOf(42));
    assertEquals(hold.unless(false), Integer.valueOf(42));
    assertEquals(hold.unless(true),null);
    assertEquals(hold.when(false), null);
    
  }
  
  @Test public void testIncase() {
    Integer val=idiomatic.incase(true, Integer.valueOf(42));
    assertEquals(val, Integer.valueOf(42));
    
    val=idiomatic.incase(false, Integer.valueOf(42));
    assertEquals(val,null);
    
  }
  
  @Test public void testKatching() {
    Producer<Integer> notThrow=()->42;
    Producer<Integer> Throw=()->{
      throw new Exception();
    };
    
    assertEquals(idiomatic.katching(notThrow), Integer.valueOf(42));
    assertEquals(idiomatic.katching(Throw), null);
    
  }
  
  @Test public void testQuote() {
    assertEquals(idiomatic.quote("helloWorld"), "'helloWorld'");
    assertEquals(idiomatic.quote(null), "<null reference>");
  }
  
  @Test public void testStorer() {
    Storer<Integer> storer=new Storer<Integer>(Integer.valueOf(42));
    assertEquals(storer.when(true), Integer.valueOf(42));
    assertEquals(storer.when(false), null);
    assertEquals(storer.unless(false), Integer.valueOf(42));
    assertEquals(storer.unless(true),null);
    assertEquals(storer.get(), Integer.valueOf(42));
    assertEquals(idiomatic.take(Integer.valueOf(42)).unless(false),Integer.valueOf(42));
    assertEquals(idiomatic.take(Integer.valueOf(42)).unless(true),null);
  }
  
  @Test public void use0() {
    assert new Storer<>(this) != null;
  }

  @Test public void use08() {
    azzert.isNull(idiomatic.unless(true).eval(() -> new Object()));
  }

  @Test public void use09() {
    assert idiomatic.unless(false).eval(() -> new Object()) != null;
  }

  @Test public void use1() {
    assert new Storer<>(this) != null;
    new Storer<>(this).when(true);
  }

  @Test public void use10() {
    assert idiomatic.when(true).eval(() -> new Object()) != null;
  }

  @Test public void use11() {
    azzert.isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @Test public void use2() {
    assert idiomatic.take(this) != null;
    azzert.isNull(idiomatic.take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(idiomatic.take(this).when(true), is(this));
  }

  @Test public void use4() {
    azzert.isNull(idiomatic.take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(idiomatic.take(this).unless(false), is(this));
  }

  @Test public void use6() {
    azzert.isNull(idiomatic.take(this).unless(true));
  }

  @Test public void use7() {
    azzert.isNull(idiomatic.take(this).unless(true));
    azzert.isNull(idiomatic.take(null).unless(true));
    azzert.isNull(idiomatic.take(null).unless(false));
  }
}
