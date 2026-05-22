package BinarySearch;

public class BinarySearchRecursiveApproach {
	
	public int search(int[] nums, int target) {
       return binarySearch(nums,target,0,nums.length-1);
    }
	
	
	int binarySearch(int []nums,int target,int low,int high) {
		if(low>high)return -1;//Base case:when element not found
		
		int mid=(low+high)/2;//mid index
		
		if(nums[mid]==target)return mid; // If target is found at mid
		
		else if(nums[mid]<target)return binarySearch(nums,target,mid+1,high);
		return binarySearch(nums,target,low,mid-1);
		
		
	}

}
