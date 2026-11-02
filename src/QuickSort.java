import java.util.Arrays;
public class QuickSort{
    public static void quickSort(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
    }
    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int indexOfPivot = partition(arr, left, right);
            quickSort(arr, left, indexOfPivot - 1);
            quickSort(arr, indexOfPivot + 1, right);
        }
    }
    public static int partition(int[] arr, int left, int right){
        int i = left - 1;
        int pivot = arr[right];
        for (int j = left; j <= right; j ++){
            if (arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        return i;
    }
    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void main(String[] args){
        int[] arr = {6, 3, 8, 2, 7, 1, 5};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}