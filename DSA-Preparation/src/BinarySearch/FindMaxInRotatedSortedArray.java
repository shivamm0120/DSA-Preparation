/*
Problem: Find Maximum in Rotated Sorted Array
Approach: Binary Search using sorted half identification

If left half is sorted:
- maximum element of that half is nums[mid]
- update max
- move to right half

Else:
- maximum lies in left half
- move left

Time Complexity: O(log n)
Space Complexity: O(1)
*/
package BinarySearch;

public class FindMaxInRotatedSortedArray {
	public static void main(String []args) {
		int [] nums= {4,5,6,0,1,2,3,4};
		System.out.println("max is :"+ findMax(nums));
		}
		
	
	public static int findMax(int []nums) {
		int low=0;int high=nums.length-1;
		int max=Integer.MIN_VALUE;
		
		while(low<=high) {
			if(nums[low]<nums[high]) {
				return Math.max(max, nums[high]);
			}
			int mid=(low+high)/2;
			
			//when left part is sorted 
			if(nums[mid]>=nums[low]) {
				max=Math.max(max, nums[mid]);
				low=mid+1;
			}
			//right part is sorted ,but maximum will be on left side ,so move high
			else high=mid-1;
		}
		return max;
	}
	

}
