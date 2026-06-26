package stacks;

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		String infix= "a+(b*c)/d";
		System.out.println(infixToPostfix(infix));
	}
	static String infixToPostfix(String infix) {
		Stack<Character>stack= new Stack<>();
		String postfix="";
		int i=0;
		while(i<infix.length()) {
			char ch= infix.charAt(i);
			//operands
			if(ch>='A'&& ch<='Z'||ch>='a'&& ch<='z'||ch>='0'&& ch<='9') {
				postfix=postfix+ch;
			}
			else if(ch=='(')stack.push(ch);
			else if(ch==')') {
				while(stack.peek()!='(') {
					postfix+=stack.pop();
				}
				stack.pop();
			}
			else {
			    int incomingPriority = priority(ch);

			    while (!stack.isEmpty() && stack.peek()!='(') {

			        boolean lessPriority = incomingPriority < priority(stack.peek());
			        boolean samePriority = incomingPriority == priority(stack.peek());

			        if (!(lessPriority || (samePriority && ch != '^')))
			            break;

			        postfix += stack.pop();
			    }

			    stack.push(ch);
			}
			i++;
		}
		while(!stack.isEmpty()) {
			postfix+=stack.pop();
		}
		return postfix;
		
	}
	static int priority(char ch) {
		if (ch=='^')return 3;
		else if(ch=='*'||ch=='/')return 2;
		else if(ch=='+'||ch=='-')return 1;
		return 0;
	}

}
