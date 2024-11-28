// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(-15, -3)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int counter = 0;
		int finalNum = x1;
		if (x2 > 0) {
			while (counter < x2) {
				finalNum++;
				counter++;
			}
		} else {
			while (counter > x2) {
				finalNum--;
				counter--;
			}
		}
		return finalNum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int counter = 0;
		int finalNum = x1;
		if (x2 > 0) {
			while (counter < x2) {
				counter++;
				finalNum--;
			}
		} else {
			while (counter > x2) {
				counter--;
				finalNum++;
			}
		}
		return finalNum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int counter = 0;
		int finalNum = 0; // Start from zero for multiplication

		if (x2 > 0) {
			while (counter < x2) {
				counter++;
				finalNum = plus(finalNum, x1); // Add x1 repeatedly
			}
		} else if (x2 < 0) {
			while (counter > x2) {
				counter--;
				finalNum = plus(finalNum, -x1); // Subtract x1 repeatedly
			}
		}
		// If x2 == 0, finalNum remains 0
		return finalNum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1; // x^0 = 1
		}

		int counter = 1; // Start from 1 because the first multiplication is implicit
		int finalNum = x;

		while (counter < n) {
			counter++;
			finalNum = times(finalNum, x);
		}
		return finalNum;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int counter = 0;
		int finalNum = x2;
		if (x1 == 0) {
			return 0;
		}
		if (x2 == 0) {
			return 0;
		}
		if (x1 > 0) {
			if (x2 > 0) {
				while (finalNum <= x1) {
					finalNum = plus(finalNum, x2);
					counter++;
				}
			} else {
				while (finalNum <= times(x1, -1)) {
					finalNum = plus(finalNum, x2);
					counter++;
				}
			}

		} else // if x > 0
		{
			if (x2 < 0) {
				while (x1 <= finalNum) {
					finalNum = plus(finalNum, x2);
					counter++;
				}
			} else {
				while (times(finalNum, -1) >= x1) {
					finalNum = plus(finalNum, x2);
					counter++;
				}
			}
		}
		return counter;
	}

	public static int mod(int x1, int x2) {
		int finalNum = x1;
		while (finalNum > x2)
			while (finalNum >= x2) {
				finalNum = minus(finalNum, x2);
			}
		return finalNum;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		if (x < 2) {
			return x;
		}

		int left = 1;
		int right = x;
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int midSquared = times(mid, mid);

			if (midSquared == x) {
				return mid;
			} else if (midSquared < x) {
				left = mid + 1;
				result = mid;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}
}