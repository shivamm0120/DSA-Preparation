package Recursion.basic;

public class CheckGivenStringIsAPalindromeOrNot {
	public static void main(String[] args) {
		String s="MADAM";
		System.out.println(check(s,0,s.length() ) );
	}
	static boolean check(String s,int i,int n) {
		if(i==n/2)return true;
		if(s.charAt(i) != s.charAt(n-1-i) )
			return false;
		return check(s,i+1,n);
		
	}

}
/*Above is a functional recursion 
 * T.C=>O(n/2)
 * S.C=>Auxiliary space O(n/2)
 * 
 */
