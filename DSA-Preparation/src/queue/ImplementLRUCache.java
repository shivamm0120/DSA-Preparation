package queue;

import java.util.HashMap;

class Node{
	int key;
	int value;
	Node prev;
	Node next;
	Node(int key,int value){
		this.key=key;
		this.value=value;
	}
}
public class ImplementLRUCache {

	
	    int capacity;
	    HashMap<Integer,Node> map= new HashMap<>();
	    Node head= new Node(-1,-1);
	    Node tail= new Node(-1,-1);


	    public ImplementLRUCache(int capacity) {
	        this.capacity=capacity;
	        head.next=tail;
	        tail.prev=head;
	    }
	    
	    public int get(int key) {
	        if(!map.containsKey(key))return -1;

	        Node node =map.get(key);
	        deleteNode(node);
	        insertAfterHead(node);
	        
	        
	        return node.value;
	        
	    }
	    
	    public void put(int key, int value) {
	        Node node;
	        if(map.containsKey(key)){
	             node = map.get(key);
	            node.value=value;

	            deleteNode(node);
	            insertAfterHead(node);
	            return;

	        }
	        if(map.size()==capacity){
	             node= tail.prev;
	            deleteNode(node);
	            map.remove(node.key);
	        }

	        node=new Node(key,value);
	        map.put(key,node);
	        insertAfterHead(node);


	        
	    }
	    void insertAfterHead(Node node){
	        Node currAfterHead=head.next;
	        node.next=currAfterHead;
	        node.prev=head;
	        head.next=node;
	        currAfterHead.prev=node;

	    }
	    void deleteNode(Node node){
	        Node prevNode= node.prev;
	        Node nextNode = node.next;

	        prevNode.next=nextNode;
	        nextNode.prev=prevNode;

	    }
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */

