# Algorithm & Data Structure Review Order

1. **`SinglyLinkedList`** — Master pointer manipulation (`head`, `tail`), traversal, insertion, and deletion.
2. **`TreeNode`** — Understand binary tree node structure (`val`, `left`, `right`) and recursive traversals (pre-order, in-order, post-order).
3. **`MinHeap` & `MaxHeap`** — Learn array-based complete binary tree representation and core `heapifyUp` / `heapifyDown` operations (prerequisite for `HeapSort`).
4. **`SelectionSort`** — Repeatedly find the minimum element from the unsorted part and place it at the beginning ($O(n^2)$).
5. **`BubbleSort`** — Repeatedly swap adjacent elements if they are in the wrong order ($O(n^2)$).
6. **`InsertionSort`** — Build the final sorted array one item at a time by shifting elements ($O(n^2)$, efficient for nearly sorted or small arrays).
7. **`BinarySearch`** — Search a sorted array by repeatedly dividing the search interval in half ($O(\log n)$).
8. **`MergeSort`** — Divide and conquer algorithm that splits the array, recursively sorts, and merges subarrays ($O(n \log n)$ time, $O(n)$ space).
9. **`QuickSort` & `QuickSortWithShuffle`** — Partition array around a `pivot`; use random shuffling to prevent $O(n^2)$ worst-case complexity on sorted inputs.
10. **`HeapSort`** — Build a heap and repeatedly extract the root element to sort the array in-place ($O(n \log n)$ time, $O(1)$ space).
11. **`CommonElements` & `CountPairs`** — Apply sorting combined with `BinarySearch` or Two Pointers to find intersections or count valid pairs efficiently.
12. **`ThreeSum`** — Sort the array, fix one element, and use the Two Pointers technique to find triplets summing to zero in $O(n^2)$ time.