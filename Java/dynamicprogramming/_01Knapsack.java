package dynamicprogramming;

import java.util.Arrays;

public class _01Knapsack {
  /**
   * Time Complexity => O(n * capacity)
   * <p>
   * Space Complexity => O(n * capacity)
   * 
   * @param capacity Capacity of Knapsack
   * @param weight   Array of weights of items
   * @param cost     Array of costs of items
   * @return Maximum of within the capacity of Knapsack
   */
  public int knapsack(int capacity, int[] weight, int[] cost) {
    return knapsack(capacity, weight, cost, weight.length);
  }

  private int knapsack(int capacity, int[] weight, int[] cost, int n) {
    int[][] dp = new int[n + 1][capacity + 1];
    for (int[] row : dp)
      Arrays.fill(row, 0);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= capacity; j++) {
        int weightIndex = i - 1;
        if (weight[weightIndex] > j)
          dp[i][j] = dp[weightIndex][j];
        else
          dp[i][j] = Math.max(dp[weightIndex][j], cost[weightIndex] + dp[weightIndex][j - weight[weightIndex]]);
      }
    }
    return dp[n][capacity];
  }

  public static void main(String[] args) {
    _01Knapsack ob = new _01Knapsack();
    int[] weight = { 5, 4, 6, 3 };
    int[] cost = { 10, 40, 30, 50 };
    System.out.println(ob.knapsack(10, weight, cost));
  }
}
