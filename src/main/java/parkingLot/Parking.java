package parkingLot; 

/** protected methods are expected to be invoked by the parking owner **/

/**add here documentation for file 
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */

import java.util.*;
import java.util.stream.*;

/**
 * @author Shaked Sapir, Shalev Kuba
 *
 */
public class Parking {
    int id;
    User owner;
    

    enum size{
        PRIVATE_CAR, MOTORCYCLE, TRANSIT, BUS
    }
    size sz;
    public class AvailableSlot{
        Date from;
        Date to;

        public Date getFrom() {
            return from;
        }

        protected void setFrom(Date from) {
            this.from = from;
        }

        public Date getTo() {
            return to;
        }

        protected void setTo(Date to) {
            this.to = to;
        }

        public double getPrice_for_hour() {
            return price_for_hour;
        }

        protected void setPrice_for_hour(double price_for_hour) {
            this.price_for_hour = price_for_hour;
        }

        double price_for_hour;

        public AvailableSlot(Date _from, Date _to, double price) {
            this.from = _from;
            this.to = _to;
            this.price_for_hour = price;
        }
    }

    /** Format: State, city, street, apratment no. **/
    String location;
    List<AvailableSlot> availableSlots;

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

  protected void setAvailableSlots(List<AvailableSlot> availableSlots) {
      this.availableSlots = availableSlots;
  }

  public String getLocation() {
      return location;
  }

  public List<AvailableSlot> getAvailableSlots() {
      return availableSlots;
  }
  
  /** some basic functionality **/
  protected Parking addSlot(Date from, Date to, double price) {
    AvailableSlot slot = new AvailableSlot(from,to,price);
    /** if the argument slot intersects with another slot in the list, dont insert it **/
    if(availableSlots.stream().filter
       (e->e.from.compareTo(slot.from)<0 || e.to.compareTo(slot.to)>0).count()>0)
        return this;
    this.availableSlots.add(slot);
    return this;

  }
  
  protected Parking addSlot(AvailableSlot slot) {
    /** if the argument slot intersects with another slot in the list, dont insert it **/
    if(availableSlots.stream().filter
       (e->e.from.compareTo(slot.from)<0 || e.to.compareTo(slot.to)>0).count()>0)
        return this;
    this.availableSlots.add(slot);
    return this;
  }
  
  protected Parking removeSlot(Date from, Date to) {
    availableSlots = availableSlots.stream().filter
        (λ -> (!λ.from.equals(from) || !λ.to.equals(to))).collect(Collectors.toList());
    return this;
  }
  
  protected Parking removeSlot(AvailableSlot slot) {
    availableSlots = availableSlots.stream().filter
        (λ -> (!λ.equals(slot))).collect(Collectors.toList());
    return this;
  }
  
  public double getPriceOfSlot(Date from,Date to) {
    ArrayList<AvailableSlot> legit = (ArrayList<AvailableSlot>) availableSlots.stream()
        .filter(e->e.from.compareTo(from)<=0 && e.to.compareTo(to)>=0).collect(Collectors.toList());
    if(legit.size()>0)
      return (legit.get(0).getPrice_for_hour())*((to.getTime()-from.getTime())/3600000);
    /** if reached here, bad **/
    return -1;

  }
}
