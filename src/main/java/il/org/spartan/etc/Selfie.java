package il.org.spartan.etc;

import java.util.function.Supplier;

import fluent.ly.forget;

/**
 * TODO Yossi Gil: document class
 *
 * @author Yossi Gil
 * @since 2017-04-14
 */
public interface Selfie<Self extends Selfie<Self>> {
	default <U> void change(final U ¢) {
		forget.it(¢);
	}

	Self self();

	default <F> Self self(final Supplier<F> t) {
		change(t.get());
		return self();
	}
}
