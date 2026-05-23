/*
	Problem: Search in Rotated Sorted Array II
	(Duplicates Allowed)

	Approach: Modified Binary Search

	1. Check boundary elements first
	2. Find mid
	3. If duplicates at low, mid, high:
	      cannot identify sorted half
	      so shrink search space
	4. Otherwise identify sorted half
	5. Check whether target lies inside it

	Time Complexity:
	Average Case : O(log n)
	Worst Case   : O(n)

	Worst case occurs when duplicates
	continuously block identification
	of sorted half.
	At that time we don't reduce search space as n->n/2 -> n/4  ->n/8 ...and soon =>O(logn)
	our search space size reduces as n ->n-2 ->n-4 ...and so on =>so O(n) time complexity 
	

	Space Complexity: O(1)
 */
package BinarySearch;

public class SearchInRotatedSortedArrayIncludingDuplicates {
	public boolean search(int[] nums, int target) {

	    int low = 0;
	    int high = nums.length - 1;

	    while (low <= high) {

	        // Extra optimization:
	        // check boundary elements first  (even it is not recessary to do ,but it will reduce steps)
	        if (nums[low] == target ||
	            nums[high] == target)
	            return true;

	        int mid = low + (high - low) / 2;

	        // Target found at mid
	        if (nums[mid] == target)
	            return true;
	        
	        //duplicates blocks to identify which part is sorted 
	        if (nums[low] == nums[mid] &&
	            nums[mid] == nums[high]) {

	            low++;
	            high--;
	            continue;
	        }

	        // Left half sorted
	        if (nums[low] <= nums[mid]) {

	            // Target lies in left half
	            if (target >= nums[low] &&
	                target < nums[mid]) {

	                high = mid - 1;
	            }

	            // Search right half
	            else {
	                low = mid + 1;
	            }
	        }

	        // Right half sorted
	        else {
	        	
	            // Target lies in right half
	            if (target > nums[mid] &&
	                target <= nums[high]) {
	                low = mid + 1;
	            }
	            // Search left half
	            else {
	                high = mid - 1;
	            }
	        }
	    }
	    return false;
	}
}


/*
	        Duplicates block identification
	        of sorted half

	        Example:
	        [1,1,1,1,2,1,1]
 */