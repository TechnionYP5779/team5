/**add here documentation for file 
 * @author Fname Sname
 * @since year-month-day */
package parkingLot;

import java.util.*;


/**
 * @author Lior Ben-Yamin, Nir Chachamovitz
 * @since 27/11/18
 *
 */
public class Transaction {
  private static int count;
  private int id;
  private double price;
  private Date transactionDate;
  private Date rentStart;
  private Date rentEnd;
  private int parkingId;
  private int tenantId;
  private int landlordId;
  
  /* @param price - the price of the transaction
   * @param transactionDate - the date in which the transaction was made
   * @param rentStart - the date in which the rent starts
   * @param rentEnd - the date in which the rent ensds
   * @param parkingId - the identifier of the parking
   * @param tenantId - the identifier of the tenant
   * @param landlordId - the identifier of the landlord
   */
  public Transaction(double price, Date transactionDate, Date rentStart, Date rentEnd,
      int parkingId, int tenantId, int landlordId) {
    this.setId(++count);
    this.setPrice(price);
    this.setTransactionDate(transactionDate);
    this.setRentStart(rentStart);
    this.setRentEnd(rentEnd);
    this.setParkingId(parkingId);
    this.setTenantId(tenantId);
    this.setLandlordId(landlordId);
  }

  /**
   * @return the tenantId
   */
  public int getTenantId() {
    return tenantId;
  }

  /**
   * @param tenantId the tenantId to set
   */
  public void setTenantId(int tenantId) {
    this.tenantId = tenantId;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  private void setId(int id) {
    this.id = id;
  }

  /**
   * @return the transactionDate
   */
  public Date getTransactionDate() {
    return transactionDate;
  }

  /**
   * @param transactionDate the transactionDate to set
   */
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  /**
   * @return the rentStart
   */
  public Date getRentStart() {
    return rentStart;
  }

  /**
   * @param rentStart the rentStart to set
   */
  public void setRentStart(Date rentStart) {
    this.rentStart = rentStart;
  }

  /**
   * @return the rentEnd
   */
  public Date getRentEnd() {
    return rentEnd;
  }

  /**
   * @param rentEnd the rentEnd to set
   */
  public void setRentEnd(Date rentEnd) {
    this.rentEnd = rentEnd;
  }

  /**
   * @return the parkingId
   */
  public int getParkingId() {
    return parkingId;
  }

  /**
   * @param parkingId the parkingId to set
   */
  public void setParkingId(int parkingId) {
    this.parkingId = parkingId;
  }

  /**
   * @return the landlordId
   */
  public int getLandlordId() {
    return landlordId;
  }

  /**
   * @param landlordId the landlordId to set
   */
  public void setLandlordId(int landlordId) {
    this.landlordId = landlordId;
  }

  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }
  
}
