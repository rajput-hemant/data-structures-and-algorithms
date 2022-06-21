#include <iostream>
#include "PriorityQueue.cpp"
using namespace std;

static void kSort(int arr[], int k, int n)
{
    PriorityQueue pq;
    for (int i = 0; i <= k; i++)
        pq.push(arr[i]);
    int index = 0;
    for (int i = k + 1; i < n; i++)
    {
        arr[index++] = pq.pop();
        pq.push(arr[i]);
    }
    while (!pq.isEmpty())
        arr[index++] = pq.pop();
}

// int main()
// {
//     int arr[] = {9, 8, 7, 19, 18};
//     kSort(arr, 3, 6);
//     for (int i = 0; i < 5; i++)
//         cout << arr[i] << " ";
//     cout << endl;
// }