#include <bits/stdc++.h>
using namespace std;

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
}