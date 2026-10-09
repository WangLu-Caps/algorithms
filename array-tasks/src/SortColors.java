import java.util.Arrays;

/**
 * Problem: sort an array of 0s, 1s and 2s in one pass (the Dutch national
 *          flag problem, LeetCode 75).
 *
 * Approach: three pointers.
 *           low  - where the next 0 should go,
 *           mid  - the current element being inspected,
 *           high - where the next 2 should go.
 *           0 -> swap with low,  advance low and mid;
 *           1 -> just advance mid;
 *           2 -> swap with high, decrease high.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums)); // [0, 0, 1, 1, 2, 2]

        int[] nums2 = {2, 0, 1};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2)); // [0, 1, 2]
    }
}
