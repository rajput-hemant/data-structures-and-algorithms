package heap;

import java.util.ArrayList;

/**
 * It's a Complete Binary Tree
 * <p>
 * Every node has value greater than it's descendants
 */
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

    private void swap(int a, int b) {
        int temp = heap.get(b);
        heap.set(b, heap.get(a));
        heap.set(a, temp);
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return heap.size();
    }

    /**
     * Appends the specified item to the end of the MaxHeap.
     * <p>
     * Time Complexity -> O(log n)
     * 
     * @param item item to be inserted.
     */
    public void insert(int item) {
        // add the item to the end of the MaxHeap
        heap.add(item);

        // index of the last item in the MaxHeap
        int i = heap.size() - 1;

        // traverse up the MaxHeap until i == root,
        // or until parent is smaller than the current node
        while (i != 0 && heap.get(parent(i)) < heap.get(i)) {
            // swap the value of parent & current node
            swap(i, parent(i));

            // index of parent node is set to be the index of current node
            i = parent(i);
        }
    }

    /**
     * This Helper method Heapify the node at the given {@code index}
     * <p>
     * Time Complexity -> O(log n) / O(h)
     * <p>
     * Auxuliary Space -> O(h)
     * 
     * @param index index of the node that violates MaxHeap Property
     */
    public void maxHeapify(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        if (index > heap.size() - 1)
            throw new IndexOutOfBoundsException("Index is Out of range!");

        // initializing the indexes of the leftChild, rightChild & node to be heapify
        int lChild = leftChild(index), rChild = rightChild(index), largest = index;

        // return if indexes of leftChild or rightChild is out of range of MaxHeap
        if (lChild >= heap.size() || rChild >= heap.size())
            return;

        // if value at lChild > largest, set the index of lChild to largest
        if (heap.get(lChild) > heap.get(largest))
            largest = lChild;

        // if value at rChild > largest, set the index of rChild to largest
        if (heap.get(rChild) > heap.get(largest))
            largest = rChild;

        // if the largest was updated with the index of the max node
        if (largest != index) {
            // swap the value at indexes - index & largest, hence heapifying the node
            swap(index, largest);

            // recursive call to heapify the rest of the MaxHeap,
            // to fix the violated MaxHeap Property
            maxHeapify(largest);
        }
    }

    /**
     * Returns the maximum element in the MaxHeap
     * <p>
     * Time Complexity -> O(1)
     * 
     * @return the root element of MaxHeap
     */
    public int getMax() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        return heap.get(0);
    }

    /**
     * Removes the maximum element from MaxHeap
     * <p>
     * Time Complexity -> O(log n )
     * <p>
     * Auxuliary Space -> O(h) (depdends on maxHeapify's implementation)
     * 
     * @return Maximum element from MaxHeap
     */
    public int extractMax() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");

        // if there's only one element
        if (heap.size() == 1)
            return heap.remove(0);

        // swap the first element w/ the last element
        swap(0, heap.size() - 1);

        // remove the last element, hence removing the max element
        int max = heap.remove(heap.size() - 1);

        // recursive call to heafipy the MaxHeap, to fix the violated MaxHeap Property
        maxHeapify(0);
        return max;
    }

    /**
     * Inreases the value at given {@code index}
     * <p>
     * Time Complexity -> O(log n)
     * 
     * @param index  index to increase the value of item
     * @param newVal new value for the item
     */
    public void increaseKey(int index, int newVal) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        if (index > heap.size() - 1)
            throw new IndexOutOfBoundsException("Index is Out of range!");

        // if the item at index is > new value, throw exception
        if (heap.get(index) > newVal)
            throw new IllegalArgumentException("Key is larger than the original key");

        // set the new value at the given index
        heap.set(index, newVal);

        // traverse up the MaxHeap until i == root,
        // or until parent is greater than the current node
        while (index != 0 && heap.get(parent(index)) < heap.get(index)) {
            // swap the value of parent & current node
            swap(index, parent(index));

            // index of parent node is set to be the index of current node
            index = parent(index);
        }
    }

    /**
     * Deletes the item at the given {@code index}
     * <p>
     * Time Complexity -> O(log n)
     * 
     * @param index index of the item to delete
     * @return the deleted item
     */
    public int delete(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        if (index > heap.size() - 1)
            throw new IndexOutOfBoundsException("Index is Out of range!");

        // initialize item var with the value at index
        int item = heap.get(index);

        // increase the value at the index with the max value possible
        increaseKey(index, Integer.MAX_VALUE);

        // extract the max value, hence deleting the item
        extractMax();
        return item;
    }

    /**
     * Helper Method to Build MaxHeap
     * <p>
     * Time Complexity -> O(n)
     */
    public void buildHeap() {
        // index of last non-leaf node
        int bmrmin = heap.size() / 2 - 1;

        // performs reverse level order traversal from last non-leaf node,
        // and heapify each node
        for (int i = bmrmin; i >= 0; i--)
            maxHeapify(i);
    }

    public void printHeap() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
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
