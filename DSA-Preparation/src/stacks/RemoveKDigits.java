package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		StringBuilder ans=new StringBuilder();
		Deque<Character> stack= new ArrayDeque<>();
		
		//maintain a monotonic increasing stack such that if current ele is smaller than the top element then do pop 
		for(char digit :num.toCharArray()){
			
			while(k>0 && !stack.isEmpty()&& digit <stack.peek()){
				stack.pop();
				k--;
			}
			stack.push(digit);
		}
		
		// if there is some more k then pop again 
		while(k>0 && !stack.isEmpty()){
			stack.pop();
			k--;
		}
		
		//convert stack into its equivalent number 
		while(!stack.isEmpty()){
			ans.append(stack.pop()); //will take O(n)
			//before i was using insert method that requires shifting of elements ie :O(n2)
		}
		ans.reverse();//reverse the num
		
		//removing leading zeroes 
		int i=0;
		while(i<ans.length() && ans.charAt(i)=='0')i++;
		return i==ans.length()?"0":ans.substring(i);
		
		//deleteCharAt() requires shifting of element ie O(n^2)operation
		//thus find an index from start which is non zero..after getting  
		//first digit we can call substring method to return remaining digits 
		//it will take O(n)
	}

}
