#include <bits/stdc++.h>
using namespace std;

void printlcs(string str1, string str2)
{
  int m = str1.length(),
      n = str2.length();
  vector<vector<int>> dp(m + 1, vector<int>(n + 1));
  for (int i = 0; i < m + 1; i++)
    dp[i][0] = 0;
  for (int j = 0; j < n + 1; j++)
    dp[0][j] = 0;
  for (int i = 1; i < m + 1; i++)
    for (int j = 1; j < n + 1; j++)
    {
      if (str1[i - 1] == str2[j - 1])
        dp[i][j] = 1 + dp[i - 1][j - 1];
      else
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
    }
  int i = m, j = n;
  string str = "";
  while (i > 0 && j > 0)
  {
    if (str1[i - 1] == str2[j - 1])
    {
      str += str1[i - 1];
      i--;
      j--;
    }
    else if (dp[i - 1][j] > dp[i][j - 1])
      i--;
    else
      j--;
  }
  reverse(str.begin(), str.end());
  cout << str << endl;
}

// int main()
// {
//   printlcs("AXYZ", "BAZ");
// }