package dynamicprogramming;

public class CoinChange {

  /**
   * Time Complexity => O(amount * no. of coins)
   * <p>
   * Space Complexity => O(amount * no. of coins)
   * 
   * @param coins  array of coins
   * @param amount targeted amount
   * @return no. of ways to get the targeted amount using the given coins
   */
  public int getCount(int[] coins, int amount) {
    return coinsCount(coins, coins.length, amount);
  }

  private int coinsCount(int[] coins, int n, int amount) {
    int[][] dp = new int[amount + 1][n + 1];

    for (int i = 0; i <= n; i++)
      dp[0][i] = 1;
    for (int i = 0; i <= amount; i++)
      dp[i][0] = 0;

    for (int i = 1; i <= amount; i++)
      for (int j = 1; j <= n; j++) {
        dp[i][j] = dp[i][j - 1];
        if (coins[j - 1] <= i)
          dp[i][j] += dp[i - coins[j - 1]][j];
      }
    return dp[amount][n];
  }

  public static void main(String[] args) {
    CoinChange ob = new CoinChange();
    System.out.println(ob.getCount(new int[] { 2, 3, 5, 6 }, 10));
  }
}
