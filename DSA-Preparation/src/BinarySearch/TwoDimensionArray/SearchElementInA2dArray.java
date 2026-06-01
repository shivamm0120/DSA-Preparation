/*Problem- Search element in a 2D array
 *Approach-
 * Treat this 2d array has 1D array
 * so total elements will be m*n (mxn matrix)
 * 
 * Now apply binary search on this -
 *  take low=0,high=m*n-1;
 *  and find mid
 *  
 *  now convert this mid index into its equivalent index of 2D
 *  
 * mid/n=>will give row no
 * mid%n=>will give col no 
 * 
 * 
 */
package BinarySearch.TwoDimensionArray;

public class SearchElementInA2dArray {
	public boolean searchMatrix(int[][] matrix, int target) {

	    int m = matrix.length;      // number of rows
	    int n = matrix[0].length;   // number of columns

	    // Binary search on virtual array of size m*n
	    int low = 0;
	    int high = m * n - 1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;

	        // Convert virtual index to actual matrix coordinates
	        int row = mid / n;
	        int col = mid % n;

	        int value = matrix[row][col];

	        if (value == target) {
	            return true;
	        }
	        else if (value < target) {
	            low = mid + 1;
	        }
	        else {
	            high = mid - 1;
	        }
	    }

	    return false;
	}

}
