#include <bits/stdc++.h>
using namespace std;

int minCoins(int coins[], int n, int target)
{
  vector<int> dp(target + 1, INT16_MAX);
  dp[0] = 0;
  for (int i = 1; i <= target; i++)
  {
    for (int j = 0; j < n; j++)
    {
      if (coins[j] <= i)
      {
        int remTarget = 1 + dp[i - coins[j]];
        if (remTarget != INT32_MAX)
          dp[i] = min(dp[i], remTarget);
      }
    }
  }
  return dp[target];
}

int main()
{
  int coins[] = {10, 25, 5};
  int n = sizeof(coins) / sizeof(coins[0]);
  cout << minCoins(coins, n, 30) << endl;
}