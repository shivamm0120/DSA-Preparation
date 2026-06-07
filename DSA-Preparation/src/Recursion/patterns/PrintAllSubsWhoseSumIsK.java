package Recursion.patterns;

import java.util.ArrayList;

public class PrintAllSubsWhoseSumIsK {
	public static void main(String[] args) {
		int [] arr= {1,2,1};
		
		ArrayList<Integer>al= new ArrayList<>();
		int k=2;int s=0;
		print(0,arr.length,s,k,arr,al);
		
		
	}
	static void print (int i,int n,int sum,int k ,int[] arr,ArrayList<Integer> al) {
		
		if(i>=n) {
			if(sum==k)
			  System.out.println(al);
			return;
		}
		
		al.add(arr[i]);
		sum+=arr[i];
		print (i+1,n,sum,k,arr,al);
		
		al.remove((Integer)arr[i]);
		sum-=arr[i];
		print (i+1,n,sum,k,arr,al);
	}

}
