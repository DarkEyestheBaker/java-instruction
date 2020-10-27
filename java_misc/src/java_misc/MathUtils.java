package java_misc;

public class MathUtils {
	public static int min(int a, int b) {
		return a < b ? a : b;
		// a is less than b, if it is, the result should be a otherwise it is b
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int sum(int... values) {
		// passing 0 to many integers into this code
		// when you see the ... it means you can pass 0 to many
		if (values.length == 0) {
			throw new IllegalArgumentException("Must pass at least one value");
		}
		int result = 0;
		for (int value : values) {
			result += value;
		}
		return result;
	}

	public static int power(int value, int raiseTo) {
		if (raiseTo == 0) {
			return 1;
		}
		int result = value;
		for (int i = 1; i < raiseTo; i++) {
			result *= value;
		}
		return result;
	}
}
