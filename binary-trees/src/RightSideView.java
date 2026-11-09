import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem (extra, from the seminar): return the values of the nodes visible
 *          when the tree is viewed from the right side - that is, the
 *          rightmost node of every level.
 *
 * Approach (BFS, level order): traverse level by level; for each level the
 *          last node in the level is the one visible from the right.
 *
 * Time complexity:  O(n)
 * Space complexity: O(n) for the queue
 */
public class RightSideView {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) {
                    result.add(node.val); // last node of the level
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return result;
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
        // [1,2,3,null,5,null,4] -> right side view [1, 3, 4]
        System.out.println(rightSideView(build(new Integer[]{1, 2, 3, null, 5, null, 4})));
        // [1,2,3,4] -> right side view [1, 3, 4]
        System.out.println(rightSideView(build(new Integer[]{1, 2, 3, 4})));
    }
}
