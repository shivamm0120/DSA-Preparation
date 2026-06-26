package queue;

public class ImplementUsingArrays {
	static int size=10;
	static int [] queue = new int [size];
	static int currSize=0;
	static int start=-1,end=-1;
	public static void main(String []args) {
		push(0);
		push(1);
		System.out.println(top());//0
		System.out.println(size());//2
		System.out.println(pop());//0
		push(2);
		System.out.println(pop());//1
		push(3);
		push(4);
		System.out.println(top());//2
		System.out.println(size());//3
		System.out.println(pop());//2
		push(5);
		push(6);
		System.out.println(top());//3
		System.out.println(size());//4
		System.out.println(pop());//3
		
		
	}
	static void push(int x) {
		if (currSize==size) {
			System.out.println("cant be pushed");
		}
		
		if(currSize==0) {
			start=0;end=0;
		}
		else {
			end=(end+1)%size;
		}
		queue[end]=x;
		currSize++;
		
	}
	static int pop() {
		if(currSize==0) {
			System.out.println("empty queue");
		}
		int pop_ele=queue[start];
		
		if(currSize==1) {
			start=-1;end=-1;
		}
		else {
			start=(start+1)%size;
		}
		currSize--;
		return pop_ele;
	}
	static int top() {
		if(start==-1) {
			System.out.println("empty queue");
		}
		return queue[start];
	}
	static int size() {
		return currSize;
		
	}

}
