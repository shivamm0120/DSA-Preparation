/*
Problem: Lower Bound =>smallest index such that nums[index]>=target
Approach: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)
*/

package BinarySearch;

public class LowerBound {
	public static void main(String[] args) {
		int [] nums= {3,3,4,7,8,10,13};
		int target =9;
		System.out.println(lowerBound(nums,target));
	}
	static int lowerBound(int [] nums,int target) {
		        int low=0,high=nums.length-1;
		        int ans=nums.length;//if not found then return the actual length

		        while(low<=high){
		            int mid= (low+high)/2;//middle ele
		            
		            if(nums[mid]>=target){//if it is greater it means it can be my ans and also there is a 
		            	                      //chance that we may get lower index so go to left half
		                ans=mid;//update ans 
		                high=mid-1;//left half
		            }
		            else low=mid+1;  //right half
		        }
		        return ans;
		     }
		
		
	

}
