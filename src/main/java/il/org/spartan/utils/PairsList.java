package il.org.spartan.utils;

import java.util.*;

import il.org.spartan.statistics.*;

/**
 * @author Shaked Sapir
 * @since 2018-11-14
 * 
 */
public class PairsList {
  @SuppressWarnings({ "rawtypes", "hiding" }) public class PAIR<Double,Double1> implements Comparable{
    public Pair<Double,Double> p;
    
    @SuppressWarnings("unchecked") public PAIR(Pair<Double,Double1> np) {
      p=(Pair<Double, Double>) np;
    }

    @SuppressWarnings({ "cast", "unchecked", "null" }) @Override public int compareTo(Object ¢) {
      Double $ = (Double) ((PAIR<Double, Double>) ¢).p.first;
      return ((Comparable) (Double) p.first).compareTo($) != 0 ? ((Comparable) (Double) p.first).compareTo($)
          : ((Comparable) (Double) p.second).compareTo((Double) ((PAIR<Double, Double>) ¢).p.second);
    }
  }
  public ArrayList<PAIR<Double,Double>> l;
  public PairsList() {
    l = new ArrayList<>();
  }

  @SuppressWarnings("boxing") public void record(double d, double e) {
    l.add(new PAIR<>(new Pair<>(d,e)));
  }

  @SuppressWarnings("boxing") public boolean contains(double d, double e) {
    Pair<Double,Double> t = new Pair<>(d,e);
    for (PAIR<Double,Double> x : l)
      if (x.p.equals(t))
        return true;
    return false;
  }

  public ArrayList<PAIR<Double,Double>> sortAsc() {
    Collections.sort(l,new Comparator<PAIR<Double,Double>>(){
      @Override public int compare(PAIR<Double,Double> d, PAIR<Double,Double> e) {
        return d.compareTo(e);
      }
    });
    return l;
  }
  
  public ArrayList<PAIR<Double,Double>> sortDesc() {
    Collections.sort(l,new Comparator<PAIR<Double,Double>>(){
      @Override public int compare(PAIR<Double,Double> d, PAIR<Double,Double> e) {
        return -d.compareTo(e);
      }
    });
    return l;
  }

  public Pair<Double,Double> max() {
    return l.isEmpty() ? null : sortAsc().get(l.size()-1).p;
  }

  public Pair<Double,Double> min() {
    return l.isEmpty() ? null : sortAsc().get(0).p;

  }

  public int size() {
    return l.size();
  }

  /*
   * @param cord: "X" if we want a mean on X values
   *              "Y" if we want a mean on Y values
   * @return mean value of wanted axis
   */
  @SuppressWarnings("boxing") public double mean(String axis) {
    double[] $ = new double[l.size()];
    for(int ¢=0;¢<l.size();¢++)
      $[¢] = "X".equals(axis) ? (double)l.get(¢).p.first : (double)l.get(¢).p.second;
    return Statistics.sampleMean($);
  }
  
  /*
   * @param cord: "X" if we want a median on X values
   *              "Y" if we want a median on Y values
   * @return mean value of wanted axis
   */
  @SuppressWarnings("boxing") public double median(String axis) {
    double[] $ = new double[l.size()];
    for(int ¢=0;¢<l.size();¢++)
      $[¢] = "X".equals(axis) ? (double)l.get(¢).p.first : (double)l.get(¢).p.second;
    return Statistics.median($);
  }

  @SuppressWarnings("boxing") public double variance(String axis) {
    double[] $ = new double[l.size()];
    for(int ¢=0;¢<l.size();¢++)
      $[¢] = "X".equals(axis) ? (double)l.get(¢).p.first : (double)l.get(¢).p.second;
    return Statistics.sampleVariance($);    
  }

  @SuppressWarnings({ "boxing", "cast" }) public double squaresSum(String axis) {
    int $ = 0;
    for(int ¢=0;¢<l.size();¢++) 
      $+= "X".equals(axis) ? (double)l.get(¢).p.first*(double)l.get(¢).p.first : (double)l.get(¢).p.second*(double)l.get(¢).p.second;
    return $;
  }
}
