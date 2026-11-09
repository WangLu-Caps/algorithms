import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: given two binary trees, check whether they are identical - the
 *          same structure and the same node values.
 *
 * Approach (recursive): two trees are identical when, at every corresponding
 *          pair of nodes:
 *            - both nodes are null, or
 *            - both are non-null, have equal values, and both the left
 *              subtrees and the right subtrees are identical.
 *          If only one of the two nodes is null, or the values differ, the
 *          trees are not identical at that level.
 *
 * Time complexity:  O(n)
 * Space complexity: O(h) recursion stack
 */
public class SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
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
        TreeNode t1 = build(new Integer[]{1, 2, 3});
        TreeNode t2 = build(new Integer[]{1, 2, 3});
        TreeNode t3 = build(new Integer[]{1, 2});
        System.out.println(isSameTree(t1, t2)); // true
        System.out.println(isSameTree(t1, t3)); // false
    }
}
