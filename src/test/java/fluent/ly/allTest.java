/** add here documentation for file
 * @author Shalev Kuba
 * @since 2018-11-19 */
package fluent.ly;

import java.util.*;

import org.junit.*;

/** @author ShalevKuba */
@SuppressWarnings("static-method")
public class allTest {
	@Test
	public void NotNulltest() {
		final LinkedList<Integer> l = new LinkedList<>();
		l.add(box.it(1));
		l.add(box.it(2));
		assert all.notNull(l);
		l.add(null);
		assert !all.notNull(l);
	}

	@Test
	public void ArrayNotNulltest() {
		final Integer[] a = new Integer[3];
		a[0] = box.it(1);
		a[1] = box.it(1);
		a[2] = box.it(1);
		assert all.notNull(a);
		a[2] = null;
		assert !all.notNull(a);
	}
}
