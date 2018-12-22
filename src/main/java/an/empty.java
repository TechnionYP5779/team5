package an;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * TODO Yossi Gil: document class
 *
 * @author Yossi Gil
 * @since 2017-04-01
 */
public enum empty {
	;
	public static <T> @NotNull List<T> list() {
		return new ArrayList<>();
	}

	public static <@Nullable T> Iterable<T> iterable() {
		return () -> new Iterator<>() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public T next() {
				return null;
			}
		};
	}
}
