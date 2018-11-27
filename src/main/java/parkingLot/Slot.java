/** add here documentation for file
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
package parkingLot;

import java.util.*;

/**
 * @author ShalevKuba, Shaked Sapir
 *
 */
public class Slot {
  /** Slot fields **/
  Date from;
  Date to;
  double price_for_hour;
  
  /** Constructors **/
  public Slot(Date _from, Date _to, double price) {
    this.from = _from;
    this.to = _to;
    this.price_for_hour = price;
  }

  public Slot(Slot s) {
    this.from = s.getFrom();
    this.to = s.getTo();
    this.price_for_hour = s.getPrice_for_hour();
  }
  
  /** getters & setters **/
  public Date getFrom() {
    return from;
  }

  public Date getTo() {
    return to;
  }


  public double getPrice_for_hour() {
    return price_for_hour;
  }

}

