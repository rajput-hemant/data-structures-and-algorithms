package heap;

public class KLargestElements {
    public static void kLargestElements(int[] arr, int k) {
        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 5, 15, 10, 20, 8, 25, 18 };
        kLargestElements(arr, 3);
    }
}
