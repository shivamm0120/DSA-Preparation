//same as nextgreater element 1 but there is one addition in that array is circular array.

/*
 * Problem Statement

Given a circular integer array nums, return an array where each element is the next greater element 
of the corresponding element in nums. If no greater element exists, return -1 for that position.

Approach

Since the array is circular, an element's next greater value may appear at the 
beginning of the array. To simulate this, traverse the array twice from right to left.

Initialize a monotonic decreasing stack.
Traverse from index 2n - 1 down to 0.
Use i % n to access the actual index in the array.
While the stack contains elements smaller than or equal to the current element, pop them.
During the second half of the traversal (i < n), the top of the stack (if present) is the next greater element;
otherwise, store -1.
Push the current element onto the stack.

Traversing twice ensures every element gets a chance to find a greater element even after wrapping around.

Time Complexity
================
Each element is pushed and popped at most once.

Overall Time Complexity: O(n)

Space Complexity
================
Stack: O(n)
Output array: O(n) 

Auxiliary Space Complexity: O(n)
 */
package stacks;

import java.util.Stack;

public class NextGreaterElement2 {
	public static void main(String[] args) {
		int []nums= {1,3,2,5,9,0,4};
		int [] ans = nextGreaterElements(nums);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
		
	}
	public static int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int [] nextGreater= new int [n];

        Stack <Integer>stack= new Stack<>();
        int x=2;
        
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(i<n){
           nextGreater[i]= stack.isEmpty()?-1:stack.peek();
            }
           stack.push(nums[i%n]);
           
        }
    
        return nextGreater;
        
    }

}
