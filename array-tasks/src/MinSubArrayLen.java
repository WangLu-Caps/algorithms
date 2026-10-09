/**
 * Problem: given an array of positive integers and a positive target,
 *          return the minimal length of a contiguous subarray whose sum is
 *          greater than or equal to target, or 0 if no such subarray exists
 *          (LeetCode 209).
 *
 * Approach: sliding window. Expand the right edge of the window, and while
 *           the window sum is >= target, shrink it from the left and update
 *           the minimum length.
 *
 * Time complexity:  O(n) - each element is added and removed at most once
 * Space complexity: O(1)
 */
public class MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                }
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));  // 2  -> [4, 3]

        int[] nums2 = {1, 4, 4};
        System.out.println(minSubArrayLen(4, nums2)); // 1  -> [4]

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(11, nums3)); // 0 -> no such subarray
    }
}
