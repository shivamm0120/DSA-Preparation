/*
Problem: Find How Many Times a Sorted Array is Rotated
Approach: Binary Search to find minimum element index

The index of the minimum element
= number of rotations

Time Complexity: O(log n)
Space Complexity: O(1)
*/
package BinarySearch;

public class HowManyTimesArrayRotated {
	public static void main(String[] args) {
		int []nums1= {5,6,7,0,2,3};
		System.out.println("no of times array rotated is:"+rotateTimes(nums1));
		
		int []nums2= {1,2,4,5,8};
		System.out.println("no of times array rotated is:"+rotateTimes(nums2));
		
		int []nums3= {5,6,0,1,2,3,4};
		System.out.println("no of times array rotated is:"+rotateTimes(nums3));
		
	}

	public static int rotateTimes(int[] nums) {

	    int low = 0;
	    int high = nums.length - 1;

	    int ans = Integer.MAX_VALUE;
	    int index=-1;

	    while (low <= high) {

	        // Entire range sorted--optimization
	        // smallest element is at low
	        if (nums[low] <= nums[high]) {
	        	    //update ans and index
	            if(ans>nums[low]) {
	            	   ans=nums[low];
	            	   index=low;
	            }
	            break;
	        }

	        int mid = low + (high - low) / 2;

	        // Left half sorted
	        if (nums[low] <= nums[mid]) {
	        	//update ans and index
	        	     if(ans>nums[low]) {
	        	    	     ans=nums[low];
	        	    	     index=low;
	        	     }
	        	     // minimum lies in right half
	        	     low = mid + 1;
	        }

	        

	        // Right half sorted
	        else {
	        		
	        	//update ans and index
	        		if(ans>nums[mid]) {
	        			ans=nums[mid];
	        			index=mid;
	        		}
	        			
	        		// minimum lies in left half
	        		high = mid - 1;
	        		}

	    }

	    return index;
	}

}
