#include <bits/stdc++.h>
using namespace std;

int getCount(int coins[], int n, int amount)
{
  vector<vector<int>> dp(amount + 1, vector<int>(n + 1));

  for (int i = 0; i <= n; i++)
    dp[0][i] = 1;
  for (int i = 0; i <= amount; i++)
    dp[i][0] = 0;

  for (int i = 1; i <= amount; i++)
    for (int j = 1; j <= n; j++)
    {
      dp[i][j] = dp[i][j - 1];
      if (coins[j - 1] <= i)
        dp[i][j] += dp[i - coins[j - 1]][j];
    }
  return dp[amount][n];
}

int main()
{
  int coins[] = {2, 3, 5, 6},
      n = sizeof(coins) / sizeof(coins[0]);
  cout << getCount(coins, n, 10) << endl;
}
