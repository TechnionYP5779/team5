package fluent.ly;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

import il.org.spartan.utils.*;

public class stringTest {
  @Test public void test_test() {
    final int s = string.MAX_FIRST;
    assertEquals(20, s);
  }

  double epsilon = 10e-5;

  @Test public void test_atod() {
    final double $ = string.atod("42.001"), $2 = string.atod(String.valueOf(Double.MAX_VALUE));
    assert 42.00 < $;
    assert Double.MAX_VALUE == $2;
    assertNotSame(42, $);
  }

  @Test public void test_atof() {
    final double $ = string.atof("42.001"), $2 = string.atof(String.valueOf(Float.MAX_VALUE));
    assert 42.00 < $;
    assert Float.MAX_VALUE == $2;
    assertNotSame(Integer.MAX_VALUE, $2);
  }

  @Test public void test_atoi() {
    final double $ = string.atoi("42"), $2 = string.atoi(String.valueOf(Integer.MAX_VALUE));
    assert 42 == $;
    assert Integer.MAX_VALUE == $2;
    assertNotSame(Float.MAX_VALUE, $2);
  }

  @Test public void test_atol() {
    final double $ = string.atol("42"), $2 = string.atol(String.valueOf(Long.MAX_VALUE));
    assert 42 == $;
    assert Long.MAX_VALUE == $2;
    assertNotSame(Integer.MAX_VALUE, $);
  }

  @Test public void test_capitalize() {
    final String s1 = string.capitalize(""), s2 = string.capitalize("Hello"), s3 = string.capitalize("hello"), s4 = string.capitalize("hELLo"),
        s5 = string.capitalize("h");
    assertEquals("", s1);
    assertEquals("Hello", s2);
    assertEquals("Hello", s3);
    assertEquals("Hello", s4);
    assertEquals("H", s5);
  }

  @Test public void test_cat() {
    final String[] l1 = { "Hello", " ", "World" };
    final String[] l2 = { " ", " what", " ", "happen" };
    final String s1 = string.cat("Hello", " ", "World"), s2 = string.cat(l1, l2);
    assertEquals("Hello World", s1);
    assertEquals("Hello World  what happen", s2);
  }

  @Test @SuppressWarnings("deprecated") public void test_delta() {
    final double d1 = 3.4, d2 = 3.5, d3 = 3.4;
    assert Math.abs(0.2 / 6.9 - string.delta(d1, d2)) < epsilon;
    assert Math.abs(0.2 / 6.9 - string.delta(d2, d1)) < epsilon;
    assert 0 == string.delta(d1, d3);
    assertEquals(string.delta(-1, 1) + "", "NaN");
  }

  @Test public void test_dtoa() {
    assertEquals("4.3", string.dtoa(4.3));
    assertEquals(Double.MAX_VALUE + "", string.dtoa(Double.MAX_VALUE));
  }

  @Test public void test_eq() {
    assert string.eq(4, 4);
    assert !string.eq(3, 4);
    assert string.eq(null, null);
    assert !string.eq(4, null);
    assert !string.eq(null, 4);
    assert string.eq(new Pair<>(1, 2), new Pair<>(1, 2));
  }

  @Test public void test_esc() {
    assertEquals("\\n", string.esc('\n'));
    assertEquals("\\r", string.esc('\r'));
    assertEquals("\\t", string.esc('\t'));
    assertEquals("\\f", string.esc('\f'));
    assertEquals("\\b", string.esc('\b'));
    assertEquals("\\\\", string.esc('\\'));
    assertEquals("\'", string.esc('\'')); // also an escaper, but not in the cases
    assertEquals("\"", string.esc('\"')); // also an escaper, but not in the cases
    assertEquals("g", string.esc('g'));
    /*************************************/
    assertEquals("(null)", string.esc(null));
    assertEquals("hello", string.esc("hello"));
    assertEquals("he\\bllo", string.esc("he\bllo"));
    assertEquals("hel\\\\lo", string.esc("hel\\lo"));
    assertEquals("hel\"lo", string.esc("hel\"lo"));
  }

  @Test public void test_expandLeadingTabs() {
    assertEquals("hello", string.expandLeadingTabs("hello"));
    // System.out.println(string.expandLeadingTabs("\the\tl\t\tlo"));
    // assertEquals(" he l lo",string.expandLeadingTabs("\the\tl\t\tlo"));
    // assertEquals("he l lo ",string.expandLeadingTabs("he\tl\t\tlo\t"));
  }

  @Test public void test_fill() {
    assertEquals("ccccc", string.fill(5, 'c'));
    assertEquals("scscsc", string.fill(3, "sc"));
    assertEquals("c", string.fill(1, 'c'));
  }

