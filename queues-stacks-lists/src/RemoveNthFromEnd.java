/**
 * Problem: remove the n-th node from the end of a singly linked list and
 *          return the updated list (LeetCode 19).
 *
 * Approach: two pointers plus a dummy node. Move fast forward n+1 steps,
 *           then move slow and fast together until fast is null. Now slow
 *           stands right before the node to remove; skip that node.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toString(removeNthFromEnd(build(1, 2, 3, 4, 5), 2))); // 1 -> 2 -> 3 -> 5
        System.out.println(toString(removeNthFromEnd(build(1, 2), 1)));          // 1
    }
}
