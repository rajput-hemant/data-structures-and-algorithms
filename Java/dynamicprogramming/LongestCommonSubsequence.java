package dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
  /* For a string of length, there can be 2^n possible Subsequences */

  /**
   * Time Complexity => O(m * n)
   * <p>
   * Space Complexity => O(m * n)
   * 
   * @param str1 String
   * @param str2 String
   * @return the length of Longest Common Subsequence of str1 & str2
   */
  public int longestCommonSubsequenceMemoization(String str1, String str2) {
    int m = str1.length(),
        n = str2.length();
    int[][] memo = new int[m + 1][n + 1];
    for (int[] row : memo)
      Arrays.fill(row, -1);
    return lcsMemo(str1, str2, m, n, memo);
  }

  private int lcsMemo(String str1, String str2, int m, int n, int[][] memo) {
    if (memo[m][n] != -1)
      return memo[m][n];
    if (m == 0 || n == 0)
      memo[m][n] = 0;
    else {
      if (str1.charAt(m - 1) == str2.charAt(n - 1))
        memo[m][n] = 1 + lcsMemo(str1, str2, m - 1, n - 1, memo);
      else
        memo[m][n] = Math.max(lcsMemo(str1, str2, m - 1, n, memo), lcsMemo(str1, str2, m, n - 1, memo));
    }
    return memo[m][n];
  }

  /**
   * Time Complexity => O(m * n)
   * <p>
   * Space Complexity => O(m * n)
   * 
   * @param str1 String
   * @param str2 String
   * @return the length of Longest Common Subsequence of str1 & str2
   */
  public int longestCommonSubsequenceTabulation(String str1, String str2) {
    int m = str1.length(),
        n = str2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++)
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (str1.charAt(i - 1) == str2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    return dp[m][n];
  }

  /**
   * Time Complexity => O(m * n)
   * <p>
   * Space Complexity => O(n)
   * 
   * @param str1 String
   * @param str2 String
   * @return the length of Longest Common Subsequence of str1 & str2
   */
  public int longestCommonSubsequence(String str1, String str2) {
    int m = str1.length(),
        n = str2.length();
    int[][] dp = new int[2][n + 1];
    for (int i = 0; i < m + 1; i++)
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          dp[i % 2][j] = 0;
        else if (str1.charAt(i - 1) == str2.charAt(j - 1))
          dp[i % 2][j] = 1 + dp[(i + 1) % 2][j - 1];
        else
          dp[i % 2][j] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j - 1]);
      }
    return dp[m % 2][n];
  }

  public static void main(String[] args) {
    LongestCommonSubsequence ob = new LongestCommonSubsequence();
    System.out.println(ob.longestCommonSubsequence("AXYZ", "BAZ"));
    System.out.println(ob.longestCommonSubsequenceMemoization("AXYZ", "BAZ"));
    System.out.println(ob.longestCommonSubsequenceTabulation("AXYZ", "BAZ"));
  }
}