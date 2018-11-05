package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

import il.org.spartan.utils.*;

public class stringTest {
  @Test public void test_test() {
    int s= string.MAX_FIRST;
    assertEquals(20,s);
  }
  double epsilon = 10e-5;
  @Test public void test_atod() {
    double $ = string.atod("42.001"), $2 = string.atod(String.valueOf(Double.MAX_VALUE));
    assert(42.00<$);
    assert(Double.MAX_VALUE==$2);
    assertNotSame(42,$);
  }
  
  @Test public void test_atof() {
    double $ = string.atof("42.001"), $2 = string.atof(String.valueOf(Float.MAX_VALUE));
    assert(42.00<$);
    assert(Float.MAX_VALUE==$2);
    assertNotSame(Integer.MAX_VALUE,$2);
  }
  
  @Test public void test_atoi() {
    double $ = string.atoi("42"), $2 = string.atoi(String.valueOf(Integer.MAX_VALUE));
    assert(42==$);
    assert(Integer.MAX_VALUE==$2);
    assertNotSame(Float.MAX_VALUE,$2);
  }
  
  @Test public void test_atol() {
    double $ = string.atol("42"), $2 = string.atol(String.valueOf(Long.MAX_VALUE));
    assert(42==$);
    assert(Long.MAX_VALUE==$2);
    assertNotSame(Integer.MAX_VALUE,$);
  }
  
  @Test public void test_capitalize() {
    String s1 = string.capitalize(""), s2 = string.capitalize("Hello"), s3 = string.capitalize("hello"),
        s4 = string.capitalize("hELLo"),s5 = string.capitalize("h");
    assertEquals("",s1);
    assertEquals("Hello",s2);
    assertEquals("Hello",s3);
    assertEquals("Hello",s4);
    assertEquals("H",s5);
  }
  @Test 
  public void test_cat() {
    String[] l1 = {"Hello"," ","World"};
    String[] l2 = {" "," what"," ","happen"};
    String s1 = string.cat("Hello"," ","World"), s2 = string.cat(l1,l2);
    assertEquals("Hello World",s1);
    assertEquals("Hello World  what happen",s2);
  }
  
  @Test public void test_delta() {
    double d1=3.4,d2=3.5, d3= 3.4;
    assert(Math.abs(0.2/6.9-string.delta(d1,d2))<epsilon);
    assert(Math.abs(0.2/6.9-string.delta(d2,d1))<epsilon);
    assert(0 == string.delta(d1, d3));
  }
  
  @Test public void test_dtoa() {
    assertEquals("4.3",string.dtoa(4.3));
    assertEquals(Double.MAX_VALUE+"",string.dtoa(Double.MAX_VALUE));
  }
  
  @Test public void test_eq() {
    assert(string.eq(4, 4));
    assert(!string.eq(3, 4));
    assert(string.eq(null,null));
    assert(!string.eq(4,null));
    assert(!string.eq(null,4));
    assert(string.eq(new Pair<Integer,Integer>(1,2),new Pair<Integer,Integer>(1,2)));
  }
  
  @Test public void test_esc() {
    assertEquals("\\n",string.esc('\n'));
    assertEquals("\\r",string.esc('\r'));
    assertEquals("\\t",string.esc('\t'));
    assertEquals("\\f",string.esc('\f'));
    assertEquals("\\b",string.esc('\b'));
    assertEquals("\\\\",string.esc('\\'));
    assertEquals("\'",string.esc('\'')); // also an escaper, but not in the cases
    assertEquals("\"",string.esc('\"')); // also an escaper, but not in the cases

    assertEquals("g",string.esc('g'));
    
    /*************************************/
    
    assertEquals("(null)",string.esc(null));
    assertEquals("hello",string.esc("hello"));
    assertEquals("he\\bllo",string.esc("he\bllo"));
    assertEquals("hel\\\\lo",string.esc("hel\\lo"));
    assertEquals("hel\"lo",string.esc("hel\"lo"));
  }
  
  @Test public void test_expandLeadingTabs() {
    assertEquals("hello",string.expandLeadingTabs("hello"));
//    System.out.println(string.expandLeadingTabs("\the\tl\t\tlo"));
//    assertEquals("  he  l   lo",string.expandLeadingTabs("\the\tl\t\tlo"));
//    assertEquals("he  l   lo  ",string.expandLeadingTabs("he\tl\t\tlo\t"));

  }
  
  @Test public void test_fill() {
    assertEquals("ccccc",string.fill(5, 'c'));
    assertEquals("scscsc",string.fill(3, "sc"));
    assertEquals("c",string.fill(1, 'c'));
  }
  
  @Test public void test_first() {
    assertEquals('c',string.first("cello"));
    assertEquals('c',string.first("c"));
    assertEquals('C',string.first("Cello"));
    assertEquals('$',string.first("$ello"));
    assertEquals('\t',string.first("\tcello"));  
    assertNotSame('\'',string.first("\tcello"));
  }
  
  @Test public void test_ftoa() {
    assertEquals(Float.MAX_VALUE+"",string.ftoa(Float.MAX_VALUE));
  }
  
  @Test public void test_isDouble() {
    assert(string.isDouble("4.3"));
    assert(string.isDouble(""+Double.MAX_VALUE));
    assert(!string.isDouble("4O"));
    assert(!string.isDouble("#"));
    assert(!string.isDouble("\t"));
  }
  
  @Test public void test_isFloat() {
    assert(string.isFloat("4.3"));
    assert(string.isFloat(""+Float.MAX_VALUE));
    assert(!string.isFloat("4O"));
    assert(!string.isFloat("#"));
    assert(!string.isFloat("\t"));
  }
  
  @Test public void test_isInt() {
    assert(!string.isInt("4.3"));
    assert(string.isInt(""+Integer.MAX_VALUE));
    assert(!string.isInt(""+Long.MAX_VALUE));
    assert(!string.isInt("4O"));
    assert(!string.isInt("#"));
    assert(!string.isInt("\t"));
  }
  
  @Test public void test_isLong() {
    assert(!string.isLong("4.3"));
    assert(string.isLong(""+Integer.MAX_VALUE));
    assert(string.isLong(""+Long.MAX_VALUE));
    assert(!string.isLong("4O"));
    assert(!string.isLong("#"));
    assert(!string.isLong("\t"));
  }
  
  @Test public void test_itoa() {
    assertEquals(Integer.MAX_VALUE+"",string.itoa(Integer.MAX_VALUE));
  }
  
  @Test public void test_javaCase() {
    String s1 = string.javaCase(""), s2 = string.javaCase("Hello"), s3 = string.javaCase("hello"),
        s4 = string.javaCase("hELLo"),s5 = string.javaCase("h");
    assertEquals("",s1);
    assertEquals("hello",s2);
    assertEquals("hello",s3);
    assertEquals("hELLo",s4);
    assertEquals("h",s5);
  }
  
  @Test public void test_last() {
    assertEquals('o',string.last("cello"));
    assertEquals('c',string.last("c"));
    assertEquals('C',string.last("CelloC"));
    assertEquals('$',string.last("$ello$"));
    assertEquals('\t',string.last("\tcello\t"));  
    assertNotSame('\'',string.last("\tcello\\"));
  }
  
  @Test public void test_lowCounter() {
    
  }
}
