import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: check whether a binary tree is symmetric (a mirror of itself
 *          around its center).
 *
 * Approach (recursive mirror comparison): a tree is symmetric exactly when
 * its left and right subtrees are mirror images of each other. Two nodes are
 * mirrors when:
 *   - both are null, or
 *   - both are non-null, have equal values, and
 *       left.left is a mirror of right.right  AND
 *       left.right is a mirror of right.left.
 * These are the pairs of nodes we compare: a mirror flips the left/right
 * order, so the outer children and the inner children must match each other.
 *
 * Time complexity:  O(n)
 * Space complexity: O(h) recursion stack (h = tree height)
 */
public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    // helper: build a tree from a level-order array (null = missing node)
    static TreeNode build(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode cur = q.poll();
            if (arr[i] != null) { cur.left = new TreeNode(arr[i]); q.add(cur.left); }
            i++;
            if (i < arr.length && arr[i] != null) { cur.right = new TreeNode(arr[i]); q.add(cur.right); }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        // symmetric: 1, 2, 2, 3, 4, 4, 3
        System.out.println(isSymmetric(build(new Integer[]{1, 2, 2, 3, 4, 4, 3}))); // true
        // not symmetric: 1, 2, 2, null, 3, null, 3
        System.out.println(isSymmetric(build(new Integer[]{1, 2, 2, null, 3, null, 3}))); // false
    }
}
