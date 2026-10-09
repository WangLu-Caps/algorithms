import java.util.Arrays;

/**
 * Problem: reverse an integer array in-place, without allocating
 *          any additional array.
 *
 * Approach: swap elements from both ends, moving the two pointers inward
 *           until they meet in the middle.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class ReverseArray {

    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        System.out.println(Arrays.toString(arr)); // [5, 4, 3, 2, 1]

        int[] arr2 = {1, 2};
        reverse(arr2);
        System.out.println(Arrays.toString(arr2)); // [2, 1]
    }
}
