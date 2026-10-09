/**
 * Problem: reverse a singly linked list.
 *
 * Approach: iterate through the list and flip each node's next pointer
 *           to point to the previous node.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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
        System.out.println(toString(reverseList(build(1, 2, 3, 4, 5)))); // 5 -> 4 -> 3 -> 2 -> 1
        System.out.println(toString(reverseList(build(1, 2))));          // 2 -> 1
    }
}
