package il.org.spartan.statistics;

import static org.junit.Assert.*;

import org.junit.*;

public class StatisticsTest {
  @SuppressWarnings("deprecation") @Test public void testSampleMean() {
    double b = 2;
    double a[] = { 1, 2, 3 };
    double c = Statistics.sampleMean(a);
    assertEquals(b, c, 0);
  }

  @Test public void testSampleVariance() {
    double a[] = { 1, 2, 3 };
    assertEquals(1, Statistics.sampleVariance(a), 0);
  }

  @Test public void testMad() {
    double a[] = { 4, 8, 12.5 };
    assertEquals(4, Statistics.mad(a), 0);
  }

  @Test public void testIsEmpty() {
    Statistics s = new Statistics() {
    };
    assertEquals(true, s.isEmpty());
    s.n = 1;
    assertEquals(false, s.isEmpty());
  }

  @Test public void testMax() {
    Statistics s = new Statistics() {
    };
    s.n = 1;
    s.moments[0] = 10;
    s.max = 10;
    assertEquals(10, s.max(), 0);
  }

  @Test public void testMin() {
    Statistics s = new Statistics() {
    };
    s.n = 1;
    s.moments[0] = 10;
    s.min = 10;
    assertEquals(10, s.min(), 0);
  }

  @Test public void testMean() {
    Statistics s = new Statistics() {
    };
    s.n = 2;
    s.moments[1] = 10;
    assertEquals(5, s.mean(), 0);
  }

  @Test public void testMissing() {
    Statistics s = new Statistics() {
    };
    s.missing = 0;
    assertEquals(0, s.missing(), 0);
  }

  @Test public void testSum2() {
    Statistics s = new Statistics() {
    };
    s.n = 2;
    s.moments[2] = 1;
    assertEquals(1, s.sum2(), 0);
  }

  @Test public void testSd() {
    Statistics s = new Statistics() {
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 1;
    assertEquals(0.5, s.sd(), 0);
  }

  @Test public void testRelativeError() {
    Statistics s = new Statistics() {
    };
    s.n = 1;
    s.moments[1] = 0;
    assertEquals(0, s.relativeError(), 0);
  }

  @Test public void testRelativeError2() {
    Statistics s = new Statistics() {
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 1;
    assertEquals(1, s.relativeError(), 0);
  }

  @Test public void testV() {
    Statistics s = new Statistics() {
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 2;
    assertEquals(1.5, s.v(), 0);
  }

  @Test public void testVariance() {
    Statistics s = new Statistics() {
    };
    s.n = 2;
    s.moments[1] = 1;
    s.moments[2] = 2;
    assertEquals(0.75, s.variance(), 0);
  }

  @Test public void testCheckEmpty() {
    Statistics s = new Statistics() {
    };
    s.n = 0;
    try {
      s.checkEmpty();
    } catch (Exception E) {
      ;
    }
  }
}
