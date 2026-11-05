package algorithms.sort;

import java.util.Arrays;

public class HeapSort {

    // Sắp xếp mảng theo thứ tự tăng dần
    public static void sort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        // Giai đoạn 1: Xây dựng Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(arr, i, n);
        }

        // Giai đoạn 2: Đưa max về cuối mảng
        for (int end = n - 1; end > 0; end--) {

            // Đổi phần tử lớn nhất với phần tử cuối Heap
            swap(arr, 0, end);

            // Heap giảm kích thước còn end phần tử
            // Khôi phục Max Heap
            sink(arr, 0, end);
        }
    }

    // Đưa node tại index k xuống vị trí phù hợp
    private static void sink(int[] arr, int k, int size) {

        while (2 * k + 1 < size) {

            int left = 2 * k + 1;
            int right = 2 * k + 2;

            // Chọn con lớn hơn
            int largerChild = left;

            if (right < size && arr[right] > arr[left]) {
                largerChild = right;
            }

            // Nếu cha >= con lớn hơn thì Heap hợp lệ
            if (arr[k] >= arr[largerChild]) {
                break;
            }

            // Nếu cha nhỏ hơn con thì đổi chỗ
            swap(arr, k, largerChild);

            // Tiếp tục từ vị trí con
            k = largerChild;
        }
    }

    // Hoán đổi hai phần tử
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {4, 10, 3, 5, 1};

        System.out.println("Before: " + Arrays.toString(arr));

        sort(arr);

        System.out.println("After:  " + Arrays.toString(arr));
    }
}
