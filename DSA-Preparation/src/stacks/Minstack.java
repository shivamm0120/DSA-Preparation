/*
 * Brute force:
 * while pushing any value ,insert pair of values into the stack (value,min value so far)
 */
package stacks;

import java.util.Stack;

public class Minstack {
	static Stack<int []> res = new Stack<>();
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		push(5);
		System.out.println(getMin());
		pop();
		push(9);
		push(6);
		System.out.println(getMin());
		push(2);
		System.out.println(getMin());
		pop();
		
		
	}
	static void push(int x){
		min=Math.min(x, min);
	
		res.push (new int[] {x,min});
	}
	static void pop() {
		if(res.isEmpty())return;
		
		int [] values=res.pop();
		if(!res.isEmpty()) {
			min=res.peek()[1];
			
		}
		else min=Integer.MAX_VALUE;
		
	}
	static int getMin() {
		return res.peek()[1];
	}
	static boolean empty() {
		return res.isEmpty();
	}
}

/*Optimized approach:
 * =====================
 * Store the first element normally and initialize min with it.
 *If x >= min, push x normally.
 *If x < min, push the encoded value 2*x - min and update min = x.
 *During pop(), if the popped value is less than min, it is an encoded value; restore the previous minimum using min = 2*min - encodedValue.
 *top() returns min if the top is an encoded value; otherwise, it returns the top element.
 *getMin() simply returns min.
 *
 *
 *code:
 *=====
 public void push(long value) {
        if(stack.isEmpty()){
            stack.push(value);
            min=value;
            return;
        }
        if(value>=min){
            stack.push(value);
        }
        else{//need to modify min value
            stack.push(2*value-min);
            min=value;
        }
    }
    
    public void pop() {
        long ele=stack.pop();
        if(ele<min)
            min=2*min-ele;
    }
    
    public long top() {
        long ele=stack.peek();
        if(ele>=min)return ele;
        return min;
        
    }
    
    public long getMin() {
        return min;
        
    }

 *
 */


