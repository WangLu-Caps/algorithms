import java.util.HashMap;
import java.util.Map;

/**
 * Problem: string b is formed from string a by shuffling its characters and
 *          adding one new letter. Return the added letter.
 *
 * Approach 1 (hash map): count occurrences of every character in b, then
 *           subtract the characters of a. The character left with a positive
 *           count is the added one.
 *
 * Approach 2 (XOR): XOR the codes of all characters of both strings. Each
 *           character of a appears twice and cancels out (x ^ x = 0), leaving
 *           only the code of the added letter.
 *
 * Time complexity:  O(n)
 * Space complexity: O(k) for the map, O(1) for XOR
 */
public class FindAddedLetter {

    public static char findAddedLetter(String a, String b) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : b.toCharArray()) {
            count.merge(c, 1, Integer::sum);
        }
        for (char c : a.toCharArray()) {
            count.merge(c, -1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> e : count.entrySet()) {
            if (e.getValue() > 0) {
                return e.getKey();
            }
        }
        return '\0'; // no extra letter
    }

    public static char findAddedLetterXor(String a, String b) {
        int result = 0;
        for (char c : a.toCharArray()) result ^= c;
        for (char c : b.toCharArray()) result ^= c;
        return (char) result;
    }

    public static void main(String[] args) {
        System.out.println(findAddedLetter("abcd", "abcde"));  // e
        System.out.println(findAddedLetter("", "y"));          // y
        System.out.println(findAddedLetterXor("aab", "abaa")); // a
        System.out.println(findAddedLetterXor("fe", "efo"));   // o
    }
}
