import java.util.Arrays;

/**
 * Problem: move all zeros to the end of an array, keeping the relative order
 *          of the non-zero elements (LeetCode 283).
 *          Example: [0, 1, 0, 3, 12] -> [1, 3, 12, 0, 0].
 *
 * Approach: keep an index insertPos for the next non-zero element. Scan the
 *           array; every non-zero element is written to insertPos. After the
 *           scan, fill the remaining positions with zeros.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a)); // [1, 3, 12, 0, 0]

        int[] b = {0, 33, 57, 88, 60, 0, 0, 80, 99};
        moveZeroes(b);
        System.out.println(Arrays.toString(b)); // [33, 57, 88, 60, 80, 99, 0, 0, 0]
    }
}
