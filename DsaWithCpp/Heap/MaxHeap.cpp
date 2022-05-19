#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class MaxHeap
{
private:
    vector<int> heap;

    int leftChild(int index)
    {
        return 2 * index + 1;
    }

    int rightChild(int index)
    {
        return 2 * index + 2;
    }

    int parent(int index)
    {
        return (index - 1) / 2;
    }

public:
    MaxHeap()
    {
        vector<int> heap;
    }

    MaxHeap(vector<int> items)
    {
        heap = items;
        buildHeap();
    }

    bool isEmpty()
    {
        return heap.size() == 0;
    }

    int size()
    {
        return heap.size();
    }

    void insert(int item)
    {
        heap.push_back(item);
        int i = heap.size() - 1;
        while (i != 0 && heap[parent(i)] < heap[i])
        {
            swap(heap[i], heap[parent(i)]);
            i = parent(i);
        }
    }

    void maxHeapify(int index)
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        if (index > heap.size() - 1)
            throw length_error("Index is out of range!");
        int lChild = leftChild(index), rChild = rightChild(index), largest = index;
        if (lChild < heap.size() && heap[lChild] > heap[largest])
            largest = lChild;
        if (rChild < heap.size() && heap[rChild] > heap[largest])
            largest = rChild;
        if (largest != index)
        {
            swap(heap[index], heap[largest]);
            maxHeapify(largest);
        }
    }

    int getMax()
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        return heap.at(0);
    }

    int extractMax()
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        if (heap.size() == 1)
        {
            int item = heap.front();
            heap.erase(heap.begin());
            return item;
        }
        swap(heap[0], heap[heap.size() - 1]);
        int max = heap.back();
        heap.pop_back();
        maxHeapify(0);
        return max;
    }

    void increaseKey(int index, int newVal)
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        if (index > heap.size() - 1)
            throw length_error("Index is out of range!");
        if (heap[index] > newVal)
            cout << "Key is smaller than the original key" << endl;
        heap[index] = newVal;
        while (index != 0 && heap[parent(index)] < heap[index])
        {
            swap(heap[index], heap[parent(index)]);
            index = parent(index);
        }
    }

    int remove(int index)
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        if (index > heap.size() - 1)
            throw length_error("Index is out of range!");
        int item = heap[index];
        increaseKey(index, INT_MAX);
        extractMax();
        return item;
    }

    void buildHeap()
    {
        int bmrmin = heap.size() / 2 - 1; // index of last non-leaf node
        for (int i = bmrmin; i >= 0; i--)
            maxHeapify(i);
    }

    void printHeap()
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        cout << "MaxHeap -> [";
        for (int item : heap)
            cout << item << ", ";
        cout << "\b\b]" << endl;
    }
};

// int main()
// {
//     MaxHeap ob;
//     ob.insert(10);
//     ob.insert(4);
//     ob.insert(9);
//     ob.insert(1);
//     ob.insert(7);
//     ob.insert(5);
//     ob.insert(3);
//     ob.printHeap();
//     ob.remove(3);
//     ob.printHeap();
// }
