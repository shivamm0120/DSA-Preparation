package Array;

public class SetMatrixZeroes {
	//Brute force
//	public void setZeroes(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        // Step 1: Mark rows and columns
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (matrix[i][j] == 0) {
//                    markRow(matrix, i, m);
//                    markCol(matrix, j, n);
//                }
//            }
//        }
//
//        // Step 2: Convert all -1 into 0
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (matrix[i][j] == -1) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }
//
//    static void markRow(int[][] matrix, int row, int m) {
//        for (int j = 0; j < m; j++) {
//            if (matrix[row][j] != 0) {
//                matrix[row][j] = -1;
//            }
//        }
//    }
//
//    static void markCol(int[][] matrix, int col, int n) {
//        for (int i = 0; i < n; i++) {
//            if (matrix[i][col] != 0) {
//                matrix[i][col] = -1;
//            }
//        }
//    }
	
	/*Time complexity:O((m*n)*(m+n)) ~O(n^3)
	 * space :O(1) no extra space 
	 * 
	 */

	//BETTER APPROACH:
	//Instead of immediately making rows and columns zero when we find a 0, 
	//we remember which rows and columns need to become zero.
	//Need 2 Arrays
	
//	 public void setZeroes(int[][] matrix) {
//
//	        int n = matrix.length;
//	        int m = matrix[0].length;
//
//	        int[] row = new int[n];
//	        int[] col = new int[m];
//
//	        // Mark rows and columns
//	        for (int i = 0; i < n; i++) {
//	            for (int j = 0; j < m; j++) {
//
//	                if (matrix[i][j] == 0) {
//	                    row[i] = 1;
//	                    col[j] = 1;
//	                }
//	            }
//	        }
//
//	        // Set zeroes
//	        for (int i = 0; i < n; i++) {
//	            for (int j = 0; j < m; j++) {
//
//	                if (row[i] == 1 || col[j] == 1) {
//	                    matrix[i][j] = 0;
//	                }
//	            }
//	        }
//	    }
	
	//OPTIMAL APPROACH:
//	Intuition:
//	In the better approach, we used two arrays:
//
//	row[]
//	col[]
//
//	Instead of creating these arrays, we notice something:
//
//	The first row itself can store the column markers, and the first column itself can store the row markers.
//
//	So we reuse the matrix itself as our marker array.
//
//	The Problem?
//
//	What if the original first row or first column already contained a zero?
//	matrix[0][0]cant represent both ..so here we need one xtra variable col0 that means 
//	col0 should be all zeroes.	
	
	 public void setZeroes(int[][] matrix) {

	        int n = matrix.length;
	        int m = matrix[0].length;

	        int col0 = 1;

	        // Step 1: Mark rows and columns
	        for (int i = 0; i < n; i++) {

	            if (matrix[i][0] == 0)
	                col0 = 0;

	            for (int j = 1; j < m; j++) {

	                if (matrix[i][j] == 0) {
	                    matrix[i][0] = 0;
	                    matrix[0][j] = 0;
	                }
	            }
	        }

	        // Step 2: Fill the matrix using markers
	        for (int i = 1; i < n; i++) {

	            for (int j = 1; j < m; j++) {

	                if (matrix[i][0] == 0 || matrix[0][j] == 0)
	                    matrix[i][j] = 0;
	            }
	        }

	        // Step 3: First row
	        //Why we chose to update 'first row' first .?why not first col ?
	        //bcz if u update 'first coln' first then due to col0 variable it might be all zeroes
	        //when col0 value is 0 but if lets suppose matrix[0][0] was 1 and due to col0 it will be updated to 0 
	        //then it will make all the ele of first row  as 0's,---> wrong result.
	        if (matrix[0][0] == 0) {
	            for (int j = 0; j < m; j++)
	                matrix[0][j] = 0;
	        }

	        // Step 4: First column
	        if (col0 == 0) {
	            for (int i = 0; i < n; i++)
	                matrix[i][0] = 0;
	        }
	    }
	

}
