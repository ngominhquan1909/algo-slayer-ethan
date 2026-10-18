# Java Preparation — 25 Exercises Before LeetCode

> Goal: strengthen Java fundamentals, Collections, basic Data Structures, and core algorithmic patterns before starting LeetCode.
>
> **Rule:** Try to solve each problem yourself first. Do not use built-in algorithms or libraries when the problem explicitly forbids them. After solving each problem, analyze its **time complexity** and **space complexity**.

---

# Part 1 — Array & String Fundamentals

## 1. Second Largest Element

Given an integer array `int[] arr`, find the **second largest distinct value** in the array.

### Requirements
- Do not sort the array.
- If a second largest distinct value does not exist, return `null` or another value that you clearly define.
- Duplicate values count as only one distinct value.

### Examples

```text
Input:  [10, 5, 8, 20, 15]
Output: 15

Input:  [10, 20, 20, 5]
Output: 10
```

---

## 2. Reverse Array

Given an integer array, reverse the array **in place**.

### Requirements
- Do not create another array to store the result.
- Prefer using two pointers: `left` and `right`.

### Example

```text
Input:  [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]
```

---

## 3. Palindrome String

Given a `String`, determine whether it is a **palindrome**.

A palindrome reads the same from left to right and right to left.

### Examples

```text
Input:  "racecar"
Output: true

Input:  "hello"
Output: false

Input:  "level"
Output: true
```

### Requirements
- Prefer solving the problem with two pointers.
- Do not create a reversed copy of the string.

---

## 4. Frequency Counter

Given an integer array, count how many times each element occurs.

Store the result in:

```java
HashMap<Integer, Integer>
```

### Example

```text
Input:
[1, 2, 2, 3, 1, 2, 4]

Output:
1 -> 2
2 -> 3
3 -> 1
4 -> 1
```

### Requirements
- Use `HashMap`.
- Analyze the time and space complexity.

---

## 5. Two Sum

Given an integer array `nums` and an integer `target`, find **two different indices** `i` and `j` such that:

```text
nums[i] + nums[j] = target
```

Return the two indices.

### Example

```text
Input:
nums = [2, 7, 11, 15]
target = 9

Output:
[0, 1]
```

### Requirements

Solve the problem in at least two ways:

1. Brute force — `O(n²)`
2. Using `HashMap` — target `O(n)`

---

## 6. Remove Duplicates

Given an integer array, produce a result containing only the **distinct elements**.

### Example

```text
Input:
[1, 1, 2, 2, 3, 4, 4]

Output:
[1, 2, 3, 4]
```

### Requirements

First solve it using:

```java
HashSet
```

Then, if the input array is already sorted, try solving it again using **two pointers**.

---

## 7. Valid Parentheses

Given a string containing only:

```text
( ) [ ] { }
```

determine whether the string is valid.

A valid string must satisfy:
- Every opening bracket is closed by the correct type of bracket.
- Brackets are closed in the correct order.

### Examples

```text
Input:  "()[]{}"
Output: true

Input:  "([)]"
Output: false

Input:  "{[]}"
Output: true
```

### Requirements
- Use a Stack.
- In Java, you may use `Deque<Character>`.

---

## 8. Merge Two Sorted Arrays

Given two integer arrays sorted in ascending order:

```text
A = [1, 3, 5, 7]
B = [2, 4, 6, 8]
```

merge them into one sorted array.

### Example

```text
Input:
A = [1, 3, 5, 7]
B = [2, 4, 6, 8]

Output:
[1, 2, 3, 4, 5, 6, 7, 8]
```

### Requirements
- Use two pointers.
- Do not sort the entire result again after merging.

---

## 9. Binary Search

Given a sorted integer array and a `target`, find the index of the target.

If the target does not exist, return `-1`.

### Example

```text
Input:
nums = [1, 3, 5, 7, 9, 11, 15]
target = 9

Output:
4
```

### Requirements
- Do not use `Arrays.binarySearch()`.
- Implement the algorithm using:
  - `left`
  - `right`
  - `mid`
- Target time complexity: `O(log n)`.

---

## 10. Longest Substring Without Repeating Characters

Given a string `s`, find the length of the longest substring that contains **no repeated characters**.

### Example

```text
Input:  "abcabcbb"
Output: 3
```

The longest substring is:

```text
"abc"
```

Additional examples:

```text
Input:  "bbbbb"
Output: 1

Input:  "pwwkew"
Output: 3
```

### Requirements

Use the following ideas:

```text
HashSet
+
Two Pointers
+
Sliding Window
```

---

# Part 2 — Arrays & Algorithms

## 11. Maximum Subarray Sum

