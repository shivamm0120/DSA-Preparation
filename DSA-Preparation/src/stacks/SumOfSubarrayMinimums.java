/*Problem -Sum of subarray minimums 
 * 
 * Brute force:
 * ============
 * Try all the subarrays and maintain a min variable through each subarray.
 * then add it to ans.
 * TC:O(n2)
 * Sc:O(1)
 * 
 * Optimized approach
 * ===================
 * Idea :For each element try to find in how many subarrays this element is the minimum.
 * 
 * To do this we will need previous smaller value and next smaller value .
 * why? 
 * Bcz lets suppose b...a....c is the subarray .
 * Now for a ,b is the previous smallere and c is the next smaller .
 * 
 * So if u need a subarray in which a is minimum ,then b should not be present in that subarray.
 * similarly c also should not be there bcz these 2 are smaller than a.So,a can't be min if anyone is 
 * present.
 * 
 * Now just find no of subarrays in left side of a :we can get it by previous smaller =>here store index not value.
 *    =>index of b - index of a 
 *    
 * Similarly in right side ,no of subarray will be :index of c -index of a
 * 
 *    
 * Total subarrays= no of left subarrays *no of right subarrays
 * 
 * means a is minimum in this total subarrays.
 * contribution in the ans = a*toal no of subarrays
 * 
 * do it for each element .after thar return ans/sum.
 * 
 * Edge cases:
 * ==========
 * for next smaller if there is no any element then take it n ..not -1.
 * By taking 'n' u can get no of subarrays in right where a is min.
 * ie .=> (n-index of a )   where n is the array length
 * 
 * 
 * TC:
 * ==
 *  find nse:O(n) =>every element is pushed 1 time and popped at max 1 time.
 *  find pse:O(n)
 *  calculate sum:O(n)
 *  
 *  total=O(3n)=O(n)
 *SC:
 *===
 *left[]->O(n)
 *right[]->O(n)
 *stack->O(n)
 * 
 */
package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums {
	public static void main(String[] args) {
		int []arr= {3,1,4,2};
		System.out.println(sumSubarrayMins(arr));
		
	}
	 public static int sumSubarrayMins(int[] arr) {
	        int n=arr.length;long sum=0;
	        int mod=(int)1e9 +7;
	 
	        //use deque in place of stack bcz stack is synchronized
	        Deque<Integer> stack = new ArrayDeque<>();

	        int []left = findPrevSmaller(arr,stack);
	        stack.clear();
	        int []right = findNextSmaller(arr,stack);
	        
	        for(int i=0;i<n;i++){
	            left[i]=i-left[i];
	            right[i]-=i;

	            sum=(sum+1L*arr[i]*left[i]*right[i])%mod;

	        }
	        return (int)sum;
	    }
	  static  int[] findPrevSmaller(int []arr,Deque<Integer>stack){
	    int []left= new int [arr.length];
	    
	    for(int i=0;i<arr.length;i++){
	        while(!stack.isEmpty()&& arr[stack.peek()]>arr[i])
	           stack.pop();

	        left[i]=stack.isEmpty()?-1:stack.peek();
	        stack.push(i);
	    }
	    return left;
	   }
	   
	  static int [] findNextSmaller(int []arr,Deque<Integer>stack){
	     int []right= new int [arr.length];
	     for(int i=arr.length-1;i>=0;i--){
	        while(!stack.isEmpty()&& arr[stack.peek()]>=arr[i])
	           stack.pop();

	        right[i]= stack.isEmpty()?arr.length:stack.peek();
	        stack.push(i);
	     }
	    return right;
	   }

}
