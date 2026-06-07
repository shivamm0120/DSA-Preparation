package Recursion;

public class PowerOfXAndN_UsingRecursion {
	public static void main(String[] args) {
		System.out.println(myPow(2.000000,5));
		System.out.println(myPow(2.000000,-5));
		System.out.println(myPow(2.000000,-2));
	}
	 public static double myPow(double x, int n) {
	        if(n==1)return x;
	        return (n>0)?pow(x,n):1/pow(x,n);
	    }
	 
	 //Recursive function to calculate pow
	    static double pow(double x,int n){
	       if(n==0)return 1;

	       double half=pow(x,n/2);//using divide and conquer technique 
	       
	       if(n%2==0)return half*half;
	       else return half*half*x;

	    }

}

/*T.C=>O(log2(n))
 * Stack space O(logn)
 * 
 */
