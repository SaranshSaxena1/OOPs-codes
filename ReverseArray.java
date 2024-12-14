public class ReverseArray {

    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Original array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        reverseArray(arr, 0, arr.length - 1);

        System.out.println("\nReversed array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
