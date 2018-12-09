package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;
import il.org.spartan.statistics.*;

/**
 * this class represents a list of pairs, on which we run statistic measures
 * and, hopefully, a linear regression.
 * 
 * @author Shaked Sapir
 * @since 2018-11-14
 */
public class PairsList {
	/**
	 * first, we implement a wrapper for Pair<T,S> because we want to be able to
	 * compare Pairs.
	 * 
	 * @param <Double> generic type of first element in pair
	 * @param <Double1> generic type of second element in pair
	 */
	@SuppressWarnings({ "rawtypes", "hiding" })
	public class PAIR<Double, Double1> implements Comparable {
		@NotNull
		public Pair<Double, Double> p;

		@SuppressWarnings("unchecked")
		public PAIR(@NotNull final Pair<Double, Double1> np) {
			p = (Pair<Double, Double>) np;
		}

		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(final Object ¢) {
			final Double $ = ((PAIR<Double, Double>) ¢).p.first;
			return ((Comparable) p.first).compareTo($) != 0 ? ((Comparable) p.first).compareTo($)
					: ((Comparable) p.second).compareTo(((PAIR<Double, Double>) ¢).p.second);
		}
	}

	/**
	 * then, we implement an iterator for the list, so we can iterate it sorted.
	 * 
	 * @author Shaked Sapir
	 */
	public class PLIterator implements Iterable<PAIR<Double, Double>>, Iterator<PAIR<Double, Double>> {
		PAIR<Double, Double> current;
		int idx;

		public PLIterator() {
			idx = 0;
			current = l.get(idx);
		}

		@Override
		public boolean hasNext() {
			return idx < l.size();
		}

		@Override
		public PAIR<Double, Double> next() {
			try {
				if (!hasNext())
					return l.get(l.size() - 1);
				final PAIR<Double, Double> $ = current;
				current = l.get(++idx);
				return $;
			} catch (@SuppressWarnings("unused") final IndexOutOfBoundsException ¢) {
				return l.get(l.size() - 1);
			}
		}

		@Override
		public Iterator<PAIR<Double, Double>> iterator() {
			return this;
		}
	}

	public ArrayList<PAIR<Double, Double>> l;
	public LinearRegression slr;

	public PairsList() {
		l = new ArrayList<>();
		slr = null;
	}

	public void record(final double d, final double e) {
		l.add(new PAIR<>(new Pair<>(box.it(d), box.it(e))));
	}

	public boolean contains(final double d, final double e) {
		final Pair<Double, Double> t = new Pair<>(box.it(d), box.it(e));
		for (final PAIR<Double, Double> x : l)
			if (x.p.equals(t))
				return true;
		return false;
	}

	/** sorting and iterators **/
	/**
	 * this is an iterator to iterate over the list's elements in ascending order
	 * 
	 * @return an iterator to the list
	 */
	public PLIterator iterator() {
		sortAsc();
		return new PLIterator();
	}

	/**
	 * this is an iterator to iterate over the list's elements in descending order
	 * 
	 * @return a revered-iterator to the list
	 */
	public PLIterator revIterator() {
		sortDesc();
		return new PLIterator();
	}

	public ArrayList<PAIR<Double, Double>> sortAsc() {
		Collections.sort(l, (d, e) -> d.compareTo(e));
		return l;
	}

	public ArrayList<PAIR<Double, Double>> sortDesc() {
		Collections.sort(l, (d, e) -> -d.compareTo(e));
		return l;
	}

	/** now some statistic measures **/
	/*
	 * @param cord: "X" if we want the first quarter of X values, "Y" if we want it
	 * on Y values
	 *
	 * @return first quarter value of wanted axis
	 */
	public double firstQuarterOf(final String axis) {
		final double[] $ = new double[sortAsc().size()];
		for (int ¢ = 0; ¢ < l.size(); ¢++)
			$[¢] = unbox.it("X".equals(axis) ? l.get(¢).p.first : l.get(¢).p.second);
		return l.size() % 2 != 0 ? $[l.size() / 4] : ($[l.size() / 4] + $[l.size() / 4 + 1]) / 2;
	}

