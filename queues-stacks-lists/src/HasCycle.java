/**
 * Problem: given a singly linked list, check whether it contains a cycle.
 *          A cycle means the last node points back to one of the previous nodes.
 *
 * Approach: Floyd's cycle detection (tortoise and hare).
 *           slow moves one step, fast moves two steps.
 *           If fast reaches null, there is no cycle.
 *           If slow and fast meet, the list is cyclic.
 *
 * Time complexity:  O(n)
 * Space complexity: O(1)
 */
public class HasCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // List with a cycle: 1 -> 2 -> 3 -> 4 -> back to 2
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n2;
        System.out.println(hasCycle(n1)); // true

        // List without a cycle: 1 -> 2 -> 3
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2; a2.next = a3;
        System.out.println(hasCycle(a1)); // false
    }
}
