package fluent.ly;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") 
public class nilTest {
  @Test public void testForgetting() {
    Object o = nil.forgetting(new Object());
    azzert.that(o, azzert.is((Object) null));
    o = nil.forgetting(Integer.valueOf(3), Integer.valueOf(7));
    azzert.that(o, azzert.is((Object) null));
  }

  @Test public void testGuardingly() {
    final String helloString1 = "Hello";
    final String nullString1 = null;
    final Integer i1 = nil.guardingly(String::length).on(helloString1);
    azzert.that(i1, azzert.is(Integer.valueOf(5)));
    final Integer i2 = nil.guardingly(String::length).on(nullString1);
    azzert.that(i1, azzert.is(Integer.valueOf(5)));
    azzert.that(i2, azzert.is((String) null));
  }

  @Test public void testBoolIgnoring() {
    Object o = nil.ignoring(false);
    azzert.that(o, azzert.is((Object) null));
    o = nil.ignoring(true);
    azzert.that(o, azzert.is((Object) null));
  }

  @Test public void testDoubleIgnoring() {
    Object o;
    for (double ¢ = 3.14; ¢ <= 102.37; ¢ += Math.E) {
      o = nil.ignoring(¢);
      azzert.that(o, azzert.is((Object) null));
    }
  }

  @Test public void testLongIgnoring() {
    Object o;
    for (long ¢ = 30000; ¢ <= 102000; ¢ += 100) {
      o = nil.ignoring(¢);
      azzert.that(o, azzert.is((Object) null));
    }
  }
  
  static String helloString = "Hello";
  @Test public void t() {
    final Integer i1 = nil.guardingly(String::length).on(helloString);
    azzert.that(i1, azzert.is(5));
    final Integer i2 = nil.guardingly(String::length).on(nullString);
    azzert.that(i1, azzert.is(5));
    azzert.isNull(i2);
    final Integer i3 = nil.guardingly(f).on(nullString);
    azzert.that(i1, azzert.is(5));
    azzert.isNull(i2);
    azzert.isNull(i3);
    nil.guardingly(State::getName).on(null);
    nil.guardingly(State::getName).on(californiaCustomer.getAddress().getState());
  }

  String nullString;
  final Customer californiaCustomer = () -> () -> new State() {
    @Override public String getName() {
      return "California";
    }
  };
  final Function<String, Integer> f = String::length;
  final Customer nullAddressCustomer = () -> null;
  final Customer nullNameCustomer = () -> () -> new State() {/***/
  };
  final Customer nullStateCustomer = () -> () -> null;
  final Customer nullStateCustomer1 = () -> () -> null;

  //@formatter:off
  interface Address { State getState(); }
  interface Customer { Address getAddress(); }
  interface State {default String getName() { return null; } }
}
