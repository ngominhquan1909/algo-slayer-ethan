package algorithms.sort;

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (a[j] > a[j + 1]) {
                    // Swap two adjacent elements
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};

        bubbleSort(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}