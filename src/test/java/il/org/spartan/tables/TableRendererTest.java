/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.tables;

import org.junit.*;
import static fluent.ly.azzert.is;
import fluent.ly.*;

/** @author Nir Chachamovitz
 * @since 2018-11-20 */
@SuppressWarnings("static-method") public class TableRendererTest {
  @Test public void TEX2test() {
    azzert.that(TableRenderer.builtin.TEX2.afterHeader(), is("\\hline" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX2.afterTable(), is("\\hline" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX2.arraySeparator(), is(", "));
    azzert.that(TableRenderer.builtin.TEX2.beforeFooter(), is("\\hline" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX2.beforeTable(), is("\\hline" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX2.footerEnd(), is("\\\\" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX2.recordSeparator(), is("\t&\t"));
  }

  @Test public void TXTtest() {
    azzert.that(TableRenderer.builtin.TEX.afterHeader(), is("\\midrule" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX.afterTable(), is("\\bottomrule" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX.arraySeparator(), is(", "));
    azzert.that(TableRenderer.builtin.TEX.beforeFooter(), is("\\midrule" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX.beforeTable(), is("\\toprule" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.TEX.nil(), is("$\\#$"));
    azzert.that(TableRenderer.builtin.TEX.recordSeparator(), is("\t&\t"));
  }

  @Test public void CSVtest() {
    azzert.that(TableRenderer.builtin.CSV.footerEnd(), is(TableRenderer.NL + ""));
    azzert.that(TableRenderer.builtin.CSV.recordSeparator(), is(","));
  }

  @Test public void MARKDOWNtest() {
    // azzert.that(TableRenderer.builtin.MARKDOWN.afterHeader(), is("| " +
    // TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.MARKDOWN.afterTable(), is(TableRenderer.NL));
    // azzert.that(TableRenderer.builtin.MARKDOWN.arraySeparator(), is(";
    // "));
    azzert.that(TableRenderer.builtin.MARKDOWN.beforeTable(), is(TableRenderer.NL));
    azzert.that(TableRenderer.builtin.MARKDOWN.recordBegin(), is("|"));
    azzert.that(TableRenderer.builtin.MARKDOWN.recordEnd(), is(" |" + TableRenderer.NL));
    azzert.that(TableRenderer.builtin.MARKDOWN.recordSeparator(), is(" | "));
    TableRenderer.builtin.MARKDOWN.setHeaderCount(1);
    azzert.that(TableRenderer.builtin.MARKDOWN.cellReal(box.it(4.3)), is("4"));
    azzert.that(TableRenderer.builtin.MARKDOWN.cellReal(box.it(Double.NaN)), is("NaN"));
    azzert.that(TableRenderer.empty(), is(""));
    azzert.that(TableRenderer.tab(), is("\t"));
    azzert.that(TableRenderer.builtin.MARKDOWN.afterFooter(), is(""));
    azzert.that(TableRenderer.builtin.CSV.afterHeader(), is(""));
    azzert.that(TableRenderer.builtin.CSV.afterTable(), is(""));
    azzert.that(TableRenderer.builtin.CSV.beforeFooter(), is(""));
    azzert.that(TableRenderer.builtin.CSV.beforeHeader(), is(""));
    azzert.that(TableRenderer.builtin.CSV.beforeTable(), is(""));
    azzert.that(TableRenderer.builtin.CSV.cellInt(box.it(1L * 4)), is("4"));
    azzert.that(TableRenderer.builtin.CSV.extension(), is("csv"));
    azzert.that(TableRenderer.builtin.CSV.footerBegin(), is(""));
    azzert.that(TableRenderer.builtin.TXT.footerEnd(), is(TableRenderer.NL + ""));
    azzert.that(TableRenderer.builtin.CSV.footerSeparator(), is(","));
    azzert.that(TableRenderer.builtin.CSV.headerLineBegin(), is(""));
    azzert.that(TableRenderer.builtin.CSV.headerLineEnd(), is(TableRenderer.NL + ""));
    azzert.that(TableRenderer.builtin.CSV.headerSeparator(), is(","));
    azzert.that(TableRenderer.builtin.CSV.nil(), is("Nº"));
    azzert.that(TableRenderer.builtin.TXT.recordSeparator(), is("\t"));
    azzert.that(TableRenderer.builtin.CSV.stringField("Hello World"), is("Hello World"));
  }
}
