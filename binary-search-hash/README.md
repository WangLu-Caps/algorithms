# Binary search and hash structures — homework 3

Solutions to homework № 3 (binary search + hash tables), implemented in Java.
Each problem lives in its own file in `src/` with an explanation and the time
and space complexity in the header comment.

## Problems

| # | File | Problem | Time | Space |
|---|------|---------|------|-------|
| 1 | `SqrtBinarySearch.java` | Integer square root (floor) by binary search | O(log n) | O(1) |
| 2 | `TwoCopiers.java` | Min time to make n copies with two copiers | O(log n) | O(1) |
| 3 | `FeedAnimals.java` | Max animals fed (greedy) | O(n log n) | O(1) |
| 4 | `FindAddedLetter.java` | Find the added letter (hash map / XOR) | O(n) | O(k) / O(1) |
| 5 | `TwoSum.java` | Two sum in an unsorted array (hash map) | O(n) | O(n) |
| 6 | `GroupAnagrams.java` | Group anagrams (hash map + frequency key) | O(N·k) | O(N·k) |
| 7 | `ShellSort.java` | Shell sort (extra, from the seminar) | O(n^2) worst | O(1) |

## How to run

Compile all files:

```
javac src/*.java
```

Run a single problem, for example:

```
java -cp src SqrtBinarySearch
java -cp src GroupAnagrams
```

Each class has a `main` method that runs a few example cases and prints
the results, so you can check the output directly.
