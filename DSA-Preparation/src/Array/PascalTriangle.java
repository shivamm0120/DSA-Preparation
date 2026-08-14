/*Three types of question can be asked in pascal triangle 
 * 1.To get the 'cth' value in the 'rth' row.
 * 2.To get the nth row .
 * 3.To get the complete pascal triangle for n row .
 * 
 * 1.To get any element in the nth row 
 *   =================================
 *   for nth row and rth col we need to compute nCr 
 *   ncr= n!/(r! * (n-r)!)
 *   
 *   Brute approach is to compute all the factorial separately but it will take lot of time.
 *   we need some optimization.
 *   
 *   since r is smaller than n then there will be a time when either (n-r)! cancel the product of 
 *   n! or r! will cancel the product .
 *   
 *   ie. 					      n* (n-1)* (n-2)*(n-3)......*1
 *       nCr= n!/(r! * (n-r)!)=  ________________________________
 *                                      r! * (n-r)!
 *        
 *         ****we know nCa= nCb  if a+b = n****
 *         
 *       when r is smaller than (n-r)
 *       ==============================
 *       now let r=3 then (n-3)! will be cancel out .Then run the loop only r times . 
 *      
 *      when r is greater than (n-r)
 *      ==============================
 *       similarly if n is 100 and r is 98 then do not run 98 times , (n-2)!= 98! so it will
 *        be cancel out with r! ..Then run the loop only (n-r) times .
 *        
 *        ****conclusion :we have to run the loop till min(r,n-r) times only ->optimal *****
 *        
 *             long findNcr(int n,int r){
 *               long res=1;
 *                r= Math.min(r,n-r);
 *               
 *               for(int i=0;i<r;i++){
 *                  res=res*(n-i);
 *                  res=res/(i+1);
 *                }
 *                return res;
 *              }
 *   To calculate any row r and any column c element then pass (r-1,c-1 ) as a parameter to above function
 *              
 *              
 *2.find elements of particular row
 *  ================================
 *  if we try to find ncr value for each column in a row then it will take O(n^2)
 *  so we need to optimise it .
 *  
 *  ok for row 4 :
 *    first col will be 3c0 (ie 1) ,2nd will be 3c1 (ie. 3) ,3rd will be 3c2 (ie 3) and 4th 3c3 (ie 1)
 *    if we find some observation that something is getting multiplied in every coln then we 
 *    can solve this .
 *    
 *    ArrayList<Integer>row= new ArrayList<>();
 *    res=1;
 *    for(int i=1;i<n;i++){
 *      res*=(n-i)/i;
 *      row.add(res);
 *      }
 * 3.print complete pascal triangle     
 *      
 *       
 *                
 *       
 * 
 * 
 */
package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args) {
		List <Integer>pascal= new ArrayList<>();
		List <Integer>rows= new ArrayList<>();
		int rowCount=10;
		
		
		for(int row=0;row<rowCount;row++) {
			int res=1;
			System.out.print(1+" ");
			
			for(int col=1;col<=row;col++) {
				res=res*(row-col+1)/col;
				System.out.print(res+ " ");
				
			}
			System.out.println();
			
		}
		
		
	}
	
	

}
