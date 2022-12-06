package recursion;

public class LongestIncreasingSubsequence {

  public int lengthOfLIS(int[] arr) {
    return lis(arr, -1, 0);
  }

  private int lis(int[] arr, int prev, int curr) {
    if (curr == arr.length)
      return 0;
    int take = 0;
    if (prev == -1 || arr[curr] > arr[prev])
      take = 1 + lis(arr, curr, curr + 1);
    int doNotTake = lis(arr, prev, curr + 1);
    return Math.max(take, doNotTake);
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
    System.out.println(ob.lengthOfLIS(new int[] { 1, 4, 2, 4, 7, 6, 8 }));
  }
}