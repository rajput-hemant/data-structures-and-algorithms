package sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = SortHelper.takeInput();
        int sort = SortHelper.sort();
        selectionSort(arr, sort);
        SortHelper.printSortedArray(arr);
        sc.close();
    }

    // Time Compelexity = O(n^2)
    public static void selectionSort(int[] arr, int sort) {
        for (int i = 0; i < arr.length - 1; i++) {
            int swapVal = i;
            for (int j = i + 1; j < arr.length; j++) {
                // For sorting in Ascending Order
                if (sort == 1) {
                    if (arr[swapVal] > arr[j])
                        swapVal = j;
                }
                // For Sorting in Descending Order
                else {
                    if (arr[swapVal] < arr[j])
                        swapVal = j;
                }
            }
            int temp = arr[swapVal];
            arr[swapVal] = arr[i];
            arr[i] = temp;
        }
    }
}
