package Recursion.basic;

public class FibonacciSeries {
	public static void main(String[] args) {
		int n=10;
		printFibonacci(0,1,n);
	}
	static void printFibonacci(int a,int b,int n) {
		if(n==0) return;
		
		System.out.println(a);
		printFibonacci(b,a+b,--n);
		
	}

}