	public Pair<Double, Double> max() {
		return l.isEmpty() ? null : sortAsc().get(l.size() - 1).p;
	}

	/*
	 * @param cord: "X" if we want a mean on X values, "Y" if we want a mean on Y
	 * values
	 *
	 * @return mean value of wanted axis
	 */
	public double meanOf(final String axis) {
		final double[] $ = new double[l.size()];
		for (int ¢ = 0; ¢ < l.size(); ¢++)
			$[¢] = unbox.it("X".equals(axis) ? l.get(¢).p.first : l.get(¢).p.second);
		return Statistics.sampleMean($);
	}

	/*
	 * @param cord: "X" if we want a median on X values, "Y" if we want a median on
	 * Y values
	 *
	 * @return median value of wanted axis
	 */
	public double medianOf(final String axis) {
		final double[] $ = new double[l.size()];
		for (int ¢ = 0; ¢ < l.size(); ¢++)
			$[¢] = unbox.it("X".equals(axis) ? l.get(¢).p.first : l.get(¢).p.second);
		return Statistics.median($);
	}

	public Pair<Double, Double> min() {
		return l.isEmpty() ? null : sortAsc().get(0).p;
	}

	/*
	 * @param cord: index of wanted element
	 *
	 * @return the <\> ¢th statistic order<> (the ¢ element in asc sorted list)
	 */
	public Pair<Double, Double> orderStatistic(final int ¢) {
		return sortAsc().get(¢ - 1).p;
	}

	/*
	 * @param cord: "X" if we want the standard deviation on X values, "Y" if we
	 * want it on Y values
	 *
	 * @return sd value of wanted axis
	 */
	public double sdOf(final String axis) {
		return Math.sqrt(varianceOf(axis));
	}

	public int size() {
		return l.size();
	}

	/*
	 * @param cord: "X" if we want the squares-sum of X values, "Y" if we want it on
	 * Y values
	 *
	 * @return squares-sum value of wanted axis
	 */
	public double squaresSumOf(final String axis) {
		int $ = 0;
		for (int ¢ = 0; ¢ < l.size(); ¢++)
			$ += "X".equals(axis) ? unbox.it(l.get(¢).p.first) * unbox.it(l.get(¢).p.first)
					: unbox.it(l.get(¢).p.second) * unbox.it(l.get(¢).p.second);
		return $;
	}

	/*
	 * @param cord: "X" if we want the sum of X values, "Y" if we want it on Y
	 * values
	 *
	 * @return sum value of wanted axis
	 */
	public double sumOf(final String axis) {
		int $ = 0;
		for (int ¢ = 0; ¢ < l.size(); ¢++)
			$ += unbox.it("X".equals(axis) ? l.get(¢).p.first : l.get(¢).p.second);
		return $;
	}

	/*
	 * @param cord: "X" if we want the third quarter of X values, "Y" if we want it
	 * on Y values
	 *
	 * @return third quarter value of wanted axis
	 */
	public double thirdQuarterOf(final String axis) {
		final double[] $ = new double[sortAsc().size()];
		for (int ¢ = 0; ¢ < l.size(); ¢++)
			$[¢] = unbox.it("X".equals(axis) ? l.get(¢).p.first : l.get(¢).p.second);
		return l.size() % 2 != 0 ? $[3 * l.size() / 4] : ($[3 * l.size() / 4] + $[3 * l.size() / 4 + 1]) / 2;
	}

	/*
	 * @param cord: "X" if we want a variance on X values, "Y" if we want a median
	 * on Y values
	 *
	 * @return variance value of wanted axis
	 */
	public double varianceOf(final String axis) {
		final double[] $ = new double[l.size()];
		for (int ¢ = 0; ¢ < l.size(); ¢++)
			$[¢] = unbox.it("X".equals(axis) ? l.get(¢).p.first : l.get(¢).p.second);
		return Statistics.sampleVariance($);
	}

	public LinearRegression LinearRegression() {
		return new LinearRegression(this);
	}
}