Given an integer array that may contain negative numbers, find the maximum sum of any **contiguous subarray**.

### Example

```text
Input:
[-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output:
6
```

The subarray:

```text
[4, -1, 2, 1]
```

has the maximum sum of `6`.

### Requirements
- First try to find an `O(n²)` solution.
- Then optimize it to `O(n)`.
- Study the idea behind **Kadane's Algorithm**.

---

## 12. Move Zeroes

Given an integer array, move all `0`s to the end of the array.

### Requirements
- Preserve the relative order of all non-zero elements.
- Modify the original array in place.
- Minimize additional memory usage.

### Example

```text
Input:
[0, 1, 0, 3, 12]

Output:
[1, 3, 12, 0, 0]
```

---

## 13. Rotate Array

Given an integer array and an integer `k`, rotate the array to the right by `k` positions.

### Example

```text
Input:
nums = [1, 2, 3, 4, 5, 6, 7]
k = 3

Output:
[5, 6, 7, 1, 2, 3, 4]
```

### Requirements
- Try to solve it without creating another array of size `n`.
- Study the solution based on the **reverse** technique.

---

## 14. Intersection of Two Arrays

Given two integer arrays, find the elements that appear in both arrays.

Each value should appear **only once** in the result.

### Example

```text
Input:
A = [1, 2, 2, 1]
B = [2, 2]

Output:
[2]
```

### Requirements

Solve the problem in at least two ways:

1. `HashSet`
2. Sorting + Two Pointers

Compare the time and space complexity of both approaches.

---

# Part 3 — Java Collections

## 15. Group Anagrams

Given a list of strings, group the strings that are **anagrams** of each other.

Two strings are anagrams if they contain the same characters with the same frequencies, although their order may differ.

### Example

```text
Input:
["eat", "tea", "tan", "ate", "nat", "bat"]

Output:
[
    ["eat", "tea", "ate"],
    ["tan", "nat"],
    ["bat"]
]
```

### Requirements

Use:

```java
HashMap
ArrayList
```

You may create the grouping key using either:
- Sorting each string.
- Counting character frequencies.

---

## 16. First Non-Repeating Character

Given a string, find the first character that appears exactly once.

If no such character exists, return `-1`.

### Examples

```text
Input:
"leetcode"

Output:
'l'
```

```text
Input:
"loveleetcode"

Output:
'v'
```

### Requirements
Use `HashMap` to count character frequencies.

---

## 17. Contains Duplicate

Given an integer array, determine whether the array contains at least one value that appears more than once.

### Examples

```text
Input:
[1, 2, 3, 1]

Output:
true
```

```text
Input:
[1, 2, 3, 4]

Output:
false
```

### Requirements
Solve the problem using `HashSet`.

---

## 18. Top K Frequent Elements

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

### Example

```text
Input:
nums = [1, 1, 1, 2, 2, 3]
k = 2

Output:
[1, 2]
```

The order of the elements in the result does not matter.

### Requirements
Use at least:

```text
HashMap
+
Frequency Counting
```

Then try to optimize the solution using:

```java
PriorityQueue
```

---

# Part 4 — Stack / Queue / Deque

## 19. Min Stack

Design a Stack that supports:

```text
push(x)
pop()
top()
getMin()
```

`getMin()` must return the minimum element currently in the Stack.

### Example

```text
push(5)
push(3)
push(7)

getMin() -> 3

pop()

getMin() -> 3

pop()

getMin() -> 5
```

### Requirements

Each operation should run in `O(1)`:

```text
push()   -> O(1)
pop()    -> O(1)
top()    -> O(1)
getMin() -> O(1)
```

In Java, you may use `Deque`.

---

## 20. Evaluate Reverse Polish Notation

Given an expression in **Reverse Polish Notation (RPN)**, evaluate its result.

### Example

```text
Input:
["2", "1", "+", "3", "*"]

Output:
9
```

Because:

```text
(2 + 1) * 3 = 9
```

Another example:

```text
Input:
["4", "13", "5", "/", "+"]

Output:
6
```

### Requirements
- Use a Stack or `Deque`.
- Supported operators:
  - `+`
  - `-`
  - `*`
  - `/`
- Division should use Java integer division.

---

# Part 5 — Linked List

## 21. Implement Singly Linked List

Build your own Singly Linked List.

Create the following node class:

```java
class ListNode {
    int value;
    ListNode next;
}
```

Then implement a Linked List class supporting:

```text
addFirst()
addLast()
get(index)
remove(index)
size()
```

### Requirements
- Do not use `java.util.LinkedList`.
- Manage the `head` yourself.
- Understand the relationship:

