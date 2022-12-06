package dynamicprogramming;

public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] arr) {
    int[] lis = new int[arr.length];
    lis[0] = 1;
    for (int i = 1; i < lis.length; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j])
          lis[i] = Math.max(lis[i], lis[j] + 1);
      }
    }
    int res = lis[0];
    for (int i : lis)
      res = Math.max(i, res);
    return res;
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
    System.out.println(ob.lengthOfLIS(new int[] { 10, 5, 18, 7, 2, 9 }));
  }
}
