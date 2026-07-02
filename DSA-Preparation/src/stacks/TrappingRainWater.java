/* Problem -Trapping rain water
  Approach
  ========
1. Brute Force Approach
  Idea:
    create 2 arrays left max and right max
     now  find left max and right max for each index 

  Now traverse the array and at each index:
     water = min(leftMax, rightMax) - height[i]
     Add it to the answer.

  Time complexity=O(3n)
  Space complexity=O(2n)

2.Optimized approach
  Idea:To find trapped water at some index,it only depends on one value either left max and right max ..but not on both.
  Use two pointers and maintain:

left, right
leftMax, rightMax
Key Observation
If leftMax <= rightMax, then water at the left depends only on leftMax.
and we will always traverse the smaller one ..assuming that the other side has higher wall
Otherwise, water at the right depends only on rightMax.

This is because the smaller boundary limits the amount of water that can be trapped.

  TC:O(n)(single traversal)
  SC:O(1)
*
/
class Solution {
    public int trap(int[] height) {
        int lMax=0,rMax=0,trap=0;

        int l=0,r=height.length-1;
      
        while(l<r){
          //
            if(height[l]<=height[r]){
                if(lMax>=height[l])
                    trap+=lMax-height[l];
                
                else lMax=height[l];
                l++;
            }
            else{
                if(rMax>=height[r])
                  trap+=rMax-height[r];
                else  rMax=height[r];
                r--;
            }
        }
        return trap;
        
    }
}
