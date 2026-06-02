/*TC=>O(n)
 *S.C=>O(n) it takes stack space 
 * 
 */
package Recursion.basic;

public class PrintNameNTimes {
	public static void main(String[] args) {
		int n=0;
		printName(n);
	}
	static void printName(int n) {
		
		if(n--==0)return;
		System.out.println("Shivam");
		printName(n);
		
		
	}

}
