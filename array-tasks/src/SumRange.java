/**
 * Problem: sum of all integers from 1 to n (in the seminar, n = 1_000_000).
 *
 * Approach: use the arithmetic series formula S = n * (n + 1) / 2,
 *           which works in constant time instead of looping.
 *
 * Time complexity:  O(1)
 * Space complexity: O(1)
 */
public class SumRange {

    public static long sumUpTo(long n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        long n = 1_000_000L;
        System.out.println("sum(1.." + n + ") = " + sumUpTo(n));
        System.out.println("sum(1..10)  = " + sumUpTo(10));
        System.out.println("sum(1..1)   = " + sumUpTo(1));
    }
}
