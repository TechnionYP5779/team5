/** add here documentation for file
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
package parkingLot.Logic;

import java.util.Calendar;

import fluent.ly.box;

/** @author ShalevKuba, Shaked Sapir */
public class Slot {
	/** Slot fields **/
	Calendar from;
	Calendar to;
	double price_for_hour;

	/** Constructors **/
	public Slot(final Calendar _from, final Calendar _to, final double price) {
		this.from = _from;
		this.to = _to;
		this.price_for_hour = price;
	}

	public Slot(final Slot s) {
		this.from = (Calendar) s.getFrom().clone();
		this.to = (Calendar) s.getTo().clone();
		this.price_for_hour = s.getPrice_for_hour();
	}

	/** getters & setters **/
	public Calendar getFrom() {
		return from;
	}

	public Calendar getTo() {
		return to;
	}

	public double getPrice_for_hour() {
		return price_for_hour;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int $ = 1;
		$ = $ * prime + (from == null ? 0 : from.hashCode());
		final long temp = Double.doubleToLongBits(price_for_hour);
		return prime * ($ * prime + (int) (temp ^ temp >>> 32)) + (to == null ? 0 : to.hashCode());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object ¢) {
		return this.from.equals(((Slot) ¢).from) && this.to.equals(((Slot) ¢).to)
				&& box.it(this.price_for_hour).equals(box.it(((Slot) ¢).price_for_hour));
	}
}
