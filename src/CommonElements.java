import java.util.List;
import java.util.ArrayList;
public class CommonElements {
    public static void printCommonElements(int[] arr1, int[] arr2){
        List<Integer> result = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2){
            if (arr1[i] > arr2[j]){
                result.add(arr2[j]);
                j++;
            }
            else if (arr1[i] < arr2[j]){
                result.add(arr1[i]);
                i++;
            }
            else{
                result.add(arr1[i]);
                result.add(arr2[j]);
                i++;
                j++;
            }
        }
        while (i < n1){
            result.add(arr1[i]);
            i++;
        }
        while (j < n2){
            result.add(arr2[j]);
            j++;
        }
        System.out.println(result);
    }
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 5, 7, 9};
        int[] arr2 = {2, 3, 4, 5, 8, 9};
        printCommonElements(arr1, arr2);
    }
}
