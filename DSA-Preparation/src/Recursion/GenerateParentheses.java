/*Problem Statement:
------------------
Given n pairs of parentheses, generate all combinations of well-formed (valid) parentheses.

Example:
Input: n = 3

Output:
[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
]

Approach:
---------
Use Backtracking / Recursion.

At each step we have two choices:

1. Add '('
   - Allowed only if open < n

2. Add ')'
   - Allowed only if close < open
   - This ensures the current string never becomes invalid

Base Case:
----------
When the length of the current string becomes 2*n,
we have formed a valid parentheses combination.
Store it in the answer list.

Why close < open?
-----------------
A closing bracket can be placed only when there is an
unmatched opening bracket available.

TC
----
"The algorithm generates all valid parentheses strings. If there are M valid strings,
 and each string has length O(n), then TC = O(M*n). 
 Since M is the nth Catalan number, TC = O(Catalan(n)*n)."

 * SC
 * ----
 * Auxiliary space- O(n)
 */
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		
	}
	 public List<String> generateParenthesis(int n) {
	        ArrayList<String>al= new ArrayList<>();
	       return generate(0,0,n,"",al);
	        
	    }
	     List<String> generate(int open,int close,int n,String s,List<String> al){
	        if(open==n && close==n){
	            al.add(s);
	            return al;
	        }
	        if(open<n){
	            generate(open+1,close,n,s+"(",al);
	        }
	        if(close<open){
	            generate(open,close+1,n,s+")",al);
	        }
	        return al;

	    }

}
