/*Problem - Largest Rectangle in Histogram-Leetcode 84
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
 * return the area of the largest rectangle in the histogram.
 * 
 * T.C=O(n)
 * S.C=O(2n) for arrays and O(n) for stacks
 * 
 */
package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {
	public int largestRectangleArea(int[] heights) {

        int [] prevSmaller=findPrevSmaller(heights);
        int [] nextSmaller=findNextSmaller(heights);

        int max=0;
        for(int i=0;i<heights.length;i++){
        	  //compute total area formed by this 
        	  //similar to subarrays minimums -find how many times this will contribute into area.
            int area= (nextSmaller[i]-prevSmaller[i]-1) *heights[i];
            //update max when we got bigger areas
            max=Math.max(max,area);
        }
        return max;

        
    }
	//find prev smaller
    int[] findPrevSmaller(int []heights){
        int n=heights.length;
        int []prev= new int[n];
        Deque<Integer>stack= new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();
            }
           prev[i]= stack.isEmpty() ?-1:stack.peek();
           stack.push(i);

        }
        return prev;

    }
    //find next smaller
    int[] findNextSmaller(int []heights){
        int n=heights.length;
        int []next= new int[n];
        Deque<Integer>stack= new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();
            }
            next[i]=stack.isEmpty()? n:stack.peek();
            stack.push(i);

        }
        return next;

    }

}
