/*Parameterized recursion
 * ======================
 * In parameterized recursion, you pass the current answer/state as a parameter to the recursive function.
 * Instead of waiting for recursive calls to return values, you keep updating parameters and pass them down.
 * 
 * When to use Parameterized Recursion?
 * =====================================
 *
 * Use it when you are building an answer as you go down the recursion tree.
 *
 * Common examples:
 *
 * Sum of N numbers
 * Factorial (with accumulator)
 * Generating subsequences
 * Backtracking problems
 * DFS where state is carried
 * 
 */
package Recursion.basic;

public class SumOfFirstNnumbers {
	
	public static void main(String[] args) {
		int n=3;int sum=0;
		sum(n,sum);
	}
	
	static void sum(int i,int sum) {
		if(i<1) {
			System.out.println(sum);
			return;
		}
		sum(i-1,sum+i);
		
	}
}