  @Test public void test_first() {
    assertEquals('c', string.first("cello"));
    assertEquals('c', string.first("c"));
    assertEquals('C', string.first("Cello"));
    assertEquals('$', string.first("$ello"));
    assertEquals('\t', string.first("\tcello"));
    assertNotSame('\'', string.first("\tcello"));
  }

  @Test public void test_ftoa() {
    assertEquals(Float.MAX_VALUE + "", string.ftoa(Float.MAX_VALUE));
  }

  @Test public void test_isDouble() {
    assert string.isDouble("4.3");
    assert string.isDouble("" + Double.MAX_VALUE);
    assert !string.isDouble("4O");
    assert !string.isDouble("#");
    assert !string.isDouble("\t");
  }

  @Test public void test_isFloat() {
    assert string.isFloat("4.3");
    assert string.isFloat("" + Float.MAX_VALUE);
    assert !string.isFloat("4O");
    assert !string.isFloat("#");
    assert !string.isFloat("\t");
  }

  @Test public void test_isInt() {
    assert !string.isInt("4.3");
    assert string.isInt("" + Integer.MAX_VALUE);
    assert !string.isInt("" + Long.MAX_VALUE);
    assert !string.isInt("4O");
    assert !string.isInt("#");
    assert !string.isInt("\t");
  }

  @Test public void test_isLong() {
    assert !string.isLong("4.3");
    assert string.isLong("" + Integer.MAX_VALUE);
    assert string.isLong("" + Long.MAX_VALUE);
    assert !string.isLong("4O");
    assert !string.isLong("#");
    assert !string.isLong("\t");
  }

  @Test public void test_itoa() {
    assertEquals(Integer.MAX_VALUE + "", string.itoa(Integer.MAX_VALUE));
  }

  @Test public void test_javaCase() {
    final String s1 = string.javaCase(""), s2 = string.javaCase("Hello"), s3 = string.javaCase("hello"), s4 = string.javaCase("hELLo"),
        s5 = string.javaCase("h");
    assertEquals("", s1);
    assertEquals("hello", s2);
    assertEquals("hello", s3);
    assertEquals("hELLo", s4);
    assertEquals("h", s5);
  }

  @Test public void test_last() {
    assertEquals('o', string.last("cello"));
    assertEquals('c', string.last("c"));
    assertEquals('C', string.last("CelloC"));
    assertEquals('$', string.last("$ello$"));
    assertEquals('\t', string.last("\tcello\t"));
    assertNotSame('\'', string.last("\tcello\\"));
  }

  @Test public void test_lowCounter() {
    assertEquals("", string.lowCounter(-1));
    assertEquals("a", string.lowCounter(0));
    assertEquals("dw", string.lowCounter(100));
    assertEquals("i", string.lowCounter(8));
  }

  @Test public void test_ltoa() {
    assertEquals(Long.MAX_VALUE + "", string.ltoa(Long.MAX_VALUE));
  }

  @Test public void test_ordinal() {
    assertEquals("1st", string.ordinal(1));
    assertEquals("21st", string.ordinal(21));
    assertEquals("2nd", string.ordinal(2));
    assertEquals("22nd", string.ordinal(22));
    assertEquals("11th", string.ordinal(11));
    assertEquals("12th", string.ordinal(12));
    assertEquals("3333th", string.ordinal(3333));
  }

  @Test public void test_paren() {
    assertEquals("(4)", string.paren(4));
    assertEquals("($)", string.paren("$"));
    assertEquals("(<1,2>)", string.paren(new Pair<>(1, 2)));
  }

  @Test public void test_pluralize() {
    assertEquals("no hopes", string.pluralize(0, "hope"));
    assertEquals("hope", string.pluralize(1, "hope"));
    assertEquals("two hopes", string.pluralize(2, "hope"));
    assertEquals("three hopes", string.pluralize(3, "hope"));
    assertEquals("four hopes", string.pluralize(4, "hope"));
    assertEquals("five hopes", string.pluralize(5, "hope"));
    assertEquals("six hopes", string.pluralize(6, "hope"));
    assertEquals("seven hopes", string.pluralize(7, "hope"));
    assertEquals("eight hopes", string.pluralize(8, "hope"));
    assertEquals("nine hopes", string.pluralize(9, "hope"));
    assertEquals("20 hopes", string.pluralize(20, "hope"));
    assertEquals("four parties", string.pluralize(4, "party", "parties"));
  }

