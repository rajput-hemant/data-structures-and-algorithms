package recursion;

public class _01Knapsack {
  /**
   * Time Complexity => O(2^n)
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
    if (n == 0 || capacity == 0)
      return 0;
    if (weight[n - 1] > capacity)
      return knapsack(capacity, weight, cost, n - 1);
    else
      return Math.max(knapsack(capacity, weight, cost, n - 1),
          cost[n - 1] + knapsack(capacity - weight[n - 1], weight, cost, n - 1));
  }

  public static void main(String[] args) {
    _01Knapsack ob = new _01Knapsack();
    int[] weight = { 5, 4, 6, 3 };
    int[] cost = { 10, 40, 30, 50 };
    System.out.println(ob.knapsack(10, weight, cost));
  }
}
