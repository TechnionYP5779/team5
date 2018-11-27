/**add here documentation for file 
 * @author Fname Sname
 * @since year-month-day */
package parkingLot;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

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
    Transaction t1 = new Transaction(200.0, calendar1.getTime(),
        calendar1.getTime(), calendar1.getTime(), 1, 1, 1);
    Transaction t2 = new Transaction(200.0, calendar2.getTime(),
        calendar2.getTime(), calendar2.getTime(), 1, 1, 1);
    assert t1.madeBefore(t2);
    assert !t2.madeBefore(t1);
  }
  
  @Test public void TestStartedBefore() {
    Calendar calendar1 = new GregorianCalendar(2018,1,31);
    Calendar calendar2 = new GregorianCalendar(2018,2,31);
    Transaction t1 = new Transaction(200.0, calendar1.getTime(),
        calendar1.getTime(), calendar1.getTime(), 1, 1, 1);
    Transaction t2 = new Transaction(200.0, calendar2.getTime(),
        calendar2.getTime(), calendar2.getTime(), 1, 1, 1);
    assert t1.startedBefore(t2);
    assert !t2.startedBefore(t1);
  }
  
  @Test public void TestEndedBefore() {
    Calendar calendar1 = new GregorianCalendar(2018,1,31);
    Calendar calendar2 = new GregorianCalendar(2018,2,31);
    Transaction t1 = new Transaction(200.0, calendar1.getTime(),
        calendar1.getTime(), calendar1.getTime(), 1, 1, 1);
    Transaction t2 = new Transaction(200.0, calendar2.getTime(),
        calendar2.getTime(), calendar2.getTime(), 1, 1, 1);
    assert t1.endedBefore(t2);
    assert !t2.endedBefore(t1);
  }
  
  @Test public void rentDuration() {
    Calendar calendar1 = new GregorianCalendar(2018,1,31,5,0);
    Calendar calendar2 = new GregorianCalendar(2018,1,31,8,0);
    Transaction t1 = new Transaction(200.0, calendar1.getTime(),
        calendar1.getTime(), calendar2.getTime(), 1, 1, 1);
    azzert.that(t1.rentDuration(), azzert.is(3));
  }
  
  @Test public void gettersTest() {
    Calendar calendar1 = new GregorianCalendar(2018,1,31,5,0);
    Calendar calendar2 = new GregorianCalendar(2018,1,31,8,0);
    Calendar calendar3 = new GregorianCalendar(2018,1,31,11,0);
    Transaction t1 = new Transaction(200.0, calendar1.getTime(),
        calendar2.getTime(), calendar3.getTime(), 1, 2, 3);
    azzert.that(t1.getId(), azzert.is(Transaction.getCountAlreadyMadeTransactions()));
    azzert.that(t1.getLandlordId(), azzert.is(3));
    azzert.that(t1.getParkingId(), azzert.is(1));
    azzert.that(t1.getPrice(), azzert.is(200.0));
    azzert.that(t1.getTenantId(), azzert.is(2));
    azzert.that(t1.getTransactionDate(), azzert.is(calendar1.getTime()));
    azzert.that(t1.getRentStart(), azzert.is(calendar2.getTime()));
    azzert.that(t1.getRentEnd(), azzert.is(calendar3.getTime()));
  }
}
