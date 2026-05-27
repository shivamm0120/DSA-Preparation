/*
Problem: Kth Missing Positive Number
Approach: Binary Search

Logic:
missing numbers till index mid =
arr[mid] - (mid + 1)

If missing < k
→ kth missing number lies on right side

Else
→ search on left side

At the end:when we come out of loop ie high>low happened
then answer =>current ele at high + remaining misses 
   
Remaining misses will be => k- missing till high  ie. k-{arr[high]-(high+1)}

so ,ans= arr[high]+ k-{arr[high]-(high+1)}
or, ans= k+high+1      (high+1=>low  since when loop will be terminated low will be 1 index forward)

answer = low + k  <=Need to return this 

Time Complexity: O(log n)
Space Complexity: O(1)
*/

package BinarySearch.answers;

public class KthMissingPositiveNumber {
	public static void main(String[] args) {
		int [] arr= {1,3,4,7,11};
		int k=5;
		System.out.println("missing element :"+findKthPositive(arr,k));
	}
	public static int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            int missing =arr[mid]-(mid+1);
            if(missing<k)low=mid+1;
            else high=mid-1;
        }
        return low+k;
    }


}
