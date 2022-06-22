package recursion;

import java.util.Scanner;

public class StrSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String -> ");
        String str = sc.next();
        System.out.print("Subsequences of String '" + str +"' are -> ");
        strSubsequence(str, 0, "");
        sc.close();
    }
    // Time Complexity -> O(2^n)
    static void strSubsequence(String str, int i, String newStr) {
        // base case
        if(str.length() == i) {
            System.out.print(newStr + " ");
            return;
        }
        // when current character is included in the string
        strSubsequence(str, i+1, newStr+str.charAt(i));
        // when current character isn't included in the string
        strSubsequence(str, i+1, newStr);
    }
}
