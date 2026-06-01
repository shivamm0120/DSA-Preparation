/*Problem-Peak element in a 2D array
 * 
 *Given an m x n matrix mat where:
 *  No two adjacent cells are equal.
 *  A peak element is an element strictly greater than its top, bottom, left, and right neighbors.
 *  Return the position [row, col] of any peak element.
 *  
 *  Intuition
 *  =========
 *Instead of checking every cell:

 *Pick the middle column.
*Find the maximum element in that column.
*Compare it with its left and right neighbors.
*If it is greater than both ⇒ Peak found.
*Otherwise move towards the larger neighbor because a peak must exist there.

*This is similar to 1D Peak Element where we move towards the increasing side.
 * 
 */
package BinarySearch.TwoDimensionArray;

public class PeakElementIn2DArray {
	public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // Binary search on columns
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find row index having maximum value in current column
            int row = findMax(mat, m, mid);

            int current = mat[row][mid];

            // Left neighbour
            int left = (mid > 0) ? mat[row][mid - 1] : -1;

            // Right neighbour
            int right = (mid < n - 1) ? mat[row][mid + 1] : -1;

            // Current element is greater than both neighbours
            // Hence it is a peak
            if (current > left && current > right) {
                return new int[] { row, mid };
            }

            // Larger element exists on right side
            // So peak must exist on right half
            if (current < right) {
                low = mid + 1;
            }

            // Larger element exists on left side
            // So peak must exist on left half
            else {
                high = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }

    // Returns row index of maximum element in a column
    private int findMax(int[][] mat, int m, int col) {

        int maxRow = 0;

        for (int i = 1; i < m; i++) {

            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }

        return maxRow;
    }

}
