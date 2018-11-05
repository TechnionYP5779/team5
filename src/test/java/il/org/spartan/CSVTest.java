package il.org.spartan;

import static org.junit.Assert.*;

import java.io.*;
import org.junit.*;
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
    assertEquals("java.lang.Integer,java.lang.Character,"
        + "java.lang.Double,java.lang.String,java.lang.Float,"
        + "java.lang.Byte,"+null,CSV.combine(cs) );
    
    Integer[] intArr=new Integer[5];
    for(int i=0;i<5;i++) intArr[i]=Integer.valueOf(i);
    assertEquals("0,1,2,3,4",CSV.combine(intArr));
    
    Color[] colorArr=new Color[4];
    colorArr[0]=Color.RED;
    colorArr[1]=Color.GREEN;
    colorArr[2]=Color.BLUE;
    colorArr[3]=null;
    
    assertEquals("RED,GREEN,BLUE,"+null,CSV.combine(colorArr));
  }
  
  @SuppressWarnings("null") @Test public void escapeTest() {
    
    assertEquals("\\n\\r\\t\\\\\\.",CSV.escape("\n\r\t\\,"));
    assertEquals("\\0",CSV.escape(null));
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
@SuppressWarnings("null") @Test public void splitTest() {
  
  assertEquals(0, CSV.split("").length);
  
  Color[] colorArr=new Color[3];
  colorArr[0]=Color.RED;
  colorArr[1]=Color.GREEN;
  colorArr[2]=Color.BLUE;
  assertArrayEquals(colorArr, CSV.split(Color.class,"RED,GREEN,BLUE"));
  
  Class<?>[] cs=new Class<?>[6];
  cs[0]=Integer.class;
  cs[1]=Character.class;
  cs[2]=Double.class;
  cs[3]=String.class;
  cs[4]=Float.class;
  cs[5]=Byte.class;
  assertArrayEquals(cs, CSV.splitToClasses("java.lang.Integer,java.lang.Character,"
      + "java.lang.Double,java.lang.String,java.lang.Float,"
      + "java.lang.Byte"));
  
  
}

@SuppressWarnings("null") @Test public void unescapeTest() {
  
  assertEquals(null,CSV.unescape("\\0"));
  assertEquals("\n",CSV.unescape("\\n"));
  assertEquals("\r",CSV.unescape("\\r"));
  assertEquals("\t",CSV.unescape("\\t"));
  assertEquals(",",CSV.unescape("\\."));
  assertEquals("\\",CSV.unescape("\\\\"));
  assertEquals("a",CSV.unescape("a"));
}
}
