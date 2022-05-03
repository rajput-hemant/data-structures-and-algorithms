package heap;

import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;

    MaxHeap() {
        this.heap = new ArrayList<>();
    }

    MaxHeap(ArrayList<Integer> items) {
        this.heap = items;
        buildHeap();
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
        return heap.size() == 0;
    }

    private void swap(int a, int b) {
        int temp = heap.get(b);
        heap.set(b, heap.get(a));
        heap.set(a, temp);
    }

    // Time Complexity -> O(h)
    public void insert(int item) {
        heap.add(item);
        int i = heap.size() - 1;
        while (i != 0 && heap.get(parent(i)) < heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Time Complexity -> O(logn)
    // Auxuliary Space -> O(h)
    public void maxHeapify(int index) {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!");
        int lChild = leftChild(index), rChild = rightChild(index), largest = index;
        if (lChild < heap.size() && heap.get(lChild) > heap.get(largest))
            largest = lChild;
        if (rChild < heap.size() && heap.get(rChild) > heap.get(largest))
            largest = rChild;
        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    // Time Complexity -> O(1)
    public int getMax() {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!");
        return heap.get(0);
    }

    // Time Complexity -> O(logn)
    // Auxuliary Space -> O(h) (depdends on maxHeapify's implementation)
    public int extractMax() {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!");
        if (heap.size() == 1)
            return heap.remove(0);
        swap(0, heap.size() - 1);
        int max = heap.remove(heap.size() - 1);
        maxHeapify(0);
        return max;
    }

    // Time Complexity -> O(logn)
    public void increaseKey(int index, int newVal) {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!");
        if (heap.get(index) > newVal)
            throw new IllegalArgumentException("Key is smaller than the original key");
        heap.set(index, newVal);
        while (index != 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Time Complexity -> O(logn)
    public int delete(int index) {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!");
        if (index > heap.size() - 1)
            throw new IllegalStateException("Index is Out of range!");
        increaseKey(index, Integer.MAX_VALUE);
        return extractMax();
    }

    // Time Complexity -> O(n)
    public void buildHeap() {
        int bmrmin = heap.size() - 2 / 2; // bottom most right most internal node
        for (int i = bmrmin; i >= 0; i--)
            maxHeapify(i);
    }

    public void printHeap() {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!");
        System.out.print("MaxHeap -> [");
        for (Integer item : heap) {
            System.out.print(item + ", ");
        }
        System.out.println("\b\b]");
    }

    public static void main(String[] args) {
        MaxHeap ob = new MaxHeap();
        ob.insert(10);
        ob.insert(4);
        ob.insert(9);
        ob.insert(1);
        ob.insert(7);
        ob.insert(5);
        ob.insert(3);
        ob.printHeap();
        ob.delete(3);
        ob.printHeap();
    }
}
