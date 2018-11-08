package fluent.ly;

import org.junit.*;

public class unboxTest {
  @Test public void testUnboxBooleanArray() {
    final boolean[] expected = { false, true, true, false };
    final Boolean[] tested = { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE };
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }

  @Test public void testUnboxByteArray() {
    final byte[] expected = { 0, 1, 2, 3 };
    final Byte[] tested = { Byte.valueOf("0"), Byte.valueOf("1"), Byte.valueOf("2"), Byte.valueOf("3") };
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }

  @Test public void testUnboxCharacterArray() {
    final char[] expected = { 'a', 'b', 'c', 'd' };
    final Character[] tested = { Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c'), Character.valueOf('d') };
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }

  @Test public void testUnboxShortArray() {
    final short[] expected = { 1, 2, 3, 4 };
    final Short[] tested = { Short.valueOf("1"), Short.valueOf("2"), Short.valueOf("3"), Short.valueOf("4") };
    Assert.assertArrayEquals(expected, unbox.unbox(tested));
  }

  @Test public void testUnboxDoubleArray() {
    final double[] expected = { 1.1, 1.2, 1.3, 1.4 };
    final Double[] tested = { Double.valueOf(1.1), Double.valueOf(1.2), Double.valueOf(1.3), Double.valueOf(1.4) };
    Assert.assertArrayEquals(expected, unbox.unbox(tested), 0.001);
  }

  @Test public void testUnboxFloatArray() {
    final float[] expected = { (float) 1.1, (float) 1.2, (float) 1.3, (float) 1.4 };
    final Float[] tested = { Float.valueOf((float) 1.1), Float.valueOf((float) 1.2), Float.valueOf((float) 1.3), Float.valueOf((float) 1.4) };
    Assert.assertArrayEquals(expected, unbox.unbox(tested), (float) 0.001);
  }

  @Test public void testUnboxIntegerArray() {
    final int[] expected = { 1, 2, 3, 4 };
    final Integer[] tested = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4) };
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }

  @Test public void testUnboxLongArray() {
    final long[] expected = { 1, 2, 3, 4 };
    final Long[] tested = { Long.valueOf(1), Long.valueOf(2), Long.valueOf(3), Long.valueOf(4) };
    azzert.that(unbox.unbox(tested), azzert.is(expected));
  }
}
