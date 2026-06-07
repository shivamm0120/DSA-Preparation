package Recursion.patterns;

import java.util.ArrayList;

public class CountSubsWhoseSumIsK {
	public static void main(String[] args) {
		int [] arr= {1,2,1};
		
		ArrayList<Integer>al= new ArrayList<>();
		int k=2;int s=0;
		System.out.println(print(0,arr.length,s,k,arr,al));
		
		
	}
	static int print (int i,int n,int sum,int k ,int[] arr,ArrayList<Integer> al) {
		
		if(i>=n) {
			if(sum==k) {
			  return 1;
			}
			return 0 ;
		}
		
		al.add(arr[i]);
		sum+=arr[i];
		int l=print (i+1,n,sum,k,arr,al) ;
		
		al.remove((Integer)arr[i]);
		sum-=arr[i];
		int r=print (i+1,n,sum,k,arr,al);
		return l+r;
	}

}
