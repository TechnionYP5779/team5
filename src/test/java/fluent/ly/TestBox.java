package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;
import fluent.ly.box;

public class TestBox {
  @Test public void testBooleanBox() {
    //variable boolean box testing
    Boolean b= box.box(true);
    assertEquals(Boolean.valueOf(true), b);
    
    b= box.box(false);
    assertEquals(Boolean.valueOf(false), b);
    
    //array testing
    boolean bArray[]= new boolean[10];
    for(int i=0;i<10;++i) {
      bArray[i]=(i%2==0);
    }
    
    Boolean BooleanArray[]= box.box(bArray);
    for(int i=0;i<10;++i) {
      assertEquals(Boolean.valueOf((i%2==0)), BooleanArray[i]);
    }
  }
  
  @Test public void testByteBox() {
    //variable boolean box testing
    Byte b= box.box((byte)6);
    assertEquals(Byte.valueOf((byte) 6), b);
    
    b= box.box((byte)0);
    assertEquals(Byte.valueOf((byte) 0), b);
    
    b= box.box((byte)-5);
    assertEquals(Byte.valueOf((byte) -5), b);
    
    //array testing
    byte bArray[]= new byte[10];
    for(int i=0;i<10;++i) {
      bArray[i]=((byte)(i));
    }
    
    Byte ByteArray[]= box.box(bArray);
    for(int i=0;i<10;++i) {
      assertEquals(Byte.valueOf((byte)i), ByteArray[i]);
    }
  }
  
  @Test public void testCharBox() {
    //variable boolean box testing
    Character b= box.box('a');
    assertEquals(Character.valueOf('a'), b);
    
    b= box.box('b');
    assertEquals(Character.valueOf('b'), b);
    
  //array testing
    char cArray[]= new char[10];
    for(int i=0;i<10;++i) {
      cArray[i]=(char) ('a'+i);
    }
    
    Character CharArray[]= box.box(cArray);
    for(int i=0;i<10;++i) {
      assertEquals(Character.valueOf((char) ('a'+i)), CharArray[i]);
    }
   
  }
  
  @Test public void testDoubleBox() {
    //variable double box testing
    Double b= box.box(3.14);
    assertEquals(Double.valueOf(3.14), b);
    
    b= box.box(2.71);
    assertEquals(Double.valueOf(2.71), b);
    
  //array testing
    double dArray[]= new double[10];
    for(int i=0;i<10;++i) {
      dArray[i]= (3.14+i);
    }

    Double DoubleArray[]= box.box(dArray);
    for(int i=0;i<10;++i) {
      assertEquals(Double.valueOf(3.14+i), DoubleArray[i]);
    }
   
  }
  
  @Test public void testFloatBox() {
    float diff=(float) 0.00005;
    //variable double box testing
    Float b= box.box((float)3.14);
    assertTrue(b<=Float.valueOf((float)3.14+diff)&&b>=Float.valueOf((float)3.14-diff));
    
    b= box.box((float)2.71);
    assertTrue(b<=Float.valueOf((float)2.71+diff)&&b>=Float.valueOf((float)2.71-diff));
    
  //array testing
    float fArray[]= new float[10];
    for(int i=0;i<10;++i) {
      fArray[i]= (float)(3.14+i);
    }

    Float FloatArray[]= box.box(fArray);
    for(int i=0;i<10;++i) {
      assertTrue(FloatArray[i]<=Float.valueOf((float) ((float)3.14+i+diff))&&
          FloatArray[i]>=Float.valueOf((float) ((float)3.14+i-diff)));
    }
   
  }
  
  @Test public void testIntegerBox() {
    //variable int box testing
    Integer b= box.box(3);
    assertEquals(Integer.valueOf(3), b);
    
    b= box.box(-2);
    assertEquals(Integer.valueOf(-2), b);
    
  //array testing
    int iArray[]= new int[10];
    for(int i=0;i<10;++i) {
      iArray[i]= (i);
    }

    Integer IntegerArray[]= box.box(iArray);
    for(int i=0;i<10;++i) {
      assertEquals(Integer.valueOf(i), IntegerArray[i]);
    }
   
  }
  
  @Test public void testLongBox() {
    //variable long box testing
    long offset=(long) 1e7;
    Long b= box.box(3*offset);
    assertEquals(Long.valueOf(3*offset), b);
    
    b= box.box(-3*offset);
    assertEquals(Long.valueOf(-3*offset), b);
    
  //array testing
    long lArray[]= new long[10];
    for(int i=0;i<10;++i) {
      lArray[i]= (i*offset);
    }

    Long LongArray[]= box.box(lArray);
    for(int i=0;i<10;++i) {
      assertEquals(Long.valueOf(i*offset), LongArray[i]);
    }
   
  }
  
