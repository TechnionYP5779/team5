/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.tables;

import org.junit.*;

import fluent.ly.*;

/** @author Nir Chachamovitz
 * @since 2018-11-20 */
@SuppressWarnings({ "static-method", "static-access" }) public class TableRendererTest {
  @Test public void TEX2test() {
    azzert.that(TableRenderer.builtin.TEX2.afterHeader(), azzert.is("\\hline" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX2.afterTable(), azzert.is("\\hline" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX2.arraySeparator(), azzert.is(", "));
    azzert.that(TableRenderer.builtin.TEX2.beforeFooter(), azzert.is("\\hline" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX2.beforeTable(), azzert.is("\\hline" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX2.footerEnd(), azzert.is("\\\\" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX2.recordSeparator(), azzert.is("\t&\t"));
  }

  @Test public void TXTtest() {
    azzert.that(TableRenderer.builtin.TEX.afterHeader(), azzert.is("\\midrule" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX.afterTable(), azzert.is("\\bottomrule" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX.arraySeparator(), azzert.is(", "));
    azzert.that(TableRenderer.builtin.TEX.beforeFooter(), azzert.is("\\midrule" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX.beforeTable(), azzert.is("\\toprule" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.TEX.nil(), azzert.is("$\\#$"));
    azzert.that(TableRenderer.builtin.TEX.recordSeparator(), azzert.is("\t&\t"));
  }

  @Test public void CSVtest() {
    azzert.that(TableRenderer.builtin.CSV.footerEnd(), azzert.is(TableRenderer.builtin.NL + ""));
    azzert.that(TableRenderer.builtin.CSV.recordSeparator(), azzert.is(","));
  }

  @Test public void MARKDOWNtest() {
    // azzert.that(TableRenderer.builtin.MARKDOWN.afterHeader(), azzert.is("| " +
    // TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.MARKDOWN.afterTable(), azzert.is(TableRenderer.builtin.NL));
    // azzert.that(TableRenderer.builtin.MARKDOWN.arraySeparator(), azzert.is(";
    // "));
    azzert.that(TableRenderer.builtin.MARKDOWN.beforeTable(), azzert.is(TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.MARKDOWN.recordBegin(), azzert.is("|"));
    azzert.that(TableRenderer.builtin.MARKDOWN.recordEnd(), azzert.is(" |" + TableRenderer.builtin.NL));
    azzert.that(TableRenderer.builtin.MARKDOWN.recordSeparator(), azzert.is(" | "));
    TableRenderer.builtin.MARKDOWN.setHeaderCount(1);
    azzert.that(TableRenderer.builtin.MARKDOWN.cellReal(box.it(4.3)), azzert.is("4"));
    azzert.that(TableRenderer.builtin.MARKDOWN.cellReal(box.it(Double.NaN)), azzert.is("NaN"));
    azzert.that(TableRenderer.empty(), azzert.is(""));
    azzert.that(TableRenderer.tab(), azzert.is("\t"));
    azzert.that(TableRenderer.builtin.MARKDOWN.afterFooter(), azzert.is(""));
    azzert.that(TableRenderer.builtin.CSV.afterHeader(), azzert.is(""));
    azzert.that(TableRenderer.builtin.CSV.afterTable(), azzert.is(""));
    azzert.that(TableRenderer.builtin.CSV.beforeFooter(), azzert.is(""));
    azzert.that(TableRenderer.builtin.CSV.beforeHeader(), azzert.is(""));
    azzert.that(TableRenderer.builtin.CSV.beforeTable(), azzert.is(""));
    azzert.that(TableRenderer.builtin.CSV.cellInt(box.it(1L * 4)), azzert.is("4"));
    azzert.that(TableRenderer.builtin.CSV.extension(), azzert.is("csv"));
    azzert.that(TableRenderer.builtin.CSV.footerBegin(), azzert.is(""));
    azzert.that(TableRenderer.builtin.TXT.footerEnd(), azzert.is(TableRenderer.builtin.NL + ""));
    azzert.that(TableRenderer.builtin.CSV.footerSeparator(), azzert.is(","));
    azzert.that(TableRenderer.builtin.CSV.headerLineBegin(), azzert.is(""));
    azzert.that(TableRenderer.builtin.CSV.headerLineEnd(), azzert.is(TableRenderer.builtin.NL + ""));
    azzert.that(TableRenderer.builtin.CSV.headerSeparator(), azzert.is(","));
    azzert.that(TableRenderer.builtin.CSV.nil(), azzert.is("Nº"));
    azzert.that(TableRenderer.builtin.TXT.recordSeparator(), azzert.is("\t"));
    azzert.that(TableRenderer.builtin.CSV.stringField("Hello World"), azzert.is("Hello World"));
  }
}
