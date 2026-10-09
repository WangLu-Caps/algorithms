import java.util.Arrays;

/**
 * Problem: sort an array that contains only 0s and 1s in-place, so that all
 *          zeros come first and all ones come last.
 *
 * Approach: two pointers. Advance left while it points at 0; retreat right
 *           while it points at 1. Otherwise we have a 1 on the left and a 0
 *           on the right, so we swap them.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class SortBinaryArray {

    public static void sortBinary(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] == 0) {
                left++;
            } else if (arr[right] == 1) {
                right--;
            } else {
                // arr[left] == 1 and arr[right] == 0
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1, 0};
        sortBinary(a);
        System.out.println(Arrays.toString(a)); // [0, 0, 0, 1, 1, 1]

        int[] b = {1, 1, 0, 0};
        sortBinary(b);
        System.out.println(Arrays.toString(b)); // [0, 0, 1, 1]
    }
}
