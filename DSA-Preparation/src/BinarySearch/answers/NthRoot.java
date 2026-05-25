/*
Problem: Find Nth Root of a Number

Given:
n = root
m = number

Find integer x such that:
x^n = m

Return:
- x if nth root exists
- -1 otherwise

Approach: Binary Search

1. Search possible answer in range [1, m]
2. Calculate mid^n
3. If:
      mid^n == m → answer found
      mid^n <  m → search larger values
      mid^n >  m → search smaller values

Time Complexity: O(log m * n)
Space Complexity: O(1)
 */
package BinarySearch.answers;

public class NthRoot {

    public static int nthRoot(int n, int m) {

        int low = 1;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long value = power(mid, n, m);

            // Perfect nth root found
            if (value == m)
                return mid;

            // Search larger values
            else if (value < m)
                low = mid + 1;

            // Search smaller values
            else
                high = mid - 1;
        }

        return -1;
    }

    /*
    Calculates base^power

    Stops early if value exceeds limit
    to avoid overflow
    */
    public static long power(int base, int power, int limit) {

        long ans = 1;

        for (int i = 1; i <= power; i++) {

            ans *= base;

            // Overflow prevention
            if (ans > limit)
                return ans;
        }
        return ans;
    }

    public static void main(String[] args) {

        int n = 3;
        int m = 27;

        System.out.println(nthRoot(n, m));
    }
}