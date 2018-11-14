package il.org.spartan;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import fluent.ly.*;

enum Color {
  RED, GREEN, BLUE;
}

public class CSVTest {
  @Test @SuppressWarnings({ "null", "static-method" }) public void combineTest() {
    final Class<?>[] cs = new Class<?>[7];
    cs[0] = Integer.class;
    cs[1] = Character.class;
    cs[2] = Double.class;
    cs[3] = String.class;
    cs[4] = Float.class;
    cs[5] = Byte.class;
    cs[6] = null;
    azzert.that(CSV.combine(cs),
        azzert.is("java.lang.Integer,java.lang.Character,java.lang.Double,java.lang.String,java.lang.Float,java.lang.Byte," + null));
    final Integer[] intArr = new Integer[5];
    for (int ¢ = 0; ¢ < 5; ¢++)
      intArr[¢] = Integer.valueOf(¢);
    azzert.that(CSV.combine(intArr), azzert.is("0,1,2,3,4"));
    final Color[] colorArr = new Color[4];
    colorArr[0] = Color.RED;
    colorArr[1] = Color.GREEN;
    colorArr[2] = Color.BLUE;
    colorArr[3] = null;
    azzert.that(CSV.combine(colorArr), azzert.is("RED,GREEN,BLUE," + null));
  }

  @Test @SuppressWarnings("static-method") public void escapeTest() {
    azzert.that(CSV.escape("\n\r\t\\,"), azzert.is("\\n\\r\\t\\\\\\."));
    azzert.that(CSV.escape(null), azzert.is("\\0"));
  }

  @Test @SuppressWarnings({ "null", "static-method" }) public void loadAndSaveTest() {
    Assert.assertEquals("\\n\\r\\t\\\\\\.", CSV.escape("\n\r\t\\,"));
    final File f = new File("src/test/resources/csvTest");
    try {
      final String[][] csv = CSV.load(f);
      azzert.that(csv[0][0], azzert.is("Sally Whittaker"));
      azzert.that(csv[0][1], azzert.is("2018"));
      azzert.that(csv[0][2], azzert.is("McCarren House"));
      azzert.that(csv[0][3], azzert.is("312"));
      azzert.that(csv[0][4], azzert.is("3.75"));
      CSV.save(f, csv);
    } catch (@SuppressWarnings("unused") final IOException e) {
      fail("loadAndSaveTest");
    }
  }

  @Test @SuppressWarnings("static-method") public void splitTest() {
    azzert.that(CSV.split("").length, azzert.is(0));
    final Color[] colorArr = new Color[3];
    colorArr[0] = Color.RED;
    colorArr[1] = Color.GREEN;
    colorArr[2] = Color.BLUE;
    Assert.assertArrayEquals(colorArr, CSV.split(Color.class, "RED,GREEN,BLUE"));
    final Class<?>[] cs = new Class<?>[6];
    cs[0] = Integer.class;
    cs[1] = Character.class;
    cs[2] = Double.class;
    cs[3] = String.class;
    cs[4] = Float.class;
    cs[5] = Byte.class;
    Assert.assertArrayEquals(cs,
        CSV.splitToClasses("java.lang.Integer,java.lang.Character,java.lang.Double,java.lang.String,java.lang.Float,java.lang.Byte"));
  }

  @Test @SuppressWarnings("static-method") public void unescapeTest() {
    azzert.that(null, azzert.is(CSV.unescape("\\0")));
    azzert.that("\n", azzert.is(CSV.unescape("\\n")));
    azzert.that("\r", azzert.is(CSV.unescape("\\r")));
    azzert.that("\t", azzert.is(CSV.unescape("\\t")));
    azzert.that(",", azzert.is(CSV.unescape("\\.")));
    azzert.that("\\", azzert.is(CSV.unescape("\\\\")));
    azzert.that("a", azzert.is(CSV.unescape("a")));
  }
}
