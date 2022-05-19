#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class MinHeap
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
    MinHeap()
    {
        vector<int> heap;
    }

    MinHeap(vector<int> items)
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
        while (i != 0 && heap[parent(i)] > heap[i])
        {
            swap(heap[i], heap[parent(i)]);
            i = parent(i);
        }
    }

    void minHeapify(int index)
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        if (index > heap.size() - 1)
            throw length_error("Index is out of range!");
        int lChild = leftChild(index), rChild = rightChild(index), smallest = index;
        if (lChild < heap.size() && heap[lChild] < heap[index])
            smallest = lChild;
        if (rChild < heap.size() && heap[rChild] < heap[smallest])
            smallest = rChild;
        if (smallest != index)
        {
            swap(heap[index], heap[smallest]);
            minHeapify(smallest);
        }
    }

    int getMin()
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        return heap.at(0);
    }

    int extractMin()
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
        int min = heap.back();
        heap.pop_back();
        minHeapify(0);
        return min;
    }

    void decreaseKey(int index, int newVal)
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        if (index > heap.size() - 1)
            throw length_error("Index is out of range!");
        if (heap[index] < newVal)
            cout << "Key is larger than the original key" << endl;
        heap[index] = newVal;
        while (index != 0 && heap[parent(index)] > heap[index])
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
        decreaseKey(index, INT_MIN);
        extractMin();
        return item;
    }

    void buildHeap()
    {
        int bmrmin = heap.size() / 2 - 1; // index of last non-leaf node
        for (int i = bmrmin; i >= 0; i--)
            minHeapify(i);
    }

    void printHeap()
    {
        if (isEmpty())
            throw length_error("Heap is Empty!");
        cout << "MinHeap -> [";
        for (int item : heap)
            cout << item << ", ";
        cout << "\b\b]" << endl;
    }
};

// int main()
// {
//     MinHeap ob;
//     ob.insert(10);
//     ob.insert(4);
//     ob.insert(9);
//     ob.insert(1);
//     ob.insert(7);
//     ob.insert(5);
//     ob.insert(3);
//     ob.printHeap();
//     // ob.remove(3);
//     cout << ob.extractMin() << endl;
//     ob.printHeap();
// }
