#include <iostream>
#include <vector>
#include "SortHelper.cpp"
using namespace std;

class HeapSort
{
private:
    static void maxHeapify(vector<int> &arr, int n, int index)
    {
        int largest = index, lChild = 2 * index + 1, rChild = 2 * index + 2;
        if (lChild < n && arr[lChild] > arr[largest])
            largest = lChild;
        if (rChild < n && arr[rChild] > arr[largest])
            largest = rChild;
        if (largest != index)
        {
            swap(arr[index], arr[largest]);
            maxHeapify(arr, n, largest);
        }
    }

    static void minHeapify(vector<int> &arr, int n, int index)
    {
        int smallest = index, lChild = 2 * index + 1, rChild = 2 * index + 2;
        if (lChild < n && arr[lChild] < arr[index])
            smallest = lChild;
        if (rChild < n && arr[rChild] < arr[smallest])
            smallest = rChild;
        if (smallest != index)
        {
            swap(arr[index], arr[smallest]);
            minHeapify(arr, n, smallest);
        }
    }

    static void buildHeap(vector<int> &arr, int n, int sort)
    {
        int bmrmin = n - 2 / 2; // bottom most right most internal node
        for (int i = bmrmin; i >= 0; i--)
        {
            if (sort == 1)
                maxHeapify(arr, n, i);
            else
                minHeapify(arr, n, i);
        }
    }

public:
    static void heapSort(vector<int> &arr, int sort)
    {
        buildHeap(arr, arr.size(), sort);
        for (int i = arr.size() - 1; i > 0; i--)
        {
            swap(arr[0], arr[i]);
            // For sorting in Ascending Order
            if (sort == 1)
                maxHeapify(arr, i, 0);
            // For sorting in Descending Order
            else
                minHeapify(arr, i, 0);
        }
    }
};

int main()
{
    vector<int> arr;
    takeInput(arr);
    HeapSort::heapSort(arr, sort());
    printSortedArray(arr);
}