/*
	Problem: Find Minimum in Rotated Sorted Array

	Approach:
	1. One half is always sorted
	2. Minimum always lies in unsorted half
	3. If current range already sorted,
	   nums[low] is the minimum

	Time Complexity: O(log n)
	Space Complexity: O(1)
 */
package BinarySearch;

public class MinimumInRotatedSortedArray {

	public int findMin(int[] nums) {

	    int low = 0;
	    int high = nums.length - 1;

	    int ans = Integer.MAX_VALUE;

	    while (low <= high) {

	        // Entire range sorted
	        // smallest element is at low
	        if (nums[low] <= nums[high]) {
	            ans = Math.min(ans, nums[low]);
	            break;
	        }

	        int mid = low + (high - low) / 2;

	        // Left half sorted
	        if (nums[low] <= nums[mid]) {

	            // nums[low] can be minimum
	            ans = Math.min(ans, nums[low]);

	            // minimum lies in right half
	            low = mid + 1;
	        }

	        // Right half sorted
	        else {

	            // nums[mid] can be minimum
	            ans = Math.min(ans, nums[mid]);

	            // minimum lies in left half
	            high = mid - 1;
	        }
	    }

	    return ans;
	}

}
