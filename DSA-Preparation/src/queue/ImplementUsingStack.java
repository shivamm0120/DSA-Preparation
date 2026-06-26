//Brute Force:
//Push directly into the input stack; 
//for pop/peek, transfer elements to the output stack, perform the operation, then transfer them back.
//for push and pop operation it will take O(2n) operations as we do 2 times transfer operation

//Optimized:
//Logic: after transferring to the stack2 :they are actually in the pop up order 
//so we donot need to transfer back 
// Push into the input stack; 
//transfer elements to the output stack only when it's empty, 
//then perform pop/peek directly from the output stack.
package queue;

import java.util.Stack;
public class ImplementUsingStack{
	 
	    Stack<Integer>input= new Stack<>();
	    Stack<Integer>output= new Stack<>();
	    public static void main(String[] args) {
			
		}

	  
	    
	    public void push(int x) {
	        input.push(x);
	        
	    }
	    
	    public int pop() {
	        if(output.isEmpty()){
	          while(!input.isEmpty()){
	            output.push(input.pop());
	          }
	        }
	       return output.pop();
	        
	    }
	    
	    public int peek() {
	       if(output.isEmpty()){
	        while(!input.isEmpty()){
	            output.push(input.pop());
	        }
	        }
	       return output.peek();
	    }
	    
	    public boolean empty() {
	        return (input.size()==0 && output.size()==0);
	        
	    }

}
