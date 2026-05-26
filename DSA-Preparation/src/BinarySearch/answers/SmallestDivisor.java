/*
 * Problem: Find the Smallest Divisor Given a Threshold Approach: Binary Search
 * on Answer
 * 
 * We apply binary search on possible divisor values. - Minimum divisor can be 1
 * - Maximum divisor can be max element of array
 * 
 * For every divisor: - Calculate sum of ceil(nums[i] / divisor) - If sum <=
 * threshold: divisor is valid, try smaller divisor - Else: increase divisor
 * 
 * Time Complexity: O(n * log(max(nums))) Space Complexity: O(1)
 */
package BinarySearch.answers;

public class SmallestDivisor {


	public int smallestDivisor(int[] nums, int threshold) {

		// ---------------------------------
		// Search space for divisor
		// ---------------------------------
		int low = 1;
		int high = nums[0];

		// Find maximum element
		for (int num : nums) {
			high = Math.max(high, num);
		}

		// ---------------------------------
		// Binary Search
		// ---------------------------------
		while (low <= high) {
			int mid = low + (high - low) / 2;

			// Find required sum using current divisor
			int sum = findSum(nums, mid);

			// Valid divisor found
			if (sum <= threshold) {
				high = mid - 1; // Try smaller divisor
			}

			// Divisor too small
			else {
				low = mid + 1;
			}
		}
		// Smallest valid divisor
		return low;
	}

	// ---------------------------------
	// Calculates:
	// ceil(nums[i] / divisor) sum
	// ---------------------------------
	static int findSum(int[] nums, int divisor) {
		int sum = 0;
		for (int num : nums) {

			// Ceil division formula
			sum += (num + divisor - 1) / divisor;
		}
		return sum;
	}
}
