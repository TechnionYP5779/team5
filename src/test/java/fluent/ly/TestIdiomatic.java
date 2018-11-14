package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.idiomatic.*;

@SuppressWarnings("static-method") public class TestIdiomatic {
  @Test public void testHolder() {
    final Holder<Integer> hold = idiomatic.eval(() -> box.box(42));
    azzert.that(hold.when(true), azzert.is(box.box(42)));
    azzert.that(hold.unless(false), azzert.is(box.box(42)));
    azzert.isNull(hold.unless(true));
    azzert.isNull(hold.when(false));
  }

  @Test public void testIncase() {
    Integer val = idiomatic.incase(true, box.box(42));
    azzert.that(val, azzert.is(box.box(42)));
    val = idiomatic.incase(false, box.box(42));
    azzert.isNull(val);
  }

  @Test public void testQuote() {
    azzert.that(idiomatic.quote("helloWorld"), azzert.is("'helloWorld'"));
    azzert.that(idiomatic.quote(null), azzert.is("<null reference>"));
  }

  @Test public void testStorer() {
    final Storer<Integer> storer = new Storer<>(box.box(42));
    azzert.that(storer.when(true), azzert.is(box.box(42)));
    azzert.isNull(storer.when(false));
    azzert.that(storer.unless(false), azzert.is(box.box(42)));
    azzert.isNull(storer.unless(true));
    azzert.that(storer.get(), azzert.is(box.box(42)));
    azzert.that(idiomatic.take(box.box(42)).unless(false), azzert.is(box.box(42)));
    azzert.isNull(idiomatic.take(box.box(42)).unless(true));
  }

  @SuppressWarnings("null") @Test public void use0() {
    azzert.assertTrue(new Storer<>(this) != null);
  }

  @Test public void use08() {
    azzert.isNull(idiomatic.unless(true).eval(() -> new Object()));
  }

  @Test public void use09() {
    azzert.assertTrue(idiomatic.unless(false).eval(() -> new Object()) != null);
  }

  @SuppressWarnings("null") @Test public void use1() {
    azzert.assertTrue(new Storer<>(this) != null);
    new Storer<>(this).when(true);
  }

  @Test public void use10() {
    azzert.assertTrue(idiomatic.when(true).eval(() -> new Object()) != null);
  }

  @Test public void use11() {
    azzert.isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @SuppressWarnings("null") @Test public void use2() {
    azzert.assertTrue(idiomatic.take(this) != null);
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
