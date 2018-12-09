/** add here documentation for file
 * @author Fname Sname
 * @since year-month-day */
package parkingLot.Logic;

import java.util.*;

/**
 * Since 2018 - 11 - 26
 * 
 * @author Igor Bashmashnikov
 * @author Or Feldman A class to represent a user in the parkingLot Project.
 *         Contains information about the user and his list of parkings to rent
 *         and transactions he did.
 */
public class User {
	private static int currentId = 1;
	private final int id = currentId++;
	private double sellerRank;
	private long numberOfSellersFeedback;
	private double buyerRank;
	private long numberOfBuyersFeedback;
	private String name;
	private String email;
	private int phoneNumber;
	private final List<Integer> parkingsList = new ArrayList<>();
	private final List<Integer> transctionsList = new ArrayList<>();

	public enum FEEDBACK {
		HORRIBLE(1), BAD(2), FINE(3), GOOD(4), EXCELLENT(5);
		private double feedback;

		FEEDBACK(final int f) {
			this.feedback = f;
		}

		public double getFeedback() {
			return feedback;
		}
	}

	/**
	 * @param name        the name of user
	 * @param email       the email of the user
	 * @param phoneNumber the phone number of the user
	 */
	public User(final String name, final String email, final int phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/** @return the sellerFeedback */
	public double getSellerRank() {
		return sellerRank;
	}

	/** @param feedback the feedback to add to the Seller Feedback */
	public void addSellerFeedback(final FEEDBACK ¢) {
		this.sellerRank = (¢.getFeedback() + this.sellerRank * this.numberOfSellersFeedback)
				/ (this.numberOfSellersFeedback + 1);
		this.numberOfSellersFeedback++;
	}

	/** @return the buyerFeedback */
	public double getBuyerRank() {
		return buyerRank;
	}

	/** @param feedback the feedback to add to the Buyer Feedback */
	public void addBuyerFeedback(final FEEDBACK ¢) {
		this.buyerRank = (¢.getFeedback() + this.buyerRank * this.numberOfBuyersFeedback)
				/ (this.numberOfBuyersFeedback + 1);
		this.numberOfBuyersFeedback++;
	}

	/** @return the name */
	public String getName() {
		return name;
	}

	/** @param name the name to change to */
	public void changeName(final String newName) {
		this.name = newName;
	}

	/** @return the email */
	public String getEmail() {
		return email;
	}

	/** @param email the email to change to */
	public void changeEmail(final String newEmail) {
		this.email = newEmail;
	}

	/** @return the phoneNumber */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/** @param phoneNumber the phoneNumber to change to */
	public void changePhoneNumber(final int newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	/** @return the parkingsList */
	public List<Integer> getParkingsList() {
		return parkingsList;
	}

	/** @param parking the parking to add to the parkings list */
	public void addParkingSpot(final Integer ¢) {
		this.parkingsList.add(¢);
	}

	/** @param parking the parking to remove from the parkings list */
	public void removeParkingSpot(final Integer ¢) {
		this.parkingsList.remove(¢);
	}

	/** @return the transctionsList */
	public List<Integer> getTransctionsList() {
		return transctionsList;
	}

	/** @param transaction the transaction to add to the transactions list */
	public void setTransctionsList(final Integer ¢) {
		if (!transctionsList.contains(¢))
			this.transctionsList.add(¢);
	}

	/** @param transaction the transaction to remove from the transactions list */
	public void removeTransctionsList(final Integer ¢) {
		this.transctionsList.add(¢);
	}

	/** @return the id */
	public int getId() {
		return id;
	}

	@Override
	public boolean equals(final Object ¢) {
		if (¢ == this)
			return true;
		if (!(¢ instanceof User))
			return false;
		return this.id == ((User) ¢).id;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
