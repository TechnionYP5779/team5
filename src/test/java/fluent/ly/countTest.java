package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

@SuppressWarnings("static-method")
public class countTest {
	@Test
	public void emptyIterableTest() {
		azzert.that(0, is(count.of(new ArrayList<Integer>())));
	}

	@Test
	public void Count100ObjectsTest() {
		azzert.that(100, is(count.of(Stream.generate(Object::new).limit(100).collect(Collectors.toList()))));
	}
}
