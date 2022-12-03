package dynamicprogramming;

public class LongestRepeatingSubsequence {
  /**
   * Time Complexity => O(n^2)
   * 
   * @param str String
   * @return the length of Longest Repeating Subsequence of str
   */
  public int longestRepeatingSubsequence(String str) {
    int len = str.length();
    int[][] dp = new int[len + 1][len + 1];
    for (int i = 0; i < len + 1; i++)
      for (int j = 0; j < len + 1; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    return dp[len][len];
  }

  public static void main(String[] args) {
    LongestRepeatingSubsequence ob = new LongestRepeatingSubsequence();
    System.out.println(ob.longestRepeatingSubsequence("rajput-hemant"));
  }
}
