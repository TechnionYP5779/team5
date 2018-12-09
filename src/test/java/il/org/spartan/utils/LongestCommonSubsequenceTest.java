/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

/** @author Igor Bashmashnikov */
@SuppressWarnings("static-method")
public class LongestCommonSubsequenceTest {
	@Test
	public void testSimilarity() {
		final String str1 = "abcdefg";
		final String str2 = "bcde";
		final LongestCommonSubsequence lcs = new LongestCommonSubsequence(str1, str2);
		azzert.that(lcs.similarity(), is(0.7272727272727273));
	}
}
