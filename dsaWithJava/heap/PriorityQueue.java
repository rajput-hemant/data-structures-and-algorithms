package heap;

import java.util.NoSuchElementException;

public class PriorityQueue {
    MinHeap mh = new MinHeap();

    public boolean isEmpty() {
        return mh.isEmpty();
    }

    public int size() {
        return mh.size();
    }

    public void add(int item) {
        mh.insert(item);
    }

    public Integer peek() {
        if (isEmpty())
            return null;
        return mh.getMin();
    }

    public Integer element() {
        if (isEmpty())
            throw new NoSuchElementException();
        return mh.getMin();
    }

    public Integer poll() {
        if (isEmpty())
            return null;
        return mh.extractMin();
    }

    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        return mh.extractMin();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(20);
        pq.add(15);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.poll());
        System.out.println(pq.remove());
    }
}
