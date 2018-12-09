/** add here documentation for file
 * @author Shaked Sapir, Shalev Kuba
 * @since 2018-11-27 */
package parkingLot.Logic;

import java.util.*;

import fluent.ly.*;

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
		long temp;
		temp = Double.doubleToLongBits(price_for_hour);
		$ = $ * prime + (int) (temp ^ temp >>> 32);
		$ = $ * prime + (to == null ? 0 : to.hashCode());
		return $;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object o) {
		final Slot s = (Slot) o;
		return this.from.equals(s.from) && this.to.equals(s.to)
				&& box.it(this.price_for_hour).equals(box.it(s.price_for_hour));
	}
}
