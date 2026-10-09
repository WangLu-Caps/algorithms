/**
 * Problem: remove all nodes whose value equals val from a singly linked list.
 *
 * Approach: use a dummy node before head, so that removing the first node
 *           is handled the same way as any other node.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class RemoveElements {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
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
        System.out.println(toString(removeElements(build(1, 2, 6, 3, 4, 5, 6), 6))); // 1 -> 2 -> 3 -> 4 -> 5
        System.out.println(toString(removeElements(build(7, 7, 7), 7)));              // (empty line)
    }
}
