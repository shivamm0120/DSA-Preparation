/*
Problem: Search in Rotated Sorted Array
Approach: Modified Binary Search

At every step:
1. Find mid
2. Check which half is sorted(left part or right part)
3. Decide whether target lies in that sorted half

Time Complexity: O(log n)
Space Complexity: O(1)
*/
package BinarySearch;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {

	    int low = 0;
	    int high = nums.length - 1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;

	        // Target found
	        if (nums[mid] == target)
	            return mid;

	        // Left half is sorted
	        if (nums[low] <= nums[mid]) {

	            // Target lies in left half
	            if (target >= nums[low] && target < nums[mid]) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }

	        }
	        // Right half is sorted
	        else {

	            // Target lies in right half
	            if (target > nums[mid] && target <= nums[high]) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	    }

	    return -1;
	}

}
