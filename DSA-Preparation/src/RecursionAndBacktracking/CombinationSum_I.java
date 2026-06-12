/*Problem Statement

Given an array of distinct integers candidates and a target integer target, return all unique combinations of candidates where the chosen numbers sum to target.

Rules:

A number may be chosen unlimited times.
Two combinations are unique if the frequency of at least one chosen number differs.
Return all valid combinations in any order.
Approach

We use the Pick / Not Pick recursion pattern.

For every index, we have two choices:

1)Pick Current Element
  Add the current element to the combination.
  Increase the current sum.
  Stay at the same index because the same element can be reused multiple times.
2.Not Pick Current Element
  Skip the current element.
  Move to the next index.
  Backtracking

After returning from the Pick call:

Remove the last added element.
Restore the previous state so other combinations can be explored.
 * 
 * Time Complexity : O(2^(target / minElement))  (Exponential)
 *Space Complexity: O(target / minElement)
 *(min element will give the maximum recursion depth thats why min element
 */
package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_I {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> al= new ArrayList<>();
        findCombination(0,0,target,candidates,candidates.length,al,ans);
        return ans;
        
    }
   public void findCombination(int i,int sum,int target,int[] arr,int n,List<Integer> al,List<List<Integer>> ans){
	   
	// Base Case:  All elements have been considered
        if(i==n){
        	//valid combination
            if(sum==target)
                ans.add(new ArrayList<>(al));
            return;
        }

        //pick current element only if target is not exceeded
        if(sum+arr[i]<=target){
        	   //choose current ele
            al.add(arr[i]);
            
            //stay at same index after picking
            findCombination(i,sum+arr[i],target,arr,n,al,ans);
            al.remove((Integer)arr[i]);//backtrack
        }

        //not pick:skip curr element ,move to next index
        findCombination(i+1,sum,target,arr,n,al,ans);
    }

}
