package fluent.ly;

import org.junit.*;

public class unboxTest {
  
  @Test public void testUnboxBooleanArray() {
    boolean[] expected = {false, true, true, false};
    Boolean[] tested = {Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE};
    
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }
  
  @Test public void testUnboxByteArray() {
    byte[] expected = {0, 1, 2, 3};
    Byte[] tested = {Byte.valueOf("0"), Byte.valueOf("1"), Byte.valueOf("2"), Byte.valueOf("3")};
    
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }
  
  @Test public void testUnboxCharacterArray() {
    char[] expected = {'a', 'b', 'c', 'd'};
    Character[] tested = {Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c'), Character.valueOf('d')};
    
    azzert.that(unbox.unbox(tested), azzert.is(expected));
    }
  
  @Test public void testUnboxShortArray() {
    short[] expected = {1, 2, 3, 4};
    Short[] tested = {Short.valueOf("1"), Short.valueOf("2"), Short.valueOf("3"), Short.valueOf("4")};
    
    azzert.assertArrayEquals(expected, unbox.unbox(tested));
  }
  
  @Test public void testUnboxDoubleArray() {
    double[] expected = {1.1, 1.2, 1.3, 1.4};
    Double[] tested = {Double.valueOf(1.1), Double.valueOf(1.2), Double.valueOf(1.3), Double.valueOf(1.4)};
    
    azzert.assertArrayEquals(expected, unbox.unbox(tested),0.001);
  }
  
  @Test public void testUnboxFloatArray() {
    float[] expected = {(float) 1.1, (float) 1.2, (float) 1.3, (float) 1.4};
    Float[] tested = {Float.valueOf((float) 1.1), Float.valueOf((float) 1.2), Float.valueOf((float) 1.3), Float.valueOf((float) 1.4)};
    
    azzert.assertArrayEquals(expected, unbox.unbox(tested),(float)0.001);
  }
  
  @Test public void testUnboxIntegerArray() {
    int[] expected = {1, 2, 3, 4};
    Integer[] tested = {Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)};
    
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }
  
  @Test public void testUnboxLongArray() {
    long[] expected = {1, 2, 3, 4};
    Long[] tested = {Long.valueOf(1), Long.valueOf(2), Long.valueOf(3), Long.valueOf(4)};
    
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }
}
