/*Problem statement- Maximal Rectangle 
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest 
 * rectangle containing only 1's and return its area.
 * 
 * Intuition 
 * =========
 * if it was 1D then we already solved histogram problem
 * so if we convert this into 1D we can solve it using histogram approach
 * 
 * In others words ,we already know the largest rectangle in a row.
 * we just need to find a way that helps to compute columns rectangle also 
 * 
 * convert every row into a histogram 
 * maintain heights of histogram -
 *  if column value is 1 then increase height
 *  if column value is 0 reset its height to zero
 *  
 *  now once we got the histogram heights we can solve using the histogram problem
 * 
 * Time Complexity
 * ===============
 *Suppose rows= m, cols=n
 *
 *for every row :
 * update heights->O(n)
 * Largest Rectangle in histogram ->O(n)
 * 
 *  Tc=O(m*n)
 *  
 * space
 * ====
 * O(n)
 * 
 * 
 * 
 * 


Rows = m
Columns = n

For every row

Update heights → O(n)
Largest Rectangle in Histogram → O(n)
 * 
 */
package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        int rows= matrix.length;
        int cols= matrix[0].length;

        int[] heights= new int [cols];
        int maxArea=0;

        for(int i=0;i<rows;i++){
            //for each row convert into histogram problem and find largest rectangle
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }
                else heights[j]=0;
            }
           //calling largestRectangleArea() 
            maxArea= Math.max(maxArea, largestRectangleArea(heights));


        }
        return maxArea;


        
    }
     public int largestRectangleArea(int[] heights) {

        int [] prevSmaller=findPrevSmaller(heights);
        int [] nextSmaller=findNextSmaller(heights);

        int max=0;
        for(int i=0;i<heights.length;i++){
            int area= (nextSmaller[i]-prevSmaller[i]-1) *heights[i];

            max=Math.max(max,area);
        }
        return max;

        
    }
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
