package parkingLot;

/** protected methods are expected to be invoked by the parking owner **/

/** add here documentation for file
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
import java.util.*;
import java.util.stream.*;

/** @author Shaked Sapir, Shalev Kuba */
public class Parking {
  enum size {
    PRIVATE_CAR, MOTORCYCLE, TRANSIT, BUS
  }
  
  /** Parking fields **/
  /** location Format: State, city, street, apratment no. 
   *  we will try to use google maps locationType.
   *  we will do it when the time comes**/
  String location;
  int id;
  User owner;
  size sz;
  List<Slot> availableSlots;

  /** Constructor **/
  public Parking(int id, User owner, size sz, String location) {
    this.id = id;
    this.owner = owner;
    this.sz = sz;
    this.location = location;
    this.availableSlots = new ArrayList<>();
  }

  /** getters & setters **/
  public int getId() {
    return id;
  }

  public User getOwner() {
    return owner;
  }

  protected void setLocation(String location) {
    this.location = location;
  }

  protected void setAvailableSlots(List<Slot> availableSlots) {
    this.availableSlots = availableSlots;
  }

  public String getLocation() {
    return location;
  }

  protected List<Slot> getAvailableSlots() {
    return availableSlots;
  }

  /** some basic functionality **/
  /**
   * @param from - intervals start date
   * @param to - intervals end date
   * @param price- intervals hourly price
   * @return adds the new Slot to the Available Slots of this Parking
   * only if the argument slot isn't intersecting with another available slot
   * of this Parking and the intervals length is bigger than 0 (really an interval)
   */
  protected Parking addAvailavbleSlot(Date from, Date to, double price) {
    if (to.getTime() - from.getTime() <= 0)
      return this;
    if (availableSlots.stream().filter(λ -> λ.from.compareTo(from) < 0 || λ.to.compareTo(to) > 0).count() > 0)
      return this;
    this.availableSlots.add(new Slot(from, to, price));
    return this;
  }

  /**
   * @param ¢ - new available slot
   * @return adds the new Slot to the Available Slots of this Parking
   * only if the argument slot isn't intersecting with another available slot
   * of this Parking
   */
  protected Parking addAvailavbleSlot(Slot ¢) {
    return addAvailavbleSlot(¢.getFrom(), ¢.getTo(), ¢.getPrice_for_hour());
  }

  /**
   * 
   * @param from -  intervals start date
   * @param to -  intervals end date
   * @return removes the slot from the available slots of this parking
   */
  protected Parking removeAvailavbleSlot(Date from, Date to) {
    availableSlots = availableSlots.stream().filter(λ -> (!λ.from.equals(from) || !λ.to.equals(to))).collect(Collectors.toList());
    return this;
  }

  /**
   * @param s -   interval of available slot
   * @return removes the slot from the available slots of this parking
   */
  protected Parking removeAvailavbleSlot(Slot s) {
    availableSlots = availableSlots.stream().filter(λ -> (!λ.equals(s))).collect(Collectors.toList());
    return this;
  }

  /**
   * 
   * @param from - intervals start date
   * @param to - intervals end date
   * @return available slot thats contains the desired slot with positive price_for_hour ,
   * or slot with negative price_for_hour if there isn't such slot.
   */
  protected Slot getSlot(Date from, Date to) {
    ArrayList<Slot> $ = (ArrayList<Slot>) availableSlots.stream().filter(λ -> λ.from.compareTo(from) <= 0 && λ.to.compareTo(to) >= 0)
        .collect(Collectors.toList());
    if ($.isEmpty())
      return new Slot(from, from, -1);
    return new Slot($.get(0));
  }

  /**
   * 
   * @param ¢ - the desired slot
   * @return available slot thats contains the desired slot with positive price_for_hour ,
   * or slot with negative price_for_hour if there isn't such slot.
   */
  protected Slot getSlot(Slot ¢) {
    return this.getSlot(¢.getFrom(), ¢.getTo());
  }

  /**
   * 
   * @param from - intervals start date
   * @param to - intervals end date
   * @return: split the available slot that contains the desired slot to 2 new available slots,
   * and returns the desired slot.
   */
  protected Slot OrderSlot(Date from, Date to) {
    Slot $ = new Slot(this.getSlot(from, to));
    /* negative price symbolizes failure of this function */
    if ($.getPrice_for_hour() < 0)
      return new Slot(from, from, -1);
    this.removeAvailavbleSlot(this.getSlot(from, to)).addAvailavbleSlot(new Slot($.getFrom(), from, $.getPrice_for_hour()))
        .addAvailavbleSlot(new Slot(to, $.getTo(), $.getPrice_for_hour()));
    return $;
  }
  
  /**
   * 
   * @param slot - the desired slot
   * @return: split the available slot that contains the desired slot to 2 new available slots,
   * and returns the desired slot.
   */
  protected Slot OrderSlot(Slot ¢) {
    return this.OrderSlot(¢.getFrom(), ¢.getTo());
  }
}
