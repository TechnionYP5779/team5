package parkingLot.Logic;

/** protected methods are expected to be invoked by the parking owner **/

/** add here documentation for file
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/** @author Shaked Sapir, Shalev Kuba */
public class Parking {
	public enum size {
		PRIVATE_CAR, MOTORCYCLE, TRANSIT, BUS
	}

	/** Parking fields **/
	/**
	 * location Format: State, city, street, apratment no. we will try to use google
	 * maps locationType. we will do it when the time comes
	 **/
	static int currentId = 1;
	String location;
	String userName;
	final int id;
	int ownerId;
	size sz;
	List<Slot> availableSlots;

	/** Constructor **/
	public Parking(final int owner, final size sz, final String location) {
		this.id = currentId++;
		this.ownerId = owner;
		this.sz = sz;
		this.location = location;
		this.availableSlots = new ArrayList<>();
	}
	
	public Parking(final int owner, final size sz, final String location, String userName) {
		this.id = currentId++;
		this.ownerId = owner;
		this.sz = sz;
		this.location = location;
		this.availableSlots = new ArrayList<>();
		this.userName = userName;
	}

	/** getters & setters **/
	public int getId() {
		return id;
	}

	public size getSize() {
		return sz;
	}

	public int getOwner() {
		return ownerId;
	}

	public String getLocation() {
		return location;
	}
	
	public String getUserName() {
		return userName;
	}

	protected List<Slot> getAvailableSlots() {
		return availableSlots;
	}
	

	/** some basic functionality **/
	/**
	 * @param from - intervals start date
	 * @param to   - intervals end date
	 * @param      price- intervals hourly price
	 * @return adds the new Slot to the Available Slots of this Parking only if the
	 *         argument slot isn't intersecting with another available slot of this
	 *         Parking and the intervals length is bigger than 0 (really an
	 *         interval)
	 */
	protected Parking addAvailableSlot(final Calendar from, final Calendar to, final double price) {
		if (to.compareTo(from) <= 0
				|| availableSlots.stream().filter(λ -> λ.from.compareTo(from) < 0 && λ.to.compareTo(from) > 0
						|| λ.to.compareTo(to) > 0 && λ.from.compareTo(to) < 0).count() > 0)
			return this;
		this.availableSlots.add(new Slot(from, to, price));
		return this;
	}

	/**
	 * @param ¢ - new available slot
	 * @return adds the new Slot to the Available Slots of this Parking only if the
	 *         argument slot isn't intersecting with another available slot of this
	 *         Parking
	 */
	protected Parking addAvailableSlot(final Slot ¢) {
		return addAvailableSlot(¢.getFrom(), ¢.getTo(), ¢.getPrice_for_hour());
	}

	/**
	 * @param from - intervals start date
	 * @param to   - intervals end date
	 * @return removes the slot from the available slots of this parking
	 */
	protected Parking removeAvailableSlot(final Calendar from, final Calendar to) {
		availableSlots = availableSlots.stream().filter(λ -> (!λ.from.equals(from) || !λ.to.equals(to)))
				.collect(Collectors.toList());
		return this;
	}

	/**
	 * @param s - interval of available slot
	 * @return removes the slot from the available slots of this parking
	 */
	protected Parking removeAvailableSlot(final Slot ¢) {
		return this.removeAvailableSlot(¢.getFrom(), ¢.getTo());
	}

	/**
	 * @param from - intervals start date
	 * @param to   - intervals end date
	 * @return available slot thats contains the desired slot with positive
	 *         price_for_hour , or slot with negative price_for_hour if there isn't
	 *         such slot.
	 */
	protected Slot getSlot(final Calendar from, final Calendar to) {
		final ArrayList<Slot> $ = (ArrayList<Slot>) availableSlots.stream()
				.filter(λ -> λ.from.compareTo(from) <= 0 && λ.to.compareTo(to) >= 0).collect(Collectors.toList());
		return !$.isEmpty() ? new Slot($.get(0)) : new Slot(from, from, -1);
	}

	/**
	 * @param ¢ - the desired slot
	 * @return available slot thats contains the desired slot with positive
	 *         price_for_hour , or slot with negative price_for_hour if there isn't
	 *         such slot.
	 */
	protected Slot getSlot(final Slot ¢) {
		return this.getSlot(¢.getFrom(), ¢.getTo());
	}

	/**
	 * @param from - intervals start date
	 * @param to   - intervals end date
	 * @return: split the available slot that contains the desired slot to 2 new
	 *          available slots, and returns the desired slot.
	 */
	protected Slot OrderSlot(final Calendar from, final Calendar to) {
		final Slot $ = new Slot(this.getSlot(from, to));
		/* negative price / to before from symbolize failure of this function */
		if ($.getPrice_for_hour() < 0 || to.before(from))
			return new Slot(from, from, -1);
		this.removeAvailableSlot(this.getSlot(from, to))
				.addAvailableSlot(new Slot($.getFrom(), from, $.getPrice_for_hour()));
		this.addAvailableSlot(new Slot(to, $.getTo(), $.getPrice_for_hour()));
		return new Slot(from, to, $.getPrice_for_hour());
	}

	/**
	 * @param slot - the desired slot
	 * @return: split the available slot that contains the desired slot to 2 new
	 *          available slots, and returns the desired slot.
	 */
	protected Slot OrderSlot(final Slot ¢) {
		return this.OrderSlot(¢.getFrom(), ¢.getTo());
	}
}
