#include <bits/stdc++.h>
using namespace std;

int ceilIndex(vector<int> tail, int left, int right, int k)
{
  while (left < right)
  {
    int mid = left + (right - left) / 2;
    if (tail[mid] >= k)
      right = mid;
    else
      left = mid + 1;
  }
  return right;
}

int lengthOfLISOptimized(int arr[], int n)
{
  vector<int> tail;
  tail.push_back(arr[0]);
  for (int i = 1; i < n; i++)
    if (arr[i] > tail[tail.size() - 1])
      tail.push_back(arr[i]);
    else
    {
      int ceilIdx = ceilIndex(tail, 0, tail.size() - 1, arr[i]);
      tail[ceilIdx] = arr[i];
    }
  return tail.size();
}

int lengthOfLIS(int arr[], int n)
{
  vector<int> lis(n);
  lis[0] = 1;
  for (int i = 1; i < n; i++)
  {
    lis[i] = 1;
    for (int j = 0; j < i; j++)
    {
      if (arr[i] > arr[j])
        lis[i] = max(lis[i], lis[j] + 1);
    }
  }
  int res = lis[0];
  for (int i : lis)
    res = max(i, res);
  return res;
}

int main()
{
  int arr[] = {10, 5, 18, 7, 2, 9};
  int n = sizeof(arr) / sizeof(arr[0]);
  cout << lengthOfLIS(arr, n) << endl;
  cout << lengthOfLISOptimized(arr, n) << endl;
}