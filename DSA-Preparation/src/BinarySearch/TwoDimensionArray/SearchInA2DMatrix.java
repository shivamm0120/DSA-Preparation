/*Problem-Search In A 2D Matrix II
 * ==================================
 * 
 *  This matrix has the following properties:
 *   1.Integers in each row are sorted in ascending from left to right.
 *   2.Integers in each column are sorted in ascending from top to bottom.
 * 
 *  Approach:
 *  Brute:
 *  =====
 *      simply go to each row visiting each ele.if its equal to target just return true.
 *      T.C=>O(m*n)
 *  Better
 *  ===== 
 *     we can apply binary search in every row 
 *     so time complexity will be O(m *logn)
 *  Optimal :
 *  =========
 *      Start from right top corner/bottom left corner.
 *       lets take right top corner ie. row=0 and col=n-1;
 *      why? bcz from that index we will be able to identify that should we move bottom or left 
 *      
 *       So,At every index 
 *        if(element==target )return true
 *        if(element<target)=>means we can eliminate left and move bottom ie .row++;      
 *       else col-- =>means element is bigger than target ,we can eliminate bottom
 *       
 *   T.C :At worst time we will reach at bottom left 
 *    so time complexity will be O(m+n) =>we are moving entire row and entire col
 *       
 *  
 */
package BinarySearch.TwoDimensionArray;

public class SearchInA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {

	    int m = matrix.length;
	    int n = matrix[0].length;

	    // Start from top-right corner
	    int row = 0;
	    int col = n - 1;

	    // Continue until we go out of matrix bounds
	    while (row < m && col >= 0) {

	        // Current element
	        int current = matrix[row][col];

	        // Target found
	        if (current == target) {
	            return true;
	        }
	        
	        // Current element is too large
	        // Entire column below will also be larger
	        // So move left
	        else if (current > target) {
	            col--;
	        }

	        // Current element is too small
	        // Entire row on the left will also be smaller
	        // So move down
	        else {
	            row++;
	        }
	    }
	    // Target not present
	    return false;
	}
}
