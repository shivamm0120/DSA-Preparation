package RecursionAndBacktracking;

public class CountGoodNumbers {
	public static void main(String[] args) {
		System.out.println(countGoodNumbers(2));
		System.out.println(countGoodNumbers(100));
		System.out.println(countGoodNumbers(4));
	}
	public static int countGoodNumbers(long n) {
		
		// Number of even indices:
		// n=4 -> indices 0,2 => 2
		// n=5 -> indices 0,2,4 => 3
		long even = (n % 2 == 0) ? n / 2 : n / 2 + 1;
		
		// Number of odd indices
		long odd = n / 2;
		
		// Total ways:
		// 5 choices for every even position
		// 4 choices for every odd position
		return (int) ((pow(5, even) * pow(4, odd)) % 1000000007);
	}
	
	static long pow(int x, long n) {
		
		long mod = 1000000007;
		
		// Base Case
		if (n == 0)
			return 1;
		
		// Calculate x^(n/2)
		long half = pow(x, n / 2);
		
		// x^n = (x^(n/2) * x^(n/2))
		long ans = (half * half) % mod;
		
		// If exponent is odd,
		// multiply one extra x
		if (n % 2 == 1)
			ans = (ans * x) % mod;
		
		return ans;
	}

}




