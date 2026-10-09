import java.util.Arrays;

/**
 * Problem: merge two sorted arrays in-place, without creating a third array
 *          (LeetCode 88). nums1 has size m + n: the first m elements are
 *          sorted, the last n elements are zeros to be overwritten. nums2 has
 *          n sorted elements.
 *
 * Approach: fill nums1 from the end using three pointers:
 *           p1 - last real element of nums1, p2 - last element of nums2,
 *           p  - the position in nums1 where we write the next value.
 *           Going right-to-left lets us overwrite the zero tail safely.
 *
 * Time complexity:  O(n + m)
 * Space complexity: O(1)
 */
public class MergeSortedArrayInPlace {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;      // last real element in nums1
        int p2 = n - 1;      // last element in nums2
        int p = m + n - 1;   // position to write in nums1

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]

        int[] nums1b = {1};
        int[] nums2b = {};
        merge(nums1b, 1, nums2b, 0);
        System.out.println(Arrays.toString(nums1b)); // [1]
    }
}
