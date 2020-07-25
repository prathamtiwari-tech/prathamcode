package geeksforgeeks;

public class MaximumNumberWithKSwap {
	// JAVA program to find maximum
	// integer possible by doing
	// at-most K swap operations
	// on its digits.
	// Function to find maximum
	// integer possible by
	// doing at-most K swap
	// operations on its digits
	private static String max;

	public static void findMaximumNum(char[] str, int k) {
		// Return if no swaps left
		if (k == 0)
			return;

		int n = str.length;

		// Consider every digit
		for (int i = 0; i < n - 1; i++) {

			// Compare it with all digits after it
			for (int j = i + 1; j < n; j++) {
				// if digit at position i
				// is less than digit
				// at position j, swap it
				// and check for maximum
				// number so far and recurse
				// for remaining swaps
				if (str[i] < str[j]) {
					// swap str[i] with str[j]
					swap(str, i, j);

					// If current num is more
					// than maximum so far
					String str2 = String.valueOf(str);
					if (str2.compareTo(max) > 0)
						max = str2;

					// recurse of the other k - 1 swaps
					findMaximumNum(str, k - 1);

					// Backtrack It is used to backtrack the swap are no swap is left. To nullify the effect of swap(str, i, j)
					swap(str, i, j);
				}
			}
		}
	}

	private static void swap(char[] c, int i, int j) {
		char ch = c[i];
		c[i] = c[j];
		c[j] = ch;
	}

	// Driver code
	public static void main(String a[]) {
		String str = "1234";

		int k = 4;
		char[] ch = str.toCharArray();
		max = str;
		findMaximumNum(ch, k);
		System.out.print(max);
	}

}
