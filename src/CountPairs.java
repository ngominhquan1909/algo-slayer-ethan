import java.util.Arrays;
public class CountPairs {
    public static long countPairs(int[] arr){
        int count = 0;
        Arrays.sort(arr);
        int i = 0;
        int n = arr.length;
        while (i < n - 1){
            int j = i + 1;
            while (j < n && arr[j] == arr[i]){
                j++;
            }
            long k = j - i;
            count += k * (k - 1) / 2;
            i = j;
        }
        return count;
    }
}
