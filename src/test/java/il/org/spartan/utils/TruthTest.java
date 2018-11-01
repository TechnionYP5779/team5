package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class TruthTest {
  @Test public void testTruthOf() {
    assertEquals(Truth.T, Truth.truthOf(() -> 1 == 1));
    assertEquals(Truth.F, Truth.truthOf(() -> 1 == 2));
    assertEquals(Truth.N, Truth.truthOf(null));
    assertEquals(Truth.X, Truth.truthOf(() -> {throw new AssertionError();}));
    assertEquals(Truth.R, Truth.truthOf(() -> {throw new RuntimeException();}));
    assertEquals(Truth.Ħ, Truth.truthOf(() -> {throw new Error();}));
    }
  
  @Test public void testNot() {
    Truth t = Truth.T;
    Truth f = Truth.F;
    
    assertEquals(Truth.F, t.not());
    assertEquals(Truth.T, f.not());
  }
  
  @Test public void testOr() {
    assertEquals(Truth.T, Truth.T.or(Truth.T));
    assertEquals(Truth.T, Truth.T.or(Truth.F));
    assertEquals(Truth.T, Truth.F.or(Truth.T));
    assertEquals(Truth.F, Truth.F.or(Truth.F));
  }

  @Test public void testAnd() {
    assertEquals(Truth.T, Truth.T.and(Truth.T));
    assertEquals(Truth.F, Truth.T.and(Truth.F));
    assertEquals(Truth.F, Truth.F.and(Truth.T));
    assertEquals(Truth.F, Truth.F.and(Truth.F));
  }
}