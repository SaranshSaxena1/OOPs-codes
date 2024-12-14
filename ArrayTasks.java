public class ArrayTasks {

    // (a) Smallest even number in the array
    public static int smallestEven(int[] arr, int n) {
        if (n == 0) {
            return Integer.MAX_VALUE;
        }

        if (arr[n - 1] % 2 == 0) {
            return Math.min(arr[n - 1], smallestEven(arr, n - 1));
        }

        return smallestEven(arr, n - 1);
    }

    // (b) Largest odd number in the array
    public static int largestOdd(int[] arr, int n) {
        if (n == 0) {
            return Integer.MIN_VALUE; 
        }

        if (arr[n - 1] % 2 != 0) {
            return Math.max(arr[n - 1], largestOdd(arr, n - 1));
        }

        return largestOdd(arr, n - 1);
    }

    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    
    public static int largestPrimeFactor(int num) {
        int largestPrime = -1;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && isPrime(i)) {
                largestPrime = i;
            }
        }
        return largestPrime;
    }

    // (c) Largest prime factor among the factors of all elements in the array
    public static int largestPrimeFactorAll(int[] arr, int n) {
        if (n == 0) {
            return -1;
        }
        return Math.max(largestPrimeFactor(arr[n - 1]), largestPrimeFactorAll(arr, n - 1));
    }

    
    public static void main(String[] args) {
        int[] arr = {7, 2, 10, 11, 1, 14, 8, 5};
        int n = arr.length;

        
        int smallestEvenNumber = smallestEven(arr, n);
        if (smallestEvenNumber == Integer.MAX_VALUE) {
            System.out.println("No even numbers in the array.");
        } else {
            System.out.println("Smallest even number: " + smallestEvenNumber);
        }

        
        int largestOddNumber = largestOdd(arr, n);
        if (largestOddNumber == Integer.MIN_VALUE) {
            System.out.println("No odd numbers in the array.");
        } else {
            System.out.println("Largest odd number: " + largestOddNumber);
        }

        
        int largestPrimeFactorResult = largestPrimeFactorAll(arr, n);
        if (largestPrimeFactorResult == -1) {
            System.out.println("No prime factors found.");
        } else {
            System.out.println("Largest prime factor: " + largestPrimeFactorResult);
        }
    }
}
