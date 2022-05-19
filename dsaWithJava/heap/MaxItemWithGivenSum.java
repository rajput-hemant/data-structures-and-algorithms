package heap;

import java.util.Arrays;

public class MaxItemWithGivenSum {
    /**
     * Time Complexity -> O(n * logn)
     * <p>
     * Auxiliary Space -> O(1)
     * 
     * @param arr Array of items cost
     * @param sum Total amount in the hand
     * @return Number of item that can be purchased
     */
    public static int maxItemUsingSortedArray(int[] arr, int sum) {
        int count = 0;
        Arrays.sort(arr);
        for (int i : arr) {
            if (i > sum)
                return count;
            count++;
            sum -= i;
        }
        return count;
    }

    /**
     * Time Complexity -> O(n * logn)
     * <p>
     * Auxiliary Space -> O(n)
     * 
     * @param arr Array of items cost
     * @param sum Total amount in the hand
     * @return Number of item that can be purchased
     */
    public static int maxItemUsingHeap(int[] arr, int sum) {
        PriorityQueue pq = new PriorityQueue();
        for (int i : arr)
            pq.add(i);
        int count = 0;
        while (!pq.isEmpty() && pq.peek() <= sum) {
            sum -= pq.poll();
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 12, 5, 111, 200 };
        System.out.println(maxItemUsingSortedArray(arr, 11));
        System.out.println(maxItemUsingHeap(arr, 11));
    }
}
