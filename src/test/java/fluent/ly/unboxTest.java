package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class unboxTest {
  @Test public void testUnboxBooleanArray() {
    azzert.that(unbox.it(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }), is(new boolean[] { false, true, true, false }));
  }

  @Test public void testUnboxByteArray() {
    azzert.that(unbox.it(new Byte[] { box.it((byte) 0), box.it((byte) 1), box.it((byte) 2), box.it((byte) 3) }), is(new byte[] { 0, 1, 2, 3 }));
  }

  @Test public void testUnboxCharacterArray() {
    azzert.that(unbox.it(new Character[] { box.it('a'), box.it('b'), box.it('c'), box.it('d') }), is(new char[] { 'a', 'b', 'c', 'd' }));
  }

  @Test public void testUnboxShortArray() {
    azzert.that(unbox.it(new Short[] { box.it((short) 1), box.it((short) 2), box.it((short) 3), box.it((short) 4) }), is(new short[] { 1, 2, 3, 4 }));
  }

  @Test public void testUnboxDoubleArray() {
    Assert.assertArrayEquals(new double[] { 1.1, 1.2, 1.3, 1.4 }, unbox.it(new Double[] { box.it(1.1), box.it(1.2), box.it(1.3), box.it(1.4) }),
        0.001);
  }

  @Test public void testUnboxFloatArray() {
    Assert.assertArrayEquals(new float[] { (float) 1.1, (float) 1.2, (float) 1.3, (float) 1.4 },
        unbox.it(new Float[] { box.it((float) 1.1), box.it((float) 1.2), box.it((float) 1.3), box.it((float) 1.4) }), (float) 0.001);
  }

  @Test public void testUnboxIntegerArray() {
    azzert.that(unbox.it(new Integer[] { box.it(1), box.it(2), box.it(3), box.it(4) }), is(new int[] { 1, 2, 3, 4 }));
    azzert.that(unbox.it(new Character('a')), is('a'));
  }

  @Test public void testUnboxLongArray() {
    azzert.that(unbox.it(new Long[] { box.it(1L * 1), box.it(1L * 2), box.it(1L * 3), box.it(1L * 4) }), is(new long[] { 1, 2, 3, 4 }));
  }
}
