package recursion;

public class LongestCommonSubsequence {

  /**
   * Time Complexity => O(2^n)
   * 
   * @param s1 String
   * @param s2 String
   * @return the length of Longest Common Subsequence of s1 & s2
   */
  public int longestCommonSubsequence(String s1, String s2) {
    return lcs(s1, s2, s1.length(), s2.length());
  }

  private int lcs(String s1, String s2, int m, int n) {
    if (m == 0 || n == 0)
      return 0;
    if (s1.charAt(m - 1) == s2.charAt(n - 1))
      return 1 + lcs(s1, s2, m - 1, n - 1);
    else
      return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
  }

  public static void main(String[] args) {
    LongestCommonSubsequence ob = new LongestCommonSubsequence();
    System.out.println(ob.longestCommonSubsequence("AXYZ", "BAZ"));
  }
}
