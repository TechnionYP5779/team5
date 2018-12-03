/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package parkingLot;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

/** @author ShalevKuba, Shaked Sapir */
// deprecation because usage of class GregorianCalendar.
@SuppressWarnings("static-method") public class SlotTest {
  @Test public void test1() {
    final Slot s = new Slot(new GregorianCalendar(2018, 11, 27, 19, 00), new GregorianCalendar(2018, 11, 27, 20, 00), 5.2);
    azzert.that(s.getPrice_for_hour(), is(5.2));
    azzert.that(s.getFrom(), is(new GregorianCalendar(2018, 11, 27, 19, 00)));
    azzert.that(s.getTo(), is(new GregorianCalendar(2018, 11, 27, 20, 00)));
    final Slot s2 = new Slot(s);
    azzert.that(s2.getPrice_for_hour(), is(5.2));
    azzert.that(s2.getFrom(), is(new GregorianCalendar(2018, 11, 27, 19, 00)));
    azzert.that(s2.getTo(), is(new GregorianCalendar(2018, 11, 27, 20, 00)));
  }
}
