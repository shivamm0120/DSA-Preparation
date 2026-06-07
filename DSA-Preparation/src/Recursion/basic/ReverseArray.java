package Recursion.basic;

public class ReverseArray {
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};
		
		reverse(nums,0,nums.length);
		for(int num:nums) {
			System.out.println(num);
		}
		
	}
	static void reverse(int[] nums,int i,int n) {
		if(i==n/2)return;
		int t=nums[i];
		nums[i]=nums[n-1-i];
		nums[n-1-i]=t;
		
		reverse(nums,i+1,n);
		
	}

}
