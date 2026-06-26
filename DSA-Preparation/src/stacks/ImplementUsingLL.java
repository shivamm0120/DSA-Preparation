package stacks;

public class ImplementUsingLL {
	static Node<Integer> newnode= new Node<>();
	static Node top=null;
	static int size=0;
	
	public static void main(String[] args) {
		push(7);
		System.out.println(top.item);
		push(8);
		System.out.println(top.item);
		pop();
		System.out.println(top.item);
		System.out.println(size);
		
		
	}
	static void push(int x){
		Node temp=top;
		
		top=new Node(x);
		if (top!=null)
		  top.next=temp;
		size++;
	}
	static boolean pop() {
		if(top==null)return false;
		top=top.next;
		size--;
		return true;
	}
	
	static int size() {
		Node temp=top;int count=0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	

}
 class Node<E> {
	E item;
	Node<E> next;
	
	Node (E item){
		this.item=item;
	}
	Node(){
		
	}
 }
