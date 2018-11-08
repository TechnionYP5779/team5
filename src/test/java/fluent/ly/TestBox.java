package fluent.ly;

import org.junit.*;

public class TestBox {
  @Test public void testBooleanBox() {
    // variable boolean box testing
    Boolean b = box.box(true);
    azzert.that(b, azzert.is(Boolean.valueOf(true)));
    b = box.box(false);
    azzert.that(b, azzert.is(Boolean.valueOf(false)));
    // array testing
    final boolean bArray[] = new boolean[10];
    for (int i = 0; i < 10; ++i)
      bArray[i] = i % 2 == 0;
    final Boolean BooleanArray[] = box.box(bArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(BooleanArray[i], azzert.is(Boolean.valueOf(i % 2 == 0)));
  }

  @Test public void testByteBox() {
    // variable boolean box testing
    Byte b = box.box((byte) 6);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 6)));
    b = box.box((byte) 0);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 0)));
    b = box.box((byte) -5);
    azzert.that(b, azzert.is(Byte.valueOf((byte) -5)));
    // array testing
    final byte bArray[] = new byte[10];
    for (int i = 0; i < 10; ++i)
      bArray[i] = (byte) i;
    final Byte ByteArray[] = box.box(bArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(ByteArray[i], azzert.is(Byte.valueOf((byte) i)));
  }

  @Test public void testCharBox() {
    // variable boolean box testing
    Character b = box.box('a');
    azzert.that(b, azzert.is(Character.valueOf('a')));
    b = box.box('b');
    azzert.that(b, azzert.is(Character.valueOf('b')));
    // array testing
    final char cArray[] = new char[10];
    for (int i = 0; i < 10; ++i)
      cArray[i] = (char) ('a' + i);
    final Character CharArray[] = box.box(cArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(CharArray[i], azzert.is(Character.valueOf((char) ('a' + i))));
  }

  @Test public void testDoubleBox() {
    // variable double box testing
    Double b = box.box(3.14);
    azzert.that(b, azzert.is(Double.valueOf(3.14)));
    b = box.box(2.71);
    azzert.that(b, azzert.is(Double.valueOf(2.71)));
    // array testing
    final double dArray[] = new double[10];
    for (int i = 0; i < 10; ++i)
      dArray[i] = 3.14 + i;
    final Double DoubleArray[] = box.box(dArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(DoubleArray[i], azzert.is(Double.valueOf(3.14 + i)));
  }

  @Test public void testFloatBox() {
    final float diff = (float) 0.00005;
    // variable double box testing
    Float b = box.box((float) 3.14);
    azzert.assertTrue(b <= Float.valueOf((float) 3.14 + diff) && b >= Float.valueOf((float) 3.14 - diff));
    b = box.box((float) 2.71);
    azzert.assertTrue(b <= Float.valueOf((float) 2.71 + diff) && b >= Float.valueOf((float) 2.71 - diff));
    // array testing
    final float fArray[] = new float[10];
    for (int i = 0; i < 10; ++i)
      fArray[i] = (float) (3.14 + i);
    final Float FloatArray[] = box.box(fArray);
    for (int i = 0; i < 10; ++i)
      azzert.assertTrue(FloatArray[i] <= Float.valueOf((float) 3.14 + i + diff) && FloatArray[i] >= Float.valueOf((float) 3.14 + i - diff));
  }

  @Test public void testIntegerBox() {
    // variable int box testing
    Integer b = box.box(3);
    azzert.that(b, azzert.is(Integer.valueOf(3)));
    b = box.box(-2);
    azzert.that(b, azzert.is(Integer.valueOf(-2)));
    // array testing
    final int iArray[] = new int[10];
    for (int i = 0; i < 10; ++i)
      iArray[i] = i;
    final Integer IntegerArray[] = box.box(iArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(IntegerArray[i], azzert.is(Integer.valueOf(i)));
  }

  @Test public void testLongBox() {
    // variable long box testing
    final long offset = (long) 1e7;
    Long b = box.box(3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(3 * offset)));
    b = box.box(-3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(-3 * offset)));
    // array testing
    final long lArray[] = new long[10];
    for (int i = 0; i < 10; ++i)
      lArray[i] = i * offset;
    final Long LongArray[] = box.box(lArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(LongArray[i], azzert.is(Long.valueOf(i * offset)));
  }

  @Test public void testShortBox() {
    // variable short box testing
    Short b = box.box((short) 3);
    azzert.that(b, azzert.is(Short.valueOf((short) 3)));
    b = box.box((short) -2);
    azzert.that(b, azzert.is(Short.valueOf((short) -2)));
    // array testing
    final short sArray[] = new short[10];
    for (int i = 0; i < 10; ++i)
      sArray[i] = (short) i;
    final Short ShortArray[] = box.box(sArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(ShortArray[i], azzert.is(Short.valueOf((short) i)));
  }

  @Test public void testItBooleanBox() {
    // variable boolean box testing
    Boolean b = box.it(true);
    azzert.that(b, azzert.is(Boolean.valueOf(true)));
    b = box.it(false);
    azzert.that(b, azzert.is(Boolean.valueOf(false)));
    // array testing
    final boolean bArray[] = new boolean[10];
    for (int i = 0; i < 10; ++i)
      bArray[i] = i % 2 == 0;
    final Boolean BooleanArray[] = box.it(bArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(BooleanArray[i], azzert.is(Boolean.valueOf(i % 2 == 0)));
  }

  @Test public void testItByteBox() {
    // variable boolean box testing
    Byte b = box.it((byte) 6);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 6)));
    b = box.it((byte) 0);
    azzert.that(b, azzert.is(Byte.valueOf((byte) 0)));
    b = box.it((byte) -5);
    azzert.that(b, azzert.is(Byte.valueOf((byte) -5)));
    // array testing
    final byte bArray[] = new byte[10];
    for (int i = 0; i < 10; ++i)
      bArray[i] = (byte) i;
    final Byte ByteArray[] = box.it(bArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(ByteArray[i], azzert.is(Byte.valueOf((byte) i)));
  }

  @Test public void testItCharBox() {
    // variable boolean box testing
    Character b = box.it('a');
    azzert.that(b, azzert.is(Character.valueOf('a')));
    b = box.it('b');
    azzert.that(b, azzert.is(Character.valueOf('b')));
    // array testing
    final char cArray[] = new char[10];
    for (int i = 0; i < 10; ++i)
      cArray[i] = (char) ('a' + i);
    final Character CharArray[] = box.it(cArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(CharArray[i], azzert.is(Character.valueOf((char) ('a' + i))));
  }

  @Test public void testItDoubleBox() {
    // variable double box testing
    Double b = box.it(3.14);
    azzert.that(b, azzert.is(Double.valueOf(3.14)));
    b = box.it(2.71);
    azzert.that(b, azzert.is(Double.valueOf(2.71)));
    // array testing
    final double dArray[] = new double[10];
    for (int i = 0; i < 10; ++i)
      dArray[i] = 3.14 + i;
    final Double DoubleArray[] = box.it(dArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(DoubleArray[i], azzert.is(Double.valueOf(3.14 + i)));
  }

  @Test public void testItFloatBox() {
    final float diff = (float) 0.00005;
    // variable double box testing
    Float b = box.it((float) 3.14);
    azzert.assertTrue(b <= Float.valueOf((float) 3.14 + diff) && b >= Float.valueOf((float) 3.14 - diff));
    b = box.it((float) 2.71);
    azzert.assertTrue(b <= Float.valueOf((float) 2.71 + diff) && b >= Float.valueOf((float) 2.71 - diff));
    // array testing
    final float fArray[] = new float[10];
    for (int i = 0; i < 10; ++i)
      fArray[i] = (float) (3.14 + i);
    final Float FloatArray[] = box.it(fArray);
    for (int i = 0; i < 10; ++i)
      azzert.assertTrue(FloatArray[i] <= Float.valueOf((float) 3.14 + i + diff) && FloatArray[i] >= Float.valueOf((float) 3.14 + i - diff));
  }

  @Test public void testItIntegerBox() {
    // variable int box testing
    Integer b = box.it(3);
    azzert.that(b, azzert.is(Integer.valueOf(3)));
    b = box.it(-2);
    azzert.that(b, azzert.is(Integer.valueOf(-2)));
    // array testing
    final int iArray[] = new int[10];
    for (int i = 0; i < 10; ++i)
      iArray[i] = i;
    final Integer IntegerArray[] = box.it(iArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(IntegerArray[i], azzert.is(Integer.valueOf(i)));
  }

  @Test public void testItLongBox() {
    // variable long box testing
    final long offset = (long) 1e7;
    Long b = box.it(3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(3 * offset)));
    b = box.it(-3 * offset);
    azzert.that(b, azzert.is(Long.valueOf(-3 * offset)));
    // array testing
    final long lArray[] = new long[10];
    for (int i = 0; i < 10; ++i)
      lArray[i] = i * offset;
    final Long LongArray[] = box.it(lArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(LongArray[i], azzert.is(Long.valueOf(i * offset)));
  }

  @Test public void testItShortBox() {
    // variable short box testing
    Short b = box.it((short) 3);
    azzert.that(b, azzert.is(Short.valueOf((short) 3)));
    b = box.it((short) -2);
    azzert.that(b, azzert.is(Short.valueOf((short) -2)));
    // array testing
    final short sArray[] = new short[10];
    for (int i = 0; i < 10; ++i)
      sArray[i] = (short) i;
    final Short ShortArray[] = box.it(sArray);
    for (int i = 0; i < 10; ++i)
      azzert.that(ShortArray[i], azzert.is(Short.valueOf((short) i)));
  }
}