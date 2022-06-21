#include <iostream>
#include "PriorityQueue.cpp"
using namespace std;

void kLargestElements(int arr[],int n,  int k)
{
    PriorityQueue pq;
    for (int i = 0; i < k; i++)
        pq.push(arr[i]);
    for (int i = k; i < n; i++)
    {
        if (arr[i] > pq.top())
        {
            pq.pop();
            pq.push(arr[i]);
        }
    }
    while (!pq.isEmpty())
        cout << pq.pop() << " ";
    cout << endl;
}

// int main()
// {
//     int arr[] = {5, 15, 10, 20, 8, 25, 18};
//     kLargestElements(arr, 7, 3);
// }
