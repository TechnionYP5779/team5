package fluent.ly;

import org.junit.*;

public class TestBox {
  @Test @SuppressWarnings("static-method") public void testBooleanBox() {
    Boolean b = box.box(true);
    azzert.that(b, azzert.is(Boolean.TRUE));
    b = box.box(false);
    azzert.that(b, azzert.is(Boolean.FALSE));
    final boolean bArray[] = new boolean[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = ¢ % 2 == 0;
    final Boolean BooleanArray[] = box.box(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(BooleanArray[¢], azzert.is(Boolean.valueOf(¢ % 2 == 0)));
  }

  @Test @SuppressWarnings("static-method") public void testByteBox() {
    Byte b = box.box((byte) 6);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 6)));
    b = box.box((byte) 0);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 0)));
    b = box.box((byte) -5);
    azzert.that(b, azzert.is(Byte.valueOf((byte) -5)));
    final byte bArray[] = new byte[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = (byte) ¢;
    final Byte ByteArray[] = box.box(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ByteArray[¢], azzert.is(Byte.valueOf((byte) ¢)));
  }

  @Test @SuppressWarnings("static-method") public void testCharBox() {
    Character b = box.box('a');
    azzert.that(b, azzert.is(Character.valueOf('a')));
    b = box.box('b');
    azzert.that(b, azzert.is(Character.valueOf('b')));
    final char cArray[] = new char[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      cArray[¢] = (char) (¢ + 'a');
    final Character CharArray[] = box.box(cArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(CharArray[¢], azzert.is(Character.valueOf((char) (¢ + 'a'))));
  }

  @Test @SuppressWarnings("static-method") public void testDoubleBox() {
    Double b = box.box(3.14);
    azzert.that(b, azzert.is(Double.valueOf(3.14)));
    b = box.box(2.71);
    azzert.that(b, azzert.is(Double.valueOf(2.71)));
    final double dArray[] = new double[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      dArray[¢] = ¢ + 3.14;
    final Double DoubleArray[] = box.box(dArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(DoubleArray[¢], azzert.is(Double.valueOf(¢ + 3.14)));
  }

  @Test @SuppressWarnings({ "boxing", "static-method" }) public void testFloatBox() {
    final float diff = (float) 0.00005;
    Float b = box.box((float) 3.14);
    azzert.assertTrue(b <= Float.valueOf(diff + (float) 3.14) && b >= Float.valueOf((float) 3.14 - diff));
    b = box.box((float) 2.71);
    azzert.assertTrue(b <= Float.valueOf(diff + (float) 2.71) && b >= Float.valueOf((float) 2.71 - diff));
    final float fArray[] = new float[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      fArray[¢] = (float) (¢ + 3.14);
    final Float FloatArray[] = box.box(fArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertTrue(FloatArray[¢] <= Float.valueOf(¢ + diff + (float) 3.14) && FloatArray[¢] >= Float.valueOf(¢ + (float) 3.14 - diff));
  }

  @Test @SuppressWarnings("static-method") public void testIntegerBox() {
    Integer b = box.box(3);
    azzert.that(b, azzert.is(Integer.valueOf(3)));
    b = box.box(-2);
    azzert.that(b, azzert.is(Integer.valueOf(-2)));
    final int iArray[] = new int[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      iArray[¢] = ¢;
    final Integer IntegerArray[] = box.box(iArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(IntegerArray[¢], azzert.is(Integer.valueOf(¢)));
  }

  @Test @SuppressWarnings("static-method") public void testLongBox() {
    final long offset = (long) 1e7;
    Long b = box.box(3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(3 * offset)));
    b = box.box(-3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(-3 * offset)));
    final long lArray[] = new long[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      lArray[¢] = ¢ * offset;
    final Long LongArray[] = box.box(lArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(LongArray[¢], azzert.is(Long.valueOf(¢ * offset)));
  }

  @Test @SuppressWarnings("static-method") public void testShortBox() {
    Short b = box.box((short) 3);
    azzert.that(b, azzert.is(Short.valueOf((short) 3)));
    b = box.box((short) -2);
    azzert.that(b, azzert.is(Short.valueOf((short) -2)));
    final short sArray[] = new short[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      sArray[¢] = (short) ¢;
    final Short ShortArray[] = box.box(sArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ShortArray[¢], azzert.is(Short.valueOf((short) ¢)));
  }

  @Test @SuppressWarnings("static-method") public void testItBooleanBox() {
    Boolean b = box.it(true);
    azzert.that(b, azzert.is(Boolean.TRUE));
    b = box.it(false);
    azzert.that(b, azzert.is(Boolean.FALSE));
    final boolean bArray[] = new boolean[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = ¢ % 2 == 0;
    final Boolean BooleanArray[] = box.it(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(BooleanArray[¢], azzert.is(Boolean.valueOf(¢ % 2 == 0)));
  }

  @Test @SuppressWarnings("static-method") public void testItByteBox() {
    Byte b = box.it((byte) 6);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 6)));
    b = box.it((byte) 0);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 0)));
    b = box.it((byte) -5);
    azzert.that(b, azzert.is(Byte.valueOf((byte) -5)));
    final byte bArray[] = new byte[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      bArray[¢] = (byte) ¢;
    final Byte ByteArray[] = box.it(bArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ByteArray[¢], azzert.is(Byte.valueOf((byte) ¢)));
  }

  @Test @SuppressWarnings("static-method") public void testItCharBox() {
    Character b = box.it('a');
    azzert.that(b, azzert.is(Character.valueOf('a')));
    b = box.it('b');
    azzert.that(b, azzert.is(Character.valueOf('b')));
    final char cArray[] = new char[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      cArray[¢] = (char) (¢ + 'a');
    final Character CharArray[] = box.it(cArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(CharArray[¢], azzert.is(Character.valueOf((char) (¢ + 'a'))));
  }

  @Test @SuppressWarnings("static-method") public void testItDoubleBox() {
    Double b = box.it(3.14);
    azzert.that(b, azzert.is(Double.valueOf(3.14)));
    b = box.it(2.71);
    azzert.that(b, azzert.is(Double.valueOf(2.71)));
    final double dArray[] = new double[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      dArray[¢] = ¢ + 3.14;
    final Double DoubleArray[] = box.it(dArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(DoubleArray[¢], azzert.is(Double.valueOf(¢ + 3.14)));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testItFloatBox() {
    final float diff = (float) 0.00005;
    Float b = box.it((float) 3.14);
    azzert.assertTrue(b <= Float.valueOf(diff + (float) 3.14) && b >= Float.valueOf((float) 3.14 - diff));
    b = box.it((float) 2.71);
    azzert.assertTrue(b <= Float.valueOf(diff + (float) 2.71) && b >= Float.valueOf((float) 2.71 - diff));
    final float fArray[] = new float[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      fArray[¢] = (float) (¢ + 3.14);
    final Float FloatArray[] = box.it(fArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.assertTrue(FloatArray[¢] <= Float.valueOf(¢ + diff + (float) 3.14) && FloatArray[¢] >= Float.valueOf(¢ + (float) 3.14 - diff));
  }

  @Test @SuppressWarnings("static-method") public void testItIntegerBox() {
    Integer b = box.it(3);
    azzert.that(b, azzert.is(Integer.valueOf(3)));
    b = box.it(-2);
    azzert.that(b, azzert.is(Integer.valueOf(-2)));
    final int iArray[] = new int[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      iArray[¢] = ¢;
    final Integer IntegerArray[] = box.it(iArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(IntegerArray[¢], azzert.is(Integer.valueOf(¢)));
  }

  @Test @SuppressWarnings("static-method") public void testItLongBox() {
    final long offset = (long) 1e7;
    Long b = box.it(3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(3 * offset)));
    b = box.it(-3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(-3 * offset)));
    final long lArray[] = new long[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      lArray[¢] = ¢ * offset;
    final Long LongArray[] = box.it(lArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(LongArray[¢], azzert.is(Long.valueOf(¢ * offset)));
  }

  @Test @SuppressWarnings("static-method") public void testItShortBox() {
    Short b = box.it((short) 3);
    azzert.that(b, azzert.is(Short.valueOf((short) 3)));
    b = box.it((short) -2);
    azzert.that(b, azzert.is(Short.valueOf((short) -2)));
    final short sArray[] = new short[10];
    for (int ¢ = 0; ¢ < 10; ++¢)
      sArray[¢] = (short) ¢;
    final Short ShortArray[] = box.it(sArray);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(ShortArray[¢], azzert.is(Short.valueOf((short) ¢)));
  }
}