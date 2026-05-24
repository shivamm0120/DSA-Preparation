/*
Problem: Find Peak Element
A peak element is greater than its neighbours.

Approach: Binary Search(take help of graph to understand)

Observation:
- If nums[mid] > nums[mid-1]
  we are on increasing slope
  so peak lies on right side

- Else
  we are on decreasing slope
  so peak lies on left side

Time Complexity: O(log n)
Space Complexity: O(1)
 */
package BinarySearch;

public class PeakElement {

    public static int findPeakElement(int[] nums) {

        int n = nums.length;

        // only one element
        if (n == 1) return 0;

        // first element is peak
        if (nums[0] > nums[1]) return 0;

        // last element is peak
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // peak element found
            if (nums[mid] > nums[mid - 1] &&
                nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // increasing slope
            // peak lies on right side
            else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }

            // decreasing slope
            // peak lies on left side
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        int peakIndex = findPeakElement(nums);

        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + nums[peakIndex]);
    }
}