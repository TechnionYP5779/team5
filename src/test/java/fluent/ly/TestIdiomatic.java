package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.idiomatic.*;
import il.org.spartan.beginning.with.C.D.E.*;

@SuppressWarnings("static-method") public class TestIdiomatic {
  @Test public void testHolder() {
    final Holder<Integer> hold = idiomatic.eval(() -> 42);
    azzert.that(hold.when(true), azzert.is(Integer.valueOf(42)));
    azzert.that(hold.unless(false), azzert.is(Integer.valueOf(42)));
    azzert.isNull(hold.unless(true));
    azzert.isNull(hold.when(false));
  }

  @Test public void testIncase() {
    Integer val = idiomatic.incase(true, Integer.valueOf(42));
    azzert.that(val, azzert.is(Integer.valueOf(42)));
    val = idiomatic.incase(false, Integer.valueOf(42));
    azzert.isNull(val);
  }

  @Test public void testKatching() {
    final Producer<Integer> notThrow=()->42;
    final Producer<Integer> Throw=()->{
      throw new Exception();
    };

    azzert.that(idiomatic.katching(notThrow), azzert.is(Integer.valueOf(42)));
    azzert.isNull(idiomatic.katching(Throw));

  }

  @Test public void testQuote() {
    azzert.that(idiomatic.quote("helloWorld"), azzert.is("'helloWorld'"));
    azzert.that(idiomatic.quote(null), azzert.is("<null reference>"));
  }

  @Test public void testStorer() {
    final Storer<Integer> storer = new Storer<>(Integer.valueOf(42));
    azzert.that(storer.when(true), azzert.is(Integer.valueOf(42)));
    azzert.isNull(storer.when(false));
    azzert.that(storer.unless(false), azzert.is(Integer.valueOf(42)));
    azzert.isNull(storer.unless(true));
    azzert.that(storer.get(), azzert.is(Integer.valueOf(42)));
    azzert.that(idiomatic.take(Integer.valueOf(42)).unless(false), azzert.is(Integer.valueOf(42)));
    azzert.isNull(idiomatic.take(Integer.valueOf(42)).unless(true));
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
