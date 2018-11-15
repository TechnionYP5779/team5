package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;
import il.org.spartan.statistics.*;

/** this class represents a list of pairs, on which we run statistic measures
 * and, hopefully, a linear regression.
 * @author Shaked Sapir
 * @since 2018-11-14 */
public class PairsList {
  @SuppressWarnings({ "rawtypes", "hiding" }) public class PAIR<Double, Double1> implements Comparable {
    @NotNull public Pair<Double, Double> p;

    @SuppressWarnings("unchecked") public PAIR(@NotNull Pair<Double, Double1> np) {
      p = (Pair<Double, Double>) np;
    }

    @SuppressWarnings("unchecked") @Override public int compareTo(Object ¢) {
      Double $ = ((PAIR<Double, Double>) ¢).p.first;
      return ((Comparable) p.first).compareTo($) != 0 ? ((Comparable) p.first).compareTo($)
          : ((Comparable) p.second).compareTo(((PAIR<Double, Double>) ¢).p.second);
    }
  }

  public ArrayList<PAIR<Double, Double>> l;

  public PairsList() {
    l = new ArrayList<>();
  }

  public void record(double d, double e) {
    l.add(new PAIR<>(new Pair<>(box.box(d), box.box(e))));
  }

  public boolean contains(double d, double e) {
    Pair<Double, Double> t = new Pair<>(box.box(d), box.box(e));
    for (PAIR<Double, Double> x : l)
      if (x.p.equals(t))
        return true;
    return false;
  }

  public ArrayList<PAIR<Double, Double>> sortAsc() {
    Collections.sort(l, new Comparator<PAIR<Double, Double>>() {
      @Override public int compare(PAIR<Double, Double> d, PAIR<Double, Double> e) {
        return d.compareTo(e);
      }
    });
    return l;
  }

  public ArrayList<PAIR<Double, Double>> sortDesc() {
    Collections.sort(l, new Comparator<PAIR<Double, Double>>() {
      @Override public int compare(PAIR<Double, Double> d, PAIR<Double, Double> e) {
        return -d.compareTo(e);
      }
    });
    return l;
  }

  public Pair<Double, Double> max() {
    return l.isEmpty() ? null : sortAsc().get(l.size() - 1).p;
  }

  public Pair<Double, Double> min() {
    return l.isEmpty() ? null : sortAsc().get(0).p;
  }

  public int size() {
    return l.size();
  }

  /* @param cord: "X" if we want a mean on X values "Y" if we want a mean on Y
   * values
   * 
   * @return mean value of wanted axis */
  public double mean(String axis) {
    double[] $ = new double[l.size()];
    for (int ¢ = 0; ¢ < l.size(); ¢++)
      $[¢] = "X".equals(axis) ? unbox.unbox(l.get(¢).p.first) : unbox.unbox(l.get(¢).p.second);
    return Statistics.sampleMean($);
  }

  /* @param cord: "X" if we want a median on X values "Y" if we want a median on Y
   * values
   * 
   * @return mean value of wanted axis */
  public double median(String axis) {
    double[] $ = new double[l.size()];
    for (int ¢ = 0; ¢ < l.size(); ¢++)
      $[¢] = "X".equals(axis) ? unbox.unbox(l.get(¢).p.first) : unbox.unbox(l.get(¢).p.second);
    return Statistics.median($);
  }

  public double variance(String axis) {
    double[] $ = new double[l.size()];
    for (int ¢ = 0; ¢ < l.size(); ¢++)
      $[¢] = "X".equals(axis) ? unbox.unbox(l.get(¢).p.first) : unbox.unbox(l.get(¢).p.second);
    return Statistics.sampleVariance($);
  }

  public double squaresSum(String axis) {
    int $ = 0;
    for (int ¢ = 0; ¢ < l.size(); ¢++)
      $ += "X".equals(axis) ? unbox.unbox(l.get(¢).p.first) * unbox.unbox(l.get(¢).p.first)
          : unbox.unbox(l.get(¢).p.second) * unbox.unbox(l.get(¢).p.second);
    return $;
  }

  public double sum(String axis) {
    int $ = 0;
    for (int ¢ = 0; ¢ < l.size(); ¢++)
      $ += "X".equals(axis) ? unbox.unbox(l.get(¢).p.first) : unbox.unbox(l.get(¢).p.second);
    return $;
  }

  public double sd(String axis) {
    return Math.sqrt(variance(axis));
  }

  public Pair<Double, Double> orderStatistic(int ¢) {
    return sortAsc().get(¢ - 1).p;
  }

  public double firstQuarter(String axis) {
    double[] $ = new double[sortAsc().size()];
    for (int ¢ = 0; ¢ < l.size(); ¢++)
      $[¢] = "X".equals(axis) ? unbox.unbox(l.get(¢).p.first) : unbox.unbox(l.get(¢).p.second);
    return l.size() % 2 != 0 ? $[l.size() / 4] : ($[l.size() / 4] + $[l.size() / 4 + 1]) / 2;
  }

  public double thirdQuarter(String axis) {
    double[] $ = new double[sortAsc().size()];
    for (int ¢ = 0; ¢ < l.size(); ¢++)
      $[¢] = "X".equals(axis) ? unbox.unbox(l.get(¢).p.first) : unbox.unbox(l.get(¢).p.second);
    return l.size() % 2 != 0 ? $[3 * l.size() / 4] : ($[3 * l.size() / 4] + $[3 * l.size() / 4 + 1]) / 2;
  }
}
