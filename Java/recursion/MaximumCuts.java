package recursion;

public class MaximumCuts {
  /**
   * Time Complexity => O(3^n)
   * 
   * @param n Length of Rod
   * @return Maximum cuts that can be made in rod by making cuts of
   *         length {@code a}, {@code b} and {@code c}
   */
  public int maxCuts(int n, int a, int b, int c) {
    if (n < 0)
      return -1;
    if (n == 0)
      return 0;
    int res = 1 + Math.max(maxCuts(n - a, a, b, c),
        Math.max(maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c)));
    return res;
  }

  public static void main(String[] args) {
    MaximumCuts ob = new MaximumCuts();
    System.out.println(ob.maxCuts(5, 1, 2, 3));
  }
}
