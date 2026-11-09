import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: group strings that are anagrams of each other. Return the groups
 *          in any order.
 *
 * Approach (hash map + frequency key): for each string build a canonical key
 *           from its character counts, so that anagrams share the same key.
 *           Group strings by that key in a hash map. Counting is O(k) per
 *           string (we do not sort the whole string).
 *
 * Time complexity:  O(N * k), where N is the number of strings and k the max
 *           length of a string (plus O(d log d) for sorting the distinct
 *           characters of each key)
 * Space complexity: O(N * k)
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            String key = keyOf(s);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    private static String keyOf(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        List<Character> letters = new ArrayList<>(cnt.keySet());
        Collections.sort(letters);
        StringBuilder sb = new StringBuilder();
        for (char c : letters) {
            sb.append(c).append(cnt.get(c)).append('#');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{"won", "now", "aaa", "ooo", "ooo"}));
    }
}
