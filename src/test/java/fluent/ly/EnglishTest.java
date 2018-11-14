package fluent.ly;

import java.util.*;

import org.junit.*;

import fluent.ly.English.*;
import il.org.spartan.utils.*;

public class EnglishTest {
  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testIndefinite() {
    final String s = "str";
    final Integer i = 1;
    azzert.that(English.indefinite(s), azzert.is("a str"));
    azzert.that(English.indefinite(i), azzert.is("a Integer"));
    azzert.that(English.indefinite("STR"), azzert.is("a ar"));
    azzert.that(English.indefinite(1.1), azzert.is("an Double"));
    azzert.that(English.indefinite("StrinG"), azzert.is("a StrinG"));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void testList() {
    final List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    final List<String> list2 = new ArrayList<>();
    list2.add("single");
    azzert.that(English.list(list), azzert.is("a, b, c, d and e"));
    azzert.that(English.list(new ArrayList<>()), azzert.is("nothing"));
    azzert.that(English.list(list2), azzert.is("single"));
    azzert.that(English.list(null), azzert.is("nothing"));
  }

  @Test @SuppressWarnings("static-method") public void testLowerFirstLetter() {
    azzert.that(English.lowerFirstLetter("ABcd"), azzert.is("aBcd"));
    azzert.that(English.lowerFirstLetter("").substring(0, 11), azzert.is("genererated"));
  }

  @Test @SuppressWarnings("static-method") public void testName() {
    class A {
      // empty block
    }
    azzert.that(English.name(new A()), azzert.is("A.EnglishTest"));
  }

  @Test @SuppressWarnings("static-method") public void testPlurales() {
    azzert.that(English.plurales("apple", 1), azzert.is("one apple"));
    azzert.that(English.plurales("apple", Integer.valueOf(1)), azzert.is("one apple"));
    azzert.that(English.plurales("apple", Int.valueOf(1)), azzert.is("one apple"));
    azzert.that(English.plurales("apples", 2), azzert.is("2 appleses"));
    azzert.that(English.plurales("apples", Integer.valueOf(2)), azzert.is("2 appleses"));
    azzert.that(English.plurales("apples", Int.valueOf(2)), azzert.is("2 appleses"));
    azzert.that(English.plurales("apple", (Integer) null), azzert.is("??? applees"));
    azzert.that(English.plurales("apple", (Integer) null), azzert.is("??? applees"));
  }

  @Test @SuppressWarnings("static-method") public void testPlurals() {
    azzert.that(English.plurals("apple", 1), azzert.is("one apple"));
    azzert.that(English.plurals("apple", Integer.valueOf(1)), azzert.is("one apple"));
    azzert.that(English.plurals("apple", Int.valueOf(1)), azzert.is("one apple"));
    azzert.that(English.plurals("apples", 2), azzert.is("2 appless"));
    azzert.that(English.plurals("apples", Integer.valueOf(2)), azzert.is("2 appless"));
    azzert.that(English.plurals("apples", Int.valueOf(2)), azzert.is("2 appless"));
    azzert.that(English.plurals("apple", (Integer) null), azzert.is("??? apples"));
    azzert.that(English.plurals("apple", (Int) null), azzert.is("??? apples"));
  }

  @Test @SuppressWarnings("static-method") public void testPronounce() {
    final String[] expected = { "aey", "bee", "see", "dee", "eae", "eff", "gee", "eitch", "eye", "jay", "kay", "ell", "em", "en", "oh", "pee",
        "queue", "ar", "ess", "tee", "you", "vee", "some character", "exx", "why", "zee" };
    for (int ¢ = 0; ¢ < 26; ¢++)
      azzert.that(English.pronounce((char) (¢ + 'a')), azzert.is(expected[¢]));
  }

  @Test @SuppressWarnings("static-method") public void testRepeat() {
    azzert.that(English.repeat(2, 'a'), azzert.is("aa"));
  }

  @Test @SuppressWarnings("static-method") public void testTime() {
    azzert.that(English.time(10), azzert.is("0.00"));
  }

  @Test @SuppressWarnings("static-method") public void testTrim() {
    azzert.isNull(English.trim(null));
    azzert.that(English.trim("abcd"), azzert.is("abcd"));
    azzert.that(English.trim("a"), azzert.is("a"));
    azzert.that(English.trim(""), azzert.is(""));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testUnknownIfNull() {
    azzert.that(English.unknownIfNull(10), azzert.is("10"));
    azzert.that(English.unknownIfNull(null), azzert.is("???"));
    azzert.that(English.unknownIfNull(10, λ -> λ + 1), azzert.is("11"));
    azzert.that(English.unknownIfNull(null, null), azzert.is("???"));
  }

  @Test @SuppressWarnings("static-method") public void testUpperFirstLetter() {
    azzert.that(English.upperFirstLetter("aBcd"), azzert.is("ABcd"));
    azzert.that(English.upperFirstLetter("").substring(0, 11), azzert.is("genererated"));
  }

  @Test @SuppressWarnings("static-method") public void testInterfaceInflection() {
    final Inflection s = Inflection.stem("s");
    azzert.that(s.get(), azzert.is("s"));
    azzert.that(s.getEd(), azzert.is("sed"));
    azzert.that(s.getIng(), azzert.is("sing"));
  }
}
