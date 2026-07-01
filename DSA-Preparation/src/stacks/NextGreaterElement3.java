/*Problem:
 * Given a positive integer n, find the smallest integer which has exactly the same digits 
 *existing in the integer n and is greater in value than n. If no such positive integer exists, 
 *return -1.
 *
 * Approach
 * ========
 *The idea is based on finding the next lexicographically greater permutation of the digits.
 *
 *Convert the integer into a character array so that individual digits can be manipulated.
 *Traverse the array from right to left to find the first digit that is smaller than its next digit. This is called the pivot.
 *If no such digit exists, the digits are in descending order, meaning no greater permutation is possible. Return -1.
 *Again traverse from the right to find the smallest digit greater than the pivot.
 *Swap the pivot with this digit.
 *Reverse the suffix (the part after the pivot) since it is in descending order. Reversing makes it ascending, giving the smallest possible number greater than the original.
 *Convert the character array back to a number.
 *If the number exceeds Integer.MAX_VALUE, return -1; otherwise, return the number.
 *
 *TC
 *===
 *O(n)
 *SC:we used an character array ie.O(n)
 */

package stacks;

public class NextGreaterElement3 {
	public static void main(String[] args) {
		System.out.println(nextGreaterElement(132));
		System.out.println(nextGreaterElement(47653));
		
	}

	public static int nextGreaterElement(int n) {
		// convert num into char array
		char[] num = String.valueOf(n).toCharArray();

		int i = num.length - 2;
		while (i >= 0 && num[i] >= num[i + 1]) {
			i--;
		}

		if (i == -1)
			return -1;

		// find an element from which it has to be swapped
		int j = num.length - 1;
		while (j >= 0 && num[j] <= num[i]) {
			j--;
		}

		swap(num, i, j);

		// after swapping , elements after ith index will be in decreasing order ..just
		// reverse them
		reverse(num, i + 1, num.length - 1);

		// check if it is inside int range
		long num1 = Long.parseLong(new String(num));
		if (num1 > Integer.MAX_VALUE)
			return -1;
		return (int) num1;
	}

	static void swap(char[] num, int i, int j) {
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	static void reverse(char[] num, int i, int j) {
		while (i < j) {
			swap(num, i, j);
			i++;
			j--;
		}
	}

}
