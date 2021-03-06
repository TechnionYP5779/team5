package parkingLot;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

/** @author Lior Ben-Yamin and Nir Chachamovitz
 * @since 2018-11-27 */
@SuppressWarnings("static-method") public class TransactionTest {
  @Test public void TestMadeBefore() {
    final Calendar calendar1 = new GregorianCalendar(2018, 1, 31);
    final Calendar calendar2 = new GregorianCalendar(2018, 2, 31);
    final Transaction t1 = new Transaction(calendar1, new Slot(calendar1, calendar1, 100.0), 1, 1, 1);
    final Transaction t2 = new Transaction(calendar2, new Slot(calendar2, calendar2, 100.0), 1, 1, 1);
    assert t1.madeBefore(t2);
    assert !t2.madeBefore(t1);
  }

  @Test public void TestStartedBefore() {
    final Calendar calendar1 = new GregorianCalendar(2018, 1, 31);
    final Calendar calendar2 = new GregorianCalendar(2018, 2, 31);
    final Transaction t1 = new Transaction(calendar1, new Slot(calendar1, calendar1, 100.0), 1, 1, 1);
    final Transaction t2 = new Transaction(calendar2, new Slot(calendar2, calendar2, 100.0), 1, 1, 1);
    assert t1.startedBefore(t2);
    assert !t2.startedBefore(t1);
  }

  @Test public void TestEndedBefore() {
    final Calendar calendar1 = new GregorianCalendar(2018, 1, 31);
    final Calendar calendar2 = new GregorianCalendar(2018, 2, 31);
    final Transaction t1 = new Transaction(calendar1, new Slot(calendar1, calendar1, 100.0), 1, 1, 1);
    final Transaction t2 = new Transaction(calendar2, new Slot(calendar2, calendar2, 100.0), 1, 1, 1);
    assert t1.endedBefore(t2);
    assert !t2.endedBefore(t1);
  }

  @Test public void rentDuration() {
    final Calendar calendar1 = new GregorianCalendar(2018, 1, 31, 5, 0);
    final Calendar calendar2 = new GregorianCalendar(2018, 1, 31, 8, 0);
    final Transaction t1 = new Transaction(calendar1, new Slot(calendar1, calendar2, 100.0), 1, 1, 1);
    azzert.that(t1.rentDuration(), is(3));
  }

  @Test public void gettersTest() {
    final Calendar calendar1 = new GregorianCalendar(2018, 1, 31, 5, 0);
    final Calendar calendar2 = new GregorianCalendar(2018, 1, 31, 8, 0);
    final Calendar calendar3 = new GregorianCalendar(2018, 1, 31, 11, 0);
    final Transaction t1 = new Transaction(calendar1, new Slot(calendar2, calendar3, 100.0), 1, 2, 3);
    azzert.that(t1.getLandlordId(), is(3));
    azzert.that(t1.getParkingId(), is(1));
    azzert.that(t1.getId(), is(Transaction.getCountAlreadyMadeTransactions()));
    azzert.that(t1.getPrice(), is(300.0));
    azzert.that(t1.getTenantId(), is(2));
    azzert.that(t1.getTransactionCalendar(), is(calendar1));
    azzert.that(t1.getRentStart(), is(calendar2));
    azzert.that(t1.getRentEnd(), is(calendar3));
  }

  @Test public void rentTimeTest() {
    final Calendar calendar1 = new GregorianCalendar(2018, 1, 31, 5, 0);
    final Calendar calendar2 = new GregorianCalendar(2018, 1, 31, 8, 0);
    final Calendar calendar3 = new GregorianCalendar(2018, 1, 31, 11, 0);
    final Transaction t1 = new Transaction(calendar1, new Slot(calendar1, calendar1, 100.0), 1, 2, 3);
    t1.setRentStart(calendar2);
    t1.setRentEnd(calendar3);
    final Slot s = t1.getRentTime();
    azzert.that((int) ((s.to.getTime().getTime() - s.from.getTime().getTime()) / 3600000), is(3));
  }
}
