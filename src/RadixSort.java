import java.util.*;

public class RadixSort {

    public static void radixSort(Integer[] arr) {
        // Sorting using base 10
        final int RADIX = 10;

        // Determine the integer with the most digits (EX: 100 = 3 digits)
        int max = Collections.max(Arrays.asList(arr));

        // Loops per digit place (e.g. ones, tens, hundreds)
        // EX: if max = 100 then loops 3 times. 1000 = loops 4 times, etc
        for (int exp = 1; max / exp > 0; exp *= RADIX) {
            countingSortByDigit(arr, exp);
        }
    }

    // Count sort method that sorts by digit in 1s, 10s, 100s place
    private static void countingSortByDigit(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n]; // Temporary array for sorted values
        int[] count = new int[10]; // Count array for digits 0-9

        // Count occurences of digits in each digit place
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] to represent position in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Builds output array in reverse to maintain proper sorting order
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