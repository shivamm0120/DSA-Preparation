/*
Problem: Count Negative Numbers in a Sorted Matrix

Approach:
Start from top-right corner.
- If current element is negative:
  -> all elements below it are also negative
  -> count them and move left
- Else move downward

Property Used:
Matrix is sorted in non-increasing order
both row-wise and column-wise.

Time Complexity: O(rows + cols)
Space Complexity: O(1)
*/


package Matrix;

public class CountNegativeNumbersInASortedMatrix {
	public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        int row = 0; int col = cols -1;

        int count = 0;

        while(row < rows && col >= 0){
            if(grid[row][col]< 0){
                count += (rows -row);
                col--;
            }else{
                row++;
            }
        }
        return count;
    }

}
