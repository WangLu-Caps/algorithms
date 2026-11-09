import java.util.Arrays;

/**
 * Problem (extra, from the seminar): Shell sort - an improved insertion sort
 *          that first compares elements far apart (by a decreasing gap) and
 *          finally performs a regular insertion sort (gap = 1).
 *
 * Approach: start with gap = n / 2; for each gap do a gapped insertion sort;
 *           halve the gap until it becomes 0.
 *
 * Time complexity:  depends on the gap sequence; with the halving sequence
 *           the worst case is O(n^2), but in practice it is faster than plain
 *           insertion / bubble sort. (Hibbard sequence ~O(n^1.5), Pratt
 *           sequence ~O(n^(4/3)).)
 * Space complexity: O(1) (in-place)
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3, 1, 8, 7};
        shellSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 7, 8, 12, 34, 54]
    }
}
