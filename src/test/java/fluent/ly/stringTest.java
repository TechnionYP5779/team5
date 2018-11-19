package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class stringTest {
  @Test public void test_test() {
    azzert.that(string.MAX_FIRST, is(20));
  }

  double epsilon = 10e-5;

  @Test public void test_atod() {
    @NotNull final Double $ = box.it(string.atod("42.001"));
    @NotNull final String s = new String("333");
    @NotNull final Double $2 = box.it(string.atod(s));
    azzert.that(true, is(unbox.it($) > 42.00));
    azzert.that(true, is(unbox.it($2) == 333.0));
    azzert.that(false, is(unbox.it($) == 42));
  }

  @Test public void test_atof() {
    final double $2 = string.atof(new String("333"));
    azzert.that(true, is(string.atof("42.001") > 42.00));
    azzert.that(true, is($2 == 333.0));
  }

  @Test public void test_atoi() {
    final double $2 = string.atoi(new String("333"));
    azzert.that(true, is(string.atoi("42") == 42));
    azzert.that(true, is($2 == 333));
  }

  @Test public void test_atol() {
    final double $ = string.atol("42"), $2 = string.atol(new String("333"));
    azzert.that(true, is($ == 42));
    azzert.that(true, is($2 == 333));
    azzert.that(true, is(Long.MAX_VALUE != $));
  }

  @Test public void test_capitalize() {
    final String s2 = string.capitalize("Hello"), s3 = string.capitalize("hello"), s4 = string.capitalize("hELLo"), s5 = string.capitalize("h");
    azzert.that(string.capitalize(""), is(""));
    azzert.that(s2, is("Hello"));
    azzert.that(s3, is("Hello"));
    azzert.that(s4, is("Hello"));
    azzert.that(s5, is("H"));
  }

  @Test public void test_cat() {
    @NotNull final String[] l1 = { "Hello", " ", "World" }, l2 = { " ", " what", " ", "happen" };
    final String s2 = string.cat(l1, l2);
    azzert.that(string.cat("Hello", " ", "World"), is("Hello World"));
    azzert.that(s2, is("Hello World  what happen"));
  }

  @Test public void test_delta() {
    final double d1 = 3.4, d2 = 3.5, d3 = 3.4;
    azzert.that(true, is(Math.abs(0.2 / 6.9 - string.delta(d1, d2)) < epsilon));
    azzert.that(true, is(Math.abs(0.2 / 6.9 - string.delta(d2, d1)) < epsilon));
    azzert.that(true, is(string.delta(d1, d3) == 0));
    azzert.that("NaN", is(string.delta(-1, 1) + ""));
  }

  @Test public void test_dtoa() {
    azzert.that(string.dtoa(4.3), is("4.3"));
    azzert.that(string.dtoa(Double.MAX_VALUE), is(Double.MAX_VALUE + ""));
  }

  @Test public void test_eq() {
    azzert.that(true, is(string.eq(box.it(4), box.it(4))));
    azzert.that(false, is(string.eq(box.it(3), box.it(4))));
    azzert.that(true, is(string.eq(null, null)));
    azzert.that(false, is(string.eq(box.it(4), null)));
    azzert.that(false, is(string.eq(null, box.it(4))));
    azzert.that(true, is(string.eq(new Pair<>(box.it(1), box.it(2)), new Pair<>(box.it(1), box.it(2)))));
  }

  @Test public void test_esc() {
    azzert.that(string.esc('\n'), is("\\n"));
    azzert.that(string.esc('\r'), is("\\r"));
    azzert.that(string.esc('\t'), is("\\t"));
    azzert.that(string.esc('\f'), is("\\f"));
    azzert.that(string.esc('\b'), is("\\b"));
    azzert.that(string.esc('\\'), is("\\\\"));
    azzert.that(string.esc('\''), is("\'"));
    azzert.that(string.esc('\"'), is("\""));
    azzert.that(string.esc('g'), is("g"));
    azzert.that(string.esc(null), is("(null)"));
    azzert.that(string.esc("hello"), is("hello"));
    azzert.that(string.esc("he\bllo"), is("he\\bllo"));
    azzert.that(string.esc("hel\\lo"), is("hel\\\\lo"));
    azzert.that(string.esc("hel\"lo"), is("hel\"lo"));
  }

  @Test public void test_expandLeadingTabs() {
    azzert.that(string.expandLeadingTabs("hello"), is("hello"));
  }

  @Test public void test_fill() {
    azzert.that(string.fill(5, 'c'), is("ccccc"));
    azzert.that(string.fill(3, "sc"), is("scscsc"));
    azzert.that(string.fill(1, 'c'), is("c"));
  }

  @Test public void test_first() {
    azzert.that(string.first("cello"), is('c'));
    azzert.that(string.first("c"), is('c'));
    azzert.that(string.first("Cello"), is('C'));
    azzert.that(string.first("$ello"), is('$'));
    azzert.that(string.first("\tcello"), is('\t'));
    azzert.that(false, is(string.first("\tcello") == '\''));
  }

  @Test public void test_ftoa() {
    azzert.that(string.ftoa(Float.MAX_VALUE), is(Float.MAX_VALUE + ""));
  }

  @Test public void test_isDouble() {
    azzert.that(true, is(string.isDouble("4.3")));
    azzert.that(true, is(string.isDouble(Double.MAX_VALUE + "")));
    azzert.that(false, is(string.isDouble("4O")));
    azzert.that(false, is(string.isDouble("#")));
    azzert.that(false, is(string.isDouble("\t")));
  }

  @Test public void test_isFloat() {
    azzert.that(true, is(string.isFloat("4.3")));
    azzert.that(true, is(string.isFloat(Float.MAX_VALUE + "")));
    azzert.that(false, is(string.isFloat("4O")));
    azzert.that(false, is(string.isFloat("#")));
    azzert.that(false, is(string.isFloat("\t")));
  }

  @Test public void test_isInt() {
    azzert.that(false, is(string.isInt("4.3")));
    azzert.that(true, is(string.isInt(Integer.MAX_VALUE + "")));
    azzert.that(false, is(string.isInt(Long.MAX_VALUE + "")));
    azzert.that(false, is(string.isInt("4O")));
    azzert.that(false, is(string.isInt("#")));
    azzert.that(false, is(string.isInt("\t")));
  }

  @Test public void test_isLong() {
    azzert.that(false, is(string.isLong("4.3")));
    azzert.that(true, is(string.isLong(Integer.MAX_VALUE + "")));
    azzert.that(true, is(string.isLong(Long.MAX_VALUE + "")));
    azzert.that(false, is(string.isLong("4O")));
    azzert.that(false, is(string.isLong("#")));
    azzert.that(false, is(string.isLong("\t")));
  }

  @Test public void test_itoa() {
    azzert.that(string.itoa(Integer.MAX_VALUE), is(Integer.MAX_VALUE + ""));
  }

  @Test public void test_javaCase() {
    final String s2 = string.javaCase("Hello"), s3 = string.javaCase("hello"), s4 = string.javaCase("hELLo"), s5 = string.javaCase("h");
    azzert.that(string.javaCase(""), is(""));
    azzert.that(s2, is("hello"));
    azzert.that(s3, is("hello"));
    azzert.that(s4, is("hELLo"));
    azzert.that(s5, is("h"));
  }

  @Test public void test_last() {
    azzert.that(string.last("cello"), is('o'));
    azzert.that(string.last("c"), is('c'));
    azzert.that(string.last("CelloC"), is('C'));
    azzert.that(string.last("$ello$"), is('$'));
    azzert.that(string.last("\tcello\t"), is('\t'));
    azzert.that(false, is(string.last("\tcello\\") == '\''));
  }

  @Test public void test_lowCounter() {
    azzert.that(string.lowCounter(-1), is(""));
    azzert.that(string.lowCounter(0), is("a"));
    azzert.that(string.lowCounter(100), is("dw"));
    azzert.that(string.lowCounter(8), is("i"));
  }

  @Test public void test_ltoa() {
    azzert.that(string.ltoa(Long.MAX_VALUE), is(Long.MAX_VALUE + ""));
  }

  @Test public void test_ordinal() {
    azzert.that(string.ordinal(1), is("1st"));
    azzert.that(string.ordinal(21), is("21st"));
    azzert.that(string.ordinal(2), is("2nd"));
    azzert.that(string.ordinal(22), is("22nd"));
    azzert.that(string.ordinal(11), is("11th"));
    azzert.that(string.ordinal(12), is("12th"));
    azzert.that(string.ordinal(3333), is("3333th"));
  }

  @Test public void test_paren() {
    azzert.that(string.paren(box.it(4)), is("(4)"));
    azzert.that(string.paren("$"), is("($)"));
    azzert.that(string.paren(new Pair<>(box.it(1), box.it(2))), is("(<1,2>)"));
  }

  @Test public void test_pluralize() {
    azzert.that(string.pluralize(0, "hope"), is("no hopes"));
    azzert.that(string.pluralize(1, "hope"), is("hope"));
    azzert.that(string.pluralize(2, "hope"), is("two hopes"));
    azzert.that(string.pluralize(3, "hope"), is("three hopes"));
    azzert.that(string.pluralize(4, "hope"), is("four hopes"));
    azzert.that(string.pluralize(5, "hope"), is("five hopes"));
    azzert.that(string.pluralize(6, "hope"), is("six hopes"));
    azzert.that(string.pluralize(7, "hope"), is("seven hopes"));
    azzert.that(string.pluralize(8, "hope"), is("eight hopes"));
    azzert.that(string.pluralize(9, "hope"), is("nine hopes"));
    azzert.that(string.pluralize(20, "hope"), is("20 hopes"));
    azzert.that(string.pluralize(4, "party", "parties"), is("four parties"));
  }

  @Test public void test_pretty() {
    azzert.that(string.pretty("hope", new ArrayList<Integer>()), is(""));
    azzert.that(string.pretty("course", "courses", new ArrayList<>(Arrays.asList(box.it(234311)))), is("1 course: 234311\n"));
    final List<Integer> l = new ArrayList<>();
    for (int ¢ = 0; ¢ < 50; ¢++)
      l.add(box.it(¢));
    String s1 = "10 hopes:\n", s2 = "40 hopes:\n";
    for (int ¢ = 0; ¢ < 20; ¢++) {
      if (¢ < 10)
        s1 += "\t" + (¢ + 1) + ") " + ¢ + "\n";
      s2 += "\t" + (¢ + 1) + ") " + ¢ + "\n";
    }
    s2 += "\t...\n" + string.repeat(9, "null");
    for (int ¢ = 30; ¢ < 40; ¢++)
      s2 += "\t" + (¢ + 1) + ") " + ¢ + "\n";
    azzert.that(string.pretty("hope", "hopes", l.subList(0, 10)), is(s1));
    azzert.that(string.pretty("hope", "hopes", l.subList(0, 40)), is(s2));
  }

  @Test public void test_quote() {
    azzert.that(string.quote("let it be epsilon>0"), is("'let it be epsilon>0'"));
    azzert.that(string.quote("\tlet it be epsilon>0\t"), is("'\tlet it be epsilon>0\t'"));
    azzert.that(string.quote(box.it(42)), is("'42'"));
  }

  @Test public void test_repeat() {
    azzert.that(string.repeat(5, 'c'), is("ccccc"));
    azzert.that(string.repeat(3, "sc"), is("scscsc"));
    azzert.that(string.repeat(1, 'c'), is("c"));
  }

  @Test public void test_signum() {
    azzert.that(string.signum(0), is(0));
    azzert.that(string.signum(1), is(1));
    azzert.that(string.signum(-1), is(-1));
    azzert.that(string.signum(Double.MAX_VALUE), is(1));
    azzert.that(string.signum(-Double.MAX_VALUE), is(-1));
  }

  @Test public void test_sprintf() {
    @NotNull final String[] a = {}, b = { "hell" }, c = { "what %s %s", "the", "hell" };
    azzert.that(string.sprintf(a), is(""));
    azzert.that(string.sprintf(b), is("hell"));
    azzert.that(string.sprintf("hello %s %s %s", "world", "what", "the..."), is("hello world what the..."));
    azzert.that(string.sprintf(c), is("what the hell"));
  }

  @Test public void test_strip() {
    azzert.that(string.strip("he"), is(""));
    azzert.that(string.strip("hell"), is("el"));
    try {
      string.strip("");
    } catch (@SuppressWarnings("unused") final RuntimeException ¢) {
      // ¢.printStackTrace();
      assert true;
      return;
    }
    assert false;
  }

  @Test public void test_toLines() {
    try {
      final List<String> l1 = string.toLines("hello world\n\twhat\nis up\ndone\n\n");
      azzert.that(l1.get(0), is("hello world"));
      azzert.that(l1.get(1), is("\twhat"));
      azzert.that(l1.get(2), is("is up"));
      azzert.that(l1.get(3), is("done"));
      azzert.that(l1.get(4), is(""));
    } catch (final IOException ¢) {
      ¢.printStackTrace();
    }
  }

  @Test public void test_upCounter() {
    azzert.that(string.upCounter(-1), is(""));
    azzert.that(string.upCounter(0), is("A"));
    azzert.that(string.upCounter(100), is("DW"));
    azzert.that(string.upCounter(8), is("I"));
  }

  @Test public void test_visualize() {
    azzert.that(string.visualize("\n"), is("\\n"));
    azzert.that(string.visualize("\r"), is("\\r"));
    azzert.that(string.visualize("\t"), is("\\t"));
    azzert.that(string.visualize("\f"), is("\\f"));
    azzert.that(string.visualize("\b"), is("\\b"));
    azzert.that(string.visualize("\\"), is("\\\\"));
    azzert.that(string.visualize("\'"), is("\'"));
    azzert.that(string.visualize("\""), is("\""));
    azzert.that(string.visualize("g"), is("g"));
    // azzert.that(string.visualize("hello"), is("hello"));
    azzert.that(string.visualize("he\bllo"), is("he\\bllo"));
    azzert.that(string.visualize("hel\\lo"), is("hel\\\\lo"));
    azzert.that(string.visualize("hel\"lo"), is("hel\"lo"));
  }

  @Test public void test_wrap() {
    azzert.that(string.wrap('\'', "(gelli)"), is("'(gelli)'"));
    azzert.that(string.wrap('\t', "(gelli)"), is("\t(gelli)\t"));
    azzert.that(string.wrap('\n', "(gelli)"), is("\n(gelli)\n"));
    azzert.that(string.wrap("'", "(gelli)"), is("'(gelli)'"));
    azzert.that(string.wrap("s", "(gelli)"), is("s(gelli)s"));
    azzert.that(string.wrap("()", "(gelli)"), is("()(gelli)()"));
  }
}
