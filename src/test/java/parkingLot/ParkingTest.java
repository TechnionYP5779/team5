/** add here documentation for file
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
package parkingLot;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import parkingLot.Parking.*;

@SuppressWarnings("static-method") public class ParkingTest {
  @Test public void setsAndGets() {
    final Parking p = new Parking(3, 1, size.PRIVATE_CAR, "Israel, Holon, Hahartsit, 8");
    azzert.that(p.getId(), is(3));
    azzert.that(p.getOwner(), is(1));
    azzert.that(p.getSize(), is(size.PRIVATE_CAR));
    azzert.that(p.getLocation(), is("Israel, Holon, Hahartsit, 8"));
    azzert.that(p.getAvailableSlots().size(), is(0));
  }

  @Test public void availableSlotTest() {
    final Parking p = new Parking(3, 1, size.PRIVATE_CAR, "Israel, Holon, Hahartsit, 8");
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 19, 00), new GregorianCalendar(2018, 11, 27, 18, 00), 5.5);
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 12, 00), new GregorianCalendar(2018, 11, 27, 12, 00), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(0));
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(1));
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 30), new GregorianCalendar(2018, 11, 27, 9, 30), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(1));
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 7, 30), new GregorianCalendar(2018, 11, 27, 8, 30), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(1));
    azzert.that(p.getAvailableSlots().get(0),
        is(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00), 5.5)));
    azzert.that(p.getAvailableSlots().get(0).getPrice_for_hour(), is(5.5));
    p.removeAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 28, 9, 00));
    azzert.that(p.getAvailableSlots().size(), is(1));
    p.removeAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00));
    azzert.that(p.getAvailableSlots().size(), is(0));
    p.addAvailableSlot(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00), 5.5));
    azzert.that(p.getAvailableSlots().size(), is(1));
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 30), new GregorianCalendar(2018, 11, 27, 9, 30), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(1));
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 7, 30), new GregorianCalendar(2018, 11, 27, 8, 30), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(1));
    p.removeAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00));
    azzert.that(p.getAvailableSlots().size(), is(0));
    p.addAvailableSlot(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00), 5.5));
    azzert.that(p.getAvailableSlots().size(), is(1));
    p.removeAvailableSlot(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00), 5.5));
    azzert.that(p.getAvailableSlots().size(), is(0));
  }

  @Test public void getSlot() {
    final Parking p = new Parking(3, 1, size.PRIVATE_CAR, "Israel, Holon, Hahartsit, 8");
    azzert.that(p.getSlot(new GregorianCalendar(2018, 11, 27, 12, 00), new GregorianCalendar(2018, 11, 27, 14, 00)).getPrice_for_hour(),
        is((double) -1));
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 20, 00), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(1));
    azzert.that(p.getSlot(new GregorianCalendar(2018, 11, 27, 12, 00), new GregorianCalendar(2018, 11, 27, 14, 00)),
        is(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 20, 00), 5.5)));
    azzert.that(p.getSlot(new Slot(new GregorianCalendar(2018, 11, 27, 12, 00), new GregorianCalendar(2018, 11, 27, 14, 00), 5.5)),
        is(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 20, 00), 5.5)));
    azzert.that(p.getAvailableSlots().size(), is(1));
    azzert.that(p.OrderSlot(new GregorianCalendar(2018, 11, 28, 12, 00), new GregorianCalendar(2018, 11, 28, 14, 00)).getPrice_for_hour(),
        is((double) -1));
    azzert.that(p.OrderSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 21, 00)).getPrice_for_hour(),
        is((double) -1));
    azzert.that(p.OrderSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 20, 00)),
        is(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 20, 00), 5.5)));
    azzert.that(p.getAvailableSlots().size(), is(0));
    p.addAvailableSlot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 20, 00), 5.5);
    azzert.that(p.getAvailableSlots().size(), is(1));
    azzert.that(p.OrderSlot(new GregorianCalendar(2018, 11, 27, 12, 00), new GregorianCalendar(2018, 11, 27, 14, 00)),
        is(new Slot(new GregorianCalendar(2018, 11, 27, 12, 00), new GregorianCalendar(2018, 11, 27, 14, 00), 5.5)));
    azzert.that(p.getAvailableSlots().size(), is(2));
    azzert.that(p.OrderSlot(new Slot(new GregorianCalendar(2018, 11, 27, 9, 00), new GregorianCalendar(2018, 11, 27, 10, 00), 6.7)),
        is(new Slot(new GregorianCalendar(2018, 11, 27, 9, 00), new GregorianCalendar(2018, 11, 27, 10, 00), 5.5)));
    azzert.that(p.getAvailableSlots().size(), is(3));
    azzert.that(p.OrderSlot(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00), 6.7)),
        is(new Slot(new GregorianCalendar(2018, 11, 27, 8, 00), new GregorianCalendar(2018, 11, 27, 9, 00), 5.5)));
    azzert.that(p.getAvailableSlots().size(), is(2));
  }
}
