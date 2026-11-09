import java.util.Arrays;

/**
 * Problem: given animals with integer food needs and available integer food
 *          portions (each portion feeds at most one animal whose need is
 *          <= the portion size), return the maximum number of fed animals.
 *
 * Approach (greedy): sort both arrays. Give the smallest portions to the
 *           least-needy animals first: if the current portion covers the
 *           current (least needy, not yet fed) animal, feed it and advance.
 *
 * Why it is optimal (exchange argument): the smallest usable portion is never
 *           worse when given to the least-needy animal. If a portion cannot
 *           feed even that animal, it cannot feed anyone and can be skipped.
 *
 * Time complexity:  O(n log n + m log m) for sorting, then O(n + m)
 * Space complexity: O(1) (sorting is in-place)
 */
public class FeedAnimals {

    public static int feedAnimals(int[] needs, int[] portions) {
        Arrays.sort(needs);
        Arrays.sort(portions);
        int fed = 0;
        for (int p : portions) {
            if (fed < needs.length && p >= needs[fed]) {
                fed++;
            }
            if (fed == needs.length) {
                break;
            }
        }
        return fed;
    }

    public static void main(String[] args) {
        System.out.println(feedAnimals(new int[]{3, 4, 7}, new int[]{8, 1, 2}));       // 1
        System.out.println(feedAnimals(new int[]{8, 2, 3, 2}, new int[]{1, 4, 3, 8})); // 3
    }
}
