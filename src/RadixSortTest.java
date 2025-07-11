public class RadixSortTest {
    public static void main(String[] args) {
        Integer[] data = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        
        RadixSort.radixSort(data);

        System.out.println("\nSorted array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}