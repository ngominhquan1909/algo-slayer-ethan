import java.util.Arrays;

public class MergeSort{
    public static void mergeSort(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        mergeSort(arr, left, right);
    }
    public static void mergeSort(int[] arr, int left, int right){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, right);
        }
    }
    public static void merge(int[] arr, int left, int right){
        int mid = (left + right) / 2;
        int[] temp = new int[right - left + 1];
        int k = 0;
        int i = left; // left <= i <= mid
        int j = mid + 1; // mid + 1 <= j <= right
        while (i <= mid && j <= right){
            if (arr[i] > arr[j]){
                temp[k] = arr[j];
                k++;
                j++;
            }
            else if (arr[i] < arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }
            else{
                temp[k] = arr[i];
                temp[k + 1] = arr[j];
                k = k + 2;
                i++;
                j++;
            }
        }
        while (i <= mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= right){
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (int n = 0; n < temp.length; n++){
            arr[left + n] = temp[n];
        }
    }
    public static void main(String[] args){
        int[] arr = {8, 3, 5, 4, 7, 6, 1, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}