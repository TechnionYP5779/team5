package parkingLot;

import java.util.*;

/** @author Lior Ben-Yamin, Nir Chachamovitz
 * @since 2018-11-27 A class for describing a transaction transaction */
public class Transaction {
  private static final long msInHour = 3600000;
  private static int count;
  private final int id;
  private final double price;
  private final Calendar transactionCalendar;
  private Slot rentTime; // rentTime contains the start time, end time and price per hour
  private final int parkingId;
  private final int tenantId;
  private final int landlordId;

  /* @param price - the price of the transaction
   *
   * @param transactionCalendar - the date in which the transaction was made
   *
   * @param rentTime.from - the date in which the rent starts
   *
   * @param rentTime.to - the date in which the rent ensds
   *
   * @param parkingId - the identifier of the parking
   *
   * @param tenantId - the identifier of the tenant
   *
   * @param landlordId - the identifier of the landlordF */
  public Transaction(final Calendar transactionCalendar, final Slot rentTime, final int parkingId, final int tenantId, final int landlordId) {
    this.id = ++count;
    this.setRentTime(rentTime);
    this.transactionCalendar = transactionCalendar;
    this.parkingId = parkingId;
    this.tenantId = tenantId;
    this.landlordId = landlordId;
    this.price = rentDuration() * rentTime.getPrice_for_hour();
  }

  /** @return the tenantId */
  public int getTenantId() {
    return tenantId;
  }

  /** @return the id */
  public int getId() {
    return id;
  }

  /** @return the transactionCalendar */
  public Calendar getTransactionCalendar() {
    return transactionCalendar;
  }

  /** @return the rentTime.from */
  public Calendar getRentStart() {
    return rentTime.from;
  }

  /** @param rentTime.from the rentTime.from to set */
  public void setRentStart(final Calendar rentTime) {
    this.rentTime.from = rentTime;
  }

  /** @return the rentTime.to */
  public Calendar getRentEnd() {
    return rentTime.to;
  }

  /** @param rentTime.to the rentTime.to to set */
  public void setRentEnd(final Calendar rentTime) {
    this.rentTime.to = rentTime;
  }

  /** @return the parkingId */
  public int getParkingId() {
    return parkingId;
  }

  /** @return the landlordId */
  public int getLandlordId() {
    return landlordId;
  }

  /** @return the price */
  public double getPrice() {
    return price;
  }

  /** @param Transaction t
   * @return whether this transaction was made before the given transaction */
  public boolean madeBefore(final Transaction ¢) {
    return this.transactionCalendar.before(¢.getTransactionCalendar());
  }

  /** @param Transaction t
   * @return whether this transaction's rent started before the given
   *         transaction's rent */
  public boolean startedBefore(final Transaction ¢) {
    return this.rentTime.from.before(¢.getRentStart());
  }

  /** @param Transaction t
   * @return whether this transaction's rent ended before the given transaction's
   *         rent */
  public boolean endedBefore(final Transaction ¢) {
    return this.rentTime.to.before(¢.getRentEnd());
  }

  /** @return the duration of the current transactions' rent */
  public int rentDuration() {
    return (int) ((this.rentTime.to.getTime().getTime() - this.rentTime.from.getTime().getTime()) / msInHour);
  }

  /** @return amount of already made transactions */
  public static int getCountAlreadyMadeTransactions() {
    return Transaction.count;
  }

  /** @return the rentTime */
  public Slot getRentTime() {
    return rentTime;
  }

  /** @param rentTime the rentTime to set */
  public void setRentTime(final Slot rentTime) {
    this.rentTime = rentTime;
  }
}