  @Test public void test_pretty() {
    assertEquals("", string.pretty("hope", null));
    assertEquals("", string.pretty("hope", new ArrayList<Integer>()));
    assertEquals("1 course: 234311\n", string.pretty("course", "courses", new ArrayList<>(Arrays.asList(234311))));
    final List<Integer> l = new ArrayList<>();
    for (int i = 0; i < 50; i++)
      l.add(i);
    String s1 = "10 hopes:\n", s2 = "40 hopes:\n";
    for (int i = 0; i < 20; i++) {
      if (i < 10)
        s1 += "\t" + (i + 1) + ") " + i + "\n";
      s2 += "\t" + (i + 1) + ") " + i + "\n";
    }
    s2 += "\t...\n" + string.repeat(9, "null");
    for (int i = 30; i < 40; i++)
      s2 += "\t" + (i + 1) + ") " + i + "\n";
    assertEquals(s1, string.pretty("hope", "hopes", l.subList(0, 10)));
    assertEquals(s2, string.pretty("hope", "hopes", l.subList(0, 40)));
  }

  @Test public void test_quote() {
    assertEquals("'let it be epsilon>0'", string.quote("let it be epsilon>0"));
    assertEquals("'\tlet it be epsilon>0\t'", string.quote("\tlet it be epsilon>0\t"));
    assertEquals("'42'", string.quote(42));
  }

  @Test public void test_repeat() {
    assertEquals("ccccc", string.repeat(5, 'c'));
    assertEquals("scscsc", string.repeat(3, "sc"));
    assertEquals("c", string.repeat(1, 'c'));
  }

  @Test public void test_signum() {
    assertEquals(0, string.signum(0));
    assertEquals(1, string.signum(1));
    assertEquals(-1, string.signum(-1));
    assertEquals(1, string.signum(Double.MAX_VALUE));
    assertEquals(-1, string.signum(-Double.MAX_VALUE));
  }

  @Test public void test_sprintf() {
    final String[] a = {}, b = { "hell" }, c = { "what %s %s", "the", "hell" };
    assertEquals("", string.sprintf(a));
    assertEquals("hell", string.sprintf(b));
    assertEquals("hello world what the...", string.sprintf("hello %s %s %s", "world", "what", "the..."));
    assertEquals("what the hell", string.sprintf(c));
  }

  @Test public void test_strip() {
    assertEquals("", string.strip("he"));
    assertEquals("el", string.strip("hell"));
    try {
      string.strip("");
    } catch (final RuntimeException e) {
    }
  }

  @Test public void test_toLines() {
    try {
      final List<String> l1 = string.toLines("hello world\n\twhat\nis up\ndone\n\n");
      assertEquals("hello world", l1.get(0));
      assertEquals("\twhat", l1.get(1));
      assertEquals("is up", l1.get(2));
      assertEquals("done", l1.get(3));
      assertEquals("", l1.get(4)); // or null
    } catch (final IOException e) {
    }
  }

  @Test public void test_upCounter() {
    assertEquals("", string.upCounter(-1));
    assertEquals("A", string.upCounter(0));
    assertEquals("DW", string.upCounter(100));
    assertEquals("I", string.upCounter(8));
  }

  @Test public void test_visualize() {
    assertEquals("\\n", string.visualize("\n"));
    assertEquals("\\r", string.visualize("\r"));
    assertEquals("\\t", string.visualize("\t"));
    assertEquals("\\f", string.visualize("\f"));
    assertEquals("\\b", string.visualize("\b"));
    assertEquals("\\\\", string.visualize("\\"));
    assertEquals("\'", string.visualize("\'")); // also an escaper, but not in the cases
    assertEquals("\"", string.visualize("\"")); // also an escaper, but not in the cases
    assertEquals("g", string.visualize("g"));
    /*************************************/
    assertEquals("(null)", string.visualize(null));
    assertEquals("hello", string.visualize("hello"));
    assertEquals("he\\bllo", string.visualize("he\bllo"));
    assertEquals("hel\\\\lo", string.visualize("hel\\lo"));
    assertEquals("hel\"lo", string.visualize("hel\"lo"));
  }

  @Test public void test_wrap() {
    assertEquals("'(gelli)'", string.wrap('\'', "(gelli)"));
    assertEquals("\t(gelli)\t", string.wrap('\t', "(gelli)"));
    assertEquals("\n(gelli)\n", string.wrap('\n', "(gelli)"));
    assertEquals("'(gelli)'", string.wrap("'", "(gelli)"));
    assertEquals("'(gelli)'", string.wrap("'", "(gelli)"));
    assertEquals("()(gelli)()", string.wrap("()", "(gelli)"));
  }
}
