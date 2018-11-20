/** Unit test for CSVLine.java
 * @author Shaked Sapir
 * @since 2018-11-19 */
package il.org.spartan;

import java.util.*;

import org.junit.*;
import static fluent.ly.azzert.is;
import fluent.ly.*;
import il.org.spartan.AbstractStringProperties.*;
import il.org.spartan.CSVLine.*;
import il.org.spartan.CSVLine.Ordered.*;
import il.org.spartan.utils.*;
import il.org.spartan.utils.Accumulator.*;

@SuppressWarnings("static-method") public class CSVLineTest {
  @Test public void aggregating() {
    final Sorterd c = new Sorterd();
    assert !c.aggregating();
  }

  @Test public void aggregations() {
    final Sorterd c = new Sorterd();
    assert c.aggregations() != null;
  }

  @Test public void asKeyValuePairs() {
    final Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    c.map.put("Nir", "Chach");
    c.map.put("Igor", "Bash");
    c.map.put("Or", "Feld");
    azzert.that(c.asKeyValuePairs(), is("Igor=Bash, Lior=BY, Nir=Chach, Or=Feld, Shaked=Sapir, Shalev=Kuba"));
  }

  @Test public void entries() {
    final Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.entries().iterator().next() + "", is("Lior=BY"));
  }

  @Test public void extract() {
    final Sorterd c = new Sorterd();
    final TreeMap<String, String> t = new TreeMap<>();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    c.extract(t);
    azzert.that(c.entries().iterator().next() + "", is("Lior=BY"));
  }

  @Test public void get() {
    final Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.get("Shalev"), is("Kuba"));
  }

  @Test public void keys() {
    final Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.keys().iterator().next() + "", is("Lior"));
  }

  /** add put tests with Accumulator **/
  @Test public void putAcc() {
    CSVLine c = new Sorterd();
    final Last a = new Last("strike");
    c = c.put(a);
    azzert.that(c.keys().iterator().next() + "", is("strike"));
  }

  /** add put tests with Accumulator **/
  @Test public void putAcc1() {
    CSVLine c = new Sorterd();
    final Last a = new Last("strike");
    a.add(5);
    c = c.put(a);
    azzert.that(c.values().iterator().next() + "", is("5"));
  }

  @Test public void putAcc2() {
    CSVLine c = new Sorterd();
    final Last a = new Last("s");
    a.add(1);
    final Last b = new Last("t");
    b.add(2);
    final Last d = new Last("u");
    d.add(3);
    c = c.put(a, b, d);
    azzert.that(c.keys().iterator().next(), is("s"));
  }

  @Test public void put0() {
    final Sorterd c = new Sorterd();
    final Truth f = Truth.F;
    c.put(f, 4);
    azzert.that(c.entries().iterator().next() + "", is("false=4"));
  }

  @Test public void put00() {
    final Sorterd c = new Sorterd();
    final Truth f = Truth.F;
    c.put(f, "ddd");
    azzert.that(c.entries().iterator().next() + "", is("false=ddd"));
  }

  @Test public void put1() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    c.put(s, 4);
    azzert.that(c.entries().iterator().next() + "", is("ddd=4"));
  }

  @Test public void put2() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    c.put(s);
    azzert.that(c.entries().iterator().next() + "", is("ddd="));
  }

  @Test public void put3() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    c.put(s, false);
    azzert.that(c.entries().iterator().next() + "", is("ddd=false"));
  }

  @Test public void put4() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    c.put(s, '\t');
    azzert.that(c.entries().iterator().next() + "", is("ddd=\t"));
  }

  @Test public void put6() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final float f = (float) 14.33333;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", is("ddd=14.33333"));
  }

  @Test public void put7() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final int i = 4;
    c.put(s, i);
    azzert.that(c.entries().iterator().next() + "", is("ddd=4"));
  }

  @Test public void put8() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    c.put(s, box.it(4));
    azzert.that(c.entries().iterator().next() + "", is("ddd=4"));
  }

  @Test public void put81() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final Integer I = null;
    c.put(s, I);
    azzert.that(c.entries().iterator().next() + "", is("ddd="));
  }

  @Test public void put9() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final long f = 4;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", is("ddd=4"));
  }

  @Test public void put10() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final long f = 4;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", is("ddd=4"));
  }

  @Test public void put11() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final Double I = box.it(4.0);
    c.put(s, I);
    azzert.that(c.entries().iterator().next() + "", is("ddd=4.0"));
  }

  @Test public void put11p0() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final Double I = null;
    c.put(s, I);
    azzert.that(c.entries().iterator().next() + "", is("ddd="));
  }

  @Test public void putarr0() {
    final Sorterd c = new Sorterd();
    c.put("ddd", null, 0);
    azzert.that(c.entries().iterator().next() + "", is("ddd="));
  }

  @SuppressWarnings("null") @Test public void putarr01() {
    final Sorterd c = new Sorterd();
    final String[] s = { "shak,shal,bobi" };
    c.put("ddd", s, -1);
    azzert.that(c.entries().iterator().next() + "", is("ddd="));
  }

  @SuppressWarnings("null") @Test public void putarr02() {
    final Sorterd c = new Sorterd();
    final String[] s = { "shak,shal,bobi" };
    c.put("ddd", s, 4);
    azzert.that(c.entries().iterator().next() + "", is("ddd="));
  }

  @SuppressWarnings("null") @Test public void putarr03() {
    final Sorterd c = new Sorterd();
    final String[] s = { "shak", "shal", "bobi" };
    c.put("ddd", s, 0);
    azzert.that(c.entries().iterator().next() + "", is("ddd=shak"));
  }

  @SuppressWarnings("null") @Test public void putarr10() {
    final Sorterd c = new Sorterd();
    final String[] s = { "shak", "shal", "bobi" };
    c.put("ddd", s);
    azzert.that(c.entries().iterator().next() + "", is("ddd=shak;shal;bobi"));
  }

  @Test public void put12() {
    final Sorterd c = new Sorterd();
    final String s = "ddd";
    final short f = 4;
    c.put(s, f);
    azzert.that(c.entries().iterator().next() + "", is("ddd=4"));
  }

  @Test public void put13() {
    final CSVLine d = new Sorterd().put("sss", "ddd");
    azzert.that(d.entries().iterator().next() + "", is("sss=ddd"));
  }

  @Test public void putAgg() {
    CSVLine c = new Sorterd();
    c = c.putAggregatorColumn("counter", "strike");
    azzert.that(c.keys().iterator().next(), is("counter"));
  }

  @Test public void putAgg1() {
    CSVLine c = new Sorterd();
    c = c.putAggregatorColumn("counter", "strike");
    azzert.that(c.values().iterator().next(), is("strike"));
  }

  @Test public void size() {
    final Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.size(), is(3));
  }

  @Test public void values() {
    final Sorterd c = new Sorterd();
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.values().iterator().next() + "", is("BY"));
  }

  @Test public void sep() {
    final Ordered o = new Ordered();
    final Separated c = o.new Separated(";");
    c.map.put("Shaked", "Sapir");
    c.map.put("Shalev", "Kuba");
    c.map.put("Lior", "BY");
    azzert.that(c.values().iterator().next() + "", is("Sapir"));
  }

  @Test public void createOrd() {
    final Ordered o = new Ordered(Renderer.CSV);
    assert !o.aggregating();
  }
}
