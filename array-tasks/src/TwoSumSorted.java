import java.util.Arrays;

/**
 * Problem: given a sorted ascending integer array and a target value,
 *          find two elements whose sum equals target and return their indices.
 *
 * Approach: two pointers - one at the start (left), one at the end (right).
 *           If the sum is smaller than target, move left to the right
 *           (we need a bigger sum). If it is larger, move right to the left.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class TwoSumSorted {

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // no such pair
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println("target=9  -> " + Arrays.toString(twoSum(nums, 9)));  // [0, 1]
        System.out.println("target=18 -> " + Arrays.toString(twoSum(nums, 18))); // [1, 2]
        System.out.println("target=99 -> " + Arrays.toString(twoSum(nums, 99))); // [-1, -1]
    }
}
