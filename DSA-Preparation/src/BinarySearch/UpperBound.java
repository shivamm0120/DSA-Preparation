/*
Problem: upper Bound =>smallest index such that nums[index]>target
Approach: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)
*/
package BinarySearch;

public class UpperBound {
	public static void main(String[] args) {
		int [] nums= {3,3,4,7,8,10,13};
		int target =9;
		System.out.println(upperBound(nums,target));
	}
	static int upperBound(int [] nums,int target) {
		        int low=0,high=nums.length-1;
		        int ans=nums.length;//if not found then return the actual length

		        while(low<=high){
		            int mid= (low+high)/2;//middle ele
		            
		            if(nums[mid]>target) { //upper bound condition
		            	   ans=mid; //update ans
		            	   high=mid-1;//go to left half to check if there is index which satisfies upperbound condition
		            }
		            else  //either nums[mid]==target or less than target ,we need to move right half
		            	   low=mid+1;
		           
		        }
		        return ans;
		     }
		
	

}
