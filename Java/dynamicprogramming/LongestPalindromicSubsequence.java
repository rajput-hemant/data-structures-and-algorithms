package dynamicprogramming;

public class LongestPalindromicSubsequence {
  public int longestPalindromicSubsequence(String str) {
    LongestCommonSubsequence ob = new LongestCommonSubsequence();
    return ob.longestCommonSubsequenceTabulation(str, new StringBuilder(str).reverse().toString());
  }

  public static void main(String[] args) {
    LongestPalindromicSubsequence ob = new LongestPalindromicSubsequence();
    System.out.println(ob.longestPalindromicSubsequence("saippuakivikauppias"));
  }
}
