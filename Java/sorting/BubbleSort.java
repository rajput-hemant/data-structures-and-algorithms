package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = SortHelper.takeInput();
        int sort = SortHelper.sort();
        bubbleSort(arr, sort);
        SortHelper.printSortedArray(arr);
    }

    // Time Compelexity = O(n^2)
    public static void bubbleSort(int[] arr, int sort) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                // For sorting in Ascending Order
                if (sort == 1) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
                // For Sorting in Descending Order
                else {
                    if (arr[j] < arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
