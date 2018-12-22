package il.org.spartan.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import il.org.spartan.Utils;

public class Pair<First, Second> {
	@SuppressWarnings("unchecked") //
	public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int ¢) {
		return new Pair[¢];
	}

	public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int i, final int m) {
		return makePairs(i * m);
	}

	@NotNull
	public static <A, B> Pair<A, B> newPair(@NotNull final A a, @NotNull final B b) {
		return new Pair<>(a, b);
	}

	private static boolean eq(final @Nullable Object a, final @Nullable Object o) {
		return a == null ? o == null : a.equals(o);
	}

	@NotNull
	public final First first;
	@NotNull
	public final Second second;

	public Pair(@NotNull final First first, @NotNull final Second second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(final @Nullable Object ¢) {
		return ¢ == this || ¢ != null && getClass().equals(¢.getClass()) && eq(first, ((Pair<?, ?>) ¢).first)
				&& eq(second, ((Pair<?, ?>) ¢).second);
	}

	@Override
	public int hashCode() {
		return Utils.hash(second) ^ Utils.hash(first) >>> 1;
	}

	@Override
	@NotNull
	public String toString() {
		return "<" + first + "," + second + ">";
	}
}
