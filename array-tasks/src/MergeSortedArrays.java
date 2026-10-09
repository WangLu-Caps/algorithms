import java.util.Arrays;

/**
 * Problem: merge two sorted arrays into one new sorted array.
 *
 * Approach: two pointers i and j. Compare the current elements of both
 *           arrays, append the smaller one to the result and advance the
 *           corresponding pointer. Finally append the remaining tail of the
 *           array that is not exhausted yet.
 *
 * Time complexity:  O(n + m), where n and m are the lengths of the arrays
 * Space complexity: O(n + m) for the resulting array
 */
public class MergeSortedArrays {

    public static int[] merge(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < n) result[k++] = a[i++];
        while (j < m) result[k++] = b[j++];

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        System.out.println(Arrays.toString(merge(a, b))); // [1, 2, 3, 4, 5, 6]

        int[] c = {1, 2, 3};
        int[] d = {2, 5, 6};
        System.out.println(Arrays.toString(merge(c, d))); // [1, 2, 2, 3, 5, 6]
    }
}
