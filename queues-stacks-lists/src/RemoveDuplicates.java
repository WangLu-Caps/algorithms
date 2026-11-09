import java.util.Arrays;

/**
 * Problem (homework 2, task 7): given a sorted array, remove duplicates
 *          in-place so that each element appears only once, and return the
 *          new length.
 *
 * Approach: two pointers (slow and fast). fast scans the array; whenever it
 *           finds a new value (different from the previous unique value),
 *           that value is copied to the slow position and slow advances.
 *           This overwrites duplicates in-place without extra memory.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 1; // position where the next unique value goes
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int len = removeDuplicates(a);
        System.out.println("length=" + len + " first=" + Arrays.toString(Arrays.copyOf(a, len))); // 2, [1, 2]

        int[] b = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = removeDuplicates(b);
        System.out.println("length=" + len2 + " first=" + Arrays.toString(Arrays.copyOf(b, len2))); // 5, [0, 1, 2, 3, 4]
    }
}
