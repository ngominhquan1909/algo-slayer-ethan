import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
    public static void threeSum(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++){
            if (i > 0 && arr[i] == arr[i - 1]){
                continue;
            }
            if (arr[i] > 0){
                break;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0){
                    result.add(Arrays.asList(arr[i],arr[left], arr[right]));
                    left++;
                    right--;
                    while ((left < right) && (arr[left] == arr[left - 1])){
                        left++;
                    }
                    while ((left < right) && (arr[right] == arr[right + 1])){
                        right--;
                    }
                }

                else if (sum > 0){
                    right--;
                }
                 else {
                    left++;
                }
            }
        }
        for (List<Integer> i:result){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        int[] arr = {-1, 0, 1, 2, -1, -4};
        threeSum(arr);
    }
}
