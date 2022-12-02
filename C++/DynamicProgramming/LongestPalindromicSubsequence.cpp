#include <bits/stdc++.h>
#include "LongestCommonSubsequence.cpp"
using namespace std;

int longestPalindromicSubsequence(string str)
{
  string rev = str;
  reverse(rev.begin(), rev.end());
  return longestCommonSubsequenceTabulation(str, rev);
}

// int main()
// {
//   cout << longestPalindromicSubsequence("saippuakivikauppias") << endl;
// }
