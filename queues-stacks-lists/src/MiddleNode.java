/**
 * Problem: find the middle node of a singly linked list in O(n) time
 *          without extra memory.
 *
 * Approach: two pointers. slow moves one step, fast moves two steps.
 *           When fast reaches the end, slow points to the middle.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class MiddleNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    public static void main(String[] args) {
        System.out.println(middleNode(build(1, 2, 3, 4, 5)).val);   // 3
        System.out.println(middleNode(build(1, 2, 3, 4, 5, 6)).val); // 4
    }
}
