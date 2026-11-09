/**
 * Problem: a binary search tree (BST) is given as an array in level-order
 *          representation (root at index 0, left child 2*i+1, right child
 *          2*i+2). Find the product of the minimum and maximum values.
 *
 * Approach using BST properties: in a BST the minimum value is the leftmost
 * node and the maximum value is the rightmost node. Thanks to the array
 * layout we can reach them by following child indices:
 *   min: start at the root's left child (index 1) and keep moving to the
 *        left child (i = 2*i + 1);
 *   max: start at the root's right child (index 2) and keep moving to the
 *        right child (i = 2*i + 2).
 *
 * Why O(h): each search walks down a single root-to-leaf path, and such a
 *          path has length equal to the tree height h, so both searches run
 *          in O(h) time.
 *
 * Time complexity:  O(h), where h is the tree height
 * Space complexity: O(1)
 */
public class MinMaxProduct {

    public static int minMaxProduct(int[] data) {
        if (data.length < 3) {
            return -1; // need at least root + left child + right child
        }
        int minIndex = 1;
        for (int i = 1; i < data.length; i = 2 * i + 1) {
            minIndex = i;
        }
        int maxIndex = 2;
        for (int i = 2; i < data.length; i = 2 * i + 2) {
            maxIndex = i;
        }
        return data[minIndex] * data[maxIndex];
    }

    public static void main(String[] args) {
        // level-order BST: 8, 3, 10, 1, 6, 9, 14  -> min=1, max=14 -> 14
        System.out.println(minMaxProduct(new int[]{8, 3, 10, 1, 6, 9, 14})); // 14
        // 5, 2, 7 -> min=2, max=7 -> 14
        System.out.println(minMaxProduct(new int[]{5, 2, 7})); // 14
    }
}
