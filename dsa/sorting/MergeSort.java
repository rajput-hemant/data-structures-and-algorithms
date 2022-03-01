package sorting;

import java.util.Scanner;

/*
* merge sort = recursively divide array in 2, sort, re-combine
* run-time complexity = O(n Log n)
* space complexity    = O(n)
*/
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = SortHelper.takeInput();
        int sort = SortHelper.sort();
        mergeSort(arr, sort);
        SortHelper.printSortedArray(arr);
        sc.close();
    }

    public static void mergeSort(int[] arr, int sort) {
        mergeSort(arr, 0, arr.length - 1, sort);
    }

    // Time Complexity -> O(logn)
    // main function that sorts the halves of the [] using merge()
    private static void mergeSort(int[] arr, int startIndex, int endingIndex, int sort) {
        // base case
        if (startIndex >= endingIndex)
            return;
        // mid can be calculated by (start+end)/2 also,
        // but in case if sum of start & end is much greater than the int can hold
        // then the formula below will come in handy
        int midIndex = startIndex + (endingIndex - startIndex) / 2;
        // sort first half of the [] i.e. from start to mid using recursion
        mergeSort(arr, startIndex, midIndex, sort);
        // sort second half of the [] i.e. from mid+1 to end using recursion
        mergeSort(arr, midIndex + 1, endingIndex, sort);
        // merge the sorted two halves
        merge(arr, startIndex, midIndex, endingIndex, sort);
    }

    // Time Complexity -> O(n)
    // Fn two merge two sorted halves of []s
    private static void merge(int[] arr, int startIndex, int midIndex, int endingIndex, int sort) {
        int[] merged = new int[endingIndex - startIndex + 1];
        int start = startIndex, size = 0, mid = midIndex + 1;
        // traversing both halves of the []
        while (start <= midIndex && mid <= endingIndex) {
            // For sorting in Ascending Order
            if (sort == 1) {
                // if element in the first half is smaller than or equal to the element in the
                // second half of the []
                if (arr[start] <= arr[mid])
                    merged[size++] = arr[start++];
                else
                    merged[size++] = arr[mid++];
            }
            // For sorting in Descending Order
            else {
                // if element in the first half is greater than or equal to the element in the
                // second half of the []
                if (arr[start] >= arr[mid])
                    merged[size++] = arr[start++];
                else
                    merged[size++] = arr[mid++];
            }
        }
        // copying the remaing element of the left half of []
        while (start <= midIndex)
            merged[size++] = arr[start++];
        // copying the remaing element of the right half of []
        while (mid <= endingIndex)
            merged[size++] = arr[mid++];
        // Copying elements from merged [] to original []
        for (int i = 0, j = startIndex; i < merged.length; i++, j++)
            arr[j] = merged[i];
    }
}
