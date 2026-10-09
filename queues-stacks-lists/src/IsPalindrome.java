import java.util.Stack;

/**
 * Problem: check whether a string is a palindrome (reads the same in both
 *          directions).
 *
 * Approach 1 (two pointers, optimal): compare characters from both ends,
 *           moving inward.
 *
 * Approach 2 (stack, as shown in the seminar): push all characters onto a
 *           stack, then pop and compare with the original string. A stack
 *           reverses the order, so a palindrome must match.
 *
 * Time complexity:  O(n) for both approaches
 * Space complexity: O(1) for two pointers, O(n) for the stack
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : s.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));      // true
        System.out.println(isPalindrome("hello"));        // false
        System.out.println(isPalindromeStack("racecar")); // true
        System.out.println(isPalindromeStack("hello"));   // false
    }
}
