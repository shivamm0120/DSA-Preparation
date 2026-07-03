/*Problem-Asteroid collison
 * 
 * Given an array of integers representing asteroids, positive values move right and 
 * negative values move left. When two asteroids moving toward each other collide,
 *  the smaller one explodes. If they are the same size, both explode. 
 *  Asteroids moving in the same direction or away from each other never collide. 
 *  Return the final state of the asteroids after all collisions.
 * 
 * Intuition
 * =========
 * Collision can only be happen when the asteroid at top of the stack is moving right and incoming
 * asteroid is moving left.other no cases are valid.
 *   Right(->)  Right(->) ==>no explosion 
 *   Right(->)  Left(<-)  ==>EXPLOSION 
 *   left(<-)   right(->) ==>no explosion
 *   left(<-)   left(<-)  ==>no explosion
 *   
 *  TC :O(2n)
 *  SC:O(2n)
 * 
 */
package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidsCollision {
	 public int[] asteroidCollision(int[] asteroids) {
	        int n=asteroids.length;
	       
	        Deque<Integer>stack= new ArrayDeque<>();

	        for(int i=0;i<n;i++){

	            while(!stack.isEmpty()&& (stack.peek()>0 && asteroids[i]<0)){
	                int incomingSize=Math.abs(asteroids[i]);
	                if(stack.peek()>incomingSize){
	                    asteroids[i]=0;break;
	                }
	                else if(stack.peek()<incomingSize){
	                    stack.pop();
	                }
	                else {
	                    asteroids[i]=0;
	                    stack.pop();
	                }
	            }
	            if(asteroids[i]!=0)stack.push(asteroids[i]);

	        }
	        
	        //create ans array that can be returned
	       int []ans= new int[stack.size()];
	       for(int i=ans.length-1;i>=0;i--){
	        ans[i]=stack.pop();
	       }
	       return ans;

	        
	        
	    }

}
