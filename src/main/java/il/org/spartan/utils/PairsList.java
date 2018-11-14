package il.org.spartan.utils;

import java.util.*;

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
    return sortAsc().get(l.size()-1).p;
  }

  public Pair<Double,Double> min() {
    return sortAsc().get(0).p;

  }

  public int size() {
    return l.size();
  }
}
