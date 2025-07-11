import java.util.*;

public class RadixSort {

    public static void radixSort(Integer[] arr) {
        // Sorting using base 10
        final int RADIX = 10;

        // Determine the integer with the most digits (EX: 100 = 3 digits)
        int max = Collections.max(Arrays.asList(arr));

        // Loops through array based on max # of digits determined by line 10
        // EX: 100 = loops 3 times. 1000 = loops 4 times, etc
        for (int exp = 1; max / exp > 0; exp *= RADIX) {
            countingSortByDigit(arr, exp);
        }
    }

    // Count sort method that sorts by digit in 1s, 10s, 100s place
    private static void countingSortByDigit(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n]; // Temporary container to store sorting result
        int[] count = new int[10]; // Size 10 for digits 0-9

        // Count occurences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] to represent position in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Loops through original array backwards to maintain order/stability
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy sorted elements back into original array (arr[])
        System.arraycopy(output, 0, arr, 0, n);

        // Prints after each sorting for clarity and verification
        System.out.println("After sorting by digit (exp = " + exp + "): " + Arrays.toString(arr));
    }   
}