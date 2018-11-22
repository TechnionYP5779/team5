// the documentation below was created by code-template for documentation
// which Shaked created as part of issue #118, its seems to work!
/** add here documentation for file
 * @author Shalev Kuba
 * @since 2018-11-19 */
package il.org.spartan.tables;

import static org.junit.Assert.fail;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class TableTest {
  @Test public void classToNormalizedFileName() {
    azzert.that(Table.classToNormalizedFileName("Integer_Shalev_Shaked"), is("shalev-shaked"));
    azzert.that(Table.classToNormalizedFileName(___Test.class), is("--test"));
  }

  @SuppressWarnings("resource") @Test public void test1() {
    final Integer in = box.it(5);
    final Table table = new Table(in);
    azzert.that(table.baseName(), is(system.tmp + ".*"));
    table.col("ints", 5);
    table.col("longs", 1L * 6);
    table.col("doubles", 6.5);
    String $ = "Table named  produced in 5 formats (versions) in " + table.baseName() + "\n"
        + "The table has 1 data rows, each consisting of 4 columns.\nTable header is  [null, ints, longs, doubles]\n"
        + "The table consists of 3 numerical columns: [ints, longs, doubles]\n";
    final Int n = new Int();
    final List<RecordWriter> writers2 = an.empty.list();
    as.list(TableRenderer.builtin.values()).forEach(r -> {
      try {
        writers2.add(new RecordWriter(r, system.tmp));
      } catch (@SuppressWarnings("unused") final IOException ¢) {
        fail("Runtime Error");
      }
    });
    $ += writers2.stream().map(λ -> "\t " + ++n.inner + ". " + λ.fileName + "\n").reduce((x, y) -> x + y).get();
    azzert.that(table.description(), is($));
    table.nl();
  }

  @SuppressWarnings("resource") @Test public void test2() {
    Table table = new Table(Integer.class, ".");
    table = new Table(Integer.class, "././././");
    table.noStatistics().add(Statistic.max).add(Statistic.min);
    table.col("ints", 5);
    table.col("null", 5);
    table.col("longs", 1L * 6);
    table.col("doubles", 6.5);
    table.col("doubles", 100.5);
    table.noStatistics().add(Statistic.max).add(Statistic.min).add(Statistic.median).add(Statistic.mean).remove(Statistic.median, Statistic.max,
        Statistic.min, Statistic.mean);
  }
}
