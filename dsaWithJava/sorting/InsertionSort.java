package sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = SortHelper.takeInput();
        int sort = SortHelper.sort();
        insertionSort(arr, sort);
        SortHelper.printSortedArray(arr);

        sc.close();
    }

    // Time Complexity = O(n^2)
    public static void insertionSort(int[] arr, int sort) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            // Sorting in Ascending Order
            if (sort == 1) {
                // This loop pushes bigger element backward to make room for smaller element
                while (j >= 0 && current < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }
            // Sorting in Descending Order
            else {
                // This loop pushes smaller element backward to make room for bigger element
                while (j >= 0 && arr[j] < current) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }
            // Placing the current value
            arr[j + 1] = current;
        }
    }
}
