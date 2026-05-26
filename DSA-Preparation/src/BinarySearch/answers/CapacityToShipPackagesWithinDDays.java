/*
	Problem: Capacity To Ship Packages Within D Days
	Approach: Binary Search on Answer

	- Minimum capacity = maximum weight
	- Maximum capacity = sum of all weights

	For every capacity:
	- Find how many days are needed
	- If days needed <= given days:
	    try smaller capacity
	- Else:
	    increase capacity

	Time Complexity: O(n * log(sum))
	Space Complexity: O(1)
 */
package BinarySearch.answers;

public class CapacityToShipPackagesWithinDDays {

	    public int shipWithinDays(int[] weights, int days) {

	        int lowCapacity = weights[0];
	        int highCapacity = 0;

	        // Define binary search range
	        for (int weight : weights) {

	            // Minimum valid capacity
	            lowCapacity = Math.max(lowCapacity, weight);

	            // Maximum possible capacity
	            highCapacity += weight;
	        }

	        // Binary Search
	        while (lowCapacity <= highCapacity) {

	            int midCapacity =
	                lowCapacity + (highCapacity - lowCapacity) / 2;

	            int requiredDays =
	                calculateDays(weights, midCapacity);

	            // Capacity works
	            if (requiredDays <= days) {

	                // Try smaller capacity
	                highCapacity = midCapacity - 1;
	            }

	            // Capacity too small
	            else {

	                lowCapacity = midCapacity + 1;
	            }
	        }

	        // Minimum valid capacity
	        return lowCapacity;
	    }

	    // ---------------------------------
	    // Calculate days needed for capacity
	    // ---------------------------------
	    static int calculateDays(int[] weights, int capacity) {

	        int daysNeeded = 1;
	        int currentLoad = 0;

	        for (int weight : weights) {

	            // Cannot fit in current day
	            if (currentLoad + weight > capacity) {

	                daysNeeded++;
	                currentLoad = weight;
	            }

	            // Add package to current day
	            else {

	                currentLoad += weight;
	            }
	        }

	        return daysNeeded;
	    }
}
