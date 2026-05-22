//iterative approach
package BinarySearch;

public class BinarySearch {
	public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        while(low<=high) {
        	
            int mid=(low+high)/2;//find middle element 
            
            if(nums[mid]==target)return mid; //target found
            else if(nums[mid]>target) { //search in left half
                high=mid-1;
            }
            else low=mid+1;//search in right half
        }
        return -1;

        
    }

}

/*Note:
 * 1)Other way to find mid index:
 *        mid=low+(high-low)/2;
 *   Use this syntax in case of int overflow
 * 
 * 2)other looping condition for binary search:
 * 
 *    while((high-low)>1){  //means minimum 2 element will be there in search space
 *     //same as above 
 *     }   
 *    if(nums[low]==target)return low;
 *    if(nums[high]==target)return high;
 *    
 *    //so here after termination of loop we need to check at low index and high index
 *    
 *    Above loop condition solves the issues of infinite loop.
 *    Used in many hard problems
 *   
 *    */
