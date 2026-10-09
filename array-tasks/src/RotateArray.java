import java.util.Arrays;

/**
 * Problem: rotate an array to the right by k steps (LeetCode 189).
 *          Example: [1,2,3,4,5,6,7], k=3 -> [5,6,7,1,2,3,4].
 *
 * Approach: reverse the whole array, then reverse the first k elements,
 *           then reverse the remaining n-k elements.
 *           k is reduced modulo n to handle k > n.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums)); // [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {-1, -100, 3, 99};
        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2)); // [3, 99, -1, -100]
    }
}
