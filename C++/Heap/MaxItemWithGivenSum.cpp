#include <iostream>
#include <bits/stdc++.h>
#include "PriorityQueue.cpp"
using namespace std;

int maxItemUsingSortedArray(int arr[], int n, int sum)
{
    int count = 0;
    sort(arr, arr + n);
    for (int i = 0; i < n; i++)
    {
        if (arr[i] > sum)
            return count;
        count++;
        sum -= arr[i];
    }
    return count;
}

int maxItemUsingHeap(int arr[], int n, int sum)
{
    PriorityQueue pq;
    for (int i = 0; i < n; i++)
        pq.push(arr[i]);
    int count = 0;
    while (!pq.isEmpty() && pq.top() <= sum)
    {
        sum -= pq.pop();
        count++;
    }
    return count;
}

// int main()
// {
//     int arr[] = {1, 12, 5, 111, 200};
//     cout << maxItemUsingSortedArray(arr, 5, 11) << endl;
//     cout << maxItemUsingHeap(arr, 5, 11) << endl;
// }
