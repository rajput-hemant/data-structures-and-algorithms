package heap;

import java.util.NoSuchElementException;

public class PriorityQueue {
    MinHeap mh = new MinHeap();

    /**
     * Returns {@code true} if Priority Queue contains no elements.
     *
     * @return {@code true} if Priority Queue contains no elements
     */
    public boolean isEmpty() {
        return mh.isEmpty();
    }

    /**
     * Returns the number of elements in the Priority Queue
     * 
     * @return the number of elements in the Priority Queue
     */
    public int size() {
        return mh.size();
    }

    /**
     * Inserts the element to the Priority Queue
     * 
     * @param item element to add
     */
    public void add(int item) {
        mh.insert(item);
    }

    /**
     * Retrieves, but does not remove, the head of this Priority Queue, or returns
     * {@code null} if it is empty.
     * 
     * @return the head of this Priority Queue, or {@code null} if it is empty
     */
    public Integer peek() {
        if (isEmpty())
            return null;
        return mh.getMin();
    }

    /**
     * Retrieves, but does not remove, the head of the Priority Queue. This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if the Priority Queue is empty.
     *
     * @return the head of the Priority Queue
     * @throws NoSuchElementException if the Priority Queue is empty
     */
    public Integer element() {
        if (isEmpty())
            throw new NoSuchElementException();
        return mh.getMin();
    }

    /**
     * Retrieves and removes the head of the Priority Queue, or returns {@code null}
     * if it is empty.
     *
     * @return the head of the Priority Queue, or {@code null} if its is empty
     */
    public Integer poll() {
        if (isEmpty())
            return null;
        return mh.extractMin();
    }

    /**
     * Retrieves and removes the head of the Priority Queue. This method differs
     * from {@link #poll() poll()} only in that it throws an exception if
     * the Priority Queue is empty.
     *
     * @return the head of the Priority Queue
     * @throws NoSuchElementException if the Priority Queue is empty
     */
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
