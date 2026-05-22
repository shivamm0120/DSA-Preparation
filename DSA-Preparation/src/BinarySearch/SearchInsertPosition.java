/*
Problem: Search Insert Position
Approach: Binary Search
  This is actually the same problem as lower bound .
  lower bound condition was nums[index]>=target.
  so, index where nums[index]==target will give the actual index where it is present 
  and the nums[index]>target will give the index where it should be inserted

Time Complexity: O(log n)
Space Complexity: O(1)
*/
package BinarySearch;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        while(low<=high){
               
            int index=low+(high-low)/2;
            int mid_value=nums[index];
            if(mid_value==target)return index;
            else if(mid_value<target){
                low=index+1;
            }
            else{
                high=index-1;
            }
        }
        return low;
        
    }

}
