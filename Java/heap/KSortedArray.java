package heap;

/**
 * An element at index i will be present between the index i-k to i+k in the
 * sorted array
 * <p>
 * Time Complexity -> O(k) + O((n-k) * log k)
 * <p>
 * Auxiliary Space: O(k)
 */
public class KSortedArray {
    public static void kSort(int[] arr, int k) {
        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i <= k; i++)
            pq.add(arr[i]);
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }
        while (!pq.isEmpty())
            arr[index++] = pq.poll();
    }

    public static void main(String[] args) {
        int[] arr = { 9, 8, 7, 19, 18 };
        kSort(arr, 3);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}