/*
	Problem: Find Square Root of a Number
	(Return integer part only)

	Approach: Binary Search

	1. Search in range [1, n]
	2. Find mid
	3. If mid * mid <= n:
	      store answer
	      search larger value
	4. Otherwise search smaller value

	Time Complexity: O(log n)
	Space Complexity: O(1)
 */
package BinarySearch.answers;

public class FindSquareRoot {
	public static void main(String[] args) {
		int n = 36;
		System.out.println("square root of n is :" + findSquareRoot(n));
		n = 25;
		System.out.println("square root of n is :" + findSquareRoot(n));
		n = 50;
		System.out.println("square root of n is :" + findSquareRoot(n));

	}

	public static int findSquareRoot(int n) {

		// Square root of 0 or 1 is itself
		if (n == 0 || n == 1)
			return n;

		int low = 1;
		int high = n;

		int ans = 0;

		while (low <= high) {

			int mid = low + (high - low) / 2;

			// Use long to avoid overflow
			long square = (long) mid * mid;

			// Perfect square found
			if (square == n)
				return mid;

			/*
			 * mid can be a possible answer but there may exist a larger valid value
			 */
			if (square < n) {

				ans = mid;
				low = mid + 1;
			}

			// Search smaller values
			else {
				high = mid - 1;
			}
		}

		return ans;
	}

}
