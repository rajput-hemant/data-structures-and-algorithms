package Heap;

import java.util.Arrays;

public class MinHeap {
    private int heap[], size;

    MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
        Arrays.fill(heap, -1);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void insert(int x) {
        if (isFull()) {
            System.out.println("Heap is full, No space to insert new element!");
            return;
        }
        heap[size++] = x;
        int i = size - 1;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(heap[i], heap[parent(i)]);
            i = parent(i);
        }
    }

    // Time Complexity -> O(logn)
    // Auxuliary Space -> O(h)
    public void minHeapify(int index) {
        int lChild = leftChild(index), rChild = rightChild(index), smallest = index;
        if (lChild < size && heap[lChild] < heap[index]) {
            smallest = lChild;
        }
        if (rChild < size && heap[rChild] < heap[smallest]) {
            smallest = rChild;
        }
        if (smallest != index) {
            swap(heap[index], heap[smallest]);
            minHeapify(smallest);
        }
    }

    // Time Complexity -> O(1)
    public int getMin() {
        return heap[0];
    }

    // Time Complexity -> O(logn)
    // Auxuliary Space -> O(h) (depdends on minHeapify's implementation)
    public int extractMin() {
        if (size == 0)
            throw new IllegalStateException("Heap is Empty!");
        if (size == 1) {
            size--;
            return heap[0];
        }
        swap(heap[0], heap[size - 1]);
        size--;
        minHeapify(0);
        return heap[size];
    }

    // Time Complexity -> O(logn)
    public void decreaseKey(int index, int newVal) {
        heap[index] = newVal;
        while (index != 0 && heap[parent(index)] > heap[index]) {
            swap(heap[index], heap[parent(index)]);
            index = parent(index);
        }
    }

    // Time Complexity -> O(logn)
    public int delete(int index) {
        if (size == 0)
            throw new IllegalStateException("Heap is Empty!");
        decreaseKey(index, Integer.MIN_VALUE);
        return extractMin();
    }

    // Time Complexity -> O(n)
    public void buildHeap() {
        int bmrmin = size - 2 / 2; // bottom most right most internal node
        for (int i = bmrmin; i >= 0; i--)
            minHeapify(i);
    }
}
