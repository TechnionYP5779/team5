package parkingLot;

import java.util.*;


/**
 * @author Lior Ben-Yamin, Nir Chachamovitz
 * @since 2018-11-27
 * A class for describing a transaction transaction
 */
public class Transaction {
  private static final long msInHour = 3600000;
  private static int count;
  private int id;
  private double price;
  private Date transactionDate;
  private Slot rentTime; // rentTime contains the start time, end time and price per hour
  private int parkingId;
  private int tenantId;
  private int landlordId;
  
  /* @param price - the price of the transaction
   * @param transactionDate - the date in which the transaction was made
   * @param rentTime.from - the date in which the rent starts
   * @param rentTime.to - the date in which the rent ensds
   * @param parkingId - the identifier of the parking
   * @param tenantId - the identifier of the tenant
   * @param landlordId - the identifier of the landlordF
   */
  public Transaction(Date transactionDate, Slot rentTime,
      int parkingId, int tenantId, int landlordId) {
    this.setId(++count);
    this.setPrice(rentDuration() * rentTime.getPrice_for_hour());
    this.setTransactionDate(transactionDate);
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
  public void setTransactionDate(Date transactionDate2) {
    this.transactionDate = transactionDate2;
  }

  /**
   * @return the rentTime.from
   */
  public Date getRentStart() {
    return rentTime.from;
  }

  /**
   * @param rentTime.from the rentTime.from to set
   */
  public void setRentStart(Date rentTime) {
    this.rentTime.from = rentTime;
  }

  /**
   * @return the rentTime.to
   */
  public Date getRentEnd() {
    return rentTime.to;
  }

  /**
   * @param rentTime.to the rentTime.to to set
   */
  public void setRentEnd(Date rentTime) {
    this.rentTime.to = rentTime;
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
  
  /**
   * @param Transaction t
   * @return whether this transaction was made before the given transaction
   */
  public boolean madeBefore(Transaction ¢) {
    return this.transactionDate.before(¢.getTransactionDate());
  }
  
  /**
   * @param Transaction t
   * @return whether this transaction's rent started before the given transaction's rent
   */
  public boolean startedBefore(Transaction ¢) {
    return this.rentTime.from.before(¢.getRentStart());
  }

  /**
   * @param Transaction t
   * @return whether this transaction's rent ended before the given transaction's rent
   */
  public boolean endedBefore(Transaction ¢) {
    return this.rentTime.to.before(¢.getRentEnd()); 
  }
  
  /**
   * @return the duration of the current transactions' rent
   */
  public int rentDuration() {
    return (int)((this.rentTime.to.getTime()-this.rentTime.from.getTime())/msInHour);
  }
  
  /**
   * @return amount of already made transactions
   */
  public static int getCountAlreadyMadeTransactions() {
    return Transaction.count;
  }

  /**
   * @return the rentTime
   */
  public Slot getRentTime() {
    return rentTime;
  }

  /**
   * @param rentTime the rentTime to set
   */
  public void setRentTime(Slot rentTime) {
    this.rentTime = rentTime;
  }
  
  
  
}
