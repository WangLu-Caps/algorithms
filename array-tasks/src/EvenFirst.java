import java.util.Arrays;

/**
 * Problem: move all even numbers to the front of an unsorted integer array,
 *          preserving the relative order of the even numbers.
 *          Example: [3, 2, 4, 1, 11, 8, 9] -> [2, 4, 8, 1, 11, 3, 9].
 *
 * Approach: keep an index evenIndex for where the next even number should go.
 *           Scan the array; whenever an even number is found, swap it into
 *           position evenIndex and increment evenIndex.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class EvenFirst {

    public static void evenFirst(int[] arr) {
        int evenIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                int tmp = arr[i];
                arr[i] = arr[evenIndex];
                arr[evenIndex] = tmp;
                evenIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 11, 8, 9};
        evenFirst(arr);
        System.out.println(Arrays.toString(arr)); // [2, 4, 8, 1, 11, 3, 9]

        int[] arr2 = {1, 2, 3, 4};
        evenFirst(arr2);
        System.out.println(Arrays.toString(arr2)); // [2, 4, 3, 1]
    }
}
