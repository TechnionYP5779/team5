package il.org.spartan.statistics;

import org.junit.*;

import fluent.ly.*;

public class StatisticsTest {
  @Test @SuppressWarnings("static-method") public void testSampleMean() {
    Assert.assertEquals(2, Statistics.sampleMean(new double[] { 1, 2, 3 }), 0);
  }

  @Test @SuppressWarnings("static-method") public void testSampleVariance() {
    Assert.assertEquals(1, Statistics.sampleVariance(new double[] { 1, 2, 3 }), 0);
  }

  @Test @SuppressWarnings("static-method") public void testMad() {
    Assert.assertEquals(4, Statistics.mad(new double[] { 4, 8, 12.5 }), 0);
  }

  @Test @SuppressWarnings("static-method") public void testIsEmpty() {
    final Statistics s = new Statistics() {
      // empty block
    };
    azzert.assertEquals(true, s.isEmpty());
    s.n = 1;
    azzert.assertEquals(false, s.isEmpty());
  }

  @Test @SuppressWarnings("static-method") public void testMax() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 1;
    s.max = s.moments[0] = 10;
    Assert.assertEquals(10, s.max(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testMin() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 1;
    s.min = s.moments[0] = 10;
    Assert.assertEquals(10, s.min(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testMean() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 2;
    s.moments[1] = 10;
    Assert.assertEquals(5, s.mean(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testMissing() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.missing = 0;
    Assert.assertEquals(0, s.missing(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testSum2() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 2;
    s.moments[2] = 1;
    Assert.assertEquals(1, s.sum2(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testSd() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 2;
    s.moments[2] = s.moments[1] = 1;
    Assert.assertEquals(0.5, s.sd(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testRelativeError() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 1;
    s.moments[1] = 0;
    Assert.assertEquals(0, s.relativeError(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testRelativeError2() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 2;
    s.moments[2] = s.moments[1] = 1;
    Assert.assertEquals(1, s.relativeError(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testV() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 2;
    Assert.assertEquals(1.5, s.v(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testVariance() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 2;
    Assert.assertEquals(0.75, s.variance(), 0);
  }

  @Test @SuppressWarnings("static-method") public void testCheckEmpty() {
    final Statistics s = new Statistics() {
      // empty block
    };
    s.n = 0;
    try {
      s.checkEmpty();
    } catch (@SuppressWarnings("unused") final Exception E) {
      // empty block
    }
  }
}
