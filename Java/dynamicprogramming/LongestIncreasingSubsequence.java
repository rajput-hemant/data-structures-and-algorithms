package dynamicprogramming;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
  /**
   * Time Complexity => O(n*nogn)
   * <p>
   * Space Complexity => O(n)
   * 
   * @param arr Array of Integers
   * @return the maximum length of increasing subsequence
   */
  public int lengthOfLISOptimized(int[] arr) {
    ArrayList<Integer> tail = new ArrayList<>();
    tail.add(arr[0]);
    for (int i = 1; i < arr.length; i++)
      if (arr[i] > tail.get(tail.size() - 1))
        tail.add(arr[i]);
      else {
        int ceilIdx = ceilIndex(tail, 0, tail.size() - 1, arr[i]);
        tail.set(ceilIdx, arr[i]);
      }
    return tail.size();
  }

  private int ceilIndex(ArrayList<Integer> tail, int left, int right, int k) {
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (tail.get(mid) >= k)
        right = mid;
      else
        left = mid + 1;
    }
    return right;
  }

  /**
   * Time Complexity => O(n^2)
   * <p>
   * Space Complexity => O(n)
   * 
   * @param arr Array of Integers
   * @return the maximum length of increasing subsequence
   */
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
    System.out.println(ob.lengthOfLISOptimized(new int[] { 10, 5, 18, 7, 2, 9 }));
  }
}
