package fluent.ly;

import org.junit.*;
import static fluent.ly.azzert.*;
@SuppressWarnings("static-method") 
public class unboxTest {
  @Test public void testUnboxBooleanArray() {
    azzert.that(unbox.unbox(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }), is(new boolean[] { false, true, true, false }));
  }

  @Test public void testUnboxByteArray() {
    azzert.that(unbox.unbox(new Byte[] { box.box((byte)0), box.box((byte)1), box.box((byte)2), box.box((byte)3) }), is(new byte[] { 0, 1, 2, 3 }));
  }

  @Test public void testUnboxCharacterArray() {
    azzert.that(unbox.unbox(new Character[] { box.box('a'), box.box('b'), box.box('c'), box.box('d') }), is(new char[] { 'a', 'b', 'c', 'd' }));
  }

  @Test public void testUnboxShortArray() {
    azzert.that(unbox.unbox(new Short[] { box.box((short)1), box.box((short)2), box.box((short)3), box.box((short)4) }), is(new short[] { 1, 2, 3, 4 }));
  }

  @SuppressWarnings("static-access") @Test public void testUnboxDoubleArray() {
    azzert.assertArrayEquals(new double[] { 1.1, 1.2, 1.3, 1.4 }, unbox.unbox(new Double[] { box.box(1.1), box.box(1.2), box.box(1.3), box.box(1.4) }), 0.001);
  }

  @SuppressWarnings("static-access") @Test public void testUnboxFloatArray() {
    azzert.assertArrayEquals(new float[] { (float) 1.1, (float) 1.2, (float) 1.3, (float) 1.4 }, unbox.unbox(new Float[] { box.box((float) 1.1), box.box((float) 1.2), box.box((float) 1.3), box.box((float) 1.4) }), (float) 0.001);
  }

  @Test public void testUnboxIntegerArray() {
    azzert.that(unbox.unbox(new Integer[] { box.box(1), box.box(2), box.box(3), box.box(4) }), is(new int[] { 1, 2, 3, 4 }));
  }

  @Test public void testUnboxLongArray() {
    azzert.that(unbox.unbox(new Long[] { box.box(1L * 1), box.box(1L * 2), box.box(1L * 3), box.box(1L * 4) }), is(new long[] { 1, 2, 3, 4 }));
  }
}