```text
head
 ↓
Node → Node → Node → null
```

### Example

```text
addLast(10)
addLast(20)
addLast(30)

List:
10 → 20 → 30 → null
```

---

## 22. Reverse Linked List

Given a singly linked list:

```text
1 → 2 → 3 → 4 → null
```

reverse it into:

```text
4 → 3 → 2 → 1 → null
```

### Requirements
- Solve it iteratively.
- Use three variables:
  - `prev`
  - `current`
  - `next`
- Target time complexity: `O(n)`.
- Target space complexity: `O(1)`.

After completing the iterative solution, optionally try a recursive solution.

---

## 23. Detect Cycle in Linked List

Given a singly linked list, determine whether it contains a cycle.

### Example

A linked list without a cycle:

```text
1 → 2 → 3 → 4 → null
```

Result:

```text
false
```

A linked list with a cycle:

```text
1 → 2 → 3 → 4
        ↑   ↓
        ← ←
```

Result:

```text
true
```

### Requirements

Use:

```text
Floyd's Cycle Detection
```

with:

```text
slow pointer
fast pointer
```

Target:

```text
Time: O(n)
Space: O(1)
```

---

# Part 6 — Sorting & Binary Search

## 24. Implement Sorting Algorithms

Implement the following sorting algorithms from scratch:

### A. Bubble Sort

Input:

```text
[5, 2, 8, 1, 3]
```

Output:

```text
[1, 2, 3, 5, 8]
```

### B. Selection Sort

Sort the array in ascending order using Selection Sort.

### C. Insertion Sort

Sort the array in ascending order using Insertion Sort.

### Requirements

For each algorithm, record:

```text
Best-case time complexity
Average-case time complexity
Worst-case time complexity
Space complexity
Stable / Unstable
In-place / Not in-place
```

Then study:

```text
Merge Sort
Quick Sort
```

and record their time and space complexity.

You do not have to implement Merge Sort and Quick Sort for this exercise.

---

## 25. Binary Search Variations

Given a sorted integer array in ascending order.

### A. First Occurrence

Find the first index of `target`.

```text
Input:
nums = [1, 2, 2, 2, 3, 4]
target = 2

Output:
1
```

### B. Last Occurrence

Find the last index of `target`.

```text
Input:
nums = [1, 2, 2, 2, 3, 4]
target = 2

Output:
3
```

### C. Search Insert Position

Find the position where `target` should be inserted so that the array remains sorted.

```text
Input:
nums = [1, 3, 5, 6]
target = 2

Output:
1
```

Another example:

```text
Input:
nums = [1, 3, 5, 6]
target = 5

Output:
2
```

### Requirements
- Do not use a built-in binary search function.
- All solutions should run in `O(log n)`.
- Pay close attention to how `left`, `right`, and `mid` are updated.

---

# Final Checklist Before Starting LeetCode

After completing all 25 exercises, check whether you can do the following without constantly looking up basic Java syntax.

## Java

- [ ] Use `int[]` confidently.
- [ ] Work with `String` and `char`.
- [ ] Write `for`, `while`, and `if` logic naturally.
- [ ] Write methods without relying on external help.
- [ ] Use `ArrayList`.
- [ ] Use `HashMap`.
- [ ] Use `HashSet`.
- [ ] Use `Deque`.
- [ ] Use `PriorityQueue`.
- [ ] Create simple classes and objects.
- [ ] Create and manipulate a `ListNode`.

## Algorithmic Patterns

- [ ] Brute Force
- [ ] Hashing
- [ ] Two Pointers
- [ ] Sliding Window
- [ ] Stack
- [ ] Fast & Slow Pointers
- [ ] Sorting
- [ ] Binary Search
- [ ] Frequency Counting

## Complexity

- [ ] Understand `O(1)`.
- [ ] Understand `O(log n)`.
- [ ] Understand `O(n)`.
- [ ] Understand `O(n log n)`.
- [ ] Understand `O(n²)`.
- [ ] Analyze Space Complexity.

# Next Step

Once these 25 exercises are reasonably solid, stop doing Java-only preparation exercises.

Move to:

```text
LeetCode Easy
      ↓
Array / String
      ↓
HashMap / HashSet
      ↓
Two Pointers
      ↓
Sliding Window
      ↓
Stack / Queue
      ↓
Binary Search
      ↓
Linked List
      ↓
Tree
      ↓
Heap
      ↓
Graph
      ↓
Dynamic Programming
```

The purpose of these 25 exercises is to make **Java itself stop being an obstacle when solving LeetCode problems**. After this point, the main focus should shift to Data Structures, Algorithms, patterns, and problem-solving.
