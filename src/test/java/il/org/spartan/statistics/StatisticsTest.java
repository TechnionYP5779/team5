package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
public class StatisticsTest {
	@Test
	public void testSampleMean() {
		azzert.that(2, is(Statistics.sampleMean(new double[] { 1, 2, 3 })));
	}

	@Test
	public void testSampleVariance() {
		azzert.that(1, is(Statistics.sampleVariance(new double[] { 1, 2, 3 })));
	}

	@Test
	public void testMad() {
		azzert.that(4, is(Statistics.mad(new double[] { 4, 8, 12.5 })));
	}

	@Test
	public void testIsEmpty() {
		final Statistics s = new Statistics() {
			// empty block
		};
		assert s.isEmpty();
		s.n = 1;
		assert !s.isEmpty();
	}

	@Test
	public void testMax() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 1;
		s.max = s.moments[0] = 10;
		azzert.that(10, is(s.max()));
	}

	@Test
	public void testMin() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 1;
		s.min = s.moments[0] = 10;
		azzert.that(10, is(s.min()));
	}

	@Test
	public void testMean() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 2;
		s.moments[1] = 10;
		azzert.that(5, is(s.mean()));
	}

	@Test
	public void testMissing() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.missing = 0;
		azzert.that(0, is(s.missing()));
	}

	@Test
	public void testSum2() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 2;
		s.moments[2] = 1;
		azzert.that(1, is(s.sum2()));
	}

	@Test
	public void testSd() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 2;
		s.moments[2] = s.moments[1] = 1;
		azzert.that(0.5, is(s.sd()));
	}

	@Test
	public void testRelativeError() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 1;
		s.moments[1] = 0;
		azzert.that(0, is(s.relativeError()));
	}

	@Test
	public void testRelativeError2() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 2;
		s.moments[2] = s.moments[1] = 1;
		azzert.that(1, is(s.relativeError()));
	}

	@Test
	public void testV() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 2;
		s.moments[1] = 1;
		s.moments[2] = 2;
		azzert.that(1.5, is(s.v()));
	}

	@Test
	public void testVariance() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 2;
		s.moments[1] = 1;
		s.moments[2] = 2;
		azzert.that(0.75, is(s.variance()));
	}

	@Test
	public void testCheckEmpty() {
		final Statistics s = new Statistics() {
			// empty block
		};
		s.n = 0;
		try {
			s.checkEmpty();
		} catch (final Exception E) {
			// empty block
		}
	}
}
