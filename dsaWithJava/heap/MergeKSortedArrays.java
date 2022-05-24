package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet> {
    int element, arrPos, elePos;

    Triplet(int element, int arrPos, int elePos) {
        this.element = element;
        this.arrPos = arrPos;
        this.elePos = elePos;
    }

    @Override
    public int compareTo(Triplet o) {
        return element <= o.element ? -1 : 1;
    }

}

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeArrays(int[][] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            pq.add(new Triplet(arr[i][0], i, 0));
        while (!pq.isEmpty()) {
            Triplet curr = pq.poll();
            res.add(curr.element);
            int arrPos = curr.arrPos, elePos = curr.elePos;
            if (elePos + 1 < arr[arrPos].length)
                pq.add(new Triplet(arr[arrPos][elePos + 1], arrPos, elePos + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = { { 5, 10 }, { 4, 9 }, { 5, 6 } };
        System.out.println(mergeArrays(arr));
    }
}