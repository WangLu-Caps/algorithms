# Binary trees and binary search trees — homework 4

Solutions to homework № 4 (binary tree / BST), implemented in Java. Each
problem lives in its own file in `src/` with an explanation and the time and
space complexity in the header comment.

## Problems

| # | File | Problem | Time | Space |
|---|------|---------|------|-------|
| 1 | `BuildBinaryTree.java` | Reconstruct a binary tree from a level-order array | O(n) | O(n) |
| 2 | `SymmetricTree.java` | Check whether a tree is symmetric | O(n) | O(h) |
| 3 | `MinDepth.java` | Minimum depth of a binary tree | O(n) | O(n) |
| 4 | `MinMaxProduct.java` | Product of min and max in a BST array | O(h) | O(1) |
| 5 | `SameTree.java` | Check whether two trees are identical | O(n) | O(h) |
| 6 | `RightSideView.java` | Right-side view of a binary tree (extra, from the seminar) | O(n) | O(n) |

## How to run

Compile all files:

```
javac src/*.java
```

Run a single problem, for example:

```
java -cp src SymmetricTree
java -cp src MinDepth
```

Each class has a `main` method that runs a few example cases and prints
the results, so you can check the output directly.
