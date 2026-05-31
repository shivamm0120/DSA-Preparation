/*
-------------------------------------------------------
Problem : Median of Two Sorted Arrays
-------------------------------------------------------

Given two sorted arrays nums1 and nums2 of sizes m and n,
return the median of the combined sorted array.

The required time complexity is O(log(min(m,n))).

-------------------------------------------------------
Approach : Binary Search on Smaller Array
-------------------------------------------------------

1. Perform binary search on the smaller array to reduce
   the search space.

2. Partition both arrays such that:
      Left Half  -> contains (m+n+1)/2 elements
      Right Half -> contains remaining elements

3. Let:
      l1 = last element on left side of nums1
      r1 = first element on right side of nums1

      l2 = last element on left side of nums2
      r2 = first element on right side of nums2

4. A partition is valid when:
      l1 <= r2  &&  l2 <= r1

   This guarantees that every element in the left half
   is less than or equal to every element in the right half.

5. Once a valid partition is found:

   - Odd total elements:
         Median = max(l1, l2)

   - Even total elements:
         Median = (max(l1,l2) + min(r1,r2)) / 2

6. If l1 > r2:
      Move partition left in nums1.  ie.high=mid-1;

   Else:
      Move partition right in nums1.  ie.low=mid+1;

-------------------------------------------------------
Time Complexity  : O(log(min(m,n)))
Space Complexity : O(1)
-------------------------------------------------------
*/
package BinarySearch.answers;

public class MedianOfSortedArray {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int n1= nums1.length;
	        int n2= nums2.length;

	        if(n1>n2)return findMedianSortedArrays(nums2,nums1);//i want nums1 must be smaller 
	        
	        int left=(n1+n2+1)/2;//no of elements in left part of symmetry

	        int n=n1+n2;//total elements
	        	
	        //either choose 0 ele or less than equal to n1 from nums1
	        int low=0;int high=n1;

	        while(low<=high){
	            int mid1=(high+low)/2;//take mid1 ele from nums1
	            int mid2=left-mid1;//take mid2 ele from nums2

	            //initializing var with boundaries
	            int l1=Integer.MIN_VALUE;
	            int l2=Integer.MIN_VALUE;
	            int r1=Integer.MAX_VALUE;
	            int r2=Integer.MAX_VALUE;

	            //right elements of symmetry line 
	            if(mid1<n1) r1=nums1[mid1];
	            if(mid2<n2) r2=nums2[mid2];

	            //left elements of symmetry
	            if(mid1-1>=0)l1=nums1[mid1-1];
	            if(mid2-1>=0)l2=nums2[mid2-1];

	            //valid configuration
	            if(l1<=r2 && l2<=r1){
	            	
	                if(n%2==0)
	                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0; //for even
	                else return Math.max(l1,l2);//for odd
	            }

	            if(l1>r2)high=mid1-1;//try picking lesser elements
	            if(l2>r1)low=mid1+1;//try picking more elements from nums1

	        } 
	        return 0;
	    }
}
