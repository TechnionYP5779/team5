package fluent.ly;

import org.junit.*;

import il.org.spartan.utils.*;

public class forgetTest {
  // @Test
  // public void test() {
  // forget.all(new String(),new String(), new String());
  // forget.it(true);
  // forget.it(false);
  // forget.it(Double.MAX_VALUE);
  // forget.it(Long.MAX_VALUE);
  // forget.it((Object)new String());
  // }
  // forget f = new forget()
  // {
  // public void all(final Object _1, final Object ..._2) {
  // if(_1.getClass().equals(getClass())){
  // System.out.println("who?");
  // }
  // else {
  // int n = 0;
  // for(Object o : _2) {
  // if(getClass().equals(o.getClass())) {
  // n++;
  // }
  // }
  // System.out.println("Who are those "+n+" people?");
  // }
  // }
  //
  // public void it(final boolean $) {
  // String str = $? "I don't remember" : "I do remember";
  // System.out.println(str);
  // }
  //
  // public void it(final double $) {
  // String str = $>80? "I am young as always" : "why am I so old";
  // System.out.println(str);
  // }
  //
  // public void it(final long $) {
  // String str = $>80? "I am young as always" : "why am I so old";
  // System.out.println(str);
  // }
  //
  // public void it(final Object o) {
  // String str = o.getClass().equals(getClass())? "o is just fine" : "o is mad";
  // System.out.println(str);
  // }
  // }; 
  @Test public void test_all() {
    forget.all(new Pair<>(1, 2), new Pair<>(1, 2), new Pair<>(1, 2),
        new Pair<>(1, 2));// should print "who?"
    forget.all(new Pair<>(1, 2));// should print "who?"
    forget.all(new String(), new Pair<>(1, 2), new Pair<>(1, 2), new Pair<>(1, 2));// should print
                                                                                                                                   // "who are those 3
                                                                                                                                   // people?"
    forget.all(new String());// should print "who are those 0 people?"
    forget.all(new String(), new Pair<>(1, 2), new Pair<>(1, 2), "varargs");// should print "who are those 2 people?"
  }

  @Test public void test_it() {
    forget.it(true);// should print "I don't remember"
    forget.it(false);// should print "I do remember"
    forget.it(81);// should print "I am young as always"
    forget.it(79.99999999);// should print "why am I so old"
    forget.it(Double.MAX_VALUE);// should print "I am young as always"
    forget.it(Double.MIN_VALUE);// should print "I don't remember"
    forget.it(Long.MAX_VALUE);// should print "I am young as always"
    forget.it(new Pair<>(1, 2));// should print "o is just fine"
    forget.it((Object) Long.MAX_VALUE);// should print "o is mad"
  }
}
