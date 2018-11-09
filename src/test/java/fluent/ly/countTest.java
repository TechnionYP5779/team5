package fluent.ly;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class countTest {
  @Test @SuppressWarnings({ "static-method", "rawtypes", "unchecked" }) public void emptyIterableTest() {
    azzert.assertEquals(0, count.of(new ArrayList()));
  }

  @Test @SuppressWarnings("static-method") public void Count100ObjectsTest() {
    azzert.assertEquals(100, count.of(Stream.generate(Object::new).limit(100).collect(Collectors.toList())));
  }
}
