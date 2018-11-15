package fluent.ly;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

@SuppressWarnings("static-method") public class countTest {
  @Test public void emptyIterableTest() {
    azzert.assertEquals(0, count.of(new ArrayList<Integer>()));
  }

  @Test public void Count100ObjectsTest() {
    azzert.assertEquals(100, count.of(Stream.generate(Object::new).limit(100).collect(Collectors.toList())));
  }
}
