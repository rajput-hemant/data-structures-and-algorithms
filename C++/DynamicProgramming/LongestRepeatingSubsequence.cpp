#include <bits/stdc++.h>
using namespace std;

int longestRepeatingSubsequence(string str)
{
  int len = str.length();
  vector<vector<int>> dp(len + 1, vector<int>(len + 1));
  for (int i = 0; i < len + 1; i++)
    for (int j = 0; j < len + 1; j++)
    {
      if (i == 0 || j == 0)
        dp[i][j] = 0;
      else if (str[i - 1] == str[j - 1] && i != j)
        dp[i][j] = 1 + dp[i - 1][j - 1];
      else
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
    }
  return dp[len][len];
}

// int main()
// {
//   cout << longestRepeatingSubsequence("rajput-hemant") << endl;
// }