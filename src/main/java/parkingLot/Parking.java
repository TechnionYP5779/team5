/**add here documentation for file 
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
package parkingLot;

import java.util.*;

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
  
  public class AvailableSlot{
    Date from;
    Date to;
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
}
