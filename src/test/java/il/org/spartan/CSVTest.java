package il.org.spartan;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.CSV;
import il.org.spartan.utils.*;
enum Color 
{ 
    RED, GREEN, BLUE; 
} 
public class CSVTest {
  
  @SuppressWarnings("null") @Test public void combineTest() {
    Class<?>[] cs=new Class<?>[7];
    cs[0]=Integer.class;
    cs[1]=Character.class;
    cs[2]=Double.class;
    cs[3]=String.class;
    cs[4]=Float.class;
    cs[5]=Byte.class;
    cs[6]=null;
    azzert.that(CSV.combine(cs),azzert.is("java.lang.Integer,java.lang.Character,"
        + "java.lang.Double,java.lang.String,java.lang.Float,"
        + "java.lang.Byte,"+null ));
    
    Integer[] intArr=new Integer[5];
    for(int i=0;i<5;i++) intArr[i]=Integer.valueOf(i);
    azzert.that(CSV.combine(intArr),azzert.is("0,1,2,3,4"));
    
    Color[] colorArr=new Color[4];
    colorArr[0]=Color.RED;
    colorArr[1]=Color.GREEN;
    colorArr[2]=Color.BLUE;
    colorArr[3]=null;
    
    azzert.that(CSV.combine(colorArr),azzert.is("RED,GREEN,BLUE,"+null));
  }
  
  @SuppressWarnings("null") @Test public void escapeTest() {
    
    azzert.that(CSV.escape("\n\r\t\\,"),azzert.is("\\n\\r\\t\\\\\\."));
    azzert.that(CSV.escape(null),azzert.is("\\0"));
  }
  
@SuppressWarnings("null") @Test public void loadAndSaveTest() {
    
    assertEquals("\\n\\r\\t\\\\\\.",CSV.escape("\n\r\t\\,"));
    File f = new File("src/test/resources/csvTest");
    
    int counter=0;
    try {
      String[][] csv=CSV.load(f);
      for(String[] line : csv) {
        System.out.println("start of line: "+counter);
        for(String word : line) {
          System.out.print(word+" ");
        }
        System.out.println();
        counter++;
      }
      CSV.save(f, csv); //save without changes
      
    } catch (IOException e) {
      fail("loadAndSaveTest");
    }
    
    
  }
@SuppressWarnings({ "null", "static-access" }) @Test public void splitTest() {
  
  azzert.that(CSV.split("").length,azzert.is(0));
  
  Color[] colorArr=new Color[3];
  colorArr[0]=Color.RED;
  colorArr[1]=Color.GREEN;
  colorArr[2]=Color.BLUE;
  azzert.assertArrayEquals(colorArr, CSV.split(Color.class,"RED,GREEN,BLUE"));
  
  Class<?>[] cs=new Class<?>[6];
  cs[0]=Integer.class;
  cs[1]=Character.class;
  cs[2]=Double.class;
  cs[3]=String.class;
  cs[4]=Float.class;
  cs[5]=Byte.class;
  azzert.assertArrayEquals(cs, CSV.splitToClasses("java.lang.Integer,java.lang.Character,"
      + "java.lang.Double,java.lang.String,java.lang.Float,"
      + "java.lang.Byte"));
  
  
}

@SuppressWarnings("null") @Test public void unescapeTest() {
  
  azzert.that(null,azzert.is(CSV.unescape("\\0")));
  azzert.that("\n",azzert.is(CSV.unescape("\\n")));
  azzert.that("\r",azzert.is(CSV.unescape("\\r")));
  azzert.that("\t",azzert.is(CSV.unescape("\\t")));
  azzert.that(",",azzert.is(CSV.unescape("\\.")));
  azzert.that("\\",azzert.is(CSV.unescape("\\\\")));
  azzert.that("a",azzert.is(CSV.unescape("a")));
}
}
