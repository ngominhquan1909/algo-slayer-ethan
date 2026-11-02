
import java.util.Arrays;
import java.util.Random;

public class QuickSortWithShuffle {

    private static final Random RANDOM = new Random();

    public static void sort(int[] arr) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);

        sort(arr, low, pivotIndex - 1);
        sort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot = arr[low];

        while (true) {
            while (arr[++i] < pivot) {
                if (i == high) {
                    break;
                }
            }

            while (arr[--j] > pivot) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
        }

        swap(arr, low, j);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Before: " + Arrays.toString(arr));

        sort(arr);

        System.out.println("After:  " + Arrays.toString(arr));
    }
}
