/*
	Problem: Minimum Days to Make m Bouquets
	Condition:
	Each bouquet requires k adjacent flowers.

	Approach: Binary Search on Answer

	1. Minimum possible answer: minimum bloom day

	2. Maximum possible answer:maximum bloom day

	3. For every mid day: count how many bouquets can be formed

	4. If bouquets >= m:try smaller answer

	5. Else:
	      increase number of days

	Time Complexity: O(n * log(maxDay))
	Space Complexity: O(1)
 */
package BinarySearch.answers;

public class MinNoOfDaysToMakeMBouquets {
	
	    public int minDays(int[] bloomDay, int m,int k) {

	        int n = bloomDay.length;
	        
	        //Not enough flowers available to form required bouquets
	        if ((long)m * k > n)
	            return -1;

	        int min = bloomDay[0];
	        int max = bloomDay[0];

	        // Find search space
	        for (int i = 1; i < n; i++) {

	            min = Math.min(min, bloomDay[i]);
	            max = Math.max(max, bloomDay[i]);
	        }

	        // Binary Search on days
	        while (min <= max) {
	            int mid =
	                min + (max - min) / 2;
	            // Count bouquets possible
	            int bouquets =
	                bouquetsCount(bloomDay,
	                              mid,
	                              k);
	            /*
	            Possible to make required bouquets
	            Try smaller answer
	            */
	            if (bouquets >= m) {
	                max = mid - 1;
	            }

	            // Need more days
	            else {
	                min = mid + 1;
	            }
	        }

	        return min;
	    }

	    
//	    Counts bouquets possible on a given day
	    static int bouquetsCount(int[] bloomDay, int day,int k) {
	        int flowers = 0;
	        int count = 0;
	        for (int i = 0;i < bloomDay.length;i++) {
	        	
	            // Flower bloomed
	            if (bloomDay[i] <= day) {
	                flowers++;
	                
//	                One bouquet formed using k adjacent flowers
	                if (flowers == k) {
	                    count++;
	                    // Reset for next bouquet
	                    flowers = 0;
	                }
	            }
	           // Adjacency breaks because flower has not bloomed
	            else {
	                flowers = 0;
	            }
	        }

	        return count;
	    }
	}


