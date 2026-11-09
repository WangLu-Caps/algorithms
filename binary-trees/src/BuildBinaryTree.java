/**
 * Problem: reconstruct a binary tree from an array that stores the tree in
 *          level-order (breadth-first) representation.
 *
 * How the parent-child relation is determined:
 *   - the root is always at index 0;
 *   - the left child of node i  is at index 2*i + 1;
 *   - the right child of node i is at index 2*i + 2;
 *   - the parent of node j is at index (j - 1) / 2.
 *
 * Data structure used for the nodes: each node is a TreeNode object holding
 * a value and two references (left / right). The array is only an input
 * representation; the actual tree is a linked structure of TreeNode objects.
 *
 * Time complexity:  O(n) - every array element becomes exactly one node
 * Space complexity: O(n) for the nodes (plus O(h) recursion stack)
 */
public class BuildBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode buildTree(int[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        TreeNode root = new TreeNode(arr[i]);
        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);
        return root;
    }

    // helper: print the tree in pre-order (value(left, right))
    static String preOrder(TreeNode root) {
        if (root == null) return "null";
        return root.val + "(" + preOrder(root.left) + "," + preOrder(root.right) + ")";
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildTree(arr, 0);
        System.out.println(preOrder(root));
        // 1(2(4(null,null),5(null,null)),3(6(null,null),7(null,null)))
    }
}
