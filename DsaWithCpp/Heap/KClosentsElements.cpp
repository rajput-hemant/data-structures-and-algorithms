#include <iostream>
#include <queue>
using namespace std;

void kclosestElements(int arr[], int n, int x, int k)
{
    priority_queue<pair<int, int>> pq;
    for (int i = 0; i < k; i++)
        pq.push({abs(arr[i] - x), i});
    for (int i = k; i < n; i++)
    {
        int diff = abs(arr[i] - x);
        if (pq.top().first > diff)
        {
            pq.pop();
            pq.push({diff, i});
        }
    }
    while (!pq.empty())
    {
        cout << arr[pq.top().second] << " ";
        pq.pop();
    }
    cout << endl;
}

// int main()
// {
//     int arr[] = {30, 40, 32, 33, 36, 37};
//     int n = sizeof(arr) / sizeof(arr[0]);
//     kclosestElements(arr, n, 38, 3);
// }
