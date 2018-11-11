package il.org.spartan.statistics;

import static org.junit.Assert.*;

import org.junit.*;

public class StatisticsTest {
  @SuppressWarnings("static-method") @Test public void testSampleMean() {
    final double b = 2;
    final double a[] = { 1, 2, 3 };
    final double c = Statistics.sampleMean(a);
    assertEquals(b, c, 0);
  }

  @SuppressWarnings("static-method") @Test public void testSampleVariance() {
    final double a[] = { 1, 2, 3 };
    assertEquals(1, Statistics.sampleVariance(a), 0);
  }

  @SuppressWarnings("static-method") @Test public void testMad() {
    final double a[] = { 4, 8, 12.5 };
    assertEquals(4, Statistics.mad(a), 0);
  }

  @SuppressWarnings({ "static-method", "boxing" }) @Test public void testIsEmpty() {
    final Statistics s = new Statistics() {
      //empty block
    };
    assertEquals(true, s.isEmpty());
    s.n = 1;
    assertEquals(false, s.isEmpty());
  }

  @SuppressWarnings("static-method") @Test public void testMax() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 1;
    s.moments[0] = 10;
    s.max = 10;
    assertEquals(10, s.max(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testMin() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 1;
    s.moments[0] = 10;
    s.min = 10;
    assertEquals(10, s.min(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testMean() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 2;
    s.moments[1] = 10;
    assertEquals(5, s.mean(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testMissing() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.missing = 0;
    assertEquals(0, s.missing(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testSum2() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 2;
    s.moments[2] = 1;
    assertEquals(1, s.sum2(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testSd() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 1;
    assertEquals(0.5, s.sd(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testRelativeError() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 1;
    s.moments[1] = 0;
    assertEquals(0, s.relativeError(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testRelativeError2() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 1;
    assertEquals(1, s.relativeError(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testV() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 2;
    assertEquals(1.5, s.v(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testVariance() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 2;
    assertEquals(0.75, s.variance(), 0);
  }

  @SuppressWarnings("static-method") @Test public void testCheckEmpty() {
    final Statistics s = new Statistics() {
    //empty block
    };
    s.n = 0;
    try {
      s.checkEmpty();
    } catch (@SuppressWarnings("unused") final Exception E) {
    //empty block
    }
  }
}
