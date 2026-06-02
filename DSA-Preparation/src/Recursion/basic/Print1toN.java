package Recursion.basic;

public class Print1toN {
	public static void main(String[] args) {
		int n=10;int i=1;
		printNum(i,n);
		
		
	}
	static void printNum(int i,int n) {
		if(i>n)return ;
		System.out.println(i++);
		printNum(i,n);
		
		
	}

}
