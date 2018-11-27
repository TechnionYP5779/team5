/**add here documentation for file 
 * @author Fname Sname
 * @since year-month-day */
package parkingLot;

import java.util.*;

import org.junit.*;

/**
 * @author Lior Ben-Yamin and Nir Chachamovitz
 * @since 2018-11-27
 *
 */
@SuppressWarnings("static-method") 
public class TransactionTest {
  @Test public void TestMadeBefore() {
    Calendar calendar1 = new GregorianCalendar(2018,1,31);
    Calendar calendar2 = new GregorianCalendar(2018,2,31);
    Transaction t1 = new Transaction(200, calendar1,
        calendar1, calendar1, 1, 1, 1);
    Transaction t2 = new Transaction(200, calendar2,
        calendar2, calendar2, 1, 1, 1);
    assert t1.madeBefore(t2);
  }
}
