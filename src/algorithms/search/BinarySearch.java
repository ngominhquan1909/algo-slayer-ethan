package algorithms.search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int minIndex = -1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] > target){
                right = mid - 1;
            }
            else if (arr[mid] < target){
                left = mid + 1;
            }
            else{
                minIndex = mid;
                right = mid - 1;
            }
        }
        return minIndex;
    }
    public static void main(String[] args){
        int[] arr = {0,3,3,3,4,5};
        System.out.print(binarySearch(arr, 3));
    }
}
