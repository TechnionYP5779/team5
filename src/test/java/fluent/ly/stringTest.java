package fluent.ly;


import java.io.*;
import java.util.*;

import org.junit.*;

import il.org.spartan.utils.*;

public class stringTest {
  @Test @SuppressWarnings("static-method") public void test_test() {
    azzert.that(string.MAX_FIRST, azzert.is(20));
  }

  double epsilon = 10e-5;

  @Test @SuppressWarnings({ "static-method", "null" }) public void test_atod() {
    final double $ = string.atod("42.001"), $2 = string.atod(String.valueOf(Double.MAX_VALUE));
    azzert.that(true, azzert.is($ > 42.00));
    azzert.that(true, azzert.is(Double.MAX_VALUE == $2));
    azzert.that(false, azzert.is($ == 42));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void test_atof() {
    final double $2 = string.atof(String.valueOf(Float.MAX_VALUE));
    azzert.that(true, azzert.is(string.atof("42.001") > 42.00));
    azzert.that(true, azzert.is(Float.MAX_VALUE == $2));
    azzert.that(false, azzert.is(Integer.MAX_VALUE == $2));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void test_atoi() {
    final double $2 = string.atoi(String.valueOf(Integer.MAX_VALUE));
    azzert.that(true, azzert.is(string.atoi("42") == 42));
    azzert.that(true, azzert.is(Integer.MAX_VALUE == $2));
    azzert.that(false, azzert.is(Float.MAX_VALUE == $2));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void test_atol() {
    final double $ = string.atol("42"), $2 = string.atol(String.valueOf(Long.MAX_VALUE));
    azzert.that(true, azzert.is($ == 42));
    azzert.that(true, azzert.is(Long.MAX_VALUE == $2));
    azzert.that(false, azzert.is(Integer.MAX_VALUE == $));
  }

  @Test @SuppressWarnings("static-method") public void test_capitalize() {
    final String s2 = string.capitalize("Hello"), s3 = string.capitalize("hello"), s4 = string.capitalize("hELLo"), s5 = string.capitalize("h");
    azzert.that(string.capitalize(""), azzert.is(""));
    azzert.that(s2, azzert.is("Hello"));
    azzert.that(s3, azzert.is("Hello"));
    azzert.that(s4, azzert.is("Hello"));
    azzert.that(s5, azzert.is("H"));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void test_cat() {
    final String[] l1 = { "Hello", " ", "World" }, l2 = { " ", " what", " ", "happen" };
    final String s2 = string.cat(l1, l2);
    azzert.that(string.cat("Hello", " ", "World"), azzert.is("Hello World"));
    azzert.that(s2, azzert.is("Hello World  what happen"));
  }

  @Test public void test_delta() {
    final double d1 = 3.4, d2 = 3.5, d3 = 3.4;
    azzert.that(true, azzert.is(Math.abs(0.2 / 6.9 - string.delta(d1, d2)) < epsilon));
    azzert.that(true, azzert.is(Math.abs(0.2 / 6.9 - string.delta(d2, d1)) < epsilon));
    azzert.that(true, azzert.is(string.delta(d1, d3) == 0));
    azzert.that("NaN",azzert.is(string.delta(-1, 1)+""));
  }

  @Test @SuppressWarnings("static-method") public void test_dtoa() {
    azzert.that(string.dtoa(4.3), azzert.is("4.3"));
    azzert.that(string.dtoa(Double.MAX_VALUE), azzert.is(Double.MAX_VALUE + ""));
  }

  @Test @SuppressWarnings({ "static-method", "boxing", "unused" }) public void test_eq() {
    azzert.that(true, azzert.is(string.eq(4, 4)));
    azzert.that(false, azzert.is(string.eq(3, 4)));
    azzert.that(true, azzert.is(string.eq(null, null)));
    azzert.that(false, azzert.is(string.eq(4, null)));
    azzert.that(false, azzert.is(string.eq(null, 4)));
    azzert.that(true, azzert.is(string.eq(new Pair<Integer, Integer>(1, 2), new Pair<Integer, Integer>(1, 2))));
  }

  @Test @SuppressWarnings("static-method") public void test_esc() {
    azzert.that(string.esc('\n'), azzert.is("\\n"));
    azzert.that(string.esc('\r'), azzert.is("\\r"));
    azzert.that(string.esc('\t'), azzert.is("\\t"));
    azzert.that(string.esc('\f'), azzert.is("\\f"));
    azzert.that(string.esc('\b'), azzert.is("\\b"));
    azzert.that(string.esc('\\'), azzert.is("\\\\"));
    azzert.that(string.esc('\''), azzert.is("\'"));
    azzert.that(string.esc('\"'), azzert.is("\""));
    azzert.that(string.esc('g'), azzert.is("g"));
    azzert.that(string.esc(null), azzert.is("(null)"));
    azzert.that(string.esc("hello"), azzert.is("hello"));
    azzert.that(string.esc("he\bllo"), azzert.is("he\\bllo"));
    azzert.that(string.esc("hel\\lo"), azzert.is("hel\\\\lo"));
    azzert.that(string.esc("hel\"lo"), azzert.is("hel\"lo"));
  }

  @Test @SuppressWarnings("static-method") public void test_expandLeadingTabs() {
    azzert.that(string.expandLeadingTabs("hello"), azzert.is("hello"));
  }

  @Test @SuppressWarnings("static-method") public void test_fill() {
    azzert.that(string.fill(5, 'c'), azzert.is("ccccc"));
    azzert.that(string.fill(3, "sc"), azzert.is("scscsc"));
    azzert.that(string.fill(1, 'c'), azzert.is("c"));
  }

  @Test @SuppressWarnings("static-method") public void test_first() {
    azzert.that(string.first("cello"), azzert.is('c'));
    azzert.that(string.first("c"), azzert.is('c'));
    azzert.that(string.first("Cello"), azzert.is('C'));
    azzert.that(string.first("$ello"), azzert.is('$'));
    azzert.that(string.first("\tcello"), azzert.is('\t'));
    azzert.that(false, azzert.is(string.first("\tcello") == '\''));
  }

  @Test @SuppressWarnings("static-method") public void test_ftoa() {
    azzert.that(string.ftoa(Float.MAX_VALUE), azzert.is(Float.MAX_VALUE + ""));
  }

  @Test @SuppressWarnings("static-method") public void test_isDouble() {
    azzert.that(true, azzert.is(string.isDouble("4.3")));
    azzert.that(true, azzert.is(string.isDouble(Double.MAX_VALUE + "")));
    azzert.that(false, azzert.is(string.isDouble("4O")));
    azzert.that(false, azzert.is(string.isDouble("#")));
    azzert.that(false, azzert.is(string.isDouble("\t")));
  }

  @Test @SuppressWarnings("static-method") public void test_isFloat() {
    azzert.that(true, azzert.is(string.isFloat("4.3")));
    azzert.that(true, azzert.is(string.isFloat(Float.MAX_VALUE + "")));
    azzert.that(false, azzert.is(string.isFloat("4O")));
    azzert.that(false, azzert.is(string.isFloat("#")));
    azzert.that(false, azzert.is(string.isFloat("\t")));
  }

  @Test @SuppressWarnings("static-method") public void test_isInt() {
    azzert.that(false, azzert.is(string.isInt("4.3")));
    azzert.that(true, azzert.is(string.isInt(Integer.MAX_VALUE + "")));
    azzert.that(false, azzert.is(string.isInt(Long.MAX_VALUE + "")));
    azzert.that(false, azzert.is(string.isInt("4O")));
    azzert.that(false, azzert.is(string.isInt("#")));
    azzert.that(false, azzert.is(string.isInt("\t")));
  }

  @Test @SuppressWarnings("static-method") public void test_isLong() {
    azzert.that(false, azzert.is(string.isLong("4.3")));
    azzert.that(true, azzert.is(string.isLong(Integer.MAX_VALUE + "")));
    azzert.that(true, azzert.is(string.isLong(Long.MAX_VALUE + "")));
    azzert.that(false, azzert.is(string.isLong("4O")));
    azzert.that(false, azzert.is(string.isLong("#")));
    azzert.that(false, azzert.is(string.isLong("\t")));
  }

  @Test @SuppressWarnings("static-method") public void test_itoa() {
    azzert.that(string.itoa(Integer.MAX_VALUE), azzert.is(Integer.MAX_VALUE + ""));
  }

  @Test @SuppressWarnings("static-method") public void test_javaCase() {
    final String s2 = string.javaCase("Hello"), s3 = string.javaCase("hello"), s4 = string.javaCase("hELLo"), s5 = string.javaCase("h");
    azzert.that(string.javaCase(""), azzert.is(""));
    azzert.that(s2, azzert.is("hello"));
    azzert.that(s3, azzert.is("hello"));
    azzert.that(s4, azzert.is("hELLo"));
    azzert.that(s5, azzert.is("h"));
  }

  @Test @SuppressWarnings("static-method") public void test_last() {
    azzert.that(string.last("cello"), azzert.is('o'));
    azzert.that(string.last("c"), azzert.is('c'));
    azzert.that(string.last("CelloC"), azzert.is('C'));
    azzert.that(string.last("$ello$"), azzert.is('$'));
    azzert.that(string.last("\tcello\t"), azzert.is('\t'));
    azzert.that(false, azzert.is(string.last("\tcello\\") == '\''));
  }

  @Test @SuppressWarnings("static-method") public void test_lowCounter() {
    azzert.that(string.lowCounter(-1), azzert.is(""));
    azzert.that(string.lowCounter(0), azzert.is("a"));
    azzert.that(string.lowCounter(100), azzert.is("dw"));
    azzert.that(string.lowCounter(8), azzert.is("i"));
  }

  @Test @SuppressWarnings("static-method") public void test_ltoa() {
    azzert.that(string.ltoa(Long.MAX_VALUE), azzert.is(Long.MAX_VALUE + ""));
  }

  @Test @SuppressWarnings("static-method") public void test_ordinal() {
    azzert.that(string.ordinal(1), azzert.is("1st"));
    azzert.that(string.ordinal(21), azzert.is("21st"));
    azzert.that(string.ordinal(2), azzert.is("2nd"));
    azzert.that(string.ordinal(22), azzert.is("22nd"));
    azzert.that(string.ordinal(11), azzert.is("11th"));
    azzert.that(string.ordinal(12), azzert.is("12th"));
    azzert.that(string.ordinal(3333), azzert.is("3333th"));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void test_paren() {
    azzert.that(string.paren(4), azzert.is("(4)"));
    azzert.that(string.paren("$"), azzert.is("($)"));
    azzert.that(string.paren(new Pair<>(1, 2)), azzert.is("(<1,2>)"));
  }

  @Test @SuppressWarnings("static-method") public void test_pluralize() {
    azzert.that(string.pluralize(0, "hope"), azzert.is("no hopes"));
    azzert.that(string.pluralize(1, "hope"), azzert.is("hope"));
    azzert.that(string.pluralize(2, "hope"), azzert.is("two hopes"));
    azzert.that(string.pluralize(3, "hope"), azzert.is("three hopes"));
    azzert.that(string.pluralize(4, "hope"), azzert.is("four hopes"));
    azzert.that(string.pluralize(5, "hope"), azzert.is("five hopes"));
    azzert.that(string.pluralize(6, "hope"), azzert.is("six hopes"));
    azzert.that(string.pluralize(7, "hope"), azzert.is("seven hopes"));
    azzert.that(string.pluralize(8, "hope"), azzert.is("eight hopes"));
    azzert.that(string.pluralize(9, "hope"), azzert.is("nine hopes"));
    azzert.that(string.pluralize(20, "hope"), azzert.is("20 hopes"));
    azzert.that(string.pluralize(4, "party", "parties"), azzert.is("four parties"));
  }
  @Test @SuppressWarnings({ "boxing", "static-method" }) public void test_pretty() {
    azzert.that(string.pretty("hope", new ArrayList<Integer>()), azzert.is(""));
    azzert.that(string.pretty("course", "courses", new ArrayList<>(Arrays.asList(234311))), azzert.is("1 course: 234311\n"));
    final List<Integer> l = new ArrayList<>();
    for (int ¢ = 0; ¢ < 50; ¢++)
      l.add(¢);
    String s1 = "10 hopes:\n", s2 = "40 hopes:\n";
    for (int ¢ = 0; ¢ < 20; ¢++) {
      if (¢ < 10)
        s1 += "\t" + (¢ + 1) + ") " + ¢ + "\n";
      s2 += "\t" + (¢ + 1) + ") " + ¢ + "\n";
    }
    s2 += "\t...\n" + string.repeat(9, "null");
    for (int ¢ = 30; ¢ < 40; ¢++)
      s2 += "\t" + (¢ + 1) + ") " + ¢ + "\n";
    azzert.that(string.pretty("hope", "hopes", l.subList(0, 10)), azzert.is(s1));
    azzert.that(string.pretty("hope", "hopes", l.subList(0, 40)), azzert.is(s2));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void test_quote() {
    azzert.that(string.quote("let it be epsilon>0"), azzert.is("'let it be epsilon>0'"));
    azzert.that(string.quote("\tlet it be epsilon>0\t"), azzert.is("'\tlet it be epsilon>0\t'"));
    azzert.that(string.quote(42), azzert.is("'42'"));
  }

  @Test @SuppressWarnings("static-method") public void test_repeat() {
    azzert.that(string.repeat(5, 'c'), azzert.is("ccccc"));
    azzert.that(string.repeat(3, "sc"), azzert.is("scscsc"));
    azzert.that(string.repeat(1, 'c'), azzert.is("c"));
  }

  @Test @SuppressWarnings("static-method") public void test_signum() {
    azzert.that(string.signum(0), azzert.is(0));
    azzert.that(string.signum(1), azzert.is(1));
    azzert.that(string.signum(-1), azzert.is(-1));
    azzert.that(string.signum(Double.MAX_VALUE), azzert.is(1));
    azzert.that(string.signum(-Double.MAX_VALUE), azzert.is(-1));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void test_sprintf() {
    final String[] a = {}, b = { "hell" }, c = { "what %s %s", "the", "hell" };
    azzert.that(string.sprintf(a), azzert.is(""));
    azzert.that(string.sprintf(b), azzert.is("hell"));
    azzert.that(string.sprintf("hello %s %s %s", "world", "what", "the..."), azzert.is("hello world what the..."));
    azzert.that(string.sprintf(c), azzert.is("what the hell"));
  }

  @Test @SuppressWarnings({ "static-method", "unused" }) public void test_strip() {
    azzert.that(string.strip("he"), azzert.is(""));
    azzert.that(string.strip("hell"), azzert.is("el"));
    try {
      string.strip("");
    } catch (final RuntimeException e) {
      /**
       * 
       */
    }
  }

  @Test @SuppressWarnings({ "static-method", "unused" }) public void test_toLines() {
    try {
      final List<String> l1 = string.toLines("hello world\n\twhat\nis up\ndone\n\n");
      azzert.that(l1.get(0), azzert.is("hello world"));
      azzert.that(l1.get(1), azzert.is("\twhat"));
      azzert.that(l1.get(2), azzert.is("is up"));
      azzert.that(l1.get(3), azzert.is("done"));
      azzert.that(l1.get(4), azzert.is(""));
    } catch (final IOException e) {
      /**
       * 
       */
    }
  }

  @Test @SuppressWarnings("static-method") public void test_upCounter() {
    azzert.that(string.upCounter(-1), azzert.is(""));
    azzert.that(string.upCounter(0), azzert.is("A"));
    azzert.that(string.upCounter(100), azzert.is("DW"));
    azzert.that(string.upCounter(8), azzert.is("I"));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void test_visualize() {
    azzert.that(string.visualize("\n"), azzert.is("\\n"));
    azzert.that(string.visualize("\r"), azzert.is("\\r"));
    azzert.that(string.visualize("\t"), azzert.is("\\t"));
    azzert.that(string.visualize("\f"), azzert.is("\\f"));
    azzert.that(string.visualize("\b"), azzert.is("\\b"));
    azzert.that(string.visualize("\\"), azzert.is("\\\\"));
    azzert.that(string.visualize("\'"), azzert.is("\'"));
    azzert.that(string.visualize("\""), azzert.is("\""));
    azzert.that(string.visualize("g"), azzert.is("g"));
    azzert.that(string.visualize(null), azzert.is("(null)"));
    azzert.that(string.visualize("hello"), azzert.is("hello"));
    azzert.that(string.visualize("he\bllo"), azzert.is("he\\bllo"));
    azzert.that(string.visualize("hel\\lo"), azzert.is("hel\\\\lo"));
    azzert.that(string.visualize("hel\"lo"), azzert.is("hel\"lo"));
  }

  @Test @SuppressWarnings("static-method") public void test_wrap() {
    azzert.that(string.wrap('\'', "(gelli)"), azzert.is("'(gelli)'"));
    azzert.that(string.wrap('\t', "(gelli)"), azzert.is("\t(gelli)\t"));
    azzert.that(string.wrap('\n', "(gelli)"), azzert.is("\n(gelli)\n"));
    azzert.that(string.wrap("'", "(gelli)"), azzert.is("'(gelli)'"));
    azzert.that(string.wrap("s", "(gelli)"), azzert.is("s(gelli)s"));
    azzert.that(string.wrap("()", "(gelli)"), azzert.is("()(gelli)()"));
  }
}
