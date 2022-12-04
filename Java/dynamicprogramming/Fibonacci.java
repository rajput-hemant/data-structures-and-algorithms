package dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

  /**
   * Fibonnaci series using Memoization
   * <p>
   * Time Complexity => O(n)
   * <p>
   * Space Complexity => O(n)
   * 
   * @param n
   * @return the nth fibonacci number
   */
  public int fibonacciMemoization(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return fibMemo(n, memo);
  }

  private int fibMemo(int n, int[] memo) {
    if (memo[n] == -1) {
      if (n == 0 || n == 1)
        return n;
      int res = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
      memo[n] = res;
    }
    return memo[n];
  }

  /**
   * Fibonnaci series using Tabulation
   * <p>
   * Time Complexity => O(n)
   * <p>
   * Space Complexity => O(1)
   * 
   * @param n
   * @return the nth fibonacci number
   */
  public int fibonacciTabulation(int n) {
    if (n == 0 || n == 1)
      return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n];
  }

  public static void main(String[] args) {
    Fibonacci ob = new Fibonacci();
    System.out.println(ob.fibonacciMemoization(5));
    System.out.println(ob.fibonacciTabulation(5));
  }
}
