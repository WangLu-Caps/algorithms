import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: find the minimum depth of a binary tree - the number of nodes on
 *          the shortest path from the root to the nearest leaf.
 *
 * Approach (BFS, level order): explore the tree level by level. The first
 * leaf we meet is the shallowest one, so its level is the minimum depth.
 * BFS finds the minimum depth correctly because it visits nodes in
 * increasing order of depth: it finishes level 1 before level 2, level 2
 * before level 3, and so on, so the first leaf reached is necessarily at the
 * shallowest possible depth.
 *
 * Time complexity:  O(n)
 * Space complexity: O(n) for the queue (worst case a full level)
 */
public class MinDepth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth; // first leaf -> minimum depth
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return depth;
    }

    // DFS alternative (also correct)
    public static int minDepthDFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minDepthDFS(root.right);
        if (root.right == null) return 1 + minDepthDFS(root.left);
        return 1 + Math.min(minDepthDFS(root.left), minDepthDFS(root.right));
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
        // [3,9,20,null,null,15,7] -> min depth 2 (3 -> 9)
        System.out.println(minDepth(build(new Integer[]{3, 9, 20, null, null, 15, 7}))); // 2
        // skewed: 2 -> 3 -> 4 -> 5 -> 6 -> min depth 5
        System.out.println(minDepth(build(new Integer[]{2, null, 3, null, 4, null, 5, null, 6}))); // 5
    }
}
