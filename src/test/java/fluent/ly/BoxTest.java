package fluent.ly;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class BoxTest {
  @Test public void testBooleanBox() {
    Boolean b = box.it(true);
    azzert.that(b, is(Boolean.TRUE));
    b = box.it(false);
    azzert.that(b, is(Boolean.FALSE));
    final boolean bArray[] = new boolean[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = ¢ % 2 == 0;
    final Boolean BooleanArray[] = box.it(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(BooleanArray[¢], is(box.it(¢ % 2 == 0)));
    
    boolean[] arr= {true,true,true,true};
    @NotNull Boolean[] arrBoxed=box.box(arr);
    for (int ¢ = 0; ¢ < 4; ++¢)
      azzert.that(unbox.it(arrBoxed[¢]),azzert.is(true));    
    
    
  }

  @Test public void testByteBox() {
    Byte b = box.it((byte) 6);
    azzert.that(b, is(box.it((byte) 6)));
    b = box.it((byte) 0);
    azzert.that(b, is(box.it((byte) 0)));
    b = box.it((byte) -5);
    azzert.that(b, is(box.it((byte) -5)));
    final byte bArray[] = new byte[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = (byte) ¢;
    final Byte ByteArray[] = box.it(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ByteArray[¢], is(box.it((byte) ¢)));
    
    byte[] arr= {1,1,1,1};
    @NotNull Byte[] arrBoxed=box.box(arr);
    azzert.that(unbox.it(arrBoxed),azzert.is(arr));    
  }

  @Test public void testCharBox() {
    Character b = box.it('a');
    azzert.that(b, is(box.it('a')));
    Character d = box.box('a');
    azzert.that(d, is(box.box('a')));
    b = box.it('b');
    azzert.that(b, is(box.it('b')));
    final char cArray[] = new char[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      cArray[¢] = (char) (¢ + 'a');
    final Character CharArray[] = box.it(cArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(CharArray[¢], is(box.it((char) (¢ + 'a'))));
    final Character Char2Array[] = box.box(cArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(Char2Array[¢], is(box.it((char) (¢ + 'a'))));
  }

  @Test public void testDoubleBox() {
    Double b = box.it(3.14);
    azzert.that(b, is(box.it(3.14)));
    Double d = box.box(3.14);
    azzert.that(d, is(box.it(3.14)));
    b = box.it(2.71);
    azzert.that(b, is(box.it(2.71)));
    final double dArray[] = new double[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      dArray[¢] = ¢ + 3.14;
    final Double DoubleArray[] = box.it(dArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(DoubleArray[¢], is(box.it(¢ + 3.14)));
    final Double Double2Array[] = box.box(dArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(Double2Array[¢], is(box.it(¢ + 3.14)));
  }

  @Test public void testFloatBox() {
    final float diff = (float) 0.00005;
    Float b = box.it((float) 3.14);
    assert box.it(diff + (float) 3.14).compareTo(b) >= 0 && box.it((float) 3.14 - diff).compareTo(b) <= 0;
    Float d = box.box((float) 3.14);
    assert box.it(diff + (float) 3.14).compareTo(d) >= 0 && box.it((float) 3.14 - diff).compareTo(d) <= 0;
    b = box.it((float) 2.71);
    assert box.it(diff + (float) 2.71).compareTo(b) >= 0 && box.it((float) 2.71 - diff).compareTo(b) <= 0;
    final float fArray[] = new float[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      fArray[¢] = (float) (¢ + 3.14);
    final Float FloatArray[] = box.it(fArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert box.it(¢ + diff + (float) 3.14).compareTo(FloatArray[¢]) >= 0 && box.it(¢ + (float) 3.14 - diff).compareTo(FloatArray[¢]) <= 0;
      final Float Float2Array[] = box.box(fArray);
      for (int ¢ = 0; ¢ < 10; ++¢)
        assert box.it(¢ + diff + (float) 3.14).compareTo(Float2Array[¢]) >= 0 && box.it(¢ + (float) 3.14 - diff).compareTo(FloatArray[¢]) <= 0;
    
   }

  @Test public void testIntegerBox() {
    Integer b = box.it(3);
    azzert.that(b, is(box.it(3)));
    b = box.it(-2);
    azzert.that(b, is(box.it(-2)));
    final int iArray[] = new int[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      iArray[¢] = ¢;
    final Integer IntegerArray[] = box.it(iArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(IntegerArray[¢], is(box.it(¢)));
  }

  @Test public void testLongBox() {
    final long offset = (long) 1e7;
    Long b = box.it(3 * offset);
    azzert.that(b, is(box.it(3 * offset)));
    Long d = box.box(3 * offset);
    azzert.that(d, is(box.it(3 * offset)));
    b = box.it(-3 * offset);
    azzert.that(b, is(box.it(-3 * offset)));
    final long lArray[] = new long[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      lArray[¢] = ¢ * offset;
    final Long LongArray[] = box.it(lArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(LongArray[¢], is(box.it(¢ * offset)));
    final Long Long2Array[] = box.box(lArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(Long2Array[¢], is(box.it(¢ * offset)));
  }

  @Test public void testShortBox() {
    Short b = box.it((short) 3);
    azzert.that(b, is(box.it((short) 3)));
    Short d = box.box((short) 3);
    azzert.that(d, is(box.it((short) 3)));
    b = box.it((short) -2);
    azzert.that(b, is(box.it((short) -2)));
    final short sArray[] = new short[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      sArray[¢] = (short) ¢;
    final Short ShortArray[] = box.it(sArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ShortArray[¢], is(box.it((short) ¢)));
    final Short Short2Array[] = box.box(sArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(Short2Array[¢], is(box.it((short) ¢)));
  }

  @Test public void testItBooleanBox() {
    Boolean b = box.it(true);
    azzert.that(b, is(Boolean.TRUE));
    b = box.it(false);
    azzert.that(b, is(Boolean.FALSE));
    final boolean bArray[] = new boolean[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = ¢ % 2 == 0;
    final Boolean BooleanArray[] = box.it(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(BooleanArray[¢], is(box.it(¢ % 2 == 0)));
  }

  @Test public void testItByteBox() {
    Byte b = box.it((byte) 6);
    azzert.that(b, is(box.it((byte) 6)));
    b = box.it((byte) 0);
    azzert.that(b, is(box.it((byte) 0)));
    b = box.it((byte) -5);
    azzert.that(b, is(box.it((byte) -5)));
    final byte bArray[] = new byte[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = (byte) ¢;
    final Byte ByteArray[] = box.it(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ByteArray[¢], is(box.it((byte) ¢)));
  }

  @Test public void testItCharBox() {
    Character b = box.it('a');
    azzert.that(b, is(box.it('a')));
    b = box.it('b');
    azzert.that(b, is(box.it('b')));
    final char cArray[] = new char[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      cArray[¢] = (char) (¢ + 'a');
    final Character CharArray[] = box.it(cArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(CharArray[¢], is(box.it((char) (¢ + 'a'))));
  }

  @Test public void testItDoubleBox() {
    Double b = box.it(3.14);
    azzert.that(b, is(box.it(3.14)));
    b = box.it(2.71);
    azzert.that(b, is(box.it(2.71)));
    final double dArray[] = new double[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      dArray[¢] = ¢ + 3.14;
    final Double DoubleArray[] = box.it(dArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(DoubleArray[¢], is(box.it(¢ + 3.14)));
  }

  @Test public void testItFloatBox() {
    final float diff = (float) 0.00005;
    Float b = box.it((float) 3.14);
    assert unbox.it(b) <= unbox.it(box.it(diff + (float) 3.14)) && unbox.it(b) >= (float) 3.14 - diff;
    b = box.it((float) 2.71);
    assert unbox.it(b) <= diff + (float) 2.71 && unbox.it(b) >= (float) 2.71 - diff;
    final float fArray[] = new float[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      fArray[¢] = (float) (¢ + 3.14);
    final @NotNull Float FloatArray[] = box.it(fArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      assert unbox.it(FloatArray[¢]) <= ¢ + diff + (float) 3.14 && unbox.it(FloatArray[¢]) >= ¢ + (float) 3.14 - diff;
  }

  @Test public void testItIntegerBox() {
    Integer b = box.it(3);
    azzert.that(b, is(box.it(3)));
    b = box.it(-2);
    azzert.that(b, is(box.it(-2)));
    final int iArray[] = new int[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      iArray[¢] = ¢;
    final Integer IntegerArray[] = box.it(iArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(IntegerArray[¢], is(box.it(¢)));
  }

  @Test public void testItLongBox() {
    final long offset = (long) 1e7;
    Long b = box.it(3 * offset);
    azzert.that(b, is(box.it(3 * offset)));
    b = box.it(-3 * offset);
    azzert.that(b, is(box.it(-3 * offset)));
    final long lArray[] = new long[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      lArray[¢] = ¢ * offset;
    final Long LongArray[] = box.it(lArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(LongArray[¢], is(box.it(¢ * offset)));
  }

  @Test public void testItShortBox() {
    Short b = box.it((short) 3);
    azzert.that(b, is(box.it((short) 3)));
    b = box.it((short) -2);
    azzert.that(b, is(box.it((short) -2)));
    final short sArray[] = new short[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      sArray[¢] = (short) ¢;
    final Short ShortArray[] = box.it(sArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ShortArray[¢], is(box.it((short) ¢)));
  }
}