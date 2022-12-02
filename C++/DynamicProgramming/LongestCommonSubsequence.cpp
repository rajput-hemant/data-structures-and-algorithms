#include <bits/stdc++.h>
using namespace std;

int lcsMemo(string s1, string s2, int m, int n, vector<vector<int>> memo)
{
  if (memo[m][n] != -1)
    return memo[m][n];
  if (m == 0 || n == 0)
    memo[m][n] = 0;
  else
  {
    if (s1[m - 1] == s2[n - 1])
      memo[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, memo);
    else
      memo[m][n] = max(lcsMemo(s1, s2, m - 1, n, memo), lcsMemo(s1, s2, m, n - 1, memo));
  }
  return memo[m][n];
}

int longestCommonSubsequenceMemoization(string s1, string s2)
{
  int m = s1.length(),
      n = s2.length();
  vector<vector<int>> memo(m + 1, vector<int>(n + 1, -1));
  return lcsMemo(s1, s2, m, n, memo);
}

int longestCommonSubsequenceTabulation(string s1, string s2)
{
  int m = s1.length(),
      n = s2.length();
  vector<vector<int>> dp(m + 1, vector<int>(n + 1));
  for (int i = 0; i < m + 1; i++)
    dp[i][0] = 0;
  for (int j = 0; j < n + 1; j++)
    dp[0][j] = 0;
  for (int i = 1; i < m + 1; i++)
    for (int j = 1; j < n + 1; j++)
    {
      if (s1[i - 1] == s2[j - 1])
        dp[i][j] = 1 + dp[i - 1][j - 1];
      else
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
    }
  return dp[m][n];
}

// int main()
// {
//   cout << longestCommonSubsequenceMemoization("AXYZ", "BAZ") << endl;
//   cout << longestCommonSubsequenceTabulation("AXYZ", "BAZ") << endl;
//   return 0;
// }
