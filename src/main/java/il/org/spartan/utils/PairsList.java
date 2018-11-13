package il.org.spartan.utils;

import java.util.*;

public class PairsList {
  
  public ArrayList<Pair<Double,Double>> l;
  public PairsList() {
    l = new ArrayList<>();
  }

  @SuppressWarnings("boxing") public void record(double d, double e) {
    l.add(new Pair<>(d,e));
  }

  @SuppressWarnings("boxing") public boolean contains(double d, double e) {
    return l.contains(new Pair<>(d,e));
  }
}
