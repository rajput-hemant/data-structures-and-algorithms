package sorting;

public class HeapSort {
    public static void heapSort(int[] arr, int sort) {
        buildHeap(arr, arr.length, sort);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            if (sort == 1)
                maxHeapify(arr, i, 0);
            else
                minHeapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr, int n, int sort) {
        int bmrmin = n - 2 / 2; // bottom most right most internal node
        for (int i = bmrmin; i >= 0; i--) {
            // For sorting in Ascending Order
            if (sort == 1)
                maxHeapify(arr, n, i);
            // For sorting in Descending Order
            else
                minHeapify(arr, n, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    private static void maxHeapify(int[] arr, int n, int index) {
        int largest = index, lChild = 2 * index + 1, rChild = 2 * index + 2;
        if (lChild < n && arr[lChild] > arr[largest])
            largest = lChild;
        if (rChild < n && arr[rChild] > arr[largest])
            largest = rChild;
        if (largest != index) {
            swap(arr, index, largest);
            maxHeapify(arr, n, largest);
        }
    }

    private static void minHeapify(int[] arr, int n, int index) {
        int smallest = index, lChild = 2 * index + 1, rChild = 2 * index + 2;
        if (lChild < n && arr[lChild] < arr[smallest])
            smallest = lChild;
        if (rChild < n && arr[rChild] < arr[smallest])
            smallest = rChild;
        if (smallest != index) {
            swap(arr, index, smallest);
            minHeapify(arr, n, smallest);
        }
    }

    public static void main(String[] args) {
        int[] arr = SortHelper.takeInput();
        heapSort(arr, SortHelper.sort());
        SortHelper.printSortedArray(arr);
    }
}
