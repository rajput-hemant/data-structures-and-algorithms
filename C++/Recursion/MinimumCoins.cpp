#include <bits/stdc++.h>
using namespace std;

int minCoins(int coins[], int n, int target)
{
  if (target == 0)
    return 0;
  int res = INT32_MAX;
  for (int i = 0; i < n; i++)
  {
    if (coins[i] <= target)
    {
      int remTarget = 1 + minCoins(coins, n, target - coins[i]);
      if (remTarget != INT32_MAX)
        res = min(res, remTarget);
    }
  }
  return res;
}

int main()
{
  int coins[] = {10, 25, 5};
  int n = sizeof(coins) / sizeof(coins[0]);
  cout << minCoins(coins, n, 30) << endl;
}