package dynamicprogramming;

import java.util.Arrays;

public class MinimumCoins {
  /**
   * Time Complexity => O(length of coins array * target)
   * <p>
   * Space Complexity => O(target)
   * 
   * @param coins  Array of coins
   * @param target Target amount
   * @return Minimum coins required to get the target amount
   */
  public int minCoins(int[] coins, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= target; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          int remTarget = 1 + dp[i - coin];
          if (remTarget != Integer.MAX_VALUE)
            dp[i] = Math.min(dp[i], remTarget);
        }
      }
    }
    return dp[target];
  }

  public static void main(String[] args) {
    MinimumCoins ob = new MinimumCoins();
    System.out.println(ob.minCoins(new int[] { 10, 5, 25 }, 30));
  }
}
