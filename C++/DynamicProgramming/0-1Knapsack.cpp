#include <bits/stdc++.h>
using namespace std;

int knapsack(int capacity, int weight[], int cost[], int n)
{
  vector<vector<int>> dp(n + 1, vector<int>(capacity + 1, 0));
  for (int i = 1; i <= n; i++)
  {
    for (int j = 1; j <= capacity; j++)
    {
      int weightIndex = i - 1;
      if (weight[weightIndex] > j)
        dp[i][j] = dp[weightIndex][j];
      else
        dp[i][j] = max(dp[weightIndex][j], cost[weightIndex] + dp[weightIndex][j - weight[weightIndex]]);
    }
  }
  return dp[n][capacity];
}

int main()
{

  int weight[] = {5, 4, 6, 3};
  int cost[] = {10, 40, 30, 50};
  int n = sizeof(weight) / sizeof(weight[0]);
  cout << knapsack(10, weight, cost, n) << endl;
}