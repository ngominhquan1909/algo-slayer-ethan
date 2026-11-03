
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap {

    private final List<Integer> heap;

    // Constructor: tạo MinHeap rỗng
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Constructor: xây dựng MinHeap từ mảng
    public MinHeap(int[] arr) {
        heap = new ArrayList<>();

        for (int value : arr) {
            heap.add(value);
        }

        // Heapify bottom-up
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            sink(i);
        }
    }

    // Tính chỉ số node cha
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Tính chỉ số node con trái
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Tính chỉ số node con phải
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

    // Xem phần tử nhỏ nhất
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap.get(0);
    }

    // Thêm phần tử
    public void insert(int value) {
        heap.add(value);

        swim(heap.size() - 1);
    }

    // Đưa node lên trên
    private void swim(int index) {
        while (index > 0) {
            int parentIndex = parent(index);

            // Nếu node hiện tại >= node cha thì dừng
            if (heap.get(index) >= heap.get(parentIndex)) {
                break;
            }

            swap(index, parentIndex);

            index = parentIndex;
        }
    }

    // Lấy và xóa phần tử nhỏ nhất
    public int extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int min = heap.get(0);

        // Heap chỉ có một phần tử
        if (heap.size() == 1) {
            heap.remove(0);
            return min;
        }

        // Đổi root với phần tử cuối
        swap(0, heap.size() - 1);

        // Xóa phần tử min cũ
        heap.remove(heap.size() - 1);

        // Khôi phục tính chất MinHeap
        sink(0);

        return min;
    }

    // Đưa node xuống dưới
    private void sink(int index) {
        int n = heap.size();

        while (leftChild(index) < n) {
            int smallestChild = leftChild(index);

            // Chọn node con nhỏ hơn
            if (rightChild(index) < n
                    && heap.get(rightChild(index))
                    < heap.get(leftChild(index))) {

                smallestChild = rightChild(index);
            }

            // Nếu node hiện tại <= node con nhỏ nhất
            // thì Heap đã hợp lệ
            if (heap.get(index) <= heap.get(smallestChild)) {
                break;
            }

            swap(index, smallestChild);

            index = smallestChild;
        }
    }

    // Hoán đổi hai phần tử
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Hiển thị Heap
    public void display() {
        System.out.println(heap);
    }

    // Trả về bản sao các phần tử
    public int[] toArray() {
        int[] result = new int[heap.size()];

        for (int i = 0; i < heap.size(); i++) {
            result[i] = heap.get(i);
        }

        return result;
    }

    // In các phần tử theo thứ tự tăng dần
    public void printAscending() {
        MinHeap copy = new MinHeap(toArray());

        while (!copy.isEmpty()) {
            System.out.print(copy.extractMin() + " ");
        }

        System.out.println();
    }

    // Demo
    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(15);

        System.out.println("MinHeap:");
        minHeap.display();

        System.out.println("Minimum: " + minHeap.peek());

        System.out.println("Extract min: " + minHeap.extractMin());

        System.out.println("Heap after extract:");
        minHeap.display();

        System.out.println("Insert 2:");
        minHeap.insert(2);
        minHeap.display();

        System.out.println("Ascending order:");
        minHeap.printAscending();

        System.out.println("Build MinHeap from array:");

        MinHeap anotherHeap =
                new MinHeap(new int[]{4, 10, 3, 5, 1, 15});

        anotherHeap.display();
    }
}
