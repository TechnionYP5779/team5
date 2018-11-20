package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.idiomatic.*;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test public void testHolder() {
    final Holder<Integer> hold = idiomatic.eval(() -> box.it(42));
    azzert.that(hold.when(true), is(box.it(42)));
    azzert.that(hold.unless(false), is(box.it(42)));
    isNull(hold.unless(true));
    isNull(hold.when(false));
  }

  @Test public void testIncase() {
    Integer val = idiomatic.incase(true, box.it(42));
    azzert.that(val, is(box.it(42)));
    val = idiomatic.incase(false, box.it(42));
    isNull(val);
  }

  @Test public void testQuote() {
    azzert.that(idiomatic.quote("helloWorld"), is("'helloWorld'"));
    azzert.that(idiomatic.quote(null), is("<null reference>"));
  }

  @Test public void testStorer() {
    final Storer<Integer> storer = new Storer<>(box.it(42));
    azzert.that(storer.when(true), is(box.it(42)));
    isNull(storer.when(false));
    azzert.that(storer.unless(false), is(box.it(42)));
    isNull(storer.unless(true));
    azzert.that(storer.get(), is(box.it(42)));
    azzert.that(idiomatic.take(box.it(42)).unless(false), is(box.it(42)));
    isNull(idiomatic.take(box.it(42)).unless(true));
  }

  @Test public void use0() {
    assert new Storer<>(this) != null;
  }

  @Test public void use08() {
    isNull(idiomatic.unless(true).eval(() -> new Object()));
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
    isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @Test public void use2() {
    assert idiomatic.take(this) != null;
    isNull(idiomatic.take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(idiomatic.take(this).when(true), is(this));
  }

  @Test public void use4() {
    isNull(idiomatic.take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(idiomatic.take(this).unless(false), is(this));
  }

  @Test public void use6() {
    isNull(idiomatic.take(this).unless(true));
  }

  @Test public void use7() {
    isNull(idiomatic.take(this).unless(true));
    isNull(idiomatic.take(null).unless(true));
    isNull(idiomatic.take(null).unless(false));
  }
}
