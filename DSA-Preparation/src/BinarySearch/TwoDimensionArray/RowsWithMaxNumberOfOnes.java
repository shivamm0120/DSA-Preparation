package BinarySearch.TwoDimensionArray;

public class RowsWithMaxNumberOfOnes {
	public int rowWithMax1s(int[][] mat) {

	    int m = mat.length;      // number of rows
	    int n = mat[0].length;   // number of columns

	    int maxCount = 0;        // maximum 1s found so far
	    int index = -1;          // row index having maximum 1s

	    // Traverse each row
	    for (int i = 0; i < m; i++) {

	        // Find index of first 1 using Binary Search
	        int firstOneIndex = findLowerBound(mat[i]);

	        // Number of 1s = total columns - first 1 position
	        int count = n - firstOneIndex;

	        // Update answer if current row has more 1s
	        if (count > maxCount) {
	            maxCount = count;
	            index = i;
	        }
	    }

	    return index;
	}
	

	// Returns index of first occurrence of 1
	int findLowerBound(int[] arr) {

	    int low = 0;
	    int high = arr.length - 1;

	    while (low <= high) {

	        int mid = (low + high) / 2;

	        // Possible answer found, search further left
	        if (arr[mid] >= 1) {
	            high = mid - 1;
	        }
	        // First 1 must be on the right side
	        else {
	            low = mid + 1;
	        }
	    }

	    // low points to first 1
	    // If no 1 exists, low = arr.length
	    return low;
	}

}
