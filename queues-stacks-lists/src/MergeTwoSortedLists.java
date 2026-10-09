/**
 * Problem: merge two sorted singly linked lists into one sorted list.
 *          Memory usage must be O(1) (existing nodes are reused).
 *
 * Approach: use a dummy node and a tail pointer. Compare the heads of both
 *           lists and attach the smaller node to the tail. At the end attach
 *           the remaining part of the non-empty list.
 *
 * Time complexity:  O(n + m)
 * Space complexity: O(1)
 */
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
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
        System.out.println(toString(mergeTwoLists(build(3, 6, 8), build(4, 7, 9, 11)))); // 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> 11
        System.out.println(toString(mergeTwoLists(build(1, 2, 4), build(1, 3, 4))));      // 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}
