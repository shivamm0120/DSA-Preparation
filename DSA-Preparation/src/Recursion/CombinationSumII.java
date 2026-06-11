package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        Arrays.sort(candidates);

	        List<List<Integer>> ans= new ArrayList<>();
	        List<Integer> al= new ArrayList<>();

	        findCombination(0,target,candidates,al,ans);
	       
	        return ans;
	        
	    }
	   public void findCombination(int index,int target,int[] arr,List<Integer> al,List<List<Integer>> ans){
	        if(target==0){
	            ans.add(new ArrayList<>(al));
	            return;
	        }
	        for(int i=index ;i<arr.length;i++){
	        	  //skip duplicate element which starts at same recursion level 
	            if(i>index&& arr[i]==arr[i-1])continue;
	            //if curr ele exceeds target then no need to check further as it is sorted
	            if(arr[i]>target)break;

	            al.add(arr[i]);
	            findCombination(i+1,target-arr[i],arr,al,ans);
	            al.remove(al.size()-1);
	        }
	    }

}


