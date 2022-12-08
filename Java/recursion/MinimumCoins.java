package recursion;

public class MinimumCoins {
  public int minCoins(int[] coins, int target) {
    if (target == 0)
      return 0;
    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (coin <= target) {
        int remTarget = 1 + minCoins(coins, target - coin);
        if (remTarget != Integer.MAX_VALUE)
          res = Math.min(res, remTarget);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    MinimumCoins ob = new MinimumCoins();
    System.out.println(ob.minCoins(new int[] { 10, 25, 5 }, 30));
  }
}
