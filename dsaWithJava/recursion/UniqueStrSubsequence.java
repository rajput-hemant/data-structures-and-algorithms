package recursion;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueStrSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String -> ");
        String str = sc.next();
        HashSet<String> set = new HashSet<>();
        System.out.print("Unique Subsequences of String '" + str +"' are -> ");
        strSubsequence(str, 0, "", set);
        sc.close();
    }
    // Time Complexity -> O(2^n)
    static void strSubsequence(String str, int i, String newStr, HashSet<String> set) {
        // base case
        if(str.length() == i) {
            if(set.contains(newStr))
                return;
            else {
                System.out.print(newStr + " ");
                set.add(newStr);
            }
            return;
        }
        // when current character is included in the string
        strSubsequence(str, i+1, newStr+str.charAt(i), set);
        // when current character isn't included in the string
        strSubsequence(str, i+1, newStr, set);
    }
}
