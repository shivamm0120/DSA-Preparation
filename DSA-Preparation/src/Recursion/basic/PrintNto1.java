package Recursion.basic;

public class PrintNto1 {
	public static void main(String[] args) {
		int n=10;
		printNum(n);
	}
	static void printNum(int n) {
		if(n<0)return;
		System.out.println(n--);
		printNum(n);
	}

}
