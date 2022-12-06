package recursion;

public class CoinChange {
  public int getCount(int[] coins, int amount) {
    return coinsCount(coins, coins.length, amount);
  }

  private int coinsCount(int[] coins, int n, int amount) {
    if (amount == 0)
      return 1;
    if (n == 0)
      return 0;
    int count = coinsCount(coins, n - 1, amount);
    if (coins[n - 1] <= amount)
      count += coinsCount(coins, n, amount - coins[n - 1]);
    return count;
  }

  public static void main(String[] args) {
    CoinChange ob = new CoinChange();
    System.out.println(ob.getCount(new int[] { 2, 3, 5, 6 }, 10));
  }
}
