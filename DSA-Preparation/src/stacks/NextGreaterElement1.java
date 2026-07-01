/*Problem Statement

Given two integer arrays nums1 and nums2, where nums1 is a subset of nums2, 
find the next greater element for each element in nums1. 
The next greater element is the first greater value that appears to its right in nums2. If no such element exists, return -1.

Approach
========
Brute force :The brute-force approach would be to search for the next greater element of every number 
in nums1 by scanning nums2, resulting in O(n × m) time.

Use a monotonic decreasing stack along with a mapping array.

Traverse nums2 from left to right.
Maintain a decreasing stack.
Whenever the current element is greater than the stack's top, 
it is the next greater element for the top element. 
Store this mapping in the array and pop the stack.

Push the current element onto the stack.

Traverse nums1 and retrieve the mapped next greater element for each value.

Time Complexity
===============
Processing nums2: O(n)
Building the answer for nums1: O(m)

Overall: O(n + m)

Space Complexity
================
Stack: O(n)
Mapping array: O(k) (k = size of the mapping array)

Auxiliary Space: O(n + k)
 * 
 */
package stacks;

import java.util.Stack;

class NextGreaterElement1 {
	public static void main(String[] args) {
		int [] nums1= {2,3,1};
		int [] nums2 = {1,7,2,5,3,9};
		
		int [] ans = nextGreaterElement(nums1, nums2);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
    
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int [] nextGreater= new int [10001];

        Stack <Integer>stack= new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
           nextGreater[nums2[i]]= stack.isEmpty()?-1:stack.peek();
           stack.push(nums2[i]);
        }
        
        for(int i=0;i<nums1.length;i++){
            nums1[i]=nextGreater[nums1[i]];
        }
        return nums1;
    }
}
