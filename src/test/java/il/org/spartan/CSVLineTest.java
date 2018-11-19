/** Unit test for CSVLine.java
 * @author Shaked Sapir
 * @since 2018-11-19 */
package il.org.spartan;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.AbstractStringProperties.*;
import il.org.spartan.CSVLine.*;
import il.org.spartan.CSVLine.Ordered.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class CSVLineTest {
  @Test public void aggregating() {
    Sorterd c = new Sorterd();
    assert !c.aggregating();
  }

  @Test public void aggregations() {
    Sorterd c = new Sorterd();
    assert c.aggregations() != null;
  }

  @Test public void asKeyValuePairs() {
    Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    c.map.put("Nir", "Chach");
    c.map.put("Igor", "Bash");
    c.map.put("Or", "Feld");
    azzert.that(c.asKeyValuePairs(), azzert.is("Igor=Bash, Lior=BY, Nir=Chach, Or=Feld, Shaked=Sapir, Shalev=Kuba"));
  }

  @Test public void entries() {
    Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.entries().iterator().next() + "", azzert.is("Lior=BY"));
  }

  @Test public void extract() {
    Sorterd c = new Sorterd();
    TreeMap<String, String> t = new TreeMap<>();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    c.extract(t);
    azzert.that(c.entries().iterator().next() + "", azzert.is("Lior=BY"));
  }

  @Test public void get() {
    Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.get("Shalev"), azzert.is("Kuba"));
  }

  @Test public void keys() {
    Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.keys().iterator().next() + "", azzert.is("Lior"));
  }

  /** add put tests with Accumulator **/
  @Test public void put0() {
    Sorterd c = new Sorterd();
    Truth f = Truth.F;
    c.put(f, 4);
    azzert.that(c.entries().iterator().next() + "", azzert.is("false=4"));
  }

  @Test public void put1() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    c.put(s, 4);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=4"));
  }

  @Test public void put2() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    c.put(s);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd="));
  }

  @Test public void put3() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    c.put(s, false);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=false"));
  }

  @Test public void put4() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    c.put(s, '\t');
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=\t"));
  }

  // @Test public void put5() {
  // Sorterd c = new Sorterd();
  // String s = "ddd";
  // c.put(s,4.0);
  // azzert.that(c.entries().iterator().next()+"", azzert.is("ddd=4.0"));
  // }
  @Test public void put6() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    float f = (float) 14.33333;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=14.33333"));
  }

  @Test public void put7() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    int i = 4;
    c.put(s, i);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=4"));
  }

  @Test public void put8() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    c.put(s, box.box(4));
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=4"));
  }

  @Test public void put81() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    Integer I = null;
    c.put(s, I);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd="));
  }

  @Test public void put9() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    long f = 4;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=4"));
  }

  @Test public void put10() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    long f = 4;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=4"));
  }

  @Test public void put11() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    Double I = box.box(4.0);
    c.put(s, I);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=4.0"));
  }

  @Test public void put11p0() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    Double I = null;
    c.put(s, I);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd="));
  }

  @Test public void putarr0() {
    Sorterd c = new Sorterd();
    c.put("ddd", null, 0);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd="));
  }

  @SuppressWarnings("null") @Test public void putarr01() {
    Sorterd c = new Sorterd();
    String[] s = { "shak,shal,bobi" };
    c.put("ddd", s, -1);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd="));
  }

  @SuppressWarnings("null") @Test public void putarr02() {
    Sorterd c = new Sorterd();
    String[] s = { "shak,shal,bobi" };
    c.put("ddd", s, 4);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd="));
  }

  @SuppressWarnings("null") @Test public void putarr03() {
    Sorterd c = new Sorterd();
    String[] s = { "shak", "shal", "bobi" };
    c.put("ddd", s, 0);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=shak"));
  }

  @SuppressWarnings("null") @Test public void putarr10() {
    Sorterd c = new Sorterd();
    String[] s = { "shak", "shal", "bobi" };
    c.put("ddd", s);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=shak;shal;bobi"));
  }

  @Test public void put12() {
    Sorterd c = new Sorterd();
    String s = "ddd";
    short f = 4;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", azzert.is("ddd=4"));
  }

  @Test public void put13() {
    CSVLine d = (new Sorterd()).put("sss", "ddd");
    azzert.that(d.entries().iterator().next() + "", azzert.is("sss=ddd"));
  }

  @Test public void size() {
    Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.size(), azzert.is(3));
  }

  @Test public void values() {
    Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.values().iterator().next() + "", azzert.is("BY"));
  }

  @Test public void sep() {
    Ordered o = new Ordered();
    Separated c = o.new Separated(";");
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.values().iterator().next() + "", azzert.is("Sapir"));
  }

  @Test public void createOrd() {
    Ordered o = new Ordered(Renderer.CSV);
    assert !o.aggregating();
  }
  // @SuppressWarnings("null") @Test public void Agg() {
  // Ordered o = new Ordered(Renderer.CSV);
  // ArrayList<String> l = new ArrayList<>();
  // l.add("shak");
  // l.add("shal");
  // ListProperties ll = new ListProperties();
  // ll.put(l.get(0), l.get(0));
  // ll.put(l.get(1), l.get(1));
  // o.addAggregates(ll,o.aggregations().iterator().next());
  // }
}
