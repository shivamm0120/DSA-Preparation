package Recursion.patterns;

import java.util.ArrayList;

public class PrintAllSubsequences {
	public static void main(String[] args) {
		int [] arr= {3,2,1};
		
		ArrayList<Integer>al= new ArrayList<>();
		print(0,3,arr,al);
		
		
	}
	static void print (int i,int n,int[] arr,ArrayList<Integer> al) {
		if(i>=n) {
			System.out.println(al);
			return;
		}
		
		al.add(arr[i]);
		print (i+1,n,arr,al);
		
		al.remove((Integer)arr[i]);
		print (i+1,n,arr,al);
	}

}
