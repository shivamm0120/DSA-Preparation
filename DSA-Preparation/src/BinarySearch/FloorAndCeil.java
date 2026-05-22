/*
	Problem: Find Floor and Ceil in Sorted Array
	Approach: Binary Search

	Floor -> largest element <= x
	Ceil  -> smallest element >= x

	Time Complexity: O(log n)
	Space Complexity: O(1)
 */
package BinarySearch;

public class FloorAndCeil {

	public int[] getFloorAndCeil(int[] nums, int x) {

	    int floor = -1, ceil = -1;

	    // Find Floor
	    int low = 0, high = nums.length - 1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;

	        if (nums[mid] <= x) {
	            floor = nums[mid];   // possible floor
	            low = mid + 1;       // try finding larger valid value
	        } else {
	            high = mid - 1;
	        }
	    }

	    // Find Ceil
	    low = 0;
	    high = nums.length - 1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;

	        if (nums[mid] >= x) {
	            ceil = nums[mid];    // possible ceil
	            high = mid - 1;      // try finding smaller valid value
	        } else {
	            low = mid + 1;
	        }
	    }

	    return new int[]{floor, ceil};
	}

}
