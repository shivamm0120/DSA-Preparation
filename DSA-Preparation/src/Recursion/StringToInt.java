package Recursion;
public class StringToInt {
	public static void main(String[] args) {
		System.out.println(myAtoi("  -042"));
	}
	 public static int myAtoi(String s) {
	        
	        int n = s.length();
	        int sign = 1;
	        long num = 0;
	        int i=0;
	        while(i<n&&s.charAt(i)==' '){
	            i++;
	        }
	        if(i<n && (s.charAt(i)=='+'||s.charAt(i)=='-')){
	            if(s.charAt(i)=='-')
	              sign=-1;
	              i++;
	        }
	        return (int)convert(s,i,n,sign,num);

	        
	    }
	    static long convert(String s,int i,int n,int sign,long num){
	        if(i>=n || !Character.isDigit(s.charAt(i))){
	            return sign*num;
	        }
	        int digit=s.charAt(i)-'0';
	        num=num*10+digit;
	        if(sign*num>Integer.MAX_VALUE){
	          return Integer.MAX_VALUE;
	        }
	        if(sign*num<Integer.MIN_VALUE)
	        return Integer.MIN_VALUE;
	       
	        return convert(s,i+1,n,sign,num);
	    }

}
