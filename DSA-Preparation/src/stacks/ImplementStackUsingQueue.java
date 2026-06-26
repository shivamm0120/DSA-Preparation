package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueue {
	Deque<Integer> queue =new ArrayDeque<>();
	public static void main(String[] args) {
		
	}	
	  
    public void push(int x) {
    	//push to the queue
        queue.offer(x);
        int i=1;
        while(i<=queue.size()-1){
        	//pop element from the queue and push again so it will become last in first out
           int ele= queue.poll();
            queue.offer(ele);
            i++;
        }
    }
    
    public int pop() {
       return queue.poll();
        
    }
    
    public int top() {
        
       return queue.peek();
    }
    
    public boolean empty() {
        return queue.size()==0;
        
    }
	

}
