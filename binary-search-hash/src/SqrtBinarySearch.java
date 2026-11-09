/**
 * Problem: find the integer part of the square root of n (floor of sqrt(n)),
 *          without using any built-in square root function.
 *
 * Approach: binary search over [0, n]. The predicate "m*m <= n" is monotone:
 *           true for small m, false for large m. We search for the largest m
 *           with m*m <= n. Instead of m*m (which can overflow), we compare
 *           "m <= n / m".
 *
 * Why O(log n): each iteration halves the search interval, so the number of
 *           iterations is at most log2(n + 1) + 1.
 *
 * Time complexity:  O(log n)
 * Space complexity: O(1)
 */
public class SqrtBinarySearch {

    public static long intSqrt(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        long lo = 0, hi = n;
        long answer = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid == 0 || mid <= n / mid) { // mid*mid <= n, without overflow
                answer = mid;                 // mid fits, try a larger one
                lo = mid + 1;
            } else {
                hi = mid - 1;                 // mid is too large
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(intSqrt(0));                              // 0
        System.out.println(intSqrt(8));                              // 2
        System.out.println(intSqrt(10));                             // 3
        System.out.println(intSqrt(1_000_000_000_000_000_000L));     // 1000000000
    }
}
