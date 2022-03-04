package sorting;

import java.util.Scanner;

/*
* quick sort = moves smaller elements to left of a pivot recursively * * divide array in 2 partitions
* run-time complexity = Best case O(n log(n))
*                       Average case O(n log(n))
*                       Worst case O(n^2) if already sorted
* space complexity = O(log(n)) due to recursion
*/
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = SortHelper.takeInput();
        int sort = SortHelper.sort();
        quickSort(arr, sort);
        SortHelper.printSortedArray(arr);
        sc.close();
    }

    public static void quickSort(int[] arr, int sort) {
        quickSort(arr, 0, arr.length - 1, sort);
    }

    /*
     * The main function that implements QuickSort
     * arr[] --> Array to be sorted,
     * start --> Starting index,
     * end --> Ending index
     */
    private static void quickSort(int[] arr, int start, int end, int sort) {
        // base case
        if (start < end) {
            // partition fn will return the right position of the pivotIndex
            int pivotIndex = partition(arr, start, end, sort);
            // recursive call to sort smaller elements than pivot
            quickSort(arr, start, pivotIndex - 1, sort);
            // recursive call to sort greater elements than pivot
            quickSort(arr, pivotIndex + 1, end, sort);
        }
    }

    /*
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     */
    private static int partition(int[] arr, int start, int end, int sort) {
        // last element taken as pivot
        int pivot = arr[end];
        // i & j are pointers
        // when element at j is smaller/greater than the pivot,
        // the elements at i & j index will be swapped
        int i = start - 1;
        for (int j = start; j < end; j++) {
            // For Sorting in Ascending Order
            if (sort == 1) {
                // If current element is smaller than the pivot
                if (arr[j] < pivot) {
                    // i is increased to make place for the smaller value
                    i++;
                    // swapping elements, this makes all elements smaller than the pivot,
                    // shifted to the left of the pivotIndex
                    swap(arr, i, j);
                }
            }
            // For Sorting in Descending Order
            else {
                // If current element is greater than the pivot
                if (arr[j] > pivot) {
                    // i is increased to make place for the greater value
                    i++;
                    // swapping elements, this makes all elements greater than the pivot,
                    // shifted to the left of the pivotIndex
                    swap(arr, i, j);
                }
            }
        }
        // after increasing i, this will be the final index of the pivot
        i++;
        // after transvering the array i.e. till the pivot, 
        // the pivot will be swapped with the value at i
        swap(arr, i, end);
        return i;
    }

    // Fn to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
