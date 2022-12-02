package dynamicprogramming;

public class ShortestCommonSubsequence {
  /**
   * Time Complexity => O(m * n)
   * 
   * @param s1 String
   * @param s2 String
   * @return the length of Shortest Common Subsequence of str1 & str2
   */
  public int shortestCommonSubsequence(String str1, String str2) {
    int m = str1.length(),
        n = str2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++)
      for (int j = 0; j < n + 1; j++) {
        if (i == 0)
          dp[i][j] = j;
        else if (j == 0)
          dp[i][j] = i;
        else if (str1.charAt(i - 1) == str2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    return dp[m][n];
  }

  public static void main(String[] args) {
    ShortestCommonSubsequence ob = new ShortestCommonSubsequence();
    System.out.println(ob.shortestCommonSubsequence("rajput", "hemant"));
  }
}