/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

/** @author Lior */
@SuppressWarnings("static-method")
public class defaultsTest {
	@Test
	public void test1() {
		azzert.that(defaults.to(box.it(5), 6), is(5));
		azzert.that(defaults.to(null, 6), is(6));
	}

	@Test
	public void test2() {
		azzert.that(defaults.to(box.it(5), box.it(6)), is(5));
		azzert.that(defaults.to(null, box.it(6)), is(6));
	}

	@Test
	public void test3() {
		azzert.that(defaults.to(box.it(5.6), box.it(6.2)), is(5.6));
		azzert.that(defaults.to(null, box.it(6.2)), is(6.2));
	}
}
