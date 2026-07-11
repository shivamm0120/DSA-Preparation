/*Problem:  Sliding window maximum 
 * 
 * Approach:
 *   -use an deque which maintains values in decreasing monotonic style
 *   -store indices.
 *   -poll from front of the queue if peek() element is out of window.
 *    As it is not a part of current window.
 *   -Maintain decreasing monotonic stack
 *    
 * Time complexity :
 *  loop will run O(n) times and inside loop push and pop will happen at max O(n) times 
 *  so total TC =O(2n)
 *  
 *  space: 
 *   O(n) for stack and O(n) for answer array 
 *  
 * 
 * 
 */
package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> queue = new ArrayDeque<>();
		//array to return 
		int[] max = new int[nums.length - k + 1];
		
		//taking window pointers 
		int low = 0;
		int high = 0;

		int indx = 0;//pointer to insert values in max array 
		
		while (high < nums.length) {
			
			//need to remove  expired indices which is left side of window 
			if (!queue.isEmpty() && queue.peek() < low)
				queue.poll();
			
			//Maintain decreasing monotonic stack 
			//why decreasing ?so that we can retrive max on calling peek(),not only that after
			//calling poll() method 2nd largest will become top automatically 
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[high]) {
			//when the value is same or lesser ,no need to store it ..store max value as this subarray requires max value only 
				queue.pollLast();
			}
			queue.offer(high);
		
			//if it is not k size window ,first form it .Till then dont update max array
			if (high - low + 1 < k) {
				high++;
				continue;
			}
			//storing into max array 
			max[indx++] = nums[queue.peek()];
			
			//moving window by 1
			low++;
			high++;

		}
		return max;
	}
}
