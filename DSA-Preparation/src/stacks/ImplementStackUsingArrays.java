package stacks;

public class ImplementStackUsingArrays {
	static int capacity=10;
	static int top=-1;
	static int [] stack = new int [capacity];
	
	public static void main(String[] args) {
		push(4);
		push(3);
		push(7);
		push(6);
		pop();
		push(1);
		push(9);
		pop();
		//System.out.println(top());
		for(int i=capacity-1;i>=0 ;i--) {
			System.out.println(stack[i]);
		}
		
		
	}
	
	static void push(int x) {
		if(top>=10)return ;
		top++;
		stack[top]=x;
		
	}
	static void pop() {
		if(top==-1)return ;
		stack[top]=0;
		top--;
		
	}
	static int top() {
		if(top!=-1 || top!=capacity)
		return stack[top];	
		return -1;
		
	}
	static int size(){
		if(top>=capacity)
			return capacity;
		return top+1;
		
		
		
		
	}

}
