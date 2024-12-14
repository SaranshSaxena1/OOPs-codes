import java.util.Arrays;
import java.util.Collections;

public class SortExample {

    
    public static void sort(int[] arr, int n) {
        Arrays.sort(arr);
        System.out.println("Sorted integer array (ascending): " + Arrays.toString(arr));
    }

    
    public static void sort(int[] arr, int n, boolean reverse) {
        if (reverse) {
            Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(arrInteger, Collections.reverseOrder());
            System.out.println("Sorted integer array (descending): " + Arrays.toString(arrInteger));
        } else {
            sort(arr, n);
        }
    }

    
    public static void sort(String[] arr, int n) {
        Arrays.sort(arr);
        System.out.println("Sorted String array (lexicographically): " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] intArray = {5, 3, 8, 1, 2};
        String[] strArray = {"banana", "apple", "cherry", "date"};

        
        sort(intArray, intArray.length);

        
        sort(intArray, intArray.length, true);

        
        sort(strArray, strArray.length);
    }
}
