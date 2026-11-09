import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: given an unsorted array of integers and a target, find two
 *          elements whose sum equals target. Each element may be used only
 *          once. Return their indices, or an empty array if no such pair.
 *
 * Approach (hash map): in one pass, for each element x compute need = target - x.
 *           If need was seen before, the pair is found; otherwise store x.
 *           Checking the map BEFORE inserting x guarantees that an element is
 *           never paired with itself, and replaces the O(n^2) double loop.
 *
 * Time complexity:  O(n)
 * Space complexity: O(n)
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                return new int[]{seen.get(need), i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));      // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3}, 6)));            // []
    }
}
