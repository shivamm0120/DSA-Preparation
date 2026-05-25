/*
Problem: Koko Eating Bananas

Koko can eat at most k bananas per hour.

If a pile has fewer bananas than k,
she finishes that pile within the hour.

Find the minimum eating speed
such that Koko finishes all bananas
within h hours.

Approach: Binary Search on Answer

1. Minimum possible speed = 1
2. Maximum possible speed = maximum pile
3. For every speed:
      calculate total hours required
4. If total hours <= h:
      try smaller speed
5. Else:
      increase speed

Time Complexity: O(n * log(maxPile))
Space Complexity: O(1)
*/
package BinarySearch.answers;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {

		int low = 1;
		int high = piles[0];

		// Find maximum pile
		for (int i = 1; i < piles.length; i++) {
			high = Math.max(high, piles[i]);
		}

		// Binary Search on speed
		while (low <= high) {
			int mid = low + (high - low) / 2;

			// Hours needed at speed mid
			long hours = totalHours(piles, mid);

			// Possible to finish
			if (hours <= h) {
				high = mid - 1;
			}

			// Need higher speed
			else {
				low = mid + 1;
			}
		}

		return low;
	}

	// ------------------------------

	// Calculate total hours needed
	static long totalHours(int[] piles, int speed) {

		long hours = 0;

		for (int bananas : piles) {

			/*
			 * Ceiling division: ceil(a / b)
			 * 
			 * Formula: (a + b - 1) / b
			 */

			hours += (bananas + speed - 1) / speed;
		}

		return hours;
	}
}