  @Test public void testShortBox() {
  //variable short box testing
    Short b= box.box((short)3);
    assertEquals(Short.valueOf((short)3), b);
    
    b= box.box((short)-2);
    assertEquals(Short.valueOf((short)-2), b);
    
  //array testing
    short sArray[]= new short[10];
    for(int i=0;i<10;++i) {
      sArray[i]= ((short)i);
    }

    Short ShortArray[]= box.box(sArray);
    for(int i=0;i<10;++i) {
      assertEquals(Short.valueOf((short)i), ShortArray[i]);
    }
   
  }
  


  
  
  
  
  
  
  
  
  
  
  
  
  
  @Test public void testItBooleanBox() {
    //variable boolean box testing
    Boolean b= box.it(true);
    assertEquals(Boolean.valueOf(true), b);
    
    b= box.it(false);
    assertEquals(Boolean.valueOf(false), b);
    
    //array testing
    boolean bArray[]= new boolean[10];
    for(int i=0;i<10;++i) {
      bArray[i]=(i%2==0);
    }
    
    Boolean BooleanArray[]= box.it(bArray);
    for(int i=0;i<10;++i) {
      assertEquals(Boolean.valueOf((i%2==0)), BooleanArray[i]);
    }
  }
  
  @Test public void testItByteBox() {
    //variable boolean box testing
    Byte b= box.it((byte)6);
    assertEquals(Byte.valueOf((byte) 6), b);
    
    b= box.it((byte)0);
    assertEquals(Byte.valueOf((byte) 0), b);
    
    b= box.it((byte)-5);
    assertEquals(Byte.valueOf((byte) -5), b);
    
    //array testing
    byte bArray[]= new byte[10];
    for(int i=0;i<10;++i) {
      bArray[i]=((byte)(i));
    }
    
    Byte ByteArray[]= box.it(bArray);
    for(int i=0;i<10;++i) {
      assertEquals(Byte.valueOf((byte)i), ByteArray[i]);
    }
  }
  
  @Test public void testItCharBox() {
    //variable boolean box testing
    Character b= box.it('a');
    assertEquals(Character.valueOf('a'), b);
    
    b= box.it('b');
    assertEquals(Character.valueOf('b'), b);
    
  //array testing
    char cArray[]= new char[10];
    for(int i=0;i<10;++i) {
      cArray[i]=(char) ('a'+i);
    }
    
    Character CharArray[]= box.it(cArray);
    for(int i=0;i<10;++i) {
      assertEquals(Character.valueOf((char) ('a'+i)), CharArray[i]);
    }
   
  }
  
  @Test public void testItDoubleBox() {
    //variable double box testing
    Double b= box.it(3.14);
    assertEquals(Double.valueOf(3.14), b);
    
    b= box.it(2.71);
    assertEquals(Double.valueOf(2.71), b);
    
  //array testing
    double dArray[]= new double[10];
    for(int i=0;i<10;++i) {
      dArray[i]= (3.14+i);
    }

    Double DoubleArray[]= box.it(dArray);
    for(int i=0;i<10;++i) {
      assertEquals(Double.valueOf(3.14+i), DoubleArray[i]);
    }
   
  }
  
  @Test public void testItFloatBox() {
    float diff=(float) 0.00005;
    //variable double box testing
    Float b= box.it((float)3.14);
    assertTrue(b<=Float.valueOf((float)3.14+diff)&&b>=Float.valueOf((float)3.14-diff));
    
    b= box.it((float)2.71);
    assertTrue(b<=Float.valueOf((float)2.71+diff)&&b>=Float.valueOf((float)2.71-diff));
    
  //array testing
    float fArray[]= new float[10];
    for(int i=0;i<10;++i) {
      fArray[i]= (float)(3.14+i);
    }

    Float FloatArray[]= box.it(fArray);
    for(int i=0;i<10;++i) {
      assertTrue(FloatArray[i]<=Float.valueOf((float) ((float)3.14+i+diff))&&
          FloatArray[i]>=Float.valueOf((float) ((float)3.14+i-diff)));
    }
   
  }
  
  @Test public void testItIntegerBox() {
    //variable int box testing
    Integer b= box.it(3);
    assertEquals(Integer.valueOf(3), b);
    
    b= box.it(-2);
    assertEquals(Integer.valueOf(-2), b);
    
  //array testing
    int iArray[]= new int[10];
    for(int i=0;i<10;++i) {
      iArray[i]= (i);
    }

    Integer IntegerArray[]= box.it(iArray);
    for(int i=0;i<10;++i) {
      assertEquals(Integer.valueOf(i), IntegerArray[i]);
    }
   
  }
  
  @Test public void testItLongBox() {
    //variable long box testing
    long offset=(long) 1e7;
    Long b= box.it(3*offset);
    assertEquals(Long.valueOf(3*offset), b);
    
    b= box.it(-3*offset);
    assertEquals(Long.valueOf(-3*offset), b);
    
  //array testing
    long lArray[]= new long[10];
    for(int i=0;i<10;++i) {
      lArray[i]= (i*offset);
    }

    Long LongArray[]= box.it(lArray);
    for(int i=0;i<10;++i) {
      assertEquals(Long.valueOf(i*offset), LongArray[i]);
    }
   
  }
  
  @Test public void testItShortBox() {
  //variable short box testing
    Short b= box.it((short)3);
    assertEquals(Short.valueOf((short)3), b);
    
    b= box.it((short)-2);
    assertEquals(Short.valueOf((short)-2), b);
    
  //array testing
    short sArray[]= new short[10];
    for(int i=0;i<10;++i) {
      sArray[i]= ((short)i);
    }

    Short ShortArray[]= box.it(sArray);
    for(int i=0;i<10;++i) {
      assertEquals(Short.valueOf((short)i), ShortArray[i]);
    }
   
  }
  
  
}