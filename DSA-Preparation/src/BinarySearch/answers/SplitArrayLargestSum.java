/*
Problem: split array into k subarrays such that sum of maximum subarray is minimized
	       or find min(max sum of any subarray)
	       
 Approach :
	  Low= largest element of that array
	  High= sum of all  the elements
	  
   1.Brute force :
       start a loop from low to high .
       for every i : find countSubarray 
         if this countsubarray gives more than k then we need to keep moving in loop
         if this is less or equal just return the i value 
  2.As there is a range low ->high  so we can apply binary search 
  
       for every mid :
         if (countSub()>k) =>try greater mid
         else try smaller 

	Time Complexity: O(n * log(sumOfElements-Max))
	Space Complexity: O(1)
 */
package BinarySearch.answers;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int k) {
		// Not enough elements to create k non-empty subarrays
		if (nums.length < k)
			return -1;

		// -----------------------------------------
		// Search space:
		// low = largest element in array
		// high = sum of all elements
		// -----------------------------------------
		int low = nums[0];
		int high = 0;

		for (int num : nums) {
			low = Math.max(low, num);
			high += num;
		}

		// -----------------------------------------
		// Binary search on answer
		// -----------------------------------------
		while (low <= high) {

			int mid = low + (high - low) / 2;

			// Minimum subarrays needed if
			// maximum allowed subarray sum = mid
			int subArrays = countSub(nums, mid);

			// Feasible:
			// We can form k or fewer subarrays
			if (subArrays <= k) {
				high = mid - 1; // Try smaller answer
			}

			// Not feasible:
			// Need more than k subarrays
			else {
				low = mid + 1; // Increase allowed sum
			}
		}

		// low points to the smallest feasible answer
		return low;
	}

	// -------------------------------------------------
	// Returns minimum number of subarrays required
	// when no subarray sum can exceed sumLimit
	// -------------------------------------------------
	public static int countSub(int[] nums, int sumLimit) {

		int count = 1; // First subarray
		int sum = 0;

		for (int num : nums) {

			// Current element cannot fit in current subarray
			if (sum + num > sumLimit) {

				count++; // Start new subarray
				sum = num; // Put current element in it
			} else {
				sum += num; // Continue current subarray
			}
		}

		return count;
	}
}
