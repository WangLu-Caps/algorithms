/**
 * Problem ("very easy task" / two copiers): there is one original document
 *          and two copiers; the first copies a sheet in x minutes, the second
 *          in y. How fast can we make n copies? We may use one or both
 *          copiers, and we may copy from a copy too.
 *
 * Approach: first we must make one copy from the original (only one copier
 *           can do this), which takes min(x, y). After that we have two
 *           documents, so both copiers work in parallel on the remaining
 *           n - 1 copies. We binary-search the time t for those n - 1 copies:
 *           in t minutes the copiers make t/x + t/y copies, and this check is
 *           monotone in t. Total = min(x, y) + t.
 *
 * Time complexity:  O(log(min(x, y) * n))
 * Space complexity: O(1)
 */
public class TwoCopiers {

    public static long minTimeCopies(long n, long x, long y) {
        if (n <= 0) return 0;
        if (n == 1) return Math.min(x, y);

        long need = n - 1;
        long lo = 0;
        long hi = need * Math.max(x, y);
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (mid / x + mid / y < need) {
                lo = mid;   // not enough time yet
            } else {
                hi = mid;   // enough time, try smaller
            }
        }
        return hi + Math.min(x, y);
    }

    public static void main(String[] args) {
        System.out.println(minTimeCopies(5, 1, 2)); // 4
        System.out.println(minTimeCopies(4, 1, 1)); // 3
        System.out.println(minTimeCopies(1, 3, 5)); // 3
    }
}
