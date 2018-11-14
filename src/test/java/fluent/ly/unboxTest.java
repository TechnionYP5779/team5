package fluent.ly;

import org.junit.*;

/**
 * @author yogi
 *
 */
@SuppressWarnings("static-method") public class unboxTest {
  @Test public void testUnboxBooleanArray() {
    azzert.that(unbox.unbox(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }),
        azzert.is(new boolean[] { false, true, true, false }));
  }

  @Test public void testUnboxByteArray() {
    azzert.that(unbox.unbox(new Byte[] { Byte.valueOf("0"), Byte.valueOf("1"), Byte.valueOf("2"), Byte.valueOf("3") }),
        azzert.is(new byte[] { 0, 1, 2, 3 }));
  }

  @Test public void testUnboxCharacterArray() {
    azzert.that(unbox.unbox(new Character[] { Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c'), Character.valueOf('d') }),
        azzert.is(new char[] { 'a', 'b', 'c', 'd' }));
  }

  @Test public void testUnboxShortArray() {
    Assert.assertArrayEquals(new short[] { 1, 2, 3, 4 },
        unbox.unbox(new Short[] { Short.valueOf("1"), Short.valueOf("2"), Short.valueOf("3"), Short.valueOf("4") }));
  }

  @Test public void testUnboxDoubleArray() {
    Assert.assertArrayEquals(new double[] { 1.1, 1.2, 1.3, 1.4 },
        unbox.unbox(new Double[] { Double.valueOf(1.1), Double.valueOf(1.2), Double.valueOf(1.3), Double.valueOf(1.4) }), 0.001);
  }

  @Test public void testUnboxFloatArray() {
    Assert.assertArrayEquals(new float[] { (float) 1.1, (float) 1.2, (float) 1.3, (float) 1.4 },
        unbox.unbox(new Float[] { Float.valueOf((float) 1.1), Float.valueOf((float) 1.2), Float.valueOf((float) 1.3), Float.valueOf((float) 1.4) }),
        (float) 0.001);
  }

  @Test public void testUnboxIntegerArray() {
    azzert.that(unbox.unbox(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4) }),
        azzert.is(new int[] { 1, 2, 3, 4 }));
  }

  @Test public void testUnboxLongArray() {
    azzert.that(unbox.unbox(new Long[] { Long.valueOf(1), Long.valueOf(2), Long.valueOf(3), Long.valueOf(4) }), azzert.is(new long[] { 1, 2, 3, 4 }));
  }
}
