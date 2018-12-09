/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

/**
 * @author Nir Chachamovitz
 * @since 2018-11-20
 */
@SuppressWarnings("static-method")
public class ImmutableStatisticsTest {
	@Test
	public void flippingTest() {
		azzert.that(new ImmutableStatistics() {
			static final long serialVersionUID = 1;
		}.flipping(), is(Double.NaN));
	}

	@Test
	public void madTest() {
		new ImmutableStatistics() {
			static final long serialVersionUID = 1;
		}.all();
	}

	// @Test public void formatTest() {
	// new ImmutableStatistics() {
	// static final long serialVersionUID = 1;
	// }.mad();
	// }
	@Test
	public void unitTest() {
		isNull(new ImmutableStatistics() {
			static final long serialVersionUID = 1;
		}.unit());
	}
}
