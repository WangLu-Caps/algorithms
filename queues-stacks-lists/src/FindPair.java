/**
 * Problem (homework 2, task 5): given a sorted array of integers and a target
 *          number, determine whether there exist two elements whose sum
 *          equals target.
 *
 * Approach: two pointers - one at the start (left), one at the end (right).
 *           If nums[left] + nums[right] equals target, such a pair exists.
 *           If the sum is smaller, move left right (we need a larger sum);
 *           if it is larger, move right left (we need a smaller sum).
 *           Each step discards one element, so the whole scan is O(n).
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class FindPair {

    public static boolean hasPair(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(hasPair(nums, 9));  // true  (2 + 7)
        System.out.println(hasPair(nums, 20)); // false
    }
}
