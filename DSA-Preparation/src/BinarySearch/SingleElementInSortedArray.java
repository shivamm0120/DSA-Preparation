/*
		Problem: Find Single Element in Sorted Array
		Approach: Binary Search using index parity

		Observation:
		- Before single element:
		  even index pairs with next element

		- After single element:
		  pairing pattern breaks

		Time Complexity: O(log n)
		Space Complexity: O(1)
 */
package BinarySearch;

public class SingleElementInSortedArray {
	public static void main(String[] args) {
		int []nums1= {1,1,2,2,4,5,5};
		System.out.println("single element is:"+ findSingleElement(nums1));
	}
	public static int findSingleElement(int[] nums) {

		
		        int n = nums.length;

		        // single element array
		        if (n == 1) return nums[0];

		        // first element is single
		        if (nums[0] != nums[1]) return nums[0];

		        // last element is single
		        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

		        int low = 1;
		        int high = n - 2;

		        while (low <= high) {

		            int mid = low + (high - low) / 2;

		            // single element found
		            if (nums[mid] != nums[mid + 1] &&
		                nums[mid] != nums[mid - 1]) {

		                return nums[mid];
		            }

		            // valid pairing pattern
		            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||

		                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {

		                // single element on right side
		                low = mid + 1;
		            }
		            // single element on left side
		            else {

		                high = mid - 1;
		            }
		        }

		        return -1;
		    }
	}

