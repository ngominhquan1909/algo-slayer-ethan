package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxHeap {

    private final List<Integer> heap;

    // Constructor: tạo algorithms.MaxHeap rỗng
    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Constructor: xây dựng algorithms.MaxHeap từ mảng
    public MaxHeap(int[] arr) {
        heap = new ArrayList<>();

        for (int value : arr) {
            heap.add(value);
        }

        // Heapify từ node cha cuối cùng lên root
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            sink(i);
        }
    }

    // Trả về chỉ số node cha
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Trả về chỉ số node con trái
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Trả về chỉ số node con phải
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Kiểm tra Heap rỗng
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Trả về số phần tử
    public int size() {
        return heap.size();
    }

    // Xem phần tử lớn nhất
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap.get(0);
    }

    // Thêm phần tử vào algorithms.MaxHeap
    public void insert(int value) {
        heap.add(value);

        // Phần tử mới nằm ở cuối Heap
        swim(heap.size() - 1);
    }

    // Đưa node lên trên nếu lớn hơn node cha
    private void swim(int index) {
        while (index > 0) {
            int parentIndex = parent(index);

            if (heap.get(index) <= heap.get(parentIndex)) {
                break;
            }

            swap(index, parentIndex);

            index = parentIndex;
        }
    }

    // Lấy và xóa phần tử lớn nhất
    public int extractMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int max = heap.get(0);

        // Heap chỉ có một phần tử
        if (heap.size() == 1) {
            heap.remove(0);
            return max;
        }

        // Đưa phần tử cuối lên root
        swap(0, heap.size() - 1);

        // Xóa phần tử max cũ
        heap.remove(heap.size() - 1);

        // Khôi phục tính chất Max Heap
        sink(0);

        return max;
    }

    // Đưa node xuống dưới nếu nhỏ hơn node con
    private void sink(int index) {
        int n = heap.size();

        while (leftChild(index) < n) {
            int largestChild = leftChild(index);

            // Nếu có con phải và con phải lớn hơn con trái
            if (rightChild(index) < n
                    && heap.get(rightChild(index))
                    > heap.get(leftChild(index))) {

                largestChild = rightChild(index);
            }

            // Node hiện tại đã lớn hơn hoặc bằng con lớn nhất
            if (heap.get(index) >= heap.get(largestChild)) {
                break;
            }

            swap(index, largestChild);

            index = largestChild;
        }
    }

    // Hoán đổi hai phần tử
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Hiển thị Heap dưới dạng mảng
    public void display() {
        System.out.println(heap);
    }

    // Trả về bản sao các phần tử theo thứ tự Heap
    public int[] toArray() {
        int[] result = new int[heap.size()];

        for (int i = 0; i < heap.size(); i++) {
            result[i] = heap.get(i);
        }

        return result;
    }

    // In các phần tử theo thứ tự giảm dần
    public void printDescending() {
        MaxHeap copy = new MaxHeap(toArray());

        while (!copy.isEmpty()) {
            System.out.print(copy.extractMax() + " ");
        }

        System.out.println();
    }

    // Demo
    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.println("algorithms.MaxHeap:");
        maxHeap.display();

        System.out.println("Maximum: " + maxHeap.peek());

        System.out.println("Extract max: " + maxHeap.extractMax());

        System.out.println("Heap after extract:");
        maxHeap.display();

        System.out.println("Insert 40:");
        maxHeap.insert(40);
        maxHeap.display();

        System.out.println("Descending order:");
        maxHeap.printDescending();

        System.out.println("Build Heap from array:");

        MaxHeap anotherHeap =
                new MaxHeap(new int[]{4, 10, 3, 5, 1, 15});

        anotherHeap.display();
    }
}
