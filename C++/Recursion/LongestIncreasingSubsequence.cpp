#include <bits/stdc++.h>
using namespace std;

int lis(int arr[], int n, int prev, int curr)
{
  if (curr == n)
    return 0;
  int take = 0;
  if (prev == -1 || arr[curr] > arr[prev])
    take = 1 + lis(arr, n, curr, curr + 1);
  int doNotTake = lis(arr, n, prev, curr + 1);
  return max(take, doNotTake);
}

int lengthOfLIS(int arr[], int n)
{
  return lis(arr, n, -1, 0);
}

int main()
{
  int arr[] = {1, 4, 2, 4, 7, 6, 8};
  int n = sizeof(arr) / sizeof(arr[0]);
  cout << lengthOfLIS(arr, n) << endl;
}