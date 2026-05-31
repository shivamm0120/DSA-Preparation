/*
	-------------------------------------------------------
	Problem : Kth Element of Two Sorted Arrays
	-------------------------------------------------------

	Given two sorted arrays, find the kth smallest element
	in their combined sorted order.

	-------------------------------------------------------
	Approach : Binary Search on Smaller Array
	-------------------------------------------------------

	1. Always binary search on the smaller array.

	2. Create a partition such that:
	      left part contains exactly k elements.

	3. Let:
	      mid1 = elements taken from array a
	      mid2 = k - mid1 (from array b)

	4. Valid partition:
	      l1 <= r2 && l2 <= r1

	   If valid, kth element = max(l1, l2).

	5. If l1 > r2:
	      take fewer elements from a (move left).

	   Else:
	      take more elements from a (move right).

	6. Search range:
	      low  = max(0, k - n2)
	      high = min(k, n1)

	   This ensures 0 <= mid2 <= n2.

	-------------------------------------------------------
	Time Complexity  : O(log(min(n1, n2)))
	Space Complexity : O(1)
	-------------------------------------------------------
 */
package BinarySearch.answers;

public class KthElementOfTwoSortedArray {
	    public int kthElement(int[] a, int[] b, int k) {

	        // Always binary search on smaller array
	        if (a.length > b.length)
	            return kthElement(b, a, k);

	        int n1 = a.length;
	        int n2 = b.length;

	        if (k > n1 + n2)
	            return -1;

	        int low = Math.max(0, k - n2);
	        int high = Math.min(k, n1);

	        while (low <= high) {

	            // Elements taken from a and b
	            int mid1 = (low + high) / 2;
	            int mid2 = k - mid1;

	            // Left and right boundary elements
	            int l1 = Integer.MIN_VALUE;
	            int l2 = Integer.MIN_VALUE;
	            int r1 = Integer.MAX_VALUE;
	            int r2 = Integer.MAX_VALUE;

	            if (mid1 > 0) l1 = a[mid1 - 1];
	            if (mid2 > 0) l2 = b[mid2 - 1];

	            if (mid1 < n1) r1 = a[mid1];
	            if (mid2 < n2) r2 = b[mid2];

	            // Valid partition found
	            if (l1 <= r2 && l2 <= r1)
	                return Math.max(l1, l2);

	            // Too many elements taken from a
	            if (l1 > r2)
	                high = mid1 - 1;

	            // Too few elements taken from a
	            else
	                low = mid1 + 1;
	        }

	        return -1 ; 
	    }
}
