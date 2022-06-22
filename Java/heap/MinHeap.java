package heap;

import java.util.ArrayList;

/**
 * It's a Complete Binary Tree
 * <p>
 * Every node has value smaller than it's descendants
 */
public class MinHeap {
    private ArrayList<Integer> heap;

    MinHeap() {
        this.heap = new ArrayList<>();
    }

    MinHeap(ArrayList<Integer> items) {
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
     * Appends the specified item to the end of the MinHeap.
     * <p>
     * Time Complexity -> O(log n)
     * 
     * @param item item to be inserted.
     */
    public void insert(int item) {
        // add the item to the end of the MinHeap
        heap.add(item);

        // index of the last item in the MinHeap
        int i = heap.size() - 1;

        // traverse up the MinHeap until i == root,
        // or until parent is greater than the current node
        while (i != 0 && heap.get(parent(i)) > heap.get(i)) {
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
     * @param index index of the node that violates MinHeap Property
     */
    public void minHeapify(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        if (index > heap.size() - 1)
            throw new IndexOutOfBoundsException("Index is Out of range!");

        // initializing the indexes of the leftChild, rightChild & node to be heapify
        int lChild = leftChild(index), rChild = rightChild(index), smallest = index;

        // if left child exists & the value at lChild < smallest,
        // set the index of lChild to smallest
        if (lChild < heap.size() && heap.get(lChild) < heap.get(smallest))
            smallest = lChild;

        // if right child exists & the value at rChild < smallest ,
        // set the index of rChild to smallest
        if (rChild < heap.size() && heap.get(rChild) < heap.get(smallest))
            smallest = rChild;

        // if the smallest was updated with the index of the min node
        if (smallest != index) {
            // swap the value at indexes - index & smallest, hence heapifying the node
            swap(index, smallest);

            // recursive call to heapify the rest of the MinHeap,
            // to fix the violated MinHeap Property
            minHeapify(smallest);
        }
    }

    /**
     * Returns the minimum element in the MinHeap
     * <p>
     * Time Complexity -> O(1)
     * 
     * @return the root element of MinHeap
     */
    public int getMin() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        return heap.get(0);
    }

    /**
     * Removes the minimum element from MinHeap
     * <p>
     * Time Complexity -> O(log n )
     * <p>
     * Auxuliary Space -> O(h) (depdends on minHeapify's implementation)
     * 
     * @return Minimum element from MinHeap
     */
    public int extractMin() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");

        // if there's only one element
        if (heap.size() == 1)
            return heap.remove(0);

        // swap the first element w/ the last element
        swap(0, heap.size() - 1);

        // remove the last element, hence removing the min element
        int min = heap.remove(heap.size() - 1);

        // recursive call to heafipy the MinHeap, to fix the violated MinHeap Property
        minHeapify(0);
        return min;
    }

    /**
     * Decreases the value at given {@code index}
     * <p>
     * Time Complexity -> O(log n)
     * 
     * @param index  index to decrease the value of item
     * @param newVal new value for the item
     */
    public void decreaseKey(int index, int newVal) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        if (index > heap.size() - 1)
            throw new IndexOutOfBoundsException("Index is Out of range!");

        // if the item at index is < new value, throw exception
        if (heap.get(index) < newVal)
            throw new IllegalArgumentException("Key is larger than the original key");

        // set the new value at the given index
        heap.set(index, newVal);

        // traverse up the MinHeap until i == root,
        // or until parent is greater than the current node
        while (index != 0 && heap.get(parent(index)) > heap.get(index)) {
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

        // decrease the value at the index with the min value possible
        decreaseKey(index, Integer.MIN_VALUE);

        // extract the min value, hence deleting the item
        extractMin();
        return item;
    }

    /**
     * Helper Method to Build MinHeap
     * <p>
     * Time Complexity -> O(n)
     */
    public void buildHeap() {
        // index of last non-leaf node
        int bmrmin = heap.size() / 2 - 1;

        // performs reverse level order traversal from last non-leaf node,
        // and heapify each node
        for (int i = bmrmin; i >= 0; i--)
            minHeapify(i);
    }

    public void printHeap() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is Empty!");
        System.out.print("MinHeap -> [");
        for (Integer item : heap) {
            System.out.print(item + ", ");
        }
        System.out.println("\b\b]");
    }

    public static void main(String[] args) {
        MinHeap ob = new MinHeap();
        ob.insert(10);
        ob.insert(4);
        ob.insert(9);
        ob.insert(1);
        ob.insert(7);
        ob.insert(5);
        ob.insert(3);
        ob.printHeap();
        System.out.println(ob.delete(3));
        ob.printHeap();
        System.out.println(ob.size());
    }
}
