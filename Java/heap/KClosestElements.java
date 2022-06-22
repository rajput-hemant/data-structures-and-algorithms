package heap;

import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int element, difference, index;

    Pair(int element, int difference, int index) {
        this.element = element;
        this.difference = difference;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        if (difference == o.difference)
            return 0;
        else if (difference < o.difference)
            return 1;
        else
            return -1;
    }
}

public class KClosestElements {
    public static void kClosestElements(int[] arr, int x, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.add(new Pair(arr[i], Math.abs(arr[i] - x), i));
        for (int i = k; i < arr.length; i++) {
            if (pq.peek().difference > Math.abs(arr[i] - x)) {
                pq.poll();
                pq.add(new Pair(arr[i], Math.abs(arr[i] - x), i));
            }
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.peek().element + " ");
            pq.poll();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 30, 40, 32, 33, 36, 37 };
        kClosestElements(arr, 38, 3);
    }
}
