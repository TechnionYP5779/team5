/** add here documentation for file
 * @author Shalev Kuba
 * @since 2018-11-19 */
package fluent.ly;

import java.util.*;

import org.junit.*;

/** @author ShalevKuba */
@SuppressWarnings("static-method") public class allTest {
  @Test public void NotNulltest() {
    final LinkedList<Integer> l = new LinkedList<>();
    l.add(box.it(1));
    l.add(box.it(2));
    azzert.that(all.notNull(l), azzert.is(true));
    l.add(null);
    azzert.that(all.notNull(l), azzert.is(false));
  }

  @SuppressWarnings("null") @Test public void ArrayNotNulltest() {
    final Integer[] a = new Integer[3];
    a[0] = box.it(1);
    a[1] = box.it(1);
    a[2] = box.it(1);
    azzert.that(all.notNull(a), azzert.is(true));
    a[2] = null;
    azzert.that(all.notNull(a), azzert.is(false));
  }
}
