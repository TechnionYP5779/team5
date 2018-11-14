package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.English.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class EnglishTest {
  @Test public void testIndefinite() {
    final String s = "str";
    final Integer i = box.box(1);
    azzert.that(English.indefinite(s), is("a str"));
    azzert.that(English.indefinite(i), is("a Integer"));
    azzert.that(English.indefinite("STR"), is("a ar"));
    azzert.that(English.indefinite(box.box(1.1)), is("an Double"));
    azzert.that(English.indefinite("StrinG"), is("a StrinG"));
  }

  @Test public void testList() {
    final List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    final List<String> list2 = new ArrayList<>();
    list2.add("single");
    azzert.that(English.list(list), is("a, b, c, d and e"));
    azzert.that(English.list(new ArrayList<>()), is("nothing"));
    azzert.that(English.list(list2), is("single"));
    azzert.that(English.list(null), is("nothing"));
  }

  @Test public void testLowerFirstLetter() {
    azzert.that(English.lowerFirstLetter("ABcd"), is("aBcd"));
    azzert.that(English.lowerFirstLetter("").substring(0, 11), is("genererated"));
  }

  @Test public void testName() {
    class A {
      // empty block
    }
    azzert.that(English.name(new A()), is("A.EnglishTest"));
  }

  @Test public void testPlurales() {
    azzert.that(English.plurales("apple", 1), is("one apple"));
    azzert.that(English.plurales("apple", box.box(1)), is("one apple"));
    azzert.that(English.plurales("apple", box.box(1)), is("one apple"));
    azzert.that(English.plurales("apples", 2), is("2 appleses"));
    azzert.that(English.plurales("apples", box.box(2)), is("2 appleses"));
    azzert.that(English.plurales("apples", box.box(2)), is("2 appleses"));
    azzert.that(English.plurales("apple", (Integer) null), is("??? applees"));
    azzert.that(English.plurales("apple", (Integer) null), is("??? applees"));
  }

  @Test public void testPlurals() {
    azzert.that(English.plurals("apple", 1), is("one apple"));
    azzert.that(English.plurals("apple", box.box(1)), is("one apple"));
    azzert.that(English.plurals("apple", box.box(1)), is("one apple"));
    azzert.that(English.plurals("apples", 2), is("2 appless"));
    azzert.that(English.plurals("apples", box.box(2)), is("2 appless"));
    azzert.that(English.plurals("apples", box.box(2)), is("2 appless"));
    azzert.that(English.plurals("apple", (Integer) null), is("??? apples"));
    azzert.that(English.plurals("apple", (Int) null), is("??? apples"));
  }

  @Test public void testPronounce() {
    final String[] expected = { "aey", "bee", "see", "dee", "eae", "eff", "gee", "eitch", "eye", "jay", "kay", "ell", "em", "en", "oh", "pee",
        "queue", "ar", "ess", "tee", "you", "vee", "some character", "exx", "why", "zee" };
    for (int ¢ = 0; ¢ < 26; ¢++)
      azzert.that(English.pronounce((char) (¢ + 'a')), is(expected[¢]));
  }

  @Test public void testRepeat() {
    azzert.that(English.repeat(2, 'a'), is("aa"));
  }

  @Test public void testTime() {
    azzert.that(English.time(10), is("0.00"));
  }

  @Test public void testTrim() {
    isNull(English.trim(null));
    azzert.that(English.trim("abcd"), is("abcd"));
    azzert.that(English.trim("a"), is("a"));
    azzert.that(English.trim(""), is(""));
  }

  @Test public void testUnknownIfNull() {
    azzert.that(English.unknownIfNull(box.box(10)), is("10"));
    azzert.that(English.unknownIfNull(null), is("???"));
    azzert.that(English.unknownIfNull(box.box(10), λ -> box.box(unbox.unbox(λ) + 1)), is("11"));
    azzert.that(English.unknownIfNull(null, null), is("???"));
  }

  @Test public void testUpperFirstLetter() {
    azzert.that(English.upperFirstLetter("aBcd"), is("ABcd"));
    azzert.that(English.upperFirstLetter("").substring(0, 11), is("genererated"));
  }

  @Test public void testInterfaceInflection() {
    final Inflection s = Inflection.stem("s");
    azzert.that(s.get(), is("s"));
    azzert.that(s.getEd(), is("sed"));
    azzert.that(s.getIng(), is("sing"));
  }
}
