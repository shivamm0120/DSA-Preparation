package Recursion.patterns;

import java.util.ArrayList;

public class PrintAnySubsWhoseSumIsK {
	public static void main(String[] args) {
		int [] arr= {1,2,1};
		
		ArrayList<Integer>al= new ArrayList<>();
		int k=2;int s=0;
		print(0,arr.length,s,k,arr,al);
		
		
	}
	static boolean print (int i,int n,int sum,int k ,int[] arr,ArrayList<Integer> al) {
		
		if(i>=n) {
			if(sum==k) {
			  System.out.println(al);
			  return true;
			}
			return false ;
		}
		
		al.add(arr[i]);
		sum+=arr[i];
		if(print (i+1,n,sum,k,arr,al) )return true;//so when this function will get any sub we are not going to execute 
		                                 //below method
		
		al.remove((Integer)arr[i]);
		sum-=arr[i];
		if(print (i+1,n,sum,k,arr,al) )return true;
		return false;
	}

}
