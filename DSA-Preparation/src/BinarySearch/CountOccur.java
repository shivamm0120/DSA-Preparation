/* problem-count occurences of a given number in a sorted array
 *  Approach -
 *   2 Approaches -
 *   
 *   	1.using upper bound and lower bound 
 *            count =upperbound(x)-lowerbound(x)
 *     
 *   	2.using first occur and last occur 
 *           count =lastOccur-firstoccurIndex +1
 *     
 *  Time Complexity: O(log n)
 *	Space Complexity: O(1)   
 * 
 */
package BinarySearch;

public class CountOccur {
	public int occurCount(int[] nums, int target) {

	    int first = firstOccur(nums, target);
	    
	    if (first==nums.length ||first==-1)return 0;//check if the target doesnot present 
	                                               //if first does not exist then last also ,thats why place this check
	                                               //before lastOccur()
	    
	    int last = lastOccur(nums, target);
	    
	    return last-first+1;

	    
	}

	int firstOccur(int[] nums, int target) {

	    int low = 0, high = nums.length - 1;
	    int first = -1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;

	        if (nums[mid] == target) {
	            first = mid;      // store answer
	            high = mid - 1;   // search left side
	        }
	        else if (nums[mid] < target) {
	            low = mid + 1;
	        }
	        else {
	            high = mid - 1;
	        }
	    }

	    return first;
	}

	int lastOccur(int[] nums, int target) {

	    int low = 0, high = nums.length - 1;
	    int last = -1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;

	        if (nums[mid] == target) {
	            last = mid;      // store answer
	            low = mid + 1;   // search right side
	        }

	        else if (nums[mid] < target) {
	            low = mid + 1;
	        }

	        else {
	            high = mid - 1;
	        }
	    }

	    return last;
	}
	

}
