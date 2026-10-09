import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: given two strings a and b, check whether a is a subsequence of b
 *          (a can be obtained from b by deleting some characters without
 *          changing the relative order).
 *
 * Approach 1 (two pointers, optimal): scan b with pointer j and advance
 *           pointer i over a whenever the characters match.
 *
 * Approach 2 (queue, as shown in the seminar): put all characters of a into
 *           a queue, then scan b and remove from the queue whenever the
 *           front matches. If the queue is empty at the end, a is a
 *           subsequence of b.
 *
 * Time complexity:  O(n) for both approaches
 * Space complexity: O(1) for two pointers, O(n) for the queue
 */
public class IsSubsequence {

    public static boolean isSubsequence(String a, String b) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }

    public static boolean isSubsequenceQueue(String a, String b) {
        Queue<Character> q = new LinkedList<>();
        for (char ch : a.toCharArray()) {
            q.offer(ch);
        }
        for (char ch : b.toCharArray()) {
            if (!q.isEmpty() && q.peek() == ch) {
                q.poll();
            }
        }
        return q.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));      // true
        System.out.println(isSubsequence("axc", "ahbgdc"));      // false
        System.out.println(isSubsequenceQueue("abc", "ahbgdc")); // true
        System.out.println(isSubsequenceQueue("axc", "ahbgdc")); // false
    }
}
