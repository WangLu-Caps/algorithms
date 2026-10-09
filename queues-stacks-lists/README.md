# Queues, deques, stacks, and linked lists — tasks

Solutions to all problems from the "Queues. Deques and stacks. Linked lists"
seminar, implemented in Java. Each problem lives in its own file in `src/`,
with the time and space complexity written in the header comment.

## Problems

| # | File | Problem | Time | Space |
|---|------|---------|------|-------|
| 1 | `HasCycle.java` | Check if a linked list has a cycle (Floyd) | O(n) | O(1) |
| 2 | `ReverseLinkedList.java` | Reverse a singly linked list | O(n) | O(1) |
| 3 | `MiddleNode.java` | Find the middle node | O(n) | O(1) |
| 4 | `RemoveElements.java` | Remove all nodes with a given value | O(n) | O(1) |
| 5 | `RemoveNthFromEnd.java` | Remove the n-th node from the end | O(n) | O(1) |
| 6 | `IsSubsequence.java` | Is one string a subsequence of another (two pointers + queue) | O(n) | O(1) / O(n) |
| 7 | `IsPalindrome.java` | Is a string a palindrome (two pointers + stack) | O(n) | O(1) / O(n) |
| 8 | `SortStack.java` | Sort a stack using an auxiliary stack | O(n^2) | O(n) |
| 9 | `MergeTwoSortedLists.java` | Merge two sorted lists (O(1) memory) | O(n+m) | O(1) |

## How to run

Compile all files:

```
javac src/*.java
```

Run a single problem, for example:

```
java -cp src HasCycle
java -cp src MergeTwoSortedLists
```

Each class has a `main` method that runs a few example cases and prints
the results, so you can check the output directly.
