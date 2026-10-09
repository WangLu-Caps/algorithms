# Array tasks — Algorithms & Data Structures homework

Solutions to all problems from the "Fundamental array problems" seminar,
implemented in Java. Each problem lives in its own file in the `src/`
directory, with the time and space complexity written in the header comment.

## Problems

| # | File | Problem | Time | Space |
|---|------|---------|------|-------|
| 1 | `SumRange.java` | Sum of 1..n (arithmetic series) | O(1) | O(1) |
| 2 | `TwoSumSorted.java` | Two sum in a sorted array (two pointers) | O(n) | O(1) |
| 3 | `ReverseArray.java` | Reverse an array in-place | O(n) | O(1) |
| 4 | `RotateArray.java` | Rotate array right by k (LeetCode 189) | O(n) | O(1) |
| 5 | `MergeSortedArrays.java` | Merge two sorted arrays into a new one | O(n+m) | O(n+m) |
| 6 | `MergeSortedArrayInPlace.java` | Merge in-place (LeetCode 88) | O(n+m) | O(1) |
| 7 | `MinSubArrayLen.java` | Minimum size subarray sum (LeetCode 209) | O(n) | O(1) |
| 8 | `SortBinaryArray.java` | Sort an array of 0s and 1s | O(n) | O(1) |
| 9 | `SortColors.java` | Dutch national flag / sort 0-1-2 (LeetCode 75) | O(n) | O(1) |
| 10 | `EvenFirst.java` | Move even numbers to the front | O(n) | O(1) |
| 11 | `MoveZeroes.java` | Move zeros to the end (LeetCode 283) | O(n) | O(1) |

## How to run

Compile all files:

```
javac src/*.java
```

Run a single problem, for example:

```
java -cp src SumRange
java -cp src TwoSumSorted
```

Each class has a `main` method that runs a few example cases and prints
the results, so you can check the output directly.
