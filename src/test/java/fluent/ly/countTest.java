package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class countTest {
  @Test public void emptyIterableTest() {
    assertEquals(0, count.of(new ArrayList()));
  }

  @Test public void Count100ObjectsTest() {
    final List<Object> objectList = Stream.generate(Object::new).limit(100).collect(Collectors.toList());
    assertEquals(100, count.of(objectList));
  }
}
