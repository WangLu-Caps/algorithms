import java.util.Stack;

/**
 * Problem: sort a stack using one additional stack.
 *          (The same idea sorts an array: push it into a stack first.)
 *
 * Approach: take the top element of the input stack, then move all elements
 *           larger than it from the auxiliary stack back to the input, then
 *           push the element onto the auxiliary stack. Repeat until the
 *           input is empty. The auxiliary stack ends up sorted in ascending
 *           order from bottom to top.
 *
 * Time complexity:  O(n^2)
 * Space complexity: O(n) for the auxiliary stack
 */
public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> aux = new Stack<>();
        while (!input.isEmpty()) {
            int current = input.pop();
            while (!aux.isEmpty() && aux.peek() > current) {
                input.push(aux.pop());
            }
            aux.push(current);
        }
        return aux;
    }

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(3);
        input.push(1);
        input.push(2); // input top = 2

        Stack<Integer> sorted = sortStack(input);
        // Iterate from bottom to top -> ascending order
        for (int v : sorted) {
            System.out.print(v + " ");
        }
        System.out.println(); // 1 2 3
    }
}
