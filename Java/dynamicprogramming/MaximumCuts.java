package dynamicprogramming;

public class MaximumCuts {
  /**
   * Time Complexity => O(n)
   * <p>
   * Space Complexity => O(n)
   * 
   * @param n Length of Rod
   * @return Maximum cuts that can be made in rod by making cuts of
   *         length {@code a}, {@code b} and {@code c}
   */
  public int maxCuts(int n, int a, int b, int c) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = -1;
      if (i - a >= 0)
        dp[i] = Math.max(dp[i], dp[i - a]);
      if (i - b >= 0)
        dp[i] = Math.max(dp[i], dp[i - b]);
      if (i - c >= 0)
        dp[i] = Math.max(dp[i], dp[i - c]);
      if (dp[i] != -1)
        dp[i]++;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    MaximumCuts ob = new MaximumCuts();
    System.out.println(ob.maxCuts(5, 1, 2, 3));
  }
}
