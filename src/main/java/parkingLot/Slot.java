/** add here documentation for file
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
package parkingLot;

import java.util.*;

import fluent.ly.*;

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
    this.from = (Date) s.getFrom().clone();
    this.to = (Date) s.getTo().clone();
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

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime = 31;
    int $ = 1;
    $ = $ * prime + ((from == null) ? 0 : from.hashCode());
    long temp;
    temp = Double.doubleToLongBits(price_for_hour);
    $ = $ * prime + (int) (temp ^ (temp >>> 32));
    $ = $ * prime + ((to == null) ? 0 : to.hashCode());
    return $;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    Slot s=(Slot)o;
    return this.from.equals(s.from)&&this.to.equals(s.to)&&
        box.it(this.price_for_hour).equals(box.it(s.price_for_hour));
  }
}

