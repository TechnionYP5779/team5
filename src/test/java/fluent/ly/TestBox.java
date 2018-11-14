package fluent.ly;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class TestBox {
  @Test public void testBooleanBox() {
    Boolean b = box.box(true);
    azzert.that(b, is(Boolean.TRUE));
    b = box.box(false);
    azzert.that(b, is(Boolean.FALSE));
    final boolean bArray[] = new boolean[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = ¢ % 2 == 0;
    final Boolean BooleanArray[] = box.box(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(BooleanArray[¢], is(box.box(¢ % 2 == 0)));
  }

  @Test public void testByteBox() {
    Byte b = box.box((byte) 6);
    azzert.that(b, is(box.box((byte) 6)));
    b = box.box((byte) 0);
    azzert.that(b, is(box.box((byte) 0)));
    b = box.box((byte) -5);
    azzert.that(b, is(box.box((byte) -5)));
    final byte bArray[] = new byte[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = (byte) ¢;
    final Byte ByteArray[] = box.box(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ByteArray[¢], is(box.box((byte) ¢)));
  }

  @Test public void testCharBox() {
    Character b = box.box('a');
    azzert.that(b, is(box.box('a')));
    b = box.box('b');
    azzert.that(b, is(box.box('b')));
    final char cArray[] = new char[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      cArray[¢] = (char) (¢ + 'a');
    final Character CharArray[] = box.box(cArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(CharArray[¢], is(box.box((char) (¢ + 'a'))));
  }

  @Test public void testDoubleBox() {
    Double b = box.box(3.14);
    azzert.that(b, is(box.box(3.14)));
    b = box.box(2.71);
    azzert.that(b, is(box.box(2.71)));
    final double dArray[] = new double[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      dArray[¢] = ¢ + 3.14;
    final Double DoubleArray[] = box.box(dArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(DoubleArray[¢], is(box.box(¢ + 3.14)));
  }

  @Test @SuppressWarnings("boxing") public void testFloatBox() {
    final float diff = (float) 0.00005;
    Float b = box.box((float) 3.14);
    azzert.assertTrue(b <= box.box(diff + (float) 3.14) && b >= box.box((float) 3.14 - diff));
    b = box.box((float) 2.71);
    azzert.assertTrue(b <= box.box(diff + (float) 2.71) && b >= box.box((float) 2.71 - diff));
    final float fArray[] = new float[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      fArray[¢] = (float) (¢ + 3.14);
    final Float FloatArray[] = box.box(fArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertTrue(FloatArray[¢] <= box.box(¢ + diff + (float) 3.14) && FloatArray[¢] >= box.box(¢ + (float) 3.14 - diff));
  }

  @Test public void testIntegerBox() {
    Integer b = box.box(3);
    azzert.that(b, is(box.box(3)));
    b = box.box(-2);
    azzert.that(b, is(box.box(-2)));
    final int iArray[] = new int[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      iArray[¢] = ¢;
    final Integer IntegerArray[] = box.box(iArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(IntegerArray[¢], is(box.box(¢)));
  }

  @Test public void testLongBox() {
    final long offset = (long) 1e7;
    Long b = box.box(3 * offset);
    azzert.that(b, is(box.box(3 * offset)));
    b = box.box(-3 * offset);
    azzert.that(b, is(box.box(-3 * offset)));
    final long lArray[] = new long[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      lArray[¢] = ¢ * offset;
    final Long LongArray[] = box.box(lArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(LongArray[¢], is(box.box(¢ * offset)));
  }

  @Test public void testShortBox() {
    Short b = box.box((short) 3);
    azzert.that(b, is(box.box((short) 3)));
    b = box.box((short) -2);
    azzert.that(b, is(box.box((short) -2)));
    final short sArray[] = new short[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      sArray[¢] = (short) ¢;
    final Short ShortArray[] = box.box(sArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ShortArray[¢], is(box.box((short) ¢)));
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
      azzert.that(BooleanArray[¢], is(box.box(¢ % 2 == 0)));
  }

  @Test public void testItByteBox() {
    Byte b = box.it((byte) 6);
    azzert.that(b, is(box.box((byte) 6)));
    b = box.it((byte) 0);
    azzert.that(b, is(box.box((byte) 0)));
    b = box.it((byte) -5);
    azzert.that(b, is(box.box((byte) -5)));
    final byte bArray[] = new byte[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = (byte) ¢;
    final Byte ByteArray[] = box.it(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ByteArray[¢], is(box.box((byte) ¢)));
  }

  @Test public void testItCharBox() {
    Character b = box.it('a');
    azzert.that(b, is(box.box('a')));
    b = box.it('b');
    azzert.that(b, is(box.box('b')));
    final char cArray[] = new char[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      cArray[¢] = (char) (¢ + 'a');
    final Character CharArray[] = box.it(cArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(CharArray[¢], is(box.box((char) (¢ + 'a'))));
  }

  @Test public void testItDoubleBox() {
    Double b = box.it(3.14);
    azzert.that(b, is(box.box(3.14)));
    b = box.it(2.71);
    azzert.that(b, is(box.box(2.71)));
    final double dArray[] = new double[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      dArray[¢] = ¢ + 3.14;
    final Double DoubleArray[] = box.it(dArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(DoubleArray[¢], is(box.box(¢ + 3.14)));
  }

  @Test public void testItFloatBox() {
    final float diff = (float) 0.00005;
    Float b = box.it((float) 3.14);
    azzert.assertTrue(unbox.unbox(b) <= unbox.unbox(box.box(diff + (float) 3.14)) && unbox.unbox(b) >= (float) 3.14 - diff);
    b = box.it((float) 2.71);
    azzert.assertTrue(unbox.unbox(b) <= diff + (float) 2.71 && unbox.unbox(b) >= (float) 2.71 - diff);
    final float fArray[] = new float[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      fArray[¢] = (float) (¢ + 3.14);
    final @NotNull Float FloatArray[] = box.it(fArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertTrue(unbox.unbox(FloatArray[¢]) <= ¢ + diff + (float) 3.14 && unbox.unbox(FloatArray[¢]) >= ¢ + (float) 3.14 - diff);
  }

  @Test public void testItIntegerBox() {
    Integer b = box.it(3);
    azzert.that(b, is(box.box(3)));
    b = box.it(-2);
    azzert.that(b, is(box.box(-2)));
    final int iArray[] = new int[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      iArray[¢] = ¢;
    final Integer IntegerArray[] = box.it(iArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(IntegerArray[¢], is(box.box(¢)));
  }

  @Test public void testItLongBox() {
    final long offset = (long) 1e7;
    Long b = box.it(3 * offset);
    azzert.that(b, is(box.box(3 * offset)));
    b = box.it(-3 * offset);
    azzert.that(b, is(box.box(-3 * offset)));
    final long lArray[] = new long[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      lArray[¢] = ¢ * offset;
    final Long LongArray[] = box.it(lArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(LongArray[¢], is(box.box(¢ * offset)));
  }

  @Test public void testItShortBox() {
    Short b = box.it((short) 3);
    azzert.that(b, is(box.box((short) 3)));
    b = box.it((short) -2);
    azzert.that(b, is(box.box((short) -2)));
    final short sArray[] = new short[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      sArray[¢] = (short) ¢;
    final Short ShortArray[] = box.it(sArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ShortArray[¢], is(box.box((short) ¢)));
  }
}